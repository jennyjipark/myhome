<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::전자계약관리</title>
<%@include file="/WEB-INF/views/inc/asset.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    
    .matching-option > a:nth-child(1) {
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
    	margin-top: 50px;
    }
    
    #board {
    	width: 810px;
    	margin-top: 0px;
    	margin-left: 0px;
    
    }
    
   .boardtd {
	   	text-align: center;
	    vertical-align: middle;
   }
    
    .firtd {
    	width: 10px;
    }
    
    .sectd {
    	width: 20px;
    }
    
    .thitd {
    	width: 10px;
    }
    
    .fortd {
    	width: 20px;
    }
    
   	.boardtd {
   		text-align: center;
    	vertical-align: middle;
   	
   	} 
   	
   	
   	/* 헤더 */
   	
	#mycontract {
		color: #f1acac;
	}   
	
	
	/* 매칭버튼 */
	
	#button-addon1 {
	  	background-color: #f1aeae;
	   	color: white;
	   	outline: none !important;
	   	font-family: 'NanumBarunGothic';
	   	border: 1px solid #f1aeae;
   }
   
   #button-addon2 {
	   	background-color: #f1aeae;
	   	color: white;
	   	outline: none !important;
	   	font-family: 'NanumBarunGothic';
	   	border: 1px solid #f1aeae;
	   	margin-left: 5px;
   }
   
   
   .boardtr > .boardtd {
   		cursor: pointer;
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
  		text-align: center;
   	}
    
    .pagination > li > a {
		color: #202020 !important;
	
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
   		margin: 10px 220px;
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
   
   /* 전자계약이 존재하지 않는 경우 */
   
   .empty {
   		font-size: 16px;
   		font-family: 'MaplestoryOTFLight';
	    color: #202020;
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
		 	<div class="board-name">전자계약관리</div>		 	
         	 
        
   
   		<!-- 게시판 -->
        <div class="matching-board">
        
	        <table id="board" class="table table-hover table-striped table-condensed">
		
	            <tr class="headtr">
	                <th class="firtd boardtd">계약번호</th>
	                <th class="sectd boardtd">임대인</th>
	                <th class="thitd boardtd">임차인</th>
	                <th class="fortd boardtd">중개인</th>
	                <th class="fortd boardtd">계약상태</th>
	            </tr>
	            
	            <!-- 매물계약 리스트 -->
	            <c:forEach items="${list }" var="dto">
	      
	            <!-- 중개인의 전자계약이 없는 경우 -->
	            <c:if test="${empty dto.seqUserL }">
                    	<tr>
                    		<td colspan="5" style="text-align:center;">전자계약이 존재하지 않아요.</td>
                    	</tr>                
	            </c:if>
	            <c:if test="${not empty dto.seqUserL }">
	            <tr class="boardtr" onclick="location.href='/Myhome_project/contractor/mypage-contract-view.do?seq=${dto.seqContract }';">
	                <td class="firtd boardtd "><div class="temp">${dto.seqContract }</div></td>
	                <td class="sectd boardtd boardtext align-middle"><div class="temp">${dto.nameL}</div></td>
	                <td class="thitd boardtd align-middle"><div class="temp">${dto.nameT }</div></td>
	                <td class="fortd boardtd align-middle"><div class="temp">${dto.nameC }</div></td>
	                <td class="fiftd boardtd">
	                	<div class="temp">
	                	${dto.state }
	                	<!-- 계약완료인 경우만 날짜 나오기 --> 
	                	<c:if test="${dto.state eq '완료'}" var="var1">
	                		(${dto.contractDate })
	                	</c:if>
	                	
	                	</div>            	
	       			</td>
	            </tr>
	             </c:if>	  
	            </c:forEach>
	                      	            	            
	           
	        </table>
	        
	        
	     </div>
       		
       		

       		<!-- 검색, 페이지바 -->
       		<div class="search-paging">
	       		<div class="paging">
	       			<ul class="pagination">
					   ${pagebar }
					</ul>       		
	       		</div>
	       		
	       		
	       		<div id="search-box">		
					<input type="text" class="form-control" id="search-text" placeholder="닉네임, 매물번호를 입력해주세요."> 		
					<button class="btn btn-outline-secondary" type="button" id="button-addon1">검색</button>
				</div>
	       		
	       	</div>
	       		

          
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