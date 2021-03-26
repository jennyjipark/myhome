package com.myhome.admin2.report;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 신고 게시글 회업 재제 카운트 증가 
 * @author 이대홍
 *
 */
@WebServlet("/admin2/report/CountOk.do")
public class CountOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
 throws ServletException, IOException {
		/*
		
		ProcReportCompleteChat 카운트버튼 클릭  => 카운트 + 완료채팅 전송 + 처리 상태 변경 
				
		*/		
		
		HttpSession session = req.getSession();
		
		
		String seqAdmin = (String)session.getAttribute("seqAdmin");
		
		String rUser = req.getParameter("ruser"); // 신고자 번호 
		String pUser = req.getParameter("puser"); // 신고받는사람번호  번호 
		String category =req.getParameter("category"); // 신고에 대한 카테고리 번호 
		String seqReport = req.getParameter("seqreport"); // 글의 번호 넣기 	
		
		
		ReportDAO dao = new ReportDAO();
		
		int result = dao.reportCount(pUser,category,seqReport);
		int allOk = 0;

		dao.close();
		if (result == 1) {
			allOk = 1;  //dao.chat(seqAdmin,rUser ,pUser);
			
		}else {
			PrintWriter writer = resp.getWriter();
			writer.println("<HTML><body>");
			writer.println("<Script>");
			writer.println("alert('failed')");
			writer.println("history.back();");
			writer.println("</script>");
			writer.println("</body></HTML>");
			
			writer.close();
		}
		
		
		if(allOk==1) {
			PrintWriter writer = resp.getWriter();
			writer.println("<HTML><body>");
			writer.println("<Script>");
			writer.println("alert('Complete')");
			writer.println("history.back();");
			writer.println("</script>");
			writer.println("</body></HTML>");
			
			writer.close();
		}else {
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