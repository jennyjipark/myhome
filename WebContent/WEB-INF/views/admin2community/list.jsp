<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::정보공유커뮤니티</title>

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
	height: 1000px;
	width: 100%;
	margin: 0px;
	margin-top:-20px;
}

#navboardtbl .navboardtd:first-child {
	width: 200px;
}

.navboardtd {
	vertical-align: top;
}

/* 보더 수정 */
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

/* 검색, 페이지바 */
.search-paging {
	width: 800px;
	height: 200px;
	padding: 20px 0px;
}

.paging {
	width: 100%;
	height: 75px;
	padding: 0px 170px;
}

.pagination>li>.page-a {
	color: #202020;
}

.pagination>.active>a, .pagination>li>a:hover {
	background-color: #f1aeae;
	color: white !important;
}

.btn {
	background-color: #f1aeae;
	color: white;
	outline: none;
	font-family: 'NanumBarunGothic';
}

#search-box {
	/* border: 1px solid black; */
	width: 390px;
	height: 60px;
	margin: 10px 200px;
	padding: 10px;
}

#search-text {
	width: 300px;
	outline: 0;
	display: inline;
	margin-right: 10px;
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

			<form method="GET" action="/Myhome_project/admin2/community/delete.do">
	
				<table id="navboardtbl">

					<tr id="navboardtr">
						<td class="navboardtd">
							<!-- nav --> <%@include file="/WEB-INF/views/admin/nav.jsp"%>

						</td>
						<!---->

						<td class="navboardtd">
							<div id="boardtitle" class="">정보공유커뮤니티</div>

							<div class="boardcover">
								<table id="board"
									class="table table-hover table-striped table-condensed">

									<tr class="headtr">
										<th class="sixtd boardtd">선택</th>
										<th class="firtd boardtd">번호</th>
										<th class="sectd boardtd">제목</th>
										<th class="thitd boardtd">작성자</th>
										<th class="fortd boardtd">작성일</th>
										<th class="fiftd boardtd">조회수</th>

									</tr>
									<c:forEach items="${list}" var="dto">

									<tr class="boardtr">
										<td class="sixtd boardtd"><input type="checkbox"
											name="seq" id="seq" value="${dto.seqCommunity}"></td>
										<td class="firtd boardtd">${dto.seqCommunity}</td>
										<td class="sectd boardtd">
											<div class="Boardtdtitle">
												<span class="boardspan headspan"></span> 
												<a href="/Myhome_project/admin2/community/view.do?seq=${dto.seqCommunity}">
												${dto.title}</a>					
												<span class="boardspan footspan">[${dto.count}]</span>
											</div>
										</td>
										<td class="thitd boardtd">${dto.id}</td>
										<td class="fortd boardtd">${dto.writeDate}</td>
										<td class="fiftd boardtd">${dto.viewCount}</td>

									</tr>

									</c:forEach>

								</table>
							</div>

							<div class="boardwork d-grid gap-2 d-md-block btn-group">
<!-- 								<button class="btn btn-outline-secondary " type="button"
									id="button-addon2"
									onclick="location.href='/Myhome_project/admin2/community/write.do';">
									쓰기</button>
 -->							
 								<button class="btn btn-outline-secondary " type="submit"
									id="dele" style="outline:none;">삭제</button>
							</div> 
							</form>
											
							<!-- 검색, 페이지바 -->
							<div class="search-paging">
								<div class="paging">
									<ul class="pagination">
									${pagebar}
									</ul>
								</div>
								
								<form id="searchForm" method="GET"
									action="/Myhome_project/admin2/used/list.do">
				

								<div id="search-box">
									<input type="text" class="form-control" id="search-text"
										placeholder="닉네임, 매물번호를 입력해주세요.">
									<button class="btn btn-outline-secondary" type="button"
										id="button-addon1">검색</button>
								</div>
								</form>
								<!-- search-paging -->
							</div>
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