package com.myhome.user;

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
 * 중고장터 게시글 목록페이지를 출력하는 클래스입니다.
 * @author 이준오
 *
 */
@WebServlet("/user/boardusedlist.do")
public class BoardUsedList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {





		//1. 접속한 회원 번호받기 -> 회원이 아니면 메인으로 
		//2. DB작업 -> 전체 중고장터 게시판 list 가져오기
		//3. jsp에 전달

		//1.
		req.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession();

		if (session.getAttribute("seqAllUser")==null) {
			PrintWriter writer = resp.getWriter();

			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('Please Do Login');");
			writer.print("location.href='/Myhome_project/Myhome/main.do';");
			writer.print("</script>");
			writer.print("</body></html>");

			writer.close();

			return;
		}


		//페이징
		int nowPage = 0;		//현재 페이지 번호
		int totalCount = 0;		//총 게시물 수
		int pageSize = 15;		//한페이지 당 출력 개수
		int totalPage = 0;		//총 페이지 수
		int begin = 0;			//rnum 시작 번호
		int end = 0;			//rnum 끝 번호
		int n = 0;				//페이지바 관련 변수
		int loop = 0;			//페이지바 관련 변수
		int blockSize = 10;		//페이지바 관련 변수

		//검색어 등 받아서 hashmap에 저장.
		HashMap<String,String> map = new HashMap<String,String>();


		String page = req.getParameter("page");

		if (page == null || page == "") {
			//기본 -> page = 1
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}

		//nowPage -> 현재 보려는 페이지 번호
		//1page -> where rnum between 1 and 10
		//2page -> where rnum between 11 and 20
		//3page -> where rnum between 21 and 30

		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1;


		map.put("begin", begin + "");
		map.put("end", end + "");





		String search = req.getParameter("search");

		//search가 있는지 없는지..
		if (!(search == null || search.equals(""))) {
			map.put("search", search);
		}


		int seq = Integer.parseInt(session.getAttribute("seqAllUser").toString());

		//2.
		//작업 시킬 DAO 생성
		BoardUsedDAO dao = new BoardUsedDAO();

		//2.1 받은 모든글을 저장할 ArrayList 생성
		ArrayList<BoardUsedDTO> list = new ArrayList<BoardUsedDTO>();

		list = dao.getList(map);

		//2.2  모든 글의 갯수  / 총 페이지수 계산
		totalCount = dao.getTotalCount(map);
		totalPage = (int)Math.ceil((double)totalCount / pageSize);



		loop = 1;

		n = ((nowPage - 1) / blockSize) * blockSize + 1;

		String pagebar = "";


		//이전 10페이지

		if (n == 1) {
			pagebar += String.format("<li class=\"disabled page-item\"><a class=\"page-link page-a\" href=\"#!\" aria-label=\"Previous\">이전</a><li>");
		} else {				
			pagebar += String.format("<li class='page-item'>"
					+ "            <a href=\"/Myhome_project/user/boardusedlist.do?page=%d\" aria-label=\"Previous\">이전</a></li>", n - 1);
		}



		//페이지버튼 10개
		while (!(loop > blockSize || n > totalPage)) {

			if (nowPage == n) {
				pagebar += "<li class='active page-item'>";
			} else {
				pagebar += "<li class='page-item'>";
			}

			if (search!=null) {
				pagebar += String.format("<a class='page-link page-a' href=\"/Myhome_project/user/boardusedlist.do?page=%d&search="+search+"\">%d</a></li>", n, n);

			} else {
				pagebar += String.format("<a class='page-link page-a' href=\"/Myhome_project/user/boardusedlist.do?page=%d\">%d</a></li>", n, n);
			}

			loop++;
			n++;
		}


		//다음 10페이지
		if (n > totalPage) {
			pagebar += String.format("<li class='page-item disabled'><a class='page-link page-a' href=\"#!\" aria-label=\"Next\">다음</a></li>");
		} else {
			pagebar += String.format("<li class='page-item'><a class='page-link page-a' href=\"/Myhome_project/user/boardusedlist.do?page=%d\" aria-label=\"Next\">다음</a></li>", n);
			//pagebar += String.format("<a href=\"/codestudy/board/list.do?page=%d\">다음 10페이지</a>", n);
		}

		req.setAttribute("list", list);
		req.setAttribute("search", search);
		req.setAttribute("pagebar", pagebar);
		req.setAttribute("nowPage", nowPage);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/board-used-list.jsp");
		dispatcher.forward(req, resp);

	}
}



