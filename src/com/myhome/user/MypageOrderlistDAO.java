package com.myhome.user;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.myhome.DBUtil;

/**
 * 매물거래내역의 DB작업을 담당하는 클래스입니다.
 * @author 이준오
 *
 */
public class MypageOrderlistDAO {



	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	private CallableStatement cstat;

	public MypageOrderlistDAO() {
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
	
	//나의 매물 목록 요청
	/**
	 * 회원의 매물목록을 가져옵니다.
	 * @param seqUser 회원번호
	 * @return 매물목록
	 */
	public ArrayList<MypageOrderlistDTO> getBoughtList(int seqUser) {

		ArrayList<MypageOrderlistDTO> list = new ArrayList<MypageOrderlistDTO>();
		
		try {
			
			String sql = "select * from vwBoughtProperty where seqUser = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seqUser);
			
			rs = pstat.executeQuery();

			while(rs.next()) {
				MypageOrderlistDTO dto = new MypageOrderlistDTO();
				dto.setSeqContract(rs.getInt("seqContract"));
				dto.setSeqUser(rs.getInt("seqUser"));
				dto.setSeqContractorProperty(rs.getInt("seqContractorProperty"));
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setContractorName(rs.getString("contractorName"));
				dto.setContractDate(rs.getDate("contractDate"));
				dto.setSeqContractorReview(rs.getInt("seqContractorReview"));
				dto.setSeqPropertyReview(rs.getInt("seqPropertyReview"));
				
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
