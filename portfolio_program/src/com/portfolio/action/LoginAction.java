package com.portfolio.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.dao.LoginDAO;

public class LoginAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private String userId;
	private String userName;
	private String mail;
	private String password;
	private String loginErrorMessage = "";

	LoginDAO loginDAO = new LoginDAO();

	public String execute(){
		String result = "";

		System.out.println("mail "+ mail);
		System.out.println("password "+password);

		try{
			result = loginDAO.getLoginResult(mail, password);

			if(result.equals("success")){
				this.userId = loginDAO.getUserId();
				this.userName = loginDAO.getUserName();

				System.out.println("result "+ result);
				System.out.println("userId "+ userId);
				System.out.println("userName "+ userName);
				System.out.println("mail "+ mail);
				System.out.println("password "+ password);

				session.put("userName", userName);
				session.put("userId", userId);
			}else if(result.equals("error")){
				System.out.println("result "+ result);
				this.loginErrorMessage = loginDAO.getLoginErrorMessage();
			}

		}catch(SQLException e){
			result = "networkError";
			e.printStackTrace();
		}

		return result;
	}

//■getterとsetter
	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId = userId;
	}
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
	public String getLoginErrorMessage(){
		return loginErrorMessage;
	}
	public void setLoginErrorMessage(String loginErrorMessage){
		this.loginErrorMessage = loginErrorMessage;
	}

//	@Override
	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
