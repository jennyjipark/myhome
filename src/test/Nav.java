package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/navboard.do")
public class Nav extends HttpServlet{

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//http://localhost:8090/Myhome_project/admin/navboard.do
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admin/navboard.jsp");
		dispatcher.forward(request, response);
		
	}
}
