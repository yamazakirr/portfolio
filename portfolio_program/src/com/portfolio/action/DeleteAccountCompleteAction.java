package com.portfolio.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.dao.DeleteAccountCompleteDAO;

public class DeleteAccountCompleteAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private String result;
	private String userId;
	private String userName;

	DeleteAccountCompleteDAO dao = new DeleteAccountCompleteDAO();

	public String execute(){

		userId = session.get("userId").toString();
		userName = session.get("userName").toString();

//		■ログイン済み判定
		if(session.containsKey("userId") && session.containsKey("userName")){
			try{
//				■アカウント削除処理
				result = dao.deleteUserInfo(userId, userName);
//				■ログアウト処理
//				session.clear();
			}catch(SQLException e){
				result = "networkError";
				e.printStackTrace();
			}

		}else{
			result = "accountError";
		}
		System.out.println("result "+result);

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
