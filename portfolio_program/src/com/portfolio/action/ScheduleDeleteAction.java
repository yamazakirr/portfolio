package com.portfolio.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ScheduleDeleteAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private String result;

	private int id;
	private int year;
	private int month;
	private int date;

	private int userId;
	private String userName;


	public String execute(){
		result = "error";

//		■ログイン済み判定
		if(session.containsKey("userId") && session.containsKey("userName")){
			result = "success";
		}

		return result;
	}

//	■getterとsetter
	public int getUserId(){
		return userId;
	}
	public void setUserId(int userId){
		this.userId = userId;
	}
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}

	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getYear(){
		return year;
	}
	public void setYear(int year){
		this.year = year;
	}
	public int getMonth(){
		return month;
	}
	public void setMonth(int month){
		this.month = month;
	}
	public int getDate(){
		return date;
	}
	public void setDate(int date){
		this.date = date;
	}

//	@Override
	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
