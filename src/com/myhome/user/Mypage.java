package com.myhome.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 마이페이지 초기화면을 출력하는 클래스입니다.
 * @author 이준오
 *
 */
@WebServlet("/user/mypage.do")
public class Mypage extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//로그인 안한 사람이 접근하면 내쫒기
		HttpSession session = req.getSession();
		
		if (session.getAttribute("seqAllUser") == null) {
			
			//1. 내쫒기
			//response.sendRedirect("/codestudy/board/list.do");
			//return;
			
			//2. 경고(JavaScript) + 내쫒기
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('Please Do Login');");
			writer.print("location.href='/Myhome_project/Myhome/main.do';");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
			return;			
			
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/mypage.jsp");
		dispatcher.forward(req, resp);

	}

}
