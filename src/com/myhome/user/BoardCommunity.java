package com.myhome.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//파일명 바꿨더니 기존 파일명으로 사이트가 열려서 오류남.. 이 주소로 열 것
//http://localhost:8090/Myhome_project/Myhome/user/boardcommunity.do
@WebServlet("/Myhome/user/boardcommunity.do")
public class BoardCommunity extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user/board.jsp");
		dispatcher.forward(request, response);
		
	}
	
}
