package com.portfolio.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.dao.ScheduleGetDAO;
import com.portfolio.dto.ScheduleGetDTO;

public class ScheduleGetAction extends ActionSupport{

	public Map<String, Object> session;
	private String result;
	private int year;
	private int month;
	private int date;


	ScheduleGetDAO scheduleGetDAO = new ScheduleGetDAO();
	private ArrayList<ScheduleGetDTO> scheduleList = new ArrayList<ScheduleGetDTO>();

	public String execute(){





		result = "success";
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


//	@Override
	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
