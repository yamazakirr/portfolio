package com.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.portfolio.util.DBConnector;

public class ChangePasswordCompleteDAO {

//	■フィールド
	private String nowDate;
	private String password;
	private String changePassword;

	private PreparedStatement preparedStatement;
	private Connection connection;

	RegistAccountCompleteDAO dao = new RegistAccountCompleteDAO();

//	■コンストラクタ
	public ChangePasswordCompleteDAO(){
//		■現在時刻の取得
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.nowDate = simpleDateFormat.format(date);
	}

	public String changePasswordInfo(String userId, String userName, String password, String changePassword)throws SQLException{
		String result = "";
		DBConnector dbConnector = new DBConnector();
		connection = dbConnector.getConnection();

		String sql = "UPDATE login_user_transaction"
					+ " SET password=?, update_time=?"
					+ " WHERE user_id=? AND user_name=? AND password=?";

//		■パスワードのハッシュ化
		this.password = dao.passwordHash(password);
		this.changePassword = dao.passwordHash(changePassword);

		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, this.changePassword);
			preparedStatement.setString(2, nowDate);
			preparedStatement.setString(3, userId);
			preparedStatement.setString(4, userName);
			preparedStatement.setString(5, this.password);

			int resultSet = preparedStatement.executeUpdate();
			if(resultSet == 0){
				result = "error";
			}else{
				result = "success";
			}

		}catch(SQLException e){
			result = "networkError";
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
