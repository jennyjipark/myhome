package com.myhome.admin2.report;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 신고 게시글관련 메세지 전송 DB업무 처리용 서블릿
 * @author 이대홍
 *
 */
@WebServlet("/admin2/report/chatok.do")
public class ChatOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
 throws ServletException, IOException {

		
/*
	
채팅은 단순 채팅 전송. 	ProcReportChat 채팅 선종
ProcReportCompleteChat 카운트버튼 클릭  => 카운트 + 완료채팅 전송 + 처리 상태 변경 
		
*/		
		HttpSession session = req.getSession();
		
		String seqAdmin = (String)session.getAttribute("seqAdmin");
		
		String pUser = req.getParameter("puser"); // 신고 받는사람  번호 
		String rUser = req.getParameter("ruser"); // 신고 받는사람  번호 
		
		
		
		ReportDAO dao = new ReportDAO();
		
		int result = dao.chatOk(seqAdmin,pUser,rUser);
		
	
		dao.close();
		if (result == 1) {
			PrintWriter writer = resp.getWriter();
			writer.println("<HTML><body>");
			writer.println("<Script>");
			writer.println("alert(' send chat OK')");
			writer.println("history.back();");
			writer.println("</script>");
			writer.println("</body></HTML>");
			
			writer.close();
			
		
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