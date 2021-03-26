<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::QnA</title>

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
}

.boardbutton button {
	float: right;
	display: inline-block;
	outline: none;
	border: 0px solid #000;
	background-color: #f1aeae;
	color: white;
	width: 70px;
	height: 34px;
	margin-right: 5px;
	border-radius: 3px;
}

.boardbutton button:after {
	content: "";
	display: block;
	clear: both;
}

/* 추가 요청 등록 */
.container{
	border-right: 1px solid #DBDCE0;
    border-left: 1px solid #DBDCE0;
}


</style>
</head>
<body>
	<div class="wrap">

		<!-- header -->
		<%@include file="/WEB-INF/views/admin/header.jsp"%>

		<div class="container">

			<table id="navboardtbl">

				<tr id="navboardtr">
					<td class="navboardtd">
						<!-- nav --> <%@include file="/WEB-INF/views/admin/nav.jsp"%>

					</td>

					<!-- 상세 보기 입니다.-->

					<td class="navboardtd">
						<div id="boardtitle" class="">QnA</div>

						<div class="boardcover">
							<table id="board"
								class="table table-hover table-striped table-condensed">
								<!--  ?는 데이터 직접 넣기  -->
								<tr class="headtr">
									<th class="firtd boardtd">카테고리</th>
									<th class="sectd boardtd" colspan="2">제목</th>
									<th class="firtd boardtd">작성자</th>
									<th class="firtd boardtd">처리상태</th>
									<th class="fortd boardtd">작성일</th>
									<!-- <th class="fiftd boardtd">조회수</th> -->
								</tr>
								<tr class="boardtr">
									<td class="firtd boardtd"><c:if test="${category == '1' }">
										매물
										</c:if> <c:if test="${category == '2' }">
										중고장터
										</c:if> <c:if test="${category == '3' }">
										커뮤니티
										</c:if> <c:if test="${category == '4' }">
										전자계약
										</c:if> <c:if test="${category == '5' }">
										기타
										</c:if></td>
									<td class="sectd boardtd" colspan="2">
										<div class="boardtexttilte">${dto.title}</div>
									</td>
									<td class="firtd boardtd">Admin${seqAdmin}</td>
									<td class="firtd boardtd">${dto.state}</td>
									<td class="fortd boardtd">${dto.writeDate}</td>
									<!-- <th class="fiftd boardtd">조회수</th> -->
								</tr>

								<tr class="boardtr">
									<td class="firtd boardtd" colspan="6"><textarea
											class="form-control col-sm-5 boardtext" style="resize: none;"
											placeholder="여기에 게시글을 작성해주세요" rows="15" disabled>${dto.content}</textarea>
									</td>

								</tr>
							</table>
						</div> <!-- 버튼 처리상태가 완료면 신고카운도 disabled
						ProcReportChat 채팅 전송
						ProcReportCompleteChat 카운트와 동시에 완료채팅 전송 -> 처리 상태 변경 
						--> <!--  -->
		<form method="POST" action="/Myhome_project/admin2/qna/writeok.do">
							<div class="boardbutton">
								<button type="submit" 
									<c:if test="${dto.state == '완료'}">
									disabled style="background-color: #777;"
									</c:if>
								>
									등록</button>
								<button type="button"
									onclick="location.href='/Myhome_project/admin2/qna/list.do?category=${category}';">
									목록</button>
								<!--  <button> 1234</button>-->
							</div>
							<c:if test="${dto.state ne '완료'}">
								<div id="boardtitle" class="">답글쓰기</div>
								<input type="hidden" name="seq" value="${dto.seqQna}">
								<input type="hidden" name="category" value="${category}">
								<div class="boardcover">
									<table id="board"
										class="table table-hover table-striped table-condensed">
										<!--  ?는 데이터 직접 넣기  -->

										<tr class="boardtr">
											<td class="firtd boardtd" colspan="5"><textarea
													name="content" class="form-control col-sm-5 boardtext"
													style="resize: none;" placeholder="여기에 게시글을 작성해주세요"
													rows="15"></textarea></td>

										</tr>

									</table>
								</div>
							</c:if>
					</form>
							<c:if test="${dto.state == '완료' }">
								<div id="boardtitle" class="">답글쓰기</div>

								<div class="boardcover">
									<table id="board"
										class="table table-hover table-striped table-condensed">
										<!--  ?는 데이터 직접 넣기  -->

										<tr class="boardtr">
											<td class="firtd boardtd" colspan="5"><textarea
													class="form-control col-sm-5 boardtext"
													style="resize: none;" placeholder="여기에 게시글을 작성해주세요"
													rows="15" disabled>${qCdto.content}</textarea></td>

										</tr>

									</table>
								</div>
							</c:if>
							<!-- 지금은 삭제? 아니면 안보이게? -->
							<!-- 							<div class="boardwork d-grid gap-2 d-md-block btn-group">
								<button class="btn btn-outline-secondary " type="button"
									id="button-addon2" onclick="location.href='/Myhome-project/admin2/report/chatok.do';">
									채팅 전송</button>
								<button class="btn btn-outline-secondary " type="button"
									id="button-addon2" onclick="location.href='/Myhome-project/admin2/application/list.do';">
									List</button>
							</div>
 -->
					</td>
				</tr>
			</table>



		</div>

	</div>

	<!-- footer -->
	<%@include file="/WEB-INF/views/inc/footer.jsp"%>


	<script>
		
	</script>



</body>
</html>