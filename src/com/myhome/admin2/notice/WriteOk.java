package com.myhome.admin2.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 공지사항 게시글 작성 DB용 서블릿 
 * @author 홍
 *
 */
@WebServlet("/admin2/notice/writeok.do")
public class WriteOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession();

		String seqAdmin = (String) session.getAttribute("seqAdmin");

		String title = req.getParameter("title");
		String content = req.getParameter("content");
		System.out.println("title : "+ title);
		NoticeDAO dao = new NoticeDAO();
		NoticeDTO dto = new NoticeDTO();

		dto.setSeqAdmin(seqAdmin);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setViewCount("0");

		int result = dao.write(dto);

		
		dao.close();
		if (result == 1) {
			resp.sendRedirect("/Myhome_project/admin2/notice/list.do");
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
