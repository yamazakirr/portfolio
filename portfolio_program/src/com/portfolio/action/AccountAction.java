package com.portfolio.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.dao.AccountDAO;

public class AccountAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private String userId;
	private String userName;
	private String mail;

	AccountDAO dao = new AccountDAO();

	public String execute(){

		System.out.println("userId :"+userId);
		System.out.println("userName :"+userName);


		String result = "";

//		■ログイン済み判定
		if(session.containsKey("userName") && session.containsKey("userId")){
			userId = session.get("userId").toString();
			userName = session.get("userName").toString();

			System.out.println("userId :"+userId);
			System.out.println("userName :"+userName);

			try{
				result = dao.getUserInfo(userId, userName);
				userName = dao.getUserName();
				mail = dao.getMail();

			}catch(SQLException e){
				e.printStackTrace();
			}

			result = SUCCESS;
		}else{
			result = "accountError";
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


//	@Override
	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
