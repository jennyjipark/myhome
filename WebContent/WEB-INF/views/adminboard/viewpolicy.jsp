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
#tbl {
	width:920px;
}

#tbl1 td {
	font-family: 'NanumBarunGothic';
	font-size : 16px;
}



#tbl .id, #tbl .writedate, #tbl .viewcount  {
	float : right;
	margin : 5px 10px;
}

#tbl .titletr {
	font-weight : bold;
}

#tbl .seq, #tbl .title{
	float: left;
	margin : 5px 10px;
}

#tbl .download span, #tbl .download a {
	margin : 5px 5px;
}

#content { 
	height: 500px;
	padding: 25px 25px;
}



input, select {
	font-family: 'JSDongkang-Regular';
	outline: none;
}

button {
	outline:none;
}



.btn {
	width: 70px;
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

.btns {
	text-align: right;
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
		
		<table id="tbl" class="table table-striped table-condensed">
    
                <tr class="titletr">
                	<td>
	                	<span class="seq">${dto.seq}</span>
	                    <span class="title">${dto.title}</span>
	                    <span class="viewcount">${dto.viewcount}</span>
	                    <span class="writedate">${dto.writedate}</span>
	                    <span class="id">${dto.id}</span>
                    </td>
                 </tr>
                 <tr>
                 	<td class="content" id="content">
                 		${dto.content}
                 	</td>
                 
                 </tr>
                 <tr>
                 	<td class="download">
                 		<span class="glyphicon glyphicon-floppy-disk">파일이름</span>
                 		<a></a>
                 		[download : 3회]
                 	</td>
                 </tr>
          	
            </table>
            
            <div class="btns">
                    <button type="button" class="btn" onclick="location.href='/Myhome_project/admin/board/listpolicy.do';">
                        목록
                    </button>
                    <button type="button" class="btn" onclick="location.href='/Myhome_project/admin/board/editpolicy.do?seq=${dto.seq}';">
                        수정
                    </button>
                    <button type="button" class="btn" onclick="location.href='/Myhome_project/admin/board/deletepolicy.do?seq=${dto.seq}'">
                        삭제
                    </button>
              </div>
            
			

	</div>
	</div>
	</div>
	
	<!-- footer -->
<%@include file="/WEB-INF/views/inc/footer.jsp" %>
 
</body>
</html>