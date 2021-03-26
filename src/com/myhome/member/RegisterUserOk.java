package com.myhome.member;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member/RegisterUserOk.do")
public class RegisterUserOk extends HttpServlet {

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
		String location = "";	//선호하는지역
		String alarm = "";
		String roomtype = "";
		String front = "";
		String end = "";
		String middle ="";
		
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
			//location = req.getParameter("location");
			roomtype = req.getParameter("roomtype");
			alarm = req.getParameter("alarm");
			
			front = req.getParameter("frontsel");
			end = req.getParameter("endsel");
			middle = req.getParameter("middlesel");
			
			location = front + " " + middle + " " + end;
			//시퀀스 받아오는용
			HashMap<Integer, String> temp = new HashMap<Integer, String>();
			MemberDAO dao = new MemberDAO();

			// 지역 받아옴
			temp = dao.getLocation();

			int seqLocation = getKey(temp, location);
			System.out.println(seqLocation);
			//확인용
			//System.out.println(id+" "+pw+" "+name+" "+idNumber+" "+ nickname +" "+email+" "+tel+" "+address);
			//System.out.println(location);
			//System.out.println(alarm + " " + roomtype);
			//System.out.println(front + " " + middle + " " + end);
			
			//DB 작업 -> 위임
			// - DAO + DTO
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
			
			//tblUser (회원)
			//1. seq만 가져온다
			int seqAllUser = dao.getSeq(dto);
			//확인용
			//System.out.println(seqAllUser);
			//2. seq를 보내준다
			result = dao.addUser(dto, roomtype, alarm, seqAllUser, seqLocation);
			
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

	private int getKey(HashMap<Integer, String> temp, String location) {
		
		for(Integer key : temp.keySet()) {
			//System.out.println(temp.get(key));
			if(location.equals(temp.get(key)))
				return key;
		}
		
		return 0;
		
	}
}


