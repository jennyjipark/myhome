package com.myhome.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 매칭매물관리의 DB작업(매칭수락/매칭거절)을 요청하는 클래스
 * @author 이준오
 *
 */
@WebServlet("/user/matchingok.do")
public class MypageMatchingOk extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 매칭 수락/거절에 필요한 정보 받기.
		//2. DB작업
		//3. 결과 출력 및 돌아가기..
		
		int result = 0;
		MypageMatchingDAO dao = new MypageMatchingDAO();
		
		int seqMatching = Integer.parseInt(req.getParameter("seqMatching"));
		
		//거절인지, 수락인지 체크
		if (req.getParameter("seqLessorProperty")==null) {
			
			result =  dao.reject(seqMatching);
			
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
			
			return;
			
		} else {
			
			int seqLessorProperty = Integer.parseInt(req.getParameter("seqLessorProperty"));
			int seqContractor = Integer.parseInt(req.getParameter("seqContractor"));
			
			result = dao.accept(seqMatching, seqLessorProperty, seqContractor);
			
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
	
}
