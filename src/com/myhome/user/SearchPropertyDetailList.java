package com.myhome.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Myhome/user/searchpropertydetaillist.do")
public class SearchPropertyDetailList extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//1. 매물 정보
		SearchPropertyDAO dao = new SearchPropertyDAO();						
		

	//2. 중개인 매물번호 쿼리에 보내기
		int seqProperty = Integer.parseInt(req.getParameter("seq").toString());
		
		ArrayList<SearchPropertyDTO> propertyDetail = dao.propertyDetailUserVer(seqProperty);
		
	//3. 임대인 매물번호 쿼리에 보내기
		int seqLessorProperty = Integer.parseInt(req.getParameter("seq").toString());
		ArrayList<SearchPropertyDTO> LessorPropertyDetail = dao.propertyDetailUserVer(seqLessorProperty);
		
		
	//4. 매물상세보기 보내기
		req.setAttribute("list", propertyDetail);
		req.setAttribute("lessorproperty", LessorPropertyDetail);
	
		
		
		
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/search-propertydetail.jsp");
		dispatcher.forward(req, resp);
	}

}
