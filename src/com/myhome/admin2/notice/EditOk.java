package com.myhome.admin2.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
/**
 * 공지사항 게시글 수정 DB작업 서블릿
 * @author 이대홍
 *
 */
@WebServlet("/admin2/notice/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		//
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String seqNotice = req.getParameter("seqNotice");

		NoticeDAO dao = new NoticeDAO();
		NoticeDTO dto = new NoticeDTO();

		dto.setSeqNotice(seqNotice);
		dto.setTitle(title);
		dto.setContent(content);

		int result = dao.edit(dto);
		
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
