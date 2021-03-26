<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::정보공유커뮤니티</title>

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
	margin-buttom: 100px;
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


	/*버트 새로 고침 */
	
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


/* 댓글 css 입니다. */
.MyhomeCommentRow {
	width: 940px;
}
.commentinfo{
width:700px;
border-bottom:1px solid #f1aeae;
}

.commentinfo>textarea {
	outline: none;
	border: 0px;
	width: 520px;
	font-size: 12px;
	overflow:visible;
	resize:none;
}

.subinfo {
	float: right;
	margin-right: 10px;
	font-size: 11px;
	text-align: center;

}

.subinfo>::after {
	content: "";
	display: block;
	clear: both;
}

.subinfo>button {
	border: 0;
	background-color: #f1aeae;
	color: white;
	width: 70px;
	border-radius: 3px;
}

#commentname {
	vertical-align: top;
	width: 80px;
	text-align: center;
	border: 0;
	outline:none;
	font-family: 'MaplestoryOTFLight';
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
							<div id="boardtitle" class="">정보공유커뮤니티</div>

							<div class="boardcover">
								<table id="board"
									class="table table-hover table-striped table-condensed">
									<!--  ?는 데이터 직접 넣기  -->
									<tr class="headtr">
										<th class="firtd boardtd">${dto.seqCommunity}</th>
										<th class="sectd boardtd">${dto.title}</th>
										<th class="thitd boardtd">${dto.id}</th>
										<th class="fortd boardtd">${dto.writeDate}</th>
										<th class="fiftd boardtd">${dto.viewCount}</th>
									</tr>

									<tr class="boardtr">
										<td class="firtd boardtd" colspan="5"><textarea
												class="form-control col-sm-5 boardtext" style="resize: none;"
												placeholder="여기에 게시글을 작성해주세요" rows="15" disabled>${dto.content}</textarea>
										</td>

									</tr>

								</table>
							</div> 
							
						<!-- 버튼 -->	
						<div class="boardbutton">
							<button id="Communitylist" type="button" onclick="location.href='/Myhome_project/admin2/community/list.do';">
							목록</button>
							<button id="communitydel" type="button" 
							onclick="location.href='/Myhome_project/admin2/community/delete.do?seq=${dto.seqCommunity}';">
							삭제</button>
						  	<!-- <button id="checkerr" type="button" onclick="location.href='/Myhome-project/admin2/community/check.do';">
						  	검열</button>	 -->
						</div>					
							
							<!--  댓글  -->


							<div class="myhomecomment">
								<!-- 여기 행을 움직이자-->
								
								<c:if test="${dto.count != '0' }">	
								<c:forEach items="${list}" var="cdto">
				
								<div class="MyhomeCommentRow">
									<div class="commentinfo">
										<input type="text" id="commentname" value="${cdto.id }">
										<textarea name="" id="" cols="40" rows="2" >${cdto.content}</textarea>
										<div class="subinfo">
											<span class="commentdate">${cdto.writeDate}</span>
											<button  type="button"  
											onclick="location.href='/Myhome_project/admin2/community/delcommentok.do?seq=${cdto.seqCommunityComment}&seqC=${dto.seqCommunity}'">
											삭제</button>
										</div>
									
									</div>
								</div>
								</c:forEach>
								</c:if>

							</div>
							
							
								<!-- 첨부파일  
							<div class="boardfile">
							  <input type="file" class="form-control " id="inputGroupFile02" disabled>
							  <label class="" for="inputGroupFile02"></label>
							</div>
						-->
								<!-- 버튼 -->
		

								<!-- 지금은 삭제? 아니면 안보이게? -->

						
						</td>
					</tr>
				</table>
			</div>

	</div>

	<!-- footer -->
	<%@include file="/WEB-INF/views/inc/footer.jsp"%>


	<script>
		
	</script>



</body>
</html>