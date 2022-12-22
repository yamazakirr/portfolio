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

		try{
			userId = session.get("userId").toString();
			userName = session.get("userName").toString();
				try{
	//				■アカウント削除処理
					result = dao.deleteUserInfo(userId, userName);
	//				■ログアウト処理
					session.clear();
				}catch(SQLException e){
					result = "networkError";
					e.printStackTrace();
				}
		}catch(NullPointerException e){
//			■sessionにてNULLがある場合は未ログイン状態と判定
			result = "accountError";
			e.printStackTrace();
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
