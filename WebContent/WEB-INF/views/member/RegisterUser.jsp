<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::일반회원 회원가입</title>
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
    
    
   	
   	.btn {
   		background-color: #f1aeae;
   		color: white;
   		outline: none !important;
   		font-family: 'NanumBarunGothic';
   		margin-right: 5px;
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
	
	#userTel1 {
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
 
 
 <!-- 관심지역 스크립트 -->
  <script>
          var midArray = [];
         <c:forEach var="middle" items="${middle}">
            midArray.push({"seq":"${middle.seq}", "mLocation":"${middle.mLocation}", "location":"${middle.location}"});
         </c:forEach>
         
         var endArray = [];
         <c:forEach var="end" items="${end}">
            endArray.push({"seq":"${end.seq}", "mLocation":"${end.mLocation}", "location":"${end.location}"});
         </c:forEach> 
         
         
         $(function() {
            $("#frontsel").change(function(e) {
               var frontsel = $(this).val();
               midCreate(frontsel);
            });
            midCreate($("#frontsel").val());
         });
         
         function midCreate(frontsel) {
            $("#middlesel").children().remove();
            var html = "";
            $(midArray).each(function(i, elem) {
               //console.log(frontsel + " == " + elem.mseq);
               if(frontsel == elem.mLocation) {
                     html += "<option value='" + elem.location + "'>" + elem.location + "</option>";
                  }
               });
            $("#middlesel").html(html);
            endCreate($("#middlesel").val());
         }
         
         $(function() {
            $("#middlesel").change(function(e) {
               var middlesel = $(this).val();
               endCreate(middlesel);
            });
            endCreate($("#middlesel").val());
         });
            
         function endCreate(middlesel) {
            $("#endsel").children().remove();
            var html = "";
            $(endArray).each(function(i, elem) {
               if(middlesel == elem.mLocation) {
                  html += "<option value='" + elem.location + "'>" + elem.location + "</option>";
               }
            });
            $("#endsel").html(html);
         } 
         
      </script>
		
		
<div class="boardwrap">
 
 <!-- header -->
<%@include file="/WEB-INF/views/inc/bootstrap-header.jsp" %>
 
     <div class="container">
        <div class="boardcover">
            
    
		<!-- 리스트 -->
		<div class="property-box">
			<div class="board-name">일반회원 회원가입</div>
		 	
		 	
  		<form method="post" id="form1" action="/Myhome_project/member/RegisterUserOk.do">
   		
   		<!-- 시작 -->
 		
        <div class="start">  
           
			<span>아이디</span>
	       <input type="text" class="form-control form-weight readonly" id="userid" name="id"> 
			
			<span>이름</span>
			<input type="text" class="form-control form-weight readonly" id="username" name="name">
			
			<span>닉네임</span> 			
			<input type="text" class="form-control form-weight" id="nickname" name="nickname">
			<!-- <span class="desc">닉네임이 중복입니다.</span> -->
			
		
      		<span>주민번호</span> 
			<input type="text" class="form-control ssn readonly" id="ssn1" maxlength=6 name="ssn"> -
			<input type="text" class="form-control ssn readonly" id="ssn2" maxlength=7 name="ssn"> 
			
			<span>비밀번호</span> 
	       <input type="password" class="form-control form-weight" id="" name="password">
			
			<span>비밀번호확인</span>
			<input type="password" class="form-control form-weight" id="search-text" name="repassword">
			
			<span>주소</span>
			<input type="text" class="form-control search-text" name="address">
			
			<span>전화번호</span> 
			<input type="text" class="form-control tel" id="userTel1" maxlength=3 name="tel1">-
			<input type="text" class="form-control tel" id="userTel2" maxlength=4 name="tel2">-
			<input type="text" class="form-control tel" id="userTel3" maxlength=4 name="tel3">
			
			<span>이메일</span>
			<input type="text" class="form-control search-text" name="email">
			
			 <span>관심매물</span>
         	<select class="form-control multiple">
            	<option val="1">원룸</option>
           		<option val="2">투룸</option>
            	<option val="3">오피스텔</option>
         	</select>
			
			
			<span><label for="siCode2">관심지역</label></span>
			<select title="시/도 선택"  id="frontsel" name="frontsel" class="form-control multiple" id="from" style="width:250px">
				<c:forEach var="front" items="${front }" varStatus="status">
					<option value="${front.location }">${front.location }</option>
				</c:forEach> 
			</select>		
			
			<select title="시/군/구 선택"  id="middlesel" name="middlesel" class="form-control multiple" id="middle" style="width:250px">
				
			</select>		
			
			<select title="동/읍/면 선택"  id="endsel" name="endsel" class="form-control multiple" id="end" style="width:250px">
			
			</select>
       		
       		
       		
			<span>알람</span>
			 <select class="form-control multiple">
            	<option val="1">On</option>
            	<option val="0">Off</option>
         	</select>
			
			
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