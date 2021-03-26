package com.myhome.user;

import java.util.Date;

/**
 * 전자계약서 객체입니다.
 * @author 이준오
 *
 */
public class MypageContractDTO {

	private int seqContract; //전자계약번호
	private int seqUser; //임대인번호
	private String sellname; //임대인이름 
	private String buyname;	//임차인이름
	private String contractorName; //중개인이름
	private String contractState; //계약상태
	private int seqContractorProperty;
	
	private String contractorSign;	//중개인암호
	private String lessorSign;	//중개인암호
	private String tenantSign;	//중개인암호
	private Date contractDate;	//계약일
	private String contractContent;	//계약내용
	private int bSeqUser;	//임차인번호
	private String bName;	//임차인이름
	private String bPhoneNumber;	//임차인전화번호
	private String bAddress;		//임차인집주소
	private String bIdNumber;		//임차인 주민번호
	
	private String sName;	//임대인이름
	private String sPhoneNumber;	//임대인전화번호
	private String sAddress;		//임대인집주소
	private String sIdNumber;		//임대인 주민번호
	 
	private String cPhoneNumber;	//중개인전화번호
	private String cAddress;		//중개사주소
	private String companyNumber;	//사업자 등록번호
	
	private int deposit;		//보증금
	private int monthlyRent;	//월세
	private int dealing;			//매매가격
	private int contractPeriod;	//계약기간(달)
	
	private String contractType;	//계약종류(월,전세,매매)
	private String location;	//매물주소
	
	/**
	 * 중개인암호의 getter메소드
	 * @return 중개인암호
	 */
	public String getContractorSign() {
		return contractorSign;
	}
	/**
	 * 중개인암호의 setter메소드
	 * @param contractorSign 중개인암호
	 */
	public void setContractorSign(String contractorSign) {
		this.contractorSign = contractorSign;
	}
	/**
	 * 임대인암호의 getter메소드
	 * @return 임대인암호
	 */
	public String getLessorSign() {
		return lessorSign;
	}
	/**
	 * 임대인암호의 setter메소드
	 * @param lessorSign 임대인암호
	 */
	public void setLessorSign(String lessorSign) {
		this.lessorSign = lessorSign;
	}
	/**
	 * 임차인암호의 getter메소드
	 * @return 임차인암호
	 */
	public String getTenantSign() {
		return tenantSign;
	}
	/**
	 * 임차인암호의 setter메소드
	 * @param tenantSign 임차인암호
	 */
	public void setTenantSign(String tenantSign) {
		this.tenantSign = tenantSign;
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
	 * 계약내용의 getter메소드
	 * @return 계약내용
	 */
	public String getContractContent() {
		return contractContent;
	}
	/**
	 * 계약내용의 setter메소드
	 * @param contractContent 계약내용
	 */
	public void setContractContent(String contractContent) {
		this.contractContent = contractContent;
	}
	/**
	 * 임차인번호의 getter메소드
	 * @return 임차인번호
	 */
	public int getbSeqUser() {
		return bSeqUser;
	}
	/**
	 * 임차인번호의 setter메소드
	 * @param bSeqUser 임차인번호
	 */
	public void setbSeqUser(int bSeqUser) {
		this.bSeqUser = bSeqUser;
	}
	/**
	 * 임차인이름의 getter메소드
	 * @return 임차인이름
	 */
	public String getbName() {
		return bName;
	}
	/**
	 * 임차인이름의 setter메소드
	 * @param bName 임차인이름
	 */
	public void setbName(String bName) {
		this.bName = bName;
	}
	/**
	 * 임차인전화번호의 getter메소드
	 * @return 임차인전화번호
	 */
	public String getbPhoneNumber() {
		return bPhoneNumber;
	}
	/**
	 * 임차인전화번호의 setter메소드
	 * @param bPhoneNumber 임차인전화번호
	 */
	public void setbPhoneNumber(String bPhoneNumber) {
		this.bPhoneNumber = bPhoneNumber;
	}
	/**
	 * 임차인주소의 getter메소드
	 * @return 임차인주소
	 */
	public String getbAddress() {
		return bAddress;
	}
	/**
	 * 임차인주소의 setter메소드
	 * @param bAddress 임차인주소
	 */
	public void setbAddress(String bAddress) {
		this.bAddress = bAddress;
	}
	/**
	 * 임차인주민번호의 getter메소드
	 * @return 임차인주민번호
	 */
	public String getbIdNumber() {
		return bIdNumber;
	}
	/**
	 * 임차인주민번호의 setter메소드
	 * @param bIdNumber 임차인주민번호
	 */
	public void setbIdNumber(String bIdNumber) {
		this.bIdNumber = bIdNumber;
	}
	/**
	 * 임대인이름의 getter메소드
	 * @return 임대인이름
	 */
	public String getsName() {
		return sName;
	}
	/**
	 * 임대인이름의 setter메소드
	 * @param sName 임대인이름
	 */
	public void setsName(String sName) {
		this.sName = sName;
	}
	/**
	 * 임대인전화번호의 getter메소드
	 * @return 임대인전화번호
	 */
	public String getsPhoneNumber() {
		return sPhoneNumber;
	}
	/**
	 * 임대인전화번호의 setter메소드
	 * @param sPhoneNumber 임대인전화번호
	 */
	public void setsPhoneNumber(String sPhoneNumber) {
		this.sPhoneNumber = sPhoneNumber;
	}
	/**
	 * 임대인주소의 getter메소드
	 * @return 임대인주소
	 */
	public String getsAddress() {
		return sAddress;
	}
	/**
	 * 임대인주소의 setter메소드
	 * @param sAddress 임대인주소 
	 */
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	/**
	 * 임대인 주민번호의 getter메소드
	 * @return 임대인 주민번호
	 */
	public String getsIdNumber() {
		return sIdNumber;
	}
	/**
	 * 임대인 주민번호의 setter메소드
	 * @param sIdNumber 임대인 주민번호
	 */
	public void setsIdNumber(String sIdNumber) {
		this.sIdNumber = sIdNumber;
	}
	/**
	 * 임대인전화번호의 getter메소드
	 * @return 임대인전화번호
	 */
	public String getcPhoneNumber() {
		return cPhoneNumber;
	}
	/**
	 * 중개인전화번호의 setter메소드
	 * @param cPhoneNumber 중개인전화번호
	 */
	public void setcPhoneNumber(String cPhoneNumber) {
		this.cPhoneNumber = cPhoneNumber;
	}
	/**
	 * 중개사주소의 getter메소드
	 * @return 중개사주소
	 */
	public String getcAddress() {
		return cAddress;
	}
	/**
	 * 중개사주소의 setter메소드
	 * @param cAddress 중개사주소
	 */
	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
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
	 * 보증금의 getter메소드
	 * @return 보증금
	 */
	public int getDeposit() {
		return deposit;
	}
	/**
	 * 보증금의 setter메소드
	 * @param deposit 보증금
	 */
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	/**
	 * 월세의 getter메소드
	 * @return 월세
	 */
	public int getMonthlyRent() {
		return monthlyRent;
	}
	/**
	 * 월세의 setter메소드
	 * @param monthlyRent 월세
	 */
	public void setMonthlyRent(int monthlyRent) {
		this.monthlyRent = monthlyRent;
	}
	/**
	 * 매매가격의 getter메소드
	 * @return 매매가격
	 */
	public int getDealing() {
		return dealing;
	}
	/**
	 * 매매가격의 setter메소드
	 * @param dealing 매매가격
	 */
	public void setDealing(int dealing) {
		this.dealing = dealing;
	}
	/**
	 * 계약기간의 getter메소드
	 * @return 계약기간
	 */
	public int getContractPeriod() {
		return contractPeriod;
	}
	/**
	 * 계약기간의 setter메소드
	 * @param contractPeriod 계약기간
	 */
	public void setContractPeriod(int contractPeriod) {
		this.contractPeriod = contractPeriod;
	}
	/**
	 * 거래방식의 getter메소드
	 * @return 거래방식
	 */
	public String getContractType() {
		return contractType;
	}
	/**
	 * 거래방식의 setter메소드
	 * @param contractType 거래방식
	 */
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	/**
	 * 주소정보의 getter메소드
	 * @return 주소정보
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * 주소정보의 setter메소드
	 * @param location 주소정보
	 */
	public void setLocation(String location) {
		this.location = location;
	}
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
	 * 임대인이름의 getter메소드
	 * @return 임대인이름
	 */
	public String getSellname() {
		return sellname;
	}
	/**
	 * 임대인이름의 setter메소드
	 * @param sellname 임대인이름
	 */
	public void setSellname(String sellname) {
		this.sellname = sellname;
	}
	/**
	 * 임차인이름의 getter메소드
	 * @return 임차인이름
	 */
	public String getBuyname() {
		return buyname;
	}
	/**
	 * 임차인이름의 setter메소드
	 * @param buyname 임차인이름
	 */
	public void setBuyname(String buyname) {
		this.buyname = buyname;
	}
	/**
	 * 중개인 이름의 getter메소드
	 * @return 중개인 이름
	 */
	public String getContractorName() {
		return contractorName;
	}
	/**
	 * 중개인 이름의 setter메소드
	 * @param contractorName 중개인 이름
	 */
	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}
	/**
	 * 매물 계약 상태의 getter 메소드
	 * @return 매물 계약 상태
	 */
	public String getContractState() {
		return contractState;
	}
	/**
	 * 매물 계약 상태의 setter 메소드
	 * @param contractState 매물 계약 상태
	 */
	public void setContractState(String contractState) {
		this.contractState = contractState;
	}
	/**
	 * 중개인 매물번호의 getter메소드
	 * @return
	 */
	public int getSeqContractorProperty() {
		return seqContractorProperty;
	}
	/**
	 * 중개인 매물번호의 setter메소드
	 * @param seqContractorProperty 중개인 매물번호
	 */
	public void setSeqContractorProperty(int seqContractorProperty) {
		this.seqContractorProperty = seqContractorProperty;
	}
	
}
