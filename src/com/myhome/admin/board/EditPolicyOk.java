package com.myhome.admin.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/***
 * 부동산정책 게시판 수정 처리 서블릿입니다.
 * @author 윤지현
 *
 */
@WebServlet("/admin/board/editpolicyok.do")
public class EditPolicyOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 가져오기 (seq, title, content)
		//2. DB작업 -> update
		//3. 결과 처리 -> 알림
		
		HttpSession session = req.getSession();
		
		//1.
		req.setCharacterEncoding("UTF-8");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String seq = req.getParameter("seq"); //수정할 글번호
		
		
		//2.
		PolicyDAO dao = new PolicyDAO();
		PolicyDTO dto = new PolicyDTO();
		
		dto.setTitle(title);
		dto.setContent(content);
		dto.setSeq(seq);
		
		int result = dao.editpolicy(dto); //수정하기
		
		if (result == 1) {
	
			//글수정 성공 -> 글보기로 이동 (view.do)
			
			resp.sendRedirect("/Myhome_project/admin/board/viewpolicy.do?seq=" + seq);
			
		} else {
			//글수정 실패 -> 경고 + 뒤로가기
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