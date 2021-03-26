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

/**
 * 중고장터 게시글 세부정보를 요청/출력하는 클래스입니다.
 * @author 이준오
 *
 */
@WebServlet("/user/boardusedview.do")
public class BoardUsedView extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		//1. 보는사람 번호, 글번호 가져오기.
		//2. DB 정보 가져오기
		//3. req 값 전달

		//1.
		HttpSession session = req.getSession();
		int seqUsed = Integer.parseInt(req.getParameter("seq").toString());
		int seqUser = Integer.parseInt(session.getAttribute("seqAllUser").toString());
		//2.
		BoardUsedDAO dao = new BoardUsedDAO();

		//2.1 .. 해당 글 정보 가져오기 
		BoardUsedDTO dto = dao.getView(seqUsed);


		//2.2 .. 해당 글 댓글 목록 가져오기.
		ArrayList<UsedCommentDTO> clist = new ArrayList<UsedCommentDTO>();

		clist = dao.getComment(seqUsed);
		
		//2.3 .. 해당 글을 찜목록에 담았었는지 검사.
		
		LikesDTO ldto = new LikesDTO();
		
		ldto.setSeqUser(seqUser);
		ldto.setSeqUsed(seqUsed);
		//2.
		
		//겹치는 row가 있는지 검사..
		int result = dao.checkLike(ldto);
		
		

		//3. 값 넣기
		req.setAttribute("dto", dto);
		req.setAttribute("clist", clist);
		req.setAttribute("seqUsed", seqUsed);
		req.setAttribute("result", result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/board-used-view.jsp");
		dispatcher.forward(req, resp);

	}
}