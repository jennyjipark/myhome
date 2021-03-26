package com.myhome.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 마이페이지 > 매칭매물관리 페이지를 출력하는 서블릿(클래스)입니다.
 * @author 이준오
 *
 */
@WebServlet("/user/mypagematching.do")
public class MypageMatching extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 회원번호받기
		//2. DB작업 -> 회원번호를 토대로 view에서 매칭정보 반환
		//3. 결과 반환
		
		
		//1.
		HttpSession session = req.getSession();
		int seqUser = Integer.parseInt(session.getAttribute("seqAllUser").toString());
		
		//2. 
		
		//DAO 생성
		MypageMatchingDAO dao = new MypageMatchingDAO();
		
		//2.1 받은 매칭 리스트
		ArrayList<MypageMatchingDTO> glist = dao.getReceiveMatchingList(seqUser);
		
		
		//2.2 보낸 매칭 리스트
		ArrayList<MypageMatchingDTO> slist = dao.getSendMatchingList(seqUser);
		
		
		//2.3 매물의 주소 정보만 받을 리스트 생성
		ArrayList<String> llist = new ArrayList<String>();

		if (slist.size()>0) {
			for (int i=0; i<slist.size(); i++) {
				//매물의 주소정보만 받아옴.
				llist.add(slist.get(i).getLocation());
			}
		}
		//주소들고가는 갯수
		int size = 0;
		size = llist.size();
		
				
		req.setAttribute("glist", glist);
		req.setAttribute("slist", slist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/mypage-matching.jsp");
		dispatcher.forward(req, resp);

	}

}
