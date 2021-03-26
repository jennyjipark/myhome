package com.myhome.user;

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


@WebServlet("/Myhome/user/boardqnalist.do")
public class BoardQnAList extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// - 목록 : boardcommunitylist.do
		// - 검색 : boardcommunitylist.do?search=검색어
		
		HashMap<String,String> map = new HashMap<String, String>();
		
		String search = request.getParameter("search");
		
		if (!(search == null || search.equals(""))) {
			map.put("search", search);
		}
		
		
		//1. DB작업 > select
		//2. 목록 반환받음 + JSP에게 전달하면서 호출하기
		
		HttpSession session = request.getSession();
		
		//boardcommunityview.do -> 새로고침 조회수 증가 방지 -> 플래그 생성
		session.setAttribute("read", false);
		
		//페이징
		int nowPage = 0;		//현재 페이지 번호
		int totalCount = 0;		//총 게시물 수
		int pageSize = 10;		//한페이지당 출력 개수
		int totalPage = 0;		//총 페이지 수
		int begin = 0;			//rnum 시작 번호
		int end = 0;			//rnum 끝 번호
		int n = 0;				//페이지바 관련 변수
		int loop = 0;			//페이지바 관련 변수
		int blockSize = 10;		//페이지바 관련 변수
		
		
		//boardcommunitylist.do
		//boardcommunitylist.do -> boardcommunitylist.do?page=1
		
		String page = request.getParameter("page");
		
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
		end = begin + pageSize -1;
		
		//우리가만든 해쉬맵은 스트링이기 때문에 begin과 end도 문자열로 만들어서 넘기기.
		map.put("begin", begin + "");
		map.put("end", end + "");
		
		
		
		
		//1.
		BoardCommunityDAO dao = new BoardCommunityDAO();
		ArrayList<BoardCommunityDTO> list = dao.list(map);
		
		//1.5
		for (BoardCommunityDTO dto : list) {
			//날짜에서 년월일만 잘라내기
			dto.setWriteDate(dto.getWriteDate().substring(0,10));
			
			//제목이 너무 긴 경우 자르기 30자로?
			if (dto.getTitle().length() > 30) {
				dto.setTitle(dto.getTitle().substring(0,30) + "...");
			}
		}
		
		totalCount = dao.getTotalCount(map);
//		System.out.println(totalCount);
		
		totalPage = (int)Math.ceil((double)totalCount / pageSize);
//		System.out.println(totalPage);
		
		String pagebar = "";
		
		loop = 1;
		n = ((nowPage -1) / blockSize) * blockSize +1;
		
		
		
		
		if ( n == 1 ) {
			pagebar += String.format("<li class='disabled'>"
					+ "            <a href=\"#!\" aria-label=\"Previous\">"
					+ "                <span aria-hidden=\"true\">&laquo;</span>"
					+ "            </a>"
					+ "        </li>");			
		} else {
			pagebar += String.format("<li>"
					+ "            <a href=\"/Myhome_project/Myhome/user/boardqnalist.do?page=%d\" aria-label=\"Previous\">"
					+ "                <span aria-hidden=\"true\">&laquo;</span>"
					+ "            </a>"
					+ "        </li>", n - 1);
			
		}
		
		
		
		
		
		
		
		while (!(loop > blockSize || n > totalPage)) {
					
					if (nowPage == n) {
						pagebar += "<li class='active'>";				
					} else {
						pagebar += "<li>";								
					}
					
					pagebar += String.format("<a href=\"/Myhome_project/Myhome/user/boardqnalist.do?page=%d\">%d</a></li>", n, n);
				
					loop++;
					n++;
				}
		
		//다음 10페이지로 이동
				if (n > totalPage) { //마지막에 끝난 n이 토탈페이지보다 크냐? 나의 경우엔 지금 n이 29냐? > 링크 안걸린 애를 만들기.
					//링크에 샵만 있으면 맨위로 올라가므로 #뒤에 ! 붙여주기.
					pagebar += String.format("<li class='disabled'>"
							+ "            <a href=\"#!\" aria-label=\"Next\">"
							+ "                <span aria-hidden=\"true\">&raquo;</span>"
							+ "            </a>"
							+ "        </li>");
					
				} else { //여전히 다음페이지가 존재하는 경우엔 링크 있는 애로 생성.			
					pagebar += String.format("<li>"
							+ "            <a href=\"/Myhome_project/Myhome/user/boardqnalist.do?page=%d\" aria-label=\"Next\">"
							+ "                <span aria-hidden=\"true\">&raquo;</span>"
							+ "            </a>"
							+ "        </li>", n);
					//여기서 n은 위의 루프에서 10이 넘어가서 쫓겨난 애라 바로 다음애를 의미한다. 그래서 다음페이지의 첫번째 페이지의 이동하는 것!
				}
				
				
				//2.
				request.setAttribute("list", list);
				request.setAttribute("search", search);
				request.setAttribute("pagebar", pagebar);
				request.setAttribute("nowPage", nowPage);
		
			
		
		
		
		
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user/board-qna-list.jsp");
		dispatcher.forward(request, response);
		
	}
	
}
