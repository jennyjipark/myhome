package com.myhome.user;

import java.util.Date;
/**
 * 중고장터 게시글 객체입니다.
 * @author 이준오
 *
 */
public class BoardUsedDTO {

	private int seqUsed;
	private String category;
	private String title;
	private String nickname;
	private Date writeDate;
	private int seqUser;
	private String name;
	private String tradeMode;
	private int price;
	private String imagePath;

	private int commentCount;

	private int totalcount; // 전체 글 수

	private String content; //본문


	/**
	 * 중고장터 게시물 번호 getter메소드
	 * @return 중고장터 게시물 번호입니다.
	 */
	public int getSeqUsed() {
		return seqUsed;
	}
	/**
	 * 중고장터 게시물 번호 setter메소드
	 * @param seqUsed 중고장터 게시물 번호입니다.
	 */
	public void setSeqUsed(int seqUsed) {
		this.seqUsed = seqUsed;
	}
	/**
	 * 카테고리 getter메소드
	 * @return 카테고리입니다.
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * 카테고리 setter메소드
	 * @param category 카테고리입니다.
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * 글제목 getter메소드
	 * @return 제목입니다.
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 글제목 setter메소드
	 * @param title 제목입니다.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 닉네임 getter메소드
	 * @return 닉네임입니다.
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 닉네임 setter메소드
	 * @param nickname 닉네임입니다.
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 글 작성일 getter메소드
	 * @return 글 작성일 입니다.
	 */
	public Date getWriteDate() {
		return writeDate;
	}
	/**
	 * 글 작성일 setter메소드
	 * @param writeDate 글 작성일 입니다.
	 */
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	/**
	 * 회원번호 getter메소드
	 * @return 회원번호입니다.
	 */
	public int getSeqUser() {
		return seqUser;
	}
	/**
	 * 회원번호 setter메소드
	 * @param seqUser 회원번호입니다.
	 */
	public void setSeqUser(int seqUser) {
		this.seqUser = seqUser;
	}
	/**
	 * 회원이름 getter메소드
	 * @return 회원이름 입니다.
	 */
	public String getName() {
		return name;
	}
	/**
	 * 회원이름 setter메소드
	 * @param name 회원이름 입니다.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 거래방식 getter메소드
	 * @return 거래방식입니다.
	 */
	public String getTradeMode() {
		return tradeMode;
	}
	/**
	 * 거래방식 setter메소드
	 * @param tradeMode 거래방식입니다.
	 */
	public void setTradeMode(String tradeMode) {
		this.tradeMode = tradeMode;
	}
	/**
	 * 가격정보 getter메소드
	 * @return 가격정보입니다.
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * 가격정보 setter메소드
	 * @param price 가격정보입니다.
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * 이미지경로 getter메소드
	 * @return 이미지 경로입니다.
	 */
	public String getImagePath() {
		return imagePath;
	}
	/**
	 * 이미지경로 setter메소드
	 * @param imagePath 이미지 경로입니다.
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	/**
	 * 댓글 갯수 getter메소드
	 * @return 댓글 수 입니다.
	 */
	public int getCommentCount() {
		return commentCount;
	}
	/**
	 * 댓글 갯수 setter메소드
	 * @param commentCount 댓글 수 입니다.
	 */
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	/**
	 * 게시글 갯수 getter메소드
	 * @return 게시글의 총 수입니다.
	 */
	public int getTotalcount() {
		return totalcount;
	}
	/**
	 * 게시글 갯수 setter메소드
	 * @param totalcount 게시글의 총 수입니다.
	 */
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}
	/**
	 * 게시글 내용 본문 getter메소드
	 * @return 내용 본문 입니다.
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 게시글 내용 본문 setter메소드
	 * @param content 내용 본문 입니다.
	 */
	public void setContent(String content) {
		this.content = content;
	}



}