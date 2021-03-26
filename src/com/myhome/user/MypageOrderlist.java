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
 * 마이페이지 > 매물거래내역 페이지를 출력하는 클래스입니다.
 * @author 이준오
 *
 */
@WebServlet("/user/mypageorderlist.do")
public class MypageOrderlist extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 회원번호받아오기
		//2. DB작업 -> select * from  where vwBoughtProperty seqUser = 회원번호
		
		//1.
		HttpSession session = req.getSession();
		int seqUser = Integer.parseInt(session.getAttribute("seqAllUser").toString()); 
		
		//2. 
		
		MypageOrderlistDAO dao = new MypageOrderlistDAO();
		
		//받아온 정보 담을곳..
		ArrayList<MypageOrderlistDTO> olist = dao.getBoughtList(seqUser);
		
		
		
		req.setAttribute("olist", olist);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/mypage-orderlist.jsp");
		dispatcher.forward(req, resp);

	}

}
