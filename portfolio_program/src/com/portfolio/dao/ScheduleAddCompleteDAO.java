package com.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.portfolio.util.DBConnector;

public class ScheduleAddCompleteDAO {

	private String result;

	private PreparedStatement preparedStatement;
	private Connection connection;

	public String scheduleAdd(int userId, String schedule, String memo, String startDate, String endDate,
								int allDayFlg, String startTime, String endTime)throws SQLException{

		DBConnector dbConnector = new DBConnector();
		connection = dbConnector.getConnection();

		String sql = "INSERT INTO my_calendar(user_id, schedule, memo, start_date, end_date, all_day_flg, start_time, end_time, calendar_delete_flg)"
					+ " VALUE(?,?,?,?,?,?,?,?,?)";

		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, schedule);
			preparedStatement.setString(3, memo);
			preparedStatement.setString(4, startDate);
			preparedStatement.setString(5, endDate);
			preparedStatement.setInt(6, allDayFlg);
			preparedStatement.setString(7, startTime);
			preparedStatement.setString(8, endTime);
			preparedStatement.setInt(9, 0);

			preparedStatement.execute();

			result = "success";

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(connection != null){
				if(preparedStatement != null){
					preparedStatement.close();
				}else{
					;
				}
				connection.close();
			}else if(connection == null){
				result = "networkError";
				return result;
			}
		}


		return result;
	}

}
