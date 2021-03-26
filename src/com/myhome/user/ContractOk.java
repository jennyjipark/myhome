package com.myhome.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 전자계약서 DB작업(진행)을 요청하는 클래스입니다.
 * @author 이준오
 *
 */
@WebServlet("/user/contractok.do")
public class ContractOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 받아온 정보 추리기..
		//2. DB작업
		//tblContractorProperty의 state -- 0 :  계약 안됨..   1 :  계약됨...바꾸고..
		//tblContract의  contractState -> 완료
		
		//3. 페이지이동
		
		
		//1.
		int seqContractorProperty = Integer.parseInt(req.getParameter("hdn2"));
		int seqContract = Integer.parseInt(req.getParameter("hdn1"));
		
		
		//2. 
		MypageContractDAO dao = new MypageContractDAO();
		int result = dao.contract(seqContractorProperty, seqContract); 
		
		//성공 1, 실패 0..
		if (result==1) {
			//성공

			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('update Success');");
			writer.print("location.href='/Myhome_project/user/mypagecontract.do'");
			writer.print("</script>");
			writer.print("</body></html>");
			
		} else {
			//실패
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('update Failed');");
			writer.print("location.href='/Myhome_project/user/mypagecontract.do'");
			writer.print("</script>");
			writer.print("</body></html>");
			
			
		}
		
	
	}
	
}
