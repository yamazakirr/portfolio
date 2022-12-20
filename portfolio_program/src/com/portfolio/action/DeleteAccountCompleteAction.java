package com.portfolio.action;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteAccountCompleteAction extends ActionSupport{

	private String result;

	public String exeucte(){


		result = "success";

//	メモ：処理失敗時はnetworkError（後ほど削除）

		return result;
	}

}
