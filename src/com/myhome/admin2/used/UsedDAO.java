package com.myhome.admin2.used;

import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;

import com.myhome.DBUtil;
import com.myhome.admin2.Admin2;


/**
 * 중고 장터 게시글 DB업무 클래스 Admin2 상속
 * @author 이대홍
 *
 */
public class UsedDAO extends Admin2{

	@Override
	public ArrayList<UsedDTO> list(HashMap<String, String> map) {
		// TODO Auto-generated method stub

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
					.format("select * from " + "(select a.*, rownum as rnum from vwUsed a %s  order by SeqUsed desc) "
							+ "where rnum between %s and %s ", where, map.get("begin"), map.get("end"));

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			ArrayList<UsedDTO> list = new ArrayList<UsedDTO>();

			while (rs.next()) {
				
				UsedDTO dto = new UsedDTO();

				dto.setSeqUsed(rs.getString("seqUsed"));
				dto.setSeqUser(rs.getString("seqUser"));
				dto.setId(rs.getString("id"));
				dto.setType(rs.getString("type"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setState(rs.getString("state"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setPrice(rs.getString("price"));
				dto.setSeqImage(rs.getString("seqImage"));
				dto.setTradeMode(rs.getString("tradeMode"));
				dto.setCount(rs.getString("count"));

				list.add(dto);

			}

			rs.close();
			ps.close();
			
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(" Used  list" + e);
		}

		return null;
		
	}

	@Override
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
					.format("select count(*) as count from (select a.*, rownum as rnum from vwUsed a %s ) "
							+ "where rnum between %s and %s ", where, map.get("begin"), map.get("end"));

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();


			if(rs.next()) {
				
				int result = rs.getInt("count");
				return result;
			
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(" Used  list" + e);
		}

		return 0;

	}//list

	public ArrayList<UsedDTO> list(String[] seqUsed) {
	
		try {

			int count = seqUsed.length;
			String in = "";

			if (seqUsed.length != 1) {
				for (int i = 0; i < count - 1; i++) {
					in += seqUsed[i] + ",";
				}

				in += seqUsed[count - 1];
			} else {
				in = seqUsed[0];
			}

			String sql = String.format(
					"select * from vwUsed where seqUsed in ( %s ) order by seqUsed desc", in);

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			ArrayList<UsedDTO> list = new ArrayList<UsedDTO>();

			while (rs.next()) {
				UsedDTO dto = new UsedDTO();
				dto.setSeqUsed(rs.getString("seqUsed"));
				dto.setSeqUser(rs.getString("seqUser"));
				dto.setId(rs.getString("id"));
				dto.setType(rs.getString("type"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setState(rs.getString("state"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setPrice(rs.getString("price"));
				dto.setSeqImage(rs.getString("seqImage"));
				dto.setTradeMode(rs.getString("tradeMode"));
				dto.setCount(rs.getString("count"));
				
				list.add(dto);

			}

			rs.close();
			ps.close();
			return list;

		} catch (Exception e) {

			System.out.println("Used listde : " + e);
		}

		return null;

	}//list delete

	public int delete(String[] seqUsed) {
		
		int count = seqUsed.length;
		String in = "";

		if (seqUsed.length != 1) {
			for (int i = 0; i < count - 1; i++) {
				in += seqUsed[i] + ",";
			}

			in += seqUsed[count - 1];
		} else {
			in = seqUsed[0];
		}

		try {
			String sql = String.format("update tblUsed set title = ' '  where seqUsed in ( %s ) ", in);

			ps = conn.prepareStatement(sql);

			int result =ps.executeUpdate(); 
			
			return result;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("delete : " + e);
		}

		// TODO Auto-generated method stub
		return 0;
		
	}//delete

	public UsedDTO view(String seqUsed, String category) {
		try {

			String sql = String.format("select * from vwUsed where seqUsed = %s and type = %s", seqUsed,category);

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				UsedDTO dto = new UsedDTO();
				
				dto.setSeqUsed(rs.getString("seqUsed"));
				dto.setSeqUser(rs.getString("seqUser"));
				dto.setId(rs.getString("id"));
				dto.setType(rs.getString("type"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setState(rs.getString("state"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setPrice(rs.getString("price"));
				dto.setSeqImage(rs.getString("seqImage"));
				dto.setTradeMode(rs.getString("tradeMode"));
				dto.setCount(rs.getString("count"));
				
				rs.close();
				ps.close();
				
				return dto;

			}

	} catch (Exception e) {

		System.out.println(" Used view : " + e);
	}

	return null;

	}

	public ArrayList<UsedCommentDTO> getComment(String seqUsed) {
	
		
		try {
			
			String sql = "select tblUsedComment.*, "
					+ "(select id from tblAllUser where seqAllUser = tblUsedComment.seqUser )"
					+ " as id from tblUsedComment where seqused = "+ seqUsed;
			
			ps = conn.prepareStatement(sql);
			rs =ps.executeQuery();
			
			ArrayList<UsedCommentDTO> list = new ArrayList<UsedCommentDTO>();
			
			while(rs.next()) {
				UsedCommentDTO dto = new UsedCommentDTO();
				dto.setContent(rs.getString("content"));
				dto.setSeqUsed(rs.getString("seqUsed"));
				dto.setSeqUsedComment(rs.getString("seqUsedComment"));
				dto.setSeqUser(rs.getString("seqUser"));
				dto.setId(rs.getString("id"));
				
				dto.setWriteDate(rs.getString("writeDate"));

				
				//여기서 데이터를 가공해도될까?..
				dto.setWriteDate(dto.getWriteDate().substring(0, 10));

				
				list.add(dto);
			}
			
			rs.close();
			ps.close();
			
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("getComment : "+e);
		}
		
		return null;
	}

	public int delComment(String seqUsedComment) {
		// TODO Auto-generated method stub

		try {
			
			
			String sql = "update tblUsedComment set content = '' where seqUsedComment = "+seqUsedComment;
			
			st = conn.createStatement();
			
			int result = st.executeUpdate(sql); 
			return result;
		
		} catch (Exception e) {
			// TODO: handle exception
		
			System.out.println("delComment : " +e);
		}
		
		return 0;
	}

	public int check(String seqUsed) {
		// TODO Auto-generated method stub
		try {
			
			String sql = "{ ? = call fcCheckUsed(?)}";
			
			ct =conn.prepareCall(sql);
			ct.registerOutParameter(1, Types.INTEGER);
			ct.setString(2, seqUsed);
			ct.execute();
			
			int result = ct.getInt(1);

			ct.close();
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("check : " +e);
		}
		
		return 0;
	}
	
}
