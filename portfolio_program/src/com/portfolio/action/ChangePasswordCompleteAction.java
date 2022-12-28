package com.portfolio.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.dao.ChangePasswordCompleteDAO;

public class ChangePasswordCompleteAction extends ActionSupport implements SessionAware{

//	■フィールド
	public Map<String, Object> session;
	private String result;
	private String userId;
	private String userName;
	private String password = "";
	private String changePassword = "";

	private String passwordErrorMessage;
	private String changePasswordErrorMessage;

	ChangePasswordCompleteDAO dao = new ChangePasswordCompleteDAO();
	RegistAccountConfirmAction registAccountConfirmAction = new RegistAccountConfirmAction();

	public String execute(){
//		■ログイン済み判定処理
		if(session.containsKey("userName") && session.containsKey("userId")){

		this.userId = session.get("userId").toString();
		this.userName = session.get("userName").toString();

//				■入力値エラー判定処理
			this.passwordErrorMessage = registAccountConfirmAction.errorCheckPassword(registAccountConfirmAction.regexPassword,password);
			System.out.println("1");
			this.changePasswordErrorMessage = registAccountConfirmAction.errorCheckPassword(registAccountConfirmAction.regexPassword,changePassword);
			System.out.println("2");

			if(passwordErrorMessage.equals("") && changePasswordErrorMessage.equals("")){

//					■パスワード更新処理
				try{
					result = dao.changePasswordInfo(userId, userName, password, changePassword);
					if(result.equals("error")){
						this.passwordErrorMessage = "パスワードが一致しません。";
						result = "error";
					}else if(result.equals("success")){
						result = "success";
	//						session情報の削除
						session.clear();
					}else if(result.equals("networkError")){
						result = "networkError";
					}
				}catch(Exception e){
					result = "networkError";
					e.printStackTrace();
				}
			}else{
//				password,changePasswordのどちらかが未入力、入力形式の相違の際に処理
				result = "error";
			}
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
