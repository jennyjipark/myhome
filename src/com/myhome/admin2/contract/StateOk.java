package com.myhome.admin2.contract;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 전자 계약 관련 상태 변경 서블릿 
 * @author 이대홍
 */
@WebServlet("/admin2/contract/stateok.do")
public class StateOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seqC = req.getParameter("seqC");

		ContractDAO dao = new ContractDAO();
		
		int result = dao.state(seqC);

		dao.close();
		if (result > 0) {

			resp.sendRedirect("/Myhome_project/admin2/contract/list.do");
		} else {

			PrintWriter writer = resp.getWriter();
			writer.println("<HTML><body>");
			writer.println("<Script>");
			writer.println("alert('failed')");
			writer.println("history.back();");
			writer.println("</script>");
			writer.println("</body></HTML>");

			writer.close();
		}

	}

}
