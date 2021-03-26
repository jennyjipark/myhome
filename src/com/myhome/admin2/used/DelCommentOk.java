package com.myhome.admin2.used;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 중고장터 게시글의 댓글 삭제 DB처리 서블릿
 * @author 이대홍
 *
 */
public class DelCommentOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seqUsedComment = req.getParameter("seq");

		UsedDAO dao = new UsedDAO();
		
		int result = dao.delComment(seqUsedComment);

		dao.close();
		if (result > 0) {

			resp.sendRedirect("/Myhome_project/admin2/used/list.do");

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
