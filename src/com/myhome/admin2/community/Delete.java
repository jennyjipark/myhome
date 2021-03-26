package com.myhome.admin2.community;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 정보공유 게시글 삭제 서블릿 
 * @author 이대홍
 */

@WebServlet("/admin2/community/delete.do")
public class Delete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String[] seqCommunity = req.getParameterValues("seq");// 배열로 번호를 받음.

		CommunityDAO dao = new CommunityDAO();

		ArrayList<CommunityDTO> list = dao.list(seqCommunity);
		
		dao.close();
		
		for (CommunityDTO dto : list) {

			dto.setWriteDate(dto.getWriteDate().substring(0, 10));

		}

		req.setAttribute("list", list);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin2community/delete.jsp");
		dispatcher.forward(req, resp);

	}

}
