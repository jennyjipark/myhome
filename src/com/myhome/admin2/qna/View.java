package com.myhome.admin2.qna;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myhome.admin2.notice.NoticeDTO;

/**
 * QNA 목록 반환 페이지서블릿
 * @author 이대홍
 *
 */
@WebServlet("/admin2/qna/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String seq = req.getParameter("seq");
		String category = req.getParameter("category");
		
		QnaDAO dao = new QnaDAO();
		QnaDTO dto = dao.view(seq,category);
		
		String state = dto.getState();
		
		if( state.equals("완료") ) {
			QnaCommentDAO qCdao = new QnaCommentDAO();
			QnaCommentDTO qCdto = qCdao.getComment(seq);	
			req.setAttribute("qCdto", qCdto);
		}		
		
		// 날짜 추출
		
		dto.setWriteDate(dto.getWriteDate().substring(0, 10));

		dao.close();
		req.setAttribute("category", category);
		req.setAttribute("dto", dto);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin2qna/view.jsp");
		dispatcher.forward(req, resp);

	}

}
