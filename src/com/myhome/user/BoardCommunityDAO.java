package com.myhome.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.myhome.DBUtil;

public class BoardCommunityDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public BoardCommunityDAO() {
		conn = DBUtil.open();
	}

	public void close() {
		try {

			conn.close();

		} catch (Exception e) {
			System.out.println("BoardCommunityDAO.close()");
			e.printStackTrace();
		}
	}

	public int write(BoardCommunityDTO dto) {

		try {

			String sql = "insert into tblCommunity (seqCommunity, seqUser, title, content, viewCount, writeDate) values (seqCommunity.nextVal, ?, ?, ?, 1, sysdate)";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getSeqAllUser());
			pstat.setString(2, dto.getTitle());
			pstat.setString(3, dto.getContent());

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("BoardCommunityDAO.write()");
			e.printStackTrace();
		}

		return 0;
	}

	public ArrayList<BoardCommunityDTO> list(HashMap<String, String> map) {

		try {

			String where = "";

			if (map.get("search") != null) {

				// 제목과 내용에 포함되는 것만 검색되도록 설정했음.. 추후에 작성자도 검색할 수 있도록 코드 수정할 것. 수정하기*****
//				  where = String.format("where nickName like '%%%s%%' or title like '%%%s%%' or content like '%%%s%%'", map.get("search"), map.get("search"), map.get("search"));

				where = String.format("where title like '%%%s%%' or content like '%%%s%%'", map.get("search"),
						map.get("search"));
			}

			String sql = String.format(
					"select * from (select a.*, rownum as rnum from (select * from vwCommunityUserVer %s order by seqCommunity desc) a) where rnum between %s and %s",
					where, map.get("begin"), map.get("end"));
			// System.out.println(sql);
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();

			ArrayList<BoardCommunityDTO> list = new ArrayList<BoardCommunityDTO>();

			while (rs.next()) {

				BoardCommunityDTO dto = new BoardCommunityDTO();

				dto.setSeqCommunity(rs.getString("seqCommunity"));
				dto.setTitle(rs.getString("title"));
				dto.setWriteDate(rs.getString("writeDate"));
//				dto.setSeqUser(rs.getString("seqUser"));
				dto.setViewCount(rs.getInt("viewCount"));
				dto.setNickName(rs.getString("nickName"));
				dto.setGap(rs.getInt("gap"));

				dto.setContent(rs.getString("content"));
				dto.setCcount(rs.getString("ccount")); //댓글 수

				list.add(dto);

			}

			return list;

		} catch (Exception e) {
			System.out.println("BoardCommunityDAO.list()");
			e.printStackTrace();
		}

		return null;
	}

	// public BoardCommunityDTO get(String seqCommunity) { //오류나면 여기 수정하기*****
	public BoardCommunityDTO get(String seq) { // 오류나면 여기 수정하기*****

		try {

			// 오류나면 여기 수정하기*****
			String sql = "select a.*, (select nickName from tblAllUser where seqAllUser = a.seqUser) as nickName from tblCommunity a where seqCommunity = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);

			rs = pstat.executeQuery();

			if (rs.next()) {
				BoardCommunityDTO dto = new BoardCommunityDTO();

				dto.setSeqCommunity(rs.getString("seqCommunity"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setViewCount(rs.getInt("viewCount"));
				dto.setSeqAllUser(rs.getString("seqUser"));

				dto.setNickName(rs.getString("nickName"));

				return dto;

			}

		} catch (Exception e) {
			System.out.println("BoardCommunityDAO.get()");
			e.printStackTrace();
		}

		return null;
	}

	// View 서블릿 -> 조회수 증가 +1
	// 조회수 증가시키기
	public void updateViewCount(String seq) { // 오류나면 여기수정하기*****

		try {

			String sql = "update tblCommunity set viewCount = viewCount +1 where seqCommunity = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);

			pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("BoardCommunityDAO.updateViewCount()");
			e.printStackTrace();
		}

	}

	// EditOk 서블릿 -> 글 수정
	public int edit(BoardCommunityDTO dto) {

		try {

			String sql = "update tblCommunity set title = ?, content = ? where seqCommunity = ?";

//			System.out.println(dto.getTitle());
//			System.out.println(dto.getContent());
//			System.out.println(dto.getSeqCommunity());

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getSeqCommunity());

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("BoardCommunityDAO.edit()");
			e.printStackTrace();
		}

		return 0;

	}

	// 게시글 삭제
	public int del(String seq) {

		try {

			// String sql = "update tblCommunity set content = ' ', title = ' ' where
			// seqCommunity = ?";
			String sql = "delete from tblCommunity where seqCommunity = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);

			return pstat.executeUpdate(); // 1 or 0

		} catch (Exception e) {
			System.out.println("BoardCommunityDAO.del()");
			e.printStackTrace();
		}

		return 0;
	}

	// List 서블릿 -> 총 게시물 수 반환
	public int getTotalCount(HashMap<String, String> map) {

		try {

			String where = "";

			if (map.get("search") != null) {
				// 로그인 연동 후 수정하기*****
//				where = String.format("where nickName like '%%%s%%' or title like '%%%s%%' or content like '%%%s%%'", map.get("search"), map.get("search"), map.get("search"));
				where = String.format("where title like '%%%s%%' or content like '%%%s%%'", map.get("search"),
						map.get("search"));
			}

			String sql = String.format("select count(*) as cnt from tblCommunity %s", where);

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			if (rs.next()) {
				return rs.getInt("cnt");
			}

		} catch (Exception e) {
			System.out.println("BoardCommunityDAO.getTotalCount()");
			e.printStackTrace();
		}

		return 0;
	}

	// CommentCommunityOk 서블릿 -> 댓글 쓰기
	public int writeComment(CommentCommunityDTO dto) {

		try {

			String sql = "insert into tblCommunityComment (seqCommunityComment, seqCommunity, seqUser, content, writeDate) values (seqCommunityComment.nextVal, ?, ?, ?, sysdate)";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getSeqCommunity());
//			pstat.setString(2, dto.getSeqUser());
			pstat.setString(2, dto.getSeqAllUser());
			pstat.setString(3, dto.getCcontent());

			return pstat.executeUpdate(); // 1 or 0

		} catch (Exception e) {
			System.out.println("BoardCommunityDAO.writeComment()");
			e.printStackTrace();
		}

		return 0;
	}

	public ArrayList<CommentCommunityDTO> listComment(String seqCommunity) {

		try {

			String sql = "select c.*, (select nickName from tblAllUser where seqAllUser = c.seqUser) as nickName from tblCommunityComment c where c.seqCommunity = ? order by c.seqCommunityComment desc";

			// System.out.println(sql);
			// System.out.println(seqCommunity);

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seqCommunity); // 부모 글 번호

			rs = pstat.executeQuery();

			ArrayList<CommentCommunityDTO> clist = new ArrayList<CommentCommunityDTO>();

			while (rs.next()) {

				CommentCommunityDTO dto = new CommentCommunityDTO();
//				dto.setSeq(rs.getString("seq"));
				dto.setSeqCommunityComment(rs.getString("seqCommunityComment"));
				dto.setCcontent(rs.getString("content"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setSeqAllUser(rs.getString("seqUser"));
//				dto.setSeqUser(rs.getString("seqUser"));
				dto.setSeqCommunity(rs.getString("seqCommunity"));

				dto.setNickName(rs.getString("nickName"));

				clist.add(dto);
			}

			return clist;

		} catch (Exception e) {
			System.out.println("BoardCommunityDAO.listComment()");
			e.printStackTrace();
		}
		return null;
	}

	// 오류나면 수정하기****
	public int deleteComment(String seq) {
		
		try {
			
			String sql = "delete from tblCommunityComment where seqCommunityComment = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);

			return pstat.executeUpdate(); //1 or 0
			
		} catch (Exception e) {
			System.out.println("BoardCommunityDAO.deleteComment()");
			e.printStackTrace();
		}
		
		return 0;
	}

}
