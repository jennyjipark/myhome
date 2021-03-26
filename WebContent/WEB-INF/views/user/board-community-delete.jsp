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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="/Myhome_project/css/boarduserver.css"> -->


<!-- 부트스트랩 사용가능한 템플릿 -->

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
	
	
	
	
	
	.modal-backdrop {
	    z-index: auto !important;
	    background-color: #ccc !important;
	 }
	 
	 .modal-dialog {
	    position: relative;
	    top: 200px;
	    
	 }
	 
	 #btn4 {
	    left: auto;
	    top: auto;
	 } 
	 
	 
	 #btn4, #btn5 {
       
       	float: right;
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
       
       #btn3 {
       		background-color: transparent;
       		border: 0;
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
				
				<button type="button" data-toggle="modal" data-target="#deleteModal" id="btn3"></button>
				
				   <!-- Modal -->
							<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">
							  <div class="modal-dialog" role="document">
							    <div class="modal-content">
							      <div class="modal-header">
							        <h5 class="modal-title" id="deleteModalLabel">게시물 삭제</h5>
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
							          <span aria-hidden="true">&times;</span>
							        </button>
							      </div>
							      <div class="modal-body">
							        게시물을 정말 삭제하시겠습니까?
							      </div>
							      <div class="modal-footer">
							      	<button type="button" class="btn btn-default" id="btn4" onclick="location.href='/Myhome_project/Myhome/user/boardcommunitydeleteok.do?seq=${seq}';">삭제</button>
							       	<!-- <button type="button" class="btn btn-default" data-dismiss="modal">취소</button> -->
							       	<button type="button" class="btn btn-default" id="btn5" onclick="location.href='/Myhome_project/Myhome/user/boardcommunityview.do?seq=${seq}';">취소</button>
							      </div>
							    </div>
							  </div>
							</div>
                
         </div>
	
       
   </div>

</div> 

</div>
     <!-- footer -->
<%@include file="/WEB-INF/views/inc/footer.jsp" %>
<script>


</script>
	
</body>
</html>