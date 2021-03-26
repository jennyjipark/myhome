<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyHome::이사업체관리</title>
<%@include file="/WEB-INF/views/inc/asset.jsp" %>
<link rel="stylesheet" href="/Myhome_project/css/template.css">
<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">
<link rel="stylesheet" href="/Myhome_project/css/board.css">
<!-- <link rel="stylesheet" href="/Myhome_project/css/moveclean-list.css"> -->

<style>
	.header {
		background-color : white;
	}
	
	.container {
        width: 1190px;
        margin: 0 auto;
        letter-spacing: -.2px;
        min-height:100%;
		padding-bottom:100px;
		/* border: 1px solid green; */
		margin-top: 100px;
		z-index: -1;
		border-right: 1px solid #DBDCE0;
    	border-left: 1px solid #DBDCE0;
    }
    
    .boardcover{
    	/* border: 1px solid tomato; */
    	float: left;
    	width:900px;
    	height: auto;
    	margin-left: 30px; 
    }
    
	#title {
		font-size: 24px;
		font-family: 'MaplestoryOTFLight';
		border-left: 5px solid #F1AEAE;
		margin: 30px 10px;
		padding : 0px 10px;
	}
	
	.list {
    	/* text-align : center; */
    	/* float: left; */
    	margin : 10px auto;
    	width: 80%;
    	height : 200px;
    	/* border : 5px solid black; */
    	padding : 15px 0px;
    }
    
    .imagelogo{
    	border : 1px solid black;
    	width: 280px;
        height: 180px;
    	float: left;
    	position: relative;
    	/* background-image: url('../image/move_clean/1. 쌍용청소.jpg'); */
        background-size: contain;
        background-repeat: no-repeat;
        background-position: 0% -20px; 
        background-size: cover;
        margin: 0px 20px;
    }
    
    .listbox{
    	float: left;
    	width: 300px;
    	height: 180px;
    	margin-left : 30px;
    }

    
/*     .check, .imagelogo {
    	float: left;
    } */
    
    .btns {
    	position : relative;
    	cursor: pointer;
    	margin-left: 50px;
    	margin-bottom: 30px;
    }
    
    .btn {
	    background-color: #f1aeae;
	    color: aliceblue;
	    display: inline;
	    width: 70px;
	    margin-right: 10px;
	    outline: none !important;
	    
	}  

    
    .check {
    	size :2em;
    }
    
	
	.stars {
    	background-color: rgba( 255, 255, 255, 0.5 );
    }
	
    
    .glyphicon, .rating {
  
    	float: left;
    	font-size : 16px;
    	padding-left : 10px;
    	padding-top: 10px;
    	margin : 0px;
    	/* position : absolute; */
    	top : 10px;
    	left: 10px;
    }
    

    
    .glyphicon {
    	color : #F1AEAE;
    	float: left;
    }   
    
  
    
    .name{
    	font-size: 20px;
    	margin-bottom: 5px;
    	border-bottom: 1px solid #eaecef;
    }
    
    .content{
    	font-size: 16px;
    }
    
    .address, .tel, .price, .businessnum, .introduce{
    	margin : 3px 0px;
    }
    
	.pagebar {
		text-align : center;
	}
	
	.pagination > li > .page-a {
		color: #202020;
	}
	
	.pagination>.active>a, .pagination>li>a:hover{
		background-color: #f1aeae !important;
		border-color : #f1aeae !important;
		
    }
    
    .search {
		text-align:center;
	   	padding: 10px;
	}
	
	.btns {
		text-align : right;
		
	}
	
	.search #search {
		width: 150px;
		display: inline;
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
        
        
		<div id="title">이사업체관리</div>
			
			<c:if test="${not empty search}">
	                <div class="message well well-sm">
	                    '${search}'(으)로 ${list.size()}건의 게시물을 검색했습니다.
	                </div>
            </c:if>
		
			<c:forEach items="${list}" var="dto">
			<div class="list">
				<input type="checkbox" class="check" style="float:left; zoom:1.5;">
				<div class="imagelogo" style="background-image : url('${dto.image}')";"> 
					<%-- <img src="${dto.image}" class="imagelogo"> --%>				
					<div class="glyphicon glyphicon-star"></div>
					<div class="rating">${dto.rating} / 5.0</div>					
				</div>
				<div class="listbox">
					<div class="name" style="font-weight:bold">${dto.name}</div>
					<div class="content">
						<div class="tel">${dto.tel}</div>
						<div class="address">${dto.address}</div>
						<div class="businessnum">${dto.businessnum}</div>
						<div class="price">${dto.price}</div>
						<div class="introduce">${dto.introduce}</div>
					</div>
				</div>	
			</div>
			</c:forEach>
			
			
			<div class="btns">
            	<input type="button" class="btn" value="등록" id="add" onclick="location.href='/Myhome_project/admin/moveclean/addmove.do';">          
            	<input type="button" class="btn" value="삭제" id="delete">
            </div>
            
            <!-- 페이징 -->
	       	<nav class="pagebar">
                <ul class="pagination">
                    ${pagebar}
                </ul>
            </nav>
	       	
	       	<!-- 검색 -->
            <form id="searchForm" method="GET" action="/Myhome_project/admin/moveclean/listmove.do">         
           	<div class="search">
            	<input type="text" class="form-control" placeholder="이사업체명" id="search" name="search" required value="${search}">
            	<input type="button" class="btn" value="검색"  onclick="$('#searchForm').submit();">
           	</div>
			</form>
            <div style="clear:both;"></div>

		
	</div>
	</div>
	</div>
	
	<!-- footer -->
<%@include file="/WEB-INF/views/inc/footer.jsp" %>
 
</body>
</html>

