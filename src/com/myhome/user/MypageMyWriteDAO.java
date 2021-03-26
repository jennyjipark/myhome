package com.myhome.user;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.myhome.DBUtil;

/**
 * 내가쓴글보기의 DB작업을 담당하는 클래스입니다.
 * @author 이준오
 *
 */
public class MypageMyWriteDAO {


	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	private CallableStatement cstat;

	public MypageMyWriteDAO() {
		// DB 연결
		conn = DBUtil.open();
	}

	public void close() {
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//중고장터리스트 불러오기요청
	/**
	 * 회원의 중고장터 내 게시글을 가져옵니다.
	 * @param seqUser 회원번호
	 * @return 중고장터 게시글
	 */
	public ArrayList<MypageMyWriteDTO> getMyUsedList(int seqUser) {
		
		ArrayList<MypageMyWriteDTO> list = new ArrayList<MypageMyWriteDTO>();
		
		try {
			
			String sql = "select * from vwUsed where seqUser = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seqUser);
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				MypageMyWriteDTO dto = new MypageMyWriteDTO();
				dto.setSeqUser(rs.getInt("seqUser"));
				dto.setSeqUsed(rs.getInt("seqUsed"));
				dto.setTitle(rs.getString("title"));
				dto.setWriteDate(rs.getDate("writeDate"));
				dto.setCount(rs.getInt("count"));
				
				list.add(dto);
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return list;
		
	}
	//방올리기 게시물 리스트 요청
	/**
	 * 회원의 방올리기 내 게시글을 가져옵니다.
	 * @param seqUser 회원번호
	 * @return 방올리기 게시글
	 */
	public ArrayList<MypageMyWriteDTO> getMyPropertyList(int seqUser) {

		ArrayList<MypageMyWriteDTO> list = new ArrayList<MypageMyWriteDTO>();
		
		try {
			
			String sql = "select * from vwPropertyPost where seqUser = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seqUser);
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				MypageMyWriteDTO dto = new MypageMyWriteDTO();
				dto.setSeqUser(rs.getInt("seqUser"));
				dto.setSeqProperty(rs.getInt("seqProperty"));
				dto.setTitle(rs.getString("title"));
				dto.setState(rs.getString("state"));
				
				list.add(dto);
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return list;
	}
	//커뮤니티 게시글 리스트 요청
	/**
	 * 회원의 커뮤니티 내 게시글을 가져옵니다.
	 * @param seqUser 회원번호
	 * @return 커뮤니티 게시글
	 */
	public ArrayList<MypageMyWriteDTO> getMyCommunityList(int seqUser) {

		ArrayList<MypageMyWriteDTO> list = new ArrayList<MypageMyWriteDTO>();
		
		try {
			
			String sql = "select * from vwCommunity where seqUser = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seqUser);
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				MypageMyWriteDTO dto = new MypageMyWriteDTO();
				dto.setSeqUser(rs.getInt("seqUser"));
				dto.setSeqCommunity(rs.getInt("seqCommunity"));
				dto.setTitle(rs.getString("title"));
				dto.setWriteDate(rs.getDate("writeDate"));
				dto.setViewCount(rs.getInt("viewCount"));
				dto.setCount(rs.getInt("count"));
				
				list.add(dto);
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return list;
	}
	//중고장터 댓글 리스트 요청
	/**
	 * 회원의 중고장터 내 댓글을 가져옵니다.
	 * @param seqUser 회원번호
	 * @return 중고장터 댓글
	 */
	public ArrayList<MypageMyWriteDTO> getMyUsedCommentList(int seqUser) {

		ArrayList<MypageMyWriteDTO> list = new ArrayList<MypageMyWriteDTO>();
		
		try {
			
			String sql = "select seqUser, seqUsed, seqUsedComment, content, writeDate from tblUsedComment where seqUser = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seqUser);
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				MypageMyWriteDTO dto = new MypageMyWriteDTO();
				dto.setSeqUser(rs.getInt("seqUser"));
				dto.setSeqUsed(rs.getInt("seqUsed"));
				dto.setSeqUsedComment(rs.getInt("seqUsedComment"));
				dto.setContent(rs.getString("content"));
				dto.setWriteDate(rs.getDate("writeDate"));
				
				list.add(dto);
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return list;
	}
	//커뮤니티 댓글리스트 요청
	/**
	 * 회원의 커뮤니티 내 댓글을 가져옵니다.
	 * @param seqUser 회원번호
	 * @return 커뮤니티 댓글
	 */
	public ArrayList<MypageMyWriteDTO> getMyCommunityCommentList(int seqUser) {

		ArrayList<MypageMyWriteDTO> list = new ArrayList<MypageMyWriteDTO>();
		
		try {
			
			String sql = "select seqUser, seqCommunityComment, content, seqCommunity from tblCommunityComment where seqUser = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seqUser);
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				MypageMyWriteDTO dto = new MypageMyWriteDTO();
				dto.setSeqUser(rs.getInt("seqUser"));
				dto.setSeqCommunityComment(rs.getInt("seqCommunityComment"));
				dto.setContent(rs.getString("content"));
				dto.setSeqCommunity(rs.getInt("seqCommunity"));
				
				list.add(dto);
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return list;
	}
	//이삿짐센터 후기 리스트 요청
	/**
	 * 회원의 이삿짐센터 후기를 가져옵니다. 
	 * @param seqUser 회원번호
	 * @return 이삿짐센터 후기
	 */
	public ArrayList<MypageMyWriteDTO> getMyMoveReviewList(int seqUser) {

		ArrayList<MypageMyWriteDTO> list = new ArrayList<MypageMyWriteDTO>();
		
		try {
			
			String sql = "select * from vwMoveReview where seqUser = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seqUser);
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				MypageMyWriteDTO dto = new MypageMyWriteDTO();
				dto.setSeqUser(rs.getInt("seqUser"));
				dto.setSeqMoveReview(rs.getInt("seqMoveReview"));
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setReservationDate(rs.getDate("reservationDate"));
				dto.setRating(rs.getInt("rating"));
				dto.setSeqMoveReservation(rs.getInt("seqMoveReservation"));
				
				list.add(dto);
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return list;
	}

	//청소업체 후기 리스트 요청
	/**
	 * 회원의 청소업체 후기를 가져옵니다.
	 * @param seqUser 회원번호
	 * @return 청소업체 후기
	 */
	public ArrayList<MypageMyWriteDTO> getMyCleanReviewList(int seqUser) {

		ArrayList<MypageMyWriteDTO> list = new ArrayList<MypageMyWriteDTO>();
		
		try {
			
			String sql = "select * from vwCleanReview where seqUser = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seqUser);
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				MypageMyWriteDTO dto = new MypageMyWriteDTO();
				dto.setSeqUser(rs.getInt("seqUser"));
				dto.setSeqCleanReview(rs.getInt("seqCleanReview"));
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setReservationDate(rs.getDate("reservationDate"));
				dto.setRating(rs.getInt("rating"));
				dto.setSeqCleanReservation(rs.getInt("seqCleanReservation"));
				
				list.add(dto);
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return list;
	}

	//중개인 후기 리스트 요청
	/**
	 * 회원의 중개인후기를 가져옵니다.
	 * @param seqUser 회원번호
	 * @return 중개인후기
	 */
	public ArrayList<MypageMyWriteDTO> getMyContractorReviewList(int seqUser) {

		ArrayList<MypageMyWriteDTO> list = new ArrayList<MypageMyWriteDTO>();
		
		try {
			
			String sql = "select * from vwContractorReview where seqUser = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seqUser);
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				MypageMyWriteDTO dto = new MypageMyWriteDTO();
				dto.setSeqUser(rs.getInt("seqUser"));
				dto.setSeqContractorReview(rs.getInt("seqContractorReview"));
				dto.setTitle(rs.getString("title"));
				dto.setContractorName(rs.getString("contractorName"));
				dto.setRating(rs.getInt("rating"));
				dto.setSeqContract(rs.getInt("seqContract"));
				
				list.add(dto);
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return list;
	}
	
	//매물 후기 리스트 요청
	/**
	 * 회원의 매물 후기를 가져옵니다.
	 * @param seqUser 회원번호
	 * @return 매물후기
	 */
	public ArrayList<MypageMyWriteDTO> getMyPropertyReviewList(int seqUser) {

		ArrayList<MypageMyWriteDTO> list = new ArrayList<MypageMyWriteDTO>();
		
		try {
			
			String sql = "select * from vwPropertyReview where seqUser = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seqUser);
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				MypageMyWriteDTO dto = new MypageMyWriteDTO();
				dto.setSeqUser(rs.getInt("seqUser"));
				dto.setSeqPropertyReview(rs.getInt("seqPropertyReview"));
				dto.setTitle(rs.getString("title"));
				dto.setPtitle(rs.getString("ptitle"));
				dto.setLocation(rs.getString("location"));
				dto.setRating(rs.getInt("rating"));
				dto.setSeqProperty(rs.getInt("seqProperty"));
				
				list.add(dto);
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return list;
	}

	//중고장터 신고 목록 요청
	/**
	 * 회원의 중고장터 내 신고 목록을 가져옵니다.
	 * @param seqUser 회원번호
	 * @return 중고장터 신고목록
	 */
	public ArrayList<MypageMyWriteDTO> getMyUsedReportList(int seqUser) {

		ArrayList<MypageMyWriteDTO> list = new ArrayList<MypageMyWriteDTO>();
		
		try {
			
			String sql = "select * from tblUsedReport where seqUser = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seqUser);
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				MypageMyWriteDTO dto = new MypageMyWriteDTO();
				dto.setSeqUser(rs.getInt("seqUser"));
				dto.setSeqUsed(rs.getInt("seqUsed"));
				dto.setSeqUsedReport(rs.getInt("seqUsedReport"));
				dto.setTitle(rs.getString("title"));
				dto.setReason(rs.getString("reason"));
				dto.setReportState(rs.getString("state"));
				
				list.add(dto);
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return list;
	}

	//방찾기 신고 목록 요청
	/**
	 * 회원의 방찾기 내 신고목록을 가져옵니다.
	 * @param seqUser 회원번호
	 * @return 방찾기 신고목록
	 */
	public ArrayList<MypageMyWriteDTO> getMyPropertyReportList(int seqUser) {

		ArrayList<MypageMyWriteDTO> list = new ArrayList<MypageMyWriteDTO>();
		
		try {
			
			String sql = "select seqUser, seqConctractorProperty, seqPropertyContractReport, title, reason, case when state = 0 then '처리중' when state = 1 then '완료' end as state from tblPropertyContractReport where seqUser = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seqUser);
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				MypageMyWriteDTO dto = new MypageMyWriteDTO();
				dto.setSeqUser(rs.getInt("seqUser"));
				dto.setSeqPropertyContractReport(rs.getInt("seqPropertyContractReport"));
				dto.setTitle(rs.getString("title"));
				dto.setReason(rs.getString("reason"));
				dto.setReportState(rs.getString("state"));
				dto.setSeqConctractorProperty(rs.getInt("seqConctractorProperty"));
				
				list.add(dto);
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return list;
	}

	//커뮤니티 신고 목록 요청
	/**
	 * 회원의 커뮤니티 내 신고목록을 가져옵니다.
	 * @param seqUser 회원번호
	 * @return 커뮤니티 신고목록
	 */
	public ArrayList<MypageMyWriteDTO> getMyCommunityReportList(int seqUser) {

		ArrayList<MypageMyWriteDTO> list = new ArrayList<MypageMyWriteDTO>();
		
		try {
			
			String sql = "select * from tblCommunityReport where seqUser = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seqUser);
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				MypageMyWriteDTO dto = new MypageMyWriteDTO();
				dto.setSeqUser(rs.getInt("seqUser"));
				dto.setSeqCommunityReport(rs.getInt("seqCommunityReport"));
				dto.setTitle(rs.getString("title"));
				dto.setReason(rs.getString("reason"));
				dto.setWriteDate(rs.getDate("writeDate"));
				dto.setSeqCommunity(rs.getInt("seqCommunity"));
				
				list.add(dto);
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return list;
	}

	
}



