package com.myhome.admin2.report;

/*
<option value="1"> 중고장터</option>
<option value="2"> 커뮤니티</option>
<option value="3"> 매물거래</option>



*/	
/**
 * 신고 게시글 DB업무 DTO 클래스
 * @author 이대홍
 *
 */

public class ReportDTO {
	private String seqReport; // 신고 번호 
	private String rId; // 신고자 신고자는 r로 시짝!!
	private String rUser;
	private String title;
	private String reason;

	private String seqUsed; // 중고물 거래 번호 
	private String seqProperty; // 매물  번호
	private String seqCommunity; // 커뮤니티 번호  거래 번호 vw에 이것 추가 하기 
	
	private String state;
	private String pId; //신고 받는사람상태 p
	private String pUser;
	

	public String getSeqReport() {
		return seqReport;
	}
	public void setSeqReport(String seqReport) {
		this.seqReport = seqReport;
	}
	public String getrId() {
		return rId;
	}
	public void setrId(String rId) {
		this.rId = rId;
	}
	public String getrUser() {
		return rUser;
	}
	public void setrUser(String rUser) {
		this.rUser = rUser;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getSeqUsed() {
		return seqUsed;
	}
	public void setSeqUsed(String seqUsed) {
		this.seqUsed = seqUsed;
	}
	public String getSeqProperty() {
		return seqProperty;
	}
	public void setSeqProperty(String seqProperty) {
		this.seqProperty = seqProperty;
	}
	public String getSeqCommunity() {
		return seqCommunity;
	}
	public void setSeqCommunity(String seqCommunity) {
		this.seqCommunity = seqCommunity;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getpUser() {
		return pUser;
	}
	public void setpUser(String pUser) {
		this.pUser = pUser;
	}
	
	
	
	
}
