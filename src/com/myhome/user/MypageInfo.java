package com.myhome.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myhome.member.LocationDTO;
import com.myhome.member.MemberDAO;
import com.myhome.member.MemberDTO;

/**
 * 마이페이지 > 회원정보수정 페이지를 출력하는 클래스입니다.
 * @author 이준오
 *
 */
@WebServlet("/user/mypageinfo.do")
public class MypageInfo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		//1. 데이터 가져오기(seq)
		//2. DB 작업 -> select
		//3. 결과 반환 -> JSP 호출하기
		
		//1.
		req.setCharacterEncoding("UTF-8");
		
		HashMap<Integer, String> location = new HashMap<Integer, String>();

		ArrayList<LocationDTO> front = new ArrayList<LocationDTO>();
		ArrayList<LocationDTO> middle = new ArrayList<LocationDTO>();
		ArrayList<LocationDTO> end = new ArrayList<LocationDTO>();

		MemberDAO dao = new MemberDAO();

		// 지역 받아옴
		location = dao.getLocation();

		int seqFront = 1;
		int seqMiddle = 1;
		int seqEnd = 1;
		int flag = 0;

		// 시
		for (int i = 1; i < location.size(); i++) {

			String line[] = location.get(i).split(" ");

			// 중복검사
			flag = 0;

			// 시
			for (int j = 0; j < front.size(); j++) {
				if (front.get(j).getLocation().equals(line[0])) {
					flag = 1;
					break;
				}
			}

			if (flag == 0) {
				LocationDTO ldto = new LocationDTO();

				ldto.setSeq(seqFront++);
				ldto.setmLocation(null);
				ldto.setLocation(line[0]);
				front.add(ldto);
			}
		}

		// 구
		for (int i = 1; i < location.size(); i++) {

			String line[] = location.get(i).split(" ");

			flag = 0;
			for (int j = 0; j < middle.size(); j++) {
				if (middle.get(j).getLocation().equals(line[1])) {
					flag = 1;
					break;
				}
			}

			if (flag == 0) {
				LocationDTO ldto = new LocationDTO();

				ldto.setSeq(seqMiddle++);

				for (int j = 0; j < front.size(); j++) {
					if (front.get(j).getLocation().equals(line[0])) {
						ldto.setmLocation(front.get(j).getLocation());
					}
				}
				ldto.setLocation(line[1]);
				middle.add(ldto);
			}
		}
		
		// 동
		for (int i = 1; i < location.size(); i++) {

			String line[] = location.get(i).split(" ");

			flag = 0;
			for (int j = 0; j < end.size(); j++) {
				if (end.get(j).getLocation().equals(line[2])) {
					flag = 1;
					break;
				}
			}

			if (flag == 0) {
				LocationDTO ldto = new LocationDTO();

				ldto.setSeq(seqEnd++);

				for (int j = 0; j < middle.size(); j++) {
					if (middle.get(j).getLocation().equals(line[1])) {
						ldto.setmLocation(middle.get(j).getLocation());
					}
				}
				ldto.setLocation(line[2]);
				end.add(ldto);
			}
		}

		 

		// 지역 보내줌
		
		
		HttpSession session = req.getSession();
		
		
		//2.
		UserDAO udao = new UserDAO();
		UserDTO dto = udao.getUserInfo(Integer.parseInt(session.getAttribute("seqAllUser").toString()));
		
		

		//2.5 dto 값 잘라 넣기
		String[] idnumber = dto.getIdNumber().split("-");
		String[] phonenumber = dto.getPhonenumber().split("-");
		
		String[] interestlocation = dto.getInterestlocation().split(" ");
	
		
		
		
		//3.
		req.setAttribute("front", front);
		req.setAttribute("middle", middle);
		req.setAttribute("end", end);

		req.setAttribute("dto", dto);
		
		req.setAttribute("idnumber", idnumber);
		req.setAttribute("phonenumber", phonenumber);
		req.setAttribute("interestlocation", interestlocation);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/mypage-info.jsp");
		dispatcher.forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//1. 받은 정보 취합
			//2. DB 작업 -> update 
			//3. 결과 반환.
			req.setCharacterEncoding("UTF-8");
			
			//1.
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			String ssn1 = req.getParameter("ssn1");
			String ssn2 = req.getParameter("ssn2");
			String nickname = req.getParameter("nickname");
			String password1 = req.getParameter("password1");
			String address = req.getParameter("address");
			String phonenumber1 = req.getParameter("phonenumber1");
			String phonenumber2 = req.getParameter("phonenumber2");
			String phonenumber3 = req.getParameter("phonenumber3");
			String email = req.getParameter("email");
			String interestroomtype = req.getParameter("interestroomtype");
			String frontsel = req.getParameter("frontsel");
			String middelsel = req.getParameter("middlesel");
			String endsel = req.getParameter("endsel");
			int alarm = Integer.parseInt(req.getParameter("alarm"));
			
			UserDAO udao = new UserDAO();
			UserDTO dto = new UserDTO();
			
			dto.setId(id);////
			dto.setName(name);////
			dto.setIdNumber(ssn1+"-"+ssn2);
			dto.setNickname(nickname);//
			dto.setPassword(password1);//
			dto.setAddress(address);//
			dto.setPhonenumber(phonenumber1+"-"+phonenumber2+"-"+phonenumber3);//
			dto.setEmail(email);//
			dto.setInterestroomtype(interestroomtype);
			dto.setInterestlocation(frontsel+" "+middelsel+" "+endsel);
			dto.setAlarm(alarm);
			
			HttpSession session = req.getSession();
			int seq = Integer.parseInt(session.getAttribute("seqAllUser").toString());
			//2.
			int resultLocation = udao.getSeqLocation(dto.getInterestlocation());
			int resultRoomtype = udao.getSeqRoomtype(dto.getInterestroomtype());
			
			dto.setSeqLocation(resultLocation);
			dto.setSeqPropertyRoomtypeDetail(resultRoomtype);
		
		
			int resultUpdate = udao.updateUser(dto, seq);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//3.
		}
			
		
		
		resp.sendRedirect("/Myhome_project/user/mypageinfo.do");
		
	
	}
	

}











