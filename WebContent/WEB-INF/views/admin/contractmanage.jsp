<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%



%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyHome::거래정보관리</title>

<link rel="stylesheet" href="/Myhome_project/css/template.css">
<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">
<link rel="stylesheet" href="/Myhome_project/css/board.css">

<%@include file="/WEB-INF/views/inc/asset.jsp" %>

<style>

	style>body, html {
		/* width: 100%; */
		height: 100%;
		margin: 0 auto;
		padding: 0;
	}
	
	.container {
		border: 1px solid green;
		width: 1190px;
		margin: 0px auto;
		margin-top: 100px;
		position: relative;
		height: 1200px;
	}
	
	/* ------------------------------------------- */
	
	
	.boardcover{
	/* 	border: 1px solid tomato; */
		float: left;
		width:900px;
		height: auto;
		margin-left: 20px; 
	}
	
	#title {
		font-size: 24px;
		font-family: 'MaplestoryOTFLight';
		border-left: 5px solid #F1AEAE;
		margin: 30px 10px;
		padding : 0px 10px;
	}
	#tbl {
		width:920px;
	}
	
	.list:nth-child(1) { width: 60px; }
	.list:nth-child(2) { width: 100px; }
	.list:nth-child(3) { width: 100px; }
	.list:nth-child(4) { width: 150px; }
	.list:nth-child(5) { width: 200px; }
	.list:nth-child(6) { width: 150px; }
	.list:nth-child(6) { width: 150px; }
	
	#tbl1 th, #tbl1 td {
		font-family: 'NanumBarunGothic';
		text-align: center;
	}
	
	.boardtr{
		cursor:pointer;
	}
	
	.paging {
		text-align : center;
	}
	
	.pagination > li > .page-a {
		color: #202020;
	}
	
	.pagination>.active>a, .pagination>li>a:hover{
		background-color: #f1aeae !important;
		border-color : #f1aeae !important;
		color: white !important;
	}
	
	
	
	input, select {
		font-family: 'NanumBarunGothic';
		outline: none;
	}
	
	.btn {
	    cursor: pointer;
    	margin-bottom: 20px;
    	margin-right : 10px;
    	padding : 6px 12px;
    	background-color: #F1AEAE;
    	border-radius: 4px;
    	outline: none !important;
    	border : none;
    	color: aliceblue;
	    
	}  
	
    .delete {
    	text-align : right;
    }

	.search {
		text-align:center;
	   	padding: 10px;
	}
	
	.search #txt {
		width: 300px;
		display: inline;
	}



</style>
</head>
<body>
    <div class="boardwrap">
 
 <!-- header -->
<%@include file="/WEB-INF/views/admin/header.jsp" %>
 
     <div class="container">
     <%@include file="/WEB-INF/views/admin/nav.jsp" %>
        <div class="boardcover">
             
		<div id="title">거래 정보 관리</div>
		
		<table id="tbl1" class="table table-hover table-striped table-condensed">
    
                <tr class="headtr">
                	<th class="list">선택</th>
                    <th class="list">매물번호</th>
                    <th class="list">거래날짜</th>
                    <th class="list">임대인</th>
                    <th class="list">중개인</th>
                    <th class="list">임차인</th>
                    <th class="list">거래상태</th>
                </tr>
                
                <tr class="boardtr" id="item" >
                	<td class="list"><input type="checkbox" name="seq" id="seq"></td>
                    <td class="list">11111</td>
                    <td class="list">2021-02-19</td>
                    <td class="list">임대인</td>
                    <td class="list">중개인(공인중개사무소)</td>
                    <td class="list">임차인</td>
                    <td class="list">계약완료</td>
                    
                </tr>
                <tr class="boardtr">
                	<td class="list"><input type="checkbox" name="seq" id="seq"></td>
                    <td class="list">0002</td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                </tr>
                <tr class="boardtr">
                	<td class="list"><input type="checkbox" name="seq" id="seq"></td>
                    <td class="list">0003</td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                </tr>
                <tr class="boardtr">
                	<td class="list"><input type="checkbox" name="seq" id="seq"></td>
                    <td class="list">0004</td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                </tr>
                <tr class="boardtr">
                	<td class="list"><input type="checkbox" name="seq" id="seq"></td>
                    <td class="list">0005</td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                </tr>
                <tr class="boardtr">
                	<td class="list"><input type="checkbox" name="seq" id="seq"></td>
                    <td class="list">0006</td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                </tr>
                <tr class="boardtr">
                	<td class="list"><input type="checkbox" name="seq" id="seq"></td>
                    <td class="list">0007</td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                </tr>
                <tr class="boardtr">
                	<td class="list"><input type="checkbox" name="seq" id="seq"></td>
                    <td class="list">0008</td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                </tr>
                <tr class="boardtr">
                	<td class="list"><input type="checkbox" name="seq" id="seq"></td>
                    <td class="list">0009</td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                </tr>
                <tr class="boardtr">
                	<td class="list"><input type="checkbox" name="seq" id="seq"></td>
                    <td class="list">0010</td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                    <td class="list"></td>
                </tr>
            </table>
            
            <div class="delete">
            	<input type="button" class="btn" value="선택한 거래 삭제" id="delete">
            </div>
             
            <div class="search-paging">
	   		<div class="paging">
	       		<ul class="pagination">
					<li class="page-item"><a class="page-link page-a" href="">이전</a></li>
					<li class="page-item"><a class="page-link page-a" href="">1</a></li>
					<li class="page-item"><a class="page-link page-a" href="">2</a></li>
					<li class="page-item"><a class="page-link page-a" href="">3</a></li>
					<li class="page-item"><a class="page-link page-a" href="">4</a></li>
					<li class="page-item"><a class="page-link page-a" href="">5</a></li>
					<li class="page-item"><a class="page-link page-a" href="">6</a></li>
					<li class="page-item"><a class="page-link page-a" href="">7</a></li>
					<li class="page-item"><a class="page-link page-a" href="">8</a></li>
					<li class="page-item"><a class="page-link page-a" href="">9</a></li>
					<li class="page-item"><a class="page-link page-a" href="">10</a></li>
					<li><a class="page-link page-a" href="">다음</a></li>
				</ul>       		
	       	</div>
            
            <div class="search">
	            	<input type="text" class="form-control" placeholder="매물번호/중개인/임대인/임차인" id="txt">
	            	<input type="button" class="btn" value="검색" id="serch">
            </div>
            
            
			

	</div>
	</div>
	</div>
	
	<!-- footer -->
<%@include file="/WEB-INF/views/inc/footer.jsp" %>

	<script>
	
		//var item = window.document.all.item;
		
		//item.onclick = function(){
	    //    window.open("/Myhome_project/Myhome/admin/viewcontract.do", "contract", "width=1000, height= 1200");
	    //}

		$(".boardtr").click(function() {
			 window.open("/Myhome_project/Myhome/admin/viewcontract.do", "contract", "width=1000, height= 1200");
		});
	
	</script>
 
</body>
</html>