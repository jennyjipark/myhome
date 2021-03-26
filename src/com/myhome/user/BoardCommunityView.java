package com.myhome.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Myhome/user/boardcommunityview.do")
public class BoardCommunityView extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		// System.out.println(session.getAttribute("id"));
		// System.out.println(session.getAttribute("name"));

		// 1.
//		String seqCommunity = request.getParameter("seqCommunity"); //오류나면 여기 수정하기*****
		String seq = request.getParameter("seq"); // 오류나면 여기 수정하기*****
		String search = request.getParameter("search"); // 검색어
		String page = request.getParameter("page");

		// 2.
		BoardCommunityDAO dao = new BoardCommunityDAO();

		if (session.getAttribute("read") == null || (boolean) session.getAttribute("read") == false) {

			dao.updateViewCount(seq);
			session.setAttribute("read", true);
		}

		BoardCommunityDTO dto = dao.get(seq);

		// 댓글 목록 가져오기
		// 현재 보고 있는 글에 달려있는 댓글 목록 가져오기(seq가 현재 보고 있는 글번호)
		ArrayList<CommentCommunityDTO> clist = dao.listComment(seq);
		//System.out.println("clist: " + clist.size());
		dao.close();

		dto.setContent(dto.getContent().replace("\r\n", "<br>"));

		// 3.
		request.setAttribute("dto", dto);
		request.setAttribute("search", search);
		request.setAttribute("page", page);

		request.setAttribute("clist", clist);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user/board-community-view.jsp");
		dispatcher.forward(request, response);

	}
}
