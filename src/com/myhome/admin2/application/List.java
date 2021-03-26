package com.myhome.admin2.application;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 청약 게시글 목록반환 서블릿 
 * @author 이대홍
 *
 */
@WebServlet("/admin2/application/list.do")
public class List extends HttpServlet {

	// adminmenu/adminmenu.jsp 에서 번호를 받아온다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		HttpSession session = req.getSession();
		session.setAttribute("read", false);
		
		
		// 잘못된 접속자 강퇴
		if ( session.getAttribute("admin")==null  ) {
			PrintWriter writer = resp.getWriter();
			writer.println("<HTML><body>");
			writer.println("<Script>");
			writer.println("alert('failed')");
			writer.println("history.back();");
			writer.println("</script>");
			writer.println("</body></HTML>");
			
			writer.close();
		}else if( !session.getAttribute("admin").equals("admin") ) {
			PrintWriter writer = resp.getWriter();
			writer.println("<HTML><body>");
			writer.println("<Script>");
			writer.println("alert('failed')");
			writer.println("history.back();");
			writer.println("</script>");
			writer.println("</body></HTML>");
			
			writer.close();	
		}

		System.out.println("admin : ");
		// 검색
		HashMap<String, String> map = new HashMap<String, String>();

		String search = req.getParameter("search");

		if (!(search == null || search.trim().equals(""))) {
			map.put("search", search);
		}

		ApplicationDAO dao = new ApplicationDAO();

		// 페이징
		int nowPage = 0; // 현재 페이지 번호
		int totalCount = 0; // 총 게시물 수
		int pageSize = 10; // 한페이지 당 출력 개수
		int totalPage = 0; // 총 페이지 수
		int begin = 0; // rnum 시작 번호
		int end = 0; // rnum 끝 번호
		int n = 0; // 페이지바 관련 변수
		int loop = 0; // 페이지바 관련 변수
		int blockSize = 10; // 페이지바 관련 변수

		String page = req.getParameter("page");

		if (page == null || page == "") {
			// 기본 -> page = 1
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}


		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1;
		
		map.put("begin", begin + "");
		map.put("end", end + "");
		

		totalCount = dao.totalCount(map); //총 게시물 수
				
		totalPage = (int)Math.ceil((double)totalCount / pageSize); //총 페이지 수
		
		
		String pagebar = "";
		
		loop = 1;
		n = ((nowPage - 1) / blockSize) * blockSize + 1;
		

		
		// 이전10페이지
		if (n == 1) {
			pagebar += String.format("<li class='page-item disabled'>"
					+ "<a class='page-link page-a' href=\"/Myhome_project/admin2/application/list.do\">"
					+ "이전</a></li>");
		} else {				
			pagebar += String.format("<li class=\"page-item\">"
					+ "<a class=\"page-link page-a\" "
					+ "href=\"/Myhome_project/admin2/application/list.do?page=%d\">"
					+ "이전</a></li>"
					, n - 1);
		}
		
//<li class="page-item"><a class="page-link page-a" href="">1</a></li>
		
		while (!(loop > blockSize || n > totalPage)) {
			
			if (nowPage == n) {
				pagebar += "<li class='page-item'>";
			} else {
				pagebar += "<li>";
			}
			
			pagebar += String.format("<a class='page-link page-a' "
			+ " href=\"/Myhome_project/admin2/application/list.do?page=%d\">%d</a></li>", n, n);
			
			loop++;
			n++;
		}
		
		
//다음 10페이지로 이동
//<li><a class="page-link page-a" href="">다음</a></li>
				
		if (n > totalPage) {
			pagebar += String.format(
			"<li><a class='page-link page-a disabled' href=\"\">"
			+ "다음</a></li> ");
		} else {
			pagebar += String.format(
			"<li><a class='page-link page-a ' "
			+ " href=\"/Myhome_project/admin2/application/list.do?page=%d\">"
			+ "다음</a></li>", n);
		}
		
		

		ArrayList<ApplicationDTO> list = dao.list(map);
		// 날짜 추출
		for (ApplicationDTO dto : list) {

			dto.setWritedate(dto.getWritedate().substring(0, 10));

		}
		
		dao.close();
		
		req.setAttribute("list", list);
		req.setAttribute("search", search);
		req.setAttribute("pagebar", pagebar);
		req.setAttribute("nowPage", nowPage);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin2application/list.jsp");
		dispatcher.forward(req, resp);

	}

}
