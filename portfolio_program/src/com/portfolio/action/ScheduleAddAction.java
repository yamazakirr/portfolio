package com.portfolio.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ScheduleAddAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
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

	private int year;
	private int month;
	private int date;

//	■予定編集画面の日付選択プルダウン作成のために追加
	private int startYear;
	private int startMonth;
	private int startDay;
	private int endYear;
	private int endMonth;
	private int endDay;

	public String execute(){

//		■ログイン済み認証
		if(session.containsKey("userId") && session.containsKey("userName")){

			startYear = (Integer)session.get("year");
			endYear = (Integer)session.get("year");
			startMonth = (Integer)session.get("month");
			endMonth = (Integer)session.get("month");
			startDay = (Integer)session.get("date");
			endDay = (Integer)session.get("date");

//			■日付が取得可否判定
			if(year != 0 && month != 0 && date != 0){
				result = "success";
			}else{
				System.out.println("日付情報が取得出来ていません");
				result = "networkError";
			}

		}else{
			System.out.println("ログインしていません。");
			result = "accountError";
		}
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

//	Override
	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
