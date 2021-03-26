package com.myhome.admin2.application;

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
 * 청약 게시글 삭제 업무 처리  서블릿
 * @author 이대홍
 */
@WebServlet("/admin2/application/deleteok.do")
public class DeleteOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// update로 빈문자열로 변경합니다. . 제목만. .
		String[] seqApplication = req.getParameterValues("seq");// 배열로 번호를 받음.

		ApplicationDAO dao =new ApplicationDAO();
		
		int result = dao.delete(seqApplication);

		dao.close();
		if (result > 0) {
			
			resp.sendRedirect("/Myhome_project/admin2/application/list.do");
			
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
