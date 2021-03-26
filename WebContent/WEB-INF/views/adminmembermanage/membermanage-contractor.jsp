<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyHome::회원정보관리</title>
<%@include file="/WEB-INF/views/inc/asset.jsp"%>

<link rel="stylesheet" href="/Myhome_project/css/template.css">
<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">
<link rel="stylesheet" href="/Myhome_project/css/board.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">


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
	
	/* 테이블 */
	#tbl1 {
		width:940px;
	}



	#tbl1 th, #tbl1 td {
		font-family: 'NanumBarunGothic';
		text-align: center;
		font-size: 13px;
	}

	.clist:nth-child(1) { width: 40px; }
	.clist:nth-child(2) { width: 70px; }
	.clist:nth-child(3) { width: 60px; }
	.clist:nth-child(4) { width: 50px; }
	.clist:nth-child(5) { width: 160px; }
	.clist:nth-child(6) { width: 110px; }
	.clist:nth-child(7) { width: 120px; }
	.clist:nth-child(8) { width: 210px; text-align :left !important}
	.clist:nth-child(9) { width: 120px; }

	.boardtr:hover {
		color : #f1aeae;
	}

	input, select {
		font-family: 'NanumBarunGothic';
		outline: none;
	}
	
	/* 일반회원, 중개인회원 구분 */
	#member {
		margin: 10px;
		
	}

	#member input{
		border: none;
		background-color: transparent;
	
	}
	
	#member #contractor{
		font-size: 1.3em;
		font-weight: bold;
		color : #F1AEAE;
	}
	
	#member #user:hover{
		color: #F1AEAE;
		text-decoration : none;
	}



	
	ul {
		padding: 0;
		margin: 0px 5px;
		margin-bottom: 15px;
		list-style: none;
	}
	
	li {
		float: left;
	}
	
	/* 페이지바 */
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

    /* 버튼, 검색 */
    .btn {
    	cursor: pointer;
    	margin-bottom: 20px;
    	margin-right : 10px;
    	padding : 6px 12px;
    	background-color: #F1AEAE;
    	border-radius: 4px;
    	outline: none !important;
    	border : none;
    	color: aliceblue;
	
    }

    .delete {
    	text-align : right;
    }

	.search {
		text-align:center;
	   	padding: 10px;
	}
	
	.search #search {
		width: 200px;
		display: inline;
	}

	#menu1{
		color : #f1aeae;
	}
	
	#name, #id{
		cursor : pointer;
	}
	





</style>
</head>
<body>
	<div class="boardwrap">

		<!-- header -->
		<%@include file="/WEB-INF/views/admin/header.jsp"%>

		<div class="container">
		<%@include file="/WEB-INF/views/admin/nav.jsp" %>
        <div class="boardcover">

			<div id="title">회원 정보 관리</div>
			
			<!-- 검색결과 -->
			<c:if test="${not empty search}">
	        <div class="message well well-sm">
	            '${search}'(으)로 ${list.size()}건의 게시물을 검색했습니다.
	        </div>
	        </c:if>

			<div id="member">
				<input type="button" id="user" value="일반회원" onclick="location.href='/Myhome_project/admin/membermanage/membermanage-user.do';">
				<span class="bar"> ┃ </span> 
				<input type="button" id="contractor" value="중개인">
			</div>

			<table id="tbl1" class="table table-hover table-striped table-condensed">
				<tr>
					<th class="clist">선택</th>
					<th class="clist">중개인번호</th>
					<th class="clist">아이디</th>
					<th class="clist">이름</th>
					<th class="clist">공인중개소명</th>
					<th class="clist">사업자등록번호</th>
					<th class="clist">전화번호</th>
					<th class="clist">주소</th>
					<th class="clist">신고횟수(신고사항)</th>
				</tr>
				
				<c:forEach items="${list}" var="dto">
				<tr class="boardtr">
					<td class="clist"><input type="checkbox" name="seq" id="seq" value="${dto.seq}"></td>
					<td class="clist">${dto.seq}</td>
					<td class="clist" id="id" onclick="location.href='/Myhome_project/admin/membermanage/viewcontractorinfo.do?seq=${dto.seq}';">${dto.id}</td>
					<td class="clist" id="name" onclick="location.href='/Myhome_project/admin/membermanage/viewcontractorinfo.do?seq=${dto.seq}';">${dto.name}</td>
					<td class="clist">${dto.contractorname}</td>
					<td class="clist">${dto.companynumber}</td>
					<td class="clist">${dto.tel1}-${dto.tel2}-${dto.tel3}</td>
					<td class="clist">${dto.address}</td>
					<td class="clist">${dto.reportcount}</td>
				</tr>	
				</c:forEach>
				
			</table>


			<!-- 삭제버튼 -->
			<div class="delete"> 
			<input type="button" id="delete" class="btn" value="선택한 중개인 삭제" onclick="location.href='/jsp/project/communitywrite.jsp';">
			</div>
			
	       	<!-- 페이징 -->
	       	<nav class="pagebar">
                <ul class="pagination">
                    ${pagebar}
                </ul>
            </nav>
			
			<!-- 검색 -->
			<form id="searchForm" method="GET" action="/Myhome_project/admin/membermanage/membermanage-contractor.do">
				<div class="search">
					<input type="text" class="form-control" placeholder="중개인번호 / 아이디 / 이름" id="search" name="search" required value="${search}">
					<input type="submit" class="btn" value="검색" id="serch" onclick="$('#searchForm').submit();">
				</div>
			</form>
            <div style="clear:both;"></div>





		</div>

	</div>

	</div>

	</div>
	<!-- footer -->
<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	


</body>
</html>