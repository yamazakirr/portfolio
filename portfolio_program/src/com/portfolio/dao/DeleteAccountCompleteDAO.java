package com.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.portfolio.util.DBConnector;

public class DeleteAccountCompleteDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public String deleteUserInfo(String userId, String userName)throws SQLException{

		String result = "";

		String sql = "UPDATE login_user_transaction "
					+ " SET delete_flg = 1"
					+ " WHERE user_id=? AND user_name=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, userName);

			int res = preparedStatement.executeUpdate();

			if(res == 0){
				result = "error";
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
			}
		}
		return result;
	}

}
