package com.myhome.admin2.application;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 청약 1개 게시글의 부가 상세 내용 서블릿 
 * MAP API, CHART, Rolling CSS 기능 추가 
 * @author 이대홍
 */
@WebServlet("/admin2/application/map.do")
public class Map extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seq = req.getParameter("seq");// 청약테이블 번호

		
		req.setAttribute("seq", seq);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin2application/map.jsp");
		dispatcher.forward(req, resp);

	}

}
