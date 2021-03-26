package com.myhome.admin2.qna;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.myhome.DBUtil;


/**
 * QNA 질문 답글 반환 DB작업 페이지 
 * @author 이대홍
 *
 */
public class QnaCommentDAO {

	private Connection conn;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;
	private CallableStatement ct;

	public QnaCommentDAO() {
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

	//ProcQnaAnswer
	// 답변이 1개만있고.. 첫번째 답변만 반환
	public QnaCommentDTO getComment(String seq) {

		try {
			
			String sql = String
					.format("select * from tblQnaComment where seqQna = %s", seq );

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {

				QnaCommentDTO dto = new QnaCommentDTO();

				dto.setSeqQna(rs.getString("seqQna"));
				dto.setSeqAdmin(rs.getString("seqAdmin"));
				dto.setSeqQna(rs.getString("seqQna"));
				dto.setContent(rs.getString("content"));
				dto.setWriteDate(rs.getString("writeDate"));
				
				rs.close();
				ps.close();
				
				return dto; 
			}
				
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("getComment : " +e);
		}

		return null;
	}

}
