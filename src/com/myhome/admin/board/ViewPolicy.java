package com.myhome.admin.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * 부동산정책 게시판 상세페이지 서블릿입니다.
 * @author MY
 *
 */
@WebServlet("/admin/board/viewpolicy.do")
public class ViewPolicy extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 데이터 가져오기(seq)
		//2. DB 작업 -> select
		//3. 결과 반환 -> JSP 호출하기 + 전달
		
		//1.
		String seq = req.getParameter("seq");
		
		//2.
		PolicyDAO dao = new PolicyDAO();
		
		/* 조회수증가 */
		dao.updateViewcount(seq);
		
		//번호를 넘겨주면 글번호에 해당하는 글을 가져온다
		PolicyDTO dto = dao.getpolicy(seq);
		
		dao.close(); //****
		
		
		//2.5 데이터조작
		/* 개행 문자 출력 */
		dto.setContent(dto.getContent().replace("\r\n", "<br>"));
		
		
		//3. JSP에게 넘겨주기
		req.setAttribute("dto", dto);
		
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/adminboard/viewpolicy.jsp");
		dispatcher.forward(req, resp);

	}

}




