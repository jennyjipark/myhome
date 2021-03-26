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
 * 마이페이지 > 이사청소예약 > 내 예약목록 페이지를 출력하는 클래스입니다.
 * @author 이준오
 *
 */
@WebServlet("/user/reservationlist.do")
public class ReservationList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 세션에서 회원번호 받기
		//2. DB작업 -> select 이사, 청소 예약 목록 
		//3. 결과 jsp에 전달
		
		//1.
		HttpSession session = req.getSession();
		//회원번호
		int seqUser = Integer.parseInt(session.getAttribute("seqAllUser").toString());
		
		
		//2.
		ReservationListDAO dao = new ReservationListDAO();
		//청소 업체예약목록 중 where = 회원번호로 값 받아옴
		ArrayList<ReservationListDTO> clist = dao.getReservationCleanList(seqUser);
		//청소 업체예약목록 중 where = 회원번호로 값 받아옴
		ArrayList<ReservationListDTO> mlist = dao.getReservationMoveList(seqUser);
		
		
		
		
		
		//3.
		req.setAttribute("clist", clist);		
		req.setAttribute("mlist", mlist);		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/reservation-list.jsp");
		dispatcher.forward(req, resp);

	}

}
