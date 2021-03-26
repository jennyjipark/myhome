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
 * 임대인 매물 상세 정보 
 * 
 */
@WebServlet("/contractor/property-lessor-detail.do")
public class PropertyLessorDetail extends HttpServlet{

	
	//http://localhost:8090/Myhome_project/contractor/property-lessor-detail.do
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 매물 정보
			PropertyDAO dao = new PropertyDAO();				
			

		//3. 임대인 매물번호 쿼리에 보내기
			int seqLessorProperty = Integer.parseInt(req.getParameter("seq").toString());
			ArrayList<PropertyDTO> LessorPropertyDetail = dao.LessorPropertyDetail(seqLessorProperty);
			
			
		//4. 매물상세보기로 보내기
			req.setAttribute("list", LessorPropertyDetail);
			
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/contractor/property-lessor-detail.jsp");
		dispatcher.forward(req, resp);
		
	}
}
