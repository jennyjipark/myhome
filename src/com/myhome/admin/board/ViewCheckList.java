package com.myhome.admin.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/***
 * 체크리스트 게시판 상세페이지 서블릿입니다.
 * @author MY
 *
 */
@WebServlet("/admin/board/viewchecklist.do")
public class ViewCheckList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		//1.
		String seq = req.getParameter("seq");
		
		//2.
		ChecklistDAO dao = new ChecklistDAO();
		
		/* 조회수증가 */
		
		dao.updateViewcount(seq);
		
		ChecklistDTO dto = dao.getchecklist(seq);
		
		dao.close(); //****
		
		//2.5 데이터조작
		/* 개행 문자 출력 */
		dto.setContent(dto.getContent().replace("\r\n", "<br>"));
		
		//3.
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/adminboard/viewchecklist.jsp");
		dispatcher.forward(req, resp);

	}

}
