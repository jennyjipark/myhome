package com.myhome.admin2.notice;

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
 * 공지사항 DB 업무 처리 클래스 
 * @author 이대홍
 *
 */
public class NoticeDAO {

	private Connection conn;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;
	private CallableStatement ct;

	public NoticeDAO() {
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

	public ArrayList<NoticeDTO> list(HashMap<String, String> map) {

		try {

			String where = "";

			if (map.get("search") != null) {
				where = String.format(" where title like '%%%s%%' or " + "content like '%%%s%%'", map.get("search"),
						map.get("search"));
			}

			String sql = String.format("select * from "
					+ "(select a.*, rownum as rnum from tblNotice a %s order by seqNotice desc) "
					+ "where rnum between %s and %s ", where, map.get("begin"), map.get("end"));


			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			ArrayList<NoticeDTO> list = new ArrayList<NoticeDTO>();

			while (rs.next()) {
				NoticeDTO dto = new NoticeDTO();

				dto.setSeqNotice(rs.getString("seqNotice"));
				dto.setSeqAdmin(rs.getString("seqAdmin"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setViewCount(rs.getString("viewCount"));

				list.add(dto);

			}
			
			rs.close();
			ps.close();
			
			return list;

		} catch (Exception e) {

			System.out.println("lsit : " + e);
		}
		return null;

	}

	public int totalCount(HashMap<String, String> map) {

		try {

			String where = "";

			if (map.get("search") != null) {
				where = String.format(" where title like '%%%s%%' or " + "content like '%%%s%%'", map.get("search"),
						map.get("search"));
			}

			String sql = String.format(
					"select count(*) as count from tblNotice %s " + " order by seqNotice desc", where);

			st = conn.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				
			int result = rs.getInt("count");
				
				st.close();
				rs.close();
				return result;
			}

		} catch (Exception e) {
			System.out.println("total : " + e);
		}

		return 0;
	}

	public int write(NoticeDTO dto) {
		try {

			String sql = " insert into tblNotice values(seqNotice.nextVal, ?, ? ,?, sysdate ,0)";

			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getSeqAdmin());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getContent());
			
			
			int result = ps.executeUpdate();
			
			rs.close();
			ps.close();
			
			return result;
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("write : " + e);

		}

		return 0;

	}

	public NoticeDTO view(String seq) {
		try {

			String sql = String
					.format("select * from tblNotice where seqNotice = %s order by seqNotice desc", seq);
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				NoticeDTO dto = new NoticeDTO();
				dto.setSeqNotice(rs.getString("seqNotice"));
				dto.setSeqAdmin(rs.getString("seqAdmin"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWriteDate(rs.getString("writedate"));
				dto.setViewCount(rs.getString("viewcount"));
				
				rs.close();
				ps.close();
				
				return dto;

			}

		} catch (Exception e) {

			System.out.println("view : " + e);
		}

		return null;
	}

	public void count(String seq) {
		// TODO Auto-generated method stub

		String sql = "update tblNotice set viewcount = viewcount+1" + " where seqNotice =" + seq;

		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("count : " + e);
		}
	}

	public ArrayList<NoticeDTO> list(String[] seqNotice) {
		try {

			int count = seqNotice.length;
			String in = "";

			if (seqNotice.length != 1) {
				for (int i = 0; i < count - 1; i++) {
					in += seqNotice[i] + ",";
				}

				in += seqNotice[count - 1];
			} else {
				in = seqNotice[0];
			}

			String sql = String.format(
					"select * from tblNotice where seqNotice in ( %s ) order by seqNotice desc", in);

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			ArrayList<NoticeDTO> list = new ArrayList<NoticeDTO>();

			while (rs.next()) {
				NoticeDTO dto = new NoticeDTO();
				dto.setSeqNotice(rs.getString("seqNotice"));
				dto.setSeqAdmin(rs.getString("seqAdmin"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWriteDate(rs.getString("writedate"));
				dto.setViewCount(rs.getString("viewcount"));
				
				list.add(dto);

			}
			rs.close();
			ps.close();
			return list;

		} catch (Exception e) {

			System.out.println("listde : " + e);
		}

		return null;
	}

	public int delete(String[] seqNotice) {
		int count = seqNotice.length;
		String in = "";

		if (seqNotice.length != 1) {
			for (int i = 0; i < count - 1; i++) {
				in += seqNotice[i] + ",";
			}

			in += seqNotice[count - 1];
		} else {
			in = seqNotice[0];
		}

		try {
			String sql = String.format("delete tblNotice where seqNotice in ( %s ) ", in);

			ps = conn.prepareStatement(sql);

			
			int result = ps.executeUpdate();
			ps.close();
			
			return result;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("delete : " + e);
		}

		// TODO Auto-generated method stub
		return 0;
	}

	public int edit(NoticeDTO dto) {
		try {

			String sql = "update tblNotice set title = ? , content = ? where seqNotice = ?";

			ps = conn.prepareStatement(sql);
			
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getContent());
			ps.setString(3, dto.getSeqNotice());
			
			int result = ps.executeUpdate();
			
			ps.close();
			return result;
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("edit : " + e);

		}

		return 0;
	}

}
