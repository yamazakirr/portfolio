package com.portfolio.action;

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

	ChangeUserNameCompleteDAO dao = new ChangeUserNameCompleteDAO();

	public String execute(){
//		■ログイン済み判定処理
		if(session.containsKey("userName") && session.containsKey("userId")){
			userId = session.get("userId").toString();
			userName = session.get("userName").toString();

			dao.changeUserNameInfo(userId, userName);

		}

		result = "success";
		return result;
	}
//	@Override
	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
