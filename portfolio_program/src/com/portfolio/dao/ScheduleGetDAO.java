package com.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.portfolio.dto.ScheduleGetDTO;
import com.portfolio.util.DBConnector;

public class ScheduleGetDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	private Calendar selectCalendar;
	private Date selectDate;
	private ResultSet resultSet;

	private String dateFormat = "yyyy-MM-dd";


	ArrayList<ScheduleGetDTO> scheduleListDTO = new ArrayList<ScheduleGetDTO>();

	public ArrayList<ScheduleGetDTO> getScheduleList(int year, int month, int date, int userId)throws SQLException{

		selectCalendar = Calendar.getInstance();
		selectDate = new Date();
		selectCalendar.set(Calendar.YEAR, year);
		selectCalendar.set(Calendar.MONTH, month -1);
		selectCalendar.set(Calendar.DATE, date);


//		selectDateのフォーマットを変更する
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		selectDate = selectCalendar.getTime();
		System.out.println(sdf.format(selectDate));



		String dateString = sdf.format(selectDate);

		System.out.println("a     :"+dateString);
		try{
			selectDate = sdf.parse(dateString);
		}catch(Exception e){
			System.out.println("String型からDate型");
			e.printStackTrace();
		}


		System.out.println("selectDate :"+selectDate);


		String sql = "SELECT id, user_id, schedule, memo, start_date, end_date, "
					+ "all_day_flg, start_time, end_time, calendar_delete_flg"
					+ " FROM my_calendar"
					+ " WHERE user_id =? AND calendar_delete_flg=0 "
					+ " ORDER BY start_time ASC";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);

			resultSet = preparedStatement.executeQuery();

//			■データベースから取得した情報をscheduleListDTOに格納
			while(resultSet.next()){

//				■日付が該当するか判定
				Date startDate = resultSet.getDate("start_date");
				Date endDate = resultSet.getDate("end_date");

				System.out.println("startDate :"+ startDate);
				System.out.println("endDate :"+ endDate);
				System.out.println("selectDate :" + selectDate);
				System.out.println();

//				Listに格納する条件：start_date <= selectDate <= end_date
				if((selectDate.compareTo(startDate) != -1) && (selectDate.compareTo(endDate) != 1)){

					System.out.println("データ格納処理");

					ScheduleGetDTO dto = new ScheduleGetDTO();
					dto.setId(resultSet.getInt("id"));
					dto.setUserId(resultSet.getInt("user_id"));
					dto.setSchedule(resultSet.getString("schedule"));
					dto.setMemo(resultSet.getString("memo"));
					dto.setAllDayFlg(resultSet.getInt("all_day_flg"));

					System.out.println("①");
					dto.setStartDate(LocalDate.parse(resultSet.getString("start_date"), DateTimeFormatter.ofPattern(dateFormat)));
					System.out.println("②");
					dto.setEndDate(LocalDate.parse(resultSet.getString("end_date"), DateTimeFormatter.ofPattern(dateFormat)));
					System.out.println("③");

					System.out.println("値を確認");
					System.out.println("startDate :"+dto.getStartDate());
					System.out.println("endDate :"+dto.getEndDate());
					System.out.println("startDate :"+resultSet.getString("start_date"));
					System.out.println("endDate :"+resultSet.getString("end_date"));

					dto.setStartTime(LocalTime.parse(resultSet.getString("start_time")));
					dto.setEndTime(LocalTime.parse(resultSet.getString("end_time")));

					dto.setYear(year);
					dto.setMonth(month);
					dto.setDate(date);

//					String timeFormat = "HH:mm";
//					dto.setStartTime(LocalTime.parse(resultSet.getString("start_time"), DateTimeFormatter.ofPattern(timeFormat)));
					System.out.println("④");
//					dto.setEndTime(LocalTime.parse(resultSet.getString("end_time"), DateTimeFormatter.ofPattern(timeFormat)));


					System.out.println("開始日 :"+ dto.getStartDate());
					System.out.println("終了日 :"+ dto.getEndDate());
					System.out.println("開始時刻 :"+ dto.getStartTime());
					System.out.println("終了時刻 :"+ dto.getEndTime());


					scheduleListDTO.add(dto);
				}


			}

		}catch(Exception e){
			e.printStackTrace();
		}

		return scheduleListDTO;
	}


}
