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


@WebServlet("/Myhome/user/boardcommunitydeleteok.do")
public class BoardCommunityDeleteOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
//		세션에 있는 회원정보(회원번호 등)을 가져오기 위해 세션을 불러오는 코드.
		
		//1.
		req.setCharacterEncoding("UTF-8");
		
//		String seqCommunity = req.getParameter("seqCommunity"); //삭제할 글번호
		String seq = req.getParameter("seq"); //삭제할 글번호
		
		//2.
		BoardCommunityDAO dao = new BoardCommunityDAO();
		

		//테스트중
//		BoardCommunityDTO dto = dao.get(seq);
		
		
		
		
//		int result = dao.del(seqCommunity); //글삭제하기
		int result = dao.del(seq); //글삭제하기
		
		if (result == 1) {
			//글삭제 성공 -> 게시판 목록으로 이동(귀찮을 때 쓰는 용도)
			resp.sendRedirect("/Myhome_project/Myhome/user/boardcommunitylist.do");

			
		} else {
			//글삭제 실패 -> 경고 + 뒤로 가기
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('failed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
		}
		

		
		

	}

}