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
                   <div class="nav1-box1-img glyphicon glyphicon-upload"></div>
                        <div class="nav1-box1-content"><a id="upload" class="nav-list" onclick="location.href='/Myhome_project/contractor/mypage-myproperty.do';">올린매물관리</a></div>
               </div>
               <div class="nav1-content" id="nav1-content2">
                   <div class="nav1-box1-img glyphicon glyphicon-resize-small"></div>
                   <div class="nav1-box1-content"><a id="mymatching" class="nav-list" onclick="location.href='/Myhome_project/contractor/mypage-matching1.do';">매칭매물관리</a></div>
               </div>
               <div class="nav1-content" id="nav1-content3">
                   <div class="nav1-box1-img glyphicon glyphicon-pencil"></div>
                   <div class="nav1-box1-content"><a id="mycontract" class="nav-list" onclick="location.href='/Myhome_project/contractor/mypage-contract.do';">전자계약관리</a></div>
               </div>
                   <div class="nav1-content" id="nav1-content4">
                   <div class="nav1-box1-img glyphicon glyphicon-user"></div>
                   <div class="nav1-box1-content"><a id="myinfo" class="nav-list" onclick="location.href='/Myhome_project/contractor/mypage-info.do';">회원정보관리</a></div>
               </div>
         </div>
    </nav>
    
    
    <script>
    	
    </script>
</body>
</html>