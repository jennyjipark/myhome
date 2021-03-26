<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::내가쓴글보기</title>

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

.container {
	border: 0px;
    border-right: 1px solid #DBDCE0;
    border-left: 1px solid #DBDCE0;
    
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

.tbl {
   text-align: center;
   width: 800px;
   margin: auto;
   position: absolute;
   top: 278px;
   left: 640px;

}

.tbl th {
   text-align: center;
   border-top: 1px solid #d4d4d4;
}

.tbl tr {
   border-bottom: 1px solid #d4d4d4;
   height: 35px;
}

.tbl tr:nth-child(odd) {
   background-color: #F9F9F9;
}

.tbl tr:hover {
   cursor: pointer;
   background-color: #ffe1e1;
   font-weight: bold;
   text-decoration: underline;
}

.section1 {
   padding-left: 50px;
   /* border: 1px solid black; */
   font-size: 16px;
   font-family: 'NanumBarunGothic';
   float: left;
   width: 900px;
}

#btnpost {
   background-color: #F1AEAE;
}

#btncomment {
   background-color: white;
}

#tbl2 {
   
   visibility: hidden;
}

#tbl3 {
   visibility : hidden;
}

#maintitle {
   border-bottom: 1px solid #ccc;
   font-size: 24px;
   font-family: 'MaplestoryOTFLight';
   padding-right: 50px;
   position: relative;
   display: inline;
   left: 100px;
   top: 100px;
   text-align: left;
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

            <div id="maintitle">내가 쓴 글 보기</div>
            <div class="section1">
               <div style="margin-top: 50px; color: #ccc; text-align: right;">
                  <span class="glyphicon glyphicon-triangle-bottom"></span> 글 종류를
                  선택하세요.
               </div>
               <div style="text-align: right; margin: 19px;">
                  <button type="button" class="btn btn-default" id="btnpost">글</button>
                  <button type="button" class="btn btn-default" id="btncomment">댓글
                     & 후기</button>
                  <button type="button" class="btn btn-default" id="btnreport">신고</button>
               </div>


               <div class="box1">
                  <table class="tbl" id="tbl1">
                     <tr>
                        <th>게시판</th>
                        <th>글번호</th>
                        <th>제목</th>
                        <th>작성일/상태</th>
                        <th>조회수</th>
                     </tr>
                     
                     <c:if test="${alist.size()==0&&blist.size()==0&&clist.size()==0}">
                     <tr>
                        <td colspan="5">작성한 게시물(글)이 없습니다.</td>
                     </tr>
                     </c:if>
                     
                     <c:forEach items="${alist}" var="adto">
                     <tr onclick="location.href='/Myhome_project/user/boardusedview.do?seq=${adto.seqUsed}'">
                        <td>중고장터</td>
                        <td>${adto.seqUsed}</td>
                        <td>${adto.title}</td>
                        <td>${adto.writeDate}</td>
                        <td>${adto.count}</td>
                     </tr>
                     </c:forEach>
                     
                     <c:forEach items="${blist}" var="bdto">
                     <tr onclick="location.href='/Myhome_project/contractor/search-property-detail.do?seq=${bdto.seqProperty}';">
                        <td>방올리기</td>
                        <td>${bdto.seqProperty}</td>
                        <td>${bdto.title}</td>
                        <td>${bdto.state}</td>
                        <td>-</td>
                     </tr>
                     </c:forEach>
                     
                     <c:forEach items="${clist}" var="cdto">
                     <tr onclick="location.href='/Myhome_project/Myhome/user/boardcommunityview.do?seq=${cdto.seqCommunity}';">
                        <td>커뮤니티</td>
                        <td>${cdto.seqCommunity}</td>
                        <td>${cdto.title}</td>
                        <td>${cdto.writeDate}</td>
                        <td>${cdto.viewCount}</td>
                     </tr>
                     </c:forEach>
                     
                  </table>
               </div>
               <div class="box2">
                  <table class="tbl" id="tbl2">
                     <tr>
                        <th>게시판</th>
                        <th>댓글번호</th>
                        <th>댓글</th>
                        <th>작성일</th>
                     </tr>
                     
                     <c:if test="${dlist.size()==0&&elist.size()==0&&flist.size()==0&&glist.size()==0&&hlist.size()==0&&ilist.size()==0}">
                     <tr>
                        <td colspan="4">작성한 게시물(댓글)이 없습니다.</td>
                     </tr>
                     </c:if>
                     
                     <c:forEach items="${dlist}" var="ddto">
                     <tr onclick="location.href='/Myhome_project/user/boardusedview.do?seq=${ddto.seqUsed}'">
                        <td>중고장터</td>
                        <td>${ddto.seqUsedComment}</td>
                        <td>${ddto.content}</td>
                        <td>${ddto.writeDate}</td>
                     </tr>
                     </c:forEach>
                     
                     <c:forEach items="${elist}" var="edto">
                     <tr onclick="location.href='/Myhome_project/Myhome/user/boardcommunityview.do?seq=${edto.seqCommunity}';">
                        <td>커뮤니티</td>
                        <td>${edto.seqCommunityComment}</td>
                        <td>${edto.content }</td>
                        <td>-</td>
                     </tr>
                     </c:forEach>
                     
                     <c:forEach items="${flist}" var="fdto">
                     <tr><!-- onclick -> seqMoveReservation로 달아둘것 -->
                        <td>이사업체후기</td>
                        <td>${fdto.seqMoveReview}</td>
                        <td>[${fdto.name}]${fdto.title}</td>
                        <td>${fdto.reservationDate}</td>
                     </tr>
                     </c:forEach>
                     
                     <c:forEach items="${glist}" var="gdto">
                     <tr><!-- onclick -> seqCleanReservation로 달아둘것 -->
                        <td>청소업체후기</td>
                        <td>${gdto.seqCleanReview}</td>
                        <td>[${gdto.name}]${gdto.title}</td>
                        <td>${gdto.reservationDate}</td>
                     </tr>
                     </c:forEach>
                     
                     <c:forEach items="${hlist}" var="hdto">
                     <tr onclick="location.href='/Myhome_project/user/mypagecontractdetail.do?seqContract=${hdto.seqContract}'">
                        <td>중개인후기</td>
                        <td>${hdto.seqContractorReview}</td>
                        <td>[${hdto.contractorName}]${hdto.title}</td>
                        <td>-</td>
                     </tr>
                     </c:forEach>
                     
                     <c:forEach items="${ilist}" var="idto">
                     <tr onclick="location.href='/Myhome_project/contractor/search-property-detail.do?seq=${idto.seqProperty}'"><!-- onclick -> seqContract로 계약서랑 연결 달아둘것 -->
                        <td>매물후기</td>
                        <td>${idto.seqPropertyReview}</td>
                        <td>[${idto.ptitle}]${idto.title}</td>
                        <td>-</td>
                     </tr>
                     </c:forEach>
                     
                  </table>

               </div>
               <div class="box3">
                  <table class="tbl" id="tbl3">
                     <tr>
                        <th>게시판</th>
                        <th>글번호</th>
                        <th>신고사유</th>
                        <th>신고일</th>
                        <th>처리상태</th>
                     </tr>
                     
                     <c:if test="${jlist.size()==0&&klist.size()==0&&llist.size()==0}">
                     <tr>
                        <td colspan="5">작성한 게시물(신고)이 없습니다.</td>
                     </tr>
                     </c:if>
                     
                     <c:forEach items="${jlist}" var="jdto">
                     <tr onclick="location.href='/Myhome_project/user/boardusedview.do?seq=${jdto.seqUsed}'">
                        <td>중고장터</td>
                        <td>${jdto.seqUsedReport}</td>
                        <td>${jdto.reason}</td>
                        <td>-</td>
                        <td>${jdto.reportState}</td>
                     </tr>
                     </c:forEach>
                     
                     <c:forEach items="${klist}" var="kdto">
                     <tr onclick="location.href='/Myhome_project/contractor/search-property-detail.do?seq=${kdto.seqConctractorProperty}';">
                        <td>방찾기</td>
                        <td>${kdto.seqPropertyContractReport}</td>
                        <td>${kdto.reason}</td>
                        <td>-</td>
                        <td>${kdto.reportState}</td>
                     </tr>
                     </c:forEach>
                     
                     <c:forEach items="${llist}" var="ldto">
                     <tr onclick="location.href='/Myhome_project/Myhome/user/boardcommunityview.do?seq=${ldto.seqCommunity}';" >
                        <td>커뮤니티</td>
                        <td>${ldto.seqCommunityReport}</td>
                        <td>${ldto.reason}</td>
                        <td>${writeDate}</td>
                        <td>-</td>
                     </tr>
                     </c:forEach>
                     
                  </table>
               </div>

            </div>

         </div>
      </div>


      <!-- footer -->
      <%@include file="/WEB-INF/views/inc/footer.jsp"%>
   </div>

   <script>
      var btnpost = document.getElementById("btnpost");
      var btncomment = document.getElementById("btncomment");
      var btnreport = document.getElementById("btnreport");

      btnpost.onclick = function() {
         document.getElementById("tbl1").style.visibility = 'visible';
         document.getElementById("tbl2").style.visibility = 'hidden';
         document.getElementById("tbl3").style.visibility = 'hidden';
         btnpost.style.backgroundColor = '#F1AEAE';
         btncomment.style.backgroundColor = 'white';
         btnreport.style.backgroundColor = 'white';
      };

      btncomment.onclick = function() {
         document.getElementById("tbl1").style.visibility = 'hidden';
         document.getElementById("tbl2").style.visibility = 'visible';
         document.getElementById("tbl3").style.visibility = 'hidden';
         btnpost.style.backgroundColor = 'white';
         btncomment.style.backgroundColor = '#F1AEAE';
         btnreport.style.backgroundColor = 'white';
      };

      btnreport.onclick = function() {
         document.getElementById("tbl1").style.visibility = 'hidden';
         document.getElementById("tbl2").style.visibility = 'hidden';
         document.getElementById("tbl3").style.visibility = 'visible';
         btnpost.style.backgroundColor = 'white';
         btncomment.style.backgroundColor = 'white';
         btnreport.style.backgroundColor = '#F1AEAE';
      };
   </script>


</body>
</html>