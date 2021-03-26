<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::로그인</title>
<%@include file="/WEB-INF/views/inc/asset.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">
<link rel="stylesheet" href="/Myhome_project/css/contractor-mypage.css">
<link rel="stylesheet" href="/Myhome_project/css/myproperty.css">



<style>
        .search_id_form {
        	margin-left: 400px;
        	margin-top: 230px;
        }
        
        
        .search {
        	margin-left: -250px;
        	
        	margin-top: 20px;
        }
         
        #phone_area, #email_area {
        	display: none;
        }
        
        #r_phone, #r_email {
        	margin-bottom: 20px;
        }
        
        .name, .phone, .email {
        	width : 310px;
        	height: 50px;
        	margin-bottom: 20px;
        }
        
        #output {
        	margin-left: 400px;
        }
</style>

</head>
<body>



	<div class="boardwrap">

		<!-- header -->
		<%@include file="/WEB-INF/views/inc/bootstrap-header.jsp"%>

		<div class="container">
				<!-- 리스트 -->
				<div class="property-box">
					<form class="search_id_form" method="get" action="/jsp/web/search_id_ok.jsp">
						<input type="radio" id="r_phone" name="certification" value="phone">회원정보에 등록한 휴대전화로 인증<br>
						<div id="phone_area">
							<label for="name">아이디&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
							<input type="text" class="name" name="name"><br> 
							<label for="name">휴대전화</label> 
							<input type="text" class="phone" name="phone" placeholder=" -포함 입력"><br>
						</div>
						<input type="radio" id="r_email" name="certification" value="email">회원정보에 등록한 이메일주소로 인증<br>
						<div id="email_area">
							<label for="name">아이디&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
							<input type="text" class="name" name="name"><br> 
							<label for="name">이메일 주소</label> 
							<input type="text" class="email" name="email"><br>
						</div>
						<input type="button" id="searchBtn" value="검색">
					</form>
					<span id="output"></span>
					<!-- property-box -->
			<!-- container -->
			</div>



		</div>


	</div>

	<script>
    
	 	var sel = document.getElementsByName("certification");
	 	var phone_area = document.getElementById("phone_area");
	 	var email_area = document.getElementById("email_area");
	 	
		for(let i=0; i<sel.length; i++) {
			sel[i].onclick = function() {
				if(sel[i].value == "phone") {
					$("#phone_area").show();
					$("#email_area").hide();
				} 
				else {
					$("#phone_area").hide();
					$("#email_area").show();
				}
			}
	 	};
	 	
	 	$("#searchBtn").click(function() {
	 		
	 		//$("input[name='sel1']:checked").val();
	 		var type = $("input[name='certification']:checked").val();
	 		var name = $(".name").val();
	 		var email = $(".email").val();
	 		var phone = $(".phone").val();
	 		
	 		
 	 		$.ajax({	

				type: "POST",
				url: "/Myhome_project/member/searchpwdata.do",
				data: "type=" + type + "&name=" + name +"&email=" + email + "&phone=" + phone,
				//data: "type=" + type,
				
				success: function(pw) {
					
					if(pw != "")
						$("#output").text(pw);
					else
						$("#output").text("일치한 정보가 존재하지 않습니다.");
					
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			});	// chat-list ajax */
	 	});
		
	</script>



	<!-- footer -->
	<%@include file="/WEB-INF/views/inc/footer.jsp"%>

</body>
</html>