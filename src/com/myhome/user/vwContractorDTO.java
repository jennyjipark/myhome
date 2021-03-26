package com.myhome.user;

/**
 * vwContractor(중개인) 객체
 * @author 이준오
 *
 */
public class vwContractorDTO {
	private int seqContractor;
	private String contractorName;
	private String companyNumber;
	private String address;
	private String phoneNumber;
	private String name;
	private int reportCount;
	
	
	/**
	 * 중개사번호의 getter메소드
	 * @return 중개사번호
	 */
	public int getSeqContractor() {
		return seqContractor;
	}
	/**
	 * 중개사번호의 setter메소드
	 * @param seqContractor 중개사번호
	 */
	public void setSeqContractor(int seqContractor) {
		this.seqContractor = seqContractor;
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
	 * 사업자등록번호의 getter메소드
	 * @return 사업자등록번호
	 */
	public String getCompanyNumber() {
		return companyNumber;
	}
	/**
	 * 사업자등록번호의 setter메소드
	 * @param companyNumber 사업자등록번호
	 */
	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}
	/**
	 * 주소의 getter메소드
	 * @return 주소
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 주소의 setter메소드
	 * @param address 주소
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 전화번호의 getter메소드
	 * @return 전화번호
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * 전화번호의 setter메소드
	 * @param phoneNumber 전화번호
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * 신고누적횟수의 getter메소드
	 * @return 신고누적횟수
	 */
	public int getReportCount() {
		return reportCount;
	}
	/**
	 * 신고누적횟수의 setter메소드
	 * @param reportCount 신고누적횟수
	 */
	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
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
	
}
