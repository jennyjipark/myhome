package com.myhome.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 마이페이지 > 내가쓴글보기 페이지를 출력하는 클래스입니다.
 * @author 이준오
 *
 */
@WebServlet("/user/mypagemywrite.do")
public class MypageMyWrite extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 회원 번호 받기..
		//2. DB작업
		//3. 결과 반환
		
		//1.
		HttpSession session = req.getSession();
		
		int seqUser = Integer.parseInt(session.getAttribute("seqAllUser").toString());
		
		
		
		//2.1 중고장터(tblUsed), 방올리기(tblLessorProperty), 커뮤니티(tblCommunity)에서 내가 쓴 글 목록 받아오기.
		//게시글
			//중고장터
		ArrayList<MypageMyWriteDTO> alist = new ArrayList<MypageMyWriteDTO>();
			//방올리기
		ArrayList<MypageMyWriteDTO> blist = new ArrayList<MypageMyWriteDTO>();
			//커뮤니티
		ArrayList<MypageMyWriteDTO> clist = new ArrayList<MypageMyWriteDTO>();
		
		//2.2 /댓글/ 중고장터댓글, 커뮤니티댓글 /후기/ 이삿짐센터후기, 청소업체후기, 중개인후기, 매물후기 에서 내가쓴글 목록 받아오기
		//댓글
			//중고장터댓글
		ArrayList<MypageMyWriteDTO> dlist = new ArrayList<MypageMyWriteDTO>();
			//커뮤니티댓글
		ArrayList<MypageMyWriteDTO> elist = new ArrayList<MypageMyWriteDTO>();
		//후기
			//이삿짐센터후기
		ArrayList<MypageMyWriteDTO> flist = new ArrayList<MypageMyWriteDTO>();
			//청소업체후기
		ArrayList<MypageMyWriteDTO> glist = new ArrayList<MypageMyWriteDTO>();
			//중개인후기
		ArrayList<MypageMyWriteDTO> hlist = new ArrayList<MypageMyWriteDTO>();
			//매물후기
		ArrayList<MypageMyWriteDTO> ilist = new ArrayList<MypageMyWriteDTO>();

		//2.3 /신고/ 중고장터신고, 매물거래신고, 커뮤니티신고  에서 내가 쓴 글 목록 받아오기.
		//신고
			//중고장터신고
		ArrayList<MypageMyWriteDTO> jlist = new ArrayList<MypageMyWriteDTO>();
			//매물거래신고
		ArrayList<MypageMyWriteDTO> klist = new ArrayList<MypageMyWriteDTO>();
			//커뮤니티신고
		ArrayList<MypageMyWriteDTO> llist = new ArrayList<MypageMyWriteDTO>();
		
		
		//2.4 뚝딱이 생성
		MypageMyWriteDAO dao = new MypageMyWriteDAO();
		
		//중고장터(글) 리스트 가져오기
		alist = dao.getMyUsedList(seqUser);
		//방올리기(글) 리스트 가져오기
		blist = dao.getMyPropertyList(seqUser);
		//커뮤니티(글) 리스트 가져오기
		clist = dao.getMyCommunityList(seqUser);
		
		//중고장터(댓글) 리스트 가져오기
		dlist = dao.getMyUsedCommentList(seqUser);
		//커뮤니티(댓글) 리스트 가져오기
		elist = dao.getMyCommunityCommentList(seqUser);
		
		//이삿짐센터(후기) 리스트 가져오기
		flist = dao.getMyMoveReviewList(seqUser);
		//청소업체(후기) 리스트 가져오기
		glist = dao.getMyCleanReviewList(seqUser);
		//중개인(후기) 리스트 가져오기
		hlist = dao.getMyContractorReviewList(seqUser);
		//매물(후기) 리스트 가져오기
		ilist = dao.getMyPropertyReviewList(seqUser);
		
		//중고장터(신고) 리스트 가져오기
		jlist = dao.getMyUsedReportList(seqUser);
		//매물거래(신고) 리스트 가져오기
		klist = dao.getMyPropertyReportList(seqUser);
		//커뮤니티(신고) 리스트 가져오기
		llist = dao.getMyCommunityReportList(seqUser);
		
		
		
		//3.
		req.setAttribute("alist", alist);
		req.setAttribute("blist", blist);
		req.setAttribute("clist", clist);
		req.setAttribute("dlist", dlist);
		req.setAttribute("elist", elist);
		
		req.setAttribute("flist", flist);
		req.setAttribute("glist", glist);
		req.setAttribute("hlist", hlist);
		req.setAttribute("ilist", ilist);
		req.setAttribute("jlist", jlist);
		
		req.setAttribute("klist", klist);
		req.setAttribute("llist", llist);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/mypage-mywrite.jsp");
		dispatcher.forward(req, resp);

	}

}
