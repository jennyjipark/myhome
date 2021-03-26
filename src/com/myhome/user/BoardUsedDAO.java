package com.myhome.user;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.myhome.DBUtil;

/**
 * 중고장터 게시판의 DB작업을 담당하는 클래스입니다.
 * @author 이준오
 *
 */
public class BoardUsedDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	private CallableStatement cstat;

	
	public BoardUsedDAO() {
		// DB 연결
		conn = DBUtil.open();
	}


	public void close() {
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}


	
	/**
	 * 검색어에 따른 출력 할 중고장터 게시글 목록을 가져온다.
	 * @param map 중고장터 출력에 필요한 검색어, 필요 게시물 번호 등을 담은 HashMap입니다.
	 * @return 중고장터 게시물 목록입니다.
	 */
	public ArrayList<BoardUsedDTO> getList(HashMap<String, String> map) {
		ArrayList<BoardUsedDTO> list = new ArrayList<BoardUsedDTO>();

		try {
			String where ="";

			if (map.get("search")!=null) {
				where = String.format("where name like '%%%s%%' or title like '%%%s%%' or nickname like '%%%s%%'",map.get("search"),map.get("search"),map.get("search"));
			}

			String sql = String.format("select * from (select a.*, rownum as rnum from (select * from vwUsedUserVer2 %s order by seqUsed desc) a) where rnum between %s and %s"
														, where
														, map.get("begin")
														, map.get("end"));

			stat = conn.createStatement();

			rs = stat.executeQuery(sql);

			while(rs.next()) {
				BoardUsedDTO dto = new BoardUsedDTO();

				dto.setCategory(rs.getString("category"));
				dto.setImagePath(rs.getString("imagePath"));
				dto.setName(rs.getString("name"));
				dto.setNickname(rs.getString("nickname"));
				dto.setPrice(rs.getInt("price"));
				dto.setSeqUsed(rs.getInt("seqUsed"));
				dto.setSeqUser(rs.getInt("seqUser"));
				dto.setTitle(rs.getString("title"));
				dto.setTradeMode(rs.getString("tradeMode"));
				dto.setWriteDate(rs.getDate("writeDate"));
				dto.setCommentCount(rs.getInt("commentCount"));

				list.add(dto);			

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	//전체 글 수 반환
	/**
	 * 검색어에 따른 게시물 수를 가져옵니다.
	 * @param map  중고장터 출력에 필요한 검색어, 필요 게시물 번호 등을 담은 HashMap입니다.
	 * @return 해당하는 게시물의 총 수입니다.
	 */
	public int getTotalCount(HashMap<String, String> map) {
		int cnt = 0;
		try {
			String where ="";

			if (map.get("search")!=null) {
				where = String.format("where name like '%%%s%%' or title like '%%%s%%' or nickname like '%%%s%%'",map.get("search"),map.get("search"),map.get("search"));
			}

			String sql = String.format("select count(*) as cnt from vwUsedUserVer2 %s order by seqUsed desc", where);

			stat = conn.createStatement();

			rs = stat.executeQuery(sql);

			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}


	//상세 글 정보 반환

	/**
	 * 중고장터 게시글의 내용을 가져옵니다.
	 * @param seqUsed 중고장터 게시글의 번호입니다.
	 * @return 게시글의 정보입니다.
	 */
	public BoardUsedDTO getView(int seqUsed) {
		BoardUsedDTO dto = new BoardUsedDTO();
		try {

			String sql = "select seqUsed, seqUser, title, name, tradeMode, category, price, content from vwUsedUserVer2 where seqUsed = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seqUsed);

			rs = pstat.executeQuery();

			if(rs.next()) { 
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setTradeMode(rs.getString("tradeMode"));
				dto.setCategory(rs.getString("category"));
				dto.setPrice(rs.getInt("price"));
				dto.setContent(rs.getString("content"));
				dto.setSeqUser(rs.getInt("seqUser"));
				dto.setSeqUsed(rs.getInt("seqUsed"));
			}


		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	//댓글 목록 가져가기
	/**
	 * 게시물에 대한 댓글의 정보를 가져옵니다.
	 * @param seqUsed 중고장터 게시글의 번호입니다.
	 * @return 댓글의 정보입니다.
	 */
	public ArrayList<UsedCommentDTO> getComment(int seqUsed) {
		ArrayList<UsedCommentDTO> list = new ArrayList<UsedCommentDTO>();
		try {

			String sql = "select seqUsedComment, seqUser, (select nickname from tblAllUser where seqAllUser = a.seqUser) as nickname, content, writeDate from tblUsedComment a where seqUsed = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seqUsed);

			rs = pstat.executeQuery();

			while(rs.next()) {

				UsedCommentDTO dto = new UsedCommentDTO();
				dto.setSeqUsedComment(rs.getInt("seqUsedComment"));
				dto.setContent(rs.getString("content"));
				dto.setNickname(rs.getString("nickname"));
				dto.setWriteDate(rs.getDate("writeDate"));
				dto.setSeqUser(rs.getInt("seqUser"));

				list.add(dto);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	//글쓸때 필요한 작성자 이름 가져오기
	/**
	 * 회원의 번호에 따른 이름을 가져옵니다.
	 * @param seq 회원번호입니다.
	 * @return 회원 이름입니다.
	 */
	public BoardUsedDTO getWriterName(int seq) {
		BoardUsedDTO dto = new BoardUsedDTO();
		try {

			String sql = "select name from tblAllUser where seqAllUser = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setInt(1, seq);

			rs = pstat.executeQuery();

			if(rs.next()) {
				dto.setName(rs.getString("name"));
			}


		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}
	
	//DB insert작업. 글쓰기담당
	/**
	 * map의 정보를 통해 중고장터 게시글을 작성합니다.
	 * @param map 글의 정보입니다.
	 * @return DB작업(글쓰기)의 결과입니다.
	 */
	public int insertUsed(HashMap map) {
		int result = 0;

		try {

			String sql = "insert into tblUsed values(seqUsed.nextVal, ?, ?, 1, ?, ?, 1, sysdate, ?, ? )";

			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, (int)map.get("category"));
			pstat.setInt(2, (int)map.get("seq"));
			pstat.setString(3, (String)map.get("title"));
			pstat.setString(4, (String)map.get("content"));
			pstat.setInt(5, (int)map.get("price"));
			pstat.setString(6, (String)map.get("tradeMode"));

			result = pstat.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	
	//boarduseddelete.do -> 글 삭제 요청
	/**
	 * 중고장터 게시글을 삭제합니다.
	 * @param seqUsed 중고장터 게시글의 번호입니다.
	 * @param seqUser 회원 번호입니다.
	 * @return DB작업(글삭제)의 결과입니다.
	 */
	public int deleteUsed(int seqUsed, int seqUser) {
		
		int result = 0;
		
		try {
			
			String sql = "{call procDeleteUsed(?,?)}";
			
			cstat = conn.prepareCall(sql);
			cstat.setInt(1, seqUsed);
			cstat.setInt(2, seqUser);
			
			result = cstat.executeUpdate();
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//찜목록 추가하기 전에 중복된 찜목록이 있는지 확인.
	/**
	 * 찜목록이 중복되는지 검사합니다.
	 * @param dto 찜목록의 정보입니다.
	 * @return 해당하는 찜목록의 갯수 입니다.
	 */
	public int checkLike(LikesDTO dto) {
		
		int result = 0;
		
		try {
		
			String sql = "select count(*) as cnt from tblLikes where seqUser = ? and seqUsed = ?";

			pstat = conn.prepareStatement(sql);
			
			pstat.setInt(1, dto.getSeqUser());
			pstat.setInt(2, dto.getSeqUsed());
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				result = rs.getInt("cnt");
				
			}
			
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	//boardusedinsertlike.do -> 찜목록 추가 요청
	/**
	 * 찜목록을 추가합니다.
	 * @param dto 찜목록의 정보입니다.
	 * @return DB작업(찜목록 추가)의 결과입니다.
	 */
	public int insertLike(LikesDTO dto) {
		
		int result = 0;
		
		try {
			
			String sql = "insert into tblLikes values(seqLikes.nextVal, ?, null, ?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setInt(1, dto.getSeqUsed());
			pstat.setInt(2, dto.getSeqUser());
			
			result = pstat.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

	//boardusedinsertlike.do -> 찜목록 삭제 요청
	/**
	 * 기존에 등록된 찜목록을 삭제합니다.
	 * @param dto 찜목록의 정보입니다.
	 * @return DB작업(찜목록 추가)의 결과입니다.
	 */
	public int deleteLike(LikesDTO dto) {
		
		int result = 0;
		
		try {
			
			String sql = "delete from tblLikes where seqUser = ? and seqUsed = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setInt(1, dto.getSeqUser());
			pstat.setInt(2, dto.getSeqUsed());
			
			result = pstat.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return result;
		
	}
	
	//usedcommentwrite.do -> 댓글 작성 요청
	/**
	 * 댓글을 작성합니다.
	 * @param dto 댓글의 정보입니다.
	 * @return DB작업(댓글작성)의 결과입니다.
	 */
	public int writeComment(UsedCommentDTO dto) {
		
		int result = 0;
		
		try {
			
			String sql = "insert into tblUsedComment values(seqUsedComment.nextVal, ?, ?, ?, sysdate)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setInt(1, dto.getSeqUser());
			pstat.setInt(2, dto.getSeqUsed());
			pstat.setString(3, dto.getContent());
			
			result = pstat.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return result;
		
	}

	/**
	 * 댓글을 삭제합니다.
	 * @param seqUsedComment 중고장터 댓글 번호입니다.
	 * @return DB작업(댓글삭제)의 결과입니다.
	 */
	public int deleteComment(int seqUsedComment) {
		
		int result = 0;
		
		try {
			
			String sql = "delete from tblUsedComment where seqUsedComment = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seqUsedComment);
			
			result = pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}