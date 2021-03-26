package com.myhome.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myhome.company.CompanyDAO;
import com.myhome.company.CompanyDTO;

/**
 * 마이페이지 > 이사청소예약 페이지를 출력하는 클래스입니다.
 * @author 이준오
 *
 */
@WebServlet("/user/mypagereservation.do")
public class MypageReservation extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/* 리스트 세팅 */
		
		//1. 이사인지 청소인지 받아오기.
		String sel1 = req.getParameter("sel1");
		//System.out.println(sel1);
		
		//2. 지역 받아오기
		String location = req.getParameter("location");
		//System.out.println(location);
		
		//3. 정보 가져오기
		ArrayList<CompanyDTO> dto = new ArrayList<CompanyDTO>();
		CompanyDAO dao = new CompanyDAO();
		
		
		/* 페이징 */
		int nowPage = 0;		//현재 페이지 번호
		int totalCount = 0;		//총 게시물 수
		int pageSize = 4;		//한페이지 당 출력 개수
		int totalPage = 0;		//총 페이지 수
		int begin = 0;			//rnum 시작 번호
		int end = 0;			//rnum 끝 번호
		int n = 0;				//페이지바 관련 변수
		int loop = 0;			//페이지바 관련 변수
		int blockSize = 10;		//페이지바 관련 변수
		
		String page = req.getParameter("page");
		
		//System.out.println(page);
		
		if (page == null || page == "") {
			//기본 -> page = 1
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}
		
		//시작~끝
		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1;
		
		if(!(sel1 == null) && !(location == null)) {
			
			dto = dao.getCompanyList(sel1, location, begin, end);
			
		}
		
		//총 게시물 수를 받는다
		totalCount = dao.getTotalCount(sel1, location);	
		//System.out.println(totalCount);
		
		totalPage = (int)Math.ceil((double)totalCount / pageSize); //총 페이지 수
		
		String pagebar = "";
		
		loop = 1;
		//n = 1;
		n = ((nowPage - 1) / blockSize) * blockSize + 1;
		
		
		//이전 10페이지
		if (n == 1) {
			pagebar += String.format("<li class='disabled'>"
					+ "            <a href=\"#!\" aria-label=\"Previous\">"
					+ "                <span aria-hidden=\"true\">&laquo;</span>"
					+ "            </a>"
					+ "        </li>");
		} else {				
			pagebar += String.format("<li>"
					+ "            <a href=\"/Myhome_project/user/mypagereservation.do?page=%d\" aria-label=\"Previous\">"
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
			
			pagebar += String.format("<a href=\"/Myhome_project/user/mypagereservation.do?sel1=%s&location=%s&page=%d\">%d</a></li>",sel1, location, n, n);
			
			loop++;
			n++;
		}
		
		
		//다음 10페이지로 이동
		if (n > totalPage) {
			pagebar += String.format("<li class='disabled'>"
					+ "            <a href=\"#!\" aria-label=\"Next\">"
					+ "                <span aria-hidden=\"true\">&raquo;</span>"
					+ "            </a>"
					+ "        </li>");
		} else {
			pagebar += String.format("<li>"
					+ "            <a href=\"/Myhome_project/user/mypagereservation.do?sel1=%s&location=%s&page=%d\" aria-label=\"Next\">"
					+ "                <span aria-hidden=\"true\">&raquo;</span>"
					+ "            </a>"
					+ "        </li>", sel1, location, n);
		}
		
		//4. 정보 내보내기
		req.setAttribute("sel1", sel1);
		req.setAttribute("location", location);
		req.setAttribute("dto", dto);
		req.setAttribute("pagebar", pagebar);
		req.setAttribute("nowPage", nowPage);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/mypage-reservation.jsp");
		dispatcher.forward(req, resp);

	}

}