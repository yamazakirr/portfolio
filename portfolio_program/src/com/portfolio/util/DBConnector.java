package com.portfolio.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	private  String driverName = "com.mysql.jdbc.Driver";
	private  String url = "jdbc:mysql://localhost:8889/portfolio?autoReconnect=true&useSSL=false";
	private  String user = "root";
	private  String password = "root";

	private static int i = 1;

	public Connection getConnection(){
		Connection con = null;

		try{
			System.out.println();
			System.out.println("DBConnector "+i+" 回目");
			i++;
			System.out.println("driverName :"+driverName);
			System.out.println("url        :"+url);
			System.out.println("user       :"+user);
			System.out.println("password   :"+password);

			Class.forName(driverName);
			System.out.println("Class.forName(driverName);実行済み");
			con = (Connection)DriverManager.getConnection(url,user,password);
			System.out.println("con        :"+con);


		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}

}
