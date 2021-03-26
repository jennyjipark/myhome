package com.myhome.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myhome.company.CompanyDAO;
import com.myhome.company.CompanyDTO;
import com.myhome.company.ReviewDTO;

/**
 * 이사/청소업체의 정보를 출력하는 클래스입니다.
 * @author 장진영
 *
 */
@WebServlet("/user/cleanmovedetail.do")
public class CleanMoveDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//이사? 청소?
		String sel1 = req.getParameter("sel1");
		//회사번호
		String seq = req.getParameter("seq");
		
		CompanyDAO dao = new CompanyDAO();
		CompanyDTO cdto = new CompanyDTO();
		
		//회사정보 
		cdto = dao.getCompanyInfo(sel1, seq);
		
		//회사리뷰
		ArrayList<ReviewDTO> rdto = new ArrayList<ReviewDTO>();
		rdto = dao.getReview(sel1, seq);
		
		req.setAttribute("sel1", sel1);
		req.setAttribute("cdto", cdto);
		req.setAttribute("rdto", rdto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/clean-move-detail.jsp");
		dispatcher.forward(req, resp);

	}

}
