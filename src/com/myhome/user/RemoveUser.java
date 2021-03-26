package com.myhome.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 마이페이지 > 회원정보수정 > 회원삭제 페이지를 출력하는 클래스입니다.
 * @author 이준오
 *
 */
@WebServlet("/user/removeuser.do")
public class RemoveUser extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/removeuser.jsp");
		dispatcher.forward(req, resp);

	}

}