<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::커뮤니티</title>
<%@include file="/WEB-INF/views/inc/asset.jsp"%>
<link rel="stylesheet" href="/Myhome_project/css/template.css">
<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="/Myhome_project/css/boarduserver.css"> -->


<!-- 부트스트랩 사용가능한 템플릿 -->

<style>
.container {
	border-color: transparent;
	font-family: 'NanumBarunGothic', sans-serif;
	font-size: 16px;
	position: relative;
	border-right: 1px solid #DBDCE0;
    border-left: 1px solid #DBDCE0;
}

.boardwrap {
	height: auto;
	min-height: 100%;
}

.boardcover {
	float: left;
	/* 		width: 900px; */
	width: 75%;
}

#maintitle {
	font-size: 24px;
	font-family: 'MaplestoryOTFLight';
	padding: 0 10px;
	border-left: 5px solid #f1aeae;
	position: relative;
	display: inline;
	text-align: left;
	color: #202020;
	top: 100px;
	left: 100px;
}

.table {
	position: relative;
	top: 160px;
	left: 100px;
}

.table thead tr th {
	text-align: center;
}

.table td:nth-child(1) {
	text-align: center;
	width: 90px;
}

.table td:nth-child(2) {
	text-align: left;
	width: auto;
}

.table td:nth-child(3) {
	text-align: center;
	width: 130px;
}

.table td:nth-child(4) {
	text-align: center;
	width: 130px;
}

.table td:nth-child(5) {
	text-align: center;
	width: 90px;
}

.table tr {
	height: 40px;
}

.table>tbody>tr>td {
	vertical-align: middle !important;
}

.btn {
	top: 150px;
	left: 810px;
	width: 65px;
}

#basic-addon1 {
	background-color: #f1aeae;
	color: white;
	outline: none;
	position: relative;
	float: left;
	/* 	left: 70px;
		top: 640px; */
	margin-right: 10px;
}

#basic-addon3 {
	background-color: #f1aeae;
	color: white;
	outline: none;
	position: relative;
	float: left;
	/* 		left: 35px;
		top: 640px; */
	margin-right: 10px;
}

#basic-addon4 {
	background-color: #f1aeae;
	color: white;
	outline: none;
	position: relative;
	float: right;
	top: -166px;
    left: -175px;
	width: 65px;
}

#basic-addon2 {
	background-color: #f1aeae;
	color: white;
	outline: none;
}

.search {
	margin: 20px auto;
	width: 430px;
	positioin: relative;
	float: left;
	top: -340px;
	left: 460px;
	
}



.pagebar {
	margin: 0px auto;
	margin-bottom: 70px;
	float: left;
	text-align: center;
	position: relative;
	top: -250px;
	left: 500px;
}

#page_bar>.active>a, #page_bar>li>a:hover {
	background-color: #f1aeae;
	border-color: #f1aeae;
	color: white;
}

#page_bar>li>a {
	color: #202020;
}

#titlename {
	color: #202020;
}

#searchResult {
	width: auto;
	position: relative;
	margin-top: 20px;
	display: inline-block;
}
</style>


</head>
<body>

	<div class="boardwrap">

		<!-- header -->
		<%@include file="/WEB-INF/views/inc/bootstrap-header.jsp"%>

		<div class="container">

			<%@include file="/WEB-INF/views/user/nav-board.jsp"%>

			<div id="maintitle">커뮤니티</div>



			<c:if test="${not empty search}">
				<div class="message well well-sm" id="searchResult">
					'${search}'(으)로 ${list.size()}건의 게시물을 검색했습니다.
					<!-- 어레이리스트가 아래 검색으로 출력되는 목록이므로 어레이리스트의 사이즈를 출력되게 함. -->
				</div>
			</c:if>








			<form action="" id="form1">
				<div class="boardcover">
					<table id="board"
						class="table table-hover table-striped table-condensed list">
						<thead>
							<tr class="headtr">
								<th class="firtd boardtd">번호</th>
								<th class="sectd boardtd">제목</th>
								<th class="thitd boardtd">작성자(닉네임)</th>
								<th class="fortd boardtd">작성일</th>
								<th class="fiftd boardtd">조회수</th>
							</tr>
						</thead>

						<tbody>

							<c:if test="${list.size() == 0}">
								<tr>
									<td colspan="5" style="text-align: center;">게시물이 없습니다.</td>
								</tr>
							</c:if>

							<c:forEach items="${list}" var="dto">
								<%-- <c:if test = "${dto.title != ' '}"> --%>

								<!-- 여기서 list가 어레이리스트 디티오. var은 이걸 담아줄 변수.-->
								<tr>
									<td>${dto.seqCommunity}</td>
									<td><a
										href="/Myhome_project/Myhome/user/boardcommunityview.do?seq=${dto.seqCommunity}&search=${search}&page=${nowPage}"
										id="titlename">${dto.title}</a> <!-- 뷰.java한테 검색어도 같이 들 고 간 것~ -->
										<%-- ${dto.gap} --%> <!-- 최신글 표시 --> 
										<c:if test="${dto.ccount > 0}">
		                            		<span class="badge" style="background-color:#f1aeae;">${dto.ccount}</span>
		                            	</c:if>
										<c:if test="${dto.gap < 1}">
											<span class="label label-danger">new</span>
										</c:if></td>
									<td>${dto.nickName}</td>
									<td>${dto.writeDate}</td>
									<td>${dto.viewCount}</td>
								</tr>
								<%-- </c:if> --%>
							</c:forEach>


						</tbody>

					</table>
				</div>

				<div class="btns btn-group" id="btnpost">



					<!-- 로그인을 해야지만 글쓰기 버튼 출력하기 -->
					<c:if test="${not empty name}">
						<%-- 	        <c:if test="${not empty id}"> --%>
						<button type="button" class="btn btn-default" id="basic-addon3"
							onclick="location.href='/Myhome_project/Myhome/user/boardcommunitylist.do';">목록</button>

						<button type="button" class="btn btn-default" id="basic-addon1"
							onclick="location.href='/Myhome_project/Myhome/user/boardcommunitywrite.do';">글쓰기</button>
					</c:if>

				</div>
				<div style="clear: both;"></div>


				<nav class="pagebar">
					<ul class="pagination" id="page_bar">${pagebar}
					</ul>
				</nav>
				<div style="width: 100%;">
					<button type="button" class="btn btn-default" id="basic-addon4"
						onclick="location.href='/Myhome_project/Myhome/user/boardcommunitylist.do';">목록</button>
				</div>
				<div style="clear: both;"></div>

			</form>


			<form id="searchForm" method="GET"
				action="/Myhome_project/Myhome/user/boardcommunitylist.do">
				<div class="input-group search">

					<input type="text" class="form-control"
						placeholder="제목, 내용, 작성자를 입력해주세요." aria-describedby="basic-addon2"
						id="search" name="search" required value="${search}"> <span
						class="input-group-addon" id="basic-addon2"
						onclick="$('#searchForm').submit();" style="cursor: pointer;"><span>검색</span></span>
				</div>
			</form>
			<div style="clear: both;"></div>


		</div>

	</div>

	<!-- footer -->
	<%@include file="/WEB-INF/views/inc/footer.jsp"%>

</body>
</html>