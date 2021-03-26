package com.myhome.admin2.used;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 중고장터 게시글 부정 글 자동 처리 페이지 서블릿
 * @author 이대홍
 *
 */

@WebServlet("/admin2/used/check.do")
public class Check extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		String seqUsed = req.getParameter("seq");

		UsedDAO dao = new UsedDAO();
		
		int result = dao.check(seqUsed);
		
		dao.close();
		if (result > 0) {

			PrintWriter writer = resp.getWriter();
			writer.println("<HTML><body>");
			writer.println("<Script>");
			writer.println("alert('Contains Prohibited Articles')");
			writer.println("history.back();");
			writer.println("</script>");
			writer.println("</body></HTML>");
			writer.close();
		} else {
			PrintWriter writer = resp.getWriter();
			writer.println("<HTML><body>");
			writer.println("<Script>");
			writer.println("alert('clean')");
			writer.println("history.back();");
			writer.println("</script>");
			writer.println("</body></HTML>");

			writer.close();
		}
		
	}

}
