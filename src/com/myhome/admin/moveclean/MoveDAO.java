package com.myhome.admin.moveclean;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.myhome.DBUtil;

/***
 * 이사업체 DAO입니다. 
 * @author 윤지현
 *
 */
public class MoveDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private CallableStatement cstat;
	private ResultSet rs;
	
	public MoveDAO() {
		
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

	public ArrayList<MoveDTO> list(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			
			if(map.get("search") != null) {
				
				where = String.format("where name like '%%%s%%'", map.get("search"));
			}
			
			//String sql = "select * from vwMove order by seq asc";
			String sql = String.format("select * from (select a.*, rownum as rnum from (select * from vwMove %s order by seq asc) a) where rnum between %s and %s"
					, where
					, map.get("begin")
					, map.get("end"));
			
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			ArrayList<MoveDTO> list = new ArrayList<MoveDTO>();
			
			while (rs.next()) {
				//레코드 1줄 -> DTO 1개
				
				MoveDTO dto = new MoveDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setLocation(rs.getString("location"));
				dto.setImage(rs.getString("image"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dto.setAddress(rs.getString("address"));
				dto.setBusinessnum(rs.getString("businessnum"));
				dto.setRating(rs.getString("rating"));
				dto.setPrice(rs.getString("price"));
				dto.setIntroduce(rs.getString("introduce"));
				
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
				
				where = String.format("where name like '%%%s%%'", map.get("search"));
			}
			
			String sql = String.format("select count(*) as cnt from vwMove %s", where);
			
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

	public int addmove(MoveDTO dto) {
		
		try {
			
			String sql ="insert into tblMove (seqMove, seqLocation, seqImage, name, tel, address, businessNum, price, introduce) values (SEQMove.nextVal, default, ?, ?, ?, ?, ?, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getImage());
			pstat.setString(2, dto.getName());
			pstat.setString(3, dto.getTel());
			pstat.setString(4, dto.getAddress());
			pstat.setString(5, dto.getBusinessnum());
			pstat.setString(6, dto.getPrice());
			pstat.setString(7, dto.getIntroduce());

			return pstat.executeUpdate();
			
		
		} catch (Exception e) {
			System.out.println(e);
		}

		return 0;
	}
	

}










