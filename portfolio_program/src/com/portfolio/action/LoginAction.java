package com.portfolio.action;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.dao.LoginDAO;

public class LoginAction extends ActionSupport implements SessionAware{

//	■フィールド一覧
	public Map<String, Object> session;
	private String userId;
	private String userName;
	private String mail;
	private String password;
	private String loginErrorMessage = "";

	private int year;
	private int month;
	private int date;
	private int dayOfWeek;
	private int lastDate;
	private int startDate;

	private int firstDate;

	LoginDAO loginDAO = new LoginDAO();


//	■コンストラクタ
	public LoginAction(){
		Calendar today = Calendar.getInstance();
		Calendar firstDay = Calendar.getInstance();
		firstDay.set(Calendar.DATE, 1);
		this.firstDate = firstDay.get(Calendar.DAY_OF_WEEK);

		this.year = today.get(Calendar.YEAR);
		this.month = today.get(Calendar.MONTH)+1;
		this.date = today.get(Calendar.DATE);
		this.dayOfWeek = today.get(Calendar.DAY_OF_WEEK);
		this.lastDate = today.getActualMaximum(Calendar.DATE);
		this.startDate = today.getActualMinimum(Calendar.DATE);
	}



	public String execute(){
		String result = "";

//		■カレンダーの作成
		int row = 0;
		int i = 1;
		int weeks;
		String flg = "true";

//		■対象月が何週間か取得
		double d = 0.0;
		d = (lastDate + firstDate-1)/7.0;
		System.out.println();

		System.out.println("lastDate "+lastDate);
		System.out.println("firstDate "+firstDate);
		System.out.println("d "+d);
		System.out.println("row "+row);

		System.out.println();
		weeks = (int)Math.ceil(d);

		int[][] dates = new int[weeks][7];

		System.out.println("weeks "+weeks);


		System.out.println("①");


		loop:for(; row < weeks; row++){

			if(flg.equals("true")){
				System.out.println("②");
				for(int column = firstDate; column%7 != 0; column++){
					dates[row][column-1] = i;
					System.out.println("["+row+"]"+"["+(column-1)+"]"+ dates[row][column-1]);
					i++;
				}
				flg = "false";
			}else if(flg.equals("false")){
				System.out.println("③");
				for(int column = 1; column<=7 ; column++){
					System.out.println();
					System.out.println("i  "+i);

					if(i == lastDate){
						break loop;
					}
					dates[row][column-1] = i;

					System.out.println("["+row+"]"+"["+(column-1)+"]"+ dates[row][column-1]);
					i++;
				}

			}
		}
		System.out.println("[4][6] "+dates[4][6]);


		try{
			result = loginDAO.getLoginResult(mail, password);

			if(result.equals("success")){
				this.userId = loginDAO.getUserId();
				this.userName = loginDAO.getUserName();

				System.out.println("result "+ result);
				System.out.println("userId "+ userId);
				System.out.println("userName "+ userName);
				System.out.println("mail "+ mail);
				System.out.println("password "+ password);

				session.put("userName", userName);
				session.put("userId", userId);
			}else if(result.equals("error")){
				System.out.println("result "+ result);
				this.loginErrorMessage = loginDAO.getLoginErrorMessage();
			}

		}catch(SQLException e){
			result = "networkError";
			e.printStackTrace();
		}

		return result;
	}

//■getterとsetter
	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId = userId;
	}
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	public String getMail(){
		return mail;
	}
	public void setMail(String mail){
		this.mail = mail;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getLoginErrorMessage(){
		return loginErrorMessage;
	}
	public void setLoginErrorMessage(String loginErrorMessage){
		this.loginErrorMessage = loginErrorMessage;
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
	public int getDayOfWeek(){
		return dayOfWeek;
	}
	public void setDayOfWeek(int dayOfWeek){
		this.dayOfWeek = dayOfWeek;
	}
	public int getLastDate(){
		return lastDate;
	}
	public void setLastDate(int lastDate){
		this.lastDate = lastDate;
	}
	public int getStartDate(){
		return startDate;
	}
	public void setStartDate(int startDate){
		this.startDate = startDate;
	}




//	@Override
	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
