package com.myhome.contractor.mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/contractor/mypage-contract-view.do")
public class MypageContractView extends HttpServlet{

	
	//http://localhost:8090/Myhome_project/contractor/mypage-contract-view.do
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 전자계약 정보
			ContractDAO dao = new ContractDAO();
					
							
		//2. 전자계약 seq 쿼리에 보내기
			int seqContract = Integer.parseInt(req.getParameter("seq").toString());
			ArrayList<ContractDTO> list = dao.view(seqContract);
						
		
		//3. 전자계약 정보 보내기
			req.setAttribute("list", list);
				
				
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/contractor/mypage-contract-view.jsp");
		dispatcher.forward(req, resp);
		
	}
}
