<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::중개인 회원가입</title>
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
   
   .search-text {
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
	
	
	/* info css */
	
	.start {
		/* border: 1px solid black; */
		height: auto;
		margin-top: 100px;
		padding: 0px 240px;
		width: 800px;
		margin-left: 60px;
	
	}
	
	.start > span {
		/* border: 1px solid black; */
		display: block;
		width: 250px;
		font-weight: bold;
	}
	
	.start > .desc {
		display: block;
		width: 200px;
		font-weight: bold;
		color: #pink;
	}
	
	.start > input {
		margin-bottom: 40px;
		dispaly: block;
	} 
	
	#nickname {
		margin-bottom: 2px;
	}
	
	.start > span > input:nth-child(1) {
		margin-left: 20px;
	}
	
	.form-weight {
		width: 300px !important;
	}
	
	.tel {
		width: 80px !important;
		display: inline !important;
		margin: 0px 10px;
	}
	
	#tel1, #businessnum1 {
		margin-left: 0px;
	}
	
	.ssn {
		width: 135px !important;
		display: inline !important;
		margin: 0px 10px;
	}
	
	#ssn1 {
		margin-left: 0px;
	}
	
	.multiple {
		width: 300px !important; 
	}
	
	.form-control {
		margin-bottom: 20px !important;
	}
	
	.readonly {
		cursor: auto !important;
	}
	
	#btn-register {
		margin-left: 100px;
		display: inline;
		margin-top: 30px;
	}
	
	#btn-out {
		background-color: white;
		border: 1px solid #f1aeae;
		color: #202020;
		margin-top: 30px;
	}
	
	#myinfo {
    	color: #f1acac;
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
			<div class="board-name">중개인 회원가입</div>
		 	
		 	
  		<form method="post" id="form1" action="/Myhome_project/member/RegisterContractorOk.do">
   		
   		<!-- 시작 -->
 		<!-- 중개인은 닉네임이 없음 -->
 		
        <div class="start">     
		       <span>아이디</span>
		       <input type="text" class="form-control form-weight readonly" id="id" name="id"> 
				
				<span>이름</span> 			
				<input type="text" class="form-control form-weight readonly" id="name" name="name">
				
				<span>공인중개소</span>
				<input type="text" class="form-control form-weight readonly" id="companyname" name="companyname">
				
				<span>사업자등록번호</span> 			
				<input type="text" class="form-control tel" id="businessnum1" maxlength=3 name="businessnum1">-
				<input type="text" class="form-control tel" id="businessnum2" maxlength=2 name="businessnum2">-
				<input type="text" class="form-control tel" id="businessnum3" maxlength=5 name="businessnum3">
				
				<span>비밀번호</span> 
		       	<input type="password" class="form-control form-weight" id="password" name="password">
				
				<span>비밀번호확인</span>
				<input type="password" class="form-control form-weight search-text"" id="repassword" name="repassword">
				
				<span>주소</span>
				<input type="text" class="form-control search-text" id="address" name="address">
				
				<span>전화번호</span> 
				<input type="text" class="form-control tel" id="tel1" maxlength=3 name="tel1">-
				<input type="text" class="form-control tel" id="tel2" maxlength=4 name="tel2">-
				<input type="text" class="form-control tel" id="tel3" maxlength=4 name="tel3">
				
				<span>이메일</span>
				<input type="text" class="form-control search-text"" id=" name="email">
			
			<input type="submit" class="btn btn-outline-secondary" type="button" id="btn-register" value="회원가입">
       		
       		
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