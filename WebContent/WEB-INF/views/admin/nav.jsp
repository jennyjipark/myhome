<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="/Myhome_project/css/nav.css">
<%@include file="/WEB-INF/views/inc/asset.jsp"%>

<style>
.nav1-box1 {
	border: none;
	height: auto;
}

.navsub {
	background-color: white;
	text-align: center;
	padding-bottom: 10px;
	width: 130px;
	position: absolute;
	left: 200px;
	z-index: 1;
}

.navsub a {
	display: block;
}

input[id="menu1"] {
	display: none;
	position: relative;
}

#menu1:checked+label+.navsub {
	display: none;
}

input[id="menu2"] {
	display: none;
	position: relative;
}

#menu2:checked+label+.navsub {
	display: none;
}

input[id="menu3"] {
	display: none;
	position: relative;
}

#menu3:checked+label+.navsub {
	display: none;
}

input[id="menu4"] {
	display: none;
	position: relative;
}

#menu4:checked+label+.navsub {
	display: none;
}

input[id="menu5"] {
	display: none;
	position: relative;
}

#menu5:checked+label+.navsub {
	display: none;
}

input[id="menu6"] {
	display: none;
	position: relative;
}

#menu6:checked+label+.navsub {
	display: none;
}

#userupdate{

style="line-height: 35px; 
margin:0px 0px 5px;
margin-top:-5px;
}

</style>
</head>
<body>
	<nav class="nav1">
		<div id="mypage-title">관리자페이지</div>
		<div class="nav1-box1">

			<div class="nav1-content" id="nav1-content4">
				<div class="nav1-box1-img glyphicon glyphicon-user"></div>
				<div class="nav1-content" id="nav1-content1">
					<div class="nav1-box1-content nav-list" >
					
					<input type="button" id="menu1" onclick="location.href='/Myhome_project/admin/membermanage/membermanage-user.do';">
					<label for="menu1">회원정보관리</label>
					</div>
				</div>

			</div>

			<div class="nav1-content" id="nav1-content1">
				<div class="nav1-box1-img glyphicon glyphicon-briefcase"></div>
				<div class="nav1-box1-content cleanmovemanage nav-list">

					<input type="checkbox" id="menu2" name="menupage" checked>
					<label for="menu2">제휴업체관리</label>
					<div class="navsub">
						<a id="move" onclick="location.href='/Myhome_project/admin/moveclean/listmove.do';" class="nav-list move  " >이사업체</a> 
						<a id="clean" onclick="location.href='/Myhome_project/admin/moveclean/listclean.do';" class="nav-list clean ">청소업체</a>
					</div>


				</div>

			</div>

			<div class="nav1-content" id="nav1-content1">
				<div class="nav1-box1-img glyphicon glyphicon-home"></div>
				<div class="nav1-box1-content nav-list propertymanage nav-list">

					<input type="checkbox" id="menu3" name="menupage" checked>
					<label for="menu3">매물관리</label>
					<div class="navsub">
						<a id="chart" onclick="location.href='/Myhome_project/admin/chart/listchart.do';" class="nav-list payment  ">가격변화</a> 
						<a id="property" onclick="location.href='/Myhome_project/admin/property/listproperty.do';" class="nav-list property ">매물관리</a> 
						<a id="" href="" class="nav-list adminalert ">알림서비스</a>
					</div>


				</div>

			</div>




			<div class="nav1-content" id="nav1-content2">
				<div class="nav1-box1-img glyphicon glyphicon-list-alt"></div>
				<div class="nav1-box1-content nav-list">


					<input type="checkbox" id="menu4" name="menupage" checked>
					<label for="menu4">게시판관리</label>
					<div class="navsub">
						<a id="policy" onclick="location.href='/Myhome_project/admin/board/listpolicy.do';" class="nav-list adpolicy">부동산정책</a> 
						<a id="checklist" onclick="location.href='/Myhome_project/admin/board/listchecklist.do';" class="nav-list adchecklist ">체크리스트</a> 
						<a id="" href="" class="nav-list adapplication ">청약안내</a> 
						<a id="" href="" class="nav-list adcommunity ">정보공유커뮤니티</a> 
						<a id="" href="" class="nav-list adused ">중고물품게시판관리</a>


					</div>


				</div>
			</div>


			<div class="nav1-content" id="nav1-content2">
				<div class="nav1-box1-img glyphicon glyphicon-pencil"></div>
				<div class="nav1-box1-content contractmanage nav-list onemenu">

					<input type="button" id="menu5" onclick="location.href='/Myhome_project/admin2/contract/list.do'">
					<label for="menu5">전자계약</label>

				</div>
			</div>



			<div class="nav1-content" id="nav1-content3">
				<div class="nav1-box1-img glyphicon glyphicon-heart"></div>
				<div class="nav1-box1-content nav-list nav-list">

					<input type="checkbox" id="menu6" name="menupage" checked>
					<label for="menu6">고객센터</label>
					<div class="navsub">
						<a id="" href="" class="nav-list adnotice">공지사항</a> 
						<a id="" href="" class="nav-list adqna">QnA</a> 
						<a id="" href="" class="nav-list adreport">신고관리</a>

					</div>
				</div>
			</div>

		</div>
	</nav>

	<script>
		$("input[type='checkbox'][name='menupage']").click(
				function() {
					if (!$(this).prop('checked')) {
						console.log("12123");
						$('input[type="checkbox"][name="menupage"]').prop(
								'checked', true);
						$(this).prop('checked', false);
					}
				});
	</script>

</body>
</html>