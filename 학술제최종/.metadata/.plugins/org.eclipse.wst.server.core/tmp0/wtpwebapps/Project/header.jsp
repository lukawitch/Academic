<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



    <div class="container">

	  	  <div class="row flex-nowrap justify-content-between align-items-center">
          <div class="col-1 col-md-4 pt-1">
            <a class="text-muted" href="#"></a>
          </div>
		  	  <div class="col-10 col-md-4 text-center" style="text-align:center;">
			  
      <form class="form-inline" >    

            <input class="form-control col-8" type="search" placeholder="Search" aria-label="Search">
<button class="btn btn-outline-info my-2 my-col-4 col-4" type="submit">Search</button>
      
</form>
   </div> 

            <div class="col-1 col-md-4 d-flex justify-content-end align-items-center">          
          </div>
        </div>

  

 <header class="blog-header py-3">
           <div class="p-3 p-md-5 ">
        <div class="col-12 px-0">
          <img src="./resource/img/Big_Logo.png" class="rounded mx-auto d-block" style="width:50%;height:auto;">
        </div>
      </div>
      </header>
      <div class="nav-scroller py-1 mb-2">
        <nav class="nav d-flex justify-content-between">
          <a class="p-2 text-muted" href="dataconnect?g=Graduation">졸업작품</a>
          <a class="p-2 text-muted" href="dataconnect?g=Academic">학술제</a>
          <a class="p-2 text-muted" href="dataconnect?g=project">프로젝트</a>

          <c:choose>

			<c:when test="${empty id}">
			 
			   <a class="p-2 text-muted" onclick="edit();">개인정보수정</a>
			  <a class="p-2 text-muted" href="./login.jsp">Login</a>
			</c:when>

			<c:otherwise>
			<a class="p-2 text-muted" href="editperson?a=edit">개인정보수정</a>
 			<a class="p-2 text-muted" href="Loginout">Logout</a>
			</c:otherwise>

			</c:choose>
         
        </nav>
		
      </div>
<hr>

<script>
function edit(){
alert('로그인부터 해주세요');
}</script>
