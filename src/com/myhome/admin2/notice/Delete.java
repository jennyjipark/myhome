package com.myhome.admin2.notice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * 공지사항 게시글 삭제 안내 서블릿
 * @author 이대홍
 *
 */
@WebServlet("/admin2/notice/delete.do")
public class Delete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		String[] seqNotice = req.getParameterValues("seq");// 배열로 번호를 받음.

		
		NoticeDAO dao = new NoticeDAO();

		ArrayList<NoticeDTO> list = dao.list(seqNotice);

		for (NoticeDTO dto : list) {

			dto.setWriteDate(dto.getWriteDate().substring(0, 10));

		}
		dao.close();
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin2notice/delete.jsp");
		dispatcher.forward(req, resp);

	}

}
