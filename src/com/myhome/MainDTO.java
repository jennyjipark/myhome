package com.myhome;

public class MainDTO {
	
	private String notice;
	private String application;
	private String check;
	
	private int totalCount;
	private int totalContract;
	
	
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
	}
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	public int getTotalContract() {
		return totalContract;
	}
	public void setTotalContract(int totalContract) {
		this.totalContract = totalContract;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}
