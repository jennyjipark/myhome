package com.myhome.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 중고장터 댓글을 삭제를 요청하는 클래스
 * @author 이준오
 *
 */
@WebServlet("/user/usedcommentdelete.do")
public class UsedCommentDelete extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 지우려는 해당 댓글 번호 받기.
		//2. DB작업 -> delete
		//3. 결과 반환
		
		//1.
		int seqUsedComment = Integer.parseInt(req.getParameter("ucseqhidden"));
		int seqUsed = Integer.parseInt(req.getParameter("ucseqhidden2"));
		
		//2.
		BoardUsedDAO dao = new BoardUsedDAO();
		
		int result = dao.deleteComment(seqUsedComment);
		
		if (result==1) {
			//성공

			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('delete Success');");
			writer.print(String.format("location.href='/Myhome_project/user/boardusedview.do?seq="+seqUsed+"'"));
			writer.print("</script>");
			writer.print("</body></html>");
			
		} else {
			//실패
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('delete Failed');");
			writer.print(String.format("location.href='/Myhome_project/user/boardusedview.do?seq="+seqUsed+"'"));
			writer.print("</script>");
			writer.print("</body></html>");
			
			
		}
		
		
		
	}
	
}
