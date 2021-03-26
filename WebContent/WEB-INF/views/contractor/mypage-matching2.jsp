<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::매칭매물관리</title>
<%@include file="/WEB-INF/views/inc/asset.jsp" %>


<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">
<link rel="stylesheet" href="/Myhome_project/css/contractor-mypage.css">
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
		border-right: 1px solid #DBDCE0;
   		border-left: 1px solid #DBDCE0;
		margin-top: 100px;
		z-index: -1;
    }
    
    .board-name {
    	border-left: 5px solid #f1aeae;
	    width: 810px;
	    /* height: 50px; */
	    padding-left: 10px;
	    font-size: 24px;
	    font-family: 'MaplestoryOTFLight';
	    color: #202020;
    	
    }
    
    
    .matching-option {
    	/* border: 1px solid blue; */
    	width: 400px;
    	height: 100px;
    	padding: 40px 0px;
    	font-size: 16px;
    	font-family: 'NanumBarunGothic';
    	color: #202020;
    }
    
    
    
    .matching-option > a {
    	cursor: pointer;
    	color: #202020;
    	margin-right: 20px;
    	float: left;
    	margin-left: 0px;
    }
    
     .matching-option > a:hover {
    	color: #f1acac;    	
    	text-decoration: none;
    }
    
    .matching-option > a:nth-child(2) {
    	color: #f1acac;
    	display: inline;
    	border-bottom: 2px solid #f1acac;
    	padding-bottom: 4px;
    }
    
    
    #tome {
    	color: #f1acac;
    	display: inline; 
    	border-bottom: 3x solid #202020; 
    	padding-bottom: 5px;
    	text-decoration: none;
    }
    
    .matching-board {
    	/* border: 1px solid blue; */
    	width: 820px;
    	height: 550px;
    }
    
    #board {
    	width: 810px;
    	margin-top: 0px;
    	margin-left: 0px;
    }
    
    #board tr {
    	cursor: pointer;
    }
    
   .boardtd {
	   	text-align: center;
	    vertical-align: middle;
   }
    
   .text-middle {
   		text-align: center;
   }
 
   	
   	/* 헤더 */
   	
	#mymatching {
		color: #f1acac;
	}   
	
	
	/* 매칭버튼 */
	
   
   #button-addon2 {
	   	background-color: #f1aeae;
	    color: white;
	    outline: none !important;
	    font-family: 'NanumBarunGothic';
	    border: 1px solid #f1aeae;
	    margin-left: 5px;
	    height: 25px;
	    padding: 2px;
	    width: 80px;
   }
	 	

   
   /* 검색, 페이지바 */
    
    .search-paging {
    	/* border: 1px solid black; */
    	width: 800px;
    	height: 200px;
    	padding: 20px 0px; 
    }
    
    .paging {
  		/* border: 1px solid blue; */
  		width: 100%;
  		height: 75px;
  		padding: 0px 170px;
   	}
    
    .pagination > li > .page-a {
		color: #202020;
	
	}
    
    .pagination>.active>a, .pagination>li>a:hover{
		background-color: #f1aeae !important;
		border-color : #f1aeae !important;
		color: white !important;
	}
	
    
    .btn {
   		background-color: #f1aeae;
   		color: white;
   		outline: none !important;
   		font-family: 'NanumBarunGothic';
   	} 
    
    #search-box {
   		/* border: 1px solid black; */
   		width: 390px;
   		height: 60px;
   		margin: 10px 200px;
   		padding: 10px;
   }
   
   #search-text {
   		width: 300px;
   		outline: 0;
   		display: inline;
   		margin-right: 10px;
   
   }
    
   
   .temp {
	   	min-height: 35px;
	   	/* border: 1px solid black; */
	   	padding: 5px;
   
   }
   	
    

</style>


</head>
<body>
 
<div class="boardwrap">
 
 <!-- header -->
<%@include file="/WEB-INF/views/inc/bootstrap-header.jsp"%>
 
     <div class="container">
     <%@include file="/WEB-INF/views/contractor/nav.jsp" %>
        <div class="boardcover">
            
		 
		 <!-- 리스트 -->
		 <div class="property-box">
		 	<div class="board-name">매칭매물관리</div>
		 	
		 	<div class="matching-option">
		 		<a href="mypage-matching1.do">나에게 들어온 매칭</a>
		 		<a href="mypage-matching2.do">내가 신청한 매칭</a>		 		 			
		 	</div>
                
          
        
         	 
        <form action="" id="form1">
   
   		<!-- 게시판 -->
        <div class="matching-board">
        
	        <table id="board" class="table table-hover table-striped table-condensed">
	
	            <tr class="headtr">
	                <th class="boardtd" colspan="1">매물번호</th>
	                <th class="boardtd" colspan="4">제목</th>
	                <th class="boardtd" colspan="1">닉네임</th>
	                <th class="boardtd" colspan="2">매칭신청</th>
	            </tr>
	            
	           
	            <c:if test="${list.size() == 0 }">
					<tr class="boardtr">
						<td class="text-middle" colspan="8"><div class="temp">매칭 신청한 매물이 없습니다.</div></td>					
					</tr>	            
	            </c:if>
	            
	            <c:forEach items="${list }" var="dto">
	            <tr class="boardtr" onclick="location.href='/Myhome_project/contractor/property-lessor-detail.do?seq=${dto.seqLessorProperty}';">
	                <td class="firtd boardtd"><div class="temp">${dto.seqLessorProperty }</div></td>
	                <td class="sectd boardtd boardtext align-middle"><div class="temp">${dto.title }</div></td>
	                <td class="thitd boardtd align-middle"><div class="temp">${dto.nickname }</div></td>
	                <td class="fortd boardtd">
	                <div class="temp">
	                <c:if test="${dto.matching == 1 }">
	                <c:set var="now" value="<%=new java.util.Date() %>"/>	           
	                	<span>매칭완료(<fmt:formatDate value="${now }" type="date"/>)</span>
	                </c:if>
	                
	                <c:if test="${dto.matching == 0 }">
	            		<button class="btn btn-outline-secondary" type="button" id="button-addon2">거절하기</button> 
	            	</c:if>
	            	
	            	<c:if test="${empty dto.matching }">
	            		<button class="btn btn-outline-secondary" type="button" id="button-addon2">수락하기</button> 
	            	</c:if>
	            	</div>
	       			</td>
	            </tr>
	            </c:forEach>
	           
	            	     
	        </table>
       		
       		</div>
       	
       		<!-- 검색, 페이지바 -->
       		<div class="search-paging">
	       		<div class="paging">
	       			<ul class="pagination">
					    <li class="page-item"><a class="page-link page-a" href="">이전</a></li>
					    <li class="page-item"><a class="page-link page-a" href="">1</a></li>
					    <li class="page-item"><a class="page-link page-a" href="">2</a></li>
					    <li class="page-item"><a class="page-link page-a" href="">3</a></li>
					    <li class="page-item"><a class="page-link page-a" href="">4</a></li>
					    <li class="page-item"><a class="page-link page-a" href="">5</a></li>
					    <li class="page-item"><a class="page-link page-a" href="">6</a></li>
					    <li class="page-item"><a class="page-link page-a" href="">7</a></li>
						<li class="page-item"><a class="page-link page-a" href="">8</a></li>
						<li class="page-item"><a class="page-link page-a" href="">9</a></li>
						<li class="page-item"><a class="page-link page-a" href="">10</a></li>
					    <li><a class="page-link page-a" href="">다음</a></li>
					</ul>       		
	       		</div>
	       		
	       		
	       		<div id="search-box">		
					<input type="text" class="form-control" id="search-text" placeholder="닉네임, 매물번호를 입력해주세요."> 		
					<button class="btn btn-outline-secondary" type="button" id="button-addon1">검색</button>
				</div>
       		</div>
       	
       	</form>
       
        
       
		
        
        
    
         
              
          
          
          
          
          <!-- property-box -->
          </div>
             
             
             
             
             
    <!-- container -->        
	</div>  
   
    
  
   </div>
           
            
</div>


 
     <!-- footer -->
<%@include file="/WEB-INF/views/inc/footer.jsp" %>
 
</body>
</html>