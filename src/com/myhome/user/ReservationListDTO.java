package com.myhome.user;

import java.util.Date;

/**
 * 예약목록 객체
 * @author 이준오
 *
 */
public class ReservationListDTO {

	private int seqUser;
	private String name;
	private Date reservationDate;
	private int price;
	
	private int seqCleanReservation;
	private int seqClean;
	private int seqCleanReview;
	
	
	private int seqMoveReservation;
	private int seqMove;
	private int seqMoveReview;
	
	
	
	/**
	 * 청소업체 리뷰번호의 getter메소드
	 * @return 청소업체 리뷰번호
	 */
	public int getSeqCleanReview() {
		return seqCleanReview;
	}
	/**
	 * 청소업체 리뷰번호의 setter메소드
	 * @param seqCleanReview 청소업체 리뷰번호
	 */
	public void setSeqCleanReview(int seqCleanReview) {
		this.seqCleanReview = seqCleanReview;
	}
	/**
	 * 이사업체 리뷰번호의 getter메소드
	 * @return 이사업체 리뷰번호
	 */
	public int getSeqMoveReview() {
		return seqMoveReview;
	}
	/**
	 * 이사업체 리뷰번호의 setter메소드
	 * @param seqMoveReview 이사업체 리뷰번호
	 */
	public void setSeqMoveReview(int seqMoveReview) {
		this.seqMoveReview = seqMoveReview;
	}
	/**
	 * 청소업체 예약번호의 getter메소드
	 * @return 청소업체 예약번호
	 */
	public int getSeqCleanReservation() {
		return seqCleanReservation;
	}
	/**
	 * 청소업체 예약번호의 setter메소드
	 * @param seqCleanReservation 청소업체 예약번호
	 */
	public void setSeqCleanReservation(int seqCleanReservation) {
		this.seqCleanReservation = seqCleanReservation;
	}
	/**
	 * 청소업체번호의 getter메소드
	 * @return 청소업체번호
	 */
	public int getSeqClean() {
		return seqClean;
	}
	/**
	 * 청소업체번호의 setter메소드
	 * @param seqClean 청소업체번호
	 */
	public void setSeqClean(int seqClean) {
		this.seqClean = seqClean;
	}
	/**
	 * 이사업체 예약번호의 getter메소드
	 * @return 이사업체 예약번호
	 */
	public int getSeqMoveReservation() {
		return seqMoveReservation;
	}
	/**
	 * 이사업체 예약번호의 setter메소드
	 * @param seqMoveReservation 이사업체 예약번호
	 */
	public void setSeqMoveReservation(int seqMoveReservation) {
		this.seqMoveReservation = seqMoveReservation;
	}
	/**
	 * 이사업체번호의 getter메소드
	 * @return 이사업체번호
	 */
	public int getSeqMove() {
		return seqMove;
	}
	/**
	 * 이사업체번호의 setter메소드
	 * @param seqMove 이사업체번호
	 */
	public void setSeqMove(int seqMove) {
		this.seqMove = seqMove;
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
	 * 예약일의 getter메소드
	 * @return 예약일
	 */
	public Date getReservationDate() {
		return reservationDate;
	}
	/**
	 * 예약일의 setter메소드
	 * @param reservationDate 예약일
	 */
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
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
