<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::채팅</title>

<%@include file="/WEB-INF/views/inc/asset.jsp" %>
<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">

<style>
	#chatmode {
		border: 1px solid white;
		background-color: white;
		border-radius: 15px;
		width: 400px;
    	height: 600px;
		position: fixed;
		right: 20px;
		bottom: 20px;
		box-shadow: 0px 1px 10px #c5c3c3;
	}
	
	
	
	#chatstart {
	/* 	border: 1px solid white; */
		border-radius: 15px 15px 0px 0px;
		font-size: 20px;
		font-weight: bold;
		color: #202020;
		width: 400px;
		height: 60px;
		background-color: #f1aeae; 
		padding: 0px 20px;
		box-shadow: 0px 5px 8px #b9b9b9;
		margin-left: -3px;
		
				
	}
	
	
	#chat-logo {
		/* border: 1px solid black; */
		width: 50px;
		height: 50px;
		float: left;
		background-image: url('../image/logo/5_1.png');
		background-size: cover;
    	background-position: 50% 50%;
    	margin-top: 5px;
    	float: left;
		
	}
	
	#chat-title {
		/* border: 1px solid black; */
		width: 100px;
		margin-left: 20px;
		margin-top: 20px;
		float: left;
		font-family: 'MaplestoryOTFLight';
		font-size: 20px;
		color: white;
		
	}
	
	#chat-out {
		/* border: 1px solid black; */
		width: 16px;
		height: 16px;
		float: right; 
		margin-top: 20px;
		margin-left: 80px;
		background-image: url('../image/out_white.png');
		background-size: cover;
    	background-position: 50% 50%;
    	cursor: pointer;
		
	}
	
	
	#chat-out > span {
		font-size: 10px;
	}
	
	
	.chat-list {
		border: 1px solid #e0e0e0;
	    width: 365px;
	    height: 65px;
	    background-color: white;
	    box-shadow: 0px 5px 15px #dadada;
	    /* margin-top: 20px; */
	    padding: 5px 15px;
	    font-size: 14px;
	    cursor: pointer;
	    position: absolute;
	    border-radius: 10px;
	    top: 80px;
	}
	
	

	.send {
		/* border: 1px solid black; */
		font-weight: bold;
		font-size: 14px;
		float: left;
		
	}
	
	.date {
		/* border: 1px solid black; */
		margin-left: 50px;
		text-align: right;
		font-size: 13px;
	}
	
	/* 미리보기 창 */
	.send-content {
		/* border: 1px solid black; */
		margin-top: 10px;
		height: 30px;
		font-size: 14px;
	}
	
	/* 채팅상세 */
	#chat-box {
		border: 1px solid #e0e0e0;
		width: 380px;
		height: 380px;
		margin: 10px;
		padding: 5px;
		background-color: white;
		font-family: 'NanumBarunGothic', sans-serif;
		position: absolute;
		top: 70px;
		visibility: hidden;
		overflow: auto;
	}
	
	.send-date {
		/* border: 1px solid black; */
		min-width: 240px;
		min-height: 55px;
		
	}
	
	.sender, .fromme {
		/* border: 1px solid black; */
		font-weight: bold;
		font-size: 14px;
		
	}
	
	/* 텍스트창 길이에 맞게 따라가야 함 */
	.sendtime {
		/* border: 1px solid black; */
		margin-left: 5px;
		margin-top: 2px;
		width: 80px;
		font-size: 11px;
		color: #868686;
	}
	
	/* 텍스트 창
	텍스트 길이에 따라 width, height auto
	 */
	.send-content2 {
		border: 1px solid #f1aeae;
		margin-top: 10px;
		width: 200px;
		min-height: 20px;
		padding: 5px 10px; 
		font-size: 14px;
		border-radius: 10px;
		color: #202020;
		border-radius: 10px;
		
		
	}
	
	
	/* 텍스트창 & 보내기 버튼 */
	
	.text-submit {
		/* border: 1px solid black; */
		width: 380px;
		height: 100px;
		position: relative;
		top: 420px;
		visibility: hidden;
	}
	
	#chat-reply {
		border: 1px solid #e0e0e0;
		width: 290px;
		height: 105px;
		margin-right: 15px;
    	margin-left: 10px;
		border-radius: 0px 0px 0px 10px;
		background-color: white;
		font-family: 'NanumBarunGothic', sans-serif;
		font-size: 14px;
		padding: 5px;
		outline: none;
		/* visibility: hidden; */
	
	}
	
	#chat-submit {
		/* border: 1px solid black; */
		border: none;
		width: 55px;
		height: 105px;
		padding: 5px;
		border-radius: 0px 0px 10px 0px;
		outline: none;
		background-color: #f1aeae;
		color: white;
		font-family: 'NanumBarunGothic', sans-serif;
		font-weight: bold;
		cursor: pointer;
	}
	
	#chat-submit:active {
		border: 1px solid #f1aeae;
		background-color: white;
		color: #f1aeae;
	}
	
	#send-fromme {
		text-align: right;
		margin-top: 10px;
	}
	
	.send-content3 {
		border: 1px solid #f1aeae;
		margin-top: 10px;
		width: 100px;
		min-height: 20px;
		padding: 5px 10px; 
		font-size: 14px;
		border-radius: 10px;
		color: white;
		border-radius: 10px;
		background-color: #f1aeae;
		float: right;
		
	}
	
	.chat-out2 {
		z-index: 999;
	    width: 300px;
	    border-radius: 20px;
	    height: 110px;
	    box-shadow: 0px 5px 15px #e0e0e0;
	    /* border: 1px solid #e4e4e4; */
	    padding: 20px;
	    text-align: center;
	    position: relative;
	   	left: 90px;
    	top: 260px;
    	visibility: hidden;
    	background-color: white;
	}
	
	.chat-out2 > span {
		color: #202020;
		display: block;
		margin-bottom: 20px;
	}
	
	.btn {
		background-color: #f1aeae;
	    color: white;
	    font-family: 'NanumBarunGothic';
	    outline: none;
	    margin-right: 10px;
	    border: 0px;
	}
	
	.none-outline:active {
		outline: none !important;
		color: white;
	}
	
	.none-outline:hover {
		outline: none !important;
		color: #f1aeae;
		background-color: white;
		border: 1px solid #f1aeae;
	}
	
	
</style>
</head>
<body>
	
	<!-- 채팅창 -->
	<div id="chatmode">
		
		<!-- 채팅헤더 -->
   		<div id="chatstart">
   			<div id="chat-logo"></div>
   			<div id="chat-title">채팅하기</div>
   			<div class="icon-out" id="chat-out"></div>
   		</div>
   		
   		<!-- 채팅리스트 -->
   		
   		
   		<!-- 채팅 상세 -->
		<div id="chat-box">
		</div>
		
			<!-- 텍스트 보내기  -->
		<div class="text-submit">
	    	<input type="text" id="chat-reply">
	   		<input type="submit" id="chat-submit" value="보내기">
	   	</div>	   
		
   	</div>
   		
   
   	<div class="chat-out2">
   		<span>채팅을 종료하시겠어요?</span>
   		<input type="button" class="btn none-outline" id="yes" value="확인" onclick="window.close();">
   		<input type="button" class="btn none-outline" id="no" value="닫기">
   	</div>
   	
   
   


	
    
    <script>

    $(document).ready(function() {
    	
    	$.ajax({
			type: "GET",
			url: "/Myhome_project/member/chatlistdata.do",
			
			success: function(result) {

				var list = result.split(',');
				var html = "";
				
				for(var i = 0; i<list.length-1; i+=2) {	//-1은 마지막까지 ,가붙어서 해주는것
					html += "<div class='chat-list' value='" + list[i] + "'>";
					html += "<div class='send'>";	//seqTheHost 알기위해서 name에 붙혀준다
					html += list[i+1];
					html += "</div>";
					html += "</div>";
				}
				
				$("#chatstart").append(html);
				$(".chat-list").css("visibility", "visible");
			
				const url = "ws://localhost:8090/Myhome_project/chatserver";
				let ws;
				
				/* 채팅 상세 클릭 시 리스트 hidden, 텍스트&submit 보이기 */
		    	$(".chat-list").click(function() {
		    		
		    		$(".chat-list").css("visibility", "hidden");
		    		$("#chat-box").css("visibility", "visible");
		    		var html = "";
		    		var text= "";
		    		
					$.ajax({	//채팅내용 불러옴
						
						type: "GET",
						url: "/Myhome_project/member/chatdata.do",
						data: "seqTheOther=" + $(this).attr("value"),
						
						success: function(result) {
							
		 					text = result.split(',');
							
							for(var i = 0; i<text.length-1; i++) {	
								html += "<div class='send-content2'>";
								html += text[i];
								html += "</div>";
							}
							
							$("#chat-box").append(html);
							$("#chat-box").css("visibility", "visible");
							$(".text-submit").css("visibility", "visible");
							
							$("#chat-box").scrollTop($("#chat-box").prop("scrollHeight"));
						},
						error: function(a,b,c) {
							console.log(a,b,c);
						}
					});	// chat-list ajax
					
					//채팅
					ws = new WebSocket(url);
					
					ws.onopen = function(evt) {
						print("상대방이 입장했습니다.");
					};
					
					ws.onmessage = function(evt) {
						console.log("서버에서 클라이언트에게 메시지를 전송했습니다.");
						console.log(evt.data);
						
					};
					
					ws.onclose = function(evt) {
						print("상대방이 퇴장했습니다");
					};
					
					ws.onerror = function(evt) {
						console.log(evt);
					};
					
					$("#chat-reply").keyup(function() {
						
						//서버에 메시지 보내기
						//강아지#안녕하세요.
						if (event.keyCode == 13) {
							ws.send($("#chat-reply").val());
							
							print($("#chat-reply").val());
							
							$("#chat-reply").val("");
							$("#chat-reply").focus();
							
							//스크롤바를 가장 밑으로 내려라
							//$("#output").scrollTop($("#output").prop("scrollHeight"));
						}
						
					});
					
				});	//chat-list
			},
			error: function(a,b,c) {
				console.log(a,b,c);
			}
		});	//chat ajax
    })
    
			
			
		
		
		/* 나가기 클릭 시 hidden */
    	/* $("#chat-out").click(function() {
    		ws.close();
			$("#chatmode").css("visibility", "hidden");
			$("#chat-box").css("visibility", "hidden");
			$(".text-submit").css("visibility", "hidden");
			$(".chat-list").css("visibility", "hidden");
		}); */
		
		
		$("#chat-out").click(function() {
			$(".chat-out2").css("visibility", "visible");
			$("#chatmode").css("z-index", "-1");
		})
		
		$("#yes").click(function() {
			ws.close();
		})
		
		$("#no").click(function() {
			$(".chat-out2").css("visibility", "hidden");
			$("#chatmode").css("z-index", "1");
		})
		
		
		function print(msg) {
			
			let html = "";
			
			html += "<div class='send-content2'>";
			html += msg;
			html += "</div>";
			
			$("#chat-box").append(html);
			
		}
		
		

    	
    </script>
	
	
</body>
</html>