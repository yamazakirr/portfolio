package com.portfolio.action;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.dao.ScheduleEditCompleteDAO;
import com.portfolio.dao.ScheduleGetDAO;
import com.portfolio.dto.ScheduleGetDTO;

public class ScheduleEditCompleteAction extends ActionSupport implements SessionAware{

//	■フィールド一覧
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
	private String startDate;
	private String endDate;
	private int allDayFlg;
	private String startTime;
	private String endTime;
	private int calendarDeleteFlg;

	private int startYear;
	private int startMonth;
	private int startDay;
	private int startHour;
	private int startMinutes;

	private int endYear;
	private int endMonth;
	private int endDay;
	private int endHour;
	private int endMinutes;

	private String scheduleErrorMessage;

	ArrayList<Object> calendarLists = new ArrayList<Object>();
	LoginAction loginAction = new LoginAction();
	ScheduleGetDAO scheduleGetDAO = new ScheduleGetDAO();
	ArrayList<ScheduleGetDTO> scheduleListDTO = new ArrayList<ScheduleGetDTO>();

	ScheduleEditCompleteDAO dao = new ScheduleEditCompleteDAO();

	public String execute(){

//		■ログイン済み認証
		if(session.containsKey("userId") && session.containsKey("userName")){

			System.out.println("schedule :"+schedule);

//			スケジュールの空白判定
			if(schedule.equals("")){
//				「予定」欄が空白
				scheduleErrorMessage = "予定が未入力です。";
				result = "error";
			}else{
				String dateFormat = "yyyy-MM-dd";
				String timeFormat = "HH:mm";

//				startDate,endDateの作成
				LocalDate startDate = LocalDate.of(startYear, startMonth, startDay);
				this.startDate = startDate.format(DateTimeFormatter.ofPattern(dateFormat));
				LocalDate endDate = LocalDate.of(endYear, endMonth, endDay);
				this.endDate = endDate.format(DateTimeFormatter.ofPattern(dateFormat));

//				■allDayFlgが「0」と「1」で処理を分けるようにする
				if(allDayFlg == 0){
//					終日フラグが「0」の場合
//					startTime,endTimeの作成
					LocalTime startTime = LocalTime.of(startHour, startMinutes);
					this.startTime = startTime.format(DateTimeFormatter.ofPattern(timeFormat));
					LocalTime endTime = LocalTime.of(endHour, endMinutes);
					this.endTime = endTime.format(DateTimeFormatter.ofPattern(timeFormat));
				}else if(allDayFlg == 1){
//					終日フラグが「1」の場合
					this.startTime = "00:00:00";
					this.endTime = "00:00:00";
				}

				try{
//					■スケジュール編集処理
					result = dao.scheduleEdit(userId, id, schedule, memo, this.startDate, this.endDate, allDayFlg, this.startTime, this.endTime);

//					■スケジュール編集エラー判定処理
					if(result.equals("networkError")){
						return result;
					}else{
//						■カレンダー取得処理
						calendarLists = loginAction.getCalendar(year, month -1);
//						■選択した日付のスケジュール取得処理
						scheduleListDTO = scheduleGetDAO.getScheduleList(year, month, date, userId);
					}

				}catch(SQLException e){
					e.printStackTrace();
				}
				result = "success";
			}
		}else{
//			未ログイン判定
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



	public int getStartHour(){
		return startHour;
	}
	public void setStartHour(int startHour){
		this.startHour = startHour;
	}
	public int getStartMinutes(){
		return startMinutes;
	}
	public void setStartMinutes(int startMinutes){
		this.startMinutes = startMinutes;
	}
	public int getEndHour(){
		return endHour;
	}
	public void setEndHour(int endHour){
		this.endHour = endHour;
	}
	public int getEndMinutes(){
		return endMinutes;
	}
	public void setEndMinutes(int endMinutes){
		this.endMinutes = endMinutes;
	}

	public String getScheduleErrorMessage(){
		return scheduleErrorMessage;
	}
	public void setScheduleErrorMessage(String scheduleErrorMessage){
		this.scheduleErrorMessage = scheduleErrorMessage;
	}


	public ArrayList<Object> getCalendarLists(){
		return calendarLists;
	}
	public void setCalendarLists(ArrayList<Object> calendarLists){
		this.calendarLists = calendarLists;
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
