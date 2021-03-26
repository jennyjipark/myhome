package com.myhome.admin2.used;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 중고장터 게시글 삭제 페이지 서블릿 
 * @author 이대홍
 *
 */

@WebServlet("/admin2/used/delete.do")
public class Delete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		String[] seqUsed = req.getParameterValues("seq");// 배열로 번호를 받음.
		
		String category = req.getParameter("category");
		
		UsedDAO dao = new UsedDAO();

		ArrayList<UsedDTO> list = dao.list(seqUsed);

		for (UsedDTO dto : list) {
			
			dto.setWriteDate(dto.getWriteDate().substring(0, 10));

		}

		
		dao.close();
		
		req.setAttribute("list", list);
		req.setAttribute("category", category);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin2used/delete.jsp");
		dispatcher.forward(req, resp);

	}

}
