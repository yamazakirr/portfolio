package com.portfolio.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ChangeUserNameAction extends ActionSupport implements SessionAware{

//	■フィールド
	public Map<String, Object> session;
	private String result;

	public String execute(){

//		■ログイン済み判定処理
		if(session.containsKey("userName") && session.containsKey("userId")){
			result = "success";
		}else{
			result = "accountError";
		}
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
