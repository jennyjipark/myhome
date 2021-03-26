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
 * 마이페이지 > 찜목록관리 페이지를 출력하는 클래스입니다.
 * @author 이준오
 *
 */
@WebServlet("/user/mypagelike.do")
public class MypageLike extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 회원번호 받기
		//2. DB작업 -> where 회원번호인 찜목록 출력. 프로시저(커서) 사용. X 포기하고 걍 view
		//3. 값 전송
		
		req.setCharacterEncoding("UTF-8");
		//1.
		HttpSession session = req.getSession();
		int seq = Integer.parseInt(session.getAttribute("seqAllUser").toString());
		
		//2.
		//회원 찜목록  (매물) 리스트 받기.
		UserDAO dao = new UserDAO();
		ArrayList<vwPropertyLikeDTO> plist = new ArrayList<vwPropertyLikeDTO>();
		
		plist = dao.getPropertyLike(seq);
		
		//회원 찜목록  (중고장터) 리스트 받기.
		ArrayList<vwUsedLikeDTO> ulist = new ArrayList<vwUsedLikeDTO>();
		
		ulist = dao.getUsedLike(seq);
		
		
		//3. req에 값 전달.. -> 페이지도 전송
		req.setAttribute("plist", plist);
		req.setAttribute("ulist", ulist);
		
		System.out.println("plist:"+plist);
		System.out.println("ulist:"+ulist);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/mypage-like.jsp");
		dispatcher.forward(req, resp);

	}

}
