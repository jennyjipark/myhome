<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::전자계약서 작성</title>
<%@include file="/WEB-INF/views/inc/asset.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">
<link rel="stylesheet" href="/Myhome_project/css/contractor-mypage.css">
<link rel="stylesheet" href="/Myhome_project/css/myproperty.css">



<style>
	.header {
		background-color : white;
	}
	
	.container {
        width: 1190px;
        margin: 0 auto;
        letter-spacing: -.2px;
        min-height:100%;
		padding-bottom:100px;
		border: 1px solid green;
		margin-top: 100px;
		z-index: -1;
    }
    
    .board-name {
    	border-left: 5px solid #f1aeae;
	    width: 810px;
	    /* height: 50px; */
	    padding-left: 10px;
	    font-size: 24px;
	    font-family: 'MaplestoryOTFLight';
	    color: #202020;
	    margin-bottom: 50px;
    	
    	
    }
    
    /* myproperty css */
    .property-box {
    	border: 0px;
    	padding-left: 30px;
    }
    

   	/* 헤더 */
   	
	#mycontract {
		color: #f1acac;
	}   
	
	
	
	/* 전자계약 css */
	

    #adcontracttbl{
        width: 800px;
        margin-left: 20px;
        table-layout: fixed;
    }
    
    #adcontracttbl .headtr th {
        text-align: center;
        background-color: #ffe7e7;
        
    }

    .adcontacttd{
        text-align: center;
    }
    
    .info-color {
    	background-color: #ececec !important;
    }
    
    .example {
    	color:  #a2a2a2;
    }
    
    
    /*.adcontacttd>*/
    input[type="text"]{
        border: 0px solid #000;
        text-align: center;
        margin: 0px;
        padding: 0px;
        outline: none;
        display: inline;
        width: 200px;
    }
    
    .small-text {
    	width: 100px !important;
    }
    
    .month {
    	margin: 0px;
    	width: 150px;
    }
    
    #adcontracttbl td{
       text-align: center;
    }

    #contractcontent{
        width: 700px;
        overflow: hidden;
        height:400px;
        resize: none;
        padding: 0px; 
    }
    
    .contractadd{
        overflow: hidden;
    }
    
    .low {
    	text-align: left;
    	padding: 30px 5px;
    
    }
    
    .low-title {
    	font-weight: bold;
    
    }
    
    
    .low > .underline {
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
   		margin-left: 590px;
   		float: left;
   }
   
   	 .btn-contract1  {
	  	background-color: #f1aeae;
	   	color: white;
	   	outline: none !important;
	   	font-family: 'NanumBarunGothic';
	   	border: 1px solid #f1aeae;
   }
   
   #check, #discard {
   		color: white !important;
   }
   
   
   
   
 

</style>


</head>
<body>
 
<div class="boardwrap">
 
 <!-- header -->
<%@include file="/WEB-INF/views/contractor/header.jsp" %>
 
     <div class="container">
     <%@include file="/WEB-INF/views/contractor/nav.jsp" %>
        <div class="boardcover">
            
		 
		 <!-- 리스트 -->
		 <div class="property-box">	
		 	<div class="board-name">전자계약서 작성</div>		 	
         	 
       
   
   		<!-- 전자계약서 -->
        <div class="matching-board">
        
        	<div class="boardcover">
			
			</div>
				
			
			<!-- form 태그 -->	
			<form method="POST" action="/myhome_project/mypage-contract-writeok.do" id="form1">   
			
			<!-- 계약서 세부정보 -->
	        
			<table id="adcontracttbl" class="table table-condensed">	
				
				<c:forEach items="${plist }" var="dto1">
				<tr class="headtr">
					<th class="adcontacttd title-color">계약번호</th>
					<td class="adcontacttd" colspan="2">${maxSeq }</td>
					<th class="adcontacttd">계약일자</th>
					<td class="adcontacttd" colspan="3"></td>
					<th class="adcontacttd">계약상태</th>
					
					<!-- view에서 셋 다 암호입력하면 계약완료 -->
					<td class="adcontacttd" colspan="2">진행중</td>
				</tr>

				<tr class="headtr">
					<th class="adcontacttd info-color" colspan="10">부동산의 표시</th>
				</tr>
				
				<tr class="headtr">
					<th class="adcontacttd title-color">매물주소</th>
					<td class="adcontacttd" colspan="9" ><input type="text" class="example" value="${dto1.location }"></td>
				</tr>
				
				<tr class="headtr">
					<th class="adcontacttd title-color">금액</th>
					<c:if test="${not empty dto1.dealing }">
					<td class="adcontacttd" colspan="3" ><input type="text" class="example" value="${dto1.dealing }"></td>
					</c:if>
					
					<c:if test="${empty dto1.dealing }">
					<td class="adcontacttd" colspan="3" ><input type="text" class="example" value="숫자만 입력"></td>
					</c:if>
					
					<th class="adcontacttd title-color">계약금</th>
					<c:if test="${not empty dto1.deposit }">
					<td class="adcontacttd" colspan="2" ><input type="text" class="example small-text" value="${dto1.deposit }"></td>
					</c:if>
					
					<c:if test="${empty dto1.deposit }">
					<td class="adcontacttd" colspan="2" ><input type="text" class="example small-text" value="숫자만 입력"></td>
					</c:if>
					
					<th class="adcontacttd title-color">계약종류</th>
					<td class="adcontacttd"  colspan="2">
					
					<c:if test="${not empty dto1.monthlyRent }">
					<input type="text" class="example small-text" value="월세">
					</c:if>
					</td>
					
					<!-- 월세가 null 매매가 null 이면 전세 -->
					<c:if test="${empty dto1.monthlyRent and dto1.dealing }">
					<input type="text" class="example small-text" value="전세">
					</c:if>
					
					<!-- 월세가 null이 아니고 보증금이 null이면 매매 -->
					<c:if test="${not empty dto1.monthlyRent and empty dto1.deposit}">
					<input type="text" class="example small-text" value="매매">
					</c:if>
					
				</tr>
				
				
				<tr>
					<td class="adcontacttd" colspan="10">
										
						<!-- 법률 -->
						<div class="low">
											
						<!--  -->					
						<span class="low-title">제 2조 (존속기간)</span> 임대인은 위 부동산을 임대차 목적대로 사용 수익할 수 있는 상태로
						<input type="text" class="form-control" placeholder="년-월-일로 입력해주세요." onfocus="this.value=''">까지 임차인에게 인도하며, 임대차 기간은 인도일로부터 
						<input type="text" class="form-control" placeholder="년-월-일로 입력해주세요." onfocus="this.value=''">까지로 한다.
						<input type="text" class="form-control month" placeholder="숫자만 입력해주세요." onfocus="this.value=''">(개월)
						<br><br>
						<span class="low-title">제 3조 (용도변경 및 전대 등)</span> 임차인은 임대인의 동의없이 위 부동산의 용도나 구조를 변경하거나 전대 임차원 양도
						또는 담보 제공을 하지 못하게 하며 임대차 목적 이외의 용도로 사용할 수 없다.
						<br><br>
						<span class="low-title">제 4조 (계약의 해지)</span> 임차인이 제3조를 위반하였을 때 임대인은 즉시 본 계약을 해지할 수 있다.
						<br><br>
						<span class="low-title">제 5조 (계약의 종료)</span> 임대차계약이 종료된 경우에 임차인은 위 부동산을 원상으로 회복하여 임대인에게 반환한다. 
						<br><br>
						<span class="low-title">제 6조 (계약의 해제)</span> 임차인이 임대인에게 중도금(중도금이 없을 때는 잠금)을 지불하기 전까지,
						임대인은 계약금의 배액을 상환하고, 임차인은 계약금을 포기하고 본 계약을 해제할 수 있다.								
						<br><br>
						<span class="low-title">제 7조 (채무불이행과 손해배상)</span> 
						임대인 또는 임차인이 본 계약상의 내용에 대하여 불이행이 있을 경우 그 상대방은 불이행한 자에 대하여
						서면으로 최고하고 계약을 해제할 수 있다. 그리고 계약 당사자는 계약해제에 따른 손해배상을 각각 상대방에 대하여 청구할 수 있으며,
						손해배상에 대하여 별도의 약정이 없는 한 계약금을 손해배상의 기준으로 본다.
						<br><br>
						<span class="low-title">제 8조 (중개보수)</span> 
						개업공인중개사는 임대인과 임차인이 본 계약을 불이행함으로 인한 책임을 지지 않는다. 또한, 중개보수는 본 계약체결과 동시에
						계약 당사자 쌍방이 각각 지불하며, 개업공인중개사 고의나 과실없이 본 계약이 무효·취소 또는 해제되어도 중개보수는 지급한다.
						공동중개인 경우에 임대인과 임차인은 자신이 중개 의뢰한 개업공인중개사에게 각각 중개보수를 지급한다.
						(중개보수는 거래가액의<input type="text" class="form-control month" placeholder="숫자만 입력해주세요." onfocus="this.value=''">%로 한다.)
						<br><br>
						<span class="low-title">제 9조 (중개대상물확인·설명서 교부 등)</span> 
						개업공인중개사는 중개대상물 확인·설명서를 작성하고 업무보증관계증서(공제증서 등) 사본을 첨부하여 계약체결과 동시에
						거래당사자 쌍방에게 교부한다.
						</div>
										
					</td>
				</tr>
				</c:forEach>

				
				<!-- 임차인 정보 -->
				<tr>
					<th class="adcontacttd info-color" colspan="10">임차인 정보</th>
				</tr>

				<c:forEach items="${tlist }" var="dto2">
				<tr class="headtr">
					<th class="adcontacttd">계약자명</th>
					<td class="adcontacttd" colspan="3">
						<input type="text" class="example" style="width: 200px;" name="nameT" value="${dto2.nameT }">
					</td>
					<th class="adcontacttd" colspan="1">전화번호</th>
					<td class="adcontacttd" colspan="2">
						<input type="text" class="example" style="width: 140px;" value="${dto2.telT }" name="telT">
					</td>
					<th class="adcontacttd">주민번호</th>
					<td class="adcontacttd" colspan="2">
						<input type="text" class="example" style="width: 140px;" value="${dto2.ssnT }" name="idNumberT">
					</td>					
				</tr>
			
							
				
				
				
					<tr class="headtr">
						<th class="adcontacttd" colspan="1">주소</th>
						<td class="adcontacttd" colspan="6">
							<input type="text" class="example" value="${dto2.addressT }" name="addressT">
						</td>
						<th class="adcontacttd" colspan="2">암호입력상태</th>														
						<td class="adcontacttd" colspan="1"><input type="text" style="width: 80px; background-color: transparent;" value="입력요청" name="passwordStateT" disabled></td>
					</tr>		
				
				
				
				<!-- 암호입력 -->
				<tr class="headtr">
					<th class="adcontacttd" colspan="1"><div class="vertical-align">암호입력</div></th>
					<td class="adcontacttd" colspan="9"><input type="text" class="form-control" placeholder="암호를 입력해주세요." name="passwordT"></td>
					
				</tr>		
				</c:forEach>
					
									


			<!-- 임대인 정보 -->
				<tr>
					<th class="adcontacttd info-color" colspan="10">임대인 정보 </th>
				</tr>

				<c:forEach items="${llist }" var="dto3">
				<tr class="headtr">
					<th class="adcontacttd">계약자명</th>
					<td class="adcontacttd" colspan="3"><input type="text" class="example" value="${dto3.nameL }" name="nameL"></td>
					<th class="adcontacttd" colspan="1">전화번호</th>
					<td class="adcontacttd" colspan="2"><input type="text" class="example small-text" value="${dto3.telL }" onfocus="this.value=''" name="telL"></td>
					<th class="adcontacttd">주민번호</th>
					<td class="adcontacttd" colspan="2"><input type="text" class="example" value="${dto3.ssnL }" onfocus="this.value=''" name="idNumberL"></td>					
				</tr>

							
					
				<tr class="headtr">
					<th class="adcontacttd" colspan="1">주소</th>
					<td class="adcontacttd" colspan="6"><input type="text" class="example" value="${dto3.addressL }" name="addressL"></td>
					<th class="adcontacttd" colspan="2">암호입력상태</th>		
					<td class="adcontacttd" colspan="1">
						<input type="text" style="width: 80px;background-color: transparent;"  value="입력요청" name="passwordStateT" disabled>
					</td>
				</tr>		
				
				
				<!-- 암호입력 -->
				<tr class="headtr">
					<th class="adcontacttd" colspan="1"><div class="vertical-align">암호입력</div></th>
					<td class="adcontacttd" colspan="9"><input type="text" class="form-control" class="example" placeholder="암호를 입력해주세요." name="password"></td>
				</tr>		
				</c:forEach>					
									
									
				<!-- 중개인 정보 -->
				<tr>
					<th class="adcontacttd info-color" colspan="10">중개인 정보 </th>
				</tr>

				<c:forEach items="${plist }" var="dto4">
				<tr class="headtr">
					<th class="adcontacttd">계약자명</th>
					<td class="adcontacttd" colspan="3">
						<input type="text" class="example" value="${dto4.name }(${dto4.companyName })" onfocus="this.value=''" name="nameC">
					</td>
					<th class="adcontacttd" colspan="1">전화번호</th>
					<td class="adcontacttd" colspan="2">
						<input type="text" class="example small-text" value="${dto4.tel }" name="telC">
					</td>
					<th class="adcontacttd">사업자번호</th>
					<td class="adcontacttd" colspan="2"><input type="text" class="example" value="${dto4.businessNum }" name="businessNum"></td>					
				</tr>

							
					
				<tr class="headtr">
					<th class="adcontacttd" colspan="1">주소</th>
					<td class="adcontacttd" colspan="6"><input type="text" class="example" value="${dto4.location }" name="addressC"></td>
					<th class="adcontacttd" colspan="2">암호입력상태</th>			
					<td class="adcontacttd" colspan="1">입력요청</td>
				</tr>							

				
				<!-- 암호입력 -->
				<tr class="headtr">				
					<th class="adcontacttd" colspan="1"><div class="vertical-align">암호입력</div></th>
					<td class="adcontacttd" colspan="9"><input type="text" class="form-control" class="example" placeholder="암호를 입력해주세요." name="passwordC"></td>
				</tr>		
				
				</c:forEach>
				
			</table>
			
		
			</form>				
				
			
       		<!-- boardcover  -->
       		</div>
       		
       	</div>
       		
       		
       		<!-- 계약하기 버튼 -->
       		<div class="btn-contract">
       			<input type="submit" class="btn btn-contract1" id="check" value="계약하기">
       			<input type="submit" class="btn btn-contract1" id="discard" value="폐기하기">
       		</div>
       	
       		
       
      

          <!-- property-box -->
         </div>
             
             
             
             
             
    <!-- container -->        
	</div>  
   
    
  
   </div>
           

<!-- 3명의 암호 입력이 완성되면 readonly -->           
<script>
	
	//텍스트박스 클릭 시 글자색 변경
	$(".example").click(function() {
		$(this).css("color", "#202020");
	});
	
	$("#check").click(function() {
		alert("작성이 완료되었습니다.");
	})
	
	$("#discard").click(function() {
		alert("계약서가 폐기되었습니다.");
	})
	
	
	
	

</script>


 
     <!-- footer -->
<%@include file="/WEB-INF/views/inc/footer.jsp" %>
 
</body>
</html>