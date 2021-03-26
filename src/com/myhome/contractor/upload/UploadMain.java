package com.myhome.contractor.upload;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 박지현
 * 임대인 매물 올리기 & 중개인 매물 올리기 선택
 */
@WebServlet("/contractor/upload-main.do")
public class UploadMain extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//http://localhost:8090/Myhome_project/contractor/upload-main.do
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/contractor/upload-main.jsp");
		dispatcher.forward(request, response);
		
	}
}
