package com.portfolio.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.dao.ChangeUserNameCompleteDAO;

public class ChangeUserNameCompleteAction extends ActionSupport implements SessionAware{

//	■フィールド
	public Map<String, Object> session;
	private String result;
	private String userId;
	private String userName;
	private String password;
	private String changeUserName;

	private String userNameErrorMessage;
	private String passwordErrorMessage;

	ChangeUserNameCompleteDAO dao = new ChangeUserNameCompleteDAO();
	RegistAccountConfirmAction registAccountConfirmAction = new RegistAccountConfirmAction();

	public String execute(){

//		■ログイン済み判定処理
		if(session.containsKey("userName") && session.containsKey("userId")){

//			■入力値エラー判定処理
//			メモ：名前未入力、パスワード未入力、パスワード違い
			this.userNameErrorMessage = registAccountConfirmAction.errorCheckUserName(changeUserName);
			this.passwordErrorMessage = registAccountConfirmAction.errorCheckPassword(registAccountConfirmAction.regexPassword,password);

			if(userNameErrorMessage.equals("") && passwordErrorMessage.equals("")){
				userId = session.get("userId").toString();
				userName = session.get("userName").toString();

				System.out.println("userName "+userName);
				System.out.println("changeUserName "+changeUserName);
				System.out.println("password "+password);

				try{
//					■ユーザー名更新処理
					result = dao.changeUserNameInfo(userId, userName, password, changeUserName);
					if(result.equals("error")){
						this.passwordErrorMessage = "パスワードが一致しません。";
						result = "error";
					}else if(result.equals("success")){
						result = "success";

//						sessionの更新
						session.put("userName", changeUserName);
					}else if(result.equals("networkError")){
						result = "networkError";
					}
				}catch(SQLException e){
					result = "networkError";
					e.printStackTrace();
				}

			}else{
				result = "error";
			}
		}else{
			result ="accountError";
		}
		return result;
	}


//	■getterとsetter
	public String getChangeUserName(){
		return changeUserName;
	}
	public void setChangeUserName(String changeUserName){
		this.changeUserName = changeUserName;
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
	public String getPasswordErrorMessage(){
		return passwordErrorMessage;
	}
	public void sePasswordErrorMessage(String passwordErrorMessage){
		this.passwordErrorMessage = passwordErrorMessage;
	}

//	@Override
	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
