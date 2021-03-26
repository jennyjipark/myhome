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
 * 청약 게식글 글쓰기 서블릿 
 * @author 이대홍
 *
 */
@WebServlet("/admin2/application/write.do")
public class Write extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin2application/write.jsp");
		dispatcher.forward(req, resp);

	}

}
