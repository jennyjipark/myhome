package com.myhome.contractor.upload;

/**
 * @ author 박지현
 * 중개인 본인 매물 올리기 DTO
 * */
public class UploadContractorDTO {
	
	//1. 방옵션
	private String roomType; //1. 원룸 2. 투룸 3. 오피스텔
	private String spacing;
	
	//2. 계약형태
	private String contractTypeDetail; //1. 월세 2. 전세 3. 매매
	private String deposit;
	private String monthlyRent;
	private String dealing;
	private String contractPeriod;
	
	//3. 관리비
	private String internet;
	private String cable; //방옵션 tv와 겹침 
	private String cleaning;
	private String water;
	private String gas;
	private String electric;
	private String serviceCharge;
	
	//4. 건물옵션
	private String parking;
	private String elevator;
	private String pet;
	private String window;
	
	//5. 방옵션 12개
	private String airconditional;
	private String washer;
	private String bed;
	private String desk;
	private String closet;
	private String tv;
	private String shoebox;
	private String refrigerator;
	private String stove;
	private String induction;
	private String microwave;
	private String bidet;
	
	//6. 지역 
	private String location;
	
	//7. 이미지
	private String path;
	
	
	//8. 최종넣기
	private int seqContractor;
	private String occupancyDate;
	private String title;
	private String content;
	
	
	//getter & setter
	
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getSpacing() {
		return spacing;
	}
	public void setSpacing(String spacing) {
		this.spacing = spacing;
	}
	public String getContractTypeDetail() {
		return contractTypeDetail;
	}
	public void setContractTypeDetail(String contractTypeDetail) {
		this.contractTypeDetail = contractTypeDetail;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getMonthlyRent() {
		return monthlyRent;
	}
	public void setMonthlyRent(String monthlyRent) {
		this.monthlyRent = monthlyRent;
	}
	public String getDealing() {
		return dealing;
	}
	public void setDealing(String dealing) {
		this.dealing = dealing;
	}
	public String getContractPeriod() {
		return contractPeriod;
	}
	public void setContractPeriod(String contractPeriod) {
		this.contractPeriod = contractPeriod;
	}
	public String getInternet() {
		return internet;
	}
	public void setInternet(String internet) {
		this.internet = internet;
	}
	public String getCable() {
		return cable;
	}
	public void setCable(String cable) {
		this.cable = cable;
	}
	public String getCleaning() {
		return cleaning;
	}
	public void setCleaning(String cleaning) {
		this.cleaning = cleaning;
	}
	public String getWater() {
		return water;
	}
	public void setWater(String water) {
		this.water = water;
	}
	public String getGas() {
		return gas;
	}
	public void setGas(String gas) {
		this.gas = gas;
	}
	public String getElectric() {
		return electric;
	}
	public void setElectric(String electric) {
		this.electric = electric;
	}
	public String getServiceCharge() {
		return serviceCharge;
	}
	public void setServiceCharge(String serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	public String getElevator() {
		return elevator;
	}
	public void setElevator(String elevator) {
		this.elevator = elevator;
	}
	public String getPet() {
		return pet;
	}
	public void setPet(String pet) {
		this.pet = pet;
	}
	public String getWindow() {
		return window;
	}
	public void setWindow(String window) {
		this.window = window;
	}
	public String getAirconditional() {
		return airconditional;
	}
	public void setAirconditional(String airconditional) {
		this.airconditional = airconditional;
	}
	public String getWasher() {
		return washer;
	}
	public void setWasher(String washer) {
		this.washer = washer;
	}
	public String getBed() {
		return bed;
	}
	public void setBed(String bed) {
		this.bed = bed;
	}
	public String getDesk() {
		return desk;
	}
	public void setDesk(String desk) {
		this.desk = desk;
	}
	public String getCloset() {
		return closet;
	}
	public void setCloset(String closet) {
		this.closet = closet;
	}
	public String getTv() {
		return tv;
	}
	public void setTv(String tv) {
		this.tv = tv;
	}
	public String getShoebox() {
		return shoebox;
	}
	public void setShoebox(String shoebox) {
		this.shoebox = shoebox;
	}
	public String getRefrigerator() {
		return refrigerator;
	}
	public void setRefrigerator(String refrigerator) {
		this.refrigerator = refrigerator;
	}
	public String getStove() {
		return stove;
	}
	public void setStove(String stove) {
		this.stove = stove;
	}
	public String getInduction() {
		return induction;
	}
	public void setInduction(String induction) {
		this.induction = induction;
	}
	public String getMicrowave() {
		return microwave;
	}
	public void setMicrowave(String microwave) {
		this.microwave = microwave;
	}
	public String getBidet() {
		return bidet;
	}
	public void setBidet(String bidet) {
		this.bidet = bidet;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getSeqContractor() {
		return seqContractor;
	}
	public void setSeqContractor(int seqContractor) {
		this.seqContractor = seqContractor;
	}
	public String getOccupancyDate() {
		return occupancyDate;
	}
	public void setOccupancyDate(String occupancyDate) {
		this.occupancyDate = occupancyDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
