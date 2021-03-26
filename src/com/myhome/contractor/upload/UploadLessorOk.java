package com.myhome.contractor.upload;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @author 박지현
 * 임대인 매물 올리기를 완료
 */
@WebServlet("/contractor/upload-lessorok.do")
public class UploadLessorOk extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//session 받기
		HttpSession session = req.getSession();
		
		int seq = Integer.parseInt(session.getAttribute("seqAllUser").toString());
		
		int seqLessorProperty = Integer.parseInt(req.getParameter("seq"));
		
		System.out.println("임대인 시퀀스: " + seqLessorProperty);
		System.out.println("중개인 시퀀스: " + seq);
		
		//임대인 매물번호 중개인 매물 테이블에 입력
		
		UploadLessorDAO dao2 = new UploadLessorDAO();
		
		int result = dao2.uploadLessor(seqLessorProperty, seq);
		
		System.out.println("결과" + result);
		
		
		
		if (result == 1) {
			
			//매물 업로드 성공
			resp.sendRedirect("/Myhome_project/contractor/upload-lessor-list.do?seq=" + seqLessorProperty);
					
		} else {
			//실패 경고 + 뒤로 가기
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

