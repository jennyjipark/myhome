package com.myhome.member;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myhome.chat.ChatDAO;

@WebServlet("/member/chatdata.do")
public class ChatData extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		//로그인 한 사람의 번호
		String seqUser = session.getAttribute("seqAllUser").toString();
		String seqTheOther = req.getParameter("seqTheOther");
	
		//채팅 가져온다
		ChatDAO dao = new ChatDAO();
		String result = dao.getChat(seqUser, seqTheOther);
		
		//3. 홈페이지에 뿌려준다.
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		
		writer.print(result);
		
		writer.close();
	}
}
