package com.myhome.admin2.community;


/**
 * 정보공유 게시판 DTO 
 * @author 홍
 */
public class CommunityDTO {
//vwCC
 
    private String seqCommunity;
    private String seqUser;
    private String id;
    private String title;
    private String content;
    private String writeDate;
    private String count;
    private String viewCount;
	public String getSeqCommunity() {
		return seqCommunity;
	}
	public void setSeqCommunity(String seqCommunity) {
		this.seqCommunity = seqCommunity;
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
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getViewCount() {
		return viewCount;
	}
	public void setViewCount(String viewCount) {
		this.viewCount = viewCount;
	}
	
    
}
