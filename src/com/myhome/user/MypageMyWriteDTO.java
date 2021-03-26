package com.myhome.user;

import java.sql.Date;

/**
 * 내가쓴글보기 객체
 * @author 이준오
 *
 */
public class MypageMyWriteDTO {


	//2.1 중고장터(tblUsed), 방올리기(tblLessorProperty), 커뮤니티(tblCommunity)에서 내가 쓴 글 목록 받아오기.
	
	//2.2 /댓글/ 중고장터댓글, 커뮤니티댓글 /후기/ 이삿짐센터후기, 청소업체후기, 중개인후기, 매물후기 에서 내가쓴글 목록 받아오기
	//2.3 /신고/ 중고장터신고, 매물거래신고, 커뮤니티신고  에서 내가 쓴 글 목록 받아오기.
	
	//게시글
	private int seqUser;//회원번호
	
	private int seqUsed;
	private int seqCommunity;
	private int seqProperty;
	
	private String title;
	private String content;
	private Date writeDate;
	private int viewCount; //조회수
	private int count;	//댓글수
	private String state;//계약상태
	
	//댓글,후기
		//댓글
	private int seqCommunityComment;
	private int seqUsedComment;
		//후기
	private int seqContractorReview;
	private int seqPropertyReview;
	private int seqMoveReview;
	private int seqCleanReview;
	private int seqMoveReservation;
	private int seqCleanReservation;
	private int seqContract;
	
	
	private String contractorName;	//중개사이름
	private String ptitle; 	//매물 글 제목
	private String location; // 매물 주소
	private String name;	//업체(이사/청소)이름
	private Date reservationDate;	//업체 예약일
	
	private int rating;		//평점
	
	//신고
	private int seqCommunityReport;
	private int seqUsedReport;
	private int seqPropertyContractReport;
	private int seqConctractorProperty;
	
	private String reason;//신고사유
	private String reportState;//신고처리상태
	
	//----------------------------------------------------------------//
	
	/**
	 * 이사업체 예약번호의 getter메소드
	 * @return 이사업체 예약번호
	 */
	public int getSeqMoveReservation() {
		return seqMoveReservation;
	}
	/**
	 * 이사업체 예약번호의 setter메소드
	 * @param seqMoveReservation 이사업체 예약번호
	 */
	public void setSeqMoveReservation(int seqMoveReservation) {
		this.seqMoveReservation = seqMoveReservation;
	}
	/**
	 * 청소업체 예약번호의 getter메소드
	 * @return 청소업체 예약번호
	 */
	public int getSeqCleanReservation() {
		return seqCleanReservation;
	}
	/**
	 * 청소업체 예약번호의 setter메소드
	 * @param seqCleanReservation 청소업체 예약번호
	 */
	public void setSeqCleanReservation(int seqCleanReservation) {
		this.seqCleanReservation = seqCleanReservation;
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
	 * 커뮤니티 게시글 번호의 getter메소드
	 * @return 커뮤니티 게시글 번호
	 */
	public int getSeqCommunity() {
		return seqCommunity;
	}
	/**
	 * 커뮤니티 게시글 번호의 setter메소드
	 * @param seqCommunity 커뮤니티 게시글 번호
	 */
	public void setSeqCommunity(int seqCommunity) {
		this.seqCommunity = seqCommunity;
	}
	/**
	 * 리뷰제목의 getter메소드
	 * @return 리뷰제목 
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 리뷰제목의 setter메소드
	 * @param title 리뷰제목
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 내용본문의 getter메소드
	 * @return 내용본문
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 내용본문의 setter메소드
	 * @param content 내용본문
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
	 * 조회수의 getter메소드
	 * @return 조회수
	 */
	public int getViewCount() {
		return viewCount;
	}
	/**
	 * 조회수의 setter메소드
	 * @param viewCount 조회수
	 */
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	/**
	 * 댓글수의 getter메소드
	 * @return 댓글수
	 */
	public int getCount() {
		return count;
	}
	/**
	 * 댓글수의 setter메소드
	 * @param count 댓글수
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * 계약상태의 getter메소드
	 * @return 계약상태
	 */
	public String getState() {
		return state;
	}
	/**
	 * 계약상태의 setter메소드
	 * @param state 계약상태
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * 커뮤니티 댓글번호의 getter메소드
	 * @return 커뮤니티 댓글번호
	 */
	public int getSeqCommunityComment() {
		return seqCommunityComment;
	}
	/**
	 * 커뮤니티 댓글번호의 setter메소드
	 * @param seqCommunityComment 커뮤니티 댓글번호
	 */
	public void setSeqCommunityComment(int seqCommunityComment) {
		this.seqCommunityComment = seqCommunityComment;
	}
	/**
	 * 중고장터 댓글번호의 getter메소드
	 * @return 중고장터 댓글번호
	 */
	public int getSeqUsedComment() {
		return seqUsedComment;
	}
	/**
	 * 중고장터 댓글번호의 setter메소드
	 * @param seqUsedComment 중고장터 댓글번호
	 */
	public void setSeqUsedComment(int seqUsedComment) {
		this.seqUsedComment = seqUsedComment;
	}
	/**
	 * 중개사리뷰번호의 getter메소드
	 * @return 중개사리뷰번호
	 */
	public int getSeqContractorReview() {
		return seqContractorReview;
	}
	/**
	 * 중개사리뷰번호의 setter메소드
	 * @param seqContractorReview 중개사리뷰번호
	 */
	public void setSeqContractorReview(int seqContractorReview) {
		this.seqContractorReview = seqContractorReview;
	}
	/**
	 * 매물리뷰번호의 getter메소드
	 * @return 매물리뷰번호
	 */
	public int getSeqPropertyReview() {
		return seqPropertyReview;
	}
	/**
	 * 매물리뷰번호의 setter메소드
	 * @param seqPropertyReview 매물리뷰번호
	 */
	public void setSeqPropertyReview(int seqPropertyReview) {
		this.seqPropertyReview = seqPropertyReview;
	}
	/**
	 * 중개사이름의 getter메소드
	 * @return 중개사이름
	 */
	public String getContractorName() {
		return contractorName;
	}
	/**
	 * 중개사이름의 setter메소드
	 * @param contractorName 중개사이름
	 */
	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}
	/**
	 * 매물글제목의 getter메소드
	 * @return 매물글제목
	 */
	public String getPtitle() {
		return ptitle;
	}
	/**
	 * 매물글제목의 setter메소드
	 * @param ptitle 매물글제목
	 */
	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}
	/**
	 * 지역정보의 getter메소드
	 * @return 지역정보
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * 지역정보의 setter메소드
	 * @param location 지역정보
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * 이름의 getter메소드
	 * @return 이름
	 */
	public String getName() {
		return name;
	}
	/**
	 * 이름의 setter메소드
	 * @param name 이름
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 예약일의 getter메소드
	 * @return 예약일
	 */
	public Date getReservationDate() {
		return reservationDate;
	}
	/**
	 * 예약일의 setter메소드
	 * @param reservationDate 예약일
	 */
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	/**
	 * 평점의 getter메소드
	 * @return 평점
	 */
	public int getRating() {
		return rating;
	}
	/**
	 * 평점의 setter메소드
	 * @param rating 평점
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	/**
	 * 커뮤니티신고번호의 getter메소드
	 * @return 커뮤니티신고번호
	 */
	public int getSeqCommunityReport() {
		return seqCommunityReport;
	}
	/**
	 * 커뮤니티신고번호의 setter메소드
	 * @param seqCommunityReport 커뮤니티신고번호
	 */
	public void setSeqCommunityReport(int seqCommunityReport) {
		this.seqCommunityReport = seqCommunityReport;
	}
	/**
	 * 중고거래신고번호의 getter메소드
	 * @return 중고거래신고번호
	 */
	public int getSeqUsedReport() {
		return seqUsedReport;
	}
	/**
	 * 중고거래신고번호의 setter메소드
	 * @param seqUsedReport 중고거래신고번호
	 */
	public void setSeqUsedReport(int seqUsedReport) {
		this.seqUsedReport = seqUsedReport;
	}
	/**
	 * 신고사유의 getter메소드
	 * @return 신고사유
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * 신고사유의 setter메소드
	 * @param reason 신고사유
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * 신고처리상태의 getter메소드
	 * @return 신고처리상태
	 */
	public String getReportState() {
		return reportState;
	}
	/**
	 * 신고처리상태의 setter메소드
	 * @param reportState 신고처리상태
	 */
	public void setReportState(String reportState) {
		this.reportState = reportState;
	}
	/**
	 * 매물번호의 getter메소드
	 * @return 매물번호
	 */
	public int getSeqProperty() {
		return seqProperty;
	}
	/**
	 * 매물번호의 setter메소드
	 * @param seqProperty 매물번호
	 */
	public void setSeqProperty(int seqProperty) {
		this.seqProperty = seqProperty;
	}
	/**
	 * 매물신고번호의 getter메소드
	 * @return 매물신고번호
	 */
	public int getSeqPropertyContractReport() {
		return seqPropertyContractReport;
	}
	/**
	 * 매물신고번호의 setter메소드
	 * @param seqPropertyContractReport 매물신고번호
	 */
	public void setSeqPropertyContractReport(int seqPropertyContractReport) {
		this.seqPropertyContractReport = seqPropertyContractReport;
	}
	/**
	 * 청소업체리뷰번호의 getter메소드
	 * @return 청소업체리뷰번호
	 */
	public int getSeqCleanReview() {
		return seqCleanReview;
	}
	/**
	 * 청소업체리뷰번호의 setter메소드
	 * @param seqCleanReview 청소업체리뷰번호
	 */
	public void setSeqCleanReview(int seqCleanReview) {
		this.seqCleanReview = seqCleanReview;
	}
	/**
	 * 이사업체리뷰번호의 getter메소드
	 * @return 이사업체리뷰번호
	 */
	public int getSeqMoveReview() {
		return seqMoveReview;
	}
	/**
	 * 이사업체리뷰번호의 setter메소드
	 * @param seqMoveReview 이사업체리뷰번호
	 */
	public void setSeqMoveReview(int seqMoveReview) {
		this.seqMoveReview = seqMoveReview;
	}
	/**
	 * 전자계약서번호의 getter메소드
	 * @return 전자계약서번호
	 */
	public int getSeqContract() {
		return seqContract;
	}
	/**
	 * 전자계약서번호의 setter메소드
	 * @param seqContract 전자계약서번호
	 */
	public void setSeqContract(int seqContract) {
		this.seqContract = seqContract;
	}
	/**
	 * 중개인매물의 getter메소드
	 * @return 중개인매물
	 */
	public int getSeqConctractorProperty() {
		return seqConctractorProperty;
	}
	/**
	 * 중개인매물의 setter메소드
	 * @param seqConctractorProperty 중개인매물
	 */
	public void setSeqConctractorProperty(int seqConctractorProperty) {
		this.seqConctractorProperty = seqConctractorProperty;
	}
	
	
	
	
}
