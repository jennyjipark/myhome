package com.myhome.admin.membermanage;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.myhome.DBUtil;

/***
 * 중개인회원 관리 DAO입니다.
 * @author 윤지현
 * 목록(list), 상세페이지(view), 삭제(delete)
 */
public class ManageContractorDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private CallableStatement cstat;
	private ResultSet rs;
	
	public ManageContractorDAO() {
		
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
	
	//List
	public ArrayList<ManageContractorDTO> list(HashMap<String, String> map) {
		
		try {
			
			String where="";
			
			if(map.get("search") != null) {
				
				where = String.format("where seq like '%%%s%%' or name like '%%%s%%' or id like '%%%s%%'", map.get("search"), map.get("search"), map.get("search"));
			}
			
			//String sql = "select seq, name, id, email, companynumber, password, contractorname, tel1, tel2, tel3, address, state, reportcount from vwContractor";
			String sql = String.format("select * from (select a.*, rownum as rnum from (select * from vwContractor %s order by seq asc) a) where rnum between %s and %s"
					, where
					, map.get("begin")
					, map.get("end"));
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			ArrayList<ManageContractorDTO> list = new ArrayList<ManageContractorDTO	>();
			
			while (rs.next()) {
				//레코드 1줄 -> DTO 1개
				
				ManageContractorDTO dto = new  ManageContractorDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setContractorname(rs.getString("contractorname"));
				dto.setCompanynumber(rs.getString("companynumber"));
				dto.setPassword(rs.getString("password"));
				dto.setAddress(rs.getString("address"));
				dto.setTel1(rs.getString("tel1"));
				dto.setTel2(rs.getString("tel2"));
				dto.setTel3(rs.getString("tel3"));
				dto.setEmail(rs.getString("email"));
				dto.setState(rs.getString("state"));
				dto.setReportcount(rs.getString("reportcount"));
				
				list.add(dto);
				
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public ManageContractorDTO get(String seq) {

		try {
			
			String sql ="select * from vwContractor where seq=?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				
				ManageContractorDTO dto = new ManageContractorDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setContractorname(rs.getString("contractorname"));
				dto.setCompanynumber(rs.getString("companynumber"));
				dto.setPassword(rs.getString("password"));
				dto.setAddress(rs.getString("address"));
				dto.setTel1(rs.getString("tel1"));
				dto.setTel2(rs.getString("tel2"));
				dto.setTel3(rs.getString("tel3"));
				dto.setEmail(rs.getString("email"));
				dto.setState(rs.getString("state"));
				dto.setReportcount(rs.getString("reportcount"));
				
				return dto;
				
				
			}
				
					
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	//MemberManageContractor 서블릿 -> 총 게시물 수 반환
	public int getTotalCount(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			
			if(map.get("search") != null) {
				
				where = String.format("where name like '%%%s%%' or id like '%%%s%%' or seq like '%%%s%%'", map.get("search"), map.get("search"), map.get("search"));
			}
			
			String sql = String.format("select count(*) as cnt from vwContractor %s", where);
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}

	//delete
	//삭제시 상태를 2(중개인삭제)로 만들어준다.
	public int del(ManageContractorDTO dto) {
		try {
			
			/*
			 * String sql = "update tblAllUser set state = 2 where seq = ?";
			 * 
			 * pstat = conn.prepareStatement(sql); pstat.setString(1, dto.getSeq());
			 * 
			 * return pstat.executeUpdate();
			 */	
			
			String sql = "{ call procDelContractor(?) }";
			
			cstat = conn.prepareCall(sql);
			cstat.setString(1, dto.getSeq());
			
			return cstat.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	
	}
}








