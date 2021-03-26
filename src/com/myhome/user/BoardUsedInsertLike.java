package com.myhome.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 중고장터 게시물의 찜목록 DB작업(등록/삭제)을 요청하는 클래스입니다.
 * @author 이준오
 *
 */
@WebServlet("/user/boardusedinsertlike.do")
public class BoardUsedInsertLike extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 받아온 게시글번호 확인, 회원번호
		//2. DB작업. 글 지우기 
		//3. 찜목록 추가기능 결과 1, 0 전송.. 1 : 성공 , 0 : 실패
		
		//1.
		int seqUsed = Integer.parseInt(req.getParameter("seq").toString());
		
		HttpSession session = req.getSession();
		int seqUser = Integer.parseInt(session.getAttribute("seqAllUser").toString());
		
		BoardUsedDAO dao = new BoardUsedDAO();
		LikesDTO dto = new LikesDTO();
		
		dto.setSeqUser(seqUser);
		dto.setSeqUsed(seqUsed);
		//2.
		
		//겹치는 row가 있는지 검사..
		int result = dao.checkLike(dto);
		
		System.out.println(result);
		// 위의 result가 0일때만 insertLike를 실행! 있다면 삭제를 실행!!
		if (result==0) {
			result = dao.insertLike(dto);
			System.out.println("1+"+ result);
			if (result==1) {
				
				PrintWriter writer = resp.getWriter();
				
				writer.print("<html><body>");
				writer.print("<script>");
				writer.print("alert('insert Success');");
				writer.print(String.format("location.href='/Myhome_project/user/boardusedview.do?seq="+seqUsed+"'"));
				writer.print("</script>");
				writer.print("</body></html>");
				System.out.println("2+"+result);
			} else {
				
				PrintWriter writer = resp.getWriter();
				
				writer.print("<html><body>");
				writer.print("<script>");
				writer.print("alert('insert Failed');");
				writer.print(String.format("location.href='/Myhome_project/user/boardusedview.do?seq='"+seqUsed));
				writer.print("</script>");
				writer.print("</body></html>");
				System.out.println("3+"+result);
			}
			
			
		} else {
			result = dao.deleteLike(dto);
			
			if (result==1) {
				
				PrintWriter writer = resp.getWriter();
				
				writer.print("<html><body>");
				writer.print("<script>");
				writer.print("alert('delete Success');");
				writer.print(String.format("location.href='/Myhome_project/user/boardusedview.do?seq="+seqUsed+"'"));
				writer.print("</script>");
				writer.print("</body></html>");
				System.out.println("4+"+result);
			} else {
				
				PrintWriter writer = resp.getWriter();
				
				writer.print("<html><body>");
				writer.print("<script>");
				writer.print("alert('delete Failed');");
				writer.print(String.format("location.href='/Myhome_project/user/boardusedview.do?seq='"+seqUsed));
				writer.print("</script>");
				writer.print("</body></html>");
				System.out.println("5+"+result);
			}
		}
		
		//3.
		
		
		
	}
}
