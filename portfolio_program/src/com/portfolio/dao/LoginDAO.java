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

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private String sql = "SELECT user_id,user_name, mail, password"
						+ " FROM login_user_transaction"
						+ " WHERE mail=? AND password=? AND delete_flg=?";

	RegistAccountCompleteDAO registAccountCompleteDAO = new RegistAccountCompleteDAO();

	public String getLoginResult(String mail, String password)throws SQLException{
		String result = "";

//		■パスワードのハッシュ化
		password = registAccountCompleteDAO.passwordHash(password);


		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, mail);
		preparedStatement.setString(2, password);
		preparedStatement.setString(3, "0");

		ResultSet resultSet = preparedStatement.executeQuery();

//		■ログイン可否判定
		if(resultSet.next()){
			result = "success";
			this.userId = resultSet.getInt("user_id");
			this.userName = resultSet.getString("user_name");
		}else{
			this.loginErrorMessage = "メールアドレスまたはパスワードが違います。";
			result = "error";
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
