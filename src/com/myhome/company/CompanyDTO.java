package com.myhome.company;

public class CompanyDTO {

	private int seq;		//회사번호
    private int seqLocation;	//회사지역번호
    private String location;	//회사지역
    private String name;		//회사이름
    private String imagePath;	//회사사진주소
    private int price;			//이용금액
    private int avgRating;		//평점
    
	private String tel;			//전화번호
    private String introduce;	//소개
    
    private String businessnum; //사업자번호
    
    public String getBusinessnum() {
		return businessnum;
	}
	public void setBusinessnum(String businessnum) {
		this.businessnum = businessnum;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
    
    public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getSeqLocation() {
		return seqLocation;
	}
	public void setSeqLocation(int seqLocation) {
		this.seqLocation = seqLocation;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(int avgRating) {
		this.avgRating = avgRating;
	}
    
    
}
