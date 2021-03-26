package com.myhome.contractor.search;

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

import com.myhome.contractor.mypage.PropertyDAO;
import com.myhome.contractor.mypage.PropertyDTO;

/** 
 * @author 박지현
 * 임대인 매물 리스트
 */
@WebServlet("/contractor/search-lessor.do")
public class SearchLessor extends HttpServlet{

	//http://localhost:8090/Myhome_project/contractor/mypage-myproperty.do
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 매물 정보
		PropertyDAO dao = new PropertyDAO();
						
		HashMap<String,String> map = new HashMap<String, String>();
				
		String search = req.getParameter("search");
				
		if (!(search == null || search.equals(""))) {
					map.put("search", search);
		}
				
				
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
				
				
		String page = req.getParameter("page");
				
		if (page == null || page == "") {
			//기본 -> page = 1
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}
			

		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize -1;
				
		//우리가만든 해쉬맵은 스트링이기 때문에 begin과 end도 문자열로 만들어서 넘기기.
		map.put("begin", begin + "");
		map.put("end", end + "");
				
		ArrayList<PropertyDTO> list = dao.lessorList(map);
				
		
		for (PropertyDTO dto : list) {
					
			//제목 자르기
			if (dto.getTitle().length() > 30) {
				dto.setTitle(dto.getTitle().substring(0,30) + "...");
			}
		}
				
			totalCount = dao.getTotalCountLessor(map);
				
			totalPage = (int)Math.ceil((double)totalCount / pageSize);
				
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
							+ "            <a href=\"/Myhome_project/contractor/search-lessor.do?page=%d\" aria-label=\"Previous\">"
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
					
				pagebar += String.format("<a href=\"/Myhome_project/contractor/search-lessor.do?page=%d\">%d</a></li>", n, n);
				
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
							+ "            <a href=\"/Myhome_project/contractor/search-lessor.do?page=%d\" aria-label=\"Next\">"
							+ "                <span aria-hidden=\"true\">&raquo;</span>"
							+ "            </a>"
							+ "        </li>", n);
					//여기서 n은 위의 루프에서 10이 넘어가서 쫓겨난 애라 바로 다음애를 의미한다. 그래서 다음페이지의 첫번째 페이지의 이동하는 것!
				}
				
				
				//2.
				req.setAttribute("list", list);
				req.setAttribute("search", search);
				req.setAttribute("pagebar", pagebar);
				req.setAttribute("nowPage", nowPage);
				

				
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/contractor/search-lessor.jsp");
				dispatcher.forward(req, resp);
			

		}

		
		
		
		
		
		
	}

