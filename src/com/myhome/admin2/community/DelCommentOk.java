package com.myhome.admin2.community;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 정보공유 댓글 삭제 DB처리 서블릿 
 * @author 이대홍
 */
@WebServlet("/admin2/community/delcommentok.do")
public class DelCommentOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seqCommunityComment = req.getParameter("seq");
		String seqCommunity = req.getParameter("seqC");
		 
		
		CommunityDAO dao = new CommunityDAO();
		
		int result = dao.delComment(seqCommunityComment);
		
		dao.close();
		if (result > 0) {

			resp.sendRedirect("/Myhome_project/admin2/community/view.do?seq="+seqCommunity);

		} else {
			PrintWriter writer = resp.getWriter();
			writer.println("<HTML><body>");
			writer.println("<Script>");
			writer.println("alert('failed')");
			writer.println("history.back();");
			writer.println("</script>");
			writer.println("</body></HTML>");

			writer.close();
		}

	}

}
