package com.myhome.contractor.mypage;

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

/**
 * 
 * 전자계약 리스트를 확인하는 서블릿
 * @author 박지현
 *
 */
@WebServlet("/contractor/mypage-contract.do")
public class MypageContract extends HttpServlet{

	//http://localhost:8090/Myhome_project/contractor/mypage-contract.do
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//1. 전자계약 정보
		ContractDAO dao = new ContractDAO();
				
		//2. session 받기
		HttpSession session = req.getSession();
		int seqContractor = Integer.parseInt(session.getAttribute("seqAllUser").toString());

		
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
				
		ArrayList<ContractDTO> list = dao.list(map, seqContractor);
		
		//4. 전자계약 정보 보내기
		req.setAttribute("list", list);

		
		totalCount = dao.getTotalContract(map, seqContractor);
				
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
							+ "            <a href=\"/Myhome_project/contractor/mypage-contract.do?page=%d\" aria-label=\"Previous\">"
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
					
				pagebar += String.format("<a href=\"/Myhome_project/contractor/mypage-contract.do?page=%d\">%d</a></li>", n, n);
				
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
							+ "            <a href=\"/Myhome_project/contractor/mypage-contract.do?page=%d\" aria-label=\"Next\">"
							+ "                <span aria-hidden=\"true\">&raquo;</span>"
							+ "            </a>"
							+ "        </li>", n);
	
				}
				
				
				//2.
				req.setAttribute("list", list);
				req.setAttribute("search", search);
				req.setAttribute("pagebar", pagebar);
				req.setAttribute("nowPage", nowPage);
				
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/contractor/mypage-contract.jsp");
		dispatcher.forward(req, resp);
		
	}
}
