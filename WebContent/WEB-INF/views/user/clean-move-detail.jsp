<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%


%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyHome::업체상세페이지</title>
<%@include file="/WEB-INF/views/inc/asset.jsp" %>
<link rel="stylesheet" href="/Myhome_project/css/template.css">
<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">



<link rel="stylesheet" href="/Myhome_project/css/jquery-ui.css">
<script src="/Myhome_project/js/jquery-ui.js"></script>
<!-- 부트스트랩 사용가능한 템플릿 -->

<style>
	.container {
		font-size : 16px;
		font-family: 'NanumBarunGothic';
		border: 0px;
		border-right: 1px solid #DBDCE0;
    	border-left: 1px solid #DBDCE0;
	}
	.boardwrap{
	    height: auto;
	    min-height: 100%;
	}
	.wrapbtn {
		margin-right: 30px;
	}
	.tbl {
		margin: auto;
		margin-top: 30px;
		width: 80%;
		text-align: center;
		height: 50px;
	}
	.tbl tr, .tbl td {
		border: 1px solid #ccc;
	}
	.img {
		width: 80%;
		
		border: 1px solid #ccc;
	}
	.tag {
		/* border-bottom: 1px solid #ccc  */
		font-weight: bold;
	}
	
.nanumbarungothic * {
font-family: 'NanumBarunGothic', sans-serif;
}

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

#header:hover {
	background-color: white;
}

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
    
	
	
</style>


</head>
<body>
 
<div class="boardwrap">
 
 <!-- header -->
 <header id="header">
    	<div class="header-wrap">
        <div class="header-ul">
            <div class="header-img"></div>
                <ul class="header-ul2">
                    <li class="header-li li-list">방찾기</li>
                    <li class="header-li li-list">방올리기</li>
                    <li class="header-li li-list">커뮤니티</li>
                    <li class="header-li li-list">중고장터</li>
                    <li class="header-li li-list">마이페이지</li>
                    <li class="header-li li-list">고객센터</li>

                    <li id="logout" class="li-login li-list">로그아웃</li>
                </ul>
            </div>
            </div>
    </header> 
 
    <div class="container">

		<div id="infobox">
			<table class="tbl" id="tbl1">
				<tr id="sel1" value="${sel1 }">
					<td colspan="2" style="font-size: 24px; font-family: 'MaplestoryOTFLight';">이사/청소 업체 상세 페이지</td>
				</tr>
				<tr>
					<td rowspan="4"><img class="img" id="img1" src=' ${cdto.imagePath }'></td>
					<td>
						<div id="seq" class="tag" value="${cdto.seq }">업체명</div>
						<div>${cdto.name}</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="tag">전화번호</div>
						<div>${cdto.tel}</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="tag">사업자등록번호</div>
						<div>${cdto.businessnum }</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="tag">가격</div>
						<div>${cdto.price }</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="tag">소개글</div>
						<div>${cdto.introduce }</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="tag">주소</div>
						<div>${cdto.location }</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="tag">예약가능한 날짜보기</div>
						<input type="text" style="width: 300px;" class="datepicker" id="datepicker" placeholder="박스를 클릭하여 날짜를 선택하세요." value="">
					</td>
				</tr>
				<tr>
					<td>
						<div class="tag">최근 후기 글</div>
						<c:forEach var="rdto" items="${rdto }">
							<div>${rdto.userName}||${rdto.review }||${rdto.rating }</div>
						</c:forEach>
					</td>
					<td>
						<div class="tag">평점</div>
						<div>${cdto.avgRating }/5.0</div>
					</td>
				</tr>
			
			</table>
			
		</div>
		
		<div class="wrapbtn" style="text-align: right; margin-top: 40px;">
			<button type="button" class="btn btn-default" id="btn1" onclick="history.back()">이전화면</button>
			<button type="submit" class="btn btn-success" id="btn2">예약하기</button>
		</div>
       
    </div><!-- container -->


</div> 
    <!-- footer -->
	<div id="footer">
        <!-- <div id="footer-img"></div> -->
        <div id="footer-content">
            <div id="footer-content1">&copy; 2021</div>
            <div id="footer-content2">NOH PUREUN, PARK JIHYUN, LEE DAEHONG, LEE JUNOH, YUN JIHYUN, JANG JINYOUNG</div>
            <div id="footer-content2">
                <a>INFO</a>
                <a>HISTORY</a>
                <a>CONTACT</a>
            </div>
        </div>
    </div>


    <div id="chat"></div>

 	<script>
 		$('#datepicker').datepicker({
 			dateFormat: "yy-mm-dd",
            minDate: "+1",	//시작날짜
            maxDate: "+1M"	//넘길수있는 최대월
            
            //console.log($(this).val());
 		});
 		
 		var btn2 = document.getElementById("btn2");
 		
 		btn2.onclick = function() {//예약하기
 			var sel1 = $("#sel1").attr("value");
 			var seq = $("#seq").attr("value");
 			var date = $("#datepicker").val();
 			
 			//alert(sel1 + " " + seq + " " + date);
 			location.href = '/Myhome_project/user/cleanmovedetailok.do?sel1='+sel1+"&seq="+seq+"&date="+date;
 		};
 		
 	</script>
 	
</body>
</html>