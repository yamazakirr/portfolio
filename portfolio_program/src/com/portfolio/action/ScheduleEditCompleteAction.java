package com.portfolio.action;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class ScheduleEditCompleteAction extends ActionSupport{

	public Map<String, Object> session;
	private String result;

	private int year;
	private int month;
	private int date;

	private int userId;
	private String userName;

	private int id;
	private String schedule;
	private String memo;
	private LocalDate startDate;
	private LocalDate endDate;
	private int allDayFlg;
	private LocalTime startTime;
	private LocalTime endTime;
	private int calendarDeleteFlg;

	private int startYear;
	private int startMonth;
	private int startDay;
	private int endYear;
	private int endMonth;
	private int endDay;


	public String execute(){


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
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
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
	public LocalDate getStartDate(){
		return startDate;
	}
	public void setStartDate(LocalDate startDate){
		this.startDate = startDate;
	}
	public LocalDate getEndDate(){
		return endDate;
	}
	public void setEndDate(LocalDate endDate){
		this.endDate = endDate;
	}
	public int getAllDayFlg(){
		return allDayFlg;
	}
	public void setAllDayFlg(int allDayFlg){
		this.allDayFlg = allDayFlg;
	}
	public LocalTime getStartTime(){
		return startTime;
	}
	public void setStartTime(LocalTime startTime){
		this.startTime = startTime;
	}
	public LocalTime getEndTime(){
		return endTime;
	}
	public void setEndTime(LocalTime endTime){
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

	public int getStartYear(){
		return startYear;
	}
	public void setStartYear(int startYear){
		this.startYear = startYear;
	}
	public int getStartMonth(){
		return startMonth;
	}
	public void setStartMonth(int startMonth){
		this.startMonth = startMonth;
	}
	public int getStartDay(){
		return startDay;
	}
	public void setStartDay(int startDay){
		this.startDay = startDay;
	}
	public int getEndYear(){
		return endYear;
	}
	public void setEndYear(int endYear){
		this.endYear = endYear;
	}
	public int getEndMonth(){
		return endMonth;
	}
	public void setEndMonth(int endMonth){
		this.endMonth = endMonth;
	}
	public int getEndDay(){
		return endDay;
	}
	public void setEndDay(int endDay){
		this.endDay = endDay;
	}
}
