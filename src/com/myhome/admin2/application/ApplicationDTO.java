package com.myhome.admin2.application;
/**
 * 청약 DTO   
 * @author 이대홍
 */
public class ApplicationDTO {

	private String seqAdmin;
	private String seqApplication;
	private String viewcount;
	private String content;
	private String title;
	private String savefile;
	private String writedate;
	
	
	public String getSeqAdmin() {
		return seqAdmin;
	}
	public void setSeqAdmin(String seqAdmin) {
		this.seqAdmin = seqAdmin;
	}
	public String getSeqApplication() {
		return seqApplication;
	}
	public void setSeqApplication(String seqApplication) {
		this.seqApplication = seqApplication;
	}
	public String getViewcount() {
		return viewcount;
	}
	public void setViewcount(String viewcount) {
		this.viewcount = viewcount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSavefile() {
		return savefile;
	}
	public void setSavefile(String savefile) {
		this.savefile = savefile;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	
}
