package com.myhome.contractor.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 중개인 마이페이지 메인 접근 클래스
 *
 *
 */
@WebServlet("/contractor/mypage.do")
public class Mypage extends HttpServlet{

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//session 받기
		HttpSession session = req.getSession();
		int seqContractor = Integer.parseInt(session.getAttribute("seqAllUser").toString());
		
		
		//http://localhost:8090/Myhome_project/contractor/mypage.do
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/contractor/mypage.jsp");
		dispatcher.forward(req, resp);
		
	}
}
