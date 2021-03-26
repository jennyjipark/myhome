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

			<form action="" id="form1">

				<table id="navboardtbl">

					<tr id="navboardtr">
						<td class="navboardtd">
							<!-- nav --> <%@include file="/WEB-INF/views/admin/nav.jsp"%>

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
										<td class=" boardtd" colspan="3">
										<input type="text" placeholder="제목을 입력해주세요" style="text-align:center;" 
										value="${dto.title}" disabled id="usedtitle">
										</td>
									</tr>
									<tr class="headtr">
										<th class="boardtd">판매자</th>
										<td class="boardtd">${dto.id}</td>
										<th class="boardtd">거래방법</th>
										<td class="boardtd">
										${dto.tradeMode}
									<!--	<select name="selcate" id="selcate">
												<option value="dil">택배</option>
												<option value="meet">직거래</option>
										</select>   -->
										</td>
									</tr>
									<tr class="headtr">
										<th class=" boardtd">카테고리</th>
										<td class="boardtd">
										
											<c:if test="${category == '1' }">
											가구
											</c:if> <c:if test="${category == '2' }">
											뷰티
											</c:if> <c:if test="${category == '3' }">
											신발
											</c:if> <c:if test="${category == '4' }">
											의류
											</c:if> <c:if test="${category == '5' }">
											디지털/가전
											</c:if> <c:if test="${category == '6' }">
											생활용융
											</c:if> <c:if test="${category == '7' }">
											스포츠
											</c:if> <c:if test="${category == '8' }">
											식품
											</c:if> <c:if test="${category == '9' }">
											도서
											</c:if> <c:if test="${category == '10' }">
											기타
											</c:if> 
																				
										</td>
										<th class=" boardtd">금액</th>
										<td class=" boardtd">
										<!--  	<input type="number" step="100" name="price"
											id="price">--> ${dto.price} 원
										</td>
									</tr>

									<tr class="boardtr">
										<td class=" boardtd" colspan="4"><textarea
												class="form-control col-sm-5 boardtext"
												placeholder="여기에 게시글을 작성해주세요" rows="15" disabled>${dto.content}</textarea>
										</td>

									</tr>


								</table>
							</div> 
							<!-- 버튼 -->

							<div class="boardbutton">
								<button type="button" id="Communitylist"
									onclick="location.href='/Myhome_project/admin2/used/list.do?category=${category}';">
									목록</button>
								<button type="button" id="communitydel"
									onclick="location.href='/Myhome_project/admin2/used/delete.do?seq=${dto.seqUsed}&category=${category}';">
									삭제</button>
								<button type="button" id="checkerr"
									onclick="location.href='/Myhome_project/admin2/used/check.do?seq=${dto.seqUsed}';">
									검열</button>
							</div> <!--  댓글  -->

							<div class="myhomecomment">
								<!-- 여기 행을 움직이자-->
								
							<c:if test="${dto.count != '0' }">	
								<c:forEach items="${list}" var="cdto">
								<div class="MyhomeCommentRow">
									<div class="commentinfo">
										<input type="text" id="commentname" value="${cdto.id}">
										<textarea name="" id="" cols="40" rows="2">${cdto.content}</textarea>
										<div class="subinfo">
											<span class="commentdate">${cdto.writeDate}</span>
											<button type="button" 
											onclick="location.href='/Myhome_project/admin2/used/delcommentok.do?seq=${cdto.seqUsedComment}">
											삭제</button>
										</div>

									</div>
									
								</div>
							</c:forEach>
							</c:if>
							
							</div> 
							
							<!-- 첨부파일  
							<div class="boardfile">
							  <input type="file" class="form-control " id="inputGroupFile02" disabled>
							  <label class="" for="inputGroupFile02"></label>
							</div>
						--> <!-- 버튼 --> <!-- 지금은 삭제? 아니면 안보이게? -->




						</td>
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