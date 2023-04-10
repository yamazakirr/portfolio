package com.portfolio.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class DBConnector {

//	private  String driverName = "com.mysql.jdbc.Driver";
//	private  String url = "jdbc:mysql://localhost:8889/portfolio?autoReconnect=true&useSSL=false";
//	private  String user = "root";
//	private  String password = "root";

	private  String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//	private  String url = "jdbc:sqlserver://samplejava.database.windows.net:1433;"
//						+ "database=samplejava;"
//						+ "user=samplejava@samplejava;"
//						+ "password=shinko8sueki@;"
//						+ "encrypt=true;"
//						+ "trustServerCertificate=false;"
//						+ "hostNameInCertificate=*.database.windows.net;"
//						+ "loginTimeout=30;";
//	private  String user = "samplejava@samplejava";
//	private  String password = "shinko8sueki@";

	private Connection connection;
	public static int i = 1;

	public Connection getConnection(){

		try{
			StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
			StringBuilder sb = new StringBuilder();
			sb.append(ste.getMethodName())
			.append("(")
			.append(ste.getFileName())
			.append(":")
			.append(ste.getLineNumber())
			.append(")");

			System.out.println();
			System.out.println("DBConnector "+i+" 回目");
			i++;
			System.out.println("実行クラス :"+sb.toString());

			Class.forName(driverName);
//			System.out.println("Class.forName(driverName);実行済み");
//			connection = (Connection)DriverManager.getConnection(url,user,password);
//			System.out.println("con        :"+connection);

//			■サーバー用
			SQLServerDataSource ds = new SQLServerDataSource();
			ds.setUser("samplejava");
			ds.setPassword("shinko8sueki@");
			ds.setServerName("samplejava.database.windows.net");
			ds.setPortNumber(1433);
			ds.setDatabaseName("samplejava");
			connection = ds.getConnection();

			System.out.println();

		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return connection;
	}

}
