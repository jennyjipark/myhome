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
 * 체크리스트 DAO입니다.
 * @author 윤지현
 * 목록(list), 상세보기(view), 등록(add), 수정(edit), 삭제(delete)
 */
public class ChecklistDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private CallableStatement cstat;
	private ResultSet rs;
	
	public ChecklistDAO() {
		
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

	public ArrayList<ChecklistDTO> listchecklist(HashMap<String, String> map) {

		try {
			
			String where = "";
			
			if(map.get("search") != null) {
				
				where = String.format("where title like '%%%s%%' or content like '%%%s%%'", map.get("search"), map.get("search"));
			}
			
			//String sql = "select seq, title, id, writedate, viewcount from vwChecklist";
			String sql = String.format("select * from (select a.*, rownum as rnum from (select * from vwChecklist %s order by seq desc) a) where rnum between %s and %s"
					, where
					, map.get("begin")
					, map.get("end"));
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			ArrayList<ChecklistDTO> listchecklist = new ArrayList<ChecklistDTO>();
			
			while (rs.next()) {
				//레코드 1줄 -> DTO 1개
				ChecklistDTO dto = new ChecklistDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setId(rs.getString("id"));
				dto.setWritedate(rs.getString("writedate"));
				dto.setViewcount(rs.getString("viewcount"));
				

				listchecklist.add(dto);
			}
		
			return listchecklist;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	//AddChecklistOk -> 작성
	public int addchecklist(ChecklistDTO dto) {
		try {
			
			String sql = "insert into tblChecklist (seqChecklist, seqAdmin, title, content, writeDate, viewCount) values (SEQChecklist.nextVal, ?, ?, ?, default, default)";
			
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

	//ViewChecklist 서블릿 -> 글 1개 반환 요청
	public ChecklistDTO getchecklist(String seq) {

		try {
			
			String sql ="select * from vwChecklist where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				
				ChecklistDTO dto = new ChecklistDTO();
				
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

	//EditChecklistOk -> 글수정
	public int editchecklist(ChecklistDTO dto) {

		try {
			
			String sql = "update tblChecklist set title =?, content =? where seqChecklist = ?";
		
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

	//ListCheckList 서블릿 -> 총 게시물 수 반환
	public int getTotalCount(HashMap<String, String> map) {
		try {
			
			String where = "";
			
			if(map.get("search") != null) {
				
				where = String.format("where title like '%%%s%%' or content like '%%%s%%' or seq like '%%%s%%'", map.get("search"), map.get("search"), map.get("search"));
			}
			
			String sql = String.format("select count(*) as cnt from vwChecklist %s", where);
			
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

	//ViewChecklist -> 조회수 증가
	public void updateViewcount(String seq) {
		try {
			
			String sql = "update tblChecklist set viewcount = viewcount + 1 where seqChecklist = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
