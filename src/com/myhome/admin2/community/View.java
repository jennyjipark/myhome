package com.myhome.admin2.community;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 정보공유 게시글 1개 상세 보기 페이지 
 * @author 이대홍
 */
@WebServlet("/admin2/community/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seqCommunity = req.getParameter("seq");// 청약테이블 번호

		CommunityDAO dao = new CommunityDAO();
		CommunityDTO dto = dao.view(seqCommunity);
		
		ArrayList<CommunityCommentDTO> list = dao.comment(seqCommunity);
		
		dto.setWriteDate(dto.getWriteDate().substring(0, 10));
		
		for(CommunityCommentDTO temp : list) {
			
			temp.setWriteDate(temp.getWriteDate().substring(0, 10)); 
			
			if(temp.getContent().equals(" ")) {
				temp.setContent("삭제된댓글");
			}
		
		}
		dao.close();
		
		req.setAttribute("dto", dto);
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin2community/view.jsp");
		dispatcher.forward(req, resp);

	}

}
