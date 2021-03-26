package com.myhome.contractor.mypage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 박지현
 * 중개인 회원정보를 수정하는 클래스
 */
@WebServlet("/contractor/editcontractorok.do")
public class EditContractorOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		//1. 데이터 가져오기(seq, 비밀번호, 주소, 전화번호, 이메일)
		//2. DB 작업 -> update
		//3. 결과 반환 -> 알림

		ContractorDAO dao = new ContractorDAO();
		ContractorDTO dto = new ContractorDTO();

		//session 받는다.
		HttpSession session = req.getSession();
		//seq를 보내준다
		ArrayList<ContractorDTO> list = dao.list(session.getAttribute("seqAllUser").toString());

		//1. 
		req.setCharacterEncoding("UTF-8");

		//String seq = req.getParameter("seq");	//회원번호 
		String seq = session.getAttribute("seqAllUser").toString();
		
		/* String cseq = req.getParameter("seq"); */
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		String email = req.getParameter("email"); 
		String tel1 = req.getParameter("tel1");
		String tel2 = req.getParameter("tel2");	
		String tel3 = req.getParameter("tel3");

		//확인용
		//System.out.println(seq + " " + password + " " + email + " " + tel1 + " " + tel2 + " " + tel3);

		//가져온거 쓰기
		dto.setSeq(seq); //회원번호

		//null 검사
		//비밀번호
		if(password.equals(""))
			dto.setPassword(list.get(0).getPassword());
		else
			dto.setPassword(password);
		//이메일
		if(email.equals(""))
			dto.setEmail(list.get(0).getEmail());
		else
			dto.setEmail(email);
		
		//주소
		if(address.equals(""))
			dto.setAddress(list.get(0).getAddress());
		else
			dto.setAddress(address);
		
		//전화번호1
		if(tel1.equals(""))
			dto.setTel1(list.get(0).getTel1());
		else
			dto.setTel1(tel1);
		//전화번호2
		if(tel2.equals(""))
			dto.setTel2(list.get(0).getTel2());
		else
			dto.setTel2(tel2);
		//전화번호3
		if(tel3.equals(""))
			dto.setTel3(list.get(0).getTel3());
		else
			dto.setTel3(tel3);
	
		
		//회원정보수정
		int result = dao.edit(dto); 
	
		
		if (result == 1) {
			//회원정보수정 성공 -> 페이지에서 성공 팝업
			resp.sendRedirect("/Myhome_project/contractor/mypage-info.do?seqAllUser=" + seq);
			
		} else {
			//글수정 실패 -> 경고 + 뒤로 가기
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



