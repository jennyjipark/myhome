<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%


%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyHome::방올리기</title>
<%@include file="/WEB-INF/views/inc/asset.jsp" %>
<link rel="stylesheet" href="/Myhome_project/css/template.css">
<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">
<!-- <link rel="stylesheet" href="/Myhome_project/css/boarduserver.css"> -->

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="/Myhome_project/css/nav.css">


<link rel="stylesheet" href="/Myhome_project/css/jquery-ui.css">
<script src="/Myhome_project/js/jquery-ui.js"></script>

<!-- 부트스트랩 사용가능한 템플릿 -->

<style>
.boardwrap {
	height: auto;
	min-height: 100%;
}

.container {
	border: 0px;
	border-right: 1px solid #DBDCE0;
    border-left: 1px solid #DBDCE0;
	font-family: 'NanumBarunGothic', sans-serif;
	font-size: 16px;
}

#title {
	text-align: left;
	border-left: 5px solid #F1AEAE;
	font-family: 'MaplestoryOTFLight';
	font-size: 24px;
	float: left;
	width: 200px;
	margin-left: 100px;
	padding-left: 20px;
	margin-top: 96px;
	/* border: 1px solid black; */
}

#explain {
	color: #aaa;
	text-align: right;
	
	margin-top: 120px;
	margin-right: 25px;
	/* margin-bottom: 24px; */
	/* border:1px solid black; */
}


/* header css 시작*/

header {
    border-bottom: 1px solid #DBDCE0;
    width: 100%;
    height: 100px;
    margin: 0px auto;
    position: fixed;
    left: 0px;
    top: 0px;
 	z-index: 999;
 	
}

.header {
	background-color : white;
}

.header-ul {
    height: 100px;
    width: 1190px;
    margin: 0 auto;
    letter-spacing: -.2px;
    font-size: 19.2px;
    font-family: 'MaplestoryOTFLight';
}

.header-img {
    width: 70px;
    height: 70px;
    background-image: url('/Myhome_project/image/logo/5.png');
    background-size: cover;
    background-position: 50% 50%;
    float: left;
    cursor: pointer;
    position: relative;
    left: 30px;
    top: 20px;
}

.header-ul2 {
    width: 710px;
    height: 30px;
    color: #202020;
    position: relative;
    left: 460px;
    top: 55px;
    text-align: right;
    padding: 5px 0px;
}

.li-list {
    float: left;
    list-style: none;
    margin-right: 20px;
    cursor: pointer;
    position: relative;
    top: 3px;
    
}

li.header-li.li-list.header-li-scroll {
	font-size: 17.6px;
}


#last {
    clear: both;
} 
    

.li-list:last-child {
    margin-right: 0px;
}

.li-login {
    font-size: 14px;
    position: relative;
    left: 15px;
    top: 9px;
}



.li-list-hover {
    display:inline; 
    border-bottom: 3px solid #F1AEAE; 
    padding-bottom: 10px;
}




.li-list-scroll-hover {
    display:inline; 
    border-bottom: 3px solid #F1AEAE; 
    padding-bottom: 7px;
}

.header-scroll {
    height: 80px;
    background-color: white;
    
    /* font-size: 17.6px !important; */
}

.header-ul-scroll {
    height: 50px;
    /* font-size: 1.1em; */
}

.header-img-scroll {
    width: 55px;
    height: 55px;
    position: relative;
    left: 22px;
    top: 17px;
}

.header-ul2-scroll {
    color: #202020;
    position: relative;
    left: 450px;
    top: 36px;
    
    font-size: 17.6px;
}
/* header css 끝*/



/* footer css 시작*/
    #footer{
	    z-index: -1;
	    background-color: #F1AEAE;
	    text-align: center;
	    color: white;
	    line-height: 28px;
	    width: 100%;
	    margin: 0px auto;
	    height: 130px;
	    position: relative;
	    transform: translateY(-100%);    
	    transform: translateX(0%);
    }   
	


    #footer-content {
        position: relative;
        padding-top: 30px;
        font-family: 'NanumBarunGothic', sans-serif;
    }
    
    #footer-content2 > a {
        margin-right: 20px;
    }

    #chat {
        width: 80px;
        height: 80px;
        background-image: url('../image/chat.png');
        position: fixed;
        right: 20px;
        bottom: 20px;
        object-fit: cover;
        display: block;
        background-size: cover;
        background-position: 50% 50%;
    }
    
/* footer css끝 */	
	
	.contractors {
		float:left;
		margin-right:15px;
	}
	
	.imgbox img {
		height: 140px;
	}
	.selectboxs {
		border: 1px solid #ccc;
		border-radius: 4px;
		width: 100px;
		height: 50px;
		text-align: center;
		margin: 10px;
		padding-top:12px;
		
	}
	input:checked + label{
		background-color: #F1AEAE;
		color: white;
	}
	.container>div {
		margin-top: 15px;
		width: 80%;
		margin: 10px auto;
	}
	
	#option, #contractorcontainer {
		display: none;
	}
	.option {
		margin: 10px;
		width: 100px;
		height: 50px;
	}
	#selbox2{
		background-color:#F1AEAE;
		color: white;
	}
 	
 	#datepicker {
 		visibility: hidden;
 	}
	.hidden-menu {
		display: none;
	}
	#emptybox {
		margin-bottom: 40px;
	}
	.smalltitle {
		
	border-left: 5px solid #F1AEAE;
	font-family: 'MaplestoryOTFLight';
	font-size: 20px;
	
	padding-left: 20px;
	margin-top: 40px;
	}
	#btnwrap{
		text-align: center;
		margin-top: 30px;
	}
	#btnupload {
		background-color:#F1AEAE;
		color: white;
		width: 100px;
		height: 50px;
	}
	
	#form1>div {
		margin-top: 15px;
	    width: 80%;
	    margin: 10px auto;
	}
	.price {
		margin-top: 30px;
	}
	
</style>


 	<script>
 		function goPopup(){
 		
 			var pop = window.open("/Myhome_project/user/jusopopup.do","주소 찾기","width=570,height=420, scrollbars=yes, resizable=yes");
 		
 			}
 			function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd,
 			rnMgtSn, bdMgtSn , detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm,
 			buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){
 		
 			 document.form.roadAddrPart1.value = roadAddrPart1;
 			 document.form.addrDetail.value = addrDetail;
 			
 			}
 		
 	
 	</script>

</head>
<body>
 
<div class="boardwrap">
 
 
   <%@include file="/WEB-INF/views/inc/bootstrap-header.jsp"%>
     
     <div class="container">
	
		<div id="title">방 올리기</div>
		<div id="explain">올리는 매물의 정보를 선택 및 입력하세요.</div>
		<hr>
		<div id="emptybox"></div>
			
			
		<form id="form1" method="GET" action="/Myhome_project/contractor/upload-contractor-ok.do">	
		
		<!-- 매물 종류 선택 -->
		<div id="location">
			<div class="smalltitle">
			위치 정보
			<span style="font-size: 16px; color:tomato; padding-left: 200px;">
				<span class="glyphicon glyphicon-alert" style="margin-right: 20px;"></span>
				필수입력 사항입니다.
			</span>
			</div>
			<div style="margin: 10px;">
			
			
					<input type="button" id="btnaddress" class="btn btn-default" onClick="goPopup();" value="주소검색"/><br>
					<!-- 도로명주소 전체(포맷)<input type="text" id="roadFullAddr" name="roadFullAddr" style="width: 400px;"/><br> -->
					<input type="text" id="roadAddrPart1" name="roadAddrPart1" placeholder="도로명주소" name="location1" style="width: 400px; margin: 10px;" /><br>
					<input type="text" id="addrDetail" name="addrDetail" placeholder="고객입력 상세주소" name="location2" style="width: 400px; margin: 10px;"/><br>
					<!-- 참고주소<input type="text" id="roadAddrPart2" name="roadAddrPart2" style="width: 400px;" /><br>
					우편번호<input type="text" id="zipNo" name="zipNo" style="width: 400px;" /> -->

			</div>
		</div>
		
		
		<div id="propertyroomtypedetail">
			<div class="smalltitle">
				매물 종류 선택
				<span style="font-size: 16px; color:tomato; padding-left: 200px;">
					<span class="glyphicon glyphicon-alert" style="margin-right: 20px;"></span>
					필수입력 사항입니다.
				</span>
			</div>
			<div>
				<input type="hidden" id="hdn1" name="hdn1" value="">
				<input type="hidden" id="hdn2" name="hdn2" value="">
				<input type="hidden" id="hdn3" name="hdn3" value="${seqAllUser}">
				
				<input type="radio" id="oneroom" name="roomtype" class="roomtype hidden-menu" value="1" checked>
 				<label for="oneroom" class="selectboxs">원룸</label>
				<input type="radio" id="tworoom" name="roomtype" class="roomtype hidden-menu" value="2">
				<label for="tworoom" class="selectboxs">투룸</label>
				<input type="radio" id="officetel" name="roomtype" class="roomtype hidden-menu" value="3">
				<label for="officetel" class="selectboxs">오피스텔</label>
			</div>
		</div>
		
		<!-- 옵션선택 -->
		<div id="propertyroomoption">
			<div class="smalltitle">옵션 선택</div>
			<div>
				<input type="checkbox" id="aircon" name="aircon" class="roomoption ckbox hidden-menu" value="1">
				<label for="aircon" class="selectboxs">에어컨</label>
				
				<input type="checkbox" id="washer" name="washer" class="roomoption ckbox hidden-menu" value="1">
				<label for="washer" class="selectboxs">세탁기</label>
				
				<input type="checkbox" id="bed" name="bed" class="roomoption ckbox hidden-menu" value="1">
				<label for="bed" class="selectboxs">침대</label>
				
				<input type="checkbox" id="desk" name="desk" class="roomoption ckbox hidden-menu" value="1">
				<label for="desk" class="selectboxs">책상</label>   
				
				<input type="checkbox" id="closet" name="closet" class="roomoption ckbox hidden-menu" value="1">
				<label for="closet" class="selectboxs">옷장</label>
				
				<input type="checkbox" id="tv" name="tv" class="roomoption ckbox hidden-menu" value="1">
				<label for="tv" class="selectboxs">TV</label>   
				
				<input type="checkbox" id="shoebox" name="shoebox" class="roomoption ckbox hidden-menu" value="1">
				<label for="shoebox" class="selectboxs">신발장</label>   
				
				<input type="checkbox" id="refrigerator" name="refrigerator" class="roomoption ckbox hidden-menu" value="1">
				<label for="refrigerator" class="selectboxs">냉장고</label>   
				
				<input type="checkbox" id="stove" name="stove" class="roomoption ckbox hidden-menu" value="1">
				<label for="stove" class="selectboxs">가스레인지</label>   
				
				<input type="checkbox" id="induction" name="induction" class="roomoption ckbox hidden-menu" value="1">
				<label for="induction" class="selectboxs">인덕션</label>   
				
				<input type="checkbox" id="microwave" name="microwave" class="roomoption ckbox hidden-menu" value="1">
				<label for="microwave" class="selectboxs">전자레인지</label>   
				
				<input type="checkbox" id="bidet" name="bidet" class="roomoption ckbox hidden-menu" value="1">
				<label for="bidet" class="selectboxs">비데</label>   
			</div>
		</div>
		
		
		<!-- 관리비 -->
		<div id="maintenance">
			<div class="smalltitle">관리비 유무</div>
			<!-- <input type="checkbox" id="selbox" class="options"> -->
			<button type="button" id="selbox1" class="option btn btn-default">관리비있음</button>
			<button type="button" id="selbox2" class="option btn btn-default">관리비없음</button>
				<small>'관리비있음' 버튼을 클릭하여 관리비 세부항목을 설정하세요.</small>
			<!-- 관리비 체크 시 나옴 -->
			<div id="option">
				
				<input type="checkbox" id="internet" name="internet" class="maintenanceoption ckbox hidden-menu" value="1">
				<label for="internet" class="selectboxs">인터넷</label>
				
				<input type="checkbox" id="tvfee" name="tvfee" class="maintenanceoption ckbox hidden-menu" value="1">
				<label for="tvfee" class="selectboxs">유선TV</label>
				
				<input type="checkbox" id="cleaning" name="cleaning" class="maintenanceoption ckbox hidden-menu" value="1">
				<label for="cleaning" class="selectboxs">청소비</label>
				
				<input type="checkbox" id="water" name="water" class="maintenanceoption ckbox hidden-menu" value="1">
				<label for="water" class="selectboxs">수도세</label>   
				
				<input type="checkbox" id="gas" name="gas" class="maintenanceoption ckbox hidden-menu" value="1">
				<label for="gas" class="selectboxs">도시가스</label>
				
				<input type="checkbox" id="electric" class="maintenanceoption ckbox hidden-menu" value="1">
				<label for="electric" class="selectboxs">전기세</label>   

				관리비 : <input type="number" placeholder="관리비를(숫자만) 입력해주세요." style="width:250px;" name="servicecharge" id="servicecharge" min="0" step="1000" style="margin: 10px;" value="0">   
			</div>
		</div>
		
		<div id="propertycontracttype">
			<div class="smalltitle">
			거래 종류
			<span style="font-size: 16px; color:tomato; padding-left: 200px;">
				<span class="glyphicon glyphicon-alert" style="margin-right: 20px;"></span>
				필수입력 사항입니다.
			</span>
			</div>
			<div>
				<input type="radio" id="monthly" name="tradetype" class="tradetype hidden-menu" value="1" required>
				<label for="monthly" class="selectboxs">월세</label>
				
				<input type="radio" id="yearly" name="tradetype" class="tradetype hidden-menu" value="2">
				<label for="yearly" class="selectboxs">전세</label>
				
				<input type="radio" id="trade" name="tradetype" class="tradetype hidden-menu" value="3">
				<label for="trade" class="selectboxs">매매</label>
			</div>
			<div class="smalltitle">
			계약 정보
			<span style="font-size: 16px; color:tomato; padding-left: 200px;">
				<span class="glyphicon glyphicon-alert" style="margin-right: 20px;"></span>
				필수입력 사항입니다.
			</span>
			</div>
			<div>
				보증금 : <input class="price" type="number" id="deposit" name="deposit" placeholder="보증금" min="0" step="10000">원<br>
				월세가 : <input class="price" type="number" id="monthlyRent" name="monthlyRent" placeholder="월세" min="0" step="10000">원<br>
				매매가 : <input class="price" type="number" id="dealing" name="dealing" placeholder="매매가격" disabled min="0" step="10000">원<br>
				계약기간 : <input class="price" type="number" id="contractPeriod" name="contractPeriod" placeholder="계약기간(개월)" style="width:150px;" min="0" max="36" required>개월<br>
			</div>
		</div>
		
		<div id="spacing">
			<div class="smalltitle">
			건물 크기
			<span style="font-size: 16px; color:tomato; padding-left: 200px;">
				<span class="glyphicon glyphicon-alert" style="margin-right: 20px;"></span>
				필수입력 사항입니다.
			</span>
			</div>
			<div style="margin: 10px;">
				면적 : <input type="number" placeholder="평수를(숫자만) 입력하세요." style="width:200px;" id="suparea" name="suparea" min="0" required>
				
			</div>
		</div>
		<div id="heating">
			<div class="smalltitle" style="font-size:20px;">난방 종류</div>
			<div>
				<input type="radio" id="central" name="heating"class="heating hidden-menu" value="1">
				<label for="central" class="selectboxs">중앙난방</label>
				<input type="radio" id="individual" name="heating"class="heating hidden-menu" value="2" checked >
				<label for="individual" class="selectboxs">개별난방</label>
			</div>
		</div>
		
		<div id="floor">
			<div class="smalltitle">건물 층수</div>
			<div style="margin: 10px;">
				전체 층 수 : <input type="number" placeholder="층수를(숫자만) 입력하세요." style="width:200px;" id="totaloffloor" name="totaloffloor">
				해당 층 수 : <input type="number" placeholder="층수를(숫자만) 입력하세요." style="width:200px;" id="numberoffloor" name="numberoffloor">
			</div>
		</div>
		
		<div id="occupancy">
			<div class="smalltitle">입주 가능일</div>
			<div>
				<input type="radio" id="now" name="occupancy"class="occupancy hidden-menu" value="" checked>
				<label for="now" class="selectboxs">즉시입주</label>
				<input type="radio" id="later" name="occupancy"class="occupancy hidden-menu" value="">
				<label for="later" class="selectboxs">날짜선택</label>
				<input type="text" name="occupancy" class="form-control" placeholder="날짜를 입력해주세요.">
				
			</div>
		</div>
		
		<div id="parking">
			<div class="smalltitle">주차 여부</div>
			<div>
				<input type="radio" id="cant1" name="parking"class="parking hidden-menu" value="0" checked >
				<label for="cant1" class="selectboxs">불가능</label>
				<input type="radio" id="can1" name="parking"class="parking hidden-menu" value="1">
				<label for="can1" class="selectboxs">가능</label>
			</div>
		</div>
		
		<div id="pet">
			<div class="smalltitle">반려 동물</div>
			<div>
				<input type="radio" id="cant2" name="pet"class="pet hidden-menu" value="0" checked >
				<label for="cant2" class="selectboxs">불가능</label>
				<input type="radio" id="can2" name="pet"class="pet hidden-menu" value="1">
				<label for="can2" class="selectboxs">가능</label>
			</div>
		</div>
		
		<div id="elevator">
			<div class="smalltitle">엘리베이터</div>
			<div>
				<input type="radio" id="cant3" name="elevator"class="elevator hidden-menu" value="0" checked >
				<label for="cant3" class="selectboxs">없음</label>
				<input type="radio" id="can3" name="elevator"class="elevator hidden-menu" value="1">
				<label for="can3" class="selectboxs">있음</label>
			</div>
		</div>
		
		<div id="window">
			<div class="smalltitle">베란다/발코니</div>
			<div>
				<input type="radio" id="cant4" name="window" class="window hidden-menu" value="0" checked>
				<label for="cant4" class="selectboxs">없음</label>
				<input type="radio" id="can4" name="window" class="window hidden-menu" value="1">
				<label for="can4" class="selectboxs">있음</label>
			</div>
		</div>
		
		<div id="titletext">
			<div class="smalltitle">제목</div>
			<div>
				<input type="text" id="titletxt" class="form-control" name="titletxt" style="width: 500px; margin: 10px;" placeholder="매물 소개글의 제목을 입력하세요." required>
			</div>
		</div>
		
		<div id="contents">
			<div class="smalltitle">설명</div>
			<div>
				<textarea id="content" name="content" class="form-control" placeholder="매물 소개글을 입력하세요." style="width: 500px; margin: 10px;" rows="15" required> </textarea>
			</div>
		</div>
			
		<input type="hidden" name="img" value="">
		
			<div id="btnwrap">
				<button type="submit" class="btn btn-default" id="btnupload" name="btnupload">올리기</button>
			</div>
		</form>
		
    </div>


</div> 


	<%@include file="/WEB-INF/views/inc/footer.jsp" %>
 
 
 
 <script>
 	
 	
 	var selbox = document.getElementById('selbox');
 	var option = document.getElementById('option');
 	
 	var now = document.getElementById('now');
 	var later = document.getElementById('later');
 	var datepicker = document.getElementById('datepicker');
 	
 	var choiceyes = document.getElementById('choiceyes');
 	var choiceno = document.getElementById('choiceno');

 	var contractorcontainer = document.getElementById('contractorcontainer');
 	
 	
 	//버튼 색깔 조절 (관리비있음/없음)
 	selbox1.onclick = function() {
 		option.style.display = 'block';
 		selbox1.style.backgroundColor = '#F1AEAE';
 		selbox1.style.color = 'white';
 		selbox2.style.backgroundColor = 'white';
 		selbox2.style.color = 'black';
 	}
 	selbox2.onclick = function() {
 		option.style.display = 'none';
 		selbox2.style.backgroundColor = '#F1AEAE';
 		selbox2.style.color = 'white';
 		selbox1.style.backgroundColor = 'white';
 		selbox1.style.color = 'black';
 	}
 	
 	
 	
 	//주소가 등록될 때 히든태그에 값을 넣는다.
 	$(window).on("wheel", function (event){
		  // deltaY obviously records vertical scroll
		  
		  // event.originalEvent → JavaScript 의 wheelEvent 객체
		  // deltaY 값은 개인이 마우스 설정에서 설정한 휠 설정 값에 따라 다르다.
		  //console.log(event.originalEvent.deltaY);
		
		  //if (event.originalEvent.deltaY < 0) {
		    // wheeled up
		  //}
		  //else {
		    // wheeled down
		  //}
 		$("#hdn1").val($("#roadAddrPart1").val())
		$("#hdn2").val($("#addrDetail").val())
		  
	});
 	
 	$("#monthly").click(function(){
 		//월세
 		$("#monthlyRent").attr("disabled", false);
 		$("#deposit").attr("disabled", false);
 		$("#dealing").attr("disabled", true);
 		$("#contractPeriod").attr("disabled", false);
 	});
 	$("#yearly").click(function(){
 		//전세
 		$("#monthlyRent").attr("disabled", true);
 		$("#deposit").attr("disabled", false);
 		$("#dealing").attr("disabled", true);
 		$("#contractPeriod").attr("disabled", false);
 	});
 	$("#trade").click(function(){
 		//매매
 		$("#monthlyRent").attr("disabled", true);
 		$("#deposit").attr("disabled", true);
 		$("#dealing").attr("disabled", false);
 		$("#contractPeriod").attr("disabled", true);
 	});
 	
 	
 	
 	
 	
 	
 </script>
 
 
 
</body>
</html>