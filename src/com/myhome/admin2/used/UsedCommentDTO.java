package com.myhome.admin2.used;
/**
 * 중고 장터 댓글 DB업무 DTO 클래스
 * @author 이대홍
 *
 */
public class UsedCommentDTO {


	private String seqUsedComment;
	private String seqUser;
	private String seqUsed;
	private String content;
	private String writeDate;
	private String id;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSeqUsedComment() {
		return seqUsedComment;
	}
	public void setSeqUsedComment(String seqUsedComment) {
		this.seqUsedComment = seqUsedComment;
	}
	public String getSeqUser() {
		return seqUser;
	}
	public void setSeqUser(String seqUser) {
		this.seqUser = seqUser;
	}
	public String getSeqUsed() {
		return seqUsed;
	}
	public void setSeqUsed(String seqUsed) {
		this.seqUsed = seqUsed;
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
