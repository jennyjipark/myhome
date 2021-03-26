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

@WebServlet("/contractor/mypage-myproperty.do")
public class Myproperty extends HttpServlet{

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//1. 매물 정보
		PropertyDAO dao = new PropertyDAO();
						
		//2. session 받기
		HttpSession session = req.getSession();
						
		//3. 중개인 seq 쿼리에 보내기
		int seqContractor = Integer.parseInt(session.getAttribute("seqAllUser").toString());
		ArrayList<PropertyDTO> list = dao.list(seqContractor);
						
		//4. 올린매물리스트 보내기
		req.setAttribute("list", list);
				
		//http://localhost:8090/Myhome_project/contractor/mypage-myproperty.do
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/contractor/mypage-myproperty.jsp");
		dispatcher.forward(req, resp);
		
	}
}
