package com.myhome.user;

public class BoardPolicyDTO {

	private String seqPolicy; //정책번호
	private String title; //제목
	private String content; //내용
	private String writeDate; //작성일
	private int viewCount; //조회수
	private String seqAdmin; //관리자(작성자)번호
	
	private int gap; //최신글
	private String id; //관리자 id
	
	private String seqUser; //회원번호

	public String getSeqPolicy() {
		return seqPolicy;
	}

	public void setSeqPolicy(String seqPolicy) {
		this.seqPolicy = seqPolicy;
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

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public String getSeqAdmin() {
		return seqAdmin;
	}

	public void setSeqAdmin(String seqAdmin) {
		this.seqAdmin = seqAdmin;
	}

	public int getGap() {
		return gap;
	}

	public void setGap(int gap) {
		this.gap = gap;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSeqUser() {
		return seqUser;
	}

	public void setSeqUser(String seqUser) {
		this.seqUser = seqUser;
	}
}
