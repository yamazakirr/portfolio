package com.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.portfolio.util.DBConnector;

public class ScheduleEditCompleteDAO {

//	■フィールド
	private String result;

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public String scheduleEdit(int userId, int id, String schedule, String memo, String startDate, String endDate,
								int allDayFlg, String startTime, String endTime)throws SQLException{

		String sql = "UPDATE my_calendar"
					+ " SET schedule=?, memo=?, start_date=?, end_date=?, all_day_flg=?, start_time=?, end_time=?"
					+ " WHERE user_id=? AND id=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, schedule);
			preparedStatement.setString(2, memo);
			preparedStatement.setString(3, startDate);
			preparedStatement.setString(4, endDate);
			preparedStatement.setInt(5, allDayFlg);
			preparedStatement.setString(6, startTime);
			preparedStatement.setString(7, endTime);
			preparedStatement.setInt(8, userId);
			preparedStatement.setInt(9, id);

			int res = preparedStatement.executeUpdate();

			if(res == 0){
				result = "networkError";
			}else{
				result = "success";
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(connection != null){
				connection.close();
			}else if(connection == null){
				result = "networkError";
				return result;
			}
		}
		return result;
	}

}
