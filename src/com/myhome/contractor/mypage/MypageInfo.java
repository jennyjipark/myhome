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



@WebServlet("/contractor/mypage-info.do")
public class MypageInfo extends HttpServlet{

	//http://localhost:8090/Myhome_project/contractor/mypage-info.do
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//1. 내 정보
		ContractorDAO dao = new ContractorDAO();
		
		//session 받는다.
		HttpSession session = req.getSession();
		
		//seq를 보내준다
		ArrayList<ContractorDTO> list = dao.list(session.getAttribute("seqAllUser").toString());
		
		//내 정보 보내기
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/contractor/mypage-info.jsp");
		dispatcher.forward(req, resp);
		
	}
}
