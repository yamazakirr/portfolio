package com.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	ArrayList<ScheduleGetDTO> scheduleListDTO = new ArrayList<ScheduleGetDTO>();

	public ArrayList<ScheduleGetDTO> getScheduleList(int year, int month, int date, int userId)throws SQLException{

		selectCalendar = Calendar.getInstance();
		selectCalendar.set(Calendar.YEAR, year);
		selectCalendar.set(Calendar.MONTH, month -1);
		selectCalendar.set(Calendar.DATE, date);
		selectDate = selectCalendar.getTime();

		System.out.println("selectDate :"+selectDate);


		String sql = "SELECT id, user_id, schedule, memo, start_date, end_date, "
					+ "all_day_flg, start_time, end_time, calendar_delete_flg"
					+ " FROM my_calendar"
					+ " WHERE user_id =? AND calendar_delete_flg=0 "
					+ " ORDER BY start_time DESC";

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

//				Listに格納する条件：start_date <= selectDate <= end_date
				if((selectDate.compareTo(startDate) != -1) && (selectDate.compareTo(endDate) != 1)){
					ScheduleGetDTO dto = new ScheduleGetDTO();
					dto.setId(resultSet.getInt("id"));
					dto.setUserId(resultSet.getInt("user_if"));
					dto.setSchedule(resultSet.getString("schedule"));
					dto.setMemo(resultSet.getString("memo"));
					dto.setStartDate(resultSet.getDate("start_date"));
					dto.setEndDate(resultSet.getDate("end_date"));
					dto.setAllDayFlg(resultSet.getInt("all_day_flg"));
					dto.setStartTime(resultSet.getTime("start_time"));
					dto.setEndTime(resultSet.getTime("end_time"));


					scheduleListDTO.add(dto);
				}


			}

		}catch(Exception e){
			e.printStackTrace();
		}

		return scheduleListDTO;
	}


}
