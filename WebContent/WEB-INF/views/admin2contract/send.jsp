<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지 -> 전자계약</title>

<%-- <%@include file="/WEB-INF/views/inc/asset.jsp" %> --%>

<!-- <link rel="stylesheet" href="/Myhome_project/css/main.css"> -->
<link rel="stylesheet" href="/Myhome_project/css/template.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="/Myhome_project/css/board.css"">
<%@include file="/WEB-INF/views/inc/asset.jsp"%>

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

#navboardtbl .navboardtd:first-child {
	width: 200px;
}

.navboardtd {
	vertical-align: top;
}

#boardtitle {
	width: 300px;
	height: 70px;
	font-size: 23px;
	font-weight: bolder;
	margin: 20px;
	text-align: center;
	color: white;
	background-color: #f1aeae;
	border-radius: 20px;
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
		<%@include file="/WEB-INF/views/inc/header.jsp"%>

		<div class="container">

			<form action="" id="form1">

				<table id="navboardtbl">

					<tr id="navboardtr">
						<td class="navboardtd">
							<!-- nav --> <%@include file="/WEB-INF/views/adminmenu/nav.jsp"%>

						</td>

						<!---->

						<td class="navboardtd">
							<div id="boardtitle" class=" alert alert-success">전자계약게시판</div>

							<div class="boardcover">

								<table id="board"
									class="table table-hover table-striped table-condensed">

									<tr class="headtr">
										<!--<th class="firtd boardtd">계약번호</th>-->
										<!--<th class="sectd boardtd"></th>-->
										<!--<th class="thitd boardtd"></th>-->
										<th class="fiftd boardtd">계약번호</th>
										<th class="fortd boardtd">임차인</th>
										<th class="fortd boardtd">임대인</th>
										<th class="fortd boardtd">중개인</th>
										<th class="thitd boardtd">주소</th>
										<th class="fiftd boardtd">작성일</th>
										<th class="fiftd boardtd">계약상태</th>
										<th class="sixtd boardtd">암호</th>
									</tr>
									<!--  암호 입력에 대한 재발 송은 임대인 중개인이, 임차인의 암호가 단 한개라도 null 이면 입력 상태 재발송 안내 문구 -->
									<tr class="boardtr">
										<td class="fiftd boardtd">0000001</td>
										<td class="thitd boardtd">아마홍길동</td>
										<td class="thitd boardtd">아마임대인</td>
										<td class="fortd boardtd">
											<div class="Boardtdtitle">아마홍길동</div>
										</td>
										<td class="fiftd boardtd">
											<div class="Boardtdtitle">주소 입니다. 블라 불르</div>
										</td>
										<td class="fortd boardtd">작성일</td>
										<td class="fiftd boardtd">계약상태</td>
										<td class="sixtd boardtd"><input type="checkbox"
											name="seq" id="seq"></td>
									</tr>
									<tr class="boardtr">
										<td class="fiftd boardtd">0000001</td>
										<td class="thitd boardtd">아마홍길동</td>
										<td class="thitd boardtd">아마임대인</td>
										<td class="fortd boardtd">
											<div class="Boardtdtitle">아마홍길동</div>
										</td>
										<td class="fiftd boardtd">
											<div class="Boardtdtitle">주소 입니다. 블라 불르</div>
										</td>
										<td class="fortd boardtd">작성일</td>
										<td class="fiftd boardtd">계약상태</td>
										<td class="sixtd boardtd"><input type="checkbox"
											name="seq" id="seq"></td>
									</tr>
									<tr class="boardtr">
										<td class="fiftd boardtd">0000002</td>
										<td class="thitd boardtd">아마홍길동</td>
										<td class="thitd boardtd">아마임대인</td>
										<td class="fortd boardtd">
											<div class="Boardtdtitle">아마홍길동</div>
										</td>
										<td class="fiftd boardtd">
											<div class="Boardtdtitle">주소 입니다. 블라 불르</div>
										</td>
										<td class="fortd boardtd">2020-01-21</td>
										<td class="fiftd boardtd">계약상태</td>
										<td class="sixtd boardtd"><input type="checkbox"
											name="seq" id="seq"></td>
									</tr>
									<tr class="boardtr">
										<td class="fiftd boardtd">0000003</td>
										<td class="thitd boardtd">아마홍길동</td>
										<td class="thitd boardtd">아마임대인</td>
										<td class="fortd boardtd">
											<div class="Boardtdtitle">아마홍길동</div>
										</td>
										<td class="fiftd boardtd">
											<div class="Boardtdtitle">주소 입니다. 블라 불르</div>
										</td>
										<td class="fortd boardtd">작성일</td>
										<td class="fiftd boardtd">계약상태</td>
										<td class="sixtd boardtd"><input type="checkbox"
											name="seq" id="seq"></td>
									</tr>

								</table>
							</div>

							<div class="boardwork d-grid gap-2 d-md-block btn-group">
								<button class="btn btn-outline-secondary " type="button"
									id="button-addon2"
									onclick="location.href='/Myhome-project/admin2/contract/send.do';">
									발송</button>
								<button class="btn btn-outline-secondary " type="button"
									id="button-addon2">조회</button>
							</div>


							<div class="boardserch">
								<input type="text" class="" placeholder="Recipient's username"
									aria-label="Recipient's username"
									aria-describedby="button-addon2">
								<button class="btn btn-outline-secondary" type="button"
									id="button-addon2">Button</button>
							</div>

							
					
							<div class="Boardnext">
								<span class="tenplcount countbt ">◀</span>
								<!-- 10개 이상일 경우에 1개씩 생기도록 화살표 태그에 개별 클래스를 입력하였습니다.!-->
								<span class="countbt">1</span> <span class="tenmicount countbt">▶</span>
							</div>
					<tr>
						<td></td>
					</tr>
				</table>
			</form>



		</div>

	</div>

	<!-- footer -->
	<%@include file="/WEB-INF/views/inc/footer.jsp"%>


	<script>

	$("input[type='checkbox'][name='seq']").click(function(){
        if($(this).prop('checked')){
            
            $('input[type="checkbox"][name="seq"]').prop('checked',false);
            $(this).prop('checked',true);
        }
    });
		
	
	
	
	</script>



</body>
</html>