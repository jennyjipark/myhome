<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="/Myhome_project/css/nav.css">
<%@include file="/WEB-INF/views/inc/asset.jsp" %>

<style>

.nav1-box1 {
	border: none;		
	}


.navsub{
    background-color: white;
    text-align: center;
    padding-bottom: 10px;
    width: 130px;
    position: absolute;
    left: 200px;
    z-index: 1;
}
.navsub a{
    display: block;
}

input[id="menu1"]{
    display: none;    
    position: relative;
}
#menu1:checked+label+.navsub{
    display: none;
}

input[id="menu2"]{
    display: none;    
    position: relative;
}
#menu2:checked+label+.navsub{
    display: none;
}

input[id="menu3"]{
    display: none;    
    position: relative;
}
#menu3:checked+label+.navsub{
    display: none;
}
input[id="menu4"]{
    display: none;    
    position: relative;
}
#menu4:checked+label+.navsub{
    display: none;
}
input[id="menu5"]{
    display: none;    
    position: relative;
}
#menu5:checked+label+.navsub{
    display: none;
}
input[id="menu6"]{
    display: none;    
    position: relative;
}
#menu6:checked+label+.navsub{
    display: none;
}



</style>
</head>
<body>
 <nav class="nav1">
                <div id="mypage-title">관리자페이지</div>
                   <div class="nav1-box1">

                        <div class="nav1-content" id="nav1-content4">
                           <div class="nav1-box1-img glyphicon glyphicon-user"></div>
                           <div class="nav1-box1-content">
                            
                            <input type="checkbox" id="menu1" checked>
                            <label for="menu1">회원정보관리</label>
                                <div class="navsub">
                                <a id="" href="" class="nav-list userupdate  ">회원정보수정</a>
                                <a id="" href="" class="nav-list contractmanage ">거래정보관리</a>
                                </div>
                            
                            
                            </div>
                       
                        </div>

                        <div class="nav1-content" id="nav1-content1">
                           <div class="nav1-box1-img glyphicon glyphicon-briefcase"></div>

                           <div class="nav1-box1-content cleanmovemanage">

                            <input type="checkbox" id="menu2" checked>
                            <label for="menu2">제휴업체관리</label>
                                <div class="navsub">
                                <a id="" href="" class="nav-list move  ">이사업체</a>
                                <a id="" href="" class="nav-list clean ">청소업체</a>
                                </div>
                            

                            </div>   
                    
                       </div>
                       
                       <div class="nav1-content" id="nav1-content1">
                           <div class="nav1-box1-img glyphicon glyphicon-home"></div>
                           <div class="nav1-box1-content propertymanage">
                               
                                <input type="checkbox" id="menu3" checked>
                                <label for="menu3">메물관리</label>
                                <div class="navsub">
                                <a id="" href="" class="nav-list payment  ">가격변회</a>
                                <a id="" href="" class="nav-list property ">매물관리</a>
                                <a id="" href="" class="nav-list adminalert ">알림서비스</a>
                                </div>

                            
                            </div>
      
                       </div>
                    



                       <div class="nav1-content" id="nav1-content2">
                           <div class="nav1-box1-img glyphicon glyphicon-list-alt"></div>
                           <div class="nav1-box1-content">
                               
                            
                            <input type="checkbox" id="menu4" checked>
                            <label for="menu4">게시판관리</label>
                            <div class="navsub">
                                <a id="" href="" class="nav-list adpolicy">부동산정책</a>
                                <a id="" href="" class="nav-list adchecklist ">체크리스트</a>
                                <a id="" href="" class="nav-list adapplication ">청약안내</a>
                                <a id="" href="" class="nav-list adcommunity ">정보공유커뮤니티</a>
                                <a id="" href="" class="nav-list adused ">중고물품게시판관리</a>


                            </div>
                        
                        
                            </div>
                       </div>
                       

                       <div class="nav1-content" id="nav1-content2">
                           <div class="nav1-box1-img glyphicon glyphicon-pencil"></div>
                           <div class="nav1-box1-content contractmanage">

                                <input type="checkbox" id="menu5" checked>
                                <label for="menu5">전자계약</label>
                                <div class="navsub">
                                <a id="" href="" class="nav-list adcontract">전자계약관리</a>
                                <a id="" href="" class="nav-list adpaper">양식</a>
                            
                            
                                </div>
                            </div>
                       </div>
                       


                       <div class="nav1-content" id="nav1-content3">
                           <div class="nav1-box1-img glyphicon glyphicon-heart"></div>
                           <div class="nav1-box1-content nav-list">
                               
                                <input type="checkbox" id="menu6" checked>
                                <label for="menu6">고객센터</label>
                                <div class="navsub">
                                    <a id="" href="" class="nav-list adnotice">공지사항</a>
                                    <a id="" href="" class="nav-list adqna">QnA</a>
                                    <a id="" href="" class="nav-list adreport">신고관리</a>
                                
                                </div>
                            </div>
                        </div>
                       
                 </div>
            </nav>  

</body>
</html>