package com.myhome.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 중고장터 게시글 작성페이지를 출력하는 클래스입니다.
 * @author 이준오
 *
 */
@WebServlet("/user/boardusedwrite.do")
public class BoardUsedWrite extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 세션에서 회원번호받아와서
		//2. DB가서 이름 찾아오기.

		//1. 
		HttpSession session = req.getSession();


		int seq = Integer.parseInt(session.getAttribute("seqAllUser").toString());

		BoardUsedDAO dao = new BoardUsedDAO();
		BoardUsedDTO dto = dao.getWriterName(seq);

		req.setAttribute("dto", dto);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/board-used-write.jsp");
		dispatcher.forward(req, resp);

	}
}