package com.myhome.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 방올리기 페이지를 출력하는 클래스입니다.
 * @author 이준오
 *
 */
@WebServlet("/user/uploadproperty.do")
public class UploadProperty extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/upload-property.jsp");
		dispatcher.forward(req, resp);

	}
	
}
