package com.portfolio.action;

import com.opensymphony.xwork2.ActionSupport;

public class ScheduleConfirmAction extends ActionSupport{

	private String result;

	public String execute(){


		result = "success";
		return result;
	}

}
