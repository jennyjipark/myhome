package com.myhome.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 매칭매물관리 > 내가보낸매칭 > DB작업(중개사 바꾸기)을 요청하는 클래스입니다. 
 * @author User
 *
 */
@WebServlet("/user/selectcontractor.do")
public class SelectContractor extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 받은 번호 확인
		//2. DB 작업
		//3. 페이지 이동
		
		//1. seqContractor, seqMatching..
		int seqMatching = Integer.parseInt(req.getParameter("seqMatching"));
		int seqContractor = Integer.parseInt(req.getParameter("seqContractor"));
		
		
		//2.
		MypageMatchingDAO dao = new MypageMatchingDAO();
		
		int result = dao.updateMatching(seqMatching, seqContractor);
		
		//성공 1, 실패 0..
		if (result==1) {
			//성공

			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('update Success');");
			writer.print("location.href='/Myhome_project/user/mypagematching.do'");
			writer.print("</script>");
			writer.print("</body></html>");
			
		} else {
			//실패
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('update Failed');");
			writer.print("location.href='/Myhome_project/user/mypagematching.do'");
			writer.print("</script>");
			writer.print("</body></html>");
			
			
		}
	}
	
}
