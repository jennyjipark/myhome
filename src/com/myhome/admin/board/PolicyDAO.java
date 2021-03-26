package com.myhome.admin.board;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.myhome.DBUtil;

/***
 * 부동산 정책 DAO입니다.
 * @author 윤지현
 * 목록(list), 등록(add), 수정(edit), 삭제(delete)
 */
public class PolicyDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private CallableStatement cstat;
	private ResultSet rs;
	
	public PolicyDAO() {
		
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


	//list
	public ArrayList<PolicyDTO> listpolicy(HashMap<String, String> map) {

		try {
			
			String where = "";
			
			if(map.get("search") != null) {
				
				where = String.format("where title like '%%%s%%' or content like '%%%s%%'", map.get("search"), map.get("search"));
			}
			
			//String sql = "select seq, title, id, writedate, viewcount from vwPolicy";
			String sql = String.format("select * from (select a.*, rownum as rnum from (select * from vwPolicy %s order by seq desc) a) where rnum between %s and %s"
					, where
					, map.get("begin")
					, map.get("end"));
			
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
					
			ArrayList<PolicyDTO> listpolicy = new ArrayList<PolicyDTO>();
			
			while (rs.next()) {
				//레코드 1줄 -> DTO 1개
				PolicyDTO dto = new PolicyDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setId(rs.getString("id"));
				dto.setWritedate(rs.getString("writedate"));
				dto.setViewcount(rs.getString("viewcount"));
				

				listpolicy.add(dto);
			}
		
			return listpolicy;
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	//AddPolicyOk
	public int addpolicy(PolicyDTO dto) {
		
		try {
			
			String sql = "insert into tblPolicy (seqPolicy, seqAdmin, title, content, writeDate, viewCount) values (SEQPolicy.nextVal, ?, ?, ?, default, default)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getSeqadmin());
			pstat.setString(2, dto.getTitle());
			pstat.setString(3, dto.getContent());
			
			return pstat.executeUpdate(); //1 or 0
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}



	//ViewPolicy 서블릿 -> 글 1개 반환 요청
	public PolicyDTO getpolicy(String seq) {

		try {
			
			String sql = "select * from vwPolicy where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				
				PolicyDTO dto = new PolicyDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setViewcount(rs.getString("viewcount"));
				dto.setWritedate(rs.getString("writeDate"));
				
				return dto;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}



	//EditPolicyOk -> 글수정
	public int editpolicy(PolicyDTO dto) {
		
		try {
			
			String sql = "update tblPolicy set title = ?, content= ? where seqPolicy = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getSeq()); //글번호
			
			return pstat.executeUpdate(); //1 or 0
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return 0;
	}


	//ListPolicy 서블릿 -> 총 게시물 수 반환
	public int getTotalCount(HashMap<String, String> map) {
		try {
			
			String where = "";
			
			if(map.get("search") != null) {
				
				where = String.format("where title like '%%%s%%' or content like '%%%s%%' or seq like '%%%s%%'", map.get("search"), map.get("search"), map.get("search"));
			}
			
			String sql = String.format("select count(*) as cnt from vwPolicy %s", where);
			
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

	public int del(String[] seq) {
		// TODO Auto-generated method stub
		return 0;
	}

	//ViewPolicy -> 조회수 증가
	public void updateViewcount(String seq) {
		try {
			
			String sql = "update tblPolicy set viewcount = viewcount + 1 where seqPolicy = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}


	public int delete(String seq) {
		
		try {
			
			String sql = "update from tblPolicy set title = ?, content = ? where seqPolicy = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq); //글번호
			
			return pstat.executeUpdate();	//1 or 0
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	//DeletePolicyOk -> 다중선택 삭제
	public int delete(String[] seq) {
		
		int count = seq.length;
		String in = "";
		
		if (seq.length != 1) {
			for(int i = 0; i<count -1; i++) {
				in += seq[i] + ",";
			}
			
			in += seq[count -1]; 
		}else {
			in = seq[0];
		}
		
		
		try {
			String sql = String.format("delete tblPolicy where seqPolicy in ( %s ) ", in);
			
			pstat = conn.prepareStatement(sql);
			
			int result = pstat.executeUpdate();
			pstat.close();
			
			return result;
			
		} catch (Exception e2) {
			System.out.println();
		}
		return 0;
	}

	//삭제할 리스트 받아오기
	public ArrayList<PolicyDTO> list(String[] seq) {
		
		try {
			
			int count = seq.length;
			String in ="";
			
			if(seq.length != 1) {
				for(int i =0; i <count -1; i++) {
					in += seq[i] + ",";
				}
				
				in += seq[count -1];
			}else {
				in = seq[0];
			}
			
			String sql = String.format("select * from tblPolicy where in (%s) order by seqPolicy desc", in);
		
			pstat = conn.prepareStatement(sql);
			
			rs = pstat.executeQuery();
			
			ArrayList<PolicyDTO> list = new ArrayList<PolicyDTO>();
			
			while(rs.next()) {
				PolicyDTO dto = new PolicyDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setSeqadmin(rs.getString("seqadmin"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setWritedate(rs.getString("writedate"));
				dto.setViewcount(rs.getString("viewcount"));
				
				list.add(dto);
			}
			rs.close();
			pstat.close();
			return list;
		
		} catch (Exception e) {
			System.out.println(e);
		} 
		return null;
	}

}



