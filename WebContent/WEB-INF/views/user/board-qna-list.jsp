<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%


%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::QnA</title>
<%@include file="/WEB-INF/views/inc/asset.jsp" %>
<link rel="stylesheet" href="/Myhome_project/css/template.css">
<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="/Myhome_project/css/boarduserver.css"> -->


<!-- 부트스트랩 사용가능한 템플릿 -->

<style>

	.container {
		border-color: transparent;
	}
	
	.header-containerwrap{
	    height: auto;
	    min-height: 100%;
	    position: relative;
	}
	
	.boardTitle {
		font-size: 24px;
		/* font-family: 'MaplestoryOTFLight'; */
		font-family: 'NanumBarunGothic', sans-serif;
		font-weight: bold;
		color: #202020;
		border-left : 3px solid #F1AEAE;
		margin: 30px 7px;
		padding-left: 10px;
	}
	
	.table {
		margin: 10px auto;
	}
	
	.table thead tr th {
		text-align: center;
	}
	
	.table td:nth-child(1) {
		text-align: center;
		width: 130px;
	}
	
	.table td:nth-child(2) {
		text-align: left;
/* 		width: 400px; */
		width: auto;
	}
	
	.table td:nth-child(3) {
		text-align: center;
		width: 190px;
	}
	
	.table td:nth-child(4) {
		text-align: center;
		width: 190px;
	}
	
	.table td:nth-child(5) {
		text-align: center;
		width: 130px;
	}
	
	
	.table tr {
		height: 40px;
	}
	
	.table>tbody>tr>td {
		vertical-align: middle;
	}
	
	
	
	#basic-addon2 {
		background-color: #f1aeae;
        color: white;
        outline: none;
	}
	
	#basic-addon1 {
		background-color: #f1aeae;
        color: white;
        outline: none;
        
        position: relative;
		float: left;
		left: 1060px;
		top: 10px;
	}
	
	.search {
		margin: 20px auto;
		width: 430px;
		positioin: relative;
		float: left;
		top: -70px;
		left: 390px;
		
	}
	
	.pagebar {
		margin: 0px auto;
		margin-bottom: 70px;
		float: left;
		text-align: center;
		position : relative;
		top: 20px;
		left: 400px;

	}
	
	.pagination>.active>a, .pagination>li>a:hover{
		background-color: #f1aeae;
		border-color : #f1aeae;
		color: white;
	}

	
	.pagination>li>a {
		color: #202020;
	}
	

	
	#titlename {
		color: #202020;
	}
	

	body, html {
	   height: 100%;
	   margin: 0 auto;
	   padding: 0;
	}
	
	
	#header {
	   background-color: white;
	}
	
	#header:hover {
	   background-color: white;
	}
	
	
	 .tbl th {
	   text-align: center;
	   border-top: 1px solid #d4d4d4;
	}
	
	.tbl tr:nth-child(odd) {
	   background-color: #F9F9F9;
	}
	
	
	.box1 {
		padding-left: 50px;
	   font-size: 16px;
	   font-family: 'NanumBarunGothic';
	}
	
	
	
	#maintitle {
	   border-bottom: 1px solid #ccc;
	   font-size: 24px;
	   font-family: 'MaplestoryOTFLight';
	   padding-right: 50px;
	   position: relative;
	   display: inline;
	   left: 100px;
	   top: 100px;
	   text-align:left;
	}
	
	
</style>


</head>
<body>
 

<!-- <div class="wrap"> -->
   <div class="header-containerwrap">
 
 <!-- header -->
<%@include file="/WEB-INF/views/inc/bootstrap-header.jsp" %>
 
     <div class="container">
     
     <div class="boardTitle">Q&A</div>
            
            <!-- <div class="section1">    -->   
             <form action="" id="form1">         
               <div class="box1">
                  <table class="tbl table" id="tbl1">
                     <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자(닉네임)</th>
                        <th>작성일</th>
                        <th>답변여부</th>
                     </tr>
                     <tr>
                        <td>10</td>
                        <td>비밀번호 바꾸고 싶어요.</td>
                        <td>jihyunnn</td>                        
                        <td>2021-01-31</td>
                        <td>답변중</td>
                     </tr>
                     <tr>
                        <td>9</td>
                        <td>허위매물 신고관련 질문입니다!!!!!</td>
                        <td>pureniya</td>                        
                        <td>2021-01-30</td>
                        <td>답변완료</td>
                     </tr>
                     <tr>
                        <td>8</td>
                        <td>전자계약해야하는데 암호를 몰라요</td>
                        <td>junoh0102</td>                        
                        <td>2021-01-29</td>
                        <td>답변완료</td>
                     </tr>
                     <tr>
                        <td>7</td>
                        <td>매물정보가 부족해요</td>
                        <td>smartjh12</td>                        
                        <td>2021-01-27</td>
                        <td>답변중</td>
                     </tr>
                     <tr>
                        <td>6</td>
                        <td>방을 올리고 싶습니다</td>
                        <td>jinyoung20</td>                        
                        <td>2021-01-22</td>
                        <td>답변완료</td>
                     </tr>
                     <tr>
                        <td>5</td>
                        <td>중개인하고 연락이 안됩니다...</td>
                        <td>dhpower</td>                        
                        <td>2021-01-21</td>
                        <td>답변완료</td>
                     </tr>
                     <tr>
                        <td>4</td>
                        <td>비밀번호 바꾸고 싶어요.</td>
                        <td>james12</td>                        
                        <td>2021-01-20</td>
                        <td>답변중</td>
                     </tr>
                     <tr>
                        <td>3</td>
                        <td>비밀번호 바꾸고 싶어요.</td>
                        <td>dhpower</td>                        
                        <td>2021-01-17</td>
                        <td>답변중</td>
                     </tr>
                     <tr>
                        <td>2</td>
                        <td>비밀번호 바꾸고 싶어요.</td>
                        <td>james12</td>                        
                        <td>2021-01-15</td>
                        <td>답변완료</td>
                     </tr>
                     <tr>
                        <td>1</td>
                        <td>비밀번호 바꾸고 싶어요.</td>
                        <td>naristation</td>                        
                        <td>2021-01-11</td>
                        <td>답변완료</td>
                     </tr>
                  </table>
               </div>
               
            
                              
            <!-- </div> -->
            
         
      		<div class="btns btn-group">
   
		        <!-- 로그인을 해야지만 글쓰기 버튼 출력하기 -->
		        <%-- <c:if test="${not empty id}"> --%>
		        <!-- <button type="button" class="btn btn-default" id="basic-addon1" onclick="location.href='/Myhome_project/Myhome/user/boardcommunitylwrite.do';">글쓰기</button> -->
		        <button type="button" class="btn btn-default" id="basic-addon1" onclick="">글쓰기</button>
		        <%-- </c:if> --%>
		        
		    </div>
		    <div style="clear:both;"></div>
      
      

             <nav class="pagebar">
                <ul class="pagination" id="page_bar">
                    ${pagebar}
                </ul>
            </nav>
            <div style="clear:both;"></div>
            
            
            <form id="searchForm" method="GET" action="/Myhome_project/Myhome/user/boardcommunitylist.do">
	     		<div class="input-group search">
	     
		         	<input type="text" class="form-control" placeholder="제목, 내용, 작성자를 입력해주세요." aria-describedby="basic-addon2" id="search" name="search" required value="${search}">
		         
		         	<span class="input-group-addon" id="basic-addon2" onclick="$('#searchForm').submit();"><span>검색</span></span>
		         <!-- stype="cursor:pointer;" -->
	     		</div>
     		</form>
     		<div style="clear:both;"></div>

		</form>
            
        </div>
    </div>
      <!-- </div> -->
      <!-- footer -->
      <%@include file="/WEB-INF/views/inc/footer.jsp"%>

 
 
</body>
</html>