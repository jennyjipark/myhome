<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

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

	<c:if test="${empty name }">
	    <header id="header">
	    	<div class="header-wrap">
	        <div class="header-ul">
	            <div class="header-img" onclick="location.href='/Myhome_project/Myhome/main.do';"></div>
	                <ul class="header-ul2 header-ul3">
	                    <li class="header-li li-list" onclick="location.href='/Myhome_project/contractor/search-contractor.do';">방찾기</li>             
	                    <li class="header-li li-list" onclick="location.href='/Myhome_project/user/uploadproperty.do';">방올리기</li>
	                    <li class="header-li li-list" onclick="location.href='/Myhome_project/Myhome/user/boardcommunitylist.do';">게시판</li>
	                    <li class="header-li li-list" onclick="location.href='/Myhome_project/user/boardusedlist.do';">중고장터</li>
	                    <li class="header-li li-list" onclick="location.href='/Myhome/user/boardqnalist.do';">고객센터</li>
	
	 					<li id="login" class="li-login li-list" onclick="location.href='/Myhome_project/member/Auth.do';">로그인</li>
	                    <li id="signup" class="li-login li-list" onclick="location.href='/Myhome_project/member/Register.do';">회원가입</li>
	                </ul>
	            </div>
	            </div>
	    </header> 
    </c:if>
	<c:if test="${not empty name }">
	    <header id="header">
	    	<div class="header-wrap">
	        <div class="header-ul">
	            <div class="header-img" onclick="location.href='/Myhome_project/Myhome/main.do';"></div>
	                <ul class="header-ul2 header-ul3">
	                    
	                    <c:if test="${empty nickname }"> <!-- 중개인 -->
	                    <li class="header-li li-list" onclick="location.href='/Myhome_project/contractor/search-lessor.do';">방찾기</li>        	                         
	                    <li class="header-li li-list" onclick="location.href='/Myhome_project/contractor/upload-main.do';">방올리기</li>
	                    </c:if>
	                    
	                    <c:if test="${not empty nickname }"> <!-- 일반회원 -->
	                    <li class="header-li li-list" onclick="location.href='/Myhome_project/contractor/search-contractor.do';">방찾기</li>        	                         
	                    <li class="header-li li-list" onclick="location.href='/Myhome_project/user/uploadproperty.do';">방올리기</li>
	                    </c:if>
	                     
	                    <li class="header-li li-list" onclick="location.href='/Myhome_project/Myhome/user/boardcommunitylist.do';">게시판</li>
	                    <li class="header-li li-list" onclick="location.href='/Myhome_project/user/boardusedlist.do';">중고장터</li>
	                    
	                    <c:if test="${empty nickname }"> <!-- 중개인 -->
	                    	<li class="header-li li-list" onclick="location.href='/Myhome_project/contractor/mypage.do';">마이페이지</li>
	                    </c:if>
	                    
	                    <c:if test="${not empty nickname }"> <!-- 일반회원 -->
	                    	<li class="header-li li-list" onclick="location.href='/Myhome_project/user/mypage.do';">마이페이지</li>
	                    </c:if>
	                    <li class="header-li li-list" onclick="location.href='/Myhome/user/boardqnalist.do';">고객센터</li>
	
	 					<li id="login" class="li-login li-list">${nickname }</li>
	                    <li id="signup" class="li-login li-list" onclick="location.href='/Myhome_project/member/logout.do';">로그아웃</li>
	                </ul>
	            </div>
	            </div>
	    </header> 
    </c:if>
</body>
</html>