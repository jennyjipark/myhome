package com.myhome.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/searchpwdata.do")
public class SearchPwData extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String type = req.getParameter("type");
		String id = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		
		dto.setId(id);
		dto.setEmail(email);
		dto.setPhonenumber(phone);
		
		String pw = dao.searchPW(type, dto);
		
		//System.out.println(id + " " + email + " " + phone );
		
		PrintWriter writer = resp.getWriter();
		if(pw != null)
			writer.print(pw);
		writer.close();
		
	}
}
