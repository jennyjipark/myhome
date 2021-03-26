package com.myhome.admin.moveclean;

/***
 * 청소업체 DTO입니다. 
 * @author 윤지현
 *
 */
public class CleanDTO {
	
	private String seq;
	private String location;
	private String image;
	private String name;
	private String tel;
	private String address;
	private String businessnum;
	private String price;
	private String introduce;
	private String rating;
	
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBusinessnum() {
		return businessnum;
	}
	public void setBusinessnum(String businessnum) {
		this.businessnum = businessnum;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	
	

}
