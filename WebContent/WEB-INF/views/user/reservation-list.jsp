<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%


%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyHome::내예약목록</title>
<%@include file="/WEB-INF/views/inc/asset.jsp" %>
<link rel="stylesheet" href="/Myhome_project/css/template.css">
<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">
<!-- <link rel="stylesheet" href="/Myhome_project/css/boarduserver.css"> -->


<!-- 부트스트랩 사용가능한 템플릿 -->

<style>
	
	.boardwrap{
	    height: auto;
	    min-height: 100%;
	    font-size: 16px;
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
#tbl1{
	width: 860px;
	text-align: center;
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

tr td:nth-last-child(1) {
	color: #a5a5a5
}

#tbl1 tr:hover {
	cursor: pointer;
	background-color: #ffe1e1;
	font-weight: bold;
}

#explain {
	color: #aaa;
	text-align: right;
	margin-bottom: 24px;
}
.container {
	border: 0px;
	border-right: 1px solid #DBDCE0;
    border-left: 1px solid #DBDCE0;
}

</style>


</head>
<body>
 
<div class="boardwrap">
 
 <!-- header -->
		<%@include file="/WEB-INF/views/inc/bootstrap-header.jsp"%>
 
     <div class="container">
		<!-- nav -->
		<%@include file="/WEB-INF/views/user/nav.jsp"%>

		<div id="section1">

			<div id="title">내 예약 목록</div>
			<div class="box" id="box1">

				<div id="explain">작성하기 버튼을 누르면 후기작성 페이지로 이동합니다.</div>

				<table class="tbl" id="tbl1">
					<tr>
						<th>예약번호</th>
						<th>업체</th>
						<th>예약일</th>
						<th>가격</th>
						<th>후기작성</th>
					</tr>
					
					<c:if test="${empty clist&& empty mlist}">
					<tr>
						<td colspan="6">예약목록이 존재하지 않습니다.</td>
					</tr>
					</c:if>
					<!-- 청소업체 리스트 출력 -->
					<c:forEach items="${clist}" var="dto">
					<!-- <form></form> -->
					<tr>
						<td>${dto.seqCleanReservation}</td>
						<td>${dto.name}</td>
						<td>${dto.reservationDate}</td>
						<td>${dto.price}원</td>
						<td>
							<c:if test="${empty dto.seqCleanReview}">
							<button type="button" class="btn btn-default" onclick="">작성하기</button>
							</c:if>
							<c:if test="${not empty dto.seqCleanReview}">
							후기작성됨
							</c:if>
						</td>
					</tr>
					</c:forEach>
					
					<!-- 이사업체 리스트 출력 -->
					<c:forEach items="${mlist}" var="dto">
					<tr>
						
						<td>${dto.seqMoveReservation}</td>
						<td>${dto.name}</td>
						<td>${dto.reservationDate}</td>
						<td>${dto.price}원</td>
						<td>
							<c:if test="${empty dto.seqMoveReview}">
							<button type="button" class="btn btn-default" onclick="">작성하기</button>
							</c:if>
							<c:if test="${not empty dto.seqMoveReview}">
							후기작성됨
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
<%@include file="/WEB-INF/views/inc/footer.jsp" %>
 
</body>
</html>