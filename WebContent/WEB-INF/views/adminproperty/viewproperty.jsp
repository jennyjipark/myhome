<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%


%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::방 상세보기</title>
<%@include file="/WEB-INF/views/inc/asset.jsp" %>
<link rel="stylesheet" href="/Myhome_project/css/template.css">
<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="/Myhome_project/css/myproperty.css">
<!-- <link rel="stylesheet" href="/Myhome_project/css/boarduserver.css"> -->


<!-- 부트스트랩 사용가능한 템플릿 -->

<style>
	
	.container {
		border-color: transparent;
		
		margin: 0 auto;
	    letter-spacing: -.2px;
	    min-height: 100%;
	    padding-bottom: 100px;
	    /* border: 1px solid green; */
	    margin-top: 100px;
	    border-right: 1px solid #DBDCE0;
    	border-left: 1px solid #DBDCE0;
	    

		}
	

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
	

        
        /* 팀장님 소스 */
        
   
   	
   	/* 전체 property list 박스 property.css 덮어쓰기 */
   	
   	.property-box {
   		/* border: 1px solid black; */
	    /* float: left; */
	    float: none;
/* 	    width: 900px; */
	    width: 100%;
	    height: 1000px;
	    padding: 0 90px;
	    position: relative;
	    margin: 50px 10px;
	    font-family: 'NanumBarunGothic';
	    
   	
   	}
   	
   	.property-list {
   		width: 100%;
   		border-bottom: 0;
	    
	    height: auto;
   	}
   	
   	/* 이미지 박스 */
   	
   	
   	.img-box {
   		/* border: 1px solid black; */
   		width: 460px;
   		height: auto;
   		overflow: hidden;
   		float: left
   	}
   
    
   
   	.img-property {
        /* border: 1px solid black; */
       	width: 450px;
        height: 300px;
        float: none;
       	background-image: url('../image/6.jpg');
        background-position: 0% 0px; 
        background-size: cover;
        cursor: pointer;
        background-color: #ccc;
        margin-top: 5px;
     }
     
     
     .imgsmall-property {
     	/* border: 1px solid black; */
     	float: left;
     	background-color: #ccc;
     	cursor: pointer;
     	margin-top: 10px;
     	margin-right: 5px;
     	width: 147px;
     	height: 73px;
     	left: -450px;
     	top: 260px;
     	
     }
     
     
     .property-list2 {
     	width: 430px;
     	position: relative;
     	/* float: left; */
     	height: 900px;	
     	padding: 0px 5px;
     	/* border: solid 1px black; */
     	top: -30px;
     	margin-left: 50px;
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
    
   .state {
	   	position: relative;
	   	float: left;
	   	left: 350px;
	   	
   
   }
   
   .property-title {
   		margin-bottom: 10px;
   }
   
   .contractor-name {
   	margin-bottom: 8px;
   }
   
   .contractor-phone {
   		margin-bottom: 15px;
   }
   
   .optionname {
   		margin-bottom: 8px;
   		font-weight: bold;
   }
   
   .option1 span, .option2 span {
   		background-color: #f1aeae;
   		padding: 5px 8px;
   		margin-right: 6px;
   		margin-top: 8px;
   		color: white;
   }
   
   .option1, .option2 {
   		margin-bottom: 20px;
   }
   
   .option-type {
   		margin-bottom: 10px;
   }
   
   .informtype {
   		font-weight: bold;
   		margin-bottom: 6px;
   }
   
   .informtype span {
   		font-weight: normal;
   		margin-left: 7px;
   }
   
   .inform2-1 {
   		font-size: 20px;
   		font-weight: bold;
   		margin-bottom: 10px;
   }
   
   .inform2-2 {
   		margin-bottom: 7px;
   		font-size: 16px;
   		font-weight: bold;
   		margin-top: 20px;
   }
   
   .inform2-3 {
   		font-size: 16px;
   }
   
   .top-inform {
   	 	width: 450px;
   }
   
   .count2 {
   		margin-left: 4px;
   }
   
   #likecount {
   		font-weight: bold;
    	border: 1px #ccc solid;
	    padding: 3px 4px;
	    text-align: center;
	    width: auto;
	    position: relative;
	    float: right;
	    left: 83px;
	    top: 1px;
	    /* margin-left: 90px; */
   }
   
   #report {
   		border : 1px #ccc solid;
   		padding: 3px 4px;
   		text-align: center;
   		width: auto;
   		position: relative;
   		float: right;
   		left: -70px;
   		top: 1px;
   		font-weight: bold;
   }
   
   
   /* 중개인 정보 */
   .contractor-desc {
   		/* border: 1px solid #d0d0d0; */
	    width: 400px;
	    height: 120px;
	    padding: 20px;
	    font-size: 16px;
	    font-family: 'NanumBarunGothic';
	    border-radius: 15px;
	    margin-top: 30px;
	    margin-bottom: 30px;
	    box-shadow: 0px 0px 5px gainsboro;
   }
   
   .informcontent1 {
   		/* border: 1px solid #d0d0d0; */
   		padding: 10px;
   		font-size: 16px;
   		width: 400px;
   }
   
   .informcontent2 {
   		/* border: 1px solid #d0d0d0; */
   		padding: 20px;
   		border-radius: 20px;
   		margin-top: 30px;
   		width: 400px;
   		box-shadow: 0px 0px 5px gainsboro;
   }
   
   #btn-chat {
   		width: 70px;
	    height: 25px;
	    background-color: #f1aeae;
	    color: white;
	    outline: none !important;
	    font-family: 'NanumBarunGothic';
	    border: 1px solid #f1aeae;
	    text-align: center;
	    padding: 2px;
	    margin-left: 10px;
   }
   
   /* 매물정보 */
   
   .table>tbody>tr>th, .table-condensed>tbody>tr>td {
   		line-height: 2;
   }
   
   .table>tbody>tr>.no-line {
   		border-top: 0px;
   }
   
   .adcontacttd {
   		font-family: 'NanumBarunGothic';
   }
   
    /* 옵션박스 */
    
   .option-detail {
   		/* border: 1px solid black; */
   		width: 450px;
   		height: auto;
   		margin-top: 120px;
   		font-size: 20px;
   }
   
   .option-detail > .option > span {
   		display: block;
   		margin-bottom: 10px;
   		font-weight: bold;
   }
   
   	.option {
		width: 440px;
	    height: auto;
	    border-bottom: 1px solid #dddddd;
	    margin-bottom: 20px;
	    padding: 20px 0px;
	    float: left;
	    
  	}
  	
  	.option:nth-child(3) {
  		border-bottom: 0px;
  	}
  	
  	
  	.option-box {
  		border: 2px solid #f1aeae;
	    width: 100px;
	    height: 40px;
	    /* background-color: #f1aeae; */
	    border-radius: 10px;
	    text-align: center;
	    padding: 8px;
	    font-size: 16px;
	    color: #202020;
	    float: left;
	    margin-right: 10px;
	    margin-bottom: 10px;
  	
  	}
  	
  	
  	
  	
   
  
	
	
</style>


</head>
<body>
 
 <!-- header -->
<%@include file="/WEB-INF/views/admin/header.jsp" %>
 
     <div class="container">
     <%@include file="/WEB-INF/views/admin/nav.jsp" %>
        <div class="boardcover">
     
     <div id="title">방 상세보기</div>
     <div style="clear:both;"></div>
     
     <hr>
            
      
         <div class="property-box">		 	
		 
		
			<c:forEach items="${list }" var="dto">
			
           	<div class="property-list">
                <div class="img-box">
	            	<div class="img-property">
	            	<c:if test="${dto.available == 0 }">
	            	<div class="state">입주가능</div>
	            	</c:if>
	            	
	            	<c:if test="${dto.available == 1 }">
	            	<div class="state">계약완료</div>
	            	</c:if>
	            	
	            	</div>
	            	<!-- 작은 이미지 박스 -->
	            	<div class="imgsmall-property"></div>   
	            	<div class="imgsmall-property"></div> 
	            	<div class="imgsmall-property"></div>       
	            	
	            	<!-- 옵션 박스  -->
	                <div class="option-detail">
	                
	                	<div class="option-building option" style="float: left">
	                		<span>건물옵션</span>
	                		
	                		<c:if test="${dto.parking == 1 }">
	                		<div class="option-box">주차장</div>
	                		</c:if>
	                		
	                		<c:if test="${dto.elevator == 1 }">
	                		<div class="option-box">엘리베이터</div>
	                		</c:if>
	                		
	                		<c:if test="${dto.pet == 1 }">
	                		<div class="option-box">반려동물</div>
	                		</c:if>
	                		
	                		<c:if test="${dto.window == 1 }">
	                		<div class="option-box">발코니</div>
	                		</c:if>	                			                		
	                		
	                		
	                	</div>
	                	<div class="option-room option" style="float: left">
	                		<span>방옵션</span>
	                		
	                		<c:if test="${dto.window == 1 }">
	                		<div class="option-box">발코니</div>
	                		</c:if>
	                		
	                		<c:if test="${dto.airconditional == 1 }">
	                		<div class="option-box">에어컨</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.washer == 1 }">
	                		<div class="option-box">욕조</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.bed == 1 }">
	                		<div class="option-box">침대</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.desk == 1 }">
	                		<div class="option-box">책상</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.closet == 1 }">
	                		<div class="option-box">옷장</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.tv == 1 }">
	                		<div class="option-box">TV</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.shoebox == 1 }">
	                		<div class="option-box">신발장</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.refrigerator == 1 }">
	                		<div class="option-box">냉장고</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.stove == 1 }">
	                		<div class="option-box">가스레인지</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.induction == 1 }">
	                		<div class="option-box">인덕션</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.microwave == 1 }">
	                		<div class="option-box">전자레인지</div>
	                		</c:if>	  	  
	                		
	                		<c:if test="${dto.bidet == 1 }">
	                		<div class="option-box">비데</div>
	                		</c:if>	  
	                	</div>
	                	
	                	
	                	
	                	<div class="option-maintenance option">
	                		<span>관리비옵션</span>
	                		
	                		<c:if test="${dto.internet == 1 }">
	                		<div class="option-box">인터넷</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.cable == 1 }">
	                		<div class="option-box">케이블TV</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.cleaning == 1 }">
	                		<div class="option-box">청소</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.water == 1 }">
	                		<div class="option-box">수도</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.gas == 1 }">
	                		<div class="option-box">가스</div>
	                		</c:if>	  	                
	                		
	                		<c:if test="${dto.electric == 1 }">
	                		<div class="option-box">전기</div>
	                		</c:if>	  		 
	                		
	                		
	                	</div>
	                	
	                	<!-- 마지막 박스 끊기 -->
	                	<div style="clear: both"></div>
	                
	                
	                </div>         	           	                  	                   
	             </div>
            </div>
                

            <div class="property-list2">                
	            <div class="property-title">${dto.title }</div>
	                        
	            <!-- 중개인 정보 -->
	            <div class="contractor-desc">                   
	            	<div class="contractor-name"><b>${dto.companyName }</b> <div class="btn btn-outline-secondary" id="btn-chat">채팅하기</div></div>
	                <div class="contractor-name">${dto.name }</div>
	                <div class="contractor-phone">Tel. ${dto.tel }</div>
	            </div>
                        
                        
	                    
	            <div class="informcontent1">
	            	<table class="table table-condensed">
	            		<tr class="headtr">
	            			<th class="adcontacttd title-color no-line" colspan="1">주소</th>
	            			<td class="adcontacttd title-color no-line" colspan="2">${dto.location }</td>
	            		</tr>
	            		
	            		<tr class="headtr">
	            			<th class="adcontacttd title-color" colspan="1">매물계약종류</th>
	            			<td class="adcontacttd title-color" colspan="2">${dto.contractTypeDetail}</td>
	            		</tr>
	            		
	            		<c:if test="${dto.contractTypeDetail eq '월세' }">
	            		<tr class="headtr">
	            			<th class="adcontacttd title-color" colspan="1">월세</th>
	            			<td class="adcontacttd title-color" colspan="2">${dto.monthlyRent }</td>
	            		</tr>
	            		</c:if>
	            		
	            		<c:if test="${dto.contractTypeDetail eq '전세' }">
	            		<tr class="headtr">
	            			<th class="adcontacttd title-color" colspan="1">보증금</th>
	            			<td class="adcontacttd title-color" colspan="2">${dto.deposit }</td>
	            		</tr>
	            		</c:if>
	            		
	            		<c:if test="${dto.contractTypeDetail eq '매매' }">
	            		<tr class="headtr">
	            			<th class="adcontacttd title-color" colspan="1">매매가격</th>
	            			<td class="adcontacttd title-color" colspan="2">${dto.dealing }</td>
	            		</tr>
	            		</c:if>
	            		
	            		<tr class="headtr">
	            			<th class="adcontacttd title-color" colspan="1">관리비</th>
	            			<td class="adcontacttd title-color" colspan="2">${dto.serviceCharge }</td>
	            		</tr>
	            		
	            		<tr class="headtr">
	            			<th class="adcontacttd title-color" colspan="1">계약기간</th>
	            			<td class="adcontacttd title-color" colspan="2">${dto.contractPeriod }</td>
	            		</tr>
	            		
	            		<tr class="headtr">
	            			<th class="adcontacttd title-color" colspan="1">층</th>
	            			<td class="adcontacttd title-color" colspan="2">${dto.floor }</td>
	            		</tr>
	            		
	            		<tr class="headtr">
	            			<th class="adcontacttd title-color" colspan="1">평수</th>
	            			<td class="adcontacttd title-color" colspan="2">${dto.spacing }</td>
	            		</tr>
	            		
	            		<tr class="headtr">
	            			<th class="adcontacttd title-color" colspan="1">구조</th>
	            			<td class="adcontacttd title-color" colspan="2">${dto.roomType }</td>
	            		</tr>
	            		
	            		<tr class="headtr">
	            			<th class="adcontacttd title-color" colspan="1">입주가능일</th>
	            			<c:if test="${empty dto.occupancyDate }">
	            			<td class="adcontacttd title-color" colspan="2">즉시입주</td>
	            			</c:if>
	            			
	            			<c:if test="${not empty dto.occupancyDate }">
	            			<td class="adcontacttd title-color" colspan="2">${dto.occupancyDate }</td>
	            			</c:if>
	            		</tr>
	            		
	            	
	            	</table>
	                    	
	                    	
	               </div>
	                    	                 
	                    
	                    <div class="informcontent2">
	                    	<div class="inform2-1">상세설명</div>	                
	                    	<div class="inform2-3">${dto.content }</div>
	                    </div>
                                                                      
                        
                    </div>
                    <div style="clear:both;"></div>
                    
                    </c:forEach>
                   
                   
                   
                   
                   
            <!-- 일반회원 마이페이지 매물거래내역 -->         
                  
			<c:if test="${not empty nickname }">
			
			<c:forEach items="${lessorList }" var="dto">
			
           	<div class="property-list">
                <div class="img-box">
	            	<div class="img-property">
	            	<c:if test="${dto.available == 0 }">
	            	<div class="state">입주가능</div>
	            	</c:if>
	            	
	            	<c:if test="${dto.available == 1 }">
	            	<div class="state">계약완료</div>
	            	</c:if>
	            	
	            	</div>
	            	<!-- 작은 이미지 박스 -->
	            	<div class="imgsmall-property"></div>   
	            	<div class="imgsmall-property"></div> 
	            	<div class="imgsmall-property"></div>       
	            	
	            	<!-- 옵션 박스  -->
	                <div class="option-detail">
	                
	                	<div class="option-building option" style="float: left">
	                		<span>건물옵션</span>
	                		
	                		<c:if test="${dto.parking == 1 }">
	                		<div class="option-box">주차장</div>
	                		</c:if>
	                		
	                		<c:if test="${dto.elevator == 1 }">
	                		<div class="option-box">엘리베이터</div>
	                		</c:if>
	                		
	                		<c:if test="${dto.pet == 1 }">
	                		<div class="option-box">반려동물</div>
	                		</c:if>
	                		
	                		<c:if test="${dto.window == 1 }">
	                		<div class="option-box">발코니</div>
	                		</c:if>	                			                		
	                		
	                		
	                	</div>
	                	<div class="option-room option" style="float: left">
	                		<span>방옵션</span>
	                		
	                		<c:if test="${dto.window == 1 }">
	                		<div class="option-box">발코니</div>
	                		</c:if>
	                		
	                		<c:if test="${dto.airconditional == 1 }">
	                		<div class="option-box">에어컨</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.washer == 1 }">
	                		<div class="option-box">욕조</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.bed == 1 }">
	                		<div class="option-box">침대</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.desk == 1 }">
	                		<div class="option-box">책상</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.closet == 1 }">
	                		<div class="option-box">옷장</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.tv == 1 }">
	                		<div class="option-box">TV</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.shoebox == 1 }">
	                		<div class="option-box">신발장</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.refrigerator == 1 }">
	                		<div class="option-box">냉장고</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.stove == 1 }">
	                		<div class="option-box">가스레인지</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.induction == 1 }">
	                		<div class="option-box">인덕션</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.microwave == 1 }">
	                		<div class="option-box">전자레인지</div>
	                		</c:if>	  	  
	                		
	                		<c:if test="${dto.bidet == 1 }">
	                		<div class="option-box">비데</div>
	                		</c:if>	  
	                	</div>
	                	
	                	
	                	
	                	<div class="option-maintenance option">
	                		<span>관리비옵션</span>
	                		
	                		<c:if test="${dto.internet == 1 }">
	                		<div class="option-box">인터넷</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.cable == 1 }">
	                		<div class="option-box">케이블TV</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.cleaning == 1 }">
	                		<div class="option-box">청소</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.water == 1 }">
	                		<div class="option-box">수도</div>
	                		</c:if>	  
	                		
	                		<c:if test="${dto.gas == 1 }">
	                		<div class="option-box">가스</div>
	                		</c:if>	  	                
	                		
	                		<c:if test="${dto.electric == 1 }">
	                		<div class="option-box">전기</div>
	                		</c:if>	  		 
	                		
	                		
	                	</div>
	                	
	                	<!-- 마지막 박스 끊기 -->
	                	<div style="clear: both"></div>
	                
	                
	                </div>         	           	                  	                   
	             </div>
            </div>
                

            <div class="property-list2">                
	            <div class="property-title">${dto.title }</div>
	                        
	            <!-- 중개인 정보 -->
	            <div class="contractor-desc">                   
	            	<div class="contractor-name"><b>${dto.companyName }</b> <div class="btn btn-outline-secondary" id="btn-chat">채팅하기</div></div>
	                <div class="contractor-name">${dto.name }</div>
	                <div class="contractor-phone">Tel. ${dto.tel }</div>
	            </div>
                        
                        
	                    
	            <div class="informcontent1">
	            	<table class="table table-condensed">
	            		<tr class="headtr">
	            			<th class="adcontacttd title-color no-line" colspan="1">주소</th>
	            			<td class="adcontacttd title-color no-line" colspan="2">${dto.location }</td>
	            		</tr>
	            		
	            		<tr class="headtr">
	            			<th class="adcontacttd title-color" colspan="1">매물계약종류</th>
	            			<td class="adcontacttd title-color" colspan="2">${dto.contractTypeDetail}</td>
	            		</tr>
	            		
	            		<c:if test="${dto.contractTypeDetail eq '월세' }">
	            		<tr class="headtr">
	            			<th class="adcontacttd title-color" colspan="1">월세</th>
	            			<td class="adcontacttd title-color" colspan="2">${dto.monthlyRent }</td>
	            		</tr>
	            		</c:if>
	            		
	            		<c:if test="${dto.contractTypeDetail eq '전세' }">
	            		<tr class="headtr">
	            			<th class="adcontacttd title-color" colspan="1">보증금</th>
	            			<td class="adcontacttd title-color" colspan="2">${dto.deposit }</td>
	            		</tr>
	            		</c:if>
	            		
	            		<c:if test="${dto.contractTypeDetail eq '매매' }">
	            		<tr class="headtr">
	            			<th class="adcontacttd title-color" colspan="1">매매가격</th>
	            			<td class="adcontacttd title-color" colspan="2">${dto.dealing }</td>
	            		</tr>
	            		</c:if>
	            		
	            		<tr class="headtr">
	            			<th class="adcontacttd title-color" colspan="1">관리비</th>
	            			<td class="adcontacttd title-color" colspan="2">${dto.serviceCharge }</td>
	            		</tr>
	            		
	            		<tr class="headtr">
	            			<th class="adcontacttd title-color" colspan="1">계약기간</th>
	            			<td class="adcontacttd title-color" colspan="2">${dto.contractPeriod }</td>
	            		</tr>
	            		
	            		<tr class="headtr">
	            			<th class="adcontacttd title-color" colspan="1">층</th>
	            			<td class="adcontacttd title-color" colspan="2">${dto.floor }</td>
	            		</tr>
	            		
	            		<tr class="headtr">
	            			<th class="adcontacttd title-color" colspan="1">평수</th>
	            			<td class="adcontacttd title-color" colspan="2">${dto.spacing }</td>
	            		</tr>
	            		
	            		<tr class="headtr">
	            			<th class="adcontacttd title-color" colspan="1">구조</th>
	            			<td class="adcontacttd title-color" colspan="2">${dto.roomType }</td>
	            		</tr>
	            		
	            		<tr class="headtr">
	            			<th class="adcontacttd title-color" colspan="1">입주가능일</th>
	            			<c:if test="${empty dto.occupancyDate }">
	            			<td class="adcontacttd title-color" colspan="2">즉시입주</td>
	            			</c:if>
	            			
	            			<c:if test="${not empty dto.occupancyDate }">
	            			<td class="adcontacttd title-color" colspan="2">${dto.occupancyDate }</td>
	            			</c:if>
	            		</tr>
	            		
	            	
	            	</table>
	                    	
	                    	
	               </div>
	                    	                 
	                    
	                    <div class="informcontent2">
	                    	<div class="inform2-1">상세설명</div>	                
	                    	<div class="inform2-3">${dto.content }</div>
	                    </div>
                                                                      
                        
                    </div>
                    <div style="clear:both;"></div>
                    
                    </c:forEach>
                   </c:if>
                <!-- property-box -->    
                </div>
                   
                   
                   
                   
                   
                <!-- boardcover -->    
                </div>
                
		
        <!-- container --> 
        </div>
            	


      
       
      <!-- footer -->
      <%@include file="/WEB-INF/views/inc/footer.jsp"%>


</div>
 
</body>
</html>