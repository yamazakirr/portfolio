package com.portfolio.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.dto.ScheduleGetDTO;

public class ScheduleConfirmAction extends ActionSupport{

	private String result;

	private int id;
	private int userId;
	private String schedule;
	private String memo;
	private String startDate;
	private String endDate;
	private int allDayFlg;
	private String startTime;
	private String endTime;
	private int calendarDeleteFlg;

	private int year;
	private int month;
	private int date;

	ArrayList<ScheduleGetDTO> scheduleListDTO = new ArrayList<ScheduleGetDTO>();


	public String execute(){

		System.out.println();
		System.out.println("year  :"+year);
		System.out.println("month  :"+month);
		System.out.println("date  :"+date);


		result = "success";
		return result;
	}

//	■getterとsetter
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getUserId(){
		return userId;
	}
	public void setUserId(int userId){
		this.userId = userId;
	}
	public String getSchedule(){
		return schedule;
	}
	public void setSchedule(String schedule){
		this.schedule = schedule;
	}
	public String getMemo(){
		return memo;
	}
	public void setMemo(String memo){
		this.memo = memo;
	}
	public String getStartDate(){
		return startDate;
	}
	public void setStartDate(String startDate){
		this.startDate = startDate;
	}
	public String getEndDate(){
		return endDate;
	}
	public void setEndDate(String endDate){
		this.endDate = endDate;
	}
	public int getAllDayFlg(){
		return allDayFlg;
	}
	public void setAllDayFlg(int allDayFlg){
		this.allDayFlg = allDayFlg;
	}
	public String getStartTime(){
		return startTime;
	}
	public void setStartTime(String startTime){
		this.startTime = startTime;
	}
	public String getEndTime(){
		return endTime;
	}
	public void setEndTime(String endTime){
		this.endTime = endTime;
	}

	public int getCalendarDeleteFlg(){
		return calendarDeleteFlg;
	}
	public void setCalendarDeleteFlg(int calendarDeleteFlg){
		this.calendarDeleteFlg = calendarDeleteFlg;
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

	public ArrayList<ScheduleGetDTO> getScheduleListDTO(){
		return scheduleListDTO;
	}
	public void setScheduleListDTO(ArrayList<ScheduleGetDTO> scheduleListDTO){
		this.scheduleListDTO = scheduleListDTO;
	}

}
