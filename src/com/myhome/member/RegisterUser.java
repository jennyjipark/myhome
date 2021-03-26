package com.myhome.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/RegisterUser.do")
public class RegisterUser extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
		req.setAttribute("front", front);
		req.setAttribute("middle", middle);
		req.setAttribute("end", end);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/RegisterUser.jsp");
		dispatcher.forward(req, resp);
	}

}
