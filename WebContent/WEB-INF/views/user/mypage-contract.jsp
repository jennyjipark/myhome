<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%


%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::전자계약관리</title>

<!-- <link rel="stylesheet" href="/Myhome_project/css/main.css"> -->
<link rel="stylesheet" href="/Myhome_project/css/template.css">
<%@include file="/WEB-INF/views/inc/asset.jsp" %>

<style>
#header {
	background-color: white;
}

body, html {
	/* width: 100%; */
	height: 100%;
	margin: 0 auto;
	padding: 0;
}

.container {
	border: 0px;
	border-right: 1px solid #DBDCE0;
    border-left: 1px solid #DBDCE0;
	width: 1190px;
	margin: 0px auto;
	margin-top: 100px;
	position: relative;
	height: 1200px;
}


#section1 {
	/* border: 1px solid black; */
	float:left;
	width: 950px;
	font-family: 'NanumBarunGothic';
}
#section2 {
	/* border: 1px solid red; */
	text-align: center;
	font-size: 16px;
}
#explain {
	margin-top: 100px;
	margin-bottom: 20px;
	margin-right: 150px;
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
}
.tbl {
	/* border: 1px solid blue; */
	width: 850px;
	margin-left: 76px;
	
}

#tbl1 th {
	border-top: 1px solid #d4d4d4;
	text-align: center;
}

#tbl1 tr {
	border-bottom: 1px solid #d4d4d4;
	height: 50px;
}


#tbl1 tr:nth-child(odd) {
	background-color: #F9F9F9;
}

#tbl1 tr:hover {
	cursor: pointer;
	background-color: #ffe1e1;
	font-weight: bold;
	text-decoration:underline;
}
#tbl1 td:nth-child(5) {
	width: 352px;
}
.box {
	width: 250px;
	display: none;
}

</style>
</head>
<body>
<div class="wrap">

 <!-- header -->
		<%@include file="/WEB-INF/views/inc/bootstrap-header.jsp"%>
 
    <div class="container">
    
    	<!-- nav -->
		 <%@include file="/WEB-INF/views/user/nav.jsp" %>
		 
		 <div id="section1">
		 	<div id="maintitle">전자 계약 관리</div>
		 	<div id="explain" style="text-align: right; font-size: 16px; color:#aaa">
		 		<span class="glyphicon glyphicon-triangle-bottom"></span> 모든 계약을 볼 수 있어요.
		 	</div>
		 	
		 	<div id="section2">
		 		
		 		<table class="tbl" id="tbl1">
					<tr class="tblheader">
						<th>계약서번호</th>
						<th>임대인</th>
						<th>임차인</th>
						<th>중개인</th>
						<th>계약상태</th>
					</tr>
					<c:if test="${clist.size()==0}">
						<tr><td colspan="5">계약 목록이 존재하지 않습니다.</td></tr>
					</c:if>
					<c:forEach items="${clist}" var="cdto">
		 			<tr class="contract" onclick="location.href='/Myhome_project/user/mypagecontractdetail.do?seqContract=${cdto.seqContract}'">
		 				<td>${cdto.seqContract}</td>
		 				<td>${cdto.sName}</td>
		 				<td>${cdto.bName}</td>
		 				<td>${cdto.contractorName}</td>
		 				<td>
		 				${cdto.contractState}
		 				<!-- 후기인데 -->

		 				<!--
		 				<c:if test="${cdto.contractState=='완료'}">
		 				<input type="button" class="btn btn-default writeReview" value="중개사 후기 작성">
		 				<input type="button" class="btn btn-default writeReview" value="매물 후기 작성">
		 				</c:if>

		 				</td>
		 				-->
		 			</tr>
		 			</c:forEach>
		 			
		 		</table>
		 		
		 	
		 	
		 	</div>
		 	
		
		 </div>
		 
		 
		 
		 
		 
		 
		 
		 
    </div>
    
     <!-- footer -->
<%@include file="/WEB-INF/views/inc/footer.jsp" %>

</div>    

	<script>
	
	
	</script>
	


</body>
</html>