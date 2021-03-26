package com.myhome.admin2.qna;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * QNA 게시글 작성 DB업무 처리용 서블릿 
 * @author 이대홍
 *
 */
@WebServlet("/admin2/qna/writeok.do")
public class WriteOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		req.setCharacterEncoding("UTF-8");
		
		String seqAdmin = (String) session.getAttribute("seqAdmin");
		String content = req.getParameter("content");
		String seq = req.getParameter("seq");
		String category = req.getParameter("category");

		QnaDAO dao = new QnaDAO();
		
		int result = dao.write(seqAdmin,seq,content);
		
		dao.close();
		if(result==1) {
			
			resp.sendRedirect("/Myhome_project/admin2/qna/list.do?category="+category);
		
		
		}else {
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
