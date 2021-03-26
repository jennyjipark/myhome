<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::중고거래</title>

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
	     background-color : white;
        
    }

    #navboardtbl{
        height: 800px;  
        width: 100%;  
        margin: 0px;
    }
    
    
    /*기존 200xp 삭제만 300px*/
    #navboardtbl .navboardtd:first-child{
    	width: 300px;

    }
    
	 .navboardtd{
	
	    vertical-align: top;
			
	}
	
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

/* 삭제 글 태그*/
						
	.boardalert{
	width:940px
	}
	
	.alert-danger{
		display:block;	
    	text-align:center;
    	width:800px;
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

					<!-- nav -->
					<%@include file="/WEB-INF/views/admin/nav.jsp"%>
				
						</td>

						<!--삭제입니다.-->

						<td class="navboardtd">
							<div id="boardtitle" class="">중고거래</div>
							
							<div class="boardcover">
								<table id="board"
									class="table table-hover table-striped table-condensed">

									<tr class="headtr">
										<th class="firtd boardtd">번호</th>
										<th class="sectd boardtd">제목</th>
										<th class="thitd boardtd">작성자</th>
										<th class="fortd boardtd">작성일</th>
										<th class="fiftd boardtd">댓글수</th>
									</tr>

			<form action="/Myhome_project/admin2/used/deleteok.do" method="POST">
									
									<c:forEach items="${list}" var="dto">
									<tr class="boardtr">
										<input type="hidden" name ="seq" value="${dto.seqUsed}">
										<td class="firtd boardtd">${dto.seqUsed}</td>
										<td class="sectd boardtd">
											<div class="Boardtdtitle">
												<span class="boardspan headspan">[
												
												<c:if test="${category == '1' }">
												가구
												</c:if> <c:if test="${category == '2' }">
												뷰티
												</c:if> <c:if test="${category == '3' }">
												신발
												</c:if> <c:if test="${category == '4' }">
												의류
												</c:if> <c:if test="${category == '5' }">
												디지털/가전
												</c:if> <c:if test="${category == '6' }">
												생활용융
												</c:if> <c:if test="${category == '7' }">
												스포츠
												</c:if> <c:if test="${category == '8' }">
												식품
												</c:if> <c:if test="${category == '9' }">
												도서
												</c:if> <c:if test="${category == '10' }">
												기타
												</c:if>
												
												]
												</span> 
												${dto.title}<span
													class="boardspan footspan"></span>
											</div>

										</td>
										<td class="thitd boardtd">${dto.id}</td>
										<td class="fortd boardtd">${dto.writeDate}</td>
										<td class="fiftd boardtd">${dto.count}</td>
									</tr>
							</c:forEach>		

								</table>
							</div>
										<input type="hidden" name ="category" value="${category}">
							
 						<!-- 삭제 항목 글 -->
 							<div class="boardalert">				
								<div class="alert alert-danger" role="alert">
								  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
								  <span class="sr-only">경고!</span>
								  위의 항목(들)을 삭제하시겠습니까?삭제하시려면 아래의 삭제버튼을 눌러 주세요.
								</div>
							</div>	
						<!-- 버튼 -->
						
							<div class="boardwork d-grid gap-2 d-md-block btn-group">
								<button class="btn btn-outline-secondary " type="button"
									id="button-addon2" onclick="location.href='/Myhome_project/admin2/used/list.do?category=${category}';">
									목록</button>
								<button class="btn btn-outline-secondary " type="submit"
									id="del" >
									삭제</button>
							</div>
					</form>

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