<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::찜목록관리</title>

<%-- <%@include file="/WEB-INF/views/inc/asset.jsp" %> --%>

<!-- <link rel="stylesheet" href="/Myhome_project/css/main.css"> -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="/Myhome_project/css/template.css">
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

.likebox {
	border: 2px solid #ffa9a9;
	border-radius: 5px;
	font-family: 'MaplestoryOTFLight';
	display: inline;
	position: relative;
	left: 60px;
	top: 100px;
	float: left;
	margin: 10px;
	width: 414px;
}

.like {
	border-top: 2px solid white;
	width: 150px;
	height: 150px;
	float: left;
}

.likeimg {
	margin-right: 10px;
	border-right: 1px dotted black;
	background-size: cover;
}

.likeinfo {
	background-color: #ffdfdf;
	padding-left: 30px;
	padding-top: 30px;
	width: 250px;
}

.innerbox {
	opacity: .7;
}

.wrapbutton {
	display: inline;
	position: relative;
	left: 80px;
	top: 100px;
	margin-left: 220px;
}

#btn-use {
	margin-left: 50px;
}

.tblinfo th {
	width: 70px;
}

.innerbox:hover {
	cursor: pointer;
	opacity: 1;
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
	left: 100px;
}

#info {
	font-size: 16px;
	font-family: 'NanumBarunGothic';
	display: inline;
	position: relative;
	left: 160px;
	top: 100px;
}

#pagebox1 {
	display: inline;
	position: relative;
	left: 800px;
	top: -170px;
}

#pagebox2 {
	position: relative;
	display: inline;
	left: 1000px;
	top: -170px;
}

#pagebox1 .pagebtn, #pagebox2 .pagebtn {
	border: 1px solid #888888;
	border-radius: 3px;
	background-color: white;
	width: 30px;
	outline: none;
}

#pagebox1 .pagebtn:hover, #pagebox2 .pagebtn:hover {
	background-color: #f6afb3;
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
				<div>
					<div id="maintitle">찜 목록 관리</div>
					<div id="info" style="color: #aaa;">
						<span class="glyphicon glyphicon-triangle-bottom"> 목록 클릭시 매물페이지로 이동합니다. </span>
					</div>
				</div>


				<div class="likebox" id="property">
					<div style="background-color: white">매물 찜 목록</div>
					
					<c:if test="${empty plist}">
					<div>찜한 매물이 존재하지 않습니다.</div>					
					</c:if>
					
					<c:forEach items="${plist}" var="pdto" varStatus="status">
						<div class="innerbox" onclick="location.href='/Myhome_project/contractor/search-property-detail.do?seq=${pdto.seqContractorProperty}';">	
							<div class="like likeimg" id="propertyimg2">
								<img src="/Myhome_project/image/1${status.index+1}.jpg"
									style="width: 150px; height: 150px;">
							</div>
							<div class="like likeinfo">
								<table class="tblinfo" id="info1">


									<tr>
										<th>매물가격</th>
										<c:if test="${pdto.dealing==0}">
											<c:if test="${pdto.monthlyRent!=0}">
												<td>[월세] ${pdto.monthlyRent/10000} / 보증금
													${pdto.deposit/10000}만원</td>
											</c:if>
											<c:if test="${pdto.monthlyRent==0}">
												<td>[전세] ${pdto.deposit/10000}만원</td>
											</c:if>
										</c:if>
										<c:if test="${pdto.dealing!=0}">
											<td>[매매] ${pdto.dealing/10000}만원</td>
										</c:if>
									</tr>
									<tr>
										<th>매물종류</th>
										<td>${pdto.roomtype}</td>
									</tr>
									<tr>
										<th>위치</th>
										<td>${pdto.location}</td>
									</tr>
									<tr>
										<th>크기</th>
										<td>${pdto.spacing}평</td>
									</tr>
									<tr>
										<th>층수</th>
										<td>${pdto.floor} [해당층수/전체층수]</td>
									</tr>

								</table>
							</div>
						</div>
					</c:forEach>
				</div>




				<div class="likebox" id="used">
					<div style="background-color: white">중고물품 찜 목록</div>
					
					<c:if test="${empty ulist}">
					<div>찜한 매물이 존재하지 않습니다.</div>					
					</c:if>

					<c:forEach items="${ulist}" var="udto" varStatus="status">
						<div class="innerbox" onclick="location.href='/Myhome_project/user/boardusedview.do?seq=${udto.seqUsed}'">
							<div class="like likeimg" id="usedimg1">
								<img src="/Myhome_project/image/used/used0${status.index+1}.jpg"
									style="width: 150px; height: 150px;">
							</div>
							<div class="like likeinfo">
								<table class="tblinfo" id="info2">
									<tr>
										<th>글제목</th>
										<td>${udto.title}</td>
									</tr>
									<tr>
										<th>가격</th>
										<td>${udto.price}</td>
									</tr>
									<tr>
										<th>거래방식</th>
										<td>${udto.tradeMode}</td>
									</tr>
									<tr>
										<th>작성일</th>
										<td>${udto.writeDate}</td>
									</tr>
								</table>
							</div>
						</div>
					</c:forEach>


					<div style="clear: both;"></div>
				</div>


			</div>



			<!-- footer -->
			<%@include file="/WEB-INF/views/inc/footer.jsp"%>
		</div>
	</div>
</body>
</html>