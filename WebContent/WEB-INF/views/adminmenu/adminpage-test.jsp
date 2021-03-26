<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지 -> testpage</title>

<%-- <%@include file="/WEB-INF/views/inc/asset.jsp" %> --%>

<!-- <link rel="stylesheet" href="/Myhome_project/css/main.css"> -->
<link rel="stylesheet" href="/Myhome_project/css/template.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
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

</style>
</head>
<body>
	<div class="wrap">

		<div class="header-containerwrap">
			<!-- header -->
			<%@include file="/WEB-INF/views/adminmenu/header.jsp"%>

			<div class="container">
			<!-- method="POST" .. mypageinfook.do .. mypage-info-ok.jsp.. 수정이 완료되었다.. -->
				<form method="GET" action="/Myhome_project/user/mypage.do">
					<div class="section1">

						<!-- nav -->
						<%@include file="/WEB-INF/views/adminmenu/nav.jsp"%>

					</div>
				</form>
			</div>
		</div>


		<!-- footer -->
		<%@include file="/WEB-INF/views/inc/footer.jsp"%>

	</div>

	<script>
		function check_pw() {
			var password1 = document.getElementById('password1').value;
			var password2 = document.getElementById('password2').value;

			if (document.getElementById('password1').value != ''
					&& document.getElementById('password2').value != '') {
				if (document.getElementById('password1').value == document
						.getElementById('password2').value) {
					document.getElementById('check').innerHTML = '비밀번호 일치'
					document.getElementById('check').style.color = 'blue';
				} else {
					document.getElementById('check').innerHTML = '비밀번호 불일치';
					document.getElementById('check').style.color = 'red';
				}
			}
		}
		
		
		var removeuser = document.getElementById('removeuser');
		
		removeuser.onclick = function () { 
			location.href = "/Myhome_project/user/removeuser.do";
		
		} 
	</script>



</body>
</html>