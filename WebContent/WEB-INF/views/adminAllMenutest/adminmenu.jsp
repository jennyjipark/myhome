<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지 첫화면</title>

<%-- <%@include file="/WEB-INF/views/inc/asset.jsp" %> --%>

<!-- <link rel="stylesheet" href="/Myhome_project/css/main.css"> -->
<link rel="stylesheet" href="/Myhome_project/css/template.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<%@include file="/WEB-INF/views/inc/asset.jsp"%>

<style>
<
style>body, html {
	height: 100%;
	margin: 0 auto;
	padding: 0;
}

.container {
	width: 1190px;
	margin: 0px auto;
	margin-top: 100px;
	position: relative;
	height: 1000px;
	font-family: 'MaplestoryOTFLight';
	font-size: 50px;
	background-image: url(../image/3.jpg);
	background-size: cover;
	color: #333;
}

.section1 {
	text-align: center;
	margin: 50px;
	margin-top: 100px;
	background-color: rgb(245, 245, 245, .6);
}

.section1 #title {
	border-bottom: 1px dashed black;
	margin-bottom: 50px;
	padding: 40px;
}

.container .menu {
	border-radius: 8px;
	width: 400px;
	height: 100px;
	float: left;
	margin: 30px 50px;
	font-size: 30px;
	background-color: rgb(245, 245, 245);
}

.container .menu:hover {
	color: rgb(245, 245, 245);
	background-color: #F6ABAF;
	cursor: pointer;
}

.container .explain {
	font-size: 15px;
	background-color: #d7d7d7;
	height: 40px;
}

.container .image {
	border: 3px solid #F6ABAF;
	border-radius: 8px;
	height: 100px;
	width: 100px;
	float: left;
	font-size: 85px;
	background-color: white;
	margin-right: 20px;
	color: #F6ABAF;
	padding: 5px;
}

.test {
	height: auto;
	min-height: 100%;
}


</style>
</head>
<body>
		<div class="test">
			<!-- header -->
			<%@include file="/WEB-INF/views/inc/header.jsp"%>


			<div class="container">
				<div class="section1">
					<div id="title">관리자게시판</div>
					<div class="section2">
						<div class="menu"
							onclick="location.href='/Myhome_project/adminAllMenu/admin-userInfo.do';">

							<div class="image">
								<span class="glyphicon glyphicon-user"></span>
							</div>
							회원정보관리 <span></span>
							<div class="explain">회원정보수정+거래정보관리</div>
						</div>

						<div class="menu" onclick="location.href='/user/mypageinfo.do';">

							<div class="image">
								<span class="glyphicon glyphicon-bookmark"></span>
							</div>

							제휴업체 관리
							<div class="explain">이사 ＊ 청소 업체</div>
						</div>

						<div class="menu"
							onclick="location.href='/Myhome_project/user/mypageinfo.do';">

							<div class="image">
								<span class="glyphicon glyphicon-pencil"></span>
							</div>

							매물관리
							<div class="explain">가격변화, 매물관리, 알림</div>
						</div>
						<div class="menu"
							onclick="location.href='/Myhome_project/user/mypageinfo.do';">

							<div class="image">
								<span class="glyphicon glyphicon-align-justify"></span>
							</div>

							고객센터
							<div class="explain">공지사항 QnA 신고</div>
						</div>
						<div class="menu"
							onclick="location.href='/Myhome_project/user/mypageinfo.do';">

							<div class="image">
								<span class="glyphicon glyphicon-resize-small"></span>
							</div>

							전자계약
							<div class="explain">전자 계약 조회</div>
						</div>

						<div class="menu"
							onclick="location.href='/Myhome_project/user/mypageinfo.do';">

							<div class="image">
								<span class="glyphicon glyphicon-list-alt"></span>
							</div>

							기타 게시판관리
							<div class="explain">중고장터, 커뮤니티 등.</div>
						</div>
						<div style="clear: both;"></div>
					</div>
				</div>
			</div>
		</div>

		<!-- footer -->
		<%@include file="/WEB-INF/views/inc/footer.jsp"%>

	</div>
</body>
</html>