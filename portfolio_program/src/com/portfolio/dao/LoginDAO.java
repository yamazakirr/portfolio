package com.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.portfolio.util.DBConnector;

public class LoginDAO {

	private String loginErrorMessage = "";
	private int userId ;
	private String userName = "";

	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	private Connection connection;

	private String sql = "SELECT user_id,user_name, mail, password"
						+ " FROM login_user_transaction"
						+ " WHERE mail=? AND password=? AND delete_flg=?";

	RegistAccountCompleteDAO registAccountCompleteDAO = new RegistAccountCompleteDAO();

	public String getLoginResult(String mail, String password)throws SQLException{
		String result = "";
		DBConnector dbConnector = new DBConnector();
		connection = dbConnector.getConnection();

//		■パスワードのハッシュ化
		password = registAccountCompleteDAO.passwordHash(password);


		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, mail);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, "0");

			resultSet = preparedStatement.executeQuery();

//			■ログイン可否判定
			if(resultSet.next()){
				result = "success";
				this.userId = resultSet.getInt("user_id");
				this.userName = resultSet.getString("user_name");
			}else{
				this.loginErrorMessage = "メールアドレスまたはパスワードが違います。";
				result = "error";
			}
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
				System.out.println("LoginDAO.javaにてconnectionがNull");
				result = "networkError";
				return result;
			}
		}
		return result;
	}

//	■getterとsetter
	public int getUserId(){
		return userId;
	}
	public void setUserId(int userId){
		this.userId = userId;
	}
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getLoginErrorMessage(){
		return loginErrorMessage;
	}
	public void setLoginErrorMessage(String loginErrorMessage){
		this.loginErrorMessage = loginErrorMessage;
	}

}
