<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="/Myhome_project/css/nav.css">
<%@include file="/WEB-INF/views/inc/asset.jsp" %>

<style>

</style>
</head>
<body>
	<nav class="nav1">
    	<div id="mypage-title">마이페이지</div>
           <div class="nav1-box1">
               <div class="nav1-content" id="nav1-content1">
                   <div class="nav1-box1-img glyphicon glyphicon-user"></div>
                        <div class="nav1-box1-content"><a id="upload" href="mypage-myproperty.html" class="nav-list">올린매물관리</a></div>
               </div>
               <div class="nav1-content" id="nav1-content2">
                   <div class="nav1-box1-img glyphicon glyphicon-user"></div>
                   <div class="nav1-box1-content"><a id="mymatching" class="nav-list">매칭매물관리</a></div>
               </div>
               <div class="nav1-content" id="nav1-content3">
                   <div class="nav1-box1-img glyphicon glyphicon-user"></div>
                   <div class="nav1-box1-content"><a id="mycontract" class="nav-list">전자계약관리</a></div>
               </div>
                   <div class="nav1-content" id="nav1-content4">
                   <div class="nav1-box1-img glyphicon glyphicon-user"></div>
                   <div class="nav1-box1-content"><a id="myinfo" class="nav-list">회원정보관리</a></div>
               </div>
         </div>
    </nav>
</body>
</html>