package com.myhome.user;

import java.util.Date;

/**
 * 매물목록 객체
 * @author 이준오
 *
 */
public class MypageOrderlistDTO {

	private int seqContract;
	private int seqUser;
	private int seqContractorProperty;
	private String title;
	private String name;
	private String contractorName;
	private Date contractDate;
	private int seqContractorReview;
	private int seqPropertyReview;
	
	
	/**
	 * 전자계약서번호의 getter메소드
	 * @return 전자계약서번호
	 */
	public int getSeqContract() {
		return seqContract;
	}
	/**
	 * 전자계약서번호의 setter메소드
	 * @param seqContract 전자계약서번호
	 */
	public void setSeqContract(int seqContract) {
		this.seqContract = seqContract;
	}
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
	 * 중개인매물번호의 getter메소드
	 * @return 중개인매물번호
	 */
	public int getSeqContractorProperty() {
		return seqContractorProperty;
	}
	/**
	 * 중개인매물번호의 setter메소드
	 * @param seqContractorProperty 중개인매물번호
	 */
	public void setSeqContractorProperty(int seqContractorProperty) {
		this.seqContractorProperty = seqContractorProperty;
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
	 * 이름의 getter메소드
	 * @return 이름
	 */
	public String getName() {
		return name;
	}
	/**
	 * 이름의 setter메소드
	 * @param name 이름
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 중개사이름의 getter메소드
	 * @return 중개사이름
	 */
	public String getContractorName() {
		return contractorName;
	}
	/**
	 * 중개사이름의 setter메소드
	 * @param contractorName 중개사이름
	 */
	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}
	/**
	 * 계약일의 getter메소드
	 * @return 계약일
	 */
	public Date getContractDate() {
		return contractDate;
	}
	/**
	 * 계약일의 setter메소드
	 * @param contractDate 계약일
	 */
	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}
	/**
	 * 중개인리뷰번호의 getter메소드
	 * @return 중개인리뷰번호
	 */
	public int getSeqContractorReview() {
		return seqContractorReview;
	}
	/**
	 * 중개인리뷰번호의 setter메소드
	 * @param seqContractorReview 중개인리뷰번호
	 */
	public void setSeqContractorReview(int seqContractorReview) {
		this.seqContractorReview = seqContractorReview;
	}
	/**
	 * 매물리뷰번호의 getter메소드
	 * @return 매물리뷰번호
	 */
	public int getSeqPropertyReview() {
		return seqPropertyReview;
	}
	/**
	 * 매물리뷰번호의 setter메소드
	 * @param seqPropertyReview 매물리뷰번호
	 */
	public void setSeqPropertyReview(int seqPropertyReview) {
		this.seqPropertyReview = seqPropertyReview;
	}
	
	
}
