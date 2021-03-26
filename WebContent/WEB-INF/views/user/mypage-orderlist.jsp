<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::매물거래내역</title>

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

.container {
	font-family: 'NanumBarunGothic';
	font-size: 16px;
	border: 0px;
	border-right: 1px solid #DBDCE0;
    border-left: 1px solid #DBDCE0;
}
#tbl1{
	width: 860px;
}
#tbl1 tr{
	border-bottom: 1px solid #d4d4d4;
	height: 35px;
}
#tbl1 tr:nth-child(odd) {
	background-color: #F9F9F9;
}

#tbl1 th{
	border-top: 1px solid #d4d4d4;
	text-align: center;
}
#box1{
	/* border: 1px solid black; */
	float: left;
	margin-left: 75px;
}

tr td:nth-child(5) {
	color: #a5a5a5
}

#tbl1 tr:hover {
	cursor: pointer;
	background-color: #ffe1e1;
	font-weight: bold;
	text-decoration:underline;
}

#explain {
	color: #aaa;
	text-align: right;
	margin-bottom: 24px;
}
#comment {
	margin-right: 30px;
}
#title {
	text-align: left;
	border-bottom: 1px solid #ccc;
	font-family: 'MaplestoryOTFLight';
	font-size: 24px;
	float: left;
	width: 200px;
	margin-left: 100px;
	margin-top: 96px;
	
}

#section1 {
	text-align: center;
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

				<div id="section1">

					<div id="title">매물 거래 내역</div>
					<div class="box" id="box1">

						<div id="explain">작성하기 버튼을 누르면 후기작성 페이지로 이동합니다.</div>

						<table class="tbl" id="tbl1">
							<tr>
								<th>매물번호</th>
								<th>제목</th>
								<th>임대인(중개사)</th>
								<th>계약일</th>
								<th>후기작성</th>
							</tr>

							<c:if test="${olist.size()==0}">
							<tr>
								<td colspan="5">거래 내역이 존재하지 않습니다.</td>
							</tr>
							</c:if>
							
							<c:forEach items="${olist}" var="odto">
							<tr onclick="location.href='/Myhome_project/contractor/property-contractor-detail.do?seq=${odto.seqContractorProperty}';">
								<td>${odto.seqContractorProperty}</td>
								<td>${odto.title}</td>
								<td>${odto.name}(${odto.contractorName})</td>
								<td>${odto.contractDate}</td>
								<td>
								<c:if test="${odto.seqContractorReview==0}">
									<button type="button" class="btn btn-default" id="btn-pro">작성하기</button>
								</c:if>
								<c:if test="${odto.seqContractorReview!=0}">
									후기 작성 완료
								</c:if>
								</td>
							</tr>
							</c:forEach>
							
						</table>
						<div style="clear: both;"></div>
					</div>

				</div>
			</div>
		</div>


		<!-- footer -->
		<%@include file="/WEB-INF/views/inc/footer.jsp"%>
	</div>
</body>
</html>