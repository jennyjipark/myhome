<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::커뮤니티</title>
<%@include file="/WEB-INF/views/inc/asset.jsp"%>
<link rel="stylesheet" href="/Myhome_project/css/template.css">
<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="/Myhome_project/css/boarduserver.css"> -->


<!-- board-community-view.jsp -->

<style>
.boardwrap {
	height: auto;
	min-height: 100%;
}

.container {
	border-color: transparent;
	font-family: 'NanumBarunGothic', sans-serif;
	font-size: 16px;
	position: relative;
		border-right: 1px solid #DBDCE0;
    border-left: 1px solid #DBDCE0;
}

.boardcover {
	float: left;
	width: 100%;
}

#maintitle {
	/* border-bottom: 1px solid #ccc; */
	font-size: 24px;
	font-family: 'MaplestoryOTFLight';
	padding: 0 10px;
	border-left: 5px solid #f1aeae;
	position: relative;
	display: inline;
	text-align: left;
	color: #202020;
	top: 100px;
	left: 100px;
}

.table {
	position: relative;
	top: 160px;
	left: 100px;
	width: 100%;
	border-top: solid 1px #ccc;
	border-bottom: solid 1px #ccc;
}

.table thead tr th {
	text-align: center;
}

.firtd {
	text-align: center;
	width: 90px;
}

.sectd {
	text-align: center;
	width: auto;
}

.thitd {
	text-align: center;
	width: 130px;
}

.fortd {
	text-align: center;
	width: 130px;
}

.fiftd {
	text-align: center;
	width: 90px;
}

#content {
	padding: 15px 15px;
	height: 300px;
	overflow: auto;
}

#content textarea {
	width: 100%;
	height: 300px;
}


#btn4 {
	float: left;
	position: relative;
	background-color: #f1aeae;
	color: white;
	outline: none;
	border: none;
	font-family: 'NanumBarunGothic', sans-serif;
	color: white;
	vertical-align: middle;
	width: 70px;
	height: 34px;
	margin-right: 5px;
	border-radius: 3px;
	left: 80px;
	top: 150px;
}

.boardbutton .btn {
	float: left;
	position: relative;
	background-color: #f1aeae;
	color: white;
	outline: none;
	border: none;
	font-family: 'NanumBarunGothic', sans-serif;
	color: white;
	/* padding: 8px 15px; */
	vertical-align: middle;
	width: 70px;
	height: 34px;
	margin-right: 5px;
	border-radius: 3px;
	display: inline-block;
}

#btn1 {
	top: 160px;
	left: 85px;
	float: left;
}

#btn2 {
	top: 160px;
	left: -140px;
	float: left;
}

#btn3 {
	top: 160px;
	left: -140px;
	float: left;
}

/*  .boardbutton {
		
		position: relative;
		float: left;
		top: 170px;
    	left: 720px;
		 
	}
	 */
.modal-backdrop {
	z-index: auto !important;
	background-color: #ccc !important;
}

.modal-dialog {
	position: relative;
	top: 200px;
}

/*  #btn4 {
	    left: auto;
	    top: auto;
	 }  */
#basic-addon2 {
	background-color: #f1aeae;
	color: white;
	outline: none;
	float: right;
	position: relative;
	top: -34px;
	
	    z-index: 2;
}

#ccontent {
	width: 100%;
	position: relative;
	float: left;
	/* top: -340px;
		left: 500px; */
		    z-index: 1;
}

.comment {
	width: 100%;
	margin: 100px auto;
	position: relative;
	margin-bottom: 200px;
	float: left;
}

#buttons {
	position: relative;
	left: 770px;
	float: left;
}

.panel-default {
	border-color: transparent !important;
}

#commentForm {
	position: relative;
	top: 180px;
	left: 100px;
	width: 100%;
	margin-top: 20px;
}

#name {
	font-weight: bold;
}

#delete {
	padding: 4px 6px;
	text-align: center;
	background-color: #f1aeae;
	border: 0;
	color: white;
	border-radius: 4px;
	cursor: pointer;
	margin-left: 7px;
}

.commenttable td:nth-child(1) {
	width: 100px;
}

.well {
	width: 100%;
	float: left;
	position: relative;
	top: 50px;
	left: 100px;
}

.commenttable {
	top: 80px;
}
</style>


</head>
<body>

	<div class="boardwrap">

		<!-- header -->
		<%@include file="/WEB-INF/views/inc/bootstrap-header.jsp"%>

		<div class="container">

			<%@include file="/WEB-INF/views/user/nav-board.jsp"%>

			<div class="col-sm-12 col-md-9">
				<!-- <div> -->
				<div class="boardcover">
					<div id="maintitle">커뮤니티</div>
					<table class="table table-striped table-condensed" id="tbl">
						<thead>
							<tr class="headtr">
								<th class="firtd boardtd">번호</th>
								<th class="sectd boardtd">제목</th>
								<th class="thitd boardtd">작성자(닉네임)</th>
								<th class="fortd boardtd">작성일</th>
								<th class="fiftd boardtd">조회수</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<!--                         <td> -->
								<%--                             <td class="firtd">${dto.seqCommunity}. ${id}</td> --%>
								<td class="firtd">${dto.seqCommunity}</td>
								<td class="sectd">${dto.title}</td>
								<td class="thitd">${dto.nickName}</td>
								<td class="fortd">${dto.writeDate.substring(0,10)}</td>
								<td class="fiftd">${dto.viewCount}</td>
								<!--                         </td> -->
							</tr>

							<tr>
								<td id="content" colspan="5">
									<textarea disabled="disabled">${dto.content}</textarea>
								</td>
							</tr>
						</tbody>
					</table>
				</div>


				<!-- </div> -->
				<!-- col-sm-12 col-md-9 -->

				<div class="boardbutton" id="buttons">
					<c:if test="${empty name}">
						<button id="btn4"
							onclick="location.href='/Myhome_project/Myhome/user/boardcommunitylist.do';">
							목록</button>
					</c:if>

					<%-- <div>글쓴사람 아이디: ${dto.id}</div>
	                    <div>현재 로그인 사람 아이디: ${id}</div> --%>

					<%-- 	                    <c:if test="${dto.nickName.equals(nickName)}"> --%>
					<c:if test="${not empty name}">
						<button id="btn1" class="btn"
							onclick="location.href='/Myhome_project/Myhome/user/boardcommunitylist.do';">
							목록</button>
						<c:if test="${dto.seqAllUser == seqAllUser}">
							<button type="button" class="btn btn-default" id="btn2"
								onclick="location.href='/Myhome_project/Myhome/user/boardcommunityedit.do?seq=${dto.seqCommunity}';">수정</button>


							<!-- <button type="button" class="btn btn-default" data-toggle="modal" data-target="#deleteModal" id="btn3">삭제</button> -->
							<button type="button" class="btn btn-default" id="btn3"
								onclick="location.href='/Myhome_project/Myhome/user/boardcommunitydelete.do?seq=${dto.seqCommunity}';">삭제</button>

						</c:if>


						<!-- 글 쓴사람 아이디랑 로그인한 사람 아이디 같은지 -->
					</c:if>
				</div>
				<!-- 본문 버튼그룹  -->
				<div style="clear: both;"></div>

				<form method="POST" id="commentForm"
					action="/Myhome_project/Myhome/user/commentcommunityok.do">
					<div class="commentbox panel panel-default">
						<!-- <div class="panel-body"> -->

						<input type="text" class="form-control" placeholder="댓글을 입력해주세요."
							id="ccontent" name="ccontent" required><span class="btn"
							id="basic-addon2" onclick="$('#commentForm').submit();"
							style="cursor: pointer;"><span>등록</span></span>
						<!-- </div> -->
					</div>

					<!-- 오류나면 수정하기***** -->
					<input type="hidden" name="seqCommunity"
						value="${dto.seqCommunity}">
				</form>



				<div class="comment">
					<table class="table commenttable">
						<c:if test="${clist.size()==0}">
							<div class="message well well-sm">댓글이 없습니다.</div>
						</c:if>
						<c:forEach items="${clist}" var="cdto">
							<tr>
								<%-- <td><span class="comment">${cdto.ccontent}</span> <span
								class="date">${cdto.writeDate}</span> <span class="name">${cdto.nickName}</span> --%>
								<td><span id="name">${cdto.nickName}</span></td>
								<td><span id="comment">${cdto.ccontent}</span></td>
								<td style="text-align: right"><span id="date">${cdto.writeDate}</span>

									<!-- cdto는 댓글번호 dto.seq는 부모글번호 --> <!-- 오류나면 여기 seq 수정하기***** -->
									<%-- <c:if test="${cdto.seqUser == seq}"> 
	                            <c:if test="${cdto.seqUser == seqUser}"> --%>
									<c:if test="${cdto.seqAllUser == seqAllUser}">
										<span id="delete"
											onclick="location.href='/Myhome_project/Myhome/user/commentcommunitydeleteok.do?seq=${cdto.seqCommunityComment}&seqCommunity=${dto.seqCommunity}';">삭제</span>
										<%-- <span class="delete" onclick="location.href='/Myhome_project/Myhome/user/commentcommunitydeleteok.do?seq=${cdto.seq}&bseq=${dto.seq}';">[삭제]</span> --%>
									</c:if></td>
							</tr>
						</c:forEach>
					</table>

				</div>
				<!-- comment -->

			</div>
			<!-- col-sm-12 col-md-9 -->

		</div>
		<!-- container -->

	</div>
	<!-- boardwrap -->
	
	<!-- footer -->
	<%@include file="/WEB-INF/views/inc/footer.jsp"%>

	<script>
		
	</script>
</body>
</html>