package com.myhome.admin2.notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 공지사항 게시글 삭제 DB 작업 서블릿
 * @author 이대홍
 *
 */
@WebServlet("/admin2/notice/deleteok.do")
public class DeleteOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// update로 빈문자열로 변경합니다. . 제목만. .
		String[] seqNotice = req.getParameterValues("seq");// 배열로 번호를 받음.

		NoticeDAO dao =new NoticeDAO();
		
		int result = dao.delete(seqNotice);
		dao.close();
		if (result > 0) {
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
