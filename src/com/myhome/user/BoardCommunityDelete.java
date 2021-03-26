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


@WebServlet("/Myhome/user/boardcommunitydelete.do")
public class BoardCommunityDelete extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String seq = request.getParameter("seq");
		
		//2.
		BoardCommunityDAO dao = new BoardCommunityDAO();
		BoardCommunityDTO dto = dao.get(seq); //글보기(view.do 에서 사용하던 메소드)
		
		//2.5
		//글쓴이가 맞는지 확인?
		HttpSession session = request.getSession();
		
		/* if (!dto.getId().equals((String)session.getAttribute("id"))) { */
		/* if (!dto.getNickName().equals((String)session.getAttribute("nickName"))) {*/ 
		if (!dto.getSeqAllUser().equals(String.valueOf(session.getAttribute("seqAllUser")))) {
			
			//권한 없음 -> 쫓아내기
			PrintWriter writer = response.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('failed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
			return;//*** 쫓아내고 메소드 쫑내기	
		}
		
		request.setAttribute("seq", seq);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user/board-community-delete.jsp");
		dispatcher.forward(request, response);
		
	}

}
