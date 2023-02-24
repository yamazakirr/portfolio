package com.portfolio.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.dao.ScheduleGetDAO;
import com.portfolio.dto.ScheduleGetDTO;

public class ScheduleGetAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private String result;
	private int year;
	private int month;
	private int date;
	private int userId;

	ScheduleGetDAO scheduleGetDAO = new ScheduleGetDAO();
	LoginAction loginAction = new LoginAction();
	ArrayList<ScheduleGetDTO> scheduleListDTO = new ArrayList<ScheduleGetDTO>();
	ArrayList<Object> calendarLists = new ArrayList<Object>();

	public String execute(){
		result = "error";

//		■sessionに選択中の日付を格納
		session.put("year", year);
		session.put("month", month);
		session.put("date", date);

		try{
			scheduleListDTO = scheduleGetDAO.getScheduleList(year, month, date, userId);
			calendarLists = loginAction.getCalendar(year, month -1);

			session.put("firstDayOfWeek", loginAction.getFirstDayOfWeek());

//			System.out.println("firstDayOfWeek :"+loginAction.getFirstDayOfWeek());
			result = "success";
		}catch(Exception e){
			e.printStackTrace();
		}

		System.out.println("result :"+result);
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

	public ArrayList<ScheduleGetDTO> getScheduleListDTO(){
		return scheduleListDTO;
	}
	public void setScheduleListDTO(ArrayList<ScheduleGetDTO> scheduleListDTO){
		this.scheduleListDTO = scheduleListDTO;
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
