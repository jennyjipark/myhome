package com.myhome.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 중고장터 댓글 작성을 요청하는 클래스입니다.
 * @author 이준오
 *
 */
@WebServlet("/user/usedcommentwrite.do")
public class UsedCommentWrite extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 받은 (세션:회원번호 / 중고게시글번호, 내용)정보 찾기
		//2. DB작업 -> insert 
		//3. 결과 출력
		
		//1.
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		
		//정리..
		String content = req.getParameter("commenttxt");
		int seqUsed = Integer.parseInt(req.getParameter("hiddenseq")); 
		int seqUser = Integer.parseInt(session.getAttribute("seqAllUser").toString());
		
		
		//2.
		BoardUsedDAO dao = new BoardUsedDAO();
		UsedCommentDTO dto = new UsedCommentDTO();
		
		dto.setContent(content);
		dto.setSeqUsed(seqUsed);
		dto.setSeqUser(seqUser);
		
		
		int result = dao.writeComment(dto);
		
		if (result==1) {
			//성공

			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('insert Success');");
			writer.print(String.format("location.href='/Myhome_project/user/boardusedview.do?seq="+seqUsed+"'"));
			writer.print("</script>");
			writer.print("</body></html>");
			
		} else {
			//실패
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('insert Failed');");
			writer.print(String.format("location.href='/Myhome_project/user/boardusedview.do?seq="+seqUsed+"'"));
			writer.print("</script>");
			writer.print("</body></html>");
			
			
		}
		
		
	}
	
}
