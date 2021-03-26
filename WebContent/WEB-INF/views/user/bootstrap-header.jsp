<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	// 부트스트랩 사용하는 템플릿의 경우 헤더.jsp를 이 파일로 연결해주세용!

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/Myhome_project/css/bootstrap-header.css">

<%@include file="/WEB-INF/views/inc/asset.jsp" %>

<style>

</style>
</head>
<body>
    <header id="header">
    	<div class="header-wrap">
        <div class="header-ul">
            <div class="header-img"></div>
                <ul class="header-ul2">
                    <li class="header-li li-list">방찾기</li>
                    <li class="header-li li-list">방올리기</li>
                    <li class="header-li li-list">커뮤니티</li>
                    <li class="header-li li-list" onclick="location.href='/Myhome_project/user/boardusedlist.do';">중고장터</li>
                    <li class="header-li li-list">마이페이지</li>
                    <li class="header-li li-list">고객센터</li>

                    <li id="logout" class="li-login li-list">로그아웃</li>
                </ul>
            </div>
            </div>
    </header> 
</body>
</html>