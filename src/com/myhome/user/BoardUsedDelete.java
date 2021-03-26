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
 * 중고장터 게시판에서 글삭제를 요청하는 클래스입니다.
 * @author 이준오
 *
 */
@WebServlet("/user/boarduseddelete.do")
public class BoardUsedDelete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 받아온 게시글번호 확인, 회원번호
		//2. DB작업. 글 지우기 
		//3. 글지운결과 1, 0 전송.. 1 : 성공 , 0 : 실패
		
		//1.
		int seqUsed = Integer.parseInt(req.getParameter("seq").toString());
		
		HttpSession session = req.getSession();
		int seqUser = Integer.parseInt(session.getAttribute("seqAllUser").toString());
		
		//2.
		BoardUsedDAO dao = new BoardUsedDAO();
		
		int result = dao.deleteUsed(seqUsed, seqUser);
		
		if (result==1) {

			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('delete Success');");
			writer.print(String.format("location.href='/Myhome_project/user/boardusedlist.do'"));
			writer.print("</script>");
			writer.print("</body></html>");
			
		} else {

			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('delete Failed');");
			writer.print(String.format("location.href='/Myhome_project/user/boardusedlist.do'"));
			writer.print("</script>");
			writer.print("</body></html>");
			
		}
		

	}

}
