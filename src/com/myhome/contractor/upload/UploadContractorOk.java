package com.myhome.contractor.upload;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myhome.contractor.mypage.MatchingDAO;
import com.myhome.contractor.mypage.PropertyDTO;


/**
 * @author 박지현
 * 중개인의 매물을 올리는 클래스
 */
@WebServlet("/contractor/upload-contractor-ok.do")
public class UploadContractorOk extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
			HttpSession session = req.getSession();
				
			int seq = Integer.parseInt(session.getAttribute("seqAllUser").toString());
									
			UploadContractorDAO dao = new UploadContractorDAO();
			
			
			//매물 정보 받고 쿼리 날리기
			
			//1. 방유형 1, 2, 3 + 평수
			String roomType = req.getParameter("roomtype");		
			String spacing = req.getParameter("suparea");
			
			int result = dao.insertRoom(roomType, spacing);
			
			System.out.println("roomtype : " + roomType);
			
			
			//2. 방옵션 12개
			
			String airconditional = req.getParameter("aircon");
			String washer =  req.getParameter("washer");
			String bed =  req.getParameter("bed");
			String desk =  req.getParameter("desk");
			String closet =  req.getParameter("closet");
			String tv =  req.getParameter("tv");
			String shoebox = req.getParameter("shoebox");
			String refrigerator = req.getParameter("refrigerator");
			String stove =  req.getParameter("stove");
			String induction = req.getParameter("induction");
			String microwave = req.getParameter("microwave");
			String bidet =  req.getParameter("bidet");
			
			
			//방옵션 배열
			String[] roomOption = { airconditional, washer, bed, desk, closet, tv, shoebox, refrigerator, stove, induction, microwave, bidet };
			
			for(int i=0; i<roomOption.length; i++) {
				
				if(roomOption[i] == null) {
					roomOption[i] = "0";
				} 
				
			}
			
			int result2 = dao.roomOption(roomOption);
			
			
			//3. 관리비
			String internet =  req.getParameter("internet");
			String cabletv =  req.getParameter("tvfee");
			String cleaning =  req.getParameter("cleaning");
			String water =  req.getParameter("water");
			String gas =  req.getParameter("gas");
			String electric =  req.getParameter("electric");
			String serviceCharge =  req.getParameter("serviceCharge");
			
			//관리비 배열
			String[] serviceOption = { internet, cabletv, cleaning, water, gas, electric, serviceCharge };
			
			for(int i=0; i<serviceOption.length; i++) {
				
				if(serviceOption[i] == null) {
					serviceOption[i] = "0";
				} 
				
			}
			
			int result3 = dao.insertServiceCharge(serviceOption);
			
			
			//4. 계약유형 1. 월세 2. 전세 3. 매매
			String contractType =  req.getParameter("tradetype");
			
			
			//가격
			String deposit = req.getParameter("deposit");
			String monthlyRent =  req.getParameter("monthlyRent");
			String dealing =  req.getParameter("dealing");
			String contractPeriod =  req.getParameter("contractPeriod");
			
			int result4 = dao.insertContractType(contractType, deposit, monthlyRent, dealing, contractPeriod);			
			
			
			//5. 건물옵션
			
			String parking = req.getParameter("parking");
			String pet = req.getParameter("pet");
			String elevator = req.getParameter("elevator");
			String window = req.getParameter("window");
			
			//건물옵션 배열
			String[] buildingOption = { parking, pet, elevator, window };
			
			for(int i=0; i<buildingOption.length; i++) {
				
				if(buildingOption[i] == null) {
					buildingOption[i] = "0";
				} 
				
			}
			
			int result5 = dao.buildingOption(buildingOption);
			
			
			//6. 지역
			
			String[] location = { req.getParameter("location1"), req.getParameter("location2") };
			
			int result6 = dao.location(location);
			
			
			//7. 이미지
			String path = req.getParameter("img");
			
			
			//모든매물 최종넣기
			
			
			//1. 날짜 즉시입주 null
			String occupancyDate = req.getParameter("occupancy");
			
			
			//2. 층
			String totalfloor = req.getParameter("totaloffloor");
			String numberoffloor = req.getParameter("numberoffloor");
		
			String[] floor = { totalfloor, numberoffloor };
			
			//3. 제목
			String title = req.getParameter("titletxt");
			
			//4. 상세내용
			String content = req.getParameter("content");
			
			
			dao.write(seq, occupancyDate, floor, title, content);
			
			
			
			
			
		
	}
}
