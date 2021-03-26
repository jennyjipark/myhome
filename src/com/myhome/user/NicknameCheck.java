package com.myhome.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myhome.member.MemberDAO;
import com.myhome.member.MemberDTO;

/**
 * 회원 정보 수정 시 닉네임의 중복을 체크하는 클래스입니다.
 * @author 이준오
 *
 */
@WebServlet("/user/nicknamecheck.do")
public class NicknameCheck extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//글자 안깨지게..
		req.setCharacterEncoding("UTF-8");
		
		String nickname= req.getParameter("nickname");
		//1. DB들려서 확인..

		//nickname 다 가져오기 (중복체크)
		UserDAO mdao = new UserDAO();
		ArrayList<UserDTO> list = new ArrayList<UserDTO>();
		list = mdao.getAllNickname();
		
		//2. 비교 결과 반환
		//반환 결과 
		int result = 0;
		
		//같은 닉네임이 있으면 1반환 / 없으면 0 반환
		for (UserDTO dto : list) {
			if (dto.getNickname().equals(nickname)) {
				result = 1;
			}
			
		}
		
		
		/* HttpSession session = req.getSession(); */
		
		/* session.setAttribute("result", result); */
		req.setAttribute("result", result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/nicknamecheck.jsp");
		dispatcher.forward(req, resp);

	}

}