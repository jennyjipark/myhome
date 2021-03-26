package com.myhome.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Myhome/user/boardpolicyview.do")
public class BoardPolicyView extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String seq = request.getParameter("seq"); //오류나면 여기 수정하기*****
		String search = request.getParameter("search"); //검색어
		String page = request.getParameter("page");
		
		BoardPolicyDAO dao = new BoardPolicyDAO();
		
		if (session.getAttribute("read") == null || (boolean)session.getAttribute("read") == false) {
			
			dao.updateViewCount(seq);
			session.setAttribute("read", true);
		}
		
		BoardPolicyDTO dto = dao.get(seq);
		
		dao.close();
		dto.setContent(dto.getContent().replace("\r\n", "<br>"));
		
		request.setAttribute("dto", dto);
		request.setAttribute("search", search);
		request.setAttribute("page", page);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user/board-policy-view.jsp");
		dispatcher.forward(request, response);
		
	}

}
