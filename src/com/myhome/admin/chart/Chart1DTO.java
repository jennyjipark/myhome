package com.myhome.admin.chart;

/***
 * 가격변화차트 원룸 월세 DTO입니다. 
 * @author 윤지현
 *
 */
public class Chart1DTO {
	
	private String contractdate;
	private String contracttype;
	private String roomtype;
	private String avg;
	
	public String getContractdate() {
		return contractdate;
	}
	public void setContractdate(String contractdate) {
		this.contractdate = contractdate;
	}
	public String getContracttype() {
		return contracttype;
	}
	public void setContracttype(String contracttype) {
		this.contracttype = contracttype;
	}
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public String getAvg() {
		return avg;
	}
	public void setAvg(String avg) {
		this.avg = avg;
	}
	
	

}
