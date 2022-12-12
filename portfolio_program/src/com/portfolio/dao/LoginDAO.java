package com.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.portfolio.util.DBConnector;

public class LoginDAO {

	private String loginErrorMessage = "";
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private String sql = "SELECT mail, password"
						+ " FROM login_user_transaction"
						+ " WHERE mail=? AND password=?";

	public String getLoginResult(String mail, String password)throws SQLException{
		String result = "error";



		return result;
	}

}
