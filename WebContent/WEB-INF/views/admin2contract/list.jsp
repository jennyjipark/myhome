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

/* 검색, 페이지바 */
.search-paging {
	width: 800px;
	height: 200px;
	padding: 20px 0px;
}

.paging {
	width: 100%;
	height: 75px;
	padding: 0px 170px;
}

.pagination>li>.page-a {
	color: #202020;
}

.pagination>.active>a, .pagination>li>a:hover {
	background-color: #f1aeae;
	color: white !important;
}

.btn {
	background-color: #f1aeae;
	color: white;
	outline: none;
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

	
	/*버트 새로 고침 */
	
	.boardbutton{
		width:940px;
		padding-right:120px;
	}
	.boardbutton button{
	
		float:right;
		display:inline-block;	
        outline: none;
        border: 0px solid #000;
        background-color: #f1aeae;
        color: white;
        width: 110px;
        height: 34px;
        margin-right:5px;
        margin-bottom:10px;
        border-radius: 3px;
	}

    .boardbutton button:after{
        content: "";
        display: block;
        clear: both;
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
							<div id="boardtitle" class="">전자계약게시판</div>

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
									<c:forEach items="${list}" var="dto">	
									<tr class="boardtr">
										<td class="fiftd boardtd">
										<a href="/Myhome_project/admin2/contract/view.do?seqC=${dto.seqC}"> 
											${dto.seqC}
										</a>
										</td>
										<td class="thitd boardtd">${dto.nameT}</td>
										<td class="thitd boardtd">${dto.nameL}</td>
										<td class="fortd boardtd">
											<div class="Boardtdtitle">${dto.nameC}</div>
										</td>
										<td class="fiftd boardtd">
											<div class="Boardtdtitle">
											${dto.location}
											</div>
										</td>
										<td class="fortd boardtd">${dto.contractDate}</td>
										<td class="fiftd boardtd">${dto.state}</td>
										<td class="sixtd boardtd"><input type="checkbox"
											name="seq" id="seq" value="${dto.seqC}">
											<input type="hidden" id="state" value="${dto.state}">
										</td>
									</tr>
									</c:forEach>
								</table>
							</div>
						
						<div class="boardbutton">
							<button id="passwordupdate" type="button">
							암호재등록</button>
							<button id="statechange" type="button">
							상태변경</button>
						<!--  <button> 1234</button>-->	
						</div>
						
							
							<!-- 검색, 페이지바 -->
							<div class="search-paging">
								<div class="paging">
									<ul class="pagination">
									${pagebar}
									</ul>
								</div>


								<input type="hidden" value="" name="">
								<form id="searchForm" method="GET" action="/Myhome_project/admin2/contract/list.do">
                
								<div id="search-box">
									<input type="text" class="form-control" id="search-text"
										placeholder="닉네임, 매물번호를 입력해주세요.">
									<button class="btn btn-outline-secondary" type="button"
										id="button-addon1">검색</button>
								</div>
								</form>
								<!-- search-paging -->
							</div>
						
						</td>
					</tr>
				</table>
			

		</div>

	</div>

	<!-- footer -->
	<%@include file="/WEB-INF/views/inc/footer.jsp"%>


	<script>

	// 한개만 체크 되도록하는것 
	$("input[type='checkbox'][name='seq']").click(function(){
        if($(this).prop('checked')){
            
            $('input[type="checkbox"][name="seq"]').prop('checked',false);
            $(this).prop('checked',true);
        }
    });
	
	
	$("#passwordupdate").click(function(){

		if( $("input[type='checkbox'][name='seq']:checked").val() != null ){
		    var con_test = confirm("암호를 재입력 하시겠습니까? 기존암호 입력사항은 초기화됩니다.");
		    var seq =$("input[type='checkbox'][name='seq']:checked").val();
		    if(con_test == true){
		    	location.href='http://localhost:8090/Myhome_project/admin2/contract/change.do?seqC='+seq;
		    }
		}else{
			alert("변경할 계약을 선택해주세요.");
		}
	});
	
	
	$("#statechange").click(function(){
		/*페이지 이동 어떻게 하지?*/
		if( $("input[type='checkbox'][name='seq']:checked").val() != null ){
		    var con_test = confirm("계약 상태를 취소로 변경하시겠습니까??");
		    var seq =$("input[type='checkbox'][name='seq']:checked").val();
		    if(con_test == true){
		    	
		    	if ($("input[type='checkbox'][name='seq']:checked+input[type='hidden']").val()=='완료'||$("input[type='checkbox'][name='seq']:checked+input[type='hidden']").val()=='취소'){
		    		alert("진행중인 부분만 취소로 변경이 가능합니다.");
		    	}else{

			    	location.href='http://localhost:8090/Myhome_project/admin2/contract/stateok.do?seqC='+seq;
			    	
		    	}
		    	
		    }
		}else{
			alert("변경할 계약을 선택해주세요.");
		}

	});

	
	
	</script>



</body>
</html>