<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%


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

	<c:if test="${empty nickname}">
    <header id="header">
    	<div class="header-wrap">
        <div class="header-ul">
            <div class="header-img"></div>
                <ul class="header-ul2 header-ul3">
                    <li class="header-li li-list">방찾기</li>
                    <li class="header-li li-list">방올리기</li>
                    <li class="header-li li-list">게시판</li>
                    <li class="header-li li-list">중고장터</li>
                    <li class="header-li li-list">마이페이지</li>
                    <li class="header-li li-list">고객센터</li>

                    <li id="login" class="li-login li-list"><a class="deco-none" href="/Myhome_project/member/Auth.do">로그인</a></li>
                    <li id="signup" class="li-login li-list"><a class="deco-none" href="/Myhome_project/member/Register.do">회원가입</a></li>
                </ul>
            </div>
            </div>
    </header> 
    </c:if>
    <c:if test="${not empty nickname}">
    <header id="header">
    	<div class="header-wrap">
        <div class="header-ul">
            <div class="header-img"></div>
                <ul class="header-ul2" id="header-ul-id">
                    <li class="header-li li-list">방찾기</li>
                    <li class="header-li li-list">방올리기</li>
                    <li class="header-li li-list">커뮤니티</li>
                    <li class="header-li li-list" onclick="location.href='/Myhome_project/user/boardusedlist.do'">중고장터</li>
                    <li class="header-li li-list" onclick="location.href='/Myhome_project/user/mypage.do'">마이페이지</li>
                    <li class="header-li li-list">고객센터</li>

                    <li id="login" class="li-login li-list">${name}님 환영합니다</li>
                    <li id="signup" class="li-login li-list"><a href="/Myhome_project/member/logout.do">로그아웃</a></li>
                </ul>
            </div>
            </div>
    </header> 
    </c:if>
    
    <script>
    	console.log(${seqAllUser});
    </script>

</body>
</html>