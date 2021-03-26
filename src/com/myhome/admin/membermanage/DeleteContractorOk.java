package com.myhome.admin.membermanage;

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
 * 중개인회원 삭제 처리 서블릿입니다.
 * @author 윤지현
 *
 */
@WebServlet("/admin/membermanage/deletecontractorok.do")
public class DeleteContractorOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 가져오기(seq)
		//2. 권한 확인?
		//3. DB 작업 -> delete
		//4. 결과 처리
		
		HttpSession session = req.getSession();
		
		//1. 
		req.setCharacterEncoding("UTF-8");
		
		String state = req.getParameter("state");
		String seq = req.getParameter("seq"); //삭제할 글번호
		
		
		//2.
		ManageContractorDAO dao = new ManageContractorDAO();
		ManageContractorDTO dto = new ManageContractorDTO();
		
		dto.setState(state);
		dto.setSeq(seq); //글번호
		
		int result = dao.del(dto);	//글삭제하기
		
		if (result == 1) {
			//글삭제 성공 -> 게시판 목록으로 이동
			resp.sendRedirect("/Myhome_project/admin/membermanage/membermanage-contractor.do");
			
			
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
