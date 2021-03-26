package com.myhome.user;

/**
 * 임대인 매물 객체입니다.
 * @author 이준오
 *
 */
public class LessorPropertyDTO {
	private int seqLessorProperty;
	private int seqProperty;
	private int seqUser;
	private int state;
	
	/**
	 * 임대인 매물번호 getter메소드
	 * @return 임대인 매물번호
	 */
	public int getSeqLessorProperty() {
		return seqLessorProperty;
	}
	/**
	 * 임대인 매물번호 setter메소드
	 * @param seqLessorProperty 임대인 매물번호
	 */
	public void setSeqLessorProperty(int seqLessorProperty) {
		this.seqLessorProperty = seqLessorProperty;
	}
	/**
	 * 매물번호 getter메소드
	 * @return 매물번호
	 */
	public int getSeqProperty() {
		return seqProperty;
	}
	/**
	 * 매물번호 setter메소드
	 * @param seqProperty 매물번호
	 */
	public void setSeqProperty(int seqProperty) {
		this.seqProperty = seqProperty;
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
	
	/**
	 * 매물 매칭상태  getter메소드
	 * @return 매물 매칭상태
	 */
	public int getState() {
		return state;
	}
	
	/**
	 * 매물 매칭상태 setter메소드
	 * @param state 매물 매칭상태
	 */
	public void setState(int state) {
		this.state = state;
	}
	
}
