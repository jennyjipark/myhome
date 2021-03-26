<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::방올리기</title>
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
    
    .property-list {
    	border-bottom: 1px solid #DBDCE0;
    	width: 870px;
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
    	height: 600px;
    	margin-right: 50px;
    	margin-left: 60px;
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
  	
  	.pagination > .disabled > a {
  		cursor: pointer !important;
  	}
  	

   
   /* 방올리기 버튼 */
   #btn-upload {
   		margin-left: 790px;
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
   
   
   /* 컨텐츠 없는 경우 */
   .content-none {
   		border: 1px solid #e2e2e2;
   		/* margin-left: 300px; */
   		font-family: 'MaplestoryOTFLight';
   		color: #202020;
   		font-size: 24px;
   		width: 800px;
   		height: 400px;
   		padding: 140px 200px;
   		text-align: center;
   		border-radius: 20px;
   }
   
   .nothing {
   		font-size: 50px;
   		display: block;
   		color: #f1aeae;
   		line-height: 2;
   }
   
   
   .tenantid {
   		border: 1px solid #dedede;
   		width: 400px;
   		margin: 0px auto;
   		position: fixed;
   		border-radius: 30px;
   		padding: 50px 40px;
   		left: 700px;
   		top: 400px;
   		background-color: white;
   		font-family: 'NanumBarunGothic';
   		visibility: hidden;
   		height: 170px;
   }
   
   .tenantid > span {
   		display: block;
   		font-size: 20px;
   		text-align: center;
   		font-family: 'MaplestoryOTFLight';
   		color: #f1aeae;
   }
   
   #check {
   		margin-top: 20px;
   		margin-left: 130px;
   }
   
   .pagination > li > a {
   		color: #202020;
   }
   
   
   
   	
    

</style>


</head>
<body>
 
<div class="boardwrap">
 
 <!-- header -->
<%@include file="/WEB-INF/views/inc/bootstrap-header.jsp"%>
 
 <!-- 임대인과 매칭된 매물 리스트만 보여주기 + 체크박스 > 방올리기 페이지 이동 -->
 
     <div class="container">
  	
        
       
            		 
		 <!-- 상단 게시판 타이틀 -->
		 <div class="board-name">방올리기</div>
		 	
		 	<div class="matching-option">
		 	<c:if test="${list.size() > 0 }">
		 		<span>임대인과 매칭된 매물리스트입니다.</span>
		 	</c:if>	 		 
		 	
		 	<c:if test="${list.size() == 0 }">
		 		<span>임대인과 매칭된 매물이 없어요.</span>
		 	</c:if>	 		
		 				
		 	</div>
        	
                
         <!-- 리스트 -->
		 <div class="property-box">		 	
		 
		 <form method="GET" action="/Myhome_project/contractor/upload-lessorok.do">
		 
		 <c:forEach items="${list }" var="dto">
		 <!-- form -->
		 <c:if test="${list.size() > 0}">
                <div class="property-list">
                	<div class="checkbox">
                	<input type="checkbox" name="seq" id="ck" value="${dto.seqLessorProperty }" onclick='checkOnlyOne(this)'>
                </div>
                	
                	<input type="hidden" value="${dto.seqLessorProperty }">
                	    		      
                    <div class="img-property">               
                    	<div class="state nickname">${dto.nickname }</div>
                    </div>
                    <div class="property-list2">
                        <div class="property-num">no. ${dto.seqLessorProperty }</div>
                        
                        <div class="property-title">${dto.title }</div>
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
                        
                    </div>
                </div>
                </c:if>
                
                <input type="hidden" value="${dto.seqLessorProperty }">
                
               </c:forEach>
                
                <c:if test="${list.size() == 0 }">
                <div class="content-none">
                	<span class="nothing">NOTHING</span>
                	<span>매칭된 매물이 없어요.</span>
                </div>
                </c:if>
                
			<!-- 올리기 버튼 -->
			<c:if test="${list.size() > 0 }">
				<input type="button" class="btn btn-outline-secondary" value="방올리기" id="btn-upload"></input>
            </c:if>    
        
				
        <c:if test="${list.size() > 0 }">   
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
       	<!-- search-paging -->
      
       	</div>         
		</c:if>
		
		
			<div class="tenantid">              
        	<span>매물 올리기가 완료되었습니다.</span>
        		<div class="btns">
                	<input type="submit" class="btn btn-outline-secondary btn2" id="check"  value="확인">
                </div>
        	</div>
        
        </form>        
        <!-- property-box -->
        </div>
        
        
        
         
        
    <!-- container -->        
	</div>  

   </div>
           


<script>

	$("#btn-upload").click(function() {
		$(".tenantid").css("visibility", "visible");
		$(".tenantid").css("z-index", "999");
	})
	
	$("#check").click(function() {
		$(".tenantid").css("visibility", "hidden");
	})
	
	
	//체크박스는 하나만 선택
	function checkOnlyOne(element) {
		const checkbox = document.getElementsByName("seq");
		
		checkbox.forEach((cb) => {
			  cb.checked = false;
		})
		
		 element.checked = true;
	}
	
</script>

 
     <!-- footer -->
<%@include file="/WEB-INF/views/inc/footer.jsp" %>
 
</body>
</html>