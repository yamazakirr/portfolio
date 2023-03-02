package com.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.portfolio.util.DBConnector;

public class DeleteAccountCompleteDAO {

//	■フィールド
	private String nowDate;
	private PreparedStatement preparedStatement;
	private Connection connection;

//	■コンストラクタ
	public DeleteAccountCompleteDAO(){
//		■現在時刻の取得
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.nowDate = simpleDateFormat.format(date);
	}

	public String deleteUserInfo(String userId, String userName)throws SQLException{
		String result = "";
		DBConnector dbConnector = new DBConnector();
		connection = dbConnector.getConnection();

		String sql = "UPDATE login_user_transaction "
					+ " SET delete_flg = 1, update_time = ?"
					+ " WHERE user_id=? AND user_name=?";

		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, nowDate);
			preparedStatement.setString(2, userId);
			preparedStatement.setString(3, userName);

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
