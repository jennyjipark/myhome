package com.myhome.admin2.report;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 신고게시글 관련 목록 반환 페이지 서블릿
 * @author 이대홍
 *
 */

@WebServlet("/admin2/report/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String seq = req.getParameter("seq");// 신고번호
		String category = req.getParameter("category");// 카테고리 번호

		
		ReportDAO dao = new ReportDAO();
		ReportDTO dto = dao.view(seq,category);

		
		dao.close();
		req.setAttribute("category", category);
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin2report/view.jsp");
		dispatcher.forward(req, resp);

	}

}
