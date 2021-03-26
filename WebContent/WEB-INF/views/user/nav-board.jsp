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
	.nav1-box1 {
		border: 0px;
	}
	
	.nav1-box1-img {
		margin-right: 3px;
		margin-left: 0px;
	}
</style>
</head>
<body>
	<nav class="nav1">
    	<div id="mypage-title">게시판</div>
           <div class="nav1-box1">
               <div class="nav1-content" id="nav1-content5">
                   <div class="nav1-box1-img glyphicon glyphicon-list"></div>
                   <div class="nav1-box1-content"><a id="bcommunity" href="/Myhome_project/Myhome/user/boardcommunitylist.do" class="nav-list">커뮤니티</a></div>
               </div>
               <div class="nav1-content" id="nav1-content6">
                   <div class="nav1-box1-img glyphicon glyphicon-list"></div>
                   <div class="nav1-box1-content"><a id="bnotice" href="/Myhome_project/Myhome/user/boardnoticelist.do" class="nav-list">공지사항</a></div>
               </div>
               <div class="nav1-content" id="nav1-content7">
                   <div class="nav1-box1-img glyphicon glyphicon-list"></div>
                   <div class="nav1-box1-content"><a id="bpolicy" href="/Myhome_project/Myhome/user/boardpolicylist.do" class="nav-list">부동산정책게시판</a></div>
               </div>
                   <div class="nav1-content" id="nav1-content8">
                   <div class="nav1-box1-img glyphicon glyphicon-list"></div>
                   <div class="nav1-box1-content"><a id="bchecklist" href="/Myhome_project/Myhome/user/boardchecklist.do" class="nav-list">부동산체크리스트</a></div>
               </div>
               <div class="nav1-content" id="nav1-content9">
                   <div class="nav1-box1-img glyphicon glyphicon-list"></div>
                   <div class="nav1-box1-content"><a id="bapplication" href="/Myhome_project/Myhome/user/boardapplicatioinlist.do" class="nav-list">청약게시판</a></div>
               </div>
         </div>
    </nav>
</body>
</html>