package com.portfolio.action;

import java.sql.SQLException;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.dao.LoginDAO;

public class LoginAction extends ActionSupport{

	public Map<String, Object> session;
	public String mail;
	public String password;

	LoginDAO logindao = new LoginDAO();

	public String execute(){
		String result = "error";

		System.out.println("mail "+ mail);
		System.out.println("password "+password);

		try{
			result = logindao.getLoginResult(mail, password);

		}catch(SQLException e){
			e.printStackTrace();
		}




		return result;
	}

//■getterとsetter
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

//	@Override
	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
