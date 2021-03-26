package com.myhome.contractor.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contractor/nav.do")
public class Nav extends HttpServlet{

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//http://localhost:8090/Myhome_project/contractor/nav.do
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/contractor/nav.jsp");
		dispatcher.forward(request, response);
		
		//중개인은 중고장터, 커뮤니티 접근권한이 없음
	}
}
