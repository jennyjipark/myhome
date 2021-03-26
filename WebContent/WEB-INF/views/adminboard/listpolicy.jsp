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
		/* border: 1px solid green; */
		width: 1190px;
		margin: 0px auto;
		margin-top: 100px;
		position: relative;
		height: 1200px;
		border-right: 1px solid #DBDCE0;
    	border-left: 1px solid #DBDCE0;
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
	
	.search #search {
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
		
		<c:if test="${not empty search}">
	        <div class="message well well-sm">
	            '${search}'(으)로 ${listpolicy.size()}건의 게시물을 검색했습니다.
        </div>
        </c:if>
        
		<form method="POST" action="/Myhome_project/admin/board/deletepolicy.do">
		<table id="tbl1" class="table table-hover table-striped table-condensed">
    
                <tr class="headtr">
                	<th class="list">선택</th>
                    <th class="list">번호</th>
                    <th class="list">제목</th>
                    <th class="list">작성자</th>
                    <th class="list">작성일</th>
                    <th class="list">조회수</th>
                </tr>
                
               
                <c:forEach items="${listpolicy}" var="dto">
                <tr class="boardtr">
                	<td class="list"><input type="checkbox" name="seq" id="seq" value="${dto.seq}"></td>
                    <td class="list">${dto.seq}</td>
                    <td class="list" id="policytitle" onclick="location.href='/Myhome_project/admin/board/viewpolicy.do?seq=${dto.seq}';">${dto.title}</td>
                    <td class="list">${dto.id}</td>
                    <td class="list">${dto.writedate}</td>
                    <td class="list">${dto.viewcount}</td>
                    
                </tr>
                </c:forEach>
               
                
            </table>
            
            <div class="btns">
            	<input type="button" class="btn" value="등록" id="add" onclick="location.href='/Myhome_project/admin/board/addpolicy.do';">
            	<input type="button" class="btn" value="삭제" id="delete">
           	</div>
           	</form>
           	
	       	<!-- 페이징 -->
	       	<nav class="pagebar">
                <ul class="pagination">
                    ${pagebar}
                </ul>
            </nav>
           	
           	<!-- 검색 -->
           	<form id="searchForm" method="GET" action="/Myhome_project/admin/board/listpolicy.do">
	           	<div class="search">
	            	<input type="text" class="form-control" placeholder="제목/내용" id="search" name="search" required value="${search}">
	            	<input type="button" class="btn" value="검색" id="serch" onclick="$('#searchForm').submit();">
	           	</div>
            </form>
            <div style="clear:both;"></div>
			

	</div>
	</div>
	</div>
	
	<!-- footer -->
<%@include file="/WEB-INF/views/inc/footer.jsp" %>
 
 	<script>
 		var cbarr = [];
 		$("#delete").click(function(){
 			$("input[type='checkbox'][name='seq']:checked").each(funtion(){
 				cbarr.push($(this).val());
 			})
 			this.form.submit();
 		});
 	
 	</script>
 
</body>
</html>