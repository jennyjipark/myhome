package com.myhome.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 전자계약서 DB작업(파기)을 요청하는 클래스입니다. 
 * @author 이준오
 *
 */
@WebServlet("/user/contractcancel.do")
public class ContractCancel extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//1. 폐기할 전자계약번호받기..
		//2. DB작업 -> update -> 컬럼값 취소
		//3. 결과반환
		
		//1.
		int seqContract = Integer.parseInt(req.getParameter("seqContract"));
		
		
		//2.
		MypageContractDAO dao = new MypageContractDAO();
		
		int result = dao.cancelContract(seqContract);
		
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
