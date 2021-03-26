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

	.boardbutton{
		width:940px;
		padding-right:120px;
		float:right;
		text-align:right;
        margin-top:-100px;
	}
	
    .boardbutton:after{
        content: "";
        display: block;
        clear: both;
	}
	.boardbutton button{
		
		display:inline-block;	
        outline: none;
        border: 0px solid #000;
        background-color: #f1aeae;
        color: white;
        width: 70px;
        height: 34px;
        margin-right:5px;
        margin-bottom:10px;
        border-radius: 3px;
        z-index:99;
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

			<form method="" action="">

				<table id="navboardtbl">

					<tr id="navboardtr">
						<td class="navboardtd">
							<!-- nav --> <%@include file="/WEB-INF/views/admin/nav.jsp"%>

						</td>

						<!-- 상세 보기 입니다.-->

						<td class="navboardtd">
							<div id="boardtitle" class="">청약안내게시판</div>

							<div class="boardcover">
								<table id="board"
									class="table table-hover table-striped table-condensed">

									<tr class="headtr">
										<th class="firtd boardtd">${dto.seqApplication}</th>
										<th class="sectd boardtd">${dto.title }</th>
										<th class="thitd boardtd">Admin${dto.seqAdmin }</th>
										<th class="fortd boardtd">${dto.writedate}</th>
										<th class="fiftd boardtd">${dto.viewcount}</th>
									</tr>
									<tr>
										<td colspan="5" style="text-align:center;">
										<a href="https://apply.lh.or.kr/LH/index.html#MN::CLCC_MN_0010:" target="_blank">
										LH 청약 센터 이동 [https://apply.lh.or.kr/]</a>
										</td>
									</tr>
									<tr class="headtr">
										<th colspan="5" style="text-align:center;" > 청약 공고 주소</th>
									</tr>
									<tr>
										<td colspan="5" style="text-align:center;">
										서울특별시 서초구 신반포로 270
										</td>
									</tr>
									<tr class="boardtr">
										<td class="firtd boardtd" colspan="5"><textarea
												class="form-control col-sm-5 boardtext"
												placeholder="여기에 게시글을 작성해주세요" rows="15" disabled>${dto.content}</textarea>
										</td>
									</tr>
								</table>
							</div> 
							<input type="hidden" name="seq" value="${dto.seqApplication}">
							<!-- 첨부파일  테스트용으로 일단 만듬 -->
							
							<div class="boardfile">
								<input type="file" class="form-control " id="inputGroupFile02"
									<c:if test="${dto.savefile == ' '}">
										disabled
									</c:if>
									
									> <label class="" for="inputGroupFile02"></label>
							</div> <!-- 버튼 --> <!-- 지금은 삭제? 아니면 안보이게? -->
								
						<div class="boardbutton">
							<button id="ApplicaionMap" type="button"  
 							onclick="location.href='/Myhome_project/admin2/application/map.do?seq=${dto.seqApplication}';">
							상세</button>
							<button id="Communitylist" type="button"  
							onclick="location.href='/Myhome_project/admin2/application/list.do';">
							목록</button>
							<button id="applicationdel" type="button"
							onclick="location.href='/Myhome_project/admin2/application/edit.do?seq=${dto.seqApplication}';">
							수정
							</button>
						  	<button id="checkerr" type="button"
						  	onclick="location.href='/Myhome_project/admin2/application/delete.do?seq=${dto.seqApplication}';">
						  	삭제</button>	
							
						</div>			
						
						<!-- 	<div class="boardwork d-grid gap-2 d-md-block btn-group">
								<button class="btn btn-outline-secondary " type="button"
									id="button-addon2"
									onclick="location.href='/Myhome_project/admin2/application/list.do';">
									목록</button>
								<button class="btn btn-outline-secondary " type="submit"
									id="button-addon2"
									>
									삭제</button>		
							</div> -->
						</td>
					</tr>
				</table>
			
		</form>


		</div>

	</div>

	<!-- footer -->
	<%@include file="/WEB-INF/views/inc/footer.jsp"%>


	<script>
		
	</script>



</body>
</html>