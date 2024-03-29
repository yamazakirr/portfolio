package com.portfolio.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.dao.LoginDAO;
import com.portfolio.dao.ScheduleGetDAO;
import com.portfolio.dto.ScheduleGetDTO;


public class LoginAction extends ActionSupport implements SessionAware{

//	■フィールド一覧
	public Map<String, Object> session;
	public int userId;
	private String userName;
	private String mail;
	private String password;
	private String loginErrorMessage = "";

	private Calendar selectDate;
	private Calendar today;
	private int year;
	private int month;
	private int date;
	private int lastDate;
	private int firstDate;
	private int firstDayOfWeek;

	LoginDAO loginDAO = new LoginDAO();
	ArrayList<Object> calendarLists = new ArrayList<Object>();

	ScheduleGetDAO scheduleGetDAO = new ScheduleGetDAO();
	ArrayList<ScheduleGetDTO> scheduleListDTO = new ArrayList<ScheduleGetDTO>();

	public String execute(){
		String result = "";
//		■ログイン処理
		try{
			result = loginDAO.getLoginResult(mail, password);

			if(result.equals("success")){
				this.userId = loginDAO.getUserId();
				this.userName = loginDAO.getUserName();

				session.put("userName", userName);
				session.put("userId", userId);

//				■sessionにyear,monthを格納
				session.put("year", year);
				session.put("month", month);
				session.put("date", date);

//				■カレンダー作成処理
					if(session.get("year").equals(0) && session.get("month").equals(0)){
//						■カレンダー初期表示
						calendarLists = getCalendar();
//						■今日のスケジュール取得処理
						try{
							scheduleListDTO = scheduleGetDAO.getScheduleList(year, month, date, userId);
						}catch(SQLException e){
							e.printStackTrace();
						}
					}else{
//						■日付変更後のカレンダー表示
						calendarLists = getCalendar(year, month);
					}
			}else if(result.equals("error")){
				this.loginErrorMessage = loginDAO.getLoginErrorMessage();
			}
		}catch(SQLException e){
			result = "networkError";
			e.printStackTrace();
		}
		return result;
	}

//	■初期表示のカレンダー作成
	public ArrayList<Object> getCalendar(){
		today = Calendar.getInstance();

		year = today.get(Calendar.YEAR);
		month = today.get(Calendar.MONTH) + 1;
		date = today.get(Calendar.DATE);

		session.put("year", year);
		session.put("month", month);
		session.put("date", date);

		lastDate = today.getActualMaximum(Calendar.DATE);
		firstDate = today.getActualMinimum(Calendar.DATE);

		today.set(Calendar.DATE, firstDate);

		firstDayOfWeek = today.get(Calendar.DAY_OF_WEEK);
		session.put("firstDayOfWeek", firstDayOfWeek);

//		※「sample < 4」は動作確認後「sample < firstDayOfWeek - 1」に変更する ※

		for(int sample=0; sample < firstDayOfWeek - 1; sample++){
			calendarLists.add("");
		}
		for(int sample2=1; sample2 != lastDate+1; sample2++){
			calendarLists.add(sample2);
		}
		return calendarLists;
	}

//	■日付指定がある場合のカレンダー作成
	public ArrayList<Object> getCalendar(int year, int month){
		selectDate = Calendar.getInstance();
		selectDate.set(Calendar.YEAR, year);
		selectDate.set(Calendar.MONTH, month);
		selectDate.set(Calendar.DATE, 1);

		lastDate = selectDate.getActualMaximum(Calendar.DATE);
		firstDate = selectDate.getActualMinimum(Calendar.DATE);
		firstDayOfWeek = selectDate.get(Calendar.DAY_OF_WEEK);

//		※「sample < 4」は動作確認後「sample < firstDayOfWeek - 1」に変更する ※
		for(int sample=0; sample < firstDayOfWeek - 1 ; sample++){
			calendarLists.add("");
		}
		for(int sample2=1; sample2 != lastDate+1; sample2++){
			calendarLists.add(sample2);
		}
		return calendarLists;
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
	public int getLastDate(){
		return lastDate;
	}
	public void setLastDate(int lastDate){
		this.lastDate = lastDate;
	}
	public int getFirstDate(){
		return firstDate;
	}
	public void setFirstDate(int firstDate){
		this.firstDate = firstDate;
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

	public Calendar getSelectDate(){
		return selectDate;
	}
	public void setSelectDate(Calendar selectDate){
		this.selectDate = selectDate;
	}

	public ArrayList<ScheduleGetDTO> getScheduleListDTO(){
		return scheduleListDTO;
	}
	public void setScheduleListDTO(ArrayList<ScheduleGetDTO> scheduleListDTO){
		this.scheduleListDTO = scheduleListDTO;
	}

//	@Override
	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
