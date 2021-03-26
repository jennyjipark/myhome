<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyHome::가격변화차트</title>

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
		/* border: 1px solid green; */
		width: 1190px;
		margin: 0px auto;
		margin-top: 100px;
		position: relative;
		height: 1200px;
		border-right: 1px solid #DBDCE0;
    	border-left: 1px solid #DBDCE0;
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
	
	.chartbox{
		border : 3px solid #F1AEAE;
		border-radius: 50px;
		margin-bottom : 10px;
		padding : 30px;
	}
	
	.check{
		margin : 30px !important;
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
	
	.search{
		text-align:center;
	   	padding: 10px;
	}
	
	#txt{
		margin-right: 10px;
		size: 100px;
	}
	
	
	.btns {
		text-align : right;
	}
	
	.search #txt {
		width: 200px;
		display: inline;
	}
	
	#propertytype, #roomtype{
		width : 20%;
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
             
		<div id="title">가격변화 차트 관리</div>
		
<!-- 		<select class="option1 form-control" id="propertytype">
			<option>월세</option>
			<option>전세</option>
			<option>매매</option>
		</select>
		<select class="option2 form-control" id="roomtype">
			<option>원룸</option>
			<option>투룸</option>
			<option>오피스텔</option>
		</select>
		
		<div class="btn">
			<input type="button" class="form-control btn" value="검색">
		</div>
		
		<div class="chartbox">
			<input type="checkbox" class="check" style="zoom:1.5;">
			<div id="chart1"></div>
		</div> -->
		
		<div class="chartbox">
			<div id="chart1"></div>
		</div>
      
            
			

	</div>
	</div>
	</div>
	
	<!-- footer -->
<%@include file="/WEB-INF/views/inc/footer.jsp" %>

<script src="/Myhome_project//js/highcharts.js"></script>			
<script>
	
	Highcharts.chart('chart1', {
		
	    title: {
	        text: '월세 평균 가격'
	    },
	
	    subtitle: {
	        text: '(원룸, 투룸, 오피스텔)'
	    },
	
	    yAxis: {
	        title: {
	            text:'가격 (원)' 
	        }
	    },
	
	    xAxis: {
  			  accessibility: {
  		            rangeDescription: 'Range: 01월 to 12월'
  		        }, 
	    	title: {
	    		text:'월'
	    	}
	    },
	
	    legend: {
	        layout: 'vertical',
	        align: 'right',
	        verticalAlign: 'middle'
	    },
	
	    plotOptions: {
	        series: {
	            label: {
	                connectorAllowed: false
	            },
	            pointStart: 01
	        }
	    },
	
	    series: [
	    	{
	            name: '원룸',
	            data: [
		            	<c:forEach items="${list1}" var="dto" varStatus="status">
		        		${dto.avg}
		        		<c:if test="${status.index < list1.size() -1}">
	        			, 
	        			</c:if>
		        		</c:forEach>
		            	]
	        }
	    	 ,
	    	{
	        name: '투룸',
	        data: [
	            	<c:forEach items="${list2}" var="dto" varStatus="status">
	        		${dto.avg}
	        		<c:if test="${status.index < list2.size() -1}">
	    			, 
	    			</c:if>
	        		</c:forEach>
	            	]
	    	}
	    	, 
	    	{
	        name: '오피스텔',
	        data: [
	            	<c:forEach items="${list3}" var="dto" varStatus="status">
	        		${dto.avg}
	        		<c:if test="${status.index < list3.size() -1}">
	    			, 
	    			</c:if>
	        		</c:forEach>	        	
	        		]	
	    	}],
	
	    responsive: {
	        rules: [{
	            condition: {
	                maxWidth: 500
	            },
	            chartOptions: {
	                legend: {
	                    layout: 'horizontal',
	                    align: 'center',
	                    verticalAlign: 'bottom'
	                }
	            }
	        }]
	    }
	
	});
	
	
	
</script>
 
</body>
</html>