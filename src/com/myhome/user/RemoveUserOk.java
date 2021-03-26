package com.myhome.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 회원삭제의 DB작업(회원삭제)를 요청하는 클래스입니다.
 * @author 이준오
 *
 */
@WebServlet("/user/removeuserok.do")
public class RemoveUserOk extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		//1. 탈퇴하는 회원번호 받아오기
		//2. DB작업 -> update
		//3. 결과 반환..
		
		//1.
		HttpSession session = req.getSession();
		
		//탈퇴하는 회원번호 seq에 저장
		int seq = Integer.parseInt(session.getAttribute("seqAllUser").toString());
		
		//2.
		UserDAO dao = new UserDAO();
		int result=0;
		try {
			result = dao.removeUser(seq);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (result==1) {
			PrintWriter writer = resp.getWriter();
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('success.');");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
			resp.sendRedirect("/Myhome_project/member/logout.do");
			
		} else {
			PrintWriter writer = resp.getWriter();
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('failed.');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
		}
		
		
	}
	
}
