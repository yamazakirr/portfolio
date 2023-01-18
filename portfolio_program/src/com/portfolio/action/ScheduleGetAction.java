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
	private int userId;


	ScheduleGetDAO scheduleGetDAO = new ScheduleGetDAO();
	private ArrayList<ScheduleGetDTO> scheduleListDTO = new ArrayList<ScheduleGetDTO>();

	public String execute(){

		System.out.println("year :"+year);
		System.out.println("month :"+month);
		System.out.println("date :"+date);
		System.out.println("userId :" +userId);

		try{
			scheduleListDTO = scheduleGetDAO.getScheduleList(year, month, date, userId);

		}catch(Exception e){
			e.printStackTrace();
		}

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


//	@Override
	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
