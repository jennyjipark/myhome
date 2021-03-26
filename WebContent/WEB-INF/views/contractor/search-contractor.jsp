<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::방찾기</title>
<%@include file="/WEB-INF/views/inc/asset.jsp" %>


<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">
<link rel="stylesheet" href="/Myhome_project/css/contractor-mypage.css">
<link rel="stylesheet" href="/Myhome_project/css/myproperty.css">



<style>
	.header {
		background-color : white;
	}
	
	/* myproperty.css 덮어쓰기 */
	
	.property-box {
       	/* border: 1px solid blue; */
        float: left;            
        margin-left: 50px;
        width: 900px;
        height: auto;
        margin-bottom: 50px;
        /* padding-right: 150px; */
        padding-left: 50px;
            
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
		padding: 100px 200px;
		z-index: -1;
    }
    
    .board-name {
    	border-left: 3px solid #f1acac;
    	width: 810px;
    	height: 32px;
    	padding-left: 20px;
    	font-size: 24px;
    	font-family: 'MaplestoryOTFLight';
    	color: #202020;
    	margin-bottom: 20px;
    	
    }
    
    .property-title {
    	width: 500px;
    }
    
    .property-list {
    	border-bottom: 1px solid #DBDCE0;
    	width: 860px;
    	height: 240px;
    	padding: 30px 0px;
    	font-family: 'NanumBarunGothic';
    	color: #424242;
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
    
    
   	/* 전체 property list 박스 property.css 덮어쓰기 */
   	
   	.property-box {
   		/* border: 1px solid blue; */ */
	    float: left;
	    width: 900px;
	    height: auto;
	    margin-bottom: 50px;
	    margin-left: 0px;
	    padding-left: 0px;
	    padding-top: 0px;
   	
   	}
   	
   	.img-property {
       /*  border: 1px solid black; */
       	width: 280px;
        height: 180px;
        float: left;
       	background-image: url('../image/6.jpg');
        background-position: 0% 0px; 
        background-size: cover;
        cursor: pointer;
        margin-left: 15px;
     }
   	
   	
   	
   	
   	/* 헤더 */
   	
	#mymatching {
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
	 	

   
   /* 검색, 페이지바 */
    
    .search-paging {
    	/* border: 1px solid black; */
    	width: 800px;
    	height: 200px;
    	padding: 20px 0px; 
    	margin-top: 50px;
    }
    
    .paging {
  		/* border: 1px solid blue; */
  		width: 100%;
  		height: 75px;
  		padding: 0px 170px;
  		text-align: center;
   	}
    
    .pagination > li > a {
		color: #202020;
	
	}
    
    .pagination>.active>a, .pagination>li>a:hover{
		background-color: #f1aeae !important;
		border-color : #f1aeae !important;
		color: white !important;
	}
	
	
	.pagination > .disabled > a {
		cursor: pointer !important;
	}
	
    
    .btn {
   		background-color: #f1aeae;
   		color: white;
   		outline: none !important;
   		font-family: 'NanumBarunGothic';
   	} 
   	
   	.btn:active {
   		color: white;
   	}
   	
   	.btn:hover {
   		color: white !important;
   	}
    
    #search-box {
   		/* border: 1px solid black; */
   		width: 390px;
   		height: 60px;
   		margin: 10px 230px;
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
  
  	ck {
  		float: left;
  	} 
  	
   
   /* 방올리기 버튼 */
   #btn-upload {
   		margin-left: 380px;
   		margin-top: 20px;
   }
   
   /* 매물리스트 체크박스 */
   
   .checkbox {
   		/* border: 1px solid black; */
   		float: left;
   		width: 16px;
   		height: 16px;
   		margin-top: 0px;
   	
   }
   
   #ck {
   		margin-left: 0px;
   		width: 16px;
   		height: 16px;
   		margin-top: 0px;
   }
   
   .search-result {
   		font-size: 16px;
   		font-family: 'NanumBarunGothic';
   }
   
   .nothing {
   		height: 250px;
   }
   
   .nothing1 {
   		margin-top: 130px;
   		font-size: 50px;
   		color: #f1aeae;
   		font-family: 'MaplestoryOTFLight';
   		display: block;
   		text-align: center;
   }
   	
   .nothing2 {
   		font-size: 16px;
   		color: #202020;
   		display: block;
   		font-family: 'NanumBarunGothic';
   		text-align: center;
   }
    

</style>


</head>
<body>
 
<div class="boardwrap">
 
 <!-- header -->
<%@include file="/WEB-INF/views/inc/bootstrap-header.jsp"%>
 
 <!-- 중개인이 올린 매물 리스트만 보여주기-->
 
     <div class="container">
        <div class="boardcover">
            
		 <!-- 상단 게시판 타이틀 -->
		 <div class="board-name">방찾기</div>
		 	
		 <div class="matching-option">
		 
		 <!-- 중개인 메뉴 -->
		 <c:if test="${empty nickname }">
		 	
		 	
		 	<a href="search-lessor.do">임대인이 올린 방</a>
		 	<a href="search-contractor.do">중개인이 올린 방</a>
		 	
		 	
		 </c:if>	
		 
		 <!-- 일반회원 메뉴 -->
		  <c:if test="${not empty nickname and empty seqContractor }">
		 	<a href="search-contractor.do">중개인이 올린 방 리스트 입니다.</a>
		 </c:if>		 		 			
		 </div>
         
         
         <!-- 메인에서 검색으로 들어왔을 때 -->
        
         <!-- 다 검색된 경우 -->
          <c:if test="${not empty deal and not empty room and not empty location}">
           	<c:if test="${list.size() == 0 }">
           		<div class="nothing">
           			<span class="nothing1">NOTHING</span>
         			<span class="nothing2">검색결과가 없어요.</span>
         		</div>
         	</c:if>
          
          	<c:if test="${list.size() > 0 }">
         	<span class="search-result">${deal }, ${room }, ${location } (으)로 검색한 결과입니다.</span>
         	</c:if>
         </c:if>
        
        
        <!-- 지역이 빈 경우 -->
         <c:if test="${not empty deal and not empty room and empty location}">
         
         	<c:if test="${list.size() == 0 }">
         		<div class="nothing">
           			<span class="nothing1">NOTHING</span>
         			<span class="nothing2">검색결과가 없어요.</span>
         		</div>
         	</c:if>
         	
         	<c:if test="${list.size() > 0 }">
         		<span class="search-result">${deal }, ${room }(으)로 검색한 결과입니다.</span>
         	</c:if>
         </c:if>
         
	
        		
        	  
                
         <!-- 리스트 -->
		 <div class="property-box">		 			 	
		 	
		 		<c:forEach items="${list }" var="dto">
                <div class="property-list">
                
                    <div class="img-property" style="background-image: url('../image/${dto.path }')">           
                  		          
	                   <c:if test="${dto.available == 0 }">	           
	                    <div class="state">입주가능</div>             
	                    </c:if>
	                    
	                     <c:if test="${dto.available == 1 }">	           
	                    <div class="state">계약완료</div>             
	                    </c:if>
	
                    </div>
                
                    
                    <div class="property-list2">
                    
                        <div class="property-num">no. ${dto.seqContractorProperty }</div>
                        <div class="property-title" onclick="location.href='/Myhome_project/contractor/property-contractor-detail.do?seq=${dto.seqContractorProperty}';">${dto.title }</div>
                        <div class="property-content" id="roomtype">
                            <span>방유형</span>
                            <div class="property-content2">${dto.roomType }</div>          
                        </div>
                            
                        <div class="property-content" id="floor">
                            <span>층</span>
                            <div class="property-content2">${dto.floor }</div>
                        </div>
                        
                        <div class="property-content" id="contract">
                            <span>계약유형</span>
                            <div class="property-content2">${dto.contractTypeDetail }</div>
                        </div>
                      
                       
                       
                        <c:if test="${dto.contractTypeDetail eq '월세'}">
	                        <div class="property-content" id="price">
	                            <span>가격</span>
	                            <div class="property-content2">${dto.monthlyRent }/월(${dto.contractPeriod })</div>
	                        </div>
                        </c:if>
                        
                        <c:if test="${dto.contractTypeDetail eq '전세'}">
	                        <div class="property-content" id="price">
	                            <span>가격</span>
	                            <div class="property-content2">${dto.deposit }</div>
	                        </div>
                        </c:if>
                        
                         <c:if test="${dto.contractTypeDetail eq '매매'}">
	                        <div class="property-content" id="price">
	                            <span>가격</span>
	                            <div class="property-content2">${dto.dealing }</div>
	                        </div>
                        </c:if>
                     
                       	
                        <div class="property-location">
                            <div class="location-icon" style="float: left;"></div>
                            <div class="location-detail">${dto.location }</div>
                        </div>
               			 
               			<!-- Ajax로 보내기 -->        			 
               			<input type="hidden" id="seq" value="${dto.seqContractorProperty }">
                    </div>  
                    
                   
                </div>
               </c:forEach> 
                
                                          
	<c:if test="${list.size() > 0 }">
        <!-- 검색, 페이지바 -->
   		<div class="search-paging">
	   		<div class="paging">
	       		<ul class="pagination">
					${pagebar }
				</ul>       		
	       	</div>
	       		
	       		
	    	<div id="search-box">		
				<input type="text" class="form-control" id="search-text" placeholder="중개사무소, 매물번호를 입력해주세요."> 		
				<button class="btn btn-outline-secondary" type="button" id="button-addon1">검색</button>
			</div>
       	<!-- search-paging -->
       	</div>         
         </c:if>     
                        
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