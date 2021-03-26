package com.myhome.user;

public class BoardCommunityDTO {

	private String seqCommunity; // 게시글번호
	private String title; // 제목
	private String content; // 내용
	private String writeDate; // 작성일
	private int viewCount; // 조회수
//	private String seqUser; //회원 번호
	private String seqAllUser; // 회원 번호

	private int gap; // 최신글
	private String nickName; // 회원 닉네임

	private String id;
	private String name;

	private String ccount; // 현재 글에 달린 댓글 갯수

	public String getSeqCommunity() {
		return seqCommunity;
	}

	public void setSeqCommunity(String seqCommunity) {
		this.seqCommunity = seqCommunity;
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

//	public String getSeqUser() {
//		return seqUser;
//	}
//	public void setSeqUser(String seqUser) {
//		this.seqUser = seqUser;
//	}
	public int getGap() {
		return gap;
	}

	public void setGap(int gap) {
		this.gap = gap;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getCcount() {
		return ccount;
	}

	public void setCcount(String ccount) {
		this.ccount = ccount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSeqAllUser() {
		return seqAllUser;
	}

	public void setSeqAllUser(String seqAllUser) {
		this.seqAllUser = seqAllUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
