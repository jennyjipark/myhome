package com.myhome.admin.property;

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

import com.myhome.contractor.mypage.PropertyDAO;
import com.myhome.contractor.mypage.PropertyDTO;



@WebServlet("/admin/property/viewproperty.do")
public class ViewProperty extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*		
		//1.
		String seq = req.getParameter("seq");
		
		//2.
		AdminPropertyDAO dao = new AdminPropertyDAO();
		

		AdminPropertyDTO dto = dao.get(seq);
		
		dao.close(); //****
		
		//3. JSP에게 넘겨주기
		req.setAttribute("dto", dto);
		*/

		
		//http://localhost:8090/Myhome_project/contractor/search-property-detail.do
		
		
		//1. 매물 정보
			PropertyDAO dao = new PropertyDAO();						
			

		//2. 중개인 매물번호 쿼리에 보내기
			int seqProperty = Integer.parseInt(req.getParameter("seq").toString());
			
			ArrayList<PropertyDTO> propertyDetail = dao.propertyDetail(seqProperty);
			
		//3. 임대인 매물번호 쿼리에 보내기
			int seqLessorProperty = Integer.parseInt(req.getParameter("seq").toString());
			ArrayList<PropertyDTO> LessorPropertyDetail = dao.propertyDetail(seqLessorProperty);
			
			
		//4. 매물상세보기 보내기
			req.setAttribute("list", propertyDetail);
			req.setAttribute("lessorproperty", LessorPropertyDetail);
						
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/adminproperty/viewproperty.jsp");
			dispatcher.forward(req, resp);
					

		}
}
