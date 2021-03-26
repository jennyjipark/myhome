package com.myhome.admin.board;

/***
 * 부동산정책 게시판 DTO입니다.
 * @author 윤지현
 *
 */
public class PolicyDTO {
	
	private String seq;
	private String seqadmin;
	private String title;
	private String content;
	private String writedate;
	private String viewcount;
	
	private String id; //관리자 id
	
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getSeqadmin() {
		return seqadmin;
	}
	public void setSeqadmin(String seqadmin) {
		this.seqadmin = seqadmin;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writeDate) {
		this.writedate = writeDate;
	}
	public String getViewcount() {
		return viewcount;
	}
	public void setViewcount(String viewcount) {
		this.viewcount = viewcount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
 
}
