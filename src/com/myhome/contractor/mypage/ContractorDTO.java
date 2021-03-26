package com.myhome.contractor.mypage;

/**
 * @author 박지현
 * 중개인 회원정보 DTO
 */
public class ContractorDTO {
	
	private String seq;	//AllUser seq
	private String id;	//아이디
	private String companyName; //공인중개소명
	private String name; //이름
	private String password;	//비밀번호
	
	private String businessNum; //사업자번호
	
	private String email;	//이메일
	private String tel1;	//전화번호
	private String tel2;
	private String tel3;
	
	private String address;	//주소
	
	
	/* ------------------------------------------------------------------- */
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//사업자번호
	public String getBusinessNum() {
		return businessNum;
	}
	public void setBusinessNum(String businessNum) {
		this.businessNum = businessNum;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public String getTel3() {
		return tel3;
	}
	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}
	
	

}
