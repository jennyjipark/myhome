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
        height: 1000px;
        margin: 0 auto;
        letter-spacing: -.2px;
        min-height:100%;
		padding-bottom:100px;
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
    
    
    .matching-option {
    	border: 1px solid blue;
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
    	border: 1px solid blue;
    	width: 820px;
    	height: auto;
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
   	
   	.btn {
   		background-color: #f1aeae;
   		color: white;
   		outline: none !important;
   		font-family: 'NanumBarunGothic';
   		margin-right: 5px;
   	} 
   	
   	
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
   }
   
    
   #search-box {
   		border: 1px solid black;
   		width: 390px;
   		height: 60px;
   		margin: 10px 200px;
   		padding: 10px;
   }
   
   #search-text {
   		width: 300px;
   		outline: 0;
   		display: inline;
   
   }
   
   .temp {
	   	min-height: 35px;
	   	border: 1px solid black;
	   	padding: 5px;
   
   }
   
   .paging {
  		border: 1px solid blue;
  		width: 810px;
  		height: 80px;
  		padding: 5px 250px;

   }

	
	.pagination > li > .page-a {
		color: #202020;
	                                                                 
	}
	
	
	/* mypage css */
	
	.start {
		/* border: 1px solid black; */
		margin-top: 200px;
		margin-left: 85px;
		padding: 80px 100px;
		width: 1000px;
		height: 520px;
		background-color: rgb(245, 245, 245, .6);
		border-radius: 40px;
	
	}
	
	.mypage-title {
		/* border: 1px solid black; */
		margin-bottom: 20px;
	
	}
	
	.boardwrap {
		background-image: url('../image/8.jpg');
	}
	
	.mypage-box {
		/* border: 1px solid black; */
		border-radius: 30px;
		width: 350px;
		height: 120px;
		float: left;	
		font-family: 'NanumBarunGothic';
		margin-top: 30px;
		background-color: white;
		cursor: pointer;
	}
	
	.mypage-box:hover {
		background-color: #f1aeae;
		color: white;
	}
	
	.mypage-title {
		font-size: 30px;
		color: #202020;
		text-align: center;
		font-family: 'MaplestoryOTFLight';
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
		color: #f1aeae;
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
<%@include file="/WEB-INF/views/inc/bootstrap-header.jsp"%>
 
     <div class="container">
     
        <div class="boardcover">
            
		 
		 <!-- 리스트 -->
		 <div class="property-box">
		 	
       		<form action="" id="form1">
   
   			<!-- 시작 -->
        	<div class="start">
        		
        		<div class="mypage-title">마이페이지</div>
	       			<div class="mypage-box" id='box1' onclick="location.href='/Myhome_project/contractor/mypage-myproperty.do';">
	       				<div class="icon glyphicon glyphicon-upload" id="icon1"></div>
	       				<div class="desc">올린매물관리</div>
	       				<div class="desc2">내가 올린 매물을 확인할 수 있어요.</div>
	       			</div>
       				<div class="mypage-box" id='box2' onclick="location.href='/Myhome_project/contractor/mypage-matching1.do';">
       					<div class="icon glyphicon glyphicon-resize-small" id="icon2"></div>
       					<div class="desc">매칭매물관리</div>
       					<div class="desc2">나에게 들어온 매칭과 내가 보낸 매칭신청을 확인할 수 있어요.</div>
       				</div>
       				<div class="mypage-box" id='box3' onclick="location.href='/Myhome_project/contractor/mypage-matching2.do';">
       					<div class="icon glyphicon glyphicon-pencil" id="icon3"></div>
       					<div class="desc">전자계약관리</div>
       					<div class="desc2">전자계약서 승인 및 취소를 할 수 있어요.</div>
       				</div>
       				<div class="mypage-box" id='box4' onclick="location.href='/Myhome_project/contractor/mypage-info.do';">
       					<div class="icon glyphicon glyphicon-user" id="icon4"></div>
       					<div class="desc">회원정보수정</div>
       					<div class="desc2">회원정보를 수정할 수 있어요.</div>
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

<script>
	$("#box1").hover(function() {
		$("#icon1").css("color", "white");
		}, function() {
		$("#icon1").css("color", "#f1aeae");
	});
	
	$("#box2").hover(function() {
		$("#icon2").css("color", "white");
		}, function() {
		$("#icon2").css("color", "#f1aeae");
	});

	$("#box3").hover(function() {
		$("#icon3").css("color", "white");
		}, function() {
		$("#icon3").css("color", "#f1aeae");
	});
	
	$("#box4").hover(function() {
		$("#icon4").css("color", "white");
		}, function() {
		$("#icon4").css("color", "#f1aeae");
	});

</script>
 
</body>
</html>