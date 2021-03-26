package com.myhome.member;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member/RegisterContractorOk.do")
public class RegisterContractorOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String id = "";			//아이디
		String pw = "";			//비밀번호
		String name = "";		//이름
		String idNumber = "";	//주민등록번호
		String nickname = "";	//닉네임
		String email = "";		//이메일
		String tel = "";		//전화번호
		String address = "";	//주소
		String companyname = "";//회사명
		String companynumber ="";//사업자번호
		
		int result = 0; //업무 결과

		try {

			//req.getParameter() -> multi.getParameter()
			id = req.getParameter("id");
			pw = req.getParameter("pw");
			name = req.getParameter("name");
			idNumber = req.getParameter("idnumber");
			nickname = req.getParameter("nickname");
			email = req.getParameter("email");
			tel = req.getParameter("tel");
			address = req.getParameter("address");
			companyname = req.getParameter("companyname");
			companynumber = req.getParameter("companynumber");

			//확인용
			//System.out.println(id+" "+pw+" "+name+" "+idNumber+" "+ nickname +" "+email+" "+tel+" "+address);
			//System.out.println(location);
			//System.out.println(companyname + " " + companynumber);

			//DB 작업 -> 위임
			// - DAO + DTO
			MemberDAO dao = new MemberDAO();
			MemberDTO dto = new MemberDTO();			
			
			dto.setId(id);
			dto.setPassword(pw);
			dto.setName(name);
			dto.setIdNumber(idNumber);
			dto.setNickname(nickname);
			dto.setEmail(email);
			dto.setPhonenumber(tel);
			dto.setAddress(address);
			
			//tblAllUser (중개인, 회원)
			result = dao.add(dto); //위임 -> 1(성공) 0(실패)
			
			//tblContractor (중개인)
			//1. seq만 가져온다
			int seqAllUser = dao.getSeq(dto);
			//확인용
			//System.out.println(seqAllUser);
			//2. seq를 보내준다
			result = dao.addContractor(seqAllUser, companynumber, companyname);
			
			System.out.println(result);
			
		} catch (Exception e) {
			System.out.println(e);
		}


		//결과 : JSP 작업 X -> Servlet 작업 O
		if (result == 1) {
			//회원 가입 성공
			resp.sendRedirect("/Myhome_project/Myhome/main.do");
		} else {
			//회원 가입 실패
			PrintWriter writer = resp.getWriter();

			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('failed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");

			writer.close();
		}



	}
}


