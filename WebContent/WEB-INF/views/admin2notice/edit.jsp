<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::공지사항</title>

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

/*버튼 수정*/
.boardbutton {
	width: 940px;
	padding-right: 120px;
	float: right;
	text-align: right;
	margin-top: -100px;
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

				<form method="POST"
				action="/Myhome_project/admin2/notice/editok.do">

				<table id="navboardtbl">

					<tr id="navboardtr">
						<td class="navboardtd">
							<!-- nav --> <%@include file="/WEB-INF/views/admin/nav.jsp"%>

						</td>

						<!-- 상세 보기 입니다.-->

						<td class="navboardtd">
							<div id="boardtitle" class="">공지사항</div>

							<div class="boardcover">
								<table id="board"
									class="table table-hover table-striped table-condensed">
									<!--  ?는 데이터 직접 넣기  -->
									<tr class="headtr">
										<th class="firtd boardtd">${dto.seqNotice}</th>
										<th class="sectd boardtd">${dto.title }</th>
										<th class="thitd boardtd">Admin${dto.seqAdmin }</th>
										<th class="fortd boardtd">${dto.writeDate}</th>
										<th class="fiftd boardtd">${dto.viewCount}</th>
									</tr>
									<tr class="boardtr">
										<td class="firtd boardtd" colspan="5"><textarea
												class="form-control col-sm-5 boardtext" name="title"  style="resize: none;"
												placeholder="여기에 제목을 작성해주세요" rows="1" cols="30"></textarea>
										</td>
									</tr>
									<tr class="boardtr">
										<td class="firtd boardtd" colspan="5"><textarea
												class="form-control col-sm-5 boardtext" name="content"  style="resize: none;"
												placeholder="여기에 게시글을 작성해주세요 300자까지 가능합니다. 간단한 안내사항만 작성해주세요" rows="15">${dto.content}</textarea>
										</td>

									</tr>


								</table>
							</div> <!-- 지금은 삭제? 아니면 안보이게? -->
							<input type="hidden" name="seqNotice" value="${dto.seqNotice}">
							<div class="boardbutton">
								<button id="Communitylist" type="button"
									onclick="location.href='/Myhome_project/admin2/notice/list.do';">
									목록</button>
								<button id="Noticedel" type="submit">
									수정</button>
				
							</div>
					<tr>
						<td></td>
					</tr>
				</table>
			</form>



		</div>

	</div>

	<!-- footer -->
	<%@include file="/WEB-INF/views/inc/footer.jsp"%>


	<script>
		
	</script>



</body>
</html>