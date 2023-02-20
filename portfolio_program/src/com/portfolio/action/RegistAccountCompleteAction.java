package com.portfolio.action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.dao.RegistAccountCompleteDAO;
import com.portfolio.dao.RegistAccountConfirmDAO;

public class RegistAccountCompleteAction extends ActionSupport{

//■フィールド一覧
	private String userName;
	private String mail;
	private String password;


	public String execute(){
		String mailCheckResult = "networkError";
		String result = "error";

		RegistAccountConfirmDAO registAccountConfirmDAO = new RegistAccountConfirmDAO();
		RegistAccountCompleteDAO registAccountCompleteDAO = new RegistAccountCompleteDAO();

		try{
//			■メアド登録済みチェック処理
			mailCheckResult = registAccountConfirmDAO.checkMailDatebase(mail);

			System.out.println("RegistAccountCompleteAction.javaのmailCheckResult "+ mailCheckResult);

			if(mailCheckResult.equals("success")){
//				■アカウント作成処理
				result = registAccountCompleteDAO.createUser(userName, mail, password);
			}else{
//				■メアドが既に登録済み
				mailCheckResult = "registerdAccountError";
				return mailCheckResult;
			}

		}catch(SQLException e){
			e.printStackTrace();
			return result;
		}
		System.out.println("RegistAccountCompleteAction.javaのresult "+ result);
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

}
