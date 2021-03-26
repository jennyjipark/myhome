package com.myhome.admin.moveclean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/***
 * 청소업체 등록 처리 서블릿입니다.
 * @author 윤지현
 *
 */
@WebServlet("/admin/moveclean/addcleanok.do")
public class AddCleanOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 가져오기 (subject, content)
		//2. DB작업 > insert
		//3. 결과 처리
		
		HttpSession session = req.getSession();
		
		
		
		//1.
		req.setCharacterEncoding("UTF-8");
		
		String seq = req.getParameter("seq");
		String location = req.getParameter("location");
		String image = req.getParameter("image");
		String name = req.getParameter("image");
		String tel = req.getParameter("tel");
		String address = req.getParameter("address");
		String businessnum = req.getParameter("businessnum");
		String price = req.getParameter("price");
		String introduce = req.getParameter("introduce");
		String rating = req.getParameter("rating");
		
		//로그인한 관리자번호
		String seqadmin = (String)session.getAttribute("seqAdmin");
		
	
		
		//2.
		CleanDAO dao = new CleanDAO();
		CleanDTO dto = new CleanDTO();
		
		dto.setSeq(seq);
		dto.setLocation(location);
		dto.setImage(image);
		dto.setName(name);
		dto.setTel(tel);
		dto.setAddress(address);
		dto.setBusinessnum(businessnum);
		dto.setPrice(price);
		dto.setIntroduce(introduce);
		dto.setRating(rating);
		
		
		int result = dao.addclean(dto);
		
		if (result == 1) {
			//글쓰기 성공 -> 게시판 목록으로 이동
			resp.sendRedirect("/Myhome_project/admin/moveclean/listclean.do");
			
		} else {
			//글쓰기 실패 -> 경고 + 뒤로가기
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('filed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
		}

	}

}
