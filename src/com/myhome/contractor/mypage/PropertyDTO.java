package com.myhome.contractor.mypage;

/**
 * 
 *@ 중개인 & 임대인 전체매물 DTO
 *매칭여부 확인 가능 
 *
 **/
public class PropertyDTO {
		
		//매물 seq
		private int seqProperty; //모든 매물
		private int seqLessorProperty; //임대인매물
		private int seqContractorProperty; //중개인매물
		
		//중개인 정보
		private String companyName;	//중개사무소명		
		private String tel;	//전화번호
		private String name;	//중개인명
		private String businessNum; //사업자번호
		private String addressC; //중개사무소 주소
		
		//임대인 정보
		private int seqLessor; //임대인 번호
		private String nameL; //임대인 이름
		private String nickname;
		
		//매칭여부
		private String response; //매칭여부
		private String requester; //매칭신청 한 사람
		
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
		private int internet;
		private int cable; //방옵션 tv와 겹침 
		private int cleaning;
		private int water;
		private int gas;
		private int electric;
		private String serviceCharge;
		
		//4. 건물옵션
		private int parking;
		private int elevator;
		private int pet;
		private int window;
		private String floor; //층
		
		//5. 방옵션 12개
		private int airconditional;
		private int washer;
		private int bed;
		private int desk;
		private int closet;
		private int tv;
		private int shoebox;
		private int refrigerator;
		private int stove;
		private int induction;
		private int microwave;
		private int bidet;
		
		//6. 지역 
		private String location;
		
		//7. 이미지
		private String path;
		
		//8. 최종넣기
		private int seqContractor;
		private String occupancyDate;
		private String title;
		private String content;
		
		
		//입주가능 or 계약완료
		private String available;
		
		
		//getter & setter
		
		//매물 시퀀스
		public int getSeqProperty() {
			return seqProperty;
		}
		public void setSeqProperty(int seqProperty) {
			this.seqProperty = seqProperty;
		}
		
		public int getSeqLessorProperty() {
			return seqLessorProperty;
		}
		public void setSeqLessorProperty(int seqLessorProperty) {
			this.seqLessorProperty = seqLessorProperty;
		}
		
		public int getSeqContractorProperty() {
			return seqContractorProperty;
		}
		public void setSeqContractorProperty(int seqContractorProperty) {
			this.seqContractorProperty = seqContractorProperty;
		}
		
		//1. 방옵션
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
		
		//2. 계약형태
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
		
		//3. 관리비
		public int getInternet() {
			return internet;
		}
		public void setInternet(int internet) {
			this.internet = internet;
		}
		public int getCable() {
			return cable;
		}
		public void setCable(int cable) {
			this.cable = cable;
		}
		public int getCleaning() {
			return cleaning;
		}
		public void setCleaning(int cleaning) {
			this.cleaning = cleaning;
		}
		public int getWater() {
			return water;
		}
		public void setWater(int water) {
			this.water = water;
		}
		public int getGas() {
			return gas;
		}
		public void setGas(int gas) {
			this.gas = gas;
		}
		public int getElectric() {
			return electric;
		}
		public void setElectric(int electric) {
			this.electric = electric;
		}
		public String getServiceCharge() {
			return serviceCharge;
		}
		public void setServiceCharge(String serviceCharge) {
			this.serviceCharge = serviceCharge;
		}
		
		//4. 건물옵션
		public int getParking() {
			return parking;
		}
		public void setParking(int parking) {
			this.parking = parking;
		}
		public int getElevator() {
			return elevator;
		}
		public void setElevator(int elevator) {
			this.elevator = elevator;
		}
		public int getPet() {
			return pet;
		}
		public void setPet(int pet) {
			this.pet = pet;
		}
		public int getWindow() {
			return window;
		}
		public void setWindow(int window) {
			this.window = window;
		}
		public String getFloor() {
			return floor;
		}
		public void setFloor(String floor) {
			this.floor = floor;
		}
		
		//5. 방옵션
		public int getAirconditional() {
			return airconditional;
		}
		public void setAirconditional(int airconditional) {
			this.airconditional = airconditional;
		}
		public int getWasher() {
			return washer;
		}
		public void setWasher(int washer) {
			this.washer = washer;
		}
		public int getBed() {
			return bed;
		}
		public void setBed(int bed) {
			this.bed = bed;
		}
		public int getDesk() {
			return desk;
		}
		public void setDesk(int desk) {
			this.desk = desk;
		}
		public int getCloset() {
			return closet;
		}
		public void setCloset(int closet) {
			this.closet = closet;
		}
		public int getTv() {
			return tv;
		}
		public void setTv(int tv) {
			this.tv = tv;
		}
		public int getShoebox() {
			return shoebox;
		}
		public void setShoebox(int shoebox) {
			this.shoebox = shoebox;
		}
		public int getRefrigerator() {
			return refrigerator;
		}
		public void setRefrigerator(int refrigerator) {
			this.refrigerator = refrigerator;
		}
		public int getStove() {
			return stove;
		}
		public void setStove(int stove) {
			this.stove = stove;
		}
		public int getInduction() {
			return induction;
		}
		public void setInduction(int induction) {
			this.induction = induction;
		}
		public int getMicrowave() {
			return microwave;
		}
		public void setMicrowave(int microwave) {
			this.microwave = microwave;
		}
		public int getBidet() {
			return bidet;
		}
		public void setBidet(int bidet) {
			this.bidet = bidet;
		}
		
		//6. 지역
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		
		//7. 이미지
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
		
		//8. 최종넣기
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
		
		//입주가능 or 계약완료
		public String getAvailable() {
			return available;
		}
		public void setAvailable(String available) {
			this.available = available;
		}
	
		
		//중개인 정보
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		//매칭
		public String getRequester() {
			return requester;
		}
		public void setRequester(String requester) {
			this.requester = requester;
		}
		public String getResponse() {
			return response;
		}
		public void setResponse(String response) {
			this.response = response;
		}
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		public String getNameL() {
			return nameL;
		}
		public void setNameL(String nameL) {
			this.nameL = nameL;
		}
		public int getSeqLessor() {
			return seqLessor;
		}
		public void setSeqLessor(int seqLessor) {
			this.seqLessor = seqLessor;
		}
		public String getBusinessNum() {
			return businessNum;
		}
		public void setBusinessNum(String businessNum) {
			this.businessNum = businessNum;
		}
		public String getAddressC() {
			return addressC;
		}
		public void setAddressC(String addressC) {
			this.addressC = addressC;
		}
	
		
		
		
		
		
		
		
		
	}


