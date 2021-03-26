package com.myhome.admin2.qna;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.myhome.DBUtil;

/**
 * QNA DB 업무처리 DAO 클래스 
 * @author 이대홍
 *
 */

public class QnaDAO {
	private Connection conn;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;
	private CallableStatement ct;

	public QnaDAO() {
		conn = DBUtil.open();
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("close : " + e);
		}
	}

	public ArrayList<QnaDTO> list(HashMap<String, String> map) {

		String where = "";
		
		if (map.get("search") != null) {
			where = String.format(" where title like '%%%s%%' or " + "content like '%%%s%%'", map.get("search"),
					map.get("search"));
			
			if(!map.get("category").equals("0")) {
				where += " and type = " + map.get("category");
			}
			
		} else {
			
			if(!map.get("category").equals("0")) {
				where = "where type = " + map.get("category");
			}
		}; // search 와 category
		
		try {

			String sql = String
					.format("select * from " + "(select a.*, rownum as rnum from vwQna a %s  order by SeqQna desc) "
							+ "where rnum between %s and %s ", where, map.get("begin"), map.get("end"));

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			ArrayList<QnaDTO> list = new ArrayList<QnaDTO>();

			while (rs.next()) {
				
				QnaDTO dto = new QnaDTO();

				dto.setSeqQna(rs.getString("seqQna"));
				dto.setSeqUser(rs.getString("seqUser"));
				dto.setId(rs.getString("id"));
				dto.setType(rs.getString("type"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setState(rs.getString("state"));
				dto.setWriteDate(rs.getString("writeDate"));
				
				list.add(dto);

			}

			rs.close();
			ps.close();
			
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(" QNA  list" + e);
		}

		return null;
	}

	public int totalCount(HashMap<String, String> map) {
		String where = "";
		
		if (map.get("search") != null) {
			where = String.format(" where title like '%%%s%%' or " + "content like '%%%s%%'", map.get("search"),
					map.get("search"));
			
			if(!map.get("category").equals("0")) {
				where += " and type = " + map.get("category");
			}
			
		} else {
			
			if(!map.get("category").equals("0")) {
				where = "where type = " + map.get("category");
			}
		}; // search 와 category
		
		try {

			String sql = String
					.format("select count(*) as count from (select a.*, rownum as rnum from vwQna a %s  order by SeqQna desc) "
							+ "where rnum between %s and %s ", where, map.get("begin"), map.get("end"));

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();


			if (rs.next()) {
				int result = rs.getInt("count");
				rs.close();
				ps.close();
				
				return result;
			
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(" QNA  list" + e);
		}

		return 0;
	}

	public QnaDTO view(String seq, String category) {
		try {

				String sql = String.format("select * from vwQna where seqQna = %s and type = %s", seq,category);

				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();

				while (rs.next()) {
					QnaDTO dto = new QnaDTO();

					dto.setSeqQna(rs.getString("seqQna"));
					dto.setContent(rs.getString("content"));			
					dto.setId(rs.getString("id"));			
					dto.setSeqUser(rs.getString("seqUser"));			
					dto.setState(rs.getString("state"));			
					dto.setTitle(rs.getString("title"));			
					dto.setType(rs.getString("type"));			
					dto.setWriteDate(rs.getString("writeDate"));			
					
					rs.close();
					ps.close();
					
					return dto;

				}

		} catch (Exception e) {

			System.out.println(" Qna view : " + e);
		}

		return null;

	}

	public int write(String seqAdmin, String seq, String content) {
		// TODO Auto-generated method stub
		try {
			
			String sql = "{ call ProcQnaAnswer(?,?,?) }";
			ct =conn.prepareCall(sql);
			ct.setString(1, seqAdmin);
			ct.setString(2, seq);
			ct.setString(3, content);
			
			int result = ct.executeUpdate();
			
			ct.close();
			return result;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("write : "+e );
		
		}
		
		return 0;
	}

}
