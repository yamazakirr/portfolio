package com.portfolio.action;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.dao.ScheduleGetDAO;
import com.portfolio.dto.ScheduleGetDTO;

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

	private int userId;
	private String userName;

	ArrayList<Object> calendarLists = new ArrayList<Object>();
	LoginAction loginAction = new LoginAction();
	ScheduleGetDAO scheduleGetDAO = new ScheduleGetDAO();
	ArrayList<ScheduleGetDTO> scheduleListDTO = new ArrayList<ScheduleGetDTO>();

	public String execute(){

		year = new Integer(session.get("year").toString());
		month = new Integer(session.get("month").toString());
		date = new Integer(session.get("date").toString());
		userId = new Integer(session.get("userId").toString());
		userName = session.get("userName").toString();

		System.out.println();
		System.out.println("CalendarAction.java");
		System.out.println("year :"+year);
		System.out.println("month :"+month);
		System.out.println("date :"+date);
		System.out.println("userId :"+userId);
		System.out.println("userName :"+userName);



//		■ログイン済み判定
		if(session.containsKey("userId") && session.containsKey("userName")){
//			■yearとmonthの判定
			if(year != 0 && month != 0){

//				■日付変更処理
//				changeCalendarDateがnullの場合は「日付変更処理」は実行しない
				if(changeCalendarDate == null){
					;
				}else{
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
				}

//				dateの指定がない場合は「1」を代入
				if(date == 0){
					date = 1;
				}
				session.put("year", year);
				session.put("month", month);

//				■カレンダー作成処理
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				System.out.println("year :"+ year);
				System.out.println("month :"+ month);
				System.out.println("lastDate :"+ loginAction.getLastDate());

				calendarLists = loginAction.getCalendar(year, month -1);
				session.put("firstDayOfWeek", loginAction.getFirstDayOfWeek());

				System.out.println("sessionのfirstDayOfWeek"+ loginAction.getFirstDayOfWeek());
				System.out.println("CalendarAction.javaの日付"+ sdf.format(loginAction.getSelectDate().getTime()));

//				■選択した日付のスケジュール取得処理


				try{
					scheduleListDTO = scheduleGetDAO.getScheduleList(year, month, date, userId);

				}catch(NullPointerException e){
					System.out.println("値が取得出来ていません。");
					System.out.println("year :"+year);
					System.out.println("month :"+month);
					System.out.println("date :"+date);
					System.out.println("userId :"+userId);
					System.out.println();

					e.printStackTrace();
				}catch(SQLException e){
					e.printStackTrace();
				}

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
