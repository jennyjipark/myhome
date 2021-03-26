package com.myhome.contractor.upload;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 박지현
 * 중개인 본인 매물 올리기
 */
@WebServlet("/contractor/upload-contractor.do")
public class UploadContractor extends HttpServlet{

	//http://localhost:8090/Myhome_project/contractor/upload-contractor.do
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		
		int seq = Integer.parseInt(session.getAttribute("seqAllUser").toString());
		
		session.setAttribute("seqAllUser", seq);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/contractor/upload-contractor.jsp");
		dispatcher.forward(req, resp);
		
		
		
	}
}
