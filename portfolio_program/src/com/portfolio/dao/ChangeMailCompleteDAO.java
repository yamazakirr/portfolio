package com.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.portfolio.util.DBConnector;

public class ChangeMailCompleteDAO {

//	■フィールド
	private String nowDate;
	private String password;

	private int resultSet;
	private PreparedStatement preparedStatement;
	private Connection connection;

	RegistAccountCompleteDAO dao = new RegistAccountCompleteDAO();

//	■コンストラクタ
	public ChangeMailCompleteDAO(){
//		■現在時刻の取得
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.nowDate = simpleDateFormat.format(date);
	}

	public String changeMailInfo(String userId, String userName, String changeMail, String password)throws SQLException{
		String result = "";
		DBConnector dbConnector = new DBConnector();
		connection = dbConnector.getConnection();

		String sql = "UPDATE login_user_transaction"
					+ " SET mail=?, update_time=?"
					+ " WHERE user_id=? AND user_name=? AND password=?";

//		■パスワードのハッシュ化
		this.password = dao.passwordHash(password);

		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, changeMail);
			preparedStatement.setString(2, nowDate);
			preparedStatement.setString(3, userId);
			preparedStatement.setString(4, userName);
			preparedStatement.setString(5, this.password);

			resultSet = preparedStatement.executeUpdate();
			if(resultSet == 0){
				result = "error";
			}else{
				result = "success";
			}

		}catch(Exception e){
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
			}
		}

		return result;
	}
}
