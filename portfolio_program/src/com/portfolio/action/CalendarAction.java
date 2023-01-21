package com.portfolio.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CalendarAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private String result;
	private String changeCalendarDate;
	private int year;
	private int month;
	private int date;
	private int lastDate;
	private int firstDate;
	private int firstDayOfWeek;

	ArrayList<Object> calendarLists = new ArrayList<Object>();
	LoginAction loginAction = new LoginAction();

	public String execute(){


//		■ログイン済み判定
		if(session.containsKey("userId") && session.containsKey("userName")){
//			■yearとmonthの判定
			if(year != 0 && month != 0){

//				■日付変更処理
				if(changeCalendarDate.equals("lastYear")){
					this.year = year - 1;
				}else if(changeCalendarDate.equals("nextYear")){
					this.year = year + 1;
				}else if(changeCalendarDate.equals("lastMonth")){
					if(month == 1){
						month = 12;
					}else{
						this.month = month - 1;
					}
				}else if(changeCalendarDate.equals("nextMonth")){
					if(month == 12){
						month = 1;
					}else{
						this.month = month + 1;
					}
				}

//				dateの指定がない場合は「1」を代入
				if(date == 0){
					date = 1;
				}
				session.put("year", year);
				session.put("month", month);


				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				System.out.println("year :"+ year);
				System.out.println("month :"+ month);
				System.out.println("lastDate :"+ loginAction.getLastDate());

				calendarLists = loginAction.getCalendar(year, month -1);
				session.put("firstDayOfWeek", loginAction.getFirstDayOfWeek());
				session.put("date", loginAction.getDate());

				System.out.println("sessionのfirstDayOfWeek"+ loginAction.getFirstDayOfWeek());
				System.out.println("CalendarAction.javaの日付"+ sdf.format(loginAction.getSelectDate().getTime()));

				result = "success";
			}else{
				result = "networkError";
			}
		}else{
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
	public String getChangeCalendarDate(){
		return changeCalendarDate;
	}
	public void setChangeCalendarDate(String changeCalendarDate){
		this.changeCalendarDate = changeCalendarDate;
	}


//	@Override
	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
