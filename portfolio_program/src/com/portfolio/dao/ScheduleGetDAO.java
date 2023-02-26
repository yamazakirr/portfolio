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

		String dateString = sdf.format(selectDate);

		try{
			selectDate = sdf.parse(dateString);
		}catch(Exception e){
			System.out.println("String型からDate型");
			e.printStackTrace();
		}

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

//				Listに格納する条件：start_date <= selectDate <= end_date
				if((selectDate.compareTo(startDate) != -1) && (selectDate.compareTo(endDate) != 1)){

					ScheduleGetDTO dto = new ScheduleGetDTO();
					dto.setId(resultSet.getInt("id"));
					dto.setUserId(resultSet.getInt("user_id"));
					dto.setSchedule(resultSet.getString("schedule"));
					dto.setMemo(resultSet.getString("memo"));
					dto.setAllDayFlg(resultSet.getInt("all_day_flg"));

					dto.setStartDate(LocalDate.parse(resultSet.getString("start_date"), DateTimeFormatter.ofPattern(dateFormat)));
					dto.setEndDate(LocalDate.parse(resultSet.getString("end_date"), DateTimeFormatter.ofPattern(dateFormat)));

//					startDate,endDateをそれぞれ年、月、日に分けて格納
					dto.setStartYear(dto.getStartDate().getYear());
					dto.setStartMonth(dto.getStartDate().getMonthValue());
					dto.setStartDay(dto.getStartDate().getDayOfMonth());

					dto.setEndYear(dto.getEndDate().getYear());
					dto.setEndMonth(dto.getEndDate().getMonthValue());
					dto.setEndDay(dto.getEndDate().getDayOfMonth());

					dto.setStartTime(LocalTime.parse(resultSet.getString("start_time")));
					dto.setEndTime(LocalTime.parse(resultSet.getString("end_time")));

					dto.setYear(year);
					dto.setMonth(month);
					dto.setDate(date);

					scheduleListDTO.add(dto);
				}
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(connection != null){
				connection.close();
				System.out.println("connection.close()実行済み");
			}else if(connection == null){
				System.out.println("ScheduleGetDAO.javaにてconnectionがNull");
				scheduleListDTO = null;
				return scheduleListDTO;
			}
		}

		return scheduleListDTO;
	}


}
