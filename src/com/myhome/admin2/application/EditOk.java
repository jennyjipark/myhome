package com.myhome.admin2.application;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
/**
 * 청약 수정 업무처리 서블릿 
 * @author 이대홍
 */
@WebServlet("/admin2/application/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("UTF-8");

		//
		String title = "";
		String content =" dd ";
		String seqApplication ="";
		String file = "";
		String orgfile = "";

		try {
			MultipartRequest multi = new MultipartRequest(req, req.getRealPath("/image/admin2"), 1024 * 1024 * 10,
					"UTF-8", new DefaultFileRenamePolicy());

			System.out.println(req.getRealPath("/image/admin2"));
			seqApplication = multi.getParameter("seqApplication");
			title = multi.getParameter("title");
			content = multi.getParameter("content");
			file = multi.getFilesystemName("file");
			orgfile = multi.getOriginalFileName("file");

			ApplicationDAO dao = new ApplicationDAO();
			ApplicationDTO dto = new ApplicationDTO();

			dto.setSeqApplication(seqApplication);
			dto.setTitle(title);
			dto.setContent(content);
			dto.setViewcount("0");
			dto.setSavefile(file);

			int result = dao.edit(dto);

			dao.close();
			if (result == 1) {
				resp.sendRedirect("/Myhome_project/admin2/application/list.do");
			} else {
				PrintWriter writer = resp.getWriter();
				writer.println("<HTML><body>");
				writer.println("<Script>");
				writer.println("alert('failed')");
				writer.println("history.back();");
				writer.println("</script>");
				writer.println("</body></HTML>");
				
				writer.close();
			}

		} catch (Exception e) {
			System.out.println("EditOk java : " + e);
		}

	}

}
