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
 * 청약 게시글  작성 DB처리용 서블릿  
 * @author 이대홍
 */
@WebServlet("/admin2/application/writeok.do")
public class WriteOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 번호 새로 받을 필용벗다. insert 로 하면됨.

		req.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession();

		String seqAdmin = (String) session.getAttribute("seqAdmin");

		// 
		String title = "";
		String content = "";
		String file = "";
		String orgfile = "";

		try {
			MultipartRequest multi = new MultipartRequest(req, req.getRealPath("/image/admin2"), 1024 * 1024 * 10,
					"UTF-8", new DefaultFileRenamePolicy());

			System.out.println(req.getRealPath("/image/admin2"));
			title = multi.getParameter("title");
			content = multi.getParameter("content");
			file = multi.getFilesystemName("file");
			orgfile = multi.getOriginalFileName("file");

			ApplicationDAO dao = new ApplicationDAO();
			ApplicationDTO dto = new ApplicationDTO();

			dto.setSeqAdmin(seqAdmin);
			dto.setTitle(title);
			dto.setContent(content);
			dto.setViewcount("0");
			if(file==null||file.equals("")) {
				file="empty";
			};
			dto.setSavefile(file);

			int result = dao.write(dto);

			
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
			System.out.println("WriteOk java : " + e);
		}

	}

}
