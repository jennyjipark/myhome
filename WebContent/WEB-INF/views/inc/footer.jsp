<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Myhome_project/css/footer.css">
<%@include file="/WEB-INF/views/inc/asset.jsp" %>
<!-- <link rel="stylesheet" href="/Myhome_project/css/bootstrap.css"> -->

<style>

	#footer-content2 > a {
		color: white;
		cursor: pointer;
	}
	
	
</style>

</head>
<body>
	<div id="footer">
        <!-- <div id="footer-img"></div> -->
        <div id="footer-content">
            <div id="footer-content1">&copy; 2021</div>
            <div id="footer-content2">NOH PUREUN, PARK JIHYUN, LEE DAEHONG, LEE JUNOH, YUN JIHYUN, JANG JINYOUNG</div>
            <div id="footer-content2">WELCOME TO MYHOME</div>
        </div>
    </div>


    <a id="chat" target="_blank" onclick="chat();" ></a>

<script>

	
	//채팅팝업
	function chat(){
	    var url = "/Myhome_project/member/chat.do";
	    var name = "popup test";
	    var option = "width = 450, height = 630, top = 200, left = 400, location = no"
	    window.open(url, name, option);
	}
	

</script>

</body>
</html>