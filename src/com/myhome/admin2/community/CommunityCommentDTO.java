package com.myhome.admin2.community;
/**
 * 정보공유게시판 댓글 DTO
 * @author 이대홍
 */
public class CommunityCommentDTO {
   
	private String seqCommunityComment;
	private String seqCommunity;
    private String seqUser;
    private String id;
    private String content;
    private String writeDate;
	public String getSeqCommunityComment() {
		return seqCommunityComment;
	}
	public void setSeqCommunityComment(String seqCommunityComment) {
		this.seqCommunityComment = seqCommunityComment;
	}
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

}
