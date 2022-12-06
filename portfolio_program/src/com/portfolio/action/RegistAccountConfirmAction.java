package com.portfolio.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;

public class RegistAccountConfirmAction extends ActionSupport{

//■フィールド一覧
	private String userName;
	private String mail;
	private String password;
	private String passwordText = "";

	private String errorMessage = "";
	private String userNameErrorMessage;
	private String mailErrorMessage;
	private String passwordErrorMessage;

	public String execute(){



		this.userNameErrorMessage = errorCheck(regexUserName, userName);


		return SUCCESS;
	}

//■エラーメッセージ判定処理

	//■入力判定フィールド
	public String regexUserName = "";
	public String regexPassword = "^[a-zA-Z0-9]*$";
	public String regexMail = "^[a-zA-Z0-9.@_-]*$";
	int errorCheckTextNum = 0;

	public String errorCheck(String regex, String checkText){
		System.out.println("regex "+ regex);
		System.out.println("checkText "+ checkText);
		String checkTextErrorMessage = "";

		if(errorCheckTextNum == 0){
			if(checkText.equals("")){
				checkTextErrorMessage = "ニックネームが未入力です。";
			}else{
				checkTextErrorMessage = "";
			}
			errorCheckTextNum += 1;
		}else if(errorCheckTextNum == 1){
			if(checkText.equals("")){
				checkTextErrorMessage = "メールアドレスが未入力です。";
			}else{
				boolean checkResult = checkTextError(regex, checkText);
				if(checkResult == true){
					checkTextErrorMessage = "";
				}else{
					checkTextErrorMessage = "正しい形式でご入力をお願いします。";
				}
			}
			errorCheckTextNum += 1;
		}


		return checkTextErrorMessage;
	}

	//■入力判定処理
	public boolean checkTextError(String regex, String text){
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		boolean result = m.find();

		return result;
	}




//■getterとsetter
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


	public String getUserNameErrorMessage(){
		return userNameErrorMessage;
	}
	public void setUserNameErrorMessage(String userNameErrorMessage){
		this.userNameErrorMessage = userNameErrorMessage;
	}
	public String getMailErrorMessage(){
		return mailErrorMessage;
	}
	public void setMailErrorMessage(String mailErrorMessage){
		this.mailErrorMessage = mailErrorMessage;
	}
	public String getPasswordErrorMessage(){
		return passwordErrorMessage;
	}
	public void setPasswordErrorMessage(String passwordErrorMessage){
		this.passwordErrorMessage = passwordErrorMessage;
	}



}
