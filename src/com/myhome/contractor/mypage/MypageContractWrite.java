package com.myhome.contractor.mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contractor/mypage-contract-write.do")
public class MypageContractWrite extends HttpServlet{

	//http://localhost:8090/Myhome_project/contractor/mypage-contract-write.do
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 전자계약 정보 
		ContractDAO dao = new ContractDAO();
				 	  
		//2. 중개인 매물번호, 임차인 아이디 받기
		String idT = req.getParameter("idT");
		int seqContractorProperty = Integer.parseInt(req.getParameter("seq"));
		int seqContractor =  Integer.parseInt(req.getParameter("seqContractor"));
		int seqLessor = Integer.parseInt(req.getParameter("seqLessor"));
		
		
		System.out.println(seqLessor);
		
				
		
		//3. 매물정보 가져오기(중개인 정보 포함)
		ContractDAO pdao = new ContractDAO();
		ArrayList<PropertyDTO> plist = pdao.contractorProperty(seqContractor);
		
		
		//4. 임차인 정보 가져오기
		ArrayList<ContractDTO> tlist  = dao.getTenant(idT);
		
		int seqTenant = 0;
		
		for(ContractDTO dto : tlist) {
			
			dto.setSeqUserT(dto.getSeqUserT());
			seqTenant = dto.getSeqUserT();
			
			System.out.println(dto.getSeqUserT());
		}
		
		
		
		//5. 임대인 정보 가져오기
		ArrayList<ContractDTO> llist  = dao.getLessor(seqLessor);
		
		
		//6. tblContract에 insert (매물번호, 임차인 번호)
		dao.insertContract(seqTenant, seqContractorProperty);
		
		//7. 전자계약서 max seq가져오기
		int maxSeq = dao.maxSeq();
		
		System.out.println("maxSeq");
		req.setAttribute("maxSeq", maxSeq);
		req.setAttribute("plist", plist);
		req.setAttribute("llist", llist);
		req.setAttribute("tlist", tlist);
		
		RequestDispatcher dispatcher =
		req.getRequestDispatcher("/WEB-INF/views/contractor/mypage-contract-write.jsp");
		
		dispatcher.forward(req, resp);
		 
	}
}

