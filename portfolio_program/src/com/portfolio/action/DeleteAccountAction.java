package com.portfolio.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteAccountAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private String result;

	public String execute(){

		System.out.println("userId "+session.get("userId"));
		System.out.println("userName "+session.get("userName"));

//		■ログイン済み判定
		if(session.containsKey("userId") && session.containsKey("userName")){
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
