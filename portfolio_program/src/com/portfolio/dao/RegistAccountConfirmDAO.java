package com.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.portfolio.util.DBConnector;

public class RegistAccountConfirmDAO {
	String result = "error";

	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	private Connection connection;

	public String checkMailDatebase(String mail) throws SQLException{

		DBConnector dbConnector = new DBConnector();
		connection = dbConnector.getConnection();

		String sql = "SELECT mail"
				+ " FROM login_user_transaction"
				+ " WHERE mail=? AND delete_flg=?";

		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, mail);
			preparedStatement.setString(2, "0");
			ResultSet resutlSet = preparedStatement.executeQuery();

			if(resutlSet.next()){
//				tureなら同じメールアドレスが登録済み
				return result;
			}else{
//				それ以外ならメールアドレスは未登録
				result = "success";
				return result;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(connection != null){
				if(resultSet != null){
					resultSet.close();
				}else{
					;
				}
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
