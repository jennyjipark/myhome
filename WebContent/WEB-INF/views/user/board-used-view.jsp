<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::중고장터</title>

<%-- <%@include file="/WEB-INF/views/inc/asset.jsp" %> --%>

<!-- <link rel="stylesheet" href="/Myhome_project/css/main.css"> -->
<link rel="stylesheet" href="/Myhome_project/css/template.css">
<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">
<link rel="stylesheet" href="/Myhome_project/css/board.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<%@include file="/WEB-INF/views/inc/asset.jsp"%>

<style>
body, html {
	height: 100%;
	margin: 0 auto;
	padding: 0;
}

.container {
	border: 0px;
	border-right: 1px solid #DBDCE0;
    border-left: 1px solid #DBDCE0;
}

#header {
	background-color: white;
}

#header:hover {
	background-color: white;
}

.header-containerwrap {
	height: auto;
	min-height: 100%;
}

.section2 {
	font-family: 'MaplestoryOTFLight';
	display: inline;
	position: relative;
	left: 200px;
	top: 100px;
	float: left;
}

#title {
	border-bottom: 1px dashed #ccc;
	font-size: 24px;
	margin-bottom: 30px;
	width: 200px;
}

#tbl1 {
	font-size: 16px;
	color: #202020;
}

#tbl1 td {
	height: 50px;
}

.section3 {
	margin-top: 30px;
	text-align: center;
	/* border: 1px solid black; */
}

.header {
	background-color: white;
}

#navboardtbl {
	height: 800px;
	width: 100%;
	margin: 0px;
}

/*기존 200xp 삭제만 300px*/
#navboardtbl .navboardtd:first-child {
	width: 300px;
}

.navboardtd {
	vertical-align: top;
}

/*타이틀 태그 */

/*타이틀 태그 */
#boardtitle {
	font-size: 24px;
	margin: 30px 10px;
	padding: 0px 10px;
	color: black;
	font-family: 'MaplestoryOTFLight';
	border-left: 5px solid #F1AEAE;
}

#board {
	margin-left: 0px;
}

.boardtext {
	margin-top: 10px;
	margin-buttom: 100px;
}

.boardfile>input {
	background-color: #f1aeae;
	width: 400px;
	height: 40px;
	margin-left: 20px;
	text-align: center;
	color: white;
	outline: none;
	border: 0;
}

/*버트 새로 고침 */
.boardbutton {
	width: 940px;
	padding-right: 120px;
	float: right;
	text-align: right;
	margin-top: -50px;
}

.boardbutton:after {
	content: "";
	display: block;
	clear: both;
}

.boardbutton button {
	display: inline-block;
	outline: none;
	border: 0px solid #000;
	background-color: #f1aeae;
	color: white;
	width: 70px;
	height: 34px;
	margin-right: 5px;
	margin-bottom: 10px;
	border-radius: 3px;
	z-index: 99;
}

/* 댓글 css 입니다. */
.MyhomeCommentRow {
	width: 940px;
}

.commentinfo {
	width: 700px;
	border-bottom: 1px solid #f1aeae;
}

.commentinfo>textarea {
	outline: none;
	border: 0px;
	width: 520px;
	font-size: 12px;
	overflow: visible;
	resize: none;
}

.subinfo {
	float: right;
	margin-right: 10px;
	font-size: 11px;
	text-align: center;
}

.subinfo>::after {
	content: "";
	display: block;
	clear: both;
}

.subinfo>button {
	border: 0;
	background-color: #f1aeae;
	color: white;
	width: 70px;
	border-radius: 3px;
}

#commentname {
	vertical-align: top;
	width: 80px;
	text-align: center;
	border: 0;
	outline: none;
	font-family: 'MaplestoryOTFLight';
}

/*  테이블 크기 조절*/
#usedtitle{
	width:550px;
	outline: none;
    border: 0px solid #000;
}
#selcate, #selusedcate, #price{
	width:150px;
    outline: none;
    border: 0px solid #000;
}
</style>
</head>
<body>
	<div class="wrap">

		<!-- header -->
		<%@include file="/WEB-INF/views/inc/bootstrap-header.jsp"%>

		<div class="container">

			<!-- <form action="" id="form1"> -->

				<table id="navboardtbl">

					<tr id="navboardtr">
						<td class="navboardtd">
							<!-- nav --> 
						<%-- <%@include file="/WEB-INF/views/user/nav.jsp"%> --%>

						</td>

						<!-- 상세 보기 입니다.-->

						<td class="navboardtd">
							<div id="boardtitle" class="">중고장터</div>

							<div class="boardcover">
								<table id="board"
									class="table table-hover table-striped table-condensed">
									<!--  ?는 데이터 직접 넣기  -->
									<tr class="headtr">
										<th class=" boardtd">제목</th>
										<td class=" boardtd" colspan="3" style="text-align:left;">${dto.title}</td>
									</tr>
									<tr class="headtr">
										<th class="boardtd">판매자</th>
										<td class="boardtd">${dto.name}</td>
										<th class="boardtd">거래방법</th>
										<td class="boardtd">${dto.tradeMode}</td>
									</tr>
									<tr class="headtr">
										<th class=" boardtd">카테고리</th>
										<td class="boardtd">${dto.category}</td>
										<th class=" boardtd">금액</th>
										<td class=" boardtd">${dto.price}원</td>
									</tr>

									<tr class="boardtr">
										<td class=" boardtd" colspan="4">
											<textarea class="form-control col-sm-5 boardtext" rows="15" disabled>${dto.content}</textarea>
										</td>

									</tr>


								</table>
							</div> <!-- 버튼 -->
							<div class="boardbutton">
								<button id="usedlist"
									onclick="history.back();">
									목록보기</button>
									
								<!-- 본인이 작성한 글이 아닐때만 찜버튼 보여줌 / 찜 등록 전-->
								<c:if test="${seqAllUser!=dto.seqUser && result==0}">
									<button id="likebtn">찜하기</button>
								</c:if>
								<!-- 본인이 작성한 글이 아닐때만 찜버튼 보여줌 / 찜 등록 후-->
								<c:if test="${seqAllUser!=dto.seqUser && result!=0}">
									<button id="likebtn">찜삭제</button>
								</c:if>
								
								
								<!-- 본인이 작성한 글에서만 삭제버튼 보여줌 -->
								<c:if test="${seqAllUser==dto.seqUser}">
								<button id="communitydel">삭제</button>
								</c:if>
								
								<!-- <button id="checkerr"
									onclick="location.href='/Myhome-project/admin2/community/check.do';">
									검열</button> -->

							</div> <!--  댓글  -->

							<div class="myhomecomment">
								<!-- 여기 행을 움직이자-->
								<div class="MyhomeCommentRow">
									<c:if test="${clist.size()==0}">
											<div class="commentinfo">
												<input type="text" id="commentname" readonly value="">
												<textarea name="" id="" cols="40" rows="2" readonly >댓글이 없습니다.</textarea>
											</div>
									</c:if>
									<c:forEach items="${clist}" var="cdto" varStatus="status">
									<form method="POST" id="form${status.index+1}" action="/Myhome_project/user/usedcommentdelete.do">
									<div class="commentinfo">
										<input type="text" id="commentname" readonly value="${cdto.nickname}">
										<textarea name="" id="" cols="40" rows="2" readonly >${cdto.content}</textarea>
										<div class="subinfo">
											<span class="commentdate">${cdto.writeDate}</span>
											<input type="hidden" id="ucseqhidden" name="ucseqhidden" value="${cdto.seqUsedComment}" >
											<input type="hidden" id="ucseqhidden2" name="ucseqhidden2" value="${seqUsed}" >
											<c:if test="${cdto.seqUser==seqAllUser||seqAllUser==dto.seqUser}">
												<button type="submit">삭제</button>
											</c:if>
											
										</div>

									</div>
									</form>
									</c:forEach>
								</div>
								<form method="POST" id="cform" action="/Myhome_project/user/usedcommentwrite.do">
								<div id="commentwrite">
									<input type="text" class="form-control" id="commenttxt" name="commenttxt" placeholder="댓글 본문을 입력하세요." style="width: 600px;" required>
									<input type="hidden" id="hiddenseq" name="hiddenseq" value="${dto.seqUsed}">
									<button type="submit">작성하기</button>
								</div>
								</form>
							</div> <!-- 첨부파일  
							<div class="boardfile">
							  <input type="file" class="form-control " id="inputGroupFile02" disabled>
							  <label class="" for="inputGroupFile02"></label>
							</div>
						--> <!-- 버튼 --> <!-- 지금은 삭제? 아니면 안보이게? -->




						</td>
					</tr>
				</table>
			<!-- </form> -->



		</div>

	</div>

	<!-- footer -->
	<%@include file="/WEB-INF/views/inc/footer.jsp"%>


	<script>
	$("#communitydel").click(function () {
		location.href="/Myhome_project/user/boarduseddelete.do?seq="+${dto.seqUsed}
		
	});
	$("#likebtn").click(function () {
		location.href="/Myhome_project/user/boardusedinsertlike.do?seq="+${dto.seqUsed};
		
	});
	</script>



</body>
</html>