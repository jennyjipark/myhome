package com.myhome.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/searchiddata.do")
public class SearchIdData extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String type = req.getParameter("type");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		
		dto.setName(name);
		dto.setEmail(email);
		dto.setPhonenumber(phone);
		
		String id = dao.searchID(type, dto);
		
		System.out.println(id);
		
		PrintWriter writer = resp.getWriter();
		if(id != null)
			writer.print(id);
		writer.close();
		
	}
}
