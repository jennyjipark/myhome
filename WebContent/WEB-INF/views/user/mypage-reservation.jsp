<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::이사청소예약</title>

<%-- <%@include file="/WEB-INF/views/inc/asset.jsp" %> --%>

<!-- <link rel="stylesheet" href="/Myhome_project/css/main.css"> -->
<link rel="stylesheet" href="/Myhome_project/css/template.css">
<%@include file="/WEB-INF/views/inc/asset.jsp"%>

<style>
body, html {
	height: 100%;
	margin: 0 auto;
	padding: 0;
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

.tbl {
	text-align: center;
	width: 500px;
}

.tbl tr:hover {
	cursor: pointer;
	background-color: #ffe1e1;
	font-weight: bold;
	text-decoration: underline;
}

.section1 {
	padding-left: 50px;
	/* border: 1px solid black; */
	font-size: 16px;
	font-family: 'NanumBarunGothic';
	float: left;
	width: 900px;
	height: 850px;
}

#tbl2 {
	
}

#maintitle {
	border-bottom: 1px solid #ccc;
	font-size: 24px;
	font-family: 'MaplestoryOTFLight';
	padding-right: 50px;
	position: relative;
	display: inline;
	left: 100px;
	top: 100px;
	text-align: left;
	color: #202020;
}

tr>td:nth-child(1) {
	border: 1px solid #f6afb3;
	width: 200px;
}

tr>td:nth-child(2) {
	width: 300px;
}

.info {
	height: 168px;
	text-align: left;
	padding-left: 15px;
}

.info>div {
	margin: 15px;
}

label {
	margin-right: 20px;
}

#boxclean {
	position: relative;
	top: -840px;
	visibility: hidden;
}

#pagebox {
	position: relative;
	top: 880px;
	display: inline;
}

#pagebox .pagebtn {
	border: 1px solid #888888;
	border-radius: 3px;
	background-color: white;
	width: 30px;
	outline: none;
}

#pagebox .pagebtn:hover {
	background-color: #f6afb3;
}
.container {
	border: 0px;
	border-right: 1px solid #DBDCE0;
    border-left: 1px solid #DBDCE0;
}
</style>
</head>
<body>
	<div class="wrap">
		<div class="header-containerwrap">
			<!-- header -->
		<%@include file="/WEB-INF/views/inc/bootstrap-header.jsp"%>

			<div class="container">

				<!-- nav -->
				<%@include file="/WEB-INF/views/user/nav.jsp"%>

				<div id="maintitle">이사 청소 예약</div>
				<div class="section1">
					<div style="margin-top: 50px; color: #ccc; text-align: right;">
						<span class="glyphicon glyphicon-triangle-bottom"></span> 이사 /청소 중
						선택 > 지역 입력 > 검색하기 클릭.
					</div>
					<div style="text-align: right; margin: 19px;">
						<form method="get" action="/Myhome_project/user/mypagereservation.do">
						<c:set var="sel1" value='${sel1 }' />
							<c:choose>
								<c:when test=" ${sel1 == 'move' }">
									<input type="radio" name="sel1" id="rdmove" class="sel1" value="move" checked="checked">
									<label for="btnmove">이사</label>
									<input type="radio" name="sel1" id="rdclean" class="sel1" value="clean">
									<label for="btnclean">청소</label>
								</c:when>
								<c:when test="${sel1 == 'clean' }">
									<input type="radio" name="sel1" id="rdmove" class="sel1" value="move" >
									<label for="btnmove">이사</label>
									<input type="radio" name="sel1" id="rdclean" class="sel1" value="clean" checked="checked">
									<label for="btnclean">청소</label>
								</c:when>
								<c:otherwise>
									<input type="radio" name="sel1" id="rdmove" class="sel1" value="move" checked="checked" >
									<label for="btnmove">이사</label>
									<input type="radio" name="sel1" id="rdclean" class="sel1" value="clean">
									<label for="btnclean">청소</label>
								</c:otherwise>
							
							</c:choose>
							<c:set var="location" value='${location }' />
								<c:choose>
									<c:when test=" ${empty location }" >
										<input type="text" name="location" placeholder="지역(구)을 입력하세요. ex) 강남구 " style="width: 300px;" value="">
										<button type="submit" class="btn btn-success" id="btnsearch">검색하기</button>
									</c:when>
									<c:otherwise>
										<input type="text" name="location" placeholder="지역(구)을 입력하세요. ex) 강남구 " style="width: 300px;" value=" ${location }">
										<button type="submit" class="btn btn-success" id="btnsearch">검색하기</button>
									</c:otherwise>
								</c:choose>
						</form>
					</div>

					<a href='/Myhome_project/user/reservationlist.do' id="list-link">내
						예약목록으로 이동하기</a>


					<c:if test="${empty dto }">
						<div>검색목록이 없습니다</div>
					</c:if>
					<c:if test="${not empty dto}">
						<!-- 회사리스트 -->
						<div class="box" id="boxmove">
							<table class="tbl" id="tbl1">
								<c:forEach var="dto" items="${dto }" varStatus="status">
									<tr id="${dto.seq}" value="${dto.seq}">
										<td><img src='${dto.imagePath }' style="width: 200px;"></td>
										<td>
											<div class="info" style="border: 1px solid green;">
												<div style="font-weight: bold">${dto.name }</div>
												<div>${dto.introduce }</div>
												<div>${dto.price }~</div>
												<div>${dto.tel }</div>
											</div>
										</td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<!-- 페이지바 -->
						<nav class="pagebar">
							<ul class="pagination">${pagebar}</ul>
						</nav>
					</c:if>
				</div>

			</div>
		</div>


		<!-- footer -->
		<%@include file="/WEB-INF/views/inc/footer.jsp"%>
	</div>

	<script>
	
		var company = document.getElementsByTagName("tr")
		var sel1;
		var seq;
		
		for (var i = 0; i < company.length; i++) {
			company[i].onclick = function() {
				
				sel1 = $("input[name='sel1']:checked").val();
				seq = $(this).attr("value")
				
				
				//console.log(sel1 + " " + seq)
				location.href = '/Myhome_project/user/cleanmovedetail.do?sel1='+sel1+'&seq='+seq;
			}
		}

	</script>
</body>
</html>
