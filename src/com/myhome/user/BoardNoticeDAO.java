package com.myhome.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.myhome.DBUtil;

public class BoardNoticeDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public BoardNoticeDAO() {
		conn = DBUtil.open();
	}
	
	public void close() {
		try {
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println("BoardNoticeDAO.close()");
			e.printStackTrace();
		}
	}
	
	

	public void updateViewCount(String seq) {

		try {
			
			String sql = "update tblNotice set viewCount = viewCount +1 where seqNotice = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("BoardNoticeDAO.updateViewCount()");
			e.printStackTrace();
		}
		
	}

	public BoardNoticeDTO get(String seq) {

		try {
			
			String sql = "select a.*, (select id from tblAdmin where seqAdmin = a.seqAdmin) as id from tblNotice a where seqNotice = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				BoardNoticeDTO dto = new BoardNoticeDTO();
				
				dto.setSeqNotice(rs.getString("seqNotice"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setViewCount(rs.getInt("viewCount"));
				dto.setSeqAdmin(rs.getString("seqAdmin"));
				
				dto.setId(rs.getString("id"));
				
				return dto;
				
			}
			
		} catch (Exception e) {
			System.out.println("BoardNoticeDAO.get()");
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	

	public ArrayList<BoardNoticeDTO> list(HashMap<String, String> map) {

		try {
			
			String where = "";
			
			if (map.get("search") != null) {
				
				//관리자가 쓴 글이라 제목과 내용에 포함되는 것만 검색되도록 설정했음
				
				where = String.format("where title like '%%%s%%' or content like '%%%s%%'", map.get("search"), map.get("search"));
			}
			
			String sql = String.format("select * from (select a.*, rownum as rnum from (select * from vwNoticeUserVer %s order by seqNotice desc) a) where rnum between %s and %s", where, map.get("begin"), map.get("end"));
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			ArrayList<BoardNoticeDTO> list = new ArrayList<BoardNoticeDTO>();
			
			while (rs.next()) {
				
				BoardNoticeDTO dto = new BoardNoticeDTO();
				
				dto.setSeqNotice(rs.getString("seqNotice"));
				dto.setTitle(rs.getString("title"));
				dto.setWriteDate(rs.getString("writeDate"));

				dto.setViewCount(rs.getInt("viewCount"));
				dto.setId(rs.getString("id"));
				dto.setGap(rs.getInt("gap"));
				
				list.add(dto);
				
			}
			
			return list;	
			
		} catch (Exception e) {
			System.out.println("BoardNoticeDAO.list()");
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	

	public int getTotalCount(HashMap<String, String> map) {

		try {
			
			String where = "";
			
			if (map.get("search") != null) {
				where = String.format("where title like '%%%s%%' or content like '%%%s%%'", map.get("search"), map.get("search"));
			}
			
			String sql = String.format("select count(*) as cnt from tblNotice %s", where);
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println("BoardNoticeDAO.getTotalCount()");
			e.printStackTrace();
		}
		
		return 0;
	}
		
}












