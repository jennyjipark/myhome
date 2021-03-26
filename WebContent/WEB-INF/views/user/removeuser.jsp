<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 > 회원 정보 수정</title>

<%-- <%@include file="/WEB-INF/views/inc/asset.jsp" %> --%>

<!-- <link rel="stylesheet" href="/Myhome_project/css/main.css"> -->
<link rel="stylesheet" href="/Myhome_project/css/template.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
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
	font-size: 40px;
	margin-bottom: 30px;
	text-align: center;
	width: 400px;
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
				<div class="section1">

					<!-- nav -->
					<%@include file="/WEB-INF/views/user/nav.jsp"%>

					<div class="section2">
						<div id="title">정말 탈퇴하시겠습니까?</div>

						<div class="section3">
							<button type="button" class="btn btn-default" id="back">
								<span class="glyphicon glyphicon-check"></span> 돌아가기
							</button>
							<button type="button" class="btn btn-danger" id="removeuser2">
								<span class="glyphicon glyphicon-remove"></span> 회원탈퇴
							</button>
						</div>
					</div>
					<div style="clear: both;"></div>
				</div>
			</div>
		</div>


		<!-- footer -->
		<%@include file="/WEB-INF/views/inc/footer.jsp"%>

	</div>

	<script>
		
		var back = document.getElementById('back');
		var removeuser2 = document.getElementById('removeuser2');
		
		back.onclick = function() {
			history.back();
		}
		removeuser2.onclick = function () { 
			location.href = "/Myhome_project/user/removeuserok.do";
		
		} 
	</script>



</body>
</html>