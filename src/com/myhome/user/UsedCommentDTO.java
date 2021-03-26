package com.myhome.user;

import java.util.Date;


/**
 * 중고장터 댓글 객체
 * @author 이준오
 *
 */
public class UsedCommentDTO {
	
	private int seqUsedComment;
	private String nickname;
	private int seqUsed;
	private String content;
	private Date writeDate;
	
	private int seqUser;
	
	
	/**
	 * 중고장터 댓글 번호의 getter메소드
	 * @return 중고장터 댓글 번호
	 */
	public int getSeqUsedComment() {
		return seqUsedComment;
	}
	/**
	 * 중고장터 댓글 번호의 setter메소드
	 * @param seqUsedComment 중고장터 댓글 번호
	 */
	public void setSeqUsedComment(int seqUsedComment) {
		this.seqUsedComment = seqUsedComment;
	}
	
	/**
	 * 중고장터 게시글 번호의 getter메소드
	 * @return 중고장터 게시글 번호
	 */
	public int getSeqUsed() {
		return seqUsed;
	}
	/**
	 * 중고장터 게시글 번호의 setter메소드
	 * @param seqUsed 중고장터 게시글 번호
	 */
	public void setSeqUsed(int seqUsed) {
		this.seqUsed = seqUsed;
	}
	/**
	 * 본문내용의 getter메소드
	 * @return 본문내용
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 본문내용의 setter메소드
	 * @param content 본문내용
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 작성일의 getter메소드
	 * @return 작성일 
	 */
	public Date getWriteDate() {
		return writeDate;
	}
	/**
	 * 작성일의 setter메소드
	 * @param writeDate 작성일
	 */
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	/**
	 * 닉네임의 getter메소드
	 * @return 닉네임
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 닉네임의 setter메소드
	 * @param nickname 닉네임
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
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
	
	
}
