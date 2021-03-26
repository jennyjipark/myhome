package com.myhome.admin2.application;

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
 * 청약 삭제 관련 서블릿   
 * @author 이대홍
 */
@WebServlet("/admin2/application/delete.do")
public class Delete extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String[] seqApplication = req.getParameterValues("seq");// 배열로 번호를 받음.

		ApplicationDAO dao = new ApplicationDAO();

		ArrayList<ApplicationDTO> list = dao.list(seqApplication);

		for (ApplicationDTO dto : list) {

			dto.setWritedate(dto.getWritedate().substring(0, 10));

		}

		
		dao.close();
		req.setAttribute("list", list);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin2application/delete.jsp");
		dispatcher.forward(req, resp);

	}

}
