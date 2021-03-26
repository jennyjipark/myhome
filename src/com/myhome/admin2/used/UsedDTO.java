package com.myhome.admin2.used;


/**
 * 중고 장터 DB처리 DTO 클래스 
 * @author 이대홍
 *
 */
public class UsedDTO {
//vwUsed
 
    private String seqUsed;
    private String seqUser;
    private String id;
    private String type;
    private String title;
    private String content;
    private String seqImage;
    private String state;
    private String writeDate;
    private String price;
    private String tradeMode;
    private String count;
    
	public String getCount() {
		return count;
	}
	
	public void setCount(String count) {
		this.count = count;
	}
	public String getSeqUsed() {
		return seqUsed;
	}
	public void setSeqUsed(String seqUsed) {
		this.seqUsed = seqUsed;
	}
	public String getSeqUser() {
		return seqUser;
	}
	public void setSeqUser(String seqUser) {
		this.seqUser = seqUser;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getSeqImage() {
		return seqImage;
	}
	public void setSeqImage(String seqImage) {
		this.seqImage = seqImage;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTradeMode() {
		return tradeMode;
	}
	public void setTradeMode(String tradeMode) {
		this.tradeMode = tradeMode;
	}
    
}
