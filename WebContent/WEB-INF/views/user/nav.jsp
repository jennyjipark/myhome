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
</style>
</head>
<body>
	<nav class="nav1">
    	<div id="mypage-title">마이페이지</div>
           <div class="nav1-box1">
               <div class="nav1-content" id="nav1-content5">
                   <div class="nav1-box1-img glyphicon glyphicon-user"></div>
                   <div class="nav1-box1-content"><a id="myinfo" href="/Myhome_project/user/mypageinfo.do" class="nav-list">회원정보수정</a></div>
               </div>
               <div class="nav1-content" id="nav1-content6">
                   <div class="nav1-box1-img glyphicon glyphicon-bookmark"></div>
                   <div class="nav1-box1-content"><a id="mylike" href="/Myhome_project/user/mypagelike.do" class="nav-list">찜목록관리</a></div>
               </div>
               <div class="nav1-content" id="nav1-content7">
                   <div class="nav1-box1-img glyphicon glyphicon-pencil"></div>
                   <div class="nav1-box1-content"><a id="mywrite" href="/Myhome_project/user/mypagemywrite.do" class="nav-list">내가쓴글보기</a></div>
               </div>
                   <div class="nav1-content" id="nav1-content8">
                   <div class="nav1-box1-img glyphicon glyphicon-align-justify"></div>
                   <div class="nav1-box1-content"><a id="myorderlist" href="/Myhome_project/user/mypageorderlist.do" class="nav-list">매물거래내역</a></div>
               </div>
               <div class="nav1-content" id="nav1-content9">
                   <div class="nav1-box1-img glyphicon glyphicon-resize-small"></div>
                   <div class="nav1-box1-content"><a id="mymatching" href="/Myhome_project/user/mypagematching.do" class="nav-list">매칭매물관리</a></div>
               </div>
               <div class="nav1-content" id="nav1-content10">
                   <div class="nav1-box1-img glyphicon glyphicon-list-alt"></div>
                   <div class="nav1-box1-content"><a id="mycontract" href="/Myhome_project/user/mypagecontract.do" class="nav-list">전자계약관리</a></div>
               </div>
                   <div class="nav1-content" id="nav1-content11">
                   <div class="nav1-box1-img glyphicon glyphicon-calendar"></div>
                   <div class="nav1-box1-content"><a id="myreservation" href="/Myhome_project/user/mypagereservation.do" class="nav-list">이사청소예약</a></div>
               </div>
         </div>
    </nav>
</body>
</html>