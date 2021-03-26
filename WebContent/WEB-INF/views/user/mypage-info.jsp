<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%


%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::회원정보수정</title>
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
		border: 0px;
		border-right: 1px solid #DBDCE0;
    	border-left: 1px solid #DBDCE0;
		margin-top: 100px;
		z-index: -1;
    }
    
    .board-name {
    	border-bottom: 1px solid #eaecef;
    	width: 810px;
    	height: 50px;
    	padding-bottom: 10px;
    	font-size: 24px;
    	font-family: 'NanumBarunGothic';
    	color: #202020;
    	margin-bottom: 20px;
    	
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
	
	
	/* info css */
	
	.start {
		/* border: 1px solid black; */
		height: auto;
		margin-top: 40px;
		padding: 0px 240px;
		width: 800px;
	
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
	
	#tel1 {
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
	
	#btn-edit {
		margin-left: 70px;
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
		<%@include file="/WEB-INF/views/inc/bootstrap-header.jsp"%>
 	
 	<!-- 관심지역 select > option 넣기 -->
 	
 	<script>
 		$(document).ready(function(){
 			$("#nickname").change(function () {
 	 			var nick = $("#nickname").val();
 	 			window.open("/Myhome_project/user/nicknamecheck.do?nickname="+nick, "중복검사","width = 500, height = 500")
 	 			
 	 		});
 	 		
 	 		$("#password1").change(function () {
 	 			$("#password2").attr("readonly",false)
 	 		})
 	 		
 	 		$("#password2").change(function () {
 	 			if ($("#password2").val()!=$("#password1").val()) {
 	 				alert("비밀번호가 일치하지 않습니다.");
 	 				$("#password1").val('');
 	 				$("#password2").val('');
 	 				$("#password2").attr("readonly",true)
 	 				$("#password1").focus();
 	 			} else {
 	 				alert("비밀번호가 일치합니다!");
 	 			}
 	 		});
 	 		
 	 		 $("#frontsel").change(function(e) {
			      var frontsel = $(this).val();
			      midCreate(frontsel);
			   });
			   //midCreate($("#frontsel").val());
			   
		   $("#middlesel").change(function(e) {
				var middlesel = $(this).val();
				endCreate(middlesel);
				
			});
			//endCreate($("#middlesel").val());
		   midCreate($("#frontsel").val());
		   endCreate($("#middlesel").val());
 		});
 	
 	
 			var midArray = [];
			<c:forEach var="middle" items="${middle}">
			   midArray.push({"seq":"${middle.seq}", "mLocation":"${middle.mLocation}", "location":"${middle.location}"});
			</c:forEach>
			
			var endArray = [];
			<c:forEach var="end" items="${end}">
				endArray.push({"seq":"${end.seq}", "mLocation":"${end.mLocation}", "location":"${end.location}"});
			</c:forEach> 
			
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
		
 	
     <div class="container">
     <%@include file="/WEB-INF/views/user/nav.jsp" %>
        <div class="boardcover">
            
		 
		 <!-- 리스트 -->
		 <div class="property-box">
		 	<div class="board-name">회원정보수정</div>
		 	
		 	
       <form method="POST" action="/Myhome_project/user/mypageinfo.do" id="form1">
   
   		<!-- 시작 -->
        <div class="start">
        	
	       	<span>아이디</span>
	       	<input type="text" class="form-control form-weight readonly" id="id" name="id" readonly value="${dto.id}"> 
			
			<span>이름</span>
			<input type="text" class="form-control form-weight readonly" id="name" name="name" readonly value="${dto.name}">
			
			<span>닉네임</span> 			
			<input type="text" class="form-control form-weight" id="nickname" name="nickname" value="${dto.nickname}">
			
			<span class="desc" id="desc" style="display: none;"></span>
			
					
      		<span>주민번호</span> 
			<input type="text" class="form-control ssn readonly" id="ssn1" name="ssn1" maxlength=6 readonly value="${idnumber[0]}"> -
			<input type="text" class="form-control ssn readonly" id="ssn2" name="ssn2" maxlength=7 readonly value="${idnumber[1]}"> 
			
			<span>비밀번호</span> 
	       	<input type="password" class="form-control form-weight" id="password1" name="password1" required>
			
			<span>비밀번호확인</span>
			<input type="password" class="form-control form-weight" id="password2" name="password2" required readonly>
			
			<span>주소</span>
			<input type="text" class="form-control" id="address" name="address" value="${dto.address}" required>
			
			<span>전화번호</span> 
			<input type="text" class="form-control tel" id="phonenumber1" name="phonenumber1" maxlength=3 value="${phonenumber[0]}" required>-
			<input type="text" class="form-control tel" id="phonenumber2" name="phonenumber2" maxlength=4 value="${phonenumber[1]}" required>-
			<input type="text" class="form-control tel" id="phonenumber3" name="phonenumber3" maxlength=4 value="${phonenumber[2]}" required>
			
			<span>이메일</span>
			<input type="email" class="form-control" id="email" name="email" value="${dto.email}" required>
			
			 <span>관심매물</span>
			<select class="form-control multiple" id="interestroomtype" name="interestroomtype">
			<c:if test="${dto.interestroomtype eq '원룸'}">
				<option val="1" selected>원룸</option>
				<option val="2">투룸</option>
				<option val="3">오피스텔</option>
			</c:if>
			<c:if test="${dto.interestroomtype eq '투룸'}">
				<option val="1">원룸</option>
				<option val="2" selected>투룸</option>
				<option val="3">오피스텔</option>
			</c:if>
			<c:if test="${dto.interestroomtype eq '오피스텔'}">
				<option val="1">원룸</option>
				<option val="2">투룸</option>
				<option val="3" selected>오피스텔</option>
			</c:if>
			</select>
			
			
			<span><label for="siCode2">관심지역</label></span>
			<!-- <select title="시/도 선택"  name="city1" onchange="javascript:changeAreaList(1, this);" class="form-control multiple" id="city1" style="width:250px">
				<option>시/도 선택</option>
				<option value="11" title="서울특별시" >서울특별시</option>
				<option value="42" title="강원도" >강원도</option>
				<option value="41" title="경기도">경기도</option>
				<option value="48" title="경상남도" >경상남도</option>
				<option value="47" title="경상북도" >경상북도</option>
				<option value="46" title="전라남도" >전라남도</option>
				<option value="45" title="전라북도" >전라북도</option>
				<option value="44" title="충청남도" >충청남도</option>
				<option value="43" title="충청북도" >충청북도</option>
				<option value="29" title="광주광역시" >광주광역시</option>
				<option value="27" title="대구광역시" >대구광역시</option>
				<option value="30" title="대전광역시" >대전광역시</option>
				<option value="26" title="부산광역시" >부산광역시</option>
				<option value="31" title="울산광역시" >울산광역시</option>
				<option value="28" title="인천광역시" >인천광역시</option>
				<option value="36" title="세종특별자치시" >세종특별자치시</option>
				<option value="50" title="제주특별자치도" >제주특별자치도</option>
			</select>		
			
			임시
			<select title="시/군/구 선택"  name="city1" onchange="javascript:changeAreaList(1, this);" class="form-control multiple" id="city1" style="width:250px">
				<option>시/군/구</option>
				<option value="11" title="서울특별시" >서울특별시</option>
				<option value="42" title="강원도" >강원도</option>
				<option value="41" title="경기도">경기도</option>
				<option value="48" title="경상남도" >경상남도</option>
				<option value="47" title="경상북도" >경상북도</option>
				<option value="46" title="전라남도" >전라남도</option>
			</select>		
			
			임시
			<select title="동/읍/면 선택"  name="city1" onchange="javascript:changeAreaList(1, this);" class="form-control multiple" id="city1" style="width:250px">
				<option>동/읍/면</option>
				<option value="11" title="서울특별시" >서울특별시</option>
				<option value="42" title="강원도" >강원도</option>
				<option value="41" title="경기도">경기도</option>
				<option value="48" title="경상남도" >경상남도</option>
				<option value="47" title="경상북도" >경상북도</option>
				<option value="46" title="전라남도" >전라남도</option>
			</select> -->
			
			선호하는 지역(시)<br>
					<select id="frontsel" name="frontsel" class="form-control multiple" style="width:250px">
	 					<c:forEach var="front" items="${front }" varStatus="status">
							<c:if test="${interestlocation[0]!=front.location}">
								<option value="${front.location }">${front.location }</option>
							</c:if>
							<c:if test="${interestlocation[0]==front.location}">
								<option value="${front.location }" selected>${front.location }</option>
							</c:if>
						</c:forEach> 
					</select>
					<br>
					선호하는 지역(구)<br>
					<select id="middlesel" name="middlesel" class="form-control multiple" style="width:250px">
					</select>
					<br>
					선호하는 지역(동)<br>
					<select id="endsel" name="endsel" class="form-control multiple" style="width:250px">
					</select>
					
			 <span>알람</span>
				<select class="form-control multiple" id="alarm" name="alarm">
					<c:if test="${dto.alarm==1}">
							<option value="1" selected>On</option>
							<option value="0">Off</option>
					</c:if>
					<c:if test="${dto.alarm==0}">
							<option value="1">On</option>
							<option value="0" selected>Off</option>
					</c:if>
				</select>
			
			
			<button class="btn btn-outline-secondary" type="submit" id="btn-edit">수정하기</button>
			<button class="btn btn-outline-secondary" type="button" id="btn-out" onclick="location.href='/Myhome_project/user/removeuser.do'">회원탈퇴</button>
       		
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