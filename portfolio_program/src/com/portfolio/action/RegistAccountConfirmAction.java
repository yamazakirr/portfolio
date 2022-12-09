package com.portfolio.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.dao.RegistAccountConfirmDAO;

public class RegistAccountConfirmAction extends ActionSupport{

//■フィールド一覧
	private String userName;
	private String mail;
	private String password;
	private String passwordText = "";
	String result = "";

//	private String errorMessage = "";
	private String userNameErrorMessage;
	private String mailErrorMessage;
	private String passwordErrorMessage;

	RegistAccountConfirmDAO registAccountConfirmDAO = new RegistAccountConfirmDAO();

	public String execute(){

//		パスワードの文字数分●を取得
		for(int i = 0 ; i < password.length(); i++){
			this.passwordText += "●";
		}

		System.out.println("userName "+userName);
		System.out.println("mail "+mail);
		System.out.println("password "+password);

		this.userNameErrorMessage = errorCheck(regexUserName, userName);
		errorCheckLists.add(this.userNameErrorMessage);
		this.mailErrorMessage = errorCheck(regexMail, mail);
		errorCheckLists.add(this.mailErrorMessage);
		this.passwordErrorMessage = errorCheck(regexPassword, password);
		errorCheckLists.add(this.passwordErrorMessage);

//		■全体のエラーチェック
		int s = errorCheckAll();

		if(result.equals("networkError")){
			return result;
		}else{
			if(s == 0){
				result = SUCCESS;
				System.out.println("result :"+result);
			}else{
				result = ERROR;
				System.out.println("result :"+result);
			}
		}


		return result;
	}

//■エラーメッセージ判定処理

	//■入力判定フィールド
	public String regexUserName = "";
	public String regexPassword = "^[a-zA-Z0-9]*$";
	public String regexMail = "^([a-zA-Z0-9])+(.[a-zA-Z0-9_-]+)*@([a-zA-Z0-9_-])+([a-zA-Z0-9._-]+)+$";
	int errorCheckTextNum = 0;

	public String errorCheck(String regex, String checkText){
		System.out.println("regex "+ regex);
		System.out.println("checkText "+ checkText);
		String checkTextErrorMessage = "";

		if(errorCheckTextNum == 0){
			if(checkText.equals("")){
				checkTextErrorMessage = "ニックネームが未入力です。";
			}else{
				checkTextErrorMessage = "";
			}
			errorCheckTextNum += 1;
		}else if(errorCheckTextNum == 1){
			if(checkText.equals("")){
				checkTextErrorMessage = "メールアドレスが未入力です。";
			}else{
				boolean checkResult = checkTextError(regex, checkText);
				if(checkResult == true){

//					データベースに登録済み判定
					try{
						String checkMailResult = registAccountConfirmDAO.checkMailDatebase(checkText);
						if(checkMailResult.equals("success")){
							checkTextErrorMessage = "";
						}else if(checkMailResult.equals("error")){
							checkTextErrorMessage = "このメールアドレスは既に使用されています。";
						}else if(checkMailResult.equals("networkError")){
							result = "networkError";
						}
					}catch(SQLException e){

						e.printStackTrace();
					}



				}else{
					checkTextErrorMessage = "正しい形式でご入力をお願いします。";
				}
			}
			errorCheckTextNum += 1;
		}else if(errorCheckTextNum == 2){
			if(checkText.equals("")){
				checkTextErrorMessage = "パスワードが未入力です。";
			}else{
				boolean checkResult = checkTextError(regex, checkText);
				if(checkResult == true){
					checkTextErrorMessage = "";
				}else{
					checkTextErrorMessage = "半角英数字でご入力をお願いします。";
				}
			}
		}


		return checkTextErrorMessage;
	}

//	■項目全体のエラー判定処理
//	errorCount = 0 : 項目全体でエラーなし
	ArrayList<String> errorCheckLists = new ArrayList<>();
	int successCount = 0;
	int errorCount = 0;

	public int errorCheckAll(){
		for(String errorCheckList: errorCheckLists){
			if(errorCheckList == ""){
				successCount += 1;
			}else{
				errorCount += 1;
			}
		}
		return errorCount;
	}

	//■入力判定処理
	public boolean checkTextError(String regex, String text){
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		boolean result = m.find();

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
	public String getPasswordText(){
		return passwordText;
	}
	public void setPasswordText(String passwordText){
		this.passwordText = passwordText;
	}


	public String getUserNameErrorMessage(){
		return userNameErrorMessage;
	}
	public void setUserNameErrorMessage(String userNameErrorMessage){
		this.userNameErrorMessage = userNameErrorMessage;
	}
	public String getMailErrorMessage(){
		return mailErrorMessage;
	}
	public void setMailErrorMessage(String mailErrorMessage){
		this.mailErrorMessage = mailErrorMessage;
	}
	public String getPasswordErrorMessage(){
		return passwordErrorMessage;
	}
	public void setPasswordErrorMessage(String passwordErrorMessage){
		this.passwordErrorMessage = passwordErrorMessage;
	}



}
