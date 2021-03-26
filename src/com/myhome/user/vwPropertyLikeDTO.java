package com.myhome.user;

/**
 * 찜목록(매물) 객체
 * @author 이준오
 *
 */
public class vwPropertyLikeDTO {
	private int seqUser;
	private String imagePath;
	private int state;
	private int deposit;		//보증금
	private int monthlyRent;	//월세가격
	private int dealing;		//매매가격
	private String roomtype;
	private int spacing;		//평수
	private String floor;
	
	private String location;
	private int seqContractorProperty;
	
	
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
	 * 이미지경로의 getter메소드
	 * @return 이미지경로
	 */
	public String getImagePath() {
		return imagePath;
	}
	/**
	 * 이미지경로의 setter메소드
	 * @param imagePath 이미지경로
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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
	 * 방의형태의 getter메소드
	 * @return 방의형태
	 */
	public String getRoomtype() {
		return roomtype;
	}
	/**
	 * 방의형태의 setter메소드
	 * @param roomtype 방의형태
	 */
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	/**
	 * 평수의 getter메소드
	 * @return 평수
	 */
	public int getSpacing() {
		return spacing;
	}
	/**
	 * 평수의 setter메소드
	 * @param spacing 평수
	 */
	public void setSpacing(int spacing) {
		this.spacing = spacing;
	}
	/**
	 * 층수의 getter메소드
	 * @return 층수
	 */
	public String getFloor() {
		return floor; 
	}
	/**
	 * 층수의 setter메소드
	 * @param floor 층수
	 */
	public void setFloor(String floor) {
		this.floor = floor;
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
	 * 중개인 매물 번호의 getter메소드
	 * @return 중개인 매물 번호
	 */
	public int getSeqContractorProperty() {
		return seqContractorProperty;
	}
	/**
	 * 중개인 매물 번호의 setter메소드
	 * @param seqContractorProperty 중개인 매물 번호
	 */
	public void setSeqContractorProperty(int seqContractorProperty) {
		this.seqContractorProperty = seqContractorProperty;
	}
	
}