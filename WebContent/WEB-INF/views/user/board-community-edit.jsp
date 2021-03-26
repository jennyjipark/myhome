<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%


%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::커뮤니티</title>
<%@include file="/WEB-INF/views/inc/asset.jsp" %>
<link rel="stylesheet" href="/Myhome_project/css/template.css">
<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">
<!-- <link rel="stylesheet" href="/Myhome_project/css/boarduserver.css"> -->


<!-- board-community-view.jsp -->

<style>
	
	.boardwrap{
	    height: auto;
	    min-height: 100%;
	}
	
	.container {
		border-color: transparent;
		font-family: 'NanumBarunGothic', sans-serif;
		font-size: 16px;
		position: relative;
	}
	
	.boardcover {
		float: left;
		width: 100%; 

	}
	
	 #maintitle {

	   font-size: 24px;
	   font-family: 'MaplestoryOTFLight';
	   padding:0 10px;
	   border-left: 5px solid #f1aeae;
	   position: relative;
	   display: inline;
	   text-align:left;
		color: #202020;
		top: 100px;
		left: 100px;
		
		float: left;
		
	} 
	
	 .table {
		position: relative;

		
		border-top: solid 1px #ccc;
		border-bottom: solid 1px #ccc;
	
		top: -820px;
	    left: 280px;
	    float: left;
	
		
		
	
	}
	

	
	#content {
		padding: 15px 15px;
		height: 300px;
		overflow: auto;
		outline: none !important;
		
	}
	
	#title {
		outline: none !important;
	}
	
	
	
	.btn {
		background-color: #f1aeae;
        color: white;
        outline: none;
        
        
        left: 950px;
	    background-color: #f1aeae;
	    color: white;
	    outline: none;
	    position: relative;
	    top: -820px;
	}
	
	.btn:hover {
		background-color: #f1aeae;
		color: white;
	}
	
	
	
	
	
		.boardwrap{
	    height: auto;
	    min-height: 100%;
	}
</style>
</head>
<body>
	
<div class="boardwrap">
 
 <!-- header -->
<%@include file="/WEB-INF/views/inc/bootstrap-header.jsp" %>
 
     <div class="container">
     
     <div class="content col-sm-12 col-md-9">
     
     <%@include file="/WEB-INF/views/user/nav-board.jsp"%>
    
		<div>
				<div id="maintitle">커뮤니티</div>
				
				
				<form method="POST" action="/Myhome_project/Myhome/user/boardcommunityeditok.do">
                <div id="box1">
                <table class="table write">
                    <tr>
                        <td>
                            <input type="text" class="form-control" placeholder="제목" id="title" name="title" required value="${dto.title}">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <textarea class="form-control" id="content" placeholder="내용" name="content" required>${dto.content}</textarea>
                        </td>
                    </tr>                   
                </table>
                </div>


                <div style="clear:both;"></div>

                <div class="btns">
                    <button type="submit" class="btn" id="btn1">글쓰기</button>
                    <button type="button" class="btn" id="btn2" onclick="location.href='/Myhome_project/Myhome/user/boardcommunitylist.do';">뒤로가기</button>
                </div>
                
				<input type="hidden" name="seqCommunity" value="${dto.seqCommunity}">
                
                </form>
                <div style="clear:both;"></div>
                
         </div>
		
       
   </div>

</div> 

</div>
     <!-- footer -->
<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	
</body>
</html>