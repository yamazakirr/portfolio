package com.portfolio.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.dao.LoginDAO;


public class LoginAction extends ActionSupport implements SessionAware{

//	■フィールド一覧
	public Map<String, Object> session;
	public String userId;
	private String userName;
	private String mail;
	private String password;
	private String loginErrorMessage = "";

	private Calendar selectDate;
	private int lastDate;
	private int firstDate;
	private int firstDayOfWeek;


	private Calendar today;

	private int year;
	private int month;
	private int date;
	private int dayOfWeek;
	private int startDate;




	LoginDAO loginDAO = new LoginDAO();

	ArrayList<Object> calendarLists = new ArrayList<Object>();



//	■コンストラクタ
	public LoginAction(){
		this.today = Calendar.getInstance();
		Calendar firstDay = Calendar.getInstance();

//		月初の曜日取得
		firstDay.set(Calendar.DATE, 1);
		this.firstDate = firstDay.get(Calendar.DAY_OF_WEEK);
		System.out.println("firstDate : 月初の曜日 :"+firstDate);

		System.out.println("今日の曜日 :"+today.get(Calendar.DAY_OF_WEEK));

		this.year = today.get(Calendar.YEAR);
		this.month = today.get(Calendar.MONTH)+1;
		this.date = today.get(Calendar.DATE);
		this.dayOfWeek = today.get(Calendar.DAY_OF_WEEK);
		this.lastDate = today.getActualMaximum(Calendar.DATE);
		this.startDate = today.getActualMinimum(Calendar.DATE);


//		月初の曜日取得
		int firstDayOfWeek = firstDay.get(Calendar.DAY_OF_WEEK);
		System.out.println("firstDayOfWeek :"+firstDayOfWeek);
	}

	public String execute(){
		String result = "";

		if(year == 0 && month ==0){

		}else{
			calendarLists = getCalendar(year, month);
		}

//	■修正版======================

//	■カレンダーの作成
	for(int sample=0; sample < 4; sample++){
		calendarLists.add("");
	}
	for(int sample2=1; sample2 != lastDate+1; sample2++){
		calendarLists.add(sample2);
	}
//==============================

		try{
			result = loginDAO.getLoginResult(mail, password);

			if(result.equals("success")){
				this.userId = loginDAO.getUserId();
				this.userName = loginDAO.getUserName();

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

	public ArrayList<Object> getCalendar(int year, int month){
		selectDate = Calendar.getInstance();
		selectDate.set(Calendar.YEAR, year);
		selectDate.set(Calendar.MONTH, month);

		lastDate = selectDate.getActualMaximum(Calendar.DATE);
		firstDate = selectDate.getActualMinimum(Calendar.DATE);
		firstDayOfWeek = selectDate.get(Calendar.DAY_OF_WEEK);

//		※「sample < 4」は動作確認後「sample < firstDayOfWeek - 1」に変更する ※
		for(int sample=0; sample < 4; sample++){
			calendarLists.add("");
		}
		for(int sample2=1; sample2 != lastDate+1; sample2++){
			calendarLists.add(sample2);
		}
		return calendarLists;
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
	public int getDayOfWeek(){
		return dayOfWeek;
	}
	public void setDayOfWeek(int dayOfWeek){
		this.dayOfWeek = dayOfWeek;
	}
	public int getLastDate(){
		return lastDate;
	}
	public void setLastDate(int lastDate){
		this.lastDate = lastDate;
	}
	public int getStartDate(){
		return startDate;
	}
	public void setStartDate(int startDate){
		this.startDate = startDate;
	}
	public int getFirstDayOfWeek(){
		return firstDayOfWeek;
	}
	public void setFirstDayOfWeek(int firstDayOfWeek){
		this.firstDayOfWeek = firstDayOfWeek;
	}
	public ArrayList<Object> getCalendarLists(){
		return calendarLists;
	}
	public void setCalendarLists(ArrayList<Object> calendarLists){
		this.calendarLists = calendarLists;
	}





//	@Override
	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
