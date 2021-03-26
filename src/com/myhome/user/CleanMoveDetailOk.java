package com.myhome.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myhome.company.CompanyDAO;

/**
 * 이사/청소 업체를 예약하는 클래스입니다.
 * @author 장진영
 *
 */
@WebServlet("/user/cleanmovedetailok.do")
public class CleanMoveDetailOk extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		String sel1 = req.getParameter("sel1");
		String seqCompany = req.getParameter("seq");
		String date = req.getParameter("date");

		//확인용
		//System.out.println(sel1  + " " + seqCompany + " " + date);
	

		//세션
		HttpSession session = req.getSession();
		
		//데이터수집
		CompanyDAO dao = new CompanyDAO();
		
		//로그인한 사람의번호
		String seqUser = session.getAttribute("seqAllUser").toString();
		//계약서 번호
		int seqContract = dao.getContract(seqUser);
		
		int result = 1;
		result = dao.reservation(sel1, seqContract, seqCompany, date);

//		try {
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//
//		결과 : JSP 작업 X -> Servlet 작업 O
		if (result == 1) {
			// 성공
			resp.sendRedirect("/Myhome_project/Myhome/main.do");
		} else {
			// 실패
			PrintWriter writer = resp.getWriter();

			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('failed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");

			writer.close();
		}
	}

}
