package com.myhome.contractor.search;

import java.io.IOException;
import java.util.ArrayList;

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
 * 
 * @author 박지현
 * 중개인 매물 상세 정보 
 * 
 */
@WebServlet("/contractor/property-contractor-detail.do")
public class PropertyContractorDetail extends HttpServlet{

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//http://localhost:8090/Myhome_project/contractor/search-property-detail.do
		
		
		//1. 매물 정보
			PropertyDAO dao = new PropertyDAO();						
			

		//2. 중개인 매물번호 쿼리에 보내기
			int seqProperty = Integer.parseInt(req.getParameter("seq").toString());
			
			ArrayList<PropertyDTO> propertyDetail = dao.propertyDetail(seqProperty);
			
		//3. 임대인 매물번호 쿼리에 보내기
			int seqLessorProperty = Integer.parseInt(req.getParameter("seq").toString());
			ArrayList<PropertyDTO> LessorPropertyDetail = dao.LessorPropertyDetail(seqLessorProperty);
			
			
		//4. 매물상세보기 보내기
			req.setAttribute("list", propertyDetail);
			req.setAttribute("lessorproperty", LessorPropertyDetail);
		
			
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/contractor/property-contractor-detail.jsp");
		dispatcher.forward(req, resp);
		
	}
}
