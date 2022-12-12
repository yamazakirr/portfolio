package com.portfolio.action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.dao.RegistAccountCompleteDAO;

public class RegistAccountCompleteAction extends ActionSupport{

//■フィールド一覧
	private String userName;
	private String mail;
	private String password;


	public String execute(){
		String result = "error";

		RegistAccountCompleteDAO registAccountCompleteDAO = new RegistAccountCompleteDAO();

		try{
			result = registAccountCompleteDAO.createUser(userName, mail, password);
		}catch(SQLException e){
			e.printStackTrace();
			return result;
		}

		return result;
	}


//■getterとsetter
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	public String getMail(){
		return mail;
	}
	public void setMail(String mail){
		this.mail = mail;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}

}
