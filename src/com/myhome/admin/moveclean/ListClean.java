package com.myhome.admin.moveclean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myhome.admin.board.PolicyDAO;
import com.myhome.admin.board.PolicyDTO;

/***
 * 청소업체 목록 페이지 서블릿입니다.
 * @author 윤지현
 *
 */
@WebServlet("/admin/moveclean/listclean.do")
public class ListClean extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HashMap<String,String> map = new HashMap<String, String>();
		
		String search = req.getParameter("search");
		
		if(!(search == null || search.equals(""))) {
			map.put("search", search);
		}
		
		//1. DB 작업 > select
		//2. 목록 반환 + JSP 전달 & 호출하기
		
		HttpSession session = req.getSession();
		
		/* 페이징 */
		int nowPage = 0;		//현재 페이지 번호
		int totalCount = 0;		//총 게시물 수
		int pageSize = 5;		//한페이지 당 출력 개수
		int totalPage = 0;		//총 페이지 수
		int begin = 0;			//rnum 시작 번호
		int end = 0;			//rnum 끝 번호
		int n = 0;				//페이지바 관련 변수
		int loop = 0;			//페이지바 관련 변수
		int blockSize = 10;		//페이지바 관련 변수
	
		
		String page = req.getParameter("page");
		
		if (page == null || page == "") {
			//기본 -> page = 1
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}
		
		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1;
		
		map.put("begin", begin + "");
		map.put("end", end + "");
		
		//1.
		CleanDAO dao = new CleanDAO();
		
		ArrayList<CleanDTO> list = dao.list(map);
	
		
		/* 페이지바 */
		totalCount = dao.getTotalCount(map); //총 게시물 수
		
		totalPage = (int)Math.ceil((double)totalCount / pageSize); //총 페이지 수
		
		
		String pagebar = "";
		
		loop = 1;
		n = ((nowPage - 1) / blockSize) * blockSize + 1;
		
		
		//이전 10페이지
		if (n == 1) {
			pagebar += String.format("<li class='disabled'>"
					+ "<a href=\"#!\" aria-label=\"Previous\">"
					+ "이전"
					+ "</a>"
					+ "</li>");
		} else {				
			pagebar += String.format("<li>"
					+ "<a href=\"/Myhome_project/admin/moveclean/listclean.do?page=%d\" aria-label=\"Previous\">"
					+ "이전"
					+ "</a>"
					+ "</li>", n - 1);
		}
		
		
		
		while (!(loop > blockSize || n > totalPage)) {
			
			if (nowPage == n) {
				pagebar += "<li class='active'>";
			} else {
				pagebar += "<li>";
			}
			
			pagebar += String.format("<a href=\"/Myhome_project/admin/moveclean/listclean.do?page=%d\">%d</a></li>", n, n);
			
			loop++;
			n++;
		}
		
		
		//다음 10페이지로 이동
		if (n > totalPage) {
			pagebar += String.format("<li class='disabled'>"
					+ "<a href=\"#!\" aria-label=\"Next\">"
					+ "다음"
					+ "</a>"
					+ "</li>");
		} else {
			pagebar += String.format("<li>"
					+ "<a href=\"/Myhome_project/admin/moveclean/listclean.do?page=%d\" aria-label=\"Next\">"
					+ "다음"
					+ "</a>"
					+ "</li>", n);
		}
		
		//2.
		req.setAttribute("list", list);
		req.setAttribute("search", search);
		req.setAttribute("pagebar", pagebar);
		req.setAttribute("nowPage", nowPage);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/adminmoveclean/listclean.jsp");
		dispatcher.forward(req, resp);

	}

}