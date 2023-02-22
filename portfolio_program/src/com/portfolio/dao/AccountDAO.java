package com.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.portfolio.util.DBConnector;

public class AccountDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private String userName;
	private String mail;


	public String getUserInfo(String userId, String userName)throws SQLException{
		String result = "";

		String sql = "SELECT user_name, mail"
				   + " FROM login_user_transaction"
				   + " WHERE user_id=? AND user_name=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, userName);

			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				result = "success";
				this.userName = resultSet.getString("user_name");
				this.mail = resultSet.getString("mail");

			}else{
				result = "networkError";
			}
		}catch(SQLException e){
			result = "networkError";
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

//	■getterとsetter
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	public String getMail(){
		return mail;
	}
	public void setMail(String mail){
		this.mail = mail;
	}

}
