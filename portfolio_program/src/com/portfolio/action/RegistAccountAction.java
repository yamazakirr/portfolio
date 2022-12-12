package com.portfolio.action;

import com.opensymphony.xwork2.ActionSupport;

public class RegistAccountAction extends ActionSupport{

//■フィールド一覧
	private String userName;
	private String mail;
	private String password;

	public String execute(){
		return SUCCESS;
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
