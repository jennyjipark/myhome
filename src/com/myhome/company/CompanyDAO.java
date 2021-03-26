package com.myhome.company;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.myhome.DBUtil;

public class CompanyDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private CallableStatement cstat;
	private ResultSet rs;

	public CompanyDAO() {
		//DB 연결
		conn = DBUtil.open();
	}

	public void close() {
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//회사 리스트
	public ArrayList<CompanyDTO> getCompanyList(String sel1, String location, int begin, int end) {

		try {
			String table = "";
			//이사 or 청소에따라 테이블이 달라짐
			if(sel1.equals("move")) {
				table = "vMove";
			} else if(sel1.equals("clean")) {
				table = "vClean";
			}
			
			String sql = "select * from (select a.*, rownum as rnum from (select * from " + table + ""
					+ " where location like '%" + location + "%') a) where rnum between ? and ?";
			
			//System.out.println(sql);
			
			pstat = conn.prepareStatement(sql);

			pstat.setInt(1, begin);
			pstat.setInt(2, end);
			
			rs = pstat.executeQuery();

			ArrayList<CompanyDTO> dto = new ArrayList<CompanyDTO>();
			

			while(rs.next()) {
				CompanyDTO cdto = new CompanyDTO();
				

				cdto.setSeq(rs.getInt("seq"));
				cdto.setSeqLocation(rs.getInt("seqLocation"));
				cdto.setLocation(rs.getString("location"));
				cdto.setName(rs.getString("name"));
				cdto.setImagePath(rs.getString("imagePath"));
				cdto.setPrice(rs.getInt("price"));
				cdto.setAvgRating(rs.getInt("avgRating"));
				cdto.setTel(rs.getString("tel"));
				cdto.setIntroduce(rs.getString("introduce"));
				
				dto.add(cdto);
			}

			return dto;

	} catch (Exception e) {
		System.out.println("CompanyDAO.getCompanyList()" + e);
	}
	return null;
}

	//회사의 총 개수
	public int getTotalCount(String sel1, String location) {
		
		try {
			String table = "";
			//이사 or 청소에따라 테이블이 달라진다
			if(sel1.equals("move")) {
				table = "vMove";
			} else if(sel1.equals("clean")) {
				table = "vClean";
			}
			
			String sql = "select count(*) as cnt from " + table + " where location like '%" + location + "%'"; 
			
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
			int result = 0;
			return result;
		} catch (Exception e) {
			System.out.println("CompanyDAO.getTotalCount()" + e);
		}
		
		return 0;
	}

	//회사의 정보
	public CompanyDTO getCompanyInfo(String sel1, String seq) {
		
		try {
			String table = "";
			if(sel1.equals("move")) {
				table = "vMove";
			} else if(sel1.equals("clean")) {
				table = "vClean";
			}
			
			String sql = "select * from " + table + " where seq = ?";
			
			pstat = conn.prepareStatement(sql);

			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();

			while(rs.next()) {
				CompanyDTO cdto = new CompanyDTO();
				
				cdto.setSeq(rs.getInt("seq"));
				cdto.setSeqLocation(rs.getInt("seqLocation"));
				cdto.setLocation(rs.getString("location"));
				cdto.setName(rs.getString("name"));
				cdto.setImagePath(rs.getString("imagePath"));
				cdto.setPrice(rs.getInt("price"));
				cdto.setAvgRating(rs.getInt("avgRating"));
				cdto.setTel(rs.getString("tel"));
				cdto.setIntroduce(rs.getString("introduce"));
				
				cdto.setBusinessnum(rs.getString("businessnum"));
				
				return cdto;
			}
		} catch (Exception e) {
			System.out.println("CompanyDTO.getCompanyInfo()" + e);
		}
		return null;
	}

	
	//회사의 리뷰
	public ArrayList<ReviewDTO> getReview(String sel1, String seq) {
		
		try {
			String table = "";
			
			if(sel1.equals("move")) {
				table = "vMoveReview";
			} else if(sel1.equals("clean")) {
				table = "vCleanReview";
			}
			
			String sql = "select * from " + table + " where seq = ?";
			//System.out.println(sql);
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, Integer.parseInt(seq));
			
			rs = pstat.executeQuery();
			
			ArrayList<ReviewDTO> rdto = new ArrayList<ReviewDTO>();
			while(rs.next()) {
				ReviewDTO dto = new ReviewDTO();
				
				dto.setUserName(rs.getString("username"));
				dto.setReview(rs.getString("review"));
				dto.setRating(rs.getInt("rating"));
				
				rdto.add(dto);
				
			}
			
			return rdto;
			
		} catch (Exception e) {
			System.out.println("CompnayDAO.getReview()" + e);
		}
		return null;
	}

	//계약서번호
	public int getContract(String seqUser) {
		try {
			
			String sql = "select * from (select a.*, rownum as rnum from (select * from tblContract where seqUser = ? order by contractdate desc) a) where rnum = 1";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seqUser);
			
			rs = pstat.executeQuery();

			int seqContract = 0;
			while(rs.next()) {
				seqContract = rs.getInt("seqContract");
			}
			
			return seqContract;
			
		} catch (Exception e) {
			System.out.println("CompnayDAO.getContract()"+ e);
		}
		
		return 0;
	}

	public int reservation(String sel1, int seqContract, String seqCompany, String date) {
		try {
			String table = "";
			String seq = "";
			
			if(sel1.equals("move")) {
				table = "tblMoveReservation";
				seq = "seqMoveReservation";
			} else if(sel1.equals("clean")) {
				table = "tblCleanReservation";
				seq = "seqCleanReservation";
			}
			
			String sql = "insert into " + table + " values (" + seq + ".nextVal, ?, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seqCompany);
			pstat.setInt(2, seqContract);
			pstat.setString(3, date);
			
			System.out.println(sql);
			System.out.println(seqCompany + " " + seqContract + " " + date);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("CompanyDAO.reservation()"+e);
		}
		return 0;
	}
}

