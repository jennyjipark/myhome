package com.myhome.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
*/

@WebServlet("/Myhome/user/boardcommunitywriteok.do")
public class BoardCommunityWriteOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		// 1.
		req.setCharacterEncoding("UTF-8");

		String title = req.getParameter("title");
		String content = req.getParameter("content");
//		String seqUser = (String)session.getAttribute("seq"); //오류나면 이부분 수정하기*****
//		String seqAllUser = (String)session.getAttribute("seqAllUser"); //오류나면 이부분 수정하기*****
		String seqAllUser = String.valueOf(session.getAttribute("seqAllUser")); // 오류나면 이부분 수정하기*****

		try {

			// 첨부파일 코드 부분!!! 오류나면 여기 수정하기*****

		} catch (Exception e) {
			System.out.println("BoardCommunityWriteOk.doPost()");
			e.printStackTrace();
		}

		// 2.
		BoardCommunityDAO dao = new BoardCommunityDAO();
		BoardCommunityDTO dto = new BoardCommunityDTO();

		dto.setTitle(title);
		dto.setContent(content);
//		dto.setSeqUser(seqUser);
		// 수정하기**
		dto.setSeqAllUser(seqAllUser);

		int result = dao.write(dto);

		// *****로그인 연동한 뒤에 이 기능 설정하기. 로그인까지 확인한후 수정하기*****
		if (result == 1) {
			resp.sendRedirect("/Myhome_project/Myhome/user/boardcommunitylist.do");
		} else {
			PrintWriter writer = resp.getWriter();

			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('failed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");

			writer.close();
		}


	}

}
