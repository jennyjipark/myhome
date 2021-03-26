package com.myhome.admin.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * 체크리스트 페이지 수정 서블릿입니다.
 * @author 윤지현
 *
 */
@WebServlet("/admin/board/editchecklist.do")
public class EditCheckList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 가져오기(seq)
		//2. DB 작업 -> select
		//3. 결과 반환 -> JSP 호출하기

		//1.
		String seq = req.getParameter("seq");
		
		//2.
		ChecklistDAO dao = new ChecklistDAO();
		ChecklistDTO dto = dao.getchecklist(seq);
		
/*		HttpSession session = req.getSession();
		
		if(!dto.getId().equals((String)session.getAttribute("id"))) {
			
			//권한 없음 -> 쫒아내기
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('filed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
			return;//**********
		}
*/		
		
		
		//3.
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/adminboard/editchecklist.jsp");
		dispatcher.forward(req, resp);

	}

}
