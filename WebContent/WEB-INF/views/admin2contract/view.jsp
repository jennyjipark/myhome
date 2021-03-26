<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::전자계약</title>

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

/* 타이틀 수정 */
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

/*여기서 부터 수정 css*/
.boardwork {
	margin-top: 200px;
}

#adcontracttbl {
	width: 800px;
	margin-left: 0px; /* 마진  기존 20px*/
	table-layout: fixed;
}

#adcontracttbl .headtr th {
	text-align: center;
}

.adcontacttd {
	text-align: center;
}
/*.adcontacttd>*/
input
[
type
=
"text"
]
{
border
:
0px
solid
#000;
background-color
:
#d1e7dd;
text-align
:
center;
margin
:
0px;
padding
:
0px;
outline
:
none;
}
#adcontracttbl td {
	text-align: center;
}



.contractadd {
	overflow: hidden;
}

/*버큰 !! */
.boardbutton {
	width: 940px;
	padding-right: 120px;
}

.boardbutton button {
	float: right;
	display: inline-block;
	outline: none;
	border: 0px solid #000;
	background-color: #f1aeae;
	color: white;
	width: 110px;
	height: 34px;
	margin-right: 5px;
	margin-bottom: 10px;
	border-radius: 3px;
}

.boardbutton button:after {
	content: "";
	display: block;
	clear: both;
}
/*  수정 본    02/20*/
/* 전자계약 css */
#adcontracttbl {
	width: 800px;
	margin-left: 20px;
	table-layout: fixed;
}

#adcontracttbl .headtr th {
	text-align: center;
	background-color: #ffe7e7;
}

.adcontacttd {
	text-align: center;
}

.info-color {
	background-color: #ececec !important;
}

/*.adcontacttd>*/
input[type="text"] {
	border: 0px solid #000;
	text-align: center;
	margin: 0px;
	padding: 0px;
	outline: none;
}

#adcontracttbl td {
	text-align: center;
}

#contractcontent {
	width: 800px;
	overflow: hidden;
	height: 200px;
	resize: none;
	padding: 0px;
}

.contractadd {
	overflow: hidden;
}

.low {
	text-align: left;
	padding: 30px 5px;
}

.low-title {
	font-weight: bold;
}

.low>.underline {
	text-decoration: underline;
}

.radio {
	margin-left: 20px;
}

/* 암호입력 div 세로 크기 조절 */
.vertical-align {
	/* border: 1px solid black; */
	width: 70px;
	height: 30px;
	padding: 5px 0px;
}

/* 계약하기/폐기하기 버튼 */
.btn-contract {
	/* border: 1px solid black; */
	width: 850px;
	height: 50px;
	padding: 10px 330px;
	margin-top: 70px;
	float: left;
}

.btn-contract1 {
	background-color: #f1aeae;
	color: white;
	outline: none !important;
	font-family: 'NanumBarunGothic';
	border: 1px solid #f1aeae;
	margin-right: 15px;
}

.navboardtd {
	height: 1500px;
}

.boardbutton {
	margin-top: 850px;
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

						<!---->

						<td class="navboardtd">
							<div id="boardtitle" class="">전자계약서조회</div>

							<div class="boardcover">


								<!-- 리스트 -->
								<div class="property-box">

									<form action="" id="form1">

										<!-- 전자계약서 -->
										<div class="matching-board">


											<div class="boardcover">

												<!-- 전세, 월세 라디오 버튼 
												<div class="radio">
													<label class="custom-control-label" for="rd1"> <input
														type="radio" name="rd1" id="rd1" class=""> 전세
													</label> <label class="custom-control-label" for="rd2"> <input
														type="radio" name="rd1" id="rd2" class=""> 월세
													</label>
													
												</div>
												radio 끝 -->


												<table id="adcontracttbl" class="table table-condensed">
													<tr class="headtr">
														<th class="adcontacttd title-color">계약번호</th>
														<td class="adcontacttd" colspan="2">${dto.seqC}</td>
														<th class="adcontacttd">계약일자</th>
														<td class="adcontacttd" colspan="3">${dto.contractDate}</td>
														<th class="adcontacttd">계약상태</th>
														<td class="adcontacttd" colspan="2">${dto.state}</td>
													</tr>

													<tr class="headtr">
														<th class="adcontacttd info-color" colspan="10">부동산의
															표시</th>
													</tr>

													<tr class="headtr">
														<th class="adcontacttd title-color">주소</th>
														<td class="adcontacttd" colspan="9">${dto.location}</td>
													</tr>
												<c:if test="${dto.type =='매매'}">
													<tr class="headtr">
														<th class="adcontacttd title-color">금액</th>
														<td class="adcontacttd" colspan="3">${dto.dealing}</td>
														<th class="adcontacttd title-color">계약금</th>
														<td class="adcontacttd" colspan="3">${dto.deposit}</td>
														<th class="adcontacttd title-color">계약종류</th>
														<td class="adcontacttd">${dto.type}</td>
													</tr>
												</c:if>
												<c:if test="${dto.type !='매매'}">
													<tr class="headtr">
														<th class="adcontacttd title-color">보증금</th>
														<td class="adcontacttd" colspan="3">${dto.deposit}</td>
														<th class="adcontacttd title-color">월세</th>
														<td class="adcontacttd" colspan="3">${dto.monthlyRent}</td>
														<th class="adcontacttd title-color">계약종류</th>
														<td class="adcontacttd">${dto.type}</td>
													</tr>
												</c:if>

													<tr>
														<td class="adcontacttd" colspan="10">
															<!-- 법률 -->
															<div class="low">

																<span class="low-title">제 2조 (존속기간)</span> 임대인은 위 부동산을
																임대차 목적대로 사용 수익할 수 있는 상태로 <span>2021년 00월 00일</span> 까지
																임차인에게 인도하며, 임대차 기간은 인도일로부터 <span class="underline">2021년
																	00월 00일</span>까지로 한다.<span class="underline">(00개월)</span> <br>
																<br> <span class="low-title">제 3조 (용도변경 및 전대
																	등)</span> 임차인은 임대인의 동의없이 위 부동산의 용도나 구조를 변경하거나 전대 임차원 양도 또는 담보
																제공을 하지 못하게 하며 임대차 목적 이외의 용도로 사용할 수 없다. <br> <br>
																<span class="low-title">제 4조 (계약의 해지)</span> 임차인이 제3조를
																위반하였을 때 임대인은 즉시 본 계약을 해지할 수 있다. <br> <br> <span
																	class="low-title">제 5조 (계약의 종료)</span> 임대차계약이 종료된 경우에
																임차인은 위 부동산을 원상으로 회복하여 임대인에게 반환한다. <br> <br> <span
																	class="low-title">제 6조 (계약의 해제)</span> 임차인이 임대인에게
																중도금(중도금이 없을 때는 잠금)을 지불하기 전까지, 임대인은 계약금의 배액을 상환하고, 임차인은
																계약금을 포기하고 본 계약을 해제할 수 있다. <br> <br> <span
																	class="low-title">제 7조 (채무불이행과 손해배상)</span> 임대인 또는 임차인이
																본 계약상의 내용에 대하여 불이행이 있을 경우 그 상대방은 불이행한 자에 대하여 서면으로 최고하고
																계약을 해제할 수 있다. 그리고 계약 당사자는 계약해제에 따른 손해배상을 각각 상대방에 대하여 청구할
																수 있으며, 손해배상에 대하여 별도의 약정이 없는 한 계약금을 손해배상의 기준으로 본다. <br>
																<br> <span class="low-title">제 8조 (중개보수)</span>
																개업공인중개사는 임대인과 임차인이 본 계약을 불이행함으로 인한 책임을 지지 않는다. 또한, 중개보수는
																본 계약체결과 동시에 계약 당사자 쌍방이 각각 지불하며, 개업공인중개사 고의나 과실없이 본 계약이
																무효·취소 또는 해제되어도 중개보수는 지급한다. 공동중개인 경우에 임대인과 임차인은 자신이 중개
																의뢰한 개업공인중개사에게 각각 중개보수를 지급한다. (중개보수는 거래가액의<span
																	class="underline">00%로</span> 한다.) <br> <br>
																<span class="low-title">제 9조 (중개대상물확인·설명서 교부 등)</span>
																개업공인중개사는 중개대상물 확인·설명서를 작성하고 업무보증관계증서(공제증서 등) 사본을 첨부하여
																계약체결과 동시에 거래당사자 쌍방에게 교부한다.
															</div>

														</td>
													</tr>
													<tr>
														<td class="adcontacttd" colspan="10"">
														<textarea id="contractcontent" rows="7" disabled  placeholder="추가 특약 사항을 입력해 주세요.">${dto.content}</textarea>
														</td>
													</tr>

													<!-- 임차인 정보 -->
													<tr>
														<th class="adcontacttd info-color" colspan="10">임차인
															정보</th>
													</tr>


													<tr class="headtr">
														<th class="adcontacttd">계약자명</th>
														<td class="adcontacttd" colspan="3"><input
															type="text" style="width: 200px;" value="${dto.nameT}"></td>
														<th class="adcontacttd" colspan="1">전화번호</th>
														<td class="adcontacttd" colspan="2"><input
															type="text" style="width: 140px;" value="${dto.telT}"></td>
														<th class="adcontacttd">주민번호</th>
														<td class="adcontacttd" colspan="2"><input
															type="text" value="${dto.idnumberT}"></td>
													</tr>



													<tr class="headtr">
														<th class="adcontacttd" colspan="1">주소</th>
														<td class="adcontacttd" colspan="6"><input
															type="text" style="width: 450px;"
															value="${dto.addT}"></td>
														<th class="adcontacttd" colspan="2">암호입력상태</th>
														<td class="adcontacttd" colspan="1"><input
															type="text"
															style="width: 80px; background-color: transparent; disabled"
															
														<c:if test="${empty dto.signT}">
															value='입력'
														</c:if>
														<c:if test="${not empty dto.signT}">
															value='미입력'
														</c:if>
															
															disabled></td>
														<!-- 여기를  전자계약서 입력시에는 2,암호입력상태  조회시 1,암호임력  크기조절한다 -->
													</tr>

													<!-- 암호입력 -->
													<tr class="headtr">
														<th class="adcontacttd" colspan="1"><div
																class="vertical-align">암호입력</div></th>
														<td class="adcontacttd" colspan="9"><input
															type="text" class="form-control" disabled
															placeholder="암호를 입력해주세요."></td>
													</tr>





													<!-- 임대인 정보 -->
													<tr>
														<th class="adcontacttd info-color" colspan="10">임대인
															정보</th>
													</tr>


													<tr class="headtr">
														<th class="adcontacttd">계약자명</th>
														<td class="adcontacttd" colspan="3"><input
															type="text" style="width: 200px;" value="${dto.nameL}"></td>
														<th class="adcontacttd" colspan="1">전화번호</th>
														<td class="adcontacttd" colspan="2"><input
															type="text" style="width: 140px;" value="${dto.telL}"></td>
														<th class="adcontacttd">주민번호</th>
														<td class="adcontacttd" colspan="2"><input
															type="text" value="${dto.idNumberL}"></td>
													</tr>



													<tr class="headtr">
														<th class="adcontacttd" colspan="1">주소</th>
														<td class="adcontacttd" colspan="6"><input
															type="text" style="width: 450px;"
															value="${dto.addL}"></td>
														<th class="adcontacttd" colspan="2">암호입력상태</th>
														<td class="adcontacttd" colspan="1"><input
															type="text" 
															style="width: 80px; background-color: transparent;"
															
														<c:if test="${empty dto.signL}">
															value='입력'
														</c:if>
														<c:if test="${not empty dto.signL}">
															value='미입력'
														</c:if>
															
															
															disabled></td>
														<!-- 여기를  전자계약서 입력시에는 2,암호입력상태  조회시 1,암호임력  크기조절한다 -->
													</tr>


													<!-- 암호입력 -->
													<tr class="headtr">
														<th class="adcontacttd" colspan="1"><div
																class="vertical-align">암호입력</div></th>
														<td class="adcontacttd" colspan="9"><input
															type="text" class="form-control" disabled
															placeholder="암호를 입력해주세요."></td>
													</tr>



													<!-- 중개인 정보 -->
													<tr>
														<th class="adcontacttd info-color" colspan="10">중개인
															정보</th>
													</tr>


													<tr class="headtr">
														<th class="adcontacttd">계약자명</th>
														<td class="adcontacttd" colspan="3"><input
															type="text" style="width: 200px;" value="${dto.nameC}"></td>
														<th class="adcontacttd" colspan="1">전화번호</th>
														<td class="adcontacttd" colspan="2"><input
															type="text" style="width: 140px;" value="${dto.telC}"></td>
														<th class="adcontacttd">주민번호</th>
														<td class="adcontacttd" colspan="2"><input
															type="text" value="${dto.companyNumberC}"></td>
													</tr>



													<tr class="headtr">
														<th class="adcontacttd" colspan="1">주소</th>
														<td class="adcontacttd" colspan="6"><input
															type="text" style="width: 450px;"
															value="${dto.addC}"></td>
														<th class="adcontacttd" colspan="2">암호입력상태</th>
														<td class="adcontacttd" colspan="1"><input
															type="text" 
															style="width: 80px; background-color: transparent;"
															
															
														<c:if test="${empty dto.signC}">
															value='입력'
														</c:if>
														<c:if test="${not empty dto.signC}">
															value='미입력'
														</c:if>
															
															
															
															disabled></td>
														<!-- 여기를  전자계약서 입력시에는 2,암호입력상태  조회시 1,암호임력  크기조절한다 -->
													</tr>


													<tr class="headtr">
														<th class="adcontacttd" colspan="1"><div
																class="vertical-align">암호입력</div></th>
														<td class="adcontacttd" colspan="9"><input
															type="text" class="form-control" disabled
															placeholder="암호를 입력해주세요."></td>
													</tr>
												</table>


												<!-- boardcover  -->
											</div>

										</div>


										<!-- 계약하기 버튼
										<div class="btn-contract">
											<input type="button" class="btn btn-contract1" value="계약하기">
											<input type="button" class="btn btn-contract1" value="폐기하기">
										</div>
 										-->
									</form>


									<!-- property-box -->
								</div>





								<!-- container -->
							</div>



							<div class="boardbutton">
								<button id="passwordupdate" type="button">암호재등록</button>

								<button id="statechange"  type="button">상태변경</button>
								<button onclick="location.href='/Myhome-project/admin2/contract/list.do';" >목록</button>
							</div>

						</td>
					</tr>
				</table>



		</div>

	</div>

	<!-- footer -->
	<%@include file="/WEB-INF/views/inc/footer.jsp"%>


	<script>

		/*어떻게 이동하는건가요.. 흠..*/
		$("#passwordupdate").click(function(){

		    var con_test = confirm("암호를 재입력 하시겠습니까??");
		    if(con_test == true){
		    	location.href='http://localhost:8090/Myhome_project/admin2/contract/.do';
		    }

		});
		
		
		$("#statechange").click(function(){
			/*페이지 이동 어떻게 하지?*/
		    var con_test = confirm("계약 상태를 취소로 변경하시겠습니까??");
		    if(con_test == true){
		    	location.href='list.jsp';
		    }

		});
	</script>



</body>
</html>