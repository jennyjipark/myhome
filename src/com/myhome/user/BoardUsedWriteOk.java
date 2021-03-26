package com.myhome.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 중고장터 게시판 DB작업(글작성)을 요청하는 클래스입니다. 
 * @author 이준오
 *
 */
@WebServlet("/user/boardusedwriteok.do")
public class BoardUsedWriteOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		//1. 작성한것들 받기
		//2. DB작업.
		//3. 결과 출력


		//1.
		String title = req.getParameter("title").toString();
		String tradeMode = req.getParameter("tradeMode").toString();	//거래방식
		int category = Integer.parseInt(req.getParameter("category").toString());
		int price = Integer.parseInt(req.getParameter("price").toString());
		String content = req.getParameter("content").toString();



		HttpSession session = req.getSession();

		int seq = Integer.parseInt(session.getAttribute("seqAllUser").toString());



		//2.
		BoardUsedDAO dao = new BoardUsedDAO();

		HashMap map = new HashMap();

		map.put("category", category);
		map.put("tradeMode", tradeMode);
		map.put("title", title);
		map.put("price", price);
		map.put("price", price);
		map.put("content", content);
		map.put("seq", seq);


		int result = dao.insertUsed(map);

		if (result==1) {
			resp.sendRedirect("/Myhome_project/user/boardusedlist.do");

		} else {
			PrintWriter writer = resp.getWriter();

			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('Writing Failed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");

			writer.close();

			return;			


		}






	}

}