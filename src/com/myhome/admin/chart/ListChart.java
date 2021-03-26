package com.myhome.admin.chart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * 가격변화 차트 목록 서블릿입니다.
 * @author 윤지현
 *
 */
@WebServlet("/admin/chart/listchart.do")
public class ListChart extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. DB작업 -> select
		//2. 결과 + JSP 호출
		
		ChartDAO dao = new ChartDAO();
		ArrayList<Chart1DTO> list1 = dao.get1();
		ArrayList<Chart2DTO> list2 = dao.get2();
		ArrayList<Chart3DTO> list3 = dao.get3();
		
		req.setAttribute("list1", list1);
		req.setAttribute("list2", list2);
		req.setAttribute("list3", list3);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/adminchart/listchart.jsp");
		dispatcher.forward(req, resp);

	}

}
