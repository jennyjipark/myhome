package com.myhome.user;

/**
 * 회원 객체
 * @author 이준오 
 *
 */
public class UserDTO {

	private int seqAllUser;
	private String id;
	private String name;
	private String password;
	private String email;
	private String nickname;
	private int state;
	private String phonenumber;
	private String address;

	private String idNumber;

	// user mypageinfo.do 에 사용
	private String interestroomtype;
	private String interestlocation;
	private int alarm;
	private int seqLocation;
	private int seqPropertyRoomtypeDetail;

	//---------------------------------------------------------------
	
	
	/**
	 * 관심매물유형의 getter메소드
	 * @return 관심매물유형
	 */
	public String getInterestroomtype() {
		return interestroomtype;
	}

	/**
	 * 관심매물유형의 setter메소드
	 * @param interestroomtype 관심매물유형
	 */
	public void setInterestroomtype(String interestroomtype) {
		this.interestroomtype = interestroomtype;
	}

	/**
	 * 관심지역의 getter메소드
	 * @return 관심지역
	 */
	public String getInterestlocation() {
		return interestlocation;
	}

	/**
	 * 관심지역의 setter메소드
	 * @param interestlocation 관심지역
	 */
	public void setInterestlocation(String interestlocation) {
		this.interestlocation = interestlocation;
	}

	/**
	 * 매물알림의 getter메소드
	 * @return 매물알림
	 */
	public int getAlarm() {
		return alarm;
	}

	/**
	 * 매물알림의 setter메소드
	 * @param alarm 매물알림
	 */
	public void setAlarm(int alarm) {
		this.alarm = alarm;
	}

	/**
	 * 지역정보 번호의 getter메소드
	 * @return 지역정보 번호
	 */
	public int getSeqLocation() {
		return seqLocation;
	}

	/**
	 * 지역정보 번호의 setter메소드
	 * @param seqLocation 지역정보 번호
	 */
	public void setSeqLocation(int seqLocation) {
		this.seqLocation = seqLocation;
	}

	/**
	 * 방의형태 번호의 getter메소드
	 * @return 방의형태 번호
	 */
	public int getSeqPropertyRoomtypeDetail() {
		return seqPropertyRoomtypeDetail;
	}

	/**
	 * 방의형태 번호의 setter메소드
	 * @param seqPropertyRoomtypeDetail 방의형태 번호
	 */
	public void setSeqPropertyRoomtypeDetail(int seqPropertyRoomtypeDetail) {
		this.seqPropertyRoomtypeDetail = seqPropertyRoomtypeDetail;
	}


	/**
	 * 주민등록번호의 getter메소드
	 * @return 주민등록번호
	 */
	public String getIdNumber() {
		return idNumber;
	}

	/**
	 * 주민등록번호의 setter메소드
	 * @param idNumber 주민등록번호
	 */
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	/**
	 * 회원번호의 getter메소드
	 * @return 회원번호
	 */
	public int getSeqAllUser() {
		return seqAllUser;
	}

	/**
	 * 회원번호의 setter메소드
	 * @param seqAllUser 회원번호
	 */
	public void setSeqAllUser(int seqAllUser) {
		this.seqAllUser = seqAllUser;
	}

	/**
	 * 아이디의 getter메소드
	 * @return 아이디
	 */
	public String getId() {
		return id;
	}

	/**
	 * 아이디의 setter메소드
	 * @param id 아이디
	 */
	public void setId(String id) {
		this.id = id;
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
	 * 비밀번호의 getter메소드
	 * @return 비밀번호
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 비밀번호의 setter메소드
	 * @param password 비밀번호
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 이메일의 getter메소드
	 * @return 이메일
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 이메일의 setter메소드
	 * @param email 이메일
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 닉네임의 getter메소드
	 * @return 닉네임
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * 닉네임의 setter메소드
	 * @param nickname 닉네임
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * 상태의 getter메소드 
	 * @return 상태
	 */
	public int getState() {
		return state;
	}

	/**
	 * 상태의 setter메소드
	 * @param state 상태
	 */
	public void setState(int state) {
		this.state = state;
	}

	/**
	 * 전화번호의 getter메소드
	 * @return 전화번호
	 */
	public String getPhonenumber() {
		return phonenumber;
	}

	/**
	 * 전화번호의 setter메소드
	 * @param phonenumber 전화번호
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
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
}
