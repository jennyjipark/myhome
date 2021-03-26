package com.myhome.admin2.contract;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 전자계약의 1개 글 상세 반환 서블릿 
 * @author 이대홍
 *
 */

@WebServlet("/admin2/contract/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String seqC = req.getParameter("seqC");
		

		ContractDAO dao = new ContractDAO();
		ContractDTO dto = dao.view(seqC);

		dto.setContractDate(dto.getContractDate().substring(0, 10));
		
		
		dao.close();
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin2contract/view.jsp");
		dispatcher.forward(req, resp);

	}

}
