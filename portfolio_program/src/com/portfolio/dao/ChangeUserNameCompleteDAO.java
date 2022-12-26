package com.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.portfolio.util.DBConnector;


public class ChangeUserNameCompleteDAO {

	//	■フィールド
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private String nowDate;
	private String password;

	RegistAccountCompleteDAO dao = new RegistAccountCompleteDAO();

//	■コンストラクタ
	public ChangeUserNameCompleteDAO(){
//		■現在時刻の取得
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.nowDate = simpleDateFormat.format(date);
	}

	public String changeUserNameInfo(String userId, String userName,String password, String changeUserName)throws SQLException{

		String result = "";
		String sql = "UPDATE login_user_transaction"
					+ " SET user_name =?, update_time=?"
					+ " WHERE user_id=? AND user_name=? AND password=?";

//		■パスワードのハッシュ化
		this.password = dao.passwordHash(password);

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, changeUserName);
			preparedStatement.setString(2, nowDate);
			preparedStatement.setString(3, userId);
			preparedStatement.setString(4, userName);
			preparedStatement.setString(5, this.password);

			int resultSet = preparedStatement.executeUpdate();
			if(resultSet == 0){
//				■処理対象が見つからない場合は「パスワードの入力ミス」と判定
				result = "error";
			}else{
				result = "success";
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
