<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/inc/asset.jsp" %>
<link rel="stylesheet" href="/Myhome_project/css/template.css">
<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">
<link rel="stylesheet" href="/Myhome_project/css/board.css">




<style>
	.header {
		background-color : white;
	}
	
	#header:hover {
		background-color: white;
	}
	
	
	
</style>


</head>
<body>
 
<div class="boardwrap">
 
 <!-- header -->
<%@include file="/WEB-INF/views/inc/header.jsp" %>
 
     <div class="container">

        <form action="" id="form1">
            <div class="boardcover">
            <table id="board" class="table table-hover table-striped table-condensed">
    
                <tr class="headtr">
                    <th class="firtd boardtd">번호</th>
                    <th class="sectd boardtd">제목</th>
                    <th class="thitd boardtd">작성자(닉네임)</th>
                    <th class="fortd boardtd">작성일</th>
                    <th class="fiftd boardtd">조회수</th>
                    <th class="sixtd boardtd">선택</th>
                </tr>
                
                <tr class="boardtr">
                    <td class="firtd boardtd">1</td>
                    <td class="sectd boardtd"><span class="boardspan headspan">[카테고리?]</span> 화이팅..<span class="boardspan footspan">[댓글수]</span></td>
                    <td class="thitd boardtd">길도이(닉네임)</td>
                    <td class="fortd boardtd">2020-01-22</td>
                    <td class="fiftd boardtd">11111</td>
                    <td class="sixtd boardtd"><input type="checkbox" name="seq" id="seq"></td>
                </tr>
                <tr class="boardtr">
                    <td class="firtd boardtd">2</td>
                    <td class="sectd boardtd"><span class="boardspan headspan">[카테고리?]</span> 화이팅..<span class="boardspan footspan">[댓글수]</span></td>
                    <td class="thitd boardtd">길도이(닉네임)</td>
                    <td class="fortd boardtd">2020-01-22</td>
                    <td class="fiftd boardtd">11111</td>
                    <td class="sixtd boardtd"><input type="checkbox" name="seq" id="seq"></td>
                </tr>
           
            </table>
            </div>
    
            <div class="boardwork d-grid gap-2 d-md-block">
                <button class="btn btn-outline-secondary" type="button" id="button-addon2">Delete</button>
                <button class="btn btn-outline-secondary" type="button" id="button-addon2">Write</button>  
            </div>
    
    
           <div class="boardserch">
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="button-addon2">
              
              </div>
              <button class="btn btn-outline-secondary" type="button" id="button-addon2">Button</button>
            </div>
        
            
            
            <div class="Boardnext">
                <span class="tenplcount countbt ">◀</span>
                <!-- 10개 이상일 경우에 1개씩 생기도록 화살표 태그에 개별 클래스를 입력하였습니다.!-->
                <span class="countbt" >1</span>
                <span class="tenmicount countbt">▶</span>
            </div>
            
        </form>
           
            
            
        </div>

    </div>
 
     <!-- footer -->
<%@include file="/WEB-INF/views/inc/footer.jsp" %>
 
</body>
</html>