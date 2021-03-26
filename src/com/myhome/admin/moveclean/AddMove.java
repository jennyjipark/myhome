package com.myhome.admin.moveclean;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/***
 * 이사업체 등록 페이지 서블릿입니다.
 * @author 윤지현
 *
 */
@WebServlet("/admin/moveclean/addmove.do")
public class AddMove extends HttpServlet{

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인 안한 사람이 접근하면 내쫒기
		HttpSession session = req.getSession();	
		
		//if(session.getAttribute("id") == null) {
			
			//1. 내쫒기
			/*
			 * response.sendRedirect("/Myhome_project/admin/moveclean/listmove.do"); 
			 * return; //아래 RequestDispatcher 충돌을 막기위해
			 */			
			//2. 경고 + 내쫒기
		/*
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('filed');");
			writer.print("location.href='/Myhome_project/admin/moveclean/listmove.do';");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			*/
		//}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/adminmoveclean/addmove.jsp");
		dispatcher.forward(req, resp);
		
	}
	
}
