package com.portfolio.dto;

import java.time.LocalDate;
import java.time.LocalTime;;

public class ScheduleGetDTO {

	private int id;
	private int userId;
	private String schedule;
	private String memo;
	private LocalDate startDate;
	private LocalDate endDate;
	private int allDayFlg;
	private LocalTime startTime;
	private LocalTime endTime;
	private int calendarDeleteFlg;

	private int year;
	private int month;
	private int date;



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

}
