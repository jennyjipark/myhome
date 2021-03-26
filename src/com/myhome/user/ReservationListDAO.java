package com.myhome.user;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.myhome.DBUtil;

/**
 * 내 예약목록의 DB작업을 담당하는 클래스입니다.
 * @author 이준오
 *
 */
public class ReservationListDAO {



	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	private CallableStatement cstat;

	public ReservationListDAO() {
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
	
	//청소업체 예약목록 요청
	/**
	 * 회원의 청소업체 예약목록을 가져옵니다.
	 * @param seqUser 회원번호
	 * @return 청소업체 예약목록
	 */
	public ArrayList<ReservationListDTO> getReservationCleanList(int seqUser) {
		
		ArrayList<ReservationListDTO> list = new ArrayList<ReservationListDTO>();

		try {
			
			String sql = "select * from vwReservationClean where seqUser = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seqUser);
			
			rs = pstat.executeQuery();
			
			while (rs.next()) {
				ReservationListDTO dto = new ReservationListDTO();
				
				dto.setSeqUser(rs.getInt("seqUser"));
				dto.setSeqCleanReservation(rs.getInt("seqCleanReservation"));
				dto.setSeqClean(rs.getInt("seqClean"));
				dto.setName(rs.getString("name"));
				dto.setReservationDate(rs.getDate("reservationDate"));
				dto.setPrice(rs.getInt("price"));
				dto.setSeqCleanReview(rs.getInt("seqCleanReview"));
				
				list.add(dto);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
		
	}

	//이사업체 예약목록 요청
	/**
	 * 회원의 이사업체 예약목록을 가져옵니다.
	 * @param seqUser 회원번호
	 * @return 이사업체 예약목록
	 */
	public ArrayList<ReservationListDTO> getReservationMoveList(int seqUser) {
		
		ArrayList<ReservationListDTO> list = new ArrayList<ReservationListDTO>();

		try {
			
			String sql = "select * from vwReservationMove where seqUser = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seqUser);
			
			rs = pstat.executeQuery();
			
			while (rs.next()) {
				ReservationListDTO dto = new ReservationListDTO();
				
				dto.setSeqUser(rs.getInt("seqUser"));
				dto.setSeqMoveReservation(rs.getInt("seqMoveReservation"));
				dto.setSeqMove(rs.getInt("seqMove"));
				dto.setName(rs.getString("name"));
				dto.setReservationDate(rs.getDate("reservationDate"));
				dto.setPrice(rs.getInt("price"));
				dto.setSeqMoveReview(rs.getInt("seqMoveReview"));
				
				list.add(dto);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

}
