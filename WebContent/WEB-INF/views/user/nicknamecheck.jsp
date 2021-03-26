<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyHome::닉네임중복검사</title>

<%-- <%@include file="/WEB-INF/views/inc/asset.jsp" %> --%>

<!-- <link rel="stylesheet" href="/Myhome_project/css/main.css"> -->
<link rel="stylesheet" href="/Myhome_project/css/template.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<%@include file="/WEB-INF/views/inc/asset.jsp"%>

<style>
#container {
	margin: 30px;
	width: 500px;
	height: 300px;
}

#box1 {
	
	margin: 30px 0px;
}
#check {
	width: 100px;
}

</style>
</head>
<body>
	
	<input type="hidden" id="hdn" value="${result}">
	
	<script>
		window.onload = function () {
			if ($("#hdn").val()==0){
				opener.document.getElementById('desc').style.display = 'block';
				opener.document.getElementById('desc').style.color = 'blue';
				opener.document.getElementById('desc').innerText = '사용 가능한 닉네임 입니다.';
				window.close();
			} else {
				opener.document.getElementById('desc').style.display = 'block';
				opener.document.getElementById('desc').style.color = 'red';
				opener.document.getElementById('desc').innerText = '중복된 닉네임 입니다.';
				window.close();
			}
		};
		
	</script>
	
</body>

</html>