package com.myhome.user;

import java.util.Date;


/**
 * 찜목록(중고장터) 객체
 * @author User
 *
 */
public class vwUsedLikeDTO {
	

	private int seqUser;
	private int seqUsed;
	private String title;
	private String sellNickname;
	private String state;
	private String imagePath;
	private Date writeDate;
	private String tradeMode;
	
	private int price;
	
	
	/**
	 * 회원번호의 getter메소드
	 * @return 회원번호
	 */
	public int getSeqUser() {
		return seqUser;
	}
	/**
	 * 회원번호의 setter메소드
	 * @param seqUser 회원번호
	 */
	public void setSeqUser(int seqUser) {
		this.seqUser = seqUser;
	}
	/**
	 * 중고장터 게시글번호의 getter메소드
	 * @return 중고장터 게시글번호
	 */
	public int getSeqUsed() {
		return seqUsed;
	}
	/**
	 * 중고장터 게시글번호의 setter메소드
	 * @param seqUsed 중고장터 게시글번호
	 */
	public void setSeqUsed(int seqUsed) {
		this.seqUsed = seqUsed;
	}
	/**
	 * 제목의 getter메소드
	 * @return 제목
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 제목의 setter메소드
	 * @param title 제목
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 판매자 닉네임의 getter메소드
	 * @return 판매자 닉네임
	 */
	public String getSellNickname() {
		return sellNickname;
	}
	/**
	 * 판매자 닉네임의 setter메소드
	 * @param sellNickname 판매자 닉네임
	 */
	public void setSellNickname(String sellNickname) {
		this.sellNickname = sellNickname;
	}
	/**
	 * 상태의 getter메소드
	 * @return 상태
	 */
	public String getState() {
		return state;
	}
	/**
	 * 상태의 setter메소드
	 * @param state 상태
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * 이미지경로의 getter메소드
	 * @return 이미지경로
	 */
	public String getImagePath() {
		return imagePath;
	}
	/**
	 * 이미지경로의 setter메소드
	 * @param imagePath 이미지경로
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	/**
	 * 작성일의 getter메소드
	 * @return 작성일
	 */
	public Date getWriteDate() {
		return writeDate;
	}
	/**
	 * 작성일의 setter메소드
	 * @param writeDate 작성일
	 */
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	/**
	 * 거래방식의 getter메소드
	 * @return 거래방식
	 */
	public String getTradeMode() {
		return tradeMode;
	}
	/**
	 * 거래방식의 setter메소드
	 * @param tradeMode 거래방식
	 */
	public void setTradeMode(String tradeMode) {
		this.tradeMode = tradeMode;
	}
	/**
	 * 가격의 getter메소드
	 * @return 가격
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * 가격의 setter메소드
	 * @param price 가격
	 */
	public void setPrice(int price) {
		this.price = price;
	}

}
