<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::방찾기</title>
<%@include file="/WEB-INF/views/inc/asset.jsp"%>
<link rel="stylesheet" href="/Myhome_project/css/template.css">
<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="/Myhome_project/css/myproperty.css">
<!-- <link rel="stylesheet" href="/Myhome_project/css/boarduserver.css"> -->


<!-- 부트스트랩 사용가능한 템플릿 -->

<style>
.container {
	border: 0px;
	border-color: transparent;
	border-right: 1px solid #DBDCE0;
	border-left: 1px solid #DBDCE0;
	margin: 0 auto;
	letter-spacing: -.2px;
	min-height: 100%;
	padding-bottom: 100px;
	margin-top: 100px;
}

.header-containerwrap {
	height: auto;
	min-height: 100%;
	position: relative;
}

#maintitle {
	/* margin: 30px 7px; */
	font-size: 24px;
	font-family: 'MaplestoryOTFLight';
	padding: 0 10px;
	border-left: 5px solid #f1aeae;
	text-align: left;
	float: left;
	margin-left: 80px;
	margin-top: 80px;
	margin-bottom: 30px;
}

.option1 {
	/* margin: 10px auto; */
	font-size: 14px;
	text-align: center;
	/* padding-left: 148px; */
	position: relative;
	/* left: -60px; */
	float: left;
	margin: 0px auto;
	margin-top: 10px;
	padding: 0 100px;
}

.option1 label {
	margin-right: 30px;
	font-size: 14px;
	font-weight: normal;
}

.optionbox {
	position: relative;
	float: left;
	top: 8px;
}

.temppicture {
	width: 100%;
	height: 600px; /*나중엔 오토로 바꾸기 */
	background-color: #ccc;
	float: left;
	margin: 30px auto;
	text-align: center;
	position: relative;
	/* left: 25px; */
}

/* 팀장님 소스 */
.board-name {
	border-left: 3px solid #f1acac;
	width: 810px;
	height: 32px;
	padding-left: 20px;
	font-size: 24px;
	font-family: 'NanumBarunGothic';
	color: #202020;
	margin-bottom: 20px;
}

.matching-option {
	/* border: 1px solid blue; */
	width: 400px;
	height: 100px;
	padding: 40px 0px;
	font-size: 16px;
	font-family: 'NanumBarunGothic';
	color: #202020;
}

.matching-option>a {
	cursor: pointer;
	color: #202020;
	margin-right: 20px;
	float: left;
	margin-left: 0px;
}

.matching-option>a:hover {
	color: #f1acac;
	text-decoration: none;
}

.matching-option>a:nth-child(2) {
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
	height: 600px;
	margin-right: 50px;
	margin-left: 60px;
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

/* 전체 property list 박스 property.css 덮어쓰기 */
.property-box {
	border: 1px solid blue; */
	float: left;
	/* 	    width: 900px; */
	width: 100%;
	height: auto;
	margin-bottom: 50px;
	margin-left: 0px;
	/* padding-left: 0px;
	    padding-top: 0px; */
	/* padding: 0 100px; */
	position: relative;
	margin: 20px auto;
}

.img-property {
	border: 1px solid black;
	width: 280px;
	height: 180px;
	float: left;
	background-image: url('../image/6.jpg');
	background-position: 0% 0px;
	background-size: cover;
	cursor: pointer;
}

/* 헤더 */
#mymatching {
	color: #f1acac;
}

/* 매칭버튼 */
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
	margin-left: 5px;
}

/* 검색, 페이지바 */
.search-paging {
	border: 1px solid black;
	width: 800px;
	height: 200px;
	padding: 20px 0px;
	margin-top: 50px;
}

.paging {
	border: 1px solid blue;
	width: 100%;
	height: 75px;
	padding: 0px 170px;
}

.pagination>li>.page-a {
	color: #202020;
}

.pagination>.active>a, .pagination>li>a:hover {
	background-color: #f1aeae !important;
	border-color: #f1aeae !important;
	color: white !important;
}

.btn {
	background-color: #f1aeae;
	color: white;
	outline: none !important;
	font-family: 'NanumBarunGothic';
}

#search-box {
	/* border: 1px solid black; */
	width: 390px;
	height: 60px;
	margin: 10px 200px;
	padding: 10px;
}

#search-text {
	width: 300px;
	outline: 0;
	display: inline;
	margin-right: 10px;
}

.temp {
	min-height: 35px;
	/* border: 1px solid black; */
	padding: 5px;
}

/* 수정하며 추가된 소스 */
#searchForm1 {
	position: relative;
	margin: 40px auto;
	width: 100%;
	display: inline-block;
	margin-bottom: 10px;
}

#searchForm2 {
	position: relative;
	margin: 40px auto;
	width: 100%;
	display: inline-block;
	margin-bottom: 10px;
	top: -133px;
}

.search {
	position: relative;
	margin: 0 auto;
	width: 50%;
}

#search {
	height: 40px;
	border: 2px solid #f1aeae;
	border-radius: 40px;
	border-bottom-right-radius: 0;
	border-top-right-radius: 0;
	font-size: 16px;
}

#search2 {
	height: 40px;
	border: 2px solid #f1aeae;
	border-radius: 40px;
	border-bottom-right-radius: 0;
	border-top-right-radius: 0;
	font-size: 16px;
}

#basic-addon2 {
	background-color: #f1aeae;
	color: white;
	outline: none;
	border-radius: 40px;
	border: solid 2px #F1AEAE;
	position: relative;
	width: 90px;
	height: 20px;
	z-index: 2;
	border-bottom-left-radius: 0;
	border-top-left-radius: 0;
	font-size: 16px;
}

#basic-addon3 {
	background-color: #f1aeae;
	color: white;
	outline: none;
	border-radius: 40px;
	border: solid 2px #F1AEAE;
	position: relative;
	width: 90px;
	height: 20px;
	z-index: 2;
	border-bottom-left-radius: 0;
	border-top-left-radius: 0;
	font-size: 16px;
}

#btnsearch {
	position: relative;
	width: 20%;
	margin: 0 auto;
	font-size: 16px;
	z-index: 2;
}

.boardcontent {
	margin: 0 60px;
	font-family: 'NanumBarunGothic', sans-serif;
	font-size: 16px;
}

.property-list {
	width: 100%;
}

.options {
	width: 150px;
	float: left;
	position: relative;
}

label {
	font-weight: normal;
	font-family: 'NanumBarunGothic', sans-serif;
	font-size: 16px;
}

.filters {
	margin: 20px auto;
	display: inline-block;
	width: 800px;
	left: 110px;
	position: relative;
	border-top: 1px solid #ccc;
	padding-top: 20px;
	padding-left: 50px;
	top: 70px;
}

.optionname {
	margin-bottom: 10px;
	background-color: #F1AEAE;
	width: 100px;
	text-align: center;
	color: white;
	padding: 2px 3px;
}
</style>


</head>
<body>


	<!-- <div class="wrap"> -->
	<div class="header-containerwrap">

		<!-- header -->
		<%@include file="/WEB-INF/views/inc/bootstrap-header.jsp"%>

		<div class="container">

			<div id="maintitle">방찾기</div>
			<div style="clear: both;"></div>



			<div class="boardcontent">

				<form id="searchForm1" method="GET"
					action="/Myhome_project/Myhome/user/searchpropertylist.do">
					<div class="input-group search">

						<input type="text" class="form-control" placeholder="지역명을 입력해주세요"
							aria-describedby="basic-addon2" id="search" name="search"
							required value="${search}"> <span
							class="input-group-addon" id="basic-addon2"
							onclick="$('#searchForm').submit();" style="cursor: pointer;"><span>검색</span></span>
					</div>
				</form>
				<div style="clear: both;"></div>


				<div style="width: 100%; text-align: center;">
					<button type="button" class="btn btn-default" id="btnsearch"
						name="btnsearch">
						상세검색 필터 <span class="glyphicon glyphicon-triangle-bottom"></span>
					</button>
				</div>
				<div style="clear: both;"></div>







				<form id="searchForm2" method="GET"
					action="/Myhome_project/Myhome/user/searchpropertylist.do">
					<div class="input-group search">

						<input type="text" class="form-control" placeholder="지역명을 입력해주세요"
							aria-describedby="basic-addon2" id="search2" name="search2"
							required value="${search2}"> <span
							class="input-group-addon" id="basic-addon3"
							onclick="$('#searchForm2').submit();" style="cursor: pointer;"><span>검색</span></span>
					</div>

					<div class="filters" id="filterlist">

						<!-- 매물유형 -->
						<div class="options" id="option1">
							<div class="optionname">매물유형</div>
							<div>
								<input type="radio" name="roomtypeopt" id="opt1" value="원룸">
								<label for="opt1">원룸</label>
							</div>
							<div>
								<input type="radio" name="roomtypeopt" id="opt2" value="투룸">
								<label for="opt2">투룸</label>
							</div>
							<div>
								<input type="radio" name="roomtypeopt" id="opt3" value="오피스텔">
								<label for="opt3">오피스텔</label>
							</div>
						</div>


						<!-- 거래유형 -->
						<div class="options" id="option2">
							<div class="optionname">거래유형</div>
							<div>
								<input type="radio" name="propertytypeopt" id="opt4" value="월세">
								<label for="opt4">월세</label>
							</div>
							<div>
								<input type="radio" name="propertytypeopt" id="opt5" value="전세">
								<label for="opt5">전세</label>
							</div>
							<div>
								<input type="radio" name="propertytypeopt" id="opt6" value="매매">
								<label for="opt6">매매</label>
							</div>
						</div>


						<!-- 건물옵션 -->
						<div class="options" id="option3">
							<div class="optionname">건물옵션</div>
							<div>
								<input type="checkbox" name="buildingopt" id="opt7" value="주차가능">
								<label for="opt7">주차가능</label>
							</div>
							<div>
								<input type="checkbox" name="buildingopt" id="opt8" value="반려동물">
								<label for="opt8">반려동물</label>
							</div>
							<div>
								<input type="checkbox" name="buildingopt" id="opt9" value="베란다">
								<label for="opt9">베란다/발코니</label>
							</div>
							<div>
								<input type="checkbox" name="buildingopt" id="opt10" value="엘리베이터">
								<label for="opt10">엘리베이터</label>
							</div>
						</div>


						<!-- 관리비 -->
						<div class="options" id="option4">
							<div class="optionname">관리비</div>
							<div>
								<input type="radio" name="maintenopt" id="opt11" value="50000">
								<label for="opt11">~5만원</label>
							</div>
							<div>
								<input type="radio" name="maintenopt" id="opt12" value="100000">
								<label for="opt12">~10만원</label>
							</div>
							<div>
								<input type="radio" name="maintenopt" id="opt13" value="101000">
								<label for="opt13">10만원 이상</label>
							</div>
						</div>


						<!-- 보증금 -->
						<div class="options" id="option5">
							<div class="optionname">보증금</div>
							<div>
								<input type="radio" name="depositopt" id="opt14" value="5000000">
								<label for="opt14">~500만원</label>
							</div>
							<div>
								<input type="radio" name="depositopt" id="opt15"
									value="10000000"> <label for="opt15">~1천만원</label>
							</div>
							<div>
								<input type="radio" name="depositopt" id="opt16"
									value="50000000"> <label for="opt16">5천만원 이상</label>
							</div>
						</div>

						<!-- filters -->
					</div>







				</form>
				<div style="clear: both;"></div>









				<div class="map">
					<div class="temppicture"></div>
					<!-- <img src="/Myhome_project/Myhome/image/location.png" width="1190px"> -->
					<!-- <img src="\Myhome_project\WebContent\image\map_1.png" width="1190px"> -->
				</div>
				<div style="clear: both;"></div>









				<!-- 리스트 -->
				<div class="property-box">

					<c:if test="${list.size() == 0}">

						<div style="text-align: center; width: 100%; font-weight: bold;">검색한
							조건의 매물이 존재하지 않습니다.</div>

					</c:if>

					<c:forEach items="${list}" var="dto">
						<div class="property-list">

							<div class="img-property">

								<c:if test="${dto.available == 0 }">
									<div class="state">입주가능</div>
								</c:if>

								<c:if test="${dto.available == 1 }">
									<div class="state">계약완료</div>
								</c:if>

							</div>


							<div class="property-list2">

								<div class="property-num">no. ${dto.seqContractorProperty }</div>
								<div class="property-title"
									onclick="location.href='/Myhome_project/Myhome/user/searchpropertydetaillist.do?seq=${dto.seqContractorProperty}&page=${nowPage}';"
									style="cursor: pointer">${dto.title }</div>


								<div class="property-content" id="roomtype">
									<span>방유형</span>
									<div class="property-content2">${dto.roomType }</div>
								</div>

								<div class="property-content" id="floor">
									<span>층</span>
									<div class="property-content2">${dto.floor }</div>
								</div>

								<div class="property-content" id="contract">
									<span>계약유형</span>
									<div class="property-content2">${dto.contractTypeDetail }</div>
								</div>



								<c:if test="${dto.contractTypeDetail eq '월세'}">
									<div class="property-content" id="price">
										<span>가격</span>
										<div class="property-content2">${dto.monthlyRent }/월(${dto.contractPeriod })</div>
									</div>
								</c:if>

								<c:if test="${dto.contractTypeDetail eq '전세'}">
									<div class="property-content" id="price">
										<span>가격</span>
										<div class="property-content2">${dto.deposit }</div>
									</div>
								</c:if>

								<c:if test="${dto.contractTypeDetail eq '매매'}">
									<div class="property-content" id="price">
										<span>가격</span>
										<div class="property-content2">${dto.dealing }</div>
									</div>
								</c:if>


								<div class="property-location">
									<div class="location-icon" style="float: left;"></div>
									<div class="location-detail">${dto.location }</div>
								</div>

								<!-- Ajax로 보내기 -->
								<input type="hidden" id="seq"
									value="${dto.seqContractorProperty }">
							</div>


						</div>
					</c:forEach>
					<div style="clear: both;"></div>




					<!-- 검색, 페이지바 -->
					<div style="text-align: center;">
						<nav class="pagebar">
							<ul class="pagination" id="page_bar">${pagebar}
							</ul>
						</nav>
					</div>
					<div style="width: 100%;">
						<button type="button" class="btn btn-default" id="basic-addon4"
							onclick="location.href='/Myhome_project/Myhome/user/searchpropertylist.do';">목록</button>
					</div>
					<div style="clear: both;"></div>



					<!-- search-paging -->
				</div>


				<!-- property-box -->
			</div>
			<div style="clear: both;"></div>

		</div>
		<!--boardcontent -->

		<!-- container -->
	</div>




	<!-- </div> -->
	<!-- footer -->
	<%@include file="/WEB-INF/views/inc/footer.jsp"%>

	<script>
		var btnsearch = document.getElementById("btnsearch");
		var filterlist = document.getElementById("filterlist");

		var searchForm1 = document.getElementById("searchForm1");
		var searchForm2 = document.getElementById("searchForm2");

		btnsearch.onclick = function() {

			if (filterlist.style.visibility == 'visible') {

				filterlist.style.visibility = 'hidden';
				searchForm1.style.visibility = 'visible';
				searchForm2.style.visibility = 'hidden';

			} else {

				filterlist.style.visibility = 'visible';
				searchForm1.style.visibility = 'hidden';
				searchForm2.style.visibility = 'visible';

			}
		}
	</script>


</body>
</html>