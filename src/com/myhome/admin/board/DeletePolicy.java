package com.myhome.admin.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/***
 * 부동산 정책 삭제 서블릿입니다.
 * @author 윤지현
 *
 */
@WebServlet("/admin/board/deletepolicy.do")
public class DeletePolicy extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//1.
		//String seq = req.getParameter("seq");
		//배열로 번호 받기
		String[] seq = req.getParameterValues("seq");
		
		PolicyDAO dao = new PolicyDAO();
		
		//삭제할 목록 
		ArrayList<PolicyDTO> list = dao.list(seq);
		
		
		dao.close();
		
		req.setAttribute("list", list);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/adminboard/deletepolicy.jsp");
		dispatcher.forward(req, resp);
		

		
	}

}

