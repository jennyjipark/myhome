<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::청약안내</title>

<%-- <%@include file="/WEB-INF/views/inc/asset.jsp" %> --%>

<!-- <link rel="stylesheet" href="/Myhome_project/css/main.css"> -->
<link rel="stylesheet" href="/Myhome_project/css/template.css">
<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">
<link rel="stylesheet" href="/Myhome_project/css/board.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<%@include file="/WEB-INF/views/inc/asset.jsp"%>

<script src="/Myhome_project/js/highcharts.js"> </script>


<style>
body, html {
	height: 100%;
	margin: 0 auto;
	padding: 0;
}

.container {
	border: 0px;
}

#header {
	background-color: white;
}

#header:hover {
	background-color: white;
}

.header-containerwrap {
	height: auto;
	min-height: 100%;
}

.section2 {
	font-family: 'MaplestoryOTFLight';
	display: inline;
	position: relative;
	left: 200px;
	top: 100px;
	float: left;
}

#title {
	border-bottom: 1px dashed #ccc;
	font-size: 24px;
	margin-bottom: 30px;
	width: 200px;
}

#tbl1 {
	font-size: 16px;
	color: #202020;
}

#tbl1 td {
	height: 50px;
}

.section3 {
	margin-top: 30px;
	text-align: center;
	/* border: 1px solid black; */
}

.header {
	background-color: white;
}

#navboardtbl {
	height: 800px;
	width: 100%;
	margin: 0px;
}

/*기존 200xp 삭제만 300px*/
#navboardtbl .navboardtd:first-child {
	width: 300px;
}

.navboardtd {
	vertical-align: top;
}

/*타이틀 태그 */

/*타이틀 태그 */
#boardtitle {
	font-size: 24px;
	margin: 30px 10px;
	padding: 0px 10px;
	color: black;
	font-family: 'MaplestoryOTFLight';
	border-left: 5px solid #F1AEAE;
}

#board {
	margin-left: 0px;
}

.boardtext {
	margin-top: 10px;
}

.boardfile>input {
	background-color: #f1aeae;
	width: 400px;
	height: 40px;
	margin-left: 20px;
	text-align: center;
	color: white;
	outline: none;
	border: 0;
}

/*버튼 수정*/
.boardbutton {
	width: 940px;
	text-align: right;
}


.boardbutton button {
	outline: none;
	border: 0px solid #000;
	background-color: #f1aeae;
	color: white;
	width: 70px;
	height: 34px;
	margin-right: 5px;
	margin-bottom: 10px;
	border-radius: 3px;
	z-index: 99;
}

/*여기서 부터 하이차트 구간 입니다. */
.highcharts-figure, .highcharts-data-table table {
    min-width: 310px; 
    max-width: 800px;
    margin: 1em auto;
}

#container {
    height: 400px;
}

.highcharts-data-table table {
	font-family: Verdana, sans-serif;
	border-collapse: collapse;
	border: 1px solid #EBEBEB;
	margin: 10px auto;
	text-align: center;
	width: 100%;
	max-width: 500px;
}
.highcharts-data-table caption {
    padding: 1em 0;
    font-size: 1.2em;
    color: #555;
}
.highcharts-data-table th {
	font-weight: 600;
    padding: 0.5em;
}
.highcharts-data-table td, .highcharts-data-table th, .highcharts-data-table caption {
    padding: 0.5em;
}
.highcharts-data-table thead tr, .highcharts-data-table tr:nth-child(even) {
    background: #f8f8f8;
}
.highcharts-data-table tr:hover {
    background: #f1f7ff;
}

@font-face {
    font-family: 'MaplestoryOTFBold';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.1/MaplestoryOTFBold.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

tspan,text, .highcharts-description,#adinfo{
    font-family: 'MaplestoryOTFBold';
}

/* 여기서 부터는 지도 구간입니다  0b98d001d6c169e0913693978eb930c7 */
#add{
    background-color: #f1acac;
    width: 300px;
    height: 24px;
    border-radius: 3px;
    border: 0px; 
    text-align: center;
    color: white;
    font-size: 16px;
    font-family: 'MaplestoryOTFLight';
   	float: right;
   	
}


/*추가정보 입력 사항입니다다.*/

#add::placeholder{
	color:white;
}

#applicationsearch{
   background-color: #f1acac;
    border-radius: 3px;
    width:80px;
    border: 0px; 
    text-align: center;
    color: white;
    font-size: 16px;
    font-family: 'MaplestoryOTFLight';
    margin-right: 10px;
}

#extitle{
	font-size:20px;
	padding-bottom:10px;
}
#adinfo{
	text-align:center;
	vertical-align: top;

}

#stepinfo{
	text-align:18px;
	margin-bottom:10px;
	margin-top:10px;

}
#stepmain{
	text-align:left;
	padding-left:20px;
	padding-right:30px;
}

#stepmain p{
	margin-bottom:0px;
}

#prepare{
width:400px;
height:300px;
}

/* 효과 슬라이드  */
        #prepare ul,li{
            list-style: none;
            margin: 0px;
            padding: 0px;
        }

        [name="slide"]{
            display: none;
        }
        /*slidebox = prepare*/
        #prepare {
           width: 100%;
           margin: 0px auto;
        }
        #prepare img{
            max-width: 100%;
        }
        #prepare .slidelist{
            white-space: nowrap;
            font-size: 0;
            overflow: hidden;
        }
        #prepare .slideitem{
            position: relative;
            display: inline-block;
            vertical-align: middle;
            width: 100%;
            transition: all .35s;
        }
        
        #prepare .slideitem label{
            position: absolute;
            z-index: 1;
            top: 50%;
            transform: translateY(-50%);
            padding: 20px;
            border-radius: 50%;
            cursor: pointer;
        }

label .left{
    left:20px;
    background-color: #f1acac;
    background-position: center center;
    background-size: 50%;
    background-repeat: no-repeat;
}
label .right{
    right:20px;
    background-color: #f1acac;
    background-position: center center;
    background-size: 50%;
    background-repeat: no-repeat;

}


[id="slide01"]:checked ~.slidelist .slideitem {transform: translateX(0); animation: slide01 20s infinite;}
[id="slide02"]:checked ~.slidelist .slideitem {transform: translateX(-100%);animation: slide02 20s infinite;}
[id="slide03"]:checked ~.slidelist .slideitem {transform: translateX(-200%); animation: slide03 20s infinite;}
[id="slide04"]:checked ~.slidelist .slideitem {transform: translateX(-300%); animation: slide04 20s infinite;}


@keyframes slide01{
    0%{left: 0%;}
    23%{left: 0%;}
    25%{left: -100%;}
    48%{left: -100%;}
    50%{left: -200%;}
    73%{left: -200%;}
    75%{left: -300%;}
    98%{left: -300%;}
    100%{left: 0%;}
}

@keyframes slide02{
    0%{left: 0%;}
    23%{left: 0%;}
    25%{left: -100%;}
    48%{left: -100%;}
    50%{left: -200%;}
    73%{left: -200%;}
    75%{left: 100%;}
    98%{left: 100%;}
    100%{left: 0%;}
}

@keyframes slide03{
    0%{left: 0%;}
    23%{left: 0%;}
    25%{left: -100%;}
    48%{left: -100%;}
    50%{left: 200%;}
    73%{left: 200%;}
    75%{left: 100%;}
    98%{left: 100%;}
    100%{left: 0%;}
}

@keyframes slide04{
    0%{left: 0%;}
    23%{left: 0%;}
    25%{left: 300%;}
    48%{left: 300%;}
    50%{left: 200%;}
    73%{left: 200%;}
    75%{left: 100%;}
    98%{left: 100%;}
    100%{left: 0%;}
}



/* 추가 요청 등록 */
.container{
	border-right: 1px solid #DBDCE0;
    border-left: 1px solid #DBDCE0;
}


</style>

</head>
<body>
	<div class="wrap">

		<!-- header -->
		<%@include file="/WEB-INF/views/admin/header.jsp"%>

		<div class="container">


				<table id="navboardtbl">

					<tr id="navboardtr">
						<td class="navboardtd">
							<!-- nav --> <%@include file="/WEB-INF/views/admin/nav.jsp"%>

						</td>

						<!-- 상세 보기 입니다.-->

						<td class="navboardtd">

							<div id="boardtitle" class="">
								청약안내게시판 <small>상세 안내</small>
							</div> <!--  지도 구간 입니다. -->
							<table id="tblmap">
								<tr>
									<td>
								<p style="margin-top: -12px">
									<em class="link"> <a href="javascript:void(0);"
										onclick="window.open('http://fiy.daum.net/fiy/map/CsGeneral.daum', '_blank', 'width=981, height=650')">
											혹시 주소 결과가 잘못 나오는 경우에는 여기에 제보해주세요. </a>
									</em>
								</p>
								<div id="map" style="width: 500px; height: 400px;"></div>
									
									</td>
									<td id="adinfo">
										<div>
										공고 중인 주소의 지도 위치를 표시하고 있습니다. 
										</div>
										
										<label for="add">
											<input type="text" name="add" id="add" class="form-control" placeholder="주가로 검색할 주소를 입력해 주세요 ">	
											<button id="applicationsearch" type="button" >
											검색</button>
										
										</label>
										<input type="hidden" id="hiadd" value="">
									<hr>
									<div id="extitle">
									청약 연습하기 
									</div>
					
									<div id="prepare">
    <input type="radio" name="slide" id="slide01" checked>
                    <input type="radio" name="slide" id="slide02">
                    <input type="radio" name="slide" id="slide03">
                    <input type="radio" name="slide" id="slide04">
                    <ul class="slidelist">
                        <li class="slideitem">
                            <div>
                                <label for="slide04" class="left"></label>
                                <label for="slide02" class="right"></label>
                                <img alt="step1" src="/Myhome_project/image/admin2/admin2step1.GIF">

                            </div>
                        </li>
                        <li class="slideitem">
                            <div>
                                <label for="slide01" class="left"></label>
                                <label for="slide03" class="right"></label>
                                <div class="img"><img alt="step2" src="/Myhome_project/image/admin2/admin2step2.GIF"></div> 
                            </div>
                        </li>
                        <li class="slideitem">
                            <div>
                                <label for="slide02" class="left"></label>
                                <label for="slide04" class="right"></label>
                                <img alt="step3" src="/Myhome_project/image/admin2/admin2step3.GIF"> 
                                 </div>
                        </li>
                        <li class="slideitem">
                            <div>
                                <label for="slide03" class="left"></label>
                                <label for="slide01" class="right"></label>
                                <img alt="step4" src="/Myhome_project/image/admin2/admin2step4.GIF"> 
                            </div>
                        </li>
                    </ul>

									</div>
					
									</td>
								</tr>
							<tr>	
					<!-- 				<img alt="logo" src="/Myhome_project/image/admin2step1.GIF">
					 -->	
							<td colspan="2">
							<!-- 차크 구간 입니다 -->
							<figure class="highcharts-figure">
								<div id="container"></div>
								<p class="highcharts-description">위의 차트는 현재 공고중인 청약 지역에서 시세와
									서울 중구, 부산 중구, 울산 중구, 대전 중구의 매매, 전세 시세 비교를 안내하는 그래프 입니다. <br>
									(단, 월세는
									변동폭이 커 제외하였습니다.)</p>
								
							</figure> <!-- 버튼 구간입빈다.   -->
							
							<div class="boardbutton">
								<button id="Communitylist" type="button"
									onclick="location.href='/Myhome_project/admin2/application/list.do';">
									목록</button>
								<button id="communitydel" type="button" 
								onclick="location.href='/Myhome_project/admin2/application/view.do?seq=${seq}';" >뒤로</button>
							</div> 
							</td>
							</tr>
						</table>
													
							
						</td>
					</tr>
				</table>


		</div>

	</div>

	<!-- footer -->
	<%@include file="/WEB-INF/views/inc/footer.jsp"%>



	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0b98d001d6c169e0913693978eb930c7&libraries=services,clusterer,drawing"></script>

	<script>
/*   히든 태그 = #hiadd  input #add 버튼#applicationsearch */	
		
	var addre =$("#hiadd").val();
$("#applicationsearch").click(function(){
    
    $("#hiadd").val($("#add").val());
    
    var addre =$("#hiadd").val();
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 

		mapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption);

		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();

		// 주소로 좌표를 검색합니다
		geocoder
				.addressSearch( addre,
						function(result, status) {

							// 정상적으로 검색이 완료됐으면 
							if (status === kakao.maps.services.Status.OK) {
								var coords = new kakao.maps.LatLng(result[0].y,
										result[0].x);

								// 결과값으로 받은 위치를 마커로 표시합니다
								var marker = new kakao.maps.Marker({
									map : map,
									position : coords

								});

								// 인포윈도우로 장소에 대한 설명을 표시합니다
								var infowindow = new kakao.maps.InfoWindow(
										{
											content : '<div style="width:150px;text-align:center;padding:6px 0;">청약지역</div>'
										});
								infowindow.open(map, marker);

								// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
								map.setCenter(coords);
							}
						});


});
	
$("#add").keydown(function(evt){
        
    if( evt.keyCode==13 ){
    	$("#hiadd").val($("#add").val());

 	   var addre =$("#hiadd").val();
   		 
   		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 

		mapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption);

		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();

		// 주소로 좌표를 검색합니다
		geocoder
				.addressSearch( addre,
						function(result, status) {

							// 정상적으로 검색이 완료됐으면 
							if (status === kakao.maps.services.Status.OK) {
								var coords = new kakao.maps.LatLng(result[0].y,
										result[0].x);

								// 결과값으로 받은 위치를 마커로 표시합니다
								var marker = new kakao.maps.Marker({
									map : map,
									position : coords

								});

								// 인포윈도우로 장소에 대한 설명을 표시합니다
								var infowindow = new kakao.maps.InfoWindow(
										{
											content : '<div style="width:150px;text-align:center;padding:6px 0;">청약지역</div>'
										});
								infowindow.open(map, marker);

								// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
								map.setCenter(coords);
							}
						});

    }

})
	
	
	
	
	
	
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 

		mapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption);

		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();

		// 주소로 좌표를 검색합니다
		geocoder
				.addressSearch( '서울특별시 서초구 신반포로 270',
						function(result, status) {

							// 정상적으로 검색이 완료됐으면 
							if (status === kakao.maps.services.Status.OK) {
								var coords = new kakao.maps.LatLng(result[0].y,
										result[0].x);

								// 결과값으로 받은 위치를 마커로 표시합니다
								var marker = new kakao.maps.Marker({
									map : map,
									position : coords

								});

								// 인포윈도우로 장소에 대한 설명을 표시합니다
								var infowindow = new kakao.maps.InfoWindow(
										{
											content : '<div style="width:150px;text-align:center;padding:6px 0;">청약지역</div>'
										});
								infowindow.open(map, marker);

								// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
								map.setCenter(coords);
							}
						});
	</script>


    <script>

Highcharts.chart('container', {
    title: {
        text: '청약 상세 차트'
    },
    xAxis: {
        categories: ['청약지역', '서울중구', '부산중구', '광주서구', '대전중구']
    },
    labels: {
        items: [{
            html: ' 거래타입별 계약 건수(단위: 건)',
            style: {
                left: '50px',
                top: '18px',
                color: ( // theme
                    Highcharts.defaultOptions.title.style &&
                    Highcharts.defaultOptions.title.style.color
                ) || 'black'
            }
        }]
    },
    series: [{
        type: 'column',
        name: '전세(단위: 천만)',
        color: Highcharts.getOptions().colors[2],
        data: [2, 3, 5, 7, 6] //순서대로 데이터 입력
    }, {
        type: 'column',
        name: '매매(단위: 천만)',
        color: Highcharts.getOptions().colors[3],
        data: [4, 3, 3, 9, 0]
    }, {
        type: 'spline',
        name: '전세매매 평균(단위: 천만)',
        data: [3, 2.67, 3, 6.33, 3.33],
        marker: {
            lineWidth: 2,
            lineColor: Highcharts.getOptions().colors[0],
            fillColor: 'white'
        }
    }, {
        type: 'pie',
        name: 'Total consumption',
        data: [{
            name: '월세',
            y: 13,
            color: Highcharts.getOptions().colors[0] // Jane's color
        }, {
            name: '전세',
            y: 23,
            color: Highcharts.getOptions().colors[2] // John's color
        }, {
            name: '매매',
            y: 19,
            color: Highcharts.getOptions().colors[3] // Joe's color
        }],
        center: [100, 80],
        size: 100,
        showInLegend: false,
        dataLabels: {
            enabled: false
        }
    }]
});

    </script>


</body>
</html>



<!-- 

									<div id="prepare">
					                    <div id="stepinfo">

                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                            class="bi bi-pencil-square" viewBox="0 0 16 16">
                            <path
                                d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" />
                            <path fill-rule="evenodd"
                                d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z" />
                        </svg> 참고 예행연습 사이트안내

                    </div>

                    <div id="stepmain">
                        <p><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                            class="bi bi-pencil" viewBox="0 0 16 16">
                            <path
                                d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 
              0 0 1 .11-.168l10-10zM11.207 2.5L13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 
              1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 
              5.175l-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z" />
                        </svg>
                            공동인증서 확인 후 LH 접속
                        </p>

                        <p style="text-align:center; font-size:20px">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                class="bi bi-caret-down-fill" viewBox="0 0 16 16">
                                <path
                                    d="M7.247 11.14L2.451 5.658C1.885 5.013 2.345 4 3.204 4h9.592a1 1 0 0 1 .753 1.659l-4.796 5.48a1 1 0 0 1-1.506 0z" />
                            </svg>
                        </p>


                        <p><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                            class="bi bi-pencil" viewBox="0 0 16 16">
                            <path
                                d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 
              0 0 1 .11-.168l10-10zM11.207 2.5L13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 
              1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 
              5.175l-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z" />
                        </svg>
                           	상단 인터넷청약
                        </p>

                        <p style="text-align:center; font-size:20px">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                class="bi bi-caret-down-fill" viewBox="0 0 16 16">
                                <path
                                    d="M7.247 11.14L2.451 5.658C1.885 5.013 2.345 4 3.204 4h9.592a1 1 0 0 1 .753 1.659l-4.796 5.48a1 1 0 0 1-1.506 0z" />
                            </svg>
                        </p>


                        <p> <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                class="bi bi-pencil" viewBox="0 0 16 16">
                                <path
                                    d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 
                  0 0 1 .11-.168l10-10zM11.207 2.5L13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 
                  1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 
                  5.175l-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z" />
                            </svg>
                            청약 연습하기:분양주택</p>

                            <p style="text-align:center; font-size:20px">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                    class="bi bi-caret-down-fill" viewBox="0 0 16 16">
                                    <path
                                        d="M7.247 11.14L2.451 5.658C1.885 5.013 2.345 4 3.204 4h9.592a1 1 0 0 1 .753 1.659l-4.796 5.48a1 1 0 0 1-1.506 0z" />
                                </svg>
                            </p>
    

                        <p> <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                class="bi bi-pencil" viewBox="0 0 16 16">
                                <path
                                    d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 
                  0 0 1 .11-.168l10-10zM11.207 2.5L13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 
                  1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 
                  5.175l-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z" />
                            </svg>공동인증서 입력</p>

                        <p style="text-align:center; font-size:20px">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                class="bi bi-caret-down-fill" viewBox="0 0 16 16">
                                <path
                                    d="M7.247 11.14L2.451 5.658C1.885 5.013 2.345 4 3.204 4h9.592a1 1 0 0 1 .753 1.659l-4.796 5.48a1 1 0 0 1-1.506 0z" />
                            </svg>
                        </p>

                        <p> <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                class="bi bi-pencil" viewBox="0 0 16 16">
                                <path
                                    d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 
                  0 0 1 .11-.168l10-10zM11.207 2.5L13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 
                  1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 
                  5.175l-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z" />
                            </svg>
                            공고 선택 후 안내 사항에 따라 진행</p>
                    </div>
					
					
									</div>
					


 -->

