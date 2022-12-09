package com.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.portfolio.util.DBConnector;

public class RegistAccountConfirmDAO {
	String result = "error";

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public String checkMailDatebase(String mail) throws SQLException{


		String sql = "SELECT mail"
				+ " FROM login_user_transaction"
				+ " WHERE mail=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, mail);
			ResultSet resutlSet = preparedStatement.executeQuery();

			if(resutlSet.next()){
//				tureなら同じメールアドレスが登録済み
				return result;
			}else{
//				falseならメールアドレスは未登録
				result = "success";
				return result;
			}
		}catch(Exception e){
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
