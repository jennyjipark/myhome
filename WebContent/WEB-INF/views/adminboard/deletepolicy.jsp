<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%



%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyHome::부동산 정책 게시판 관리</title>

<link rel="stylesheet" href="/Myhome_project/css/template.css">
<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">
<link rel="stylesheet" href="/Myhome_project/css/board.css">

<%@include file="/WEB-INF/views/inc/asset.jsp" %>

<style>

	style>body, html {
		/* width: 100%; */
		height: 100%;
		margin: 0 auto;
		padding: 0;
	}
	
	.container {
		border: 1px solid green;
		width: 1190px;
		margin: 0px auto;
		margin-top: 100px;
		position: relative;
		height: 1200px;
	}
	
	/* ------------------------------------------- */
	
	
	.boardcover{
	/* 	border: 1px solid tomato; */
		float: left;
		width:900px;
		height: auto;
		margin-left: 20px; 
	}
	
	#title {
		font-size: 24px;
		font-family: 'MaplestoryOTFLight';
		border-left: 5px solid #F1AEAE;
		margin: 30px 10px;
		padding : 0px 10px;
	}
	#tbl {
		width:920px;
	}
	
	.list:nth-child(1) { width: 60px; }
	.list:nth-child(2) { width: 100px; }
	.list:nth-child(3) { width: 400px; text-align : left !important;}
	.list:nth-child(4) { width: 150px; }
	.list:nth-child(5) { width: 100px; }
	.list:nth-child(6) { width: 100px; }
	
	#policytitle {
		cursor : pointer;
	}
	#tbl1 th, #tbl1 td {
		font-family: 'NanumBarunGothic';
		text-align: center;
	}
	
	
	
	input, select {
		font-family: 'NanumBarunGothic';
		outline: none;
	}
	
	.pagebar {
		text-align : center;
	}
	
	.pagination > li > .page-a {
		color: #202020;
		text-decoration: none;
	}
	
	.pagination>.active>a, .pagination>li>a:hover{
		background-color: #f1aeae !important;
		border-color : #f1aeae !important;
		color: white !important;
	}
	
	.btn {
	    background-color: #f1aeae;
	    color: aliceblue;
	    display: inline;
	    width: 70px;
	    margin-right: 10px;
	    outline: none !important;
	    
	}  
	
	.search{
		text-align:center;
	   	padding: 10px;
	}
	
	.btns {
		text-align : right;
		
	}
	
	.search #txt {
		width: 200px;
		display: inline;
	}
	
	.boardtr:hover{
		color : #f1aeae;
	}





</style>
</head>
<body>
    <div class="boardwrap">
 
 <!-- header -->
<%@include file="/WEB-INF/views/admin/header.jsp" %>
 
     <div class="container">
     <%@include file="/WEB-INF/views/admin/nav.jsp" %>
        <div class="boardcover">
             
		<div id="title">부동산 정책 게시판 관리</div>
		
<%-- 		<c:if test="${not empty search}">
                <div class="message well well-sm">
                    '${search}'(으)로 ${list.size()}건의 게시물을 검색했습니다.
        </div>
        </c:if> --%>
		
		<table id="tbl1" class="table table-hover table-striped table-condensed">
    
                <tr class="headtr">
                	<th class="list">선택</th>
                    <th class="list">번호</th>
                    <th class="list">제목</th>
                    <th class="list">작성자</th>
                    <th class="list">작성일</th>
                    <th class="list">조회수</th>
                </tr>
                
                <form action="/Myhome_project/admin/board/deletepolicyok.do" method="POST" id="form1">
                <c:forEach items="${listpolicy}" var="dto">
                <input type="hidden" name ="seq" value="${dto.seq}">
                <tr class="boardtr">
                	<td class="list"><input type="checkbox" name="seq" id="seq"></td>
                    <td class="list">${dto.seq}</td>
                    <td class="list" id="policytitle" onclick="location.href='/Myhome_project/admin/board/viewpolicy.do?seq=${dto.seq}';">${dto.title}</td>
                    <td class="list">${dto.id}</td>
                    <td class="list">${dto.writedate}</td>
                    <td class="list">${dto.viewcount}</td>
                    
                </tr>
                </c:forEach>
               
                
            </table>

            
            <div class="boardalert">				
				<div class="alert alert-danger" role="alert">
				  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
				  <span class="sr-only">경고!</span>
				  위의 항목(들)을 삭제하시겠습니까? 삭제하시려면 아래의 '삭제'버튼을 눌러 주세요.
				</div>
			</div>
            
            <div class="btns">
            	<input type="button" class="btn" value="목록" id="edit" onclick="location.href='/Myhome_project/admin/board/listpolicy.do';">
            	<input type="submit" class="btn" value="삭제" id="delete">
           	</div>
           	</form>
           	
	       
            
			

	</div>
	</div>
	</div>
	
	<!-- footer -->
<%@include file="/WEB-INF/views/inc/footer.jsp" %>
 
</body>
</html>