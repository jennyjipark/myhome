package com.myhome.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

/**
 * 중개인 목록을 요청하는 클래스입니다.
 * @author 이준오
 *
 */
@WebServlet("/user/vwcontractordata.do")
public class vwContractorData extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 받은 주소 확인.
		//2. DB작업 -> select 하기
		//3. 결과 반환
		
		//1.
		//주소 전체
		String location = req.getParameter("location");
		//중간값 '구' 만 뽑기 
		String[] temp= location.split(" ");
		location = temp[1];
		//2.
		//dao 생성
		MypageMatchingDAO dao = new MypageMatchingDAO();
		
		
		//select 값 받을 llist 생성
		ArrayList llist = dao.getContractorList(location);

		
		resp.setCharacterEncoding("UTF-8");
		
		JSONArray arr_strJson = new JSONArray(llist); 
		
		System.out.println(arr_strJson.toString());

		//3. 
		PrintWriter writer = resp.getWriter();
		
		writer.print(arr_strJson);
		
		writer.close();
				
		

		
	}
	
	
}
