<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::로그인</title>
<%@include file="/WEB-INF/views/inc/asset.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">
<link rel="stylesheet" href="/Myhome_project/css/contractor-mypage.css">
<link rel="stylesheet" href="/Myhome_project/css/myproperty.css">



<style>
	.header {
		background-color : white;
	}
	
	.property-box {
		/* border: 1px solid blue; */
	    padding-top: 20px;
	    float: left;
	    margin-left: 50px;
	    width: 900px;
	    height: auto;
	    margin-bottom: 50px;
	    /* padding-right: 150px; */
	    padding-left: 320px;
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
    	border-left: 5px solid #f1aeae;
	    width: 810px;
	    /* height: 50px; */
	    padding-left: 10px;
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
   	
   	.btn:hover {
   		color: white; 
   	}
   	
    
   
   .search-text {
   		width: 300px;
   		outline: 0;
   		display: inline;
   
   }
   

	/* Auth css */
	
	.start {
		/* border: 1px solid #e2e2e2; */
	    height: 380px;
	    margin-top: 200px;
	    padding: 50px 40px;
	    width: 380px;
	    border-radius: 30px;
	    /* margin-left: 60px; */
	    box-shadow: 0px 5px 15px #e4e4e4;
	
	}
	
	
	.start > input {
		margin-bottom: 20px;
	} 
	
	
	.form-weight {
		width: 300px !important;
	}
	
	
	#btn-login {
		margin-left: 120px;
		display: inline;
		margin-top: 20px;
	}
	
    
    .login-title {
    	/* border: 1px solid black; */
	    width: 300px;
	    height: 60px;
	    margin-bottom: 30px;
	    padding-left: 10px;
	    font-size: 24px;
	    font-family: 'MaplestoryOTFLight';
	    color: #f1aeae;
    	
    }
    
    .login-title > span {
    	display: block;
    	float: left;
    	margin-left: 20px;
   	 	margin-top: 10px;
    }
    
    
    .search {
    	/* border: 1px solid black; */
    	width: 300px;
    	height: 20px;
    	text-align: center;
    	font-family: 'NanumBarunGothic';
    	margin-top: -10px;
    }
    
    .search > a {
    	color: #202020;
    	
    }
    
    .search > span {
    	margin: 0px 10px;
    	color: #cacaca;
    }
    
    .logo {
    	/* border: 1px solid black; */
    	width: 50px;
    	height: 50px;
    	float: left;
    	margin-left: 30px;
    	background-image: url('../image/logo/5.png');
    	background-size: cover;
        background-position: 50% 50%;
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
		 	
  		<form method="post" id="form1" action="/Myhome_project/member/login.do">
   		
   		<!-- 시작 -->
 		
        <div class="start">  
           	<div class="login-title">
           		<div class="logo"></div>
           		<span>마이홈 로그인</span>
           	</div>
		    	<input type="text" class="form-control form-weight readonly" id="id" name="id" placeholder="아이디" required> 
		    	<input type="password" class="form-control form-weight readonly" id="pw" name="password" placeholder="패스워드" required> 
				
			<div class="search">
				<a href="/Myhome_project/member/searchid.do">아이디 찾기</a>
				<span>|</span>              
				<a href="/Myhome_project/member/searchpw.do">비밀번호 찾기</a>
			</div>	
				
				<input type="submit" class="btn btn-outline-secondary" type="button" id="btn-login" value="로그인">
				
				<!-- 테스트용 -->
				<!-- <button type="button" class="btn" onclick="test('ccu7678','ccu7678nt');">이제위</button> -->
	
       		
       	</div>
       		
       	</form>
       
        
          
          
          <!-- property-box -->
          </div>
             
             
             
             
             
    <!-- container -->        
	</div>  
   
    
  
   </div>
           
            
</div>

<script>
    
		function test(id, pw) {
			$("#id").val(id);
			$("#pw").val(pw);
			$("#login_form").submit();//에뮬레이터 함수
		}
	
</script>


 
<!-- footer -->
<%@include file="/WEB-INF/views/inc/footer.jsp" %>
 
</body>
</html>