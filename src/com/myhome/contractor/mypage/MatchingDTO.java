package com.myhome.contractor.mypage;

/**
 * @author 박지현
 * 임대인의 매물을 중개인과 매칭하는 DAO
 */
public class MatchingDTO {
	
	//나에게 온 매칭 & 임대인에게 보낸 매칭
	private int seqContractor;
	private int seqProperty;
	private int seqUser; //일반회원번호
	private int seqLessorProperty; //임대인매물번호
	private int matching; //1. 매칭완료 0. 거절 null. 안받은 상태
	private String title;
	private String nickname;
	
	
	//getter & setter
	public int getSeqContractor() {
		return seqContractor;
	}
	public void setSeqContractor(int seqContractor) {
		this.seqContractor = seqContractor;
	}
	public int getSeqProperty() {
		return seqProperty;
	}
	public void setSeqProperty(int seqProperty) {
		this.seqProperty = seqProperty;
	}
	public int getSeqUser() {
		return seqUser;
	}
	public void setSeqUser(int seqUser) {
		this.seqUser = seqUser;
	}
	public int getSeqLessorProperty() {
		return seqLessorProperty;
	}
	public void setSeqLessorProperty(int seqLessorProperty) {
		this.seqLessorProperty = seqLessorProperty;
	}
	public int getMatching() {
		return matching;
	}
	public void setMatching(int matching) {
		this.matching = matching;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	
	
	

}
