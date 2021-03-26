package com.myhome.user;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.myhome.DBUtil;


/**
 * 매칭매물관리에 관한 DB작업을 담당하는 클래스입니다.
 * @author 이준오
 *
 */
public class MypageMatchingDAO {



	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	private CallableStatement cstat;

	public MypageMatchingDAO() {
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

	//받은 매칭 목록 요청
	/**
	 * 회원이 받은 매칭 목록을 가져옵니다.
	 * @param seqUser 회원번호
	 * @return 회원번호에 따른 받은 매칭 목록
	 */
	public ArrayList<MypageMatchingDTO> getReceiveMatchingList(int seqUser) {
		ArrayList<MypageMatchingDTO> list = new ArrayList<MypageMatchingDTO>();
		
		try {
			
			String sql = "select * from vwReceiveMatching where seqUser = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seqUser);
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				
				MypageMatchingDTO dto = new MypageMatchingDTO();
				
				dto.setSeqMatching(rs.getInt("seqMatching"));
				dto.setSeqUser(rs.getInt("seqUser"));
				dto.setSeqProperty(rs.getInt("seqProperty"));
				dto.setSeqLessorProperty(rs.getInt("seqLessorProperty"));
				dto.setSeqContractor(rs.getInt("seqContractor"));
				dto.setTitle(rs.getString("title"));
				dto.setContractorName(rs.getString("contractorName"));
				dto.setName(rs.getString("name"));
				dto.setResponse(rs.getString("response"));
				
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//보낸 매칭 목록 요청
	/**
	 * 회원이 보낸 매칭 목록을 가져옵니다.
	 * @param seqUser 회원번호
	 * @return 회원번호에 따른 보낸 매칭 목록
	 */
	public ArrayList<MypageMatchingDTO> getSendMatchingList(int seqUser) {
		ArrayList<MypageMatchingDTO> list = new ArrayList<MypageMatchingDTO>();
		
		try {
			
			String sql = "select * from vwSendMatching where seqUser = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seqUser);
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				
				MypageMatchingDTO dto = new MypageMatchingDTO();
				
				dto.setSeqMatching(rs.getInt("seqMatching"));
				dto.setSeqUser(rs.getInt("seqUser"));
				dto.setSeqProperty(rs.getInt("seqProperty"));
				dto.setSeqContractor(rs.getInt("seqContractor"));
				dto.setSeqLessorProperty(rs.getInt("seqLessorProperty"));
				dto.setTitle(rs.getString("title"));
				dto.setContractorName(rs.getString("contractorName"));
				dto.setName(rs.getString("name"));
				dto.setResponse(rs.getString("response"));
				dto.setLocation(rs.getString("location"));
				
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//들어온 매칭 -> 매칭 거절
	/**
	 * 들어온 매칭의 거절 작업을 합니다.
	 * @param seqMatching 매칭요청번호
	 * @return DB작업(거절)의 결과
	 */
	public int reject(int seqMatching) {

		int result = 0;
		
		try {
			
			String sql = "{call procRejectMatching(?)}";
			
			cstat = conn.prepareCall(sql);
			cstat.setInt(1, seqMatching);
			
			result = cstat.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
			
	}

	//들어온 매칭 -> 매칭 수락
	/**
	 * 들어온 매칭의 수락 작업을 합니다.
	 * @param seqMatching 매칭요청번호
	 * @param seqLessorProperty 임대인매물번호
	 * @param seqContractor 중개인번호
	 * @return DB작업(수락)의 결과
	 */
	public int accept(int seqMatching, int seqLessorProperty, int seqContractor) {

		int result = 0;
		
		try {
			
			String sql = "{call procAcceptMatching(?,?,?)}";
			
			cstat = conn.prepareCall(sql);
			cstat.setInt(1, seqMatching);
			cstat.setInt(2, seqLessorProperty);
			cstat.setInt(3, seqContractor);
			
			result = cstat.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
			
	}
	
	//중개사 목록 출력 요청
	/**
	 * 올린매물 주변의 중개사 목록을 가져옵니다.
	 * @param location 지역정보
	 * @return 지역에 따른 중개사목록
	 */
	public ArrayList getContractorList(String location) {
		
		ArrayList list = new ArrayList();
		
		try {
			
			String sql = "select seqContractor, contractorName, companyNumber, address, phoneNumber, name, reportCount from vwContractor where address like '%' || ? || '%' ";
			
			System.out.println("여기 2번");
			
			pstat = conn.prepareStatement(sql);

			
			pstat.setString(1, location);
			
			rs = pstat.executeQuery();
			
			while (rs.next()) {
				
				Map dto = new HashMap();
				
				dto.put("seqContractor", rs.getInt("seqContractor"));
				dto.put("contractorName", rs.getString("contractorName"));
				dto.put("companyNumber", rs.getString("companyNumber"));
				dto.put("address", rs.getString("address"));
				dto.put("phoneNumber", rs.getString("phoneNumber"));
				dto.put("name", rs.getString("name"));
				dto.put("reportCount", rs.getInt("reportCount"));
				
				list.add(dto);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}

	//매칭 대기중 매물 중개사 선택해서 바꿔줌
	/**
	 * 매칭 대기중인 매물의 중개사를 바꾸는 작업을 합니다.
	 * @param seqMatching 매칭요청번호
	 * @param seqContractor 중개사번호
	 * @return DB작업(중개사 수정) 결과
	 */
	public int updateMatching(int seqMatching, int seqContractor) {
		
		int result = 0;
		
		try {
			
			String sql = "update tblMatching set seqContractor = ? where seqMatching = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setInt(1, seqContractor);
			pstat.setInt(2, seqMatching);
			
			result = pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	
	}
	
	
}
