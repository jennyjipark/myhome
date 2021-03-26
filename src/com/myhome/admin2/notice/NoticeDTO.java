package com.myhome.admin2.notice;
/**
 * 
 * 공지사항 DB작업 DTO클래스 
 * @author 이대홍
 *
 */
public class NoticeDTO {

	private String seqNotice;
	private String seqAdmin;
	private String title;
	private String content;
	private String writeDate;
	private String viewCount;
	public String getSeqNotice() {
		return seqNotice;
	}
	public void setSeqNotice(String seqNotice) {
		this.seqNotice = seqNotice;
	}
	public String getSeqAdmin() {
		return seqAdmin;
	}
	public void setSeqAdmin(String seqAdmin) {
		this.seqAdmin = seqAdmin;
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
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getViewCount() {
		return viewCount;
	}
	public void setViewCount(String viewCount) {
		this.viewCount = viewCount;
	}
	
}
