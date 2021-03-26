<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::매칭매물관리</title>

<%-- <%@include file="/WEB-INF/views/inc/asset.jsp" %> --%>

<!-- <link rel="stylesheet" href="/Myhome_project/css/main.css"> -->
<link rel="stylesheet" href="/Myhome_project/css/template.css">
<%@include file="/WEB-INF/views/inc/asset.jsp"%>

<style>
body, html {
	height: 100%;
	margin: 0 auto;
	padding: 0;
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

.container {
	font-family: 'NanumBarunGothic';
	font-size: 16px;
	border: 0px;
	border-right: 1px solid #DBDCE0;
    border-left: 1px solid #DBDCE0;
}


#btnget {
	background-color: #c3d9ff; 
}

#btnsend {
	background-color: white;
}
.tbl {
	text-align: center;
	width: 800px;
	margin-left: 256px;
	position: relative;
}

.tbl th {
	text-align: center;
	border-top: 1px solid #d4d4d4;
}

.tbl tr{
	border-bottom: 1px solid #d4d4d4;
	height: 50px;
}

.tbl tr:nth-child(odd) {
	background-color: #F9F9F9;
}

.tbl tr:hover {
	cursor: pointer;
	background-color: #ffe1e1;
	font-weight: bold;
}

#tbl2{
	visibility : hidden;
}



#title {

	font-family: 'MaplestoryOTFLight';
	border-bottom: 1px dashed #ccc;
	font-size: 24px;
	margin-bottom: 30px;
	width: 500px;
	float: left;
	text-align: left;
	margin-left: 100px;
	margin-top: 20px;
}

#contractor {
	position: relative;
	visibility : hidden;
}

#tbl3 {
	
	text-align: center;
	width: 800px;
	margin:auto;
	margin-bottom: 20px;
}

#tbl3 th{
	text-align: center;
	border-top: 1px solid #d4d4d4;
}

#tbl3 tr {
	border-bottom: 1px solid #d4d4d4;
	height: 30px;
}
#tbl3 tr:hover {
	cursor: pointer;
	background-color: #ffe1e1;
	text-decoration:underline;
}
#tbl3 tr:nth-child(odd) {
	background-color: #F9F9F9;
}


#whiteboard {
	width: 820px;
	margin-left: 250px;
}
#section1 {
	text-align: center;
}

#maintitle {
	border-bottom: 1px solid #ccc;
	font-size: 24px;
	font-family: 'MaplestoryOTFLight';
	padding-right: 50px;
	position: relative;
	display: inline;
	left: -286px;
	top: 100px;
	text-align:left;
}

</style>
</head>
<body>
	<div class="wrap">
		<div class="header-containerwrap">
			<!-- header -->
		<%@include file="/WEB-INF/views/inc/bootstrap-header.jsp"%>

			<div class="container">
				
					<!-- nav -->
					<%@include file="/WEB-INF/views/user/nav.jsp"%>
				
				<div id="section1">
					<div id="maintitle">매칭 매물 관리</div>
					
					<div style="margin-top: 50px; color: #aaa; text-align: right;">
						<span class="glyphicon glyphicon-triangle-bottom"></span> 매칭 종류를 선택하세요.
					</div>
					<div style="text-align: right; margin: 20px;">
						<button type="button" class="btn btn-default" id="btnget">나에게 들어온 매칭</button>
						<button type="button" class="btn btn-default" id="btnsend">내가 보낸 매칭</button>
					</div>
					<div id="box">
											
						<div class="matchingbox" id="send">
							<table class="tbl" id="tbl1">
								<tr>
									<th>매물번호</th>
									<th>제목</th>
									<th>중개인</th>
									<th>매칭신청</th>
								</tr>
								
								<c:if test="${glist.size()==0}">
								<tr>
									<td colspan="4">받은 매칭 목록이 존재하지 않습니다.</td>
								</tr>
								</c:if>
								
								<c:forEach items="${glist}" var="gdto">
								<tr>
									<td>${gdto.seqMatching }</td>
									<td onclick="location.href='/Myhome_project/contractor/property-lessor-detail.do?seq=${gdto.seqLessorProperty}'">${gdto.title}</td>
									<td>${gdto.name}(${gdto.contractorName})</td>
									<td>
										<c:if test="${empty gdto.response}">
										<div id="matchaccept">
											<button type="button" class="btn btn-default" id="btnok" onclick="location.href='/Myhome_project/user/matchingok.do?response=ok&seqMatching=${gdto.seqMatching}&seqLessorProperty=${gdto.seqLessorProperty}&seqContractor=${gdto.seqContractor}';">매칭 수락</button>
											<button type="button" class="btn btn-default" id="btnno" onclick="location.href='/Myhome_project/user/matchingok.do?response=no&seqMatching=${gdto.seqMatching}';">매칭 거절</button> 
										</div>
										</c:if>
										${gdto.response}
									</td>
								</tr>
								</c:forEach>
								
							</table>
						</div>

						<div class="matchingbox" id="get">
							<table class="tbl" id="tbl2" style="top: <c:if test="${empty glist}">-101</c:if><c:if test="${glist.size()>=1}">${-51+glist.size()*-50}</c:if>px">
								<tr>
									<th>매물번호</th>
									<th>제목</th>
									<th>중개인</th>
									<th>매칭신청</th>
								</tr>
								
								<c:if test="${slist.size()==0}">
								<tr>
									<td colspan="4">보낸 매칭 목록이 존재하지 않습니다.</td>
								</tr>
								</c:if>
								
								<c:forEach items="${slist}" var="sdto" varStatus="status">
								<tr>
									<td>${sdto.seqMatching }</td>
									<td onclick="location.href='/Myhome_project/contractor/property-lessor-detail.do?seq=${sdto.seqLessorProperty}'">${sdto.title}</td>
									<td>${sdto.name}(${sdto.contractorName})</td>
									<td>
										<c:choose>
										<c:when test="${sdto.response eq '거절' }">
											매칭거절됨<button type="button" class="btn btn-default btncontr">중개사선택</button>
										</c:when>
										<c:when test="${sdto.response eq '수락' }">
											매칭완료
										</c:when>
										<c:otherwise>
											매칭대기중 <button type="button" class="btn btn-default btncontr" id="btn${status.count}" onclick="contractorlist('${sdto.location}', ${sdto.seqMatching});">중개사바꾸기</button>
										</c:otherwise>
										</c:choose>
																			
									</td>
								</tr>
								
								</c:forEach>
								
							</table>
						</div>
						<div class="contractorbox" id="contractor">
							<div id="whiteboard" style=" border: 1px solid black; border-radius:5px; box-shadow: 5px 5px 5px gray inset;">
								<div id="title">중개사 목록  <span style=" font-size: 16px; color: #b7b7b7;">매칭을 보낼 중개사를 선택하세요.</span></div>
								<table class="ctbl" id="tbl3">
									<thead>
										<tr>
											<th>중개사이름</th>
											<th>사업자번호</th>
											<th>전화번호</th>
											<th>주소</th>
										</tr>
									</thead>
									
									<tbody id="tb">
										
									</tbody>
								</table>
							</div>
						</div>
						
						

					</div>
				</div>





			</div>
			
		</div>


		<!-- footer -->
		<%@include file="/WEB-INF/views/inc/footer.jsp"%>
	</div>
	
	
	<script>
		
		var btnget = document.getElementById("btnget");
		var btnsend = document.getElementById("btnsend");
		var btncontr = document.getElementsByClassName("btncontr");
		var selcontractor = document.getElementsByClassName("selcontractor")
		var btnok = document.getElementById("btnok");
		var btnno = document.getElementById("btnno");
		
	
		btnget.onclick = function() {
			document.getElementById("tbl1").style.visibility = 'visible';
			document.getElementById("tbl2").style.visibility = 'hidden';
			btnget.style.backgroundColor = '#c3d9ff';
			btnsend.style.backgroundColor = 'white';
		};

		btnsend.onclick = function() {
			document.getElementById("tbl1").style.visibility = 'hidden';
			document.getElementById("tbl2").style.visibility = 'visible';
			btnget.style.backgroundColor = 'white';
			btnsend.style.backgroundColor = '#c3d9ff';
		};
		
		
		function contractorlist(location, seqMatching){
			
			let num = seqMatching;
			
			$("#contractor").css("visibility","visible");
			
			$.ajax({
				type: "GET",
				url: "/Myhome_project/user/vwcontractordata.do",
				data:"location="+location,
				success: function(llist){
					
					var body = '';
					
					console.log(llist);
					llist = JSON.parse(llist);

					
					if (llist==null || llist==""){
						body += '<td colspan="4">';
						body += '지역에 존재하는 다른 중개사가 없습니다.';
						body += '</td>';
						body += '</tr>';
					}
					
					
					for (var i=0; i<llist.length; i++) {
						

						body += '<tr class="selcontractor" onclick="location.href='
						body += '\'/Myhome_project/user/selectcontractor.do?seqContractor=';
						body += llist[i].seqContractor;
						body += '&seqMatching=';
						body += num;
						body += '\'">';
						body += '<td>'+llist[i].contractorName+'</td>';
						body += '<td>'+llist[i].companyNumber+'</td>';
						body += '<td>'+llist[i].phoneNumber +'</td>';
						body += '<td>'+llist[i].address+'</td>';
						body += '</tr>';
						
						
					}
					
				
					$("#tb").html(body);
					
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			})
			
		};
		
	
	</script>
	
	
	
</body>
</html>