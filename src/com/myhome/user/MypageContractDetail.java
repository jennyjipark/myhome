package com.myhome.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 마이페이지 > 전자계약관리 > 전자계약서 세부내용을 출력하는 클래스입니다.
 * @author 이준오
 *
 */
@WebServlet("/user/mypagecontractdetail.do")
public class MypageContractDetail extends HttpServlet{

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 회원번호 받기, seqContract(전자계약번호 받기)
		//2. DB작업 -> select(계약서에 필요한 정보 받아오기)
		//3. 결과반환
		
		//1.
		HttpSession session = request.getSession();
		
		int seqUser = Integer.parseInt(session.getAttribute("seqAllUser").toString());
		int seqContract = Integer.parseInt(request.getParameter("seqContract"));
		
		
		//2.
		MypageContractDAO dao = new MypageContractDAO();		
		
		MypageContractDTO dto = dao.getContractDetail(seqUser, seqContract);  
		
		
		//3.
		request.setAttribute("dto", dto);
		
		//http://localhost:8090/Myhome_project/user/mypage-contract-detail.do
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user/mypage-contract-detail.jsp");
		dispatcher.forward(request, response);
		
	}
}
