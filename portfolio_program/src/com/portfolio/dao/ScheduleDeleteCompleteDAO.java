package com.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.portfolio.util.DBConnector;

public class ScheduleDeleteCompleteDAO {

//	■フィールド
	private String result;

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public String scheduleDeleteInfo(int id, int userId)throws SQLException{

		String sql ="UPDATE my_calendar"
					+ " SET calendar_delete_flg = 1"
					+ " WHERE id = ? AND user_id = ?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, userId);

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



		result = "success";
		return result;
	}

}
