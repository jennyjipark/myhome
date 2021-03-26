package com.myhome;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 
 * @author 박지현
 * 메인 클래스
 *
 */
@WebServlet("/Myhome/main.do")
public class Main extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		MainDAO dao = new MainDAO();
		
		
		//카운트 박스
		
		//1. 전체매물
		int count1 = dao.count1();
		
		//2. 계약완료 매물
		int count2 = dao.count2();
		
	
		//공지, 청약, 체크리스트
		
		ArrayList<MainDTO> notice = dao.notice();
		ArrayList<MainDTO> checkList = dao.checkList();
		ArrayList<MainDTO> application = dao.application();
		
		req.setAttribute("notice", notice);
		req.setAttribute("checkList", checkList);
		req.setAttribute("application", application);
		
		req.setAttribute("count1", count1);
		req.setAttribute("count2", count2);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/Myhome/main.jsp");
		dispatcher.forward(req, resp);
		
	}
}


