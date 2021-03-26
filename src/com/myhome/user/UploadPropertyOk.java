package com.myhome.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 방올리기페이지에서 전송한 정보를 토대로 DB작업을 요청하는 클래스
 * @author 이준오
 *
 */
@WebServlet("/user/uploadpropertyok.do")
public class UploadPropertyOk extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//1. 받은 input 정보 정리하기.
		//2. 받은값으로 insert하기
		//3. 결과반환
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		
			//회원번호
		String seqUser = req.getParameter("hdn3");
			//매물정보 (uploadproperty.do)
		String roomtype = req.getParameter("roomtype");
		
		String aircon = (req.getParameter("aircon"));
		String washer = req.getParameter("washer");
		String bed = req.getParameter("bed");
		String desk = req.getParameter("desk");
		String closet = req.getParameter("closet");
		String tv = req.getParameter("tv");
		String shoebox = req.getParameter("shoebox");
		String refrigerator = req.getParameter("refrigerator");
		String stove = req.getParameter("stove");
		String induction = req.getParameter("induction");
		String microwave = req.getParameter("microwave");
		String bidet = req.getParameter("bidet");
		if (aircon==null) {
			aircon = "0";
		}
		if (washer==null) {
			washer = "0";
		}
		if (bed==null) {
			bed = "0";
		}
		if (desk==null) {
			desk = "0";
		}
		if (closet==null) {
			closet = "0";
		}
		if (tv==null) {
			tv = "0";
		}
		if (shoebox==null) {
			shoebox = "0";
		}
		if (refrigerator==null) {
			refrigerator = "0";
		}
		if (stove==null) {
			stove = "0";
		}
		if (induction==null) {
			induction = "0";
		}
		if (microwave==null) {
			microwave = "0";
		}
		if (bidet==null) {
			bidet = "0";
		}
		
		String internet = req.getParameter("internet");
		String tvfee = req.getParameter("tvfee");
		String cleaning = req.getParameter("cleaning");
		String water = req.getParameter("water");
		String gas = req.getParameter("gas");
		String electric = req.getParameter("electric");
		String servicecharge = req.getParameter("servicecharge");
		if (internet==null) {
			internet = "0";
		}
		if (tvfee==null) {
			tvfee = "0";
		}
		if (cleaning==null) {
			cleaning = "0";
		}
		if (water==null) {
			water = "0";
		}
		if (gas==null) {
			gas = "0";
		}
		if (electric==null) {
			electric = "0";
		}
		if (servicecharge==null) {
			servicecharge = "0";
		}
		
		
		String address1 = req.getParameter("hdn1");
		String address2 = req.getParameter("hdn2");
		
		String tradetype  = req.getParameter("tradetype");
		
		String deposit = req.getParameter("deposit");
		if (deposit!=null) {
			deposit = deposit.trim();
		}
		String monthlyRent = req.getParameter("monthlyRent");
		if (monthlyRent!=null) {
			monthlyRent = monthlyRent.trim();
		}
		String dealing = req.getParameter("dealing");
		if (dealing!=null) {
			dealing = dealing.trim();
		}
		String contractPeriod = req.getParameter("contractPeriod");
		if (contractPeriod!=null) {
			contractPeriod = "0";
		}
		
		String suparea = req.getParameter("suparea");
		
		String heating = req.getParameter("heating");
		
		String totaloffloor = req.getParameter("totaloffloor");
		String numberoffloor = req.getParameter("numberoffloor");
		
		String floor = numberoffloor +"/"+totaloffloor;
		
		String datepicker = req.getParameter("datepicker");
		if (datepicker==null) {
			datepicker = "null";
		}
		
		String parking = req.getParameter("parking");
		String pet = req.getParameter("pet");
		String elevator = req.getParameter("elevator");
		String window = req.getParameter("window");
		
		String titletxt = req.getParameter("titletxt");
		String content = req.getParameter("content");
		
		
		
		//매칭만들기용으로 사용!
		String selcontractor = req.getParameter("selcontractor");
		if (selcontractor==null||selcontractor.equals("")) {
			selcontractor = "nomatch";
		}
		
		//확인용
		System.out.println("datepicker:"+datepicker);
		System.out.println("titletxt:"+titletxt);
		System.out.println("content:"+content);
		System.out.println("floor:"+floor);
		System.out.println("selcontractor:"+selcontractor);
		//2021-02-27 그냥 String으로써도됌.
		//-----------------------------------------------------------------
		//2. DB작업
		//2.
		UploadPropertyDAO dao = new UploadPropertyDAO();
		
		//2.1 tblLocation
		String address3 = address1 +" "+ address2;
		
		int result = dao.insertLocation(address3);
		
		//나중에 사용할 seqLocation
		int seqLocation = 0;
		if (result==1) {
			seqLocation = dao.getSeqLocation();
		}
		System.out.println("seqLocation:" +seqLocation);
		
		System.out.println("parking"+ parking);
		System.out.println("tradetype"+ tradetype);
		System.out.println("deposit"+ deposit);
		System.out.println("monthlyRent"+ monthlyRent);
		System.out.println("dealing"+ dealing);
		System.out.println("contractPeriod"+ contractPeriod);
		//2.2 tblPropertyContractType  매물계약
		
		if (tradetype.equals("1")) {
			//월세
			UploadPropertyDTO dto = new UploadPropertyDTO();
			dto.setTradetype(tradetype);
			dto.setDeposit(deposit);
			dto.setMonthlyRent(monthlyRent);
			dto.setContractPeriod(contractPeriod);
			
			result = dao.insertMonthlyRentData(dto);
			
		} 
		if(tradetype.equals("2")) {
			//전세
			UploadPropertyDTO dto = new UploadPropertyDTO();
			dto.setTradetype(tradetype);
			dto.setDeposit(deposit);
			dto.setContractPeriod(contractPeriod);
			
			result = dao.insertYearlyRentData(dto);
			
		} 
		if(tradetype.equals("3")) {
			//매매
			UploadPropertyDTO dto = new UploadPropertyDTO();
			dto.setTradetype(tradetype);
			dto.setDealing(dealing);
			
			result = dao.insertDealingData(dto);
		}
		
		//나중에 사용할 seqPropertyContractType..
		int seqPropertyContractType = 0;
		if (result==1) {
			seqPropertyContractType = dao.getSeqPropertyContractType();
		}
		System.out.println("seqPropertyContractType :"+seqPropertyContractType );
		
		//2.3 tblMaintenanceOption 관리비옵션 추가
		
		UploadPropertyDTO dto = new UploadPropertyDTO();
		dto.setInternet(internet);
		dto.setTvfee(tvfee);
		dto.setCleaning(cleaning);
		dto.setWater(water);
		dto.setGas(gas);
		dto.setElectric(electric);
		dto.setServicecharge(servicecharge);
		
		result = dao.insertMaintenance(dto);
		
		//나중에 사용할 seqMaintenanceOption 받아오기
		int seqMaintenanceOption = 0;
		if (result==1) {
			seqMaintenanceOption = dao.getSeqMaintenanceOption();
		}
		System.out.println("seqMaintenanceOption :"+seqMaintenanceOption);
		
		
		//2.4 tblPropertyBuildingOption 매물옵션(건물) 추가!
		UploadPropertyDTO dto2 = new UploadPropertyDTO();
		dto2.setParking(parking);
		dto2.setElevator(elevator);
		dto2.setPet(pet);
		dto2.setWindow(window);
		
		result = dao.insertBuildingOption(dto2);
		
		//나중에 사용할 seqPropertyBuildingOption 받아오기
		int seqPropertyBuildingOption = 0;
		if (result==1) {
			seqPropertyBuildingOption = dao.getSeqPropertyBuildingOption();
		}
		System.out.println("seqPropertyBuildingOption : "+seqPropertyBuildingOption);
		
		
		//2.5 tblPropertyRoomType 방의형태 추가!
		UploadPropertyDTO dto3 = new UploadPropertyDTO();
		dto3.setRoomtype(roomtype);
		dto3.setSuparea(suparea);
		
		result = dao.insertPropertyRoomType(dto3);
		
		//나중에 사용할 seqPropertyRoomType 받아오기
		int seqPropertyRoomType = 0;
		if (result==1) {
			seqPropertyRoomType = dao.getSeqPropertyRoomType();
		}
		System.out.println("seqPropertyRoomType: "+ seqPropertyRoomType);
		
		
		//2.6 tblPropertyRoomOption 매물옵션(방) 추가!!
		UploadPropertyDTO dto4 = new UploadPropertyDTO();
		dto4.setAircon(aircon);
		dto4.setWasher(washer);
		dto4.setBed(bed);
		dto4.setDesk(desk);
		dto4.setCloset(closet);
		dto4.setTv(tv);
		dto4.setShoebox(shoebox);
		dto4.setRefrigerator(refrigerator);
		dto4.setStove(stove);
		dto4.setInduction(induction);
		dto4.setMicrowave(microwave);
		dto4.setBidet(bidet);
		
		result = dao.insertPropertyRoomOption(dto4);
		
		//나중에 사용할 seqPropertyRoomOption 받아오기
		int seqPropertyRoomOption = 0;
		if (result==1) {
			seqPropertyRoomOption = dao.getSeqPropertyRoomOption();
		}
		System.out.println("seqPropertyRoomOption :"+seqPropertyRoomOption);
		
		
		//2.7 tblProperty 모든매물 (매물 객체 ) 추가 !!
		PropertyDTO dto5 = new PropertyDTO();
		dto5.setSeqPropertyContractType(seqPropertyContractType);
		dto5.setSeqPropertyRoomOption(seqPropertyRoomOption);
		dto5.setSeqPropertyBuildingOption(seqPropertyBuildingOption);
		dto5.setSeqLocation(seqLocation);
		dto5.setSeqMaintenanceOption(seqMaintenanceOption);
		dto5.setSeqPropertyRoomType(seqPropertyRoomType);
		dto5.setSeqImage(1);
		dto5.setOccupancyDate(datepicker);
		dto5.setFloor(floor);
		dto5.setTitle(titletxt);
		dto5.setContent(content);
		
		result = dao.insertProperty(dto5);
		
		//나중에 사용할 seqProperty 받아오기
		int seqProperty = 0;
		if (result==1) {
			seqProperty = dao.getSeqProperty();
		}
		System.out.println("seqProperty :"+seqProperty);
		System.out.println("seqUser : "+seqUser);
		
		//2.8 tblLessorProperty 에 임대인 매물 추가!
		LessorPropertyDTO dto6 = new LessorPropertyDTO();
		dto6.setSeqProperty(seqProperty);
		dto6.setSeqUser(Integer.parseInt(seqUser));
		
		result = dao.insertLessorProperty(dto6);
		
		//나중에 사용할 seqProperty 받아오기
		int seqLessorProperty = 0;
		if (result==1) {
			seqLessorProperty = dao.getSeqLessorProperty();
		}
		System.out.println("seqLessorProperty :"+seqLessorProperty);
		System.out.println("selcontractor:"+selcontractor);
		
		//2.9 중개인 선택한 경우 tblMatching에 매칭요청 추가!
		if (!selcontractor.equals("nomatch")) {
			
			MatchingDTO dto7 = new MatchingDTO();
			dto7.setSeqLessorProperty(seqLessorProperty);
			dto7.setSeqContractor(Integer.parseInt(selcontractor));
			
			result = dao.insertMatching(dto7);
			
			
		}
		
		//3. 결과 반환
		if (result==1) {
			//성공

			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('insert Success... Back to Main');");
			writer.print("location.href='/Myhome_project/Myhome/main.do'");
			writer.print("</script>");
			writer.print("</body></html>");
			
		} else {
			//실패
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('insert Failed... Back to Main');");
			writer.print("location.href='/Myhome_project/Myhome/main.do'");
			writer.print("</script>");
			writer.print("</body></html>");
			
			
		}
		
	}
	
}
