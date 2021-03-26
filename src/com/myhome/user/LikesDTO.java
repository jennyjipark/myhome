package com.myhome.user;

/**
 * 찜목록 객체 입니다.
 * @author 이준오
 *
 */
public class LikesDTO {
	private int seqLikes;
	private int seqUsed;
	private int seqContractorProperty;
	private int seqUser;
	
	
	/**
	 * 찜목록 번호 getter메소드
	 * @return 찜목록 번호
	 */
	public int getSeqLikes() {
		return seqLikes;
	}
	/**
	 * 찜목록 번호 setter 메소드
	 * @param seqLikes 찜목록 번호
	 */
	public void setSeqLikes(int seqLikes) {
		this.seqLikes = seqLikes;
	}
	/**
	 * 중고장터 게시물 번호 getter메소드
	 * @return 중고장터 게시물 번호
	 */
	public int getSeqUsed() {
		return seqUsed;
	}
	/**
	 * 중고장터 게시물 번호 setter메소드
	 * @param seqUsed 중고장터 게시물 번호
	 */
	public void setSeqUsed(int seqUsed) {
		this.seqUsed = seqUsed;
	}
	
	/**
	 * 중개인 매물 번호 getter메소드
	 * @return 중개인 매물 번호
	 */
	public int getSeqContractorProperty() {
		return seqContractorProperty;
	}
	/**
	 * 중개인 매물 번호 setter메소드 
	 * @param seqContractorProperty 중개인 매물 번호
	 */
	public void setSeqContractorProperty(int seqContractorProperty) {
		this.seqContractorProperty = seqContractorProperty;
	}
	/**
	 * 회원번호 getter메소드
	 * @return 회원번호
	 */
	public int getSeqUser() {
		return seqUser;
	}
	/**
	 * 회원번호 setter메소드 
	 * @param seqUser 회원번호
	 */
	public void setSeqUser(int seqUser) {
		this.seqUser = seqUser;
	}
	
}
