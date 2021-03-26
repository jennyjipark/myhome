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


    .boardwork{
        margin-top: 200px;
    }

    #adcontracttbl{
        width: 800px;
        margin-left: 20px;
        table-layout: fixed;
    }
    #adcontracttbl .headtr th{
        text-align: center;
        
    }

    .adcontacttd{
        text-align: center;
    }
    /*.adcontacttd>*/
    input[type="text"]{
        border: 0px solid #000;
        background-color: #d1e7dd;
        text-align: center;
        margin: 0px;
        padding: 0px;
        outline: none;
    }
    
    #adcontracttbl td{
            text-align: center;
    }

    #contractcontent{
        width: 700px;
        overflow: hidden;
    }
    
    .contractadd{
        overflow: hidden;
    }
	
	
	/*버큰 !! */
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


</style>
</head>
<body>
	<div class="wrap">

		<!-- header -->
		<%@include file="/WEB-INF/views/admin/header.jsp"%>

		<div class="container">

			<form action="" id="form1">

				<table id="navboardtbl">

					<tr id="navboardtr">
						<td class="navboardtd">
							<!-- nav --> <%@include file="/WEB-INF/views/admin/nav.jsp"%>

						</td>

						<!---->

						<td class="navboardtd">
							<div id="boardtitle" class="">전자계약서조회</div>


							<div class="boardcover">
								<table id="adcontracttbl" class="table table-condensed">

									<tr class="headtr">
										<th class="adcontacttd">계약번호</th>
										<td class="adcontacttd" colspan="2">123456</td>
										<th class="adcontacttd" colspan="1">주소</th>
										<td class="adcontacttd" colspan="6"
											style="background-color: #fff3cd;">서울특별시 강남구 역산동 테레란로
											1324-1 1234호</td>
									</tr>

									<tr class="headtr">
										<th class="adcontacttd">계약일자</th>
										<td class="adcontacttd" colspan="2">2020-12-31</td>
										<th class="adcontacttd" colspan="1">게약상태</th>
										<td class="adcontacttd" colspan="1">계약완료</td>
										<th class="adcontacttd" colspan="1">금액</th>
										<td class="adcontacttd" colspan="4"
											style="background-color: #fff3cd;">1,100,000,000 원(계약금
											100,000,000 원)</td>
									</tr>
									<!--

                <tr class="adcontacttr" style="background-color: #fff3cd;">
                    <td class="adcontacttd" colspan="1">101</td>
                    <td class="adcontacttd" colspan="2"> 2020-12-11 </td>
                    <td class="adcontacttd" colspan="2"> 계약완료 </td>
                    <td class="adcontacttd"  colspan="5" >
                        <div style="width: 360px;">
                            서울특별시 강남구 테헤란로 139-2 1204호
                        </div>
                    </td>
                </tr>
    -->

									<tr>
										<td class="adcontacttd" colspan="10""><textarea
												name="contractcontent" id="contractcontent" rows="13">여기에 글쓰기</textarea>
										</td>
									</tr>


									<tr>
										<th class="adcontacttd" colspan="10"
											style="background-color: #cfe2ff;">임차인 정보 </th>
									</tr>


									<tr class="headtr">
										<th class="adcontacttd">계약자명</th>
										<td class="adcontacttd" colspan="3"><input type="text"
											style="width: 200px;" value="공인중개사사무소공인중개사"></td>
										<th class="adcontacttd" colspan="1">전화번호</th>
										<td class="adcontacttd" colspan="2"><input type="text"
											style="width: 140px;" value="010=1234-5678"></td>
										<!-- 여기를  전자계약서 입력시에는 2,암호입력상태  조회시 1,암호임력  크기조절한다 -->
										<th class="adcontacttd" colspan="2">암호입력상태</th>
										<td class="adcontacttd" colspan="1"><input type="text"
											style="width: 80px; background-color: transparent;"
											value="해당무" disabled></td>
									</tr>

									<tr class="headtr">
										<th class="adcontacttd">주민번호</th>
										<td class="adcontacttd" colspan="2"><input type="text"
											style="width: 140px;" value="123456-1234567"></td>
										<th class="adcontacttd" colspan="1">주소</th>
										<td class="adcontacttd" colspan="6"><input type="text"
											style="width: 450px;"
											value="서울특별시 영등포구 여의도동 여의도아파트 1234-123, 1234호"></td>
									</tr>


									<!-- 임차인 정보 -->
									<tr>
										<th class="adcontacttd" colspan="10"
											style="background-color: #cfe2ff;">임대인 정보</th>
									</tr>


									<tr class="headtr">
										<th class="adcontacttd">계약자명</th>
										<td class="adcontacttd" colspan="3"><input type="text"
											style="width: 200px;" value="공인중개사사무소공인중개사"></td>
										<th class="adcontacttd" colspan="1">전화번호</th>
										<td class="adcontacttd" colspan="2"><input type="text"
											style="width: 140px;" value="010=1234-5678"></td>
										<!-- 여기를  전자계약서 입력시에는 2,암호입력상태  조회시 1,암호임력  크기조절한다 -->
										<th class="adcontacttd" colspan="2">암호입력상태</th>
										<td class="adcontacttd" colspan="1"><input type="text"
											style="width: 80px; background-color: transparent;"
											value="해당무" disabled></td>
									</tr>

									<tr class="headtr">
										<th class="adcontacttd">주민번호</th>
										<td class="adcontacttd" colspan="2"><input type="text"
											style="width: 140px;" value="123456-1234567"></td>
										<th class="adcontacttd" colspan="1">주소</th>
										<td class="adcontacttd" colspan="6"><input type="text"
											style="width: 450px;"
											value="서울특별시 영등포구 여의도동 여의도아파트 1234-123, 1234호"></td>
									</tr>

									<!-- 임차인 정보 -->
									<tr>
										<th class="adcontacttd" colspan="10"
											style="background-color: #cfe2ff;">중개인 정보</th>
									</tr>


									<tr class="headtr">
										<th class="adcontacttd">계약자명</th>
										<td class="adcontacttd" colspan="3"><input type="text"
											style="width: 200px;" value="공인중개사사무소공인중개사"></td>
										<th class="adcontacttd" colspan="1">전화번호</th>
										<td class="adcontacttd" colspan="2"><input type="text"
											style="width: 140px;" value="010=1234-5678"></td>
										<!-- 여기를  전자계약서 입력시에는 2,암호입력상태  조회시 1,암호임력  크기조절한다 -->
										<th class="adcontacttd" colspan="2">암호입력상태</th>
										<td class="adcontacttd" colspan="1"><input type="text"
											style="width: 80px; background-color: transparent;"
											value="해당무" disabled></td>
									</tr>

									<tr class="headtr">
										<th class="adcontacttd">중개사번호</th>
										<td class="adcontacttd" colspan="2"><input type="text"
											style="width: 140px;" value="123456-1234567"></td>
										<th class="adcontacttd" colspan="1">주소</th>
										<td class="adcontacttd" colspan="6"><input type="text"
											style="width: 450px;"
											value="서울특별시 영등포구 여의도동 여의도아파트 1234-123, 1234호"></td>
									</tr>


								</table>
							</div>


						<div class="boardbutton">
							<button id="passwordupdate">
							암호재등록
							</button>
							
							<button id="statechange">
							상태변경
							</button>
						  	
						  	<button>
						  	목록
						  	</button>	
						</div>

						</td>
					</tr>
				</table>
			</form>



		</div>

	</div>

	<!-- footer -->
	<%@include file="/WEB-INF/views/inc/footer.jsp"%>


	<script>
		$("input[type='checkbox'][name='seq']").click(function() {
			if ($(this).prop('checked')) {

				$('input[type="checkbox"][name="seq"]').prop('checked', false);
				$(this).prop('checked', true);
			}
		});
	</script>



</body>
</html>