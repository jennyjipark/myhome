<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::마이페이지</title>
<%@include file="/WEB-INF/views/inc/asset.jsp" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">
<link rel="stylesheet" href="/Myhome_project/css/contractor-mypage.css">



<style>
	.header {
		background-color : white;
	}
	
	.container {
        width: 1190px;
        height: 800px;
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
    	border-bottom: 1px solid #eaecef;
    	width: 400px;
    	height: 50px;
    	padding-bottom: 10px;
    	font-size: 24px;
    	font-family: 'MaplestoryOTFLight';
    	color: #202020;
    	
    }
    
    
   	
   	.btn {
   		background-color: #f1aeae;
   		color: white;
   		outline: none !important;
   		font-family: 'NanumBarunGothic';
   		margin-right: 5px;
   	} 
   	
   	
  
   
	
	/* mypage css */
	
	.start {
		border: 1px solid #f3f3f3;
	    margin-top: 170px;
	    margin-left: 85px;
	    padding: 80px 100px;
	    width: 1000px;
	    height: 480px;
	    box-shadow: 0px 5px 15px #e4e4e4;
	    border-radius: 30px;
	
	}
	
	.mypage-title {
		/* border: 1px solid black; */
		margin-bottom: 20px;
	
	}
	

	.mypage-box {
		/* border: 1px solid black; */
		border-radius: 30px;
		width: 350px;
		height: 120px;
		float: left;	
		font-family: 'NanumBarunGothic';
		margin-top: 30px;
		background-color: #f1aeae;
		cursor: pointer;
		color: white;
	}
	
	.mypage-box:hover {
		background-color: white;
		border: 1px solid #f1aeae;
		color: #202020;
	}
	
	.mypage-title {
		font-size: 36px;
		color: #f1aeae;
		text-align: center;
		font-family: 'MaplestoryOTFLight';
		/* border-bottom: 5px solid #f1aeae; */
		z-index: 1;
	}
	
	
	.mypage-type {
		font-size: 24px;
		color: #202020;
		text-align: center;
		font-family: 'NanumBarunGothic';
		margin-top: 60px;
	}
	
	#box1, #box3 {
		margin-right: 70px;
	}
	
	#box2, #box4 {
		margin-right: 0px;
		margin-left: 20px;
	}
	
	.icon {
		/* border: 1px solid black; */
		width: 70px;
		height: 70px;
		font-size: 4.5em;
		color: white;
		margin-top: 20px;
		margin-left: 20px;
		float: left;
		
	}
	
	.desc {
		/* border: 1px solid black; */
		width: 200px;
		margin-top: 20px;
		margin-left: 120px;
		font-size: 20px;
		font-weight: bold;
		font-family: 'NanumBarunGothic';
	}
	
	.desc2 {
		/* border: 1px solid black; */
		width: 200px;
		margin: 10px 120px;
		font-size: 16px;
	}
	
    
</style>


</head>
<body>
 
<div class="boardwrap">
 
 <!-- header -->
<%@include file="/WEB-INF/views/inc/bootstrap-header.jsp" %>
 
     <div class="container">
     
        <div class="boardcover">
            
		 
		 <!-- 리스트 -->
		 <div class="property-box">
		 
   
   			<!-- 시작 -->
        	<div class="start">
        		
        		<div class="mypage-title">마이홈 회원가입</div>
        		<div class="mypage-type"><span>가입을 원하는 유형을 선택해주세요.</span></div>
        		
	       			<div class="mypage-box" id='box1' onClick="location.href='/Myhome_project/member/RegisterUser.do'">
	       				<div class="icon glyphicon glyphicon-font" id="icon1"></div>
	       				<div class="desc" >일반회원</div>
	       				<div class="desc2">중개인을 통하여 방을 올릴 수 있어요.</div>
	       			</div>
       				<div class="mypage-box" id='box2' onClick="location.href='/Myhome_project/member/RegisterContractor.do'">
       					<div class="icon glyphicon glyphicon-bold" id="icon2"></div>
       					<div class="desc">중개인</div>
       					<div class="desc2">직접 매물 올리기, 임대인에게 매칭 신청을 할 수 있어요.</div>
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

<script>
	$("#box1").hover(function() {
		$("#icon1").css("color", "#f1aeae");
		}, function() {
		$("#icon1").css("color", "white");
	});
	
	$("#box2").hover(function() {
		$("#icon2").css("color", "#f1aeae");
		}, function() {
		$("#icon2").css("color", "white");
	});

	
	

</script>
 
</body>
</html>