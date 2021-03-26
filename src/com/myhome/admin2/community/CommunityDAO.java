package com.myhome.admin2.community;

import java.util.ArrayList;
import java.util.HashMap;

import com.myhome.DBUtil;
import com.myhome.admin2.Admin2;

/**
 * 정보공유 게시판 DB처리 DAO Admin2 상속
 * @author 이대홍
 */

public class CommunityDAO extends Admin2 {

	@Override
	public ArrayList<CommunityDTO> list(HashMap<String, String> map) {

		String where = "";

		if (map.get("search") != null) {
			where = String.format(" where title like '%%%s%%' or " + "content like '%%%s%%'", map.get("search"),
					map.get("search"));

		}
		// search 와 category

		try {

			String sql = String.format(
					"select * from " + "(select a.*, rownum as rnum from vwCC a %s  order by SeqCommunity desc) "
							+ "where rnum between %s and %s ",
					where, map.get("begin"), map.get("end"));
			System.out.println(sql);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			ArrayList<CommunityDTO> list = new ArrayList<CommunityDTO>();

			while (rs.next()) {
				CommunityDTO dto = new CommunityDTO();

				dto.setSeqCommunity(rs.getString("seqCommunity"));
				dto.setSeqUser(rs.getString("seqUser"));
				dto.setId(rs.getString("id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setCount(rs.getString("count"));
				dto.setViewCount(rs.getString("viewCount"));
				list.add(dto);

			}
			rs.close();
			ps.close();
			
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(" Community  list : " + e);
		}

		return null;
	}

	@Override
	public int totalCount(HashMap<String, String> map) {
		String where = "";

		if (map.get("search") != null) {
			where = String.format(" where title like '%%%s%%' or " + "content like '%%%s%%'", map.get("search"),
					map.get("search"));

		} // search 와 category

		try {

			String sql = String.format("select count(*) as count from (select a.*, rownum as rnum from vwCC a %s ) "
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
			System.out.println(" Community  total count : " + e);
		}

		return 0;

	}

	public ArrayList<CommunityDTO> list(String[] seqCommunity) {
		try {

			int count = seqCommunity.length;
			String in = "";

			if (seqCommunity.length != 1) {
				for (int i = 0; i < count - 1; i++) {
					in += seqCommunity[i] + ",";
				}

				in += seqCommunity[count - 1];
			} else {
				in = seqCommunity[0];
			}

			String sql = String.format("select * from vwCC where seqCommunity in ( %s ) order by seqCommunity desc",
					in);

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			ArrayList<CommunityDTO> list = new ArrayList<CommunityDTO>();

			while (rs.next()) {
				CommunityDTO dto = new CommunityDTO();

				dto.setSeqCommunity(rs.getString("seqCommunity"));
				dto.setSeqUser(rs.getString("seqUser"));
				dto.setId(rs.getString("id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setCount(rs.getString("count"));
				dto.setViewCount(rs.getString("viewCount"));

				list.add(dto);

			}
			
			rs.close();
			ps.close();
			
			return list;

		} catch (Exception e) {

			System.out.println("Community listde : " + e);
		}

		return null;
	}

	public int delete(String[] seqCommunity) {

		int count = seqCommunity.length;
		String in = "";

		if (seqCommunity.length != 1) {
			for (int i = 0; i < count - 1; i++) {
				in += seqCommunity[i] + ",";
			}

			in += seqCommunity[count - 1];
		} else {
			in = seqCommunity[0];
		}

		try {
			String sql = String.format("update tblCommunity set title = ' '  where seqCommunity in ( %s ) ", in);

			ps = conn.prepareStatement(sql);
			
			
			int result = ps.executeUpdate();
			
			ps.close();
			return result;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("delete : " + e);
		}

		return 0;
	}// delete

	public CommunityDTO view(String seq) {

		try {

			String sql = "select * from vwCC where seqCommunity = " + seq;

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				CommunityDTO dto = new CommunityDTO();

				dto.setSeqCommunity(rs.getString("seqCommunity"));
				dto.setSeqUser(rs.getString("seqUser"));
				dto.setId(rs.getString("id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setCount(rs.getString("count"));
				dto.setViewCount(rs.getString("viewCount"));

				rs.close();
				ps.close();
				
				return dto;
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("view : " + e);

		}

		return null;
	}

	public ArrayList<CommunityCommentDTO> comment(String seqCommunity) {
		// TODO Auto-generated method stub
		try {
			String sql = "select  tblCommunityComment.*,"
					+ "(select id from tblAllUser where seqAllUser = seqUser) as id "
					+ "from tblCommunityComment where seqCommunity = " + seqCommunity;

			st = conn.createStatement();
			rs = st.executeQuery(sql);

			ArrayList<CommunityCommentDTO> list = new ArrayList<CommunityCommentDTO>();
			while (rs.next()) {
				CommunityCommentDTO dto = new CommunityCommentDTO();

				dto.setSeqCommunity(rs.getString("seqCommunity"));
				dto.setSeqUser(rs.getString("seqUser"));
				dto.setId(rs.getString("id"));
				dto.setContent(rs.getString("content"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setSeqCommunityComment(rs.getString("seqCommunityComment"));
				
				list.add(dto);
			}

			rs.close();
			st.close();
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			// TODO: handle exception
			System.out.println("Comment view : " + e);

		}

		return null;
	}

	public int delComment(String seqCommunityComment) {
		// TODO Auto-generated method stub
	
		try {
			
			String sql = "update tblCommunityComment set content = ' '  where seqCommunityComment = "+seqCommunityComment; 
			
			st =conn.createStatement();
			
			int result = st.executeUpdate(sql);
			
			st.close();
			
			return result;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("delComment : "+e);
		}

		return 0;
	}

}
