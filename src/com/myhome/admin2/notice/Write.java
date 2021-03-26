package com.myhome.admin2.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 공지사항 게시글 작성 페이지 서블릿 
 * @author 이대홍
 *
 */
@WebServlet("/admin2/notice/write.do")
public class Write extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin2notice/write.jsp");
		dispatcher.forward(req, resp);

	}

}
