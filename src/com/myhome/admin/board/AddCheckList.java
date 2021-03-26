package com.myhome.admin.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/***
 * 체크리스트 등록 페이지 서블릿입니다.
 * @author 윤지현
 *
 */

@WebServlet("/admin/board/addchecklist.do")
public class AddCheckList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 가져오기 (subject, content)
				//2. DB작업 > insert
				//3. 결과 처리
				
				HttpSession session = req.getSession();
				
				
				//if(session.getAttribute("id") == null) {
					
				//1. 내쫒기
				/*
				 * response.sendRedirect("/codestudy/board/list.do"); return; //아래
				 * RequestDispatcher 충돌을 막기위해
				 */			
				//2. 경고 + 내쫒기
			/*
				PrintWriter writer = resp.getWriter();
				
				writer.print("<html><body>");
				writer.print("<script>");
				writer.print("alert('filed');");
				writer.print("location.href='/Myhome_project/admin/board/listchecklist.do';");
				writer.print("</script>");
				writer.print("</body></html>");
				
				writer.close();
			*/
			//}
				
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/adminboard/addchecklist.jsp");
			dispatcher.forward(req, resp);	
				

			}

		}