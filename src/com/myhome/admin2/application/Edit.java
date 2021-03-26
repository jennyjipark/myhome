package com.myhome.admin2.application;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 청약 수정게시글 수정 확인게시판 반환 서블릿 
 * @author 이대홍
 *
 */
@WebServlet("/admin2/application/edit.do")
public class Edit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*
 * 02/22
 * 
 * 넘어온 정보를 바탕으로 정보사항을 출력
 * 
 */
		
		HttpSession session= req.getSession();
		
		String seq = req.getParameter("seq");// 청약테이블 번호

		ApplicationDAO dao = new ApplicationDAO();
		ApplicationDTO dto = dao.view(seq);

		
		if(session.getAttribute("read")==null || 
				(boolean)session.getAttribute("read")==false) {
			dao.count(seq);
			session.setAttribute("read",true);
		}
		
		
		dto.setWritedate(dto.getWritedate().substring(0, 10));
	
		
		dao.close();
		req.setAttribute("dto", dto);

		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin2application/edit.jsp");
		dispatcher.forward(req, resp);

	}

}
