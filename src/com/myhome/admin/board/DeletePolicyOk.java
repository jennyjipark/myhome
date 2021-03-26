package com.myhome.admin.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/***
 * 부동산 정책 삭제 처리 서블릿입니다.
 * @author 윤지현
 *
 */
@WebServlet("/admin/board/deletepolicyok.do")
public class DeletePolicyOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		HttpSession session = req.getSession();
		
		//1. 
		req.setCharacterEncoding("UTF-8");
		
		//String seq = req.getParameter("seq"); //삭제할 글번호
		String[] seq = req.getParameterValues("seq");
		
		//2.
		PolicyDAO dao = new PolicyDAO();
		
		int result = dao.delete(seq);	//글삭제하기
		
		if (result == 1) {
			//글삭제 성공 -> 게시판 목록으로 이동
			resp.sendRedirect("/admin/board/listepolicy.do");
			
			
		} else {
			//글삭제 실패 -> 경고 + 뒤로가기
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('filed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
		}

	}

}
