package com.myhome.user;

/**
 * 매칭요청 객체
 * @author 이준오
 *
 */
public class MatchingDTO {
	private int seqMatching;
	private int seqLessorProperty;
	private int seqContractor;
	private String requestor;
	private String response;
	
	/**
	 * 매칭요청번호 getter메소드
	 * @return 매칭요청번호
	 */
	public int getSeqMatching() {
		return seqMatching;
	}
	/**
	 * 매칭요청번호 setter메소드
	 * @param seqMatching 매칭요청번호
	 */
	public void setSeqMatching(int seqMatching) {
		this.seqMatching = seqMatching;
	}
	/**
	 * 임대인 매물 번호 getter메소드
	 * @return 임대인 매물 번호
	 */
	public int getSeqLessorProperty() {
		return seqLessorProperty;
	}
	/**
	 * 임대인 매물 번호 setter메소드
	 * @param seqLessorProperty 임대인 매물 번호
	 */
	public void setSeqLessorProperty(int seqLessorProperty) {
		this.seqLessorProperty = seqLessorProperty;
	}
	/**
	 * 임대인 번호 getter메소드
	 * @return 임대인 번호
	 */
	public int getSeqContractor() {
		return seqContractor;
	}
	/**
	 * 임대인 번호 setter메소드
	 * @param seqContractor 임대인 번호
	 */
	public void setSeqContractor(int seqContractor) {
		this.seqContractor = seqContractor;
	}
	/**
	 * 요청자 getter메소드
	 * @return 요청자
	 */
	public String getRequestor() {
		return requestor;
	}
	/**
	 * 요청자 setter메소드
	 * @param requestor 요청자
	 */
	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}
	/**
	 * 응답내용 getter메소드
	 * @return 응답내용
	 */
	public String getResponse() {
		return response;
	}
	/**
	 * 응답내용 getter메소드
	 * @param response 응답내용
	 */
	public void setResponse(String response) {
		this.response = response;
	}
	
	
	
}
