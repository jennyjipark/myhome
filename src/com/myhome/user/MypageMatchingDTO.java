package com.myhome.user;

/**
 * 매칭요청 객체
 * @author 이준오
 *
 */
public class MypageMatchingDTO {

	private int seqMatching;//매칭 번호
	private int seqUser;//회원 번호
	private int seqProperty;//매물 번호
	private int seqContractor;//중개사 번호
	private int seqLessorProperty;//임대인 매물 번호
	private String title;//글제목
	private String contractorName;	//중개사 이름
	private String name;	//중개인 이름
	private String response;	//매칭응답 내용
	
	private String location; //매물 주소
	
	
	/**
	 * 매칭요청번호의 getter메소드
	 * @return 매칭요청번호
	 */
	public int getSeqMatching() {
		return seqMatching;
	}
	/**
	 * 매칭요청번호의 setter메소드
	 * @param seqMatching 매칭요청번호
	 */
	public void setSeqMatching(int seqMatching) {
		this.seqMatching = seqMatching;
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
	 * 매물번호의 getter메소드
	 * @return 매물번호
	 */
	public int getSeqProperty() {
		return seqProperty;
	}
	/**
	 * 매물번호의 setter메소드
	 * @param seqProperty 매물번호
	 */
	public void setSeqProperty(int seqProperty) {
		this.seqProperty = seqProperty;
	}
	/**
	 * 중개인번호의 getter메소드
	 * @return 중개인번호
	 */
	public int getSeqContractor() {
		return seqContractor;
	}
	/**
	 * 중개인번호의 setter메소드
	 * @param seqContractor 중개인번호
	 */
	public void setSeqContractor(int seqContractor) {
		this.seqContractor = seqContractor;
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
	 * 응답내용의 getter메소드
	 * @return 응답내용
	 */
	public String getResponse() {
		return response;
	}
	/**
	 * 응답내용의 setter메소드
	 * @param response 응답내용
	 */
	public void setResponse(String response) {
		this.response = response;
	}
	/**
	 * 지역정보의 getter메소드
	 * @return 지역정보
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * 지역정보의 setter메소드
	 * @param location 지역정보
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * 임대인매물번호의 getter메소드
	 * @return 임대인매물번호
	 */
	public int getSeqLessorProperty() {
		return seqLessorProperty;
	}
	/**
	 * 임대인매물번호의 setter메소드
	 * @param seqLessorProperty 임대인매물번호
	 */
	public void setSeqLessorProperty(int seqLessorProperty) {
		this.seqLessorProperty = seqLessorProperty;
	}
	
	
}
