package com.myhome.admin.property;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.myhome.DBUtil;

/***
 * 매물관리 DAO입니다. 
 * @author 윤지현
 *
 */
public class AdminPropertyDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private CallableStatement cstat;
	private ResultSet rs;
	
	public AdminPropertyDAO() {
		
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

	public ArrayList<AdminPropertyDTO> list(HashMap<String, String> map) {

		try {
			
			String where = "";
			
			if(map.get("search") != null) {
				
				where = String.format("where seq like '%%%s%%'", map.get("search"));
			}
			
			//String sql = "select * from vwMove order by seq asc";
			String sql = String.format("select * from (select a.*, rownum as rnum from (select * from vwProperty %s order by seq asc) a) where rnum between %s and %s"
					, where
					, map.get("begin")
					, map.get("end"));
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			ArrayList<AdminPropertyDTO> list = new ArrayList<AdminPropertyDTO>();
			
			while(rs.next()) {
				//레코드 1줄 -> DTO 1개
				
				AdminPropertyDTO dto = new AdminPropertyDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setImage(rs.getString("image"));
				dto.setRoomtype(rs.getString("roomtype"));
				dto.setContracttype(rs.getString("contracttype"));
				dto.setValue(rs.getString("value"));
				dto.setLocation(rs.getString("location"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setFloor(rs.getString("floor"));
				dto.setState(rs.getString("state"));
				
				list.add(dto);
				
			}
			
			return list;
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	public int getTotalCount(HashMap<String, String> map) {
		try {
			
			String where = "";
			
			if(map.get("search") != null) {
				
				where = String.format("where seq like '%%%s%%'", map.get("search"));
			}
			
			String sql = String.format("select count(*) as cnt from vwProperty %s", where);
			
			
			
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

	//ViewProperty 서블릿 -> 글 1개 반환 요청
	public AdminPropertyDTO get(String seq) {
		
		try {
			
			String sql = "select * from vwPorperty where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				
				AdminPropertyDTO dto = new AdminPropertyDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setImage(rs.getString("image"));
				dto.setRoomtype(rs.getString("roomtype"));
				dto.setValue(rs.getString("value"));
				dto.setLocation(rs.getString("location"));
				dto.setFloor(rs.getString("floor"));
				dto.setState(rs.getString("state"));
				dto.setTitle(rs.getString("title"));
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}
	
	
	
}
