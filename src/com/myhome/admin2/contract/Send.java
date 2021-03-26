package com.myhome.admin2.contract;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 전자계약관련 안내메세지 전공 DB작업 서블릿 
 * @author 이대홍
 */
@WebServlet("/admin2/contract/send.do")
public class Send extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin2contract/send.jsp");
		dispatcher.forward(req, resp);

	}

}
