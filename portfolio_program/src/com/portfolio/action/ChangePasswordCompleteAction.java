package com.portfolio.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ChangePasswordCompleteAction extends ActionSupport implements SessionAware{

//	■フィールド
	public Map<String, Object> session;
	private String result;
	private String userId;
	private String userName;
	private String password;
	private String changePassword;

	private String changePasswordErrorMessage;
	private String passwordErrorMessage;

	public String execute(){
//		■ログイン済み判定処理
		if(session.containsKey("userName") && session.containsKey("userId")){

//			■パスワード更新処理



			result = "success";
		}else{
			result = "accountError";
		}
		return result;
	}

//	■getterとsetter
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
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getChangePassword(){
		return changePassword;
	}
	public void setChangePassword(String changePassword){
		this.changePassword = changePassword;
	}
	public String getPasswordErrorMessage(){
		return passwordErrorMessage;
	}
	public void setPasswordErrorMessage(String passwordErrorMessage){
		this.passwordErrorMessage = passwordErrorMessage;
	}
	public String getChangePasswordErrorMessage(){
		return changePasswordErrorMessage;
	}
	public void setChangePasswordErrorMessage(String changePasswordErrorMessage){
		this.changePasswordErrorMessage = changePasswordErrorMessage;
	}

//	@Override
	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
