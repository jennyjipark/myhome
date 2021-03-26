package com.myhome.admin2.used;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 중고장터 게시글 1개 상세 보기 페이지 서블릿 
 * @author 이대홍
 *
 */

@WebServlet("/admin2/used/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		String seqUsed = req.getParameter("seq");
		String category = req.getParameter("category");
		
		UsedDAO dao = new UsedDAO();
		UsedDTO dto = dao.view(seqUsed,category);
		
		
		
		if( Integer.valueOf(dto.getCount()) > 0) {

			ArrayList<UsedCommentDTO> list = dao.getComment(seqUsed);	
			req.setAttribute("list", list);
		};
		
		
		
		
		dto.setWriteDate(dto.getWriteDate().substring(0, 10));

		
		dao.close();
		req.setAttribute("category", category);
		req.setAttribute("dto", dto);

		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin2used/view.jsp");
		dispatcher.forward(req, resp);

	}

}
