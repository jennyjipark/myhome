package com.myhome.admin2.qna;


/**
 * QNA게시글 관련 DB작업 DTO 클래스 
 * @author 이대홍
 *
 */
public class QnaDTO {

/*
 *    Qa.SeqQna ,  
    Qa.SeqUser,
    Au.id,
    qa.seqqnaType as type,
    Qa.Title,
    Qa.Content,
    Qa.Writedate,
    case 
    when Qc.Count = 0 
        then '처리중'
    else '완료'
    end as state 
 * 
 */
	private String seqQna;
	private String SeqUser;
	private String id;
	private String type;
	private String title;
	private String content;
	private String state;
	private String writeDate;
	
	
	
	public String getSeqQna() {
		return seqQna;
	}
	public void setSeqQna(String seqQna) {
		this.seqQna = seqQna;
	}
	public String getSeqUser() {
		return SeqUser;
	}
	public void setSeqUser(String seqUser) {
		SeqUser = seqUser;
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
	
	
}

