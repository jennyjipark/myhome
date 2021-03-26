package com.myhome.contractor.mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/contractor/mypage-matching2.do")
public class MypageMatching2 extends HttpServlet{

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 중개인이 신청한 매칭
		MatchingDAO dao = new MatchingDAO();
					
		//2. session 받기
		HttpSession session = req.getSession();
					
		//3. 중개인 seq 쿼리에 보내기
		ArrayList<MatchingDTO> list = dao.listLessor(session.getAttribute("seqAllUser").toString());
					
		//4. 보내기
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/contractor/mypage-matching2.jsp");
		dispatcher.forward(req, resp);
		
	}
}
