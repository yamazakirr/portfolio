package com.portfolio.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.portfolio.util.DBConnector;

public class RegistAccountCompleteDAO {

	private PreparedStatement preparedStatement;
	private Connection connection;

	private String nowDate;

//	■コンストラクタ
	public RegistAccountCompleteDAO(){
//		■現在時刻の取得
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.nowDate = simpleDateFormat.format(date);
	}

	public String createUser(String userName, String mail, String password) throws SQLException{
		String result = "error";
		DBConnector dbConnector = new DBConnector();
		connection = dbConnector.getConnection();

//		■パスワードのハッシュ化処理
		password = passwordHash(password);

		String sql = "INSERT INTO login_user_transaction(user_name, mail, password, delete_flg, registered_time, update_time)"
				+ " VALUE(?,?,?,?,?,?)";

		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, mail);
			preparedStatement.setString(3, password);
			preparedStatement.setString(4, "0");
			preparedStatement.setString(5, nowDate);
			preparedStatement.setString(6, nowDate);

			preparedStatement.execute();

			result = "success";

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
				return result;
			}
		}
		return result;
	}

//	■パスワードハッシュ化メソッド
	public String passwordHash(String password){
		String str = "";
		try{
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] b = digest.digest(password.getBytes());
			str = new String(b);
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
			System.out.println("ハッシュ化に失敗しました。");
		}

		return str;
	}


}
