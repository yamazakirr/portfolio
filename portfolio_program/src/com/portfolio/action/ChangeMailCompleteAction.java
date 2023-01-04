package com.portfolio.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.dao.ChangeMailCompleteDAO;

public class ChangeMailCompleteAction extends ActionSupport implements SessionAware{

//	■フィールド
	public Map<String, Object> session;
	private String result;
	private String userId;
	private String userName;
	private String changeMail;
	private String password;

	private String changeMailErrorMessage;
	private String passwordErrorMessage;

	ChangeMailCompleteDAO dao = new ChangeMailCompleteDAO();
	RegistAccountConfirmAction registAccountConfirmAction = new RegistAccountConfirmAction();

	public String execute(){
//		■ログイン済み判定処理
		if(session.containsKey("userId") && session.containsKey("userName")){
			this.userId = session.get("userId").toString();
			this.userName = session.get("userName").toString();

//			■入力値エラー判定処理
			this.changeMailErrorMessage = registAccountConfirmAction.errorCheckMail(registAccountConfirmAction.regexMail, changeMail);
			this.passwordErrorMessage = registAccountConfirmAction.errorCheckPassword(registAccountConfirmAction.regexPassword,password);

			if(changeMailErrorMessage.equals("") && passwordErrorMessage.equals("")){

//				■メアド変更処理
				try{
					result = dao.changeMailInfo(userId, userName, changeMail, password);
					if(result.equals("error")){
						this.passwordErrorMessage = "パスワードが一致しません。";
					}else if(result.equals("success")){
						session.clear();
					}else if(result.equals("networkError")){
						;
					}

				}catch(Exception e){
					result = "networkError";
					e.printStackTrace();
				}
			}else{
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
	public String getChangeMail(){
		return changeMail;
	}
	public void setChangeMail(String changeMail){
		this.changeMail = changeMail;
	}
	public String getPasswordErrorMessage(){
		return passwordErrorMessage;
	}
	public void setPasswordErrorMessage(String passwordErrorMessage){
		this.passwordErrorMessage = passwordErrorMessage;
	}
	public String getChangeMailErrorMessage(){
		return changeMailErrorMessage;
	}
	public void setChangeMailErrorMessage(String changeMailErrorMessage){
		this.changeMailErrorMessage = changeMailErrorMessage;
	}

//	@Override
	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
