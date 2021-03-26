package com.myhome.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Myhome/user/boardcommunityeditok.do")
public class BoardCommunityEditOk extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		req.setCharacterEncoding("UTF-8");
		

		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
//		String seqCommunity = req.getParameter("seqCommunity");
		String seqCommunity = req.getParameter("seqCommunity");
		
		
		String seqAllUser = String.valueOf(session.getAttribute("seqAllUser"));
		
		
		
		BoardCommunityDAO dao = new BoardCommunityDAO();
		BoardCommunityDTO dto = new BoardCommunityDTO();
		
		dto.setTitle(title);
		dto.setContent(content);
		dto.setSeqCommunity(seqCommunity); //글번호
		dto.setSeqAllUser(seqAllUser);
		
		int result = dao.edit(dto); //글수정하기 0 or 1
		
		if (result == 1) {
			//글수정 성공 -> 게시판 목록으로 이동(귀찮을 때 쓰는 용도)
			//resp.sendRedirect("/codestudy/board/list.do");
			
			//글수정 성공 -> 글보기로 이동(view.do) (이걸로 보통 많이 쓴다.)
			//http://localhost:8090/codestudy/board/view.do?seq=13
			//오류나면 seq 수정ㅎ아기*****
			resp.sendRedirect("/Myhome_project/Myhome/user/boardcommunityview.do?seq=" + seqCommunity);
			
		} else {
			//글수정 실패 -> 경고 + 뒤로 가기
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('editok failed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
		}
		
	}

}
