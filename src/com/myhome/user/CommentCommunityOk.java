package com.myhome.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Myhome/user/commentcommunityok.do")
public class CommentCommunityOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

		String seqCommunity = request.getParameter("seqCommunity");
		String ccontent = request.getParameter("ccontent");

		BoardCommunityDAO dao = new BoardCommunityDAO();
		CommentCommunityDTO dto = new CommentCommunityDTO();

		dto.setCcontent(ccontent);
		dto.setSeqCommunity(seqCommunity);
		// seq.. 오류나면 수정하기*****
		dto.setSeqAllUser(String.valueOf(session.getAttribute("seqAllUser"))); // 로그인한 회원번호(댓글쓴사람)

		int result = dao.writeComment(dto);

		if (result == 1) {
			// 댓글쓰기 성공 -> 뷰로 돌아와야 함
			// 오류나면 seq부분 수정하기 *****
//			response.sendRedirect("/Myhome/user/boardcommunityview.do?seqCommunity=" + seqCommunity); //현재 보고 있는 게시글 번호(bseq)
			response.sendRedirect("/Myhome_project/Myhome/user/boardcommunityview.do?seq=" + seqCommunity); // 현재 보고 있는
																											// 게시글
																											// 번호(seqCommunity)

		} else {
			// 글쓰기 실패 -> 경고 + 뒤로 가기
			PrintWriter writer = response.getWriter();

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
