package com.myhome.user;

import java.util.Date;

/**
 * 매물 객체
 * @author 이준오
 *
 */
public class PropertyDTO {
	private int seqProperty;
	private int seqPropertyContractType;
	private int seqPropertyRoomOption;
	private int seqPropertyBuildingOption;
	private int seqLocation;
	private int seqMaintenanceOption;
	private int seqPropertyRoomType;
	private int seqImage;
	private String occupancyDate;
	private String floor;
	private String title;
	private String content;
	
	
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
	 * 계약종류의 getter메소드
	 * @return 계약종류
	 */
	public int getSeqPropertyContractType() {
		return seqPropertyContractType;
	}
	/**
	 * 계약종류의 setter메소드
	 * @param seqPropertyContractType 계약종류
	 */
	public void setSeqPropertyContractType(int seqPropertyContractType) {
		this.seqPropertyContractType = seqPropertyContractType;
	}
	/**
	 * 방옵션의 setter메소드
	 * @return 방옵션
	 */
	public int getSeqPropertyRoomOption() {
		return seqPropertyRoomOption;
	}
	/**
	 * 방옵션의 setter메소드
	 * @param seqPropertyRoomOption 방옵션
	 */
	public void setSeqPropertyRoomOption(int seqPropertyRoomOption) {
		this.seqPropertyRoomOption = seqPropertyRoomOption;
	}
	/**
	 * 건물옵션의 getter메소드
	 * @return 건물옵션
	 */
	public int getSeqPropertyBuildingOption() {
		return seqPropertyBuildingOption;
	}
	/**
	 * 건물옵션의 setter메소드
	 * @param seqPropertyBuildingOption 건물옵션
	 */
	public void setSeqPropertyBuildingOption(int seqPropertyBuildingOption) {
		this.seqPropertyBuildingOption = seqPropertyBuildingOption;
	}
	/**
	 * 지역정보번호의 getter메소드
	 * @return 지역정보번호
	 */
	public int getSeqLocation() {
		return seqLocation;
	}
	/**
	 * 지역정보번호의 setter메소드
	 * @param seqLocation 지역정보번호
	 */
	public void setSeqLocation(int seqLocation) {
		this.seqLocation = seqLocation;
	}
	/**
	 * 관리비옵션의 getter메소드
	 * @return 관리비옵션
	 */
	public int getSeqMaintenanceOption() {
		return seqMaintenanceOption;
	}
	/**
	 * 관리비옵션의 setter메소드
	 * @param seqMaintenanceOption 관리비옵션
	 */
	public void setSeqMaintenanceOption(int seqMaintenanceOption) {
		this.seqMaintenanceOption = seqMaintenanceOption;
	}
	/**
	 * 방의형태의 getter메소드
	 * @return 방의형태
	 */
	public int getSeqPropertyRoomType() {
		return seqPropertyRoomType;
	}
	/**
	 * 방의형태의 setter메소드
	 * @param seqPropertyRoomType 방의형태
	 */
	public void setSeqPropertyRoomType(int seqPropertyRoomType) {
		this.seqPropertyRoomType = seqPropertyRoomType;
	}
	/**
	 * 이미지번호의 getter메소드
	 * @return 이미지번호
	 */
	public int getSeqImage() {
		return seqImage;
	}
	/**
	 * 이미지번호의 setter메소드
	 * @param seqImage 이미지번호
	 */
	public void setSeqImage(int seqImage) {
		this.seqImage = seqImage;
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
	 * 내용본문의 getter메소드
	 * @return 내용본문
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 내용본문의 setter메소드
	 * @param content 내용본문
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 입주가능일의 getter메소드
	 * @return 입주가능일
	 */
	public String getOccupancyDate() {
		return occupancyDate;
	}
	/**
	 * 입주가능일의 setter메소드
	 * @param occupancyDate 입주가능일
	 */
	public void setOccupancyDate(String occupancyDate) {
		this.occupancyDate = occupancyDate;
	}
	
	
}
