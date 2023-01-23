package com.portfolio.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ScheduleAddAction extends ActionSupport implements SessionAware{

	private String result;

	public Map<String, Object> session;
	private int userId;
	private String userName;

	private int year;
	private int month;
	private int date;

	public String execute(){

//		■ログイン済み認証
		if(session.containsKey("userId") && session.containsKey("userName")){

//			■日付が取得可否判定
			if(year != 0 && month != 0 && date != 0){
				result = "success";
			}else{
				System.out.println("日付情報が取得出来ていません");
				result = "networkError";
			}

		}else{
			System.out.println("ログインしていません。");
			result = "accountError";
		}
		return result;
	}


//	■getterとsetter
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

//	Override
	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
