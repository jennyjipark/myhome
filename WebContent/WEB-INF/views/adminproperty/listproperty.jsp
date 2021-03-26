<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyHome::매물관리</title>
<%@include file="/WEB-INF/views/inc/asset.jsp" %>
<!-- <link rel="stylesheet" href="/Myhome_project/css/template.css"> -->
<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">
<!-- <link rel="stylesheet" href="/Myhome_project/css/board.css"> -->
<link rel="stylesheet" href="/Myhome_project/css/myproperty.css">

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
	
	.property-list2{
		width:530px;
		margin-left: 10px;
	}

    
     .listbox{
     	width: 870px;
    	margin: 10px 0px;
    	height: 200px;
    } 
    
    .list {
	    float: left;
	    height: auto;
	    margin : 10px auto;
    	padding : 15px 0px;
   	
   	}
   	
   	.property-content{
   		margin-right : 10px;
   	
   	}
   	

   	
   	.img-property {
        border: 1px solid black;
       	width: 280px;
        height: 180px;
        float: left;
       	/* background-image: url(../image/6.jpg); */
        background-position: 0% 0px; 
        background-size: cover;
        cursor: pointer;
     }

	#checkbox {
		float: left;
		margin : 10px;
	}
	.property-title{
		width : 100%
	}
	
	#price{
		width:auto;
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
		color: white !important;
	}
	
	.btns {
    	cursor: pointer;
    	margin-bottom: 20px;
    	text-align : right;
    }
    
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
    
    
    .search{
		text-align:center;
	   	padding: 10px;
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
        
        
		<div id="title">매물관리</div>
		
		<!-- <div class="list">	 -->
			
			<!-- 검색결과 -->
			<c:if test="${not empty search}">
	        <div class="message well well-sm">
	            '${search}'(으)로 ${list.size()}건의 게시물을 검색했습니다.
	        </div>
	        </c:if>
			
			<c:forEach items="${list}" var="dto">
			<div class="listbox">
				<input type="checkbox" id="checkbox">
                    <div class="img-property" <%-- style="background-image : url('${dto.image}');" --%> ><div class="state">${dto.state}</div></div>
                    <div class="property-list2">
                        <div class="property-num">no.${dto.seq}</div>
                        <div class="property-title">${dto.title}</div>
                        <div class="property-content" id="roomtype">
                            <span>방유형</span>
                            <div class="property-content2">${dto.roomtype}</div>
                        </div>
                        
                        <div class="property-content" id="floor">
                            <span>층</span>
                            <div class="property-content2">${dto.floor}</div>
                        </div>
                        
                        <div class="property-content" id="contract">
                            <span>계약유형</span>
                            <div class="property-content2">${dto.contracttype}</div>
                        </div>
                        
                        <div class="property-content" id="price">
                            <span>가격</span>
                            <div class="property-content2">${dto.value}</div>
                        </div>
                        
                        <div class="property-location">
                            <div class="location-icon" style="float: left;"></div>
                            <div class="location-detail">${dto.location}</div>
                        </div>
                        
                    </div>
                </div>
                </c:forEach>
                
            <!-- </div> -->
  
			
			<div class="btns">           	
            	<input type="button" class="btn" value="선택한 매물 삭제" id="delete">
            </div>
            
            <!-- 페이징 -->
	       	<nav class="pagebar">
                <ul class="pagination">
                    ${pagebar}
                </ul>
            </nav>
            <!-- 검색 -->
			<form id="searchForm" method="GET" action="/Myhome_project/admin/property/listproperty.do">            
           	<div class="search">
            	<input type="text" class="form-control" placeholder="닉네임/매물번호" id="search" name="search" required value="${search}">
            	<input type="button" class="btn" value="검색" id="serch" onclick="$('#searchForm').submit();">
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

