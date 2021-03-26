<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::당신이 찾는 모든방</title>
                                                 
<%@include file="/WEB-INF/views/inc/asset.jsp" %>
<!-- <link rel="stylesheet" href="/Myhome_project/css/main.css"> -->
<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<style>

	.header-ul2 {
	    color: white !important;
	}
	
	.header-ul2-scroll {
    	color: #202020 !important;
    
	}
	
	
	.box2 {
	   /*  border: 1px solid rgb(255, 255, 255); */
    	width: 900px;
   	 	height: 300px;
    	margin: 0 auto;
    	margin-top: 250px;
    	padding: 20px;
	}
	
	.xsbox1 {
	    background-color: hsla(0, 71%, 81%, 0.4);
	    width: 200px;
	    height: 200px;
	    padding: 20px;
	    padding-top: 60px;
	    border-radius: 30px;
	    font-size: 2em;
	    text-align: center;
	    margin: 0 auto;
	    margin-top: 10px;
	    /* float: left; */
	}
	
	
	
	body {

      margin: 0 auto;
      height: 100%;
      width: 100%;
        
    }
    
    html {
    	height: 100%;
    }
    

 
    .main-wrap {
        height: auto;
	    min-height: 100%;
	    position: relative;
	}
    

    /* main */
    
    .container {
        width: 100%;
        height: 100%;
    }

    .main1 {
        width: 100%;
        height: 1200px;
        border: 1px solid transparent;
        background-image: url(/Myhome_project/image/main-img/0.jpg);
        background-size: cover;
        background-position: 50% 50%;
    }

    .box2 {
        /* border: 1px solid rgb(255, 255, 255); */
        width: 900px !important;
        height: 300px;
        margin: 0 auto;
        margin-top: 250px;
        padding: 20px;
        
    }


    .search {
        border: 1px solid white;
        margin: 0 auto;
        margin-top: 120px;
        text-align: center;
        padding: 20px;
		padding-top: 80px;
		height: 330px;
		width: 820px;
        
    }


    #search-title {
        font-size: 2em;
        font-family: 'MaplestoryOTFLight';
        margin-bottom: 50px;
        color: white;
    }


    .section1 {
        border: 1px solid transparent;
        height: 700px;
    }
   
    .content {
       /*  border: 1px solid black; */
        width: 1210px;
        height: 500px;        
        margin: 100px auto;
        text-align: center;
    }

   
    
    /* 카운트 박스 */
    
    
	.count-box {
		float: left;
		padding: 0px 23px;
		text-align: center;
	}
	
	#count-sbox1, #count-sbox2 {
		/* border: 1px solid blue; */
		width: 250px;
		height: 270px;
		margin-right: 50px;
		font-family: 'MaplestoryOTFLight';

	}
	
	#count-sbox3 {
		/* border: 1px solid blue; */
		width: 250px;
		height: 270px;
		margin-right: 0px;
		font-family: 'MaplestoryOTFLight';
	}
	
	.count-box > span {
		font-size: 30px;
		font-family: 'MaplestoryOTFLight';
		color: white;
	}
	
	.cbox {
		/* border: 1px solid blue; */
		width: 200px;
		height: 200px;
		margin-top: 10px;
		border-radius: 20px;
		background-color: hsla(0, 71%, 81%, 0.4);
		padding: 45px;
		font-size: 5em;
		color: white;
		text-align: center;
	
	}
	
	
	/* 매물 검색 창  */
	.search-room {
		/* border: 1px solid #9c9c9c; */
		width: 880px;
		height: 350px;
		margin: 100px auto;
		padding: 50px 60px;
		border-radius: 20px;
		background-color: #dcdcdc42;
	}	

	.search-title {
		font-size: 28px;
		color: white;
		font-family: 'MaplestoryOTFLight';
		text-align: center;
	}
	
	.search-box1 {
		/* border: 1px solid white; */
		width: 770px;
		height: 70px;
		margin-top: 40px;
		
	}
	
	.op-box1 {
		/* border: 1px solid white; */
		width: 350px;
		height: 50px;
		float: left;
		font-size: 16px;
	}
	
	
	.search-box2 > input:hover {
		background-color: #f1aeae !important;
		color: white !important;
	}
	
	.search-box2 > .search-last {
		border-right: 0px;
	}
	
	.search-box2:nth-child(2) {
		margin-left: 60px;
	}
	
	.form-control {
		width: 610px;
		height: 50px;
		float: left;
		
	}
	
	
	/* 버튼 */
	.btn {
		background-color: white;
   		color: #202020;
   		outline: none !important;
   		font-family: 'MaplestoryOTFLight';
   		margin-right: 5px;
   		height: 50px;
   		font-size: 20px;
   		width: 106px;
   		/* margin-left: 20px; */
	}
	
	
	#btn-search:hover {
		background-color: white !important;
		color: #f1aeae !important;
	}
	
	#btn-search:active {
		background-color: white !important;
		color: #f1aeae !important;
	}
	
	
	#btn-search {
		margin-left: 20px;
		background-color: #f1aeae;
		color: white;
	}
	
	.op-box1:nth-child(2) {
		margin-left: 50px;
	}
	
	.btn-active {
		background-color: #f1aeae;
		color: white;
	}
	
	
	/* 공지사항 */
	.notice1 {
		/* border: 1px solid black; */
		width: 600px;
		height: 500px;
		float: left;
		color: white;	
		padding: 100px;
			
	}
	
	.notice1 > span {
		color: white;
		display: block;
	}
	
	.large-font {		
		border: 7px solid white;
		padding: 10px;
		width: 400px;
		margin-top: 150px;
		font-family: 'MaplestoryOTFLight';
		font-weight: bold;		
		font-size: 50px;	
		background-color: #00000073;	
	}
	
	.small-font {
		font-size: 20px;
		margin-top: 10px;
		display: block;
		font-weight: 700;
	}
	
	.notice2 {
		/* border: 1px solid black; */
		width: 300px;
		height: 250px;
		float: left;
		padding: 40px 35px;
		/* overflow: hidden; */
		text-align: left;
		padding: 20px 35px;
	}
	
	.notice3 {
		background-color: #ececec;
	}
	
	#n1 {
		background-image: url(/Myhome_project/image/9.jpg);
		background-size: cover;
        background-position: 50% 50%;
	}
	
	.notice4 {
		border: 1px solid #ececec;
	}
	
	.large-title {
		font-size: 20px;
		font-family: 'MaplestoryOTFLight';
		text-align: center;
		color: #202020;
		margin-left: 15px;
	}
	
	.notice2 > ul {
		margin-top: 20px;
		padding: 0px;
		font-size: 16px;
	}
	
	
	.notice2 > ul > li {
		list-style: none;
		line-height: 1.7;
		text-align: left;
		font-family: 'NanumBarunGothic';
	}
	
	.notice2 > .glyphicon {
		font-size: 28px;
		color: #f1aeae;
		margin-right: 30px;
		text-align: center;
	}
	
	.span-block {
		display: block;
		text-align: center;
	}
	
	.span-block:nth-child(2) {
		margin-top: 50px;
		font-size: 30px;
		font-weight: 700;
		
	} 
	
	.main-tran {
		/* border: 1px solid black; */
		width: 400px;
		height: 100px;
		margin-top: 10px;
		background-color: #00000099;
		padding: 10px;
	
	}
	
	
	.more {
		border: 1px solid #eccfcf;
	    width: 80px;
	    height: 30px;
	    text-align: center;
	    padding: 3px;
	    float: left;
	    margin-left: 150px;
	    font-size: 14px;
	    font-family: 'NanumBarunGothic';
	    background-color: transparent;
	    color: #202020;
	}
	
	.more:hover {
		background-color: #f6afb3;
		color: white;
	}
	
	input[type=checkbox] {
		display: none;
	}
	
	input[type="checkbox"]:checked + label {
		background-color: #f6afb3;
		color: white;
	}
	
	
	
	
	
	

</style>
</head>
<body>
<!-- <div class="wrap">  -->
<div class="main-wrap">
 <!-- header -->
<%@include file="/WEB-INF/views/inc/bootstrap-header.jsp" %>
 
    <div class="main1">
         
         <!-- 매물 카운트 박스 -->
        <div class="box2">
           <div class="count-box" id="count-sbox1">
      			<span>실시간 매물</span>
      			<div class="cbox">20</div>
      		</div>
      		<div class="count-box" id="count-sbox2">
      			<span>전체 매물</span>
      			<div class="cbox">${count1 }</div>
      		</div>
      		<div class="count-box" id="count-sbox3">
      			<span>계약완료</span>
      			<div class="cbox">${count2 }</div>
      		</div>
        </div> 
         
         

        <!-- 검색창 -->
     	<div class="search-room">
     		<div class="search-title"><span class="glyphicon glyphicon-search"></span> 원하는 방을 검색해보세요.</div>
     		
     		<form method="GET" action="/Myhome_project/contractor/search-contractor.do"> 
     		<!-- 원룸, 투룸, 전세, 월세 -->
     		<div class="search-box1">
     		
     		
     			<div class="op-box1">
     				<input type="checkbox" name="room" id="btn1" value="원룸" checked onclick='checkOnlyOne(this)'>
     				<label for="btn1" class="btn btn-big">원룸</label>
     				<input type="checkbox" name="room" id="btn2" value="투룸" onclick='checkOnlyOne(this)'>
     				<label for="btn2" class="btn btn-big">투룸</label>
     				<input type="checkbox" name="room" id="btn3" value="오피스텔" onclick='checkOnlyOne(this)'>
     				<label for="btn3" class="btn btn-big">오피스텔</label>
     			</div>
     			
     			<div class="op-box1">
     				<input type="checkbox" name="deal" id="btn4" value="월세" checked onclick='checkOnlyOne2(this)'>
     				<label for="btn4" class="btn btn-big">월세</label>
     				<input type="checkbox" name="deal" id="btn5" value="전세" onclick='checkOnlyOne2(this)'>
     				<label for="btn5" class="btn btn-big">전세</label>     				
     				<input type="checkbox" name="deal" id="btn6" value="매매" onclick='checkOnlyOne2(this)'>
     				<label for="btn6" class="btn btn-big">매매</label>
     			</div>
     			
     		
     		</div>
     		
     		
     		<!-- 지하철역 검색 -->
     		<div class="search-box1">
     			<input type="text" class="form-control search-box2" name="location" placeholder="지역을 검색해주세요.">
     			<input type="submit" class="btn" id="btn-search" value="검색하기"></div>
     			
     		</form>	
     		</div>
     	</div>
     	
     	
     	
    
    </div>
            

    <div class="section1">
        <div class="content">
       		<div class="notice1" id="n1">
       			<span class="large-font">MYHOME</span>
       			<div class="main-tran">
       				<span class="small-font">방구하기부터 전자계약까지 한번에!</span>
       				<span class="small-font">당신이 찾던 마이홈</span>
       			</div>
       		</div>
       		<div class="notice2 notice4" id="n2">
       			<span class="glyphicon glyphicon-bullhorn"><span class="large-title">공지사항</span></span>
       			<ul>
       			<c:forEach items="${notice }" var="dto1" begin="0" end="3">
       				<li>${dto1.notice }</li>
       			</c:forEach>
       			</ul>
       			
       			<!-- 연결안됨 -->
       			<div class="more btn" onclick="location.href='/Myhome/user/boardnoticelist.do';">more</div>
       		</div>
       		<div class="notice2 notice3 no-title" id="n3">
       			<span class="glyphicon glyphicon-pencil"><span class="large-title">청약알림</span></span>
       			<ul>
       			<c:forEach items="${application }" var="dto2" begin="0" end="3">
       				<li>${dto2.application }</li>
       			</c:forEach>
       			</ul>
       			<div class="more btn" onclick="location.href='/Myhome/user/boardapplicatioinlist.do';">more</div>
       		</div>
       		<div class="notice2 notice3">
       			<span class="glyphicon glyphicon-ok"><span class="large-title">부동산 체크리스트</span></span>   
       			<ul>
       			<c:forEach items="${checkList }" var="dto3" begin="0" end="3">
       				<li>${dto3.check }</li>
       			</c:forEach>
       			</ul>    	
       			<div class="more btn" onclick="location.href='/Myhome/user/boardchecklist.do';">more</div>		
       		</div>
       		<div class="notice2 notice4">
       			<span class="glyphicon glyphicon-info-sign"><span class="large-title">고객센터</span></span>
       			
       			<span class="span-block">02-1234-0000</span>
       			<span class="span-block">09:00 ~ 18:00</span>
       		</div>
        </div>
    
    
    <!-- main-wrap -->
    </div>
    

     <!-- footer -->
<%@include file="/WEB-INF/views/inc/footer.jsp" %>
<!-- </div> -->


<script>

/* 브라우저 창 띄우면 white로 나옴 -> 메인에서 transparent */
$(document).ready(function() {
	$("header").hover(function() {
		$("#header").css("background-color", "transparent");})
})


/* 스크롤 시  */

$(window).scroll(function() {
	
	if($(this).scrollTop() > 0) {
		$(".header-ul3").css("color", "#202020");
		$("#header").css("background-color", "white");
		$("header").hover(function() {
			$("#header").css("background-color", "white");
		});
	
	} else {
		$(".header-ul3").css("color", "white");
		$("#header").css("background-color", "transparent");
		$("header").hover(function() {
			$("#header").css("background-color", "transparent");})
	}
});


	//체크박스는 하나만 선택
	function checkOnlyOne(element) {
		const checkbox = document.getElementsByName("room");
		
		checkbox.forEach((cb) => {
			  cb.checked = false;
		})
		
		 element.checked = true;
	}
	
	function checkOnlyOne2(element) {
		const checkbox2 = document.getElementsByName("deal");
		
		checkbox2.forEach((cb) => {
			  cb.checked = false;
		})
		
		 element.checked = true;
	}
	
	
	//메인 이미지 4초마다 변경
	
	var count = 0;
	
	$(document).ready(function() {
		setInterval("onChange()", 4000);
	})
	
	function onChange() {
		
		count++;
		$(".main1").css("background-image", "url(/Myhome_project/image/main-img/" + count + ".jpg");
		
		if(count > 6) {
			count = 0;
		}
		
	}
	
	
	
	
	

</script>
</body>
</html>