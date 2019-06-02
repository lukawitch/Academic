<%@page import="com.project.ISAM.List_data"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.project.ISAM.data"%>
<%@page import="com.project.ISAM.Connect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.project.ISAM.ListChange" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>


<!DOCTYPE html>
<html>
<head>
<%@include file="./common.jsp"%>
  </head>

  <body>
  <%

  if(session.getAttribute("dataes")==null){
	  session.setAttribute("Value","졸업작품");
  %>
  


 <c:set var="init" value="<%=new Connect() %>" />
${init.basic()}

<c:set var="data" value="${init.getData()}" />
<c:set var="dataes" value="${data.getBasic_data()}" />

<c:set var="size" value="${dataes.size()}" />
  <% 
  }
  else{
	  ArrayList<data> dataaa=new ArrayList<data>();
	  dataaa = (ArrayList<data>)session.getAttribute("dataes");
	  int size=dataaa.size();
	  session.setAttribute("SIZE",size);
	  
%>
	  <c:set var="dataes" value="${dataes}" />
	  <c:set var="size" value="${SIZE}" />
  <% }
  %>
  
   <%@include file="./header.jsp"%>

<%

if(session.getAttribute("number")==null){
session.setAttribute("number",1);
session.setAttribute("prenext",0);
}
%>








    <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
      <h1 class="display-4"  style="font-family:'Malgun Gothic';"><%=session.getAttribute("Value") %></h1>
	  <br>
      <p class="lead">우리학교 학생들의 <%=session.getAttribute("Value") %>을 모아놓은 게시판입니다</p>
	  
    </div>
<div class="container">
      <nav class="navbar navbar-expand-lg  rounded">
        <img src="./resource/img/LOGO.png" width="30" height="30" class="d-inline-block align-top"/>
        <button class="navbar-toggler navbar-light" type="button" data-toggle="collapse" data-target="#navbarsExample09" aria-controls="navbarsExample09" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsExample09">
          <ul class="navbar-nav mr-auto">
		<li class="nav-item dropdown">
              <a style="color:black;"class="nav-link dropdown-toggle" href="https://example.com" id="dropdown09" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">프로젝트진행상황</a>
              <div class="dropdown-menu" aria-labelledby="dropdown09">
                <a class="dropdown-item" href="#">진행중</a>
                <a class="dropdown-item" href="#">프로젝트완료</a>
              </div>
            </li>
            <li class="nav-item dropdown">
              <a style="color:black;"class="nav-link dropdown-toggle" href="https://example.com" id="dropdown09" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">연도</a>
              <div class="dropdown-menu" aria-labelledby="dropdown09">
                <a class="dropdown-item" href="#">2018</a>
                <a class="dropdown-item" href="#">2017</a>
                <a class="dropdown-item" href="#">2016</a>
				  <a class="dropdown-item" href="#">2015</a>
                <a class="dropdown-item" href="#">2014</a>
                <a class="dropdown-item" href="#">2013이전</a>
              </div>
            </li>
          </ul>
           <form class="form-inline">
    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
    <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Search</button>
  </form>
        </div>

<c:choose>
<c:when test="${((prenext+1) *30)<=size}">
 <c:set var="end" value="${5}"></c:set>
</c:when>

<c:otherwise>

<c:choose>
<c:when test="${prenext>=1}">
<c:set var="end" value="${size%6+1}"></c:set>
</c:when>
<c:otherwise>
<c:choose>
<c:when test="${size<=6}">
<c:set var="end" value="${1}"></c:set>
</c:when>
<c:otherwise>
<c:choose>
<c:when test="${size%6==0}">
<c:set var="end" value="${size/6}"></c:set>
</c:when>
<c:otherwise>
<c:set var="end" value="${size/6+1}"></c:set>
</c:otherwise>
</c:choose>
</c:otherwise>
</c:choose>
</c:otherwise>
</c:choose>
</c:otherwise>

</c:choose>



<c:set var="aaa" value="${((number-1)*6+6+prenext*30)}"></c:set>
 <c:choose>

<c:when test="${aaa<=size}">

 <c:set var="list" value="${5}"></c:set>

</c:when>

<c:otherwise>

<c:set var="list" value="${size%6-1}"></c:set> <!--  -1  -->



</c:otherwise>

</c:choose>
      </nav>
<c:choose>
<c:when test="${list<0}">
 <%@include file="./error.jsp"%>
</c:when>
<c:otherwise>
    <div class="container">
    <div class="row">

    <c:forEach var="i" begin="0" end="${list}" varStatus="status">
     
  <div class="col-sm-4" style="text-align:center">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title" style="font-family:'Malgun Gothic';">${dataes.get(((number-1)*6)+i+(prenext*30)).getProjectName()}</h5>
		<br>
        <p class="card-text">${dataes.get(((number-1)*6)+i+(prenext*30)).getNow()}<br>
		
		팀장:${dataes.get(((number-1)*6)+i+(prenext*30)).getname()}(${dataes.get(((number-1)*6)+i+(prenext*30)).getmajor()})</p>
        <a href="read?a=${dataes.get(((number-1)*6)+i+(prenext*30)).getname()}&b=${dataes.get(((number-1)*6)+i+(prenext*30)).getProjectName()}" class="btn btn-outline-info">자세히알아보기</a>
      </div>
    </div>
  </div>
  </c:forEach>

</div>
   <br/>
   <br/> 
   

<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
        <c:choose>
    <c:when test="${prenext==0}">
 	 <li class="page-item disabled">
      <a class="page-link" href="#" tabindex="-1">Previous</a>
    </li>
	</c:when>
	<c:otherwise>
	 <li class="page-item">
      <a class="page-link" href="ListChange?a=1&b=${prenext}&c=-1" tabindex="-1">Previous</a>
    </li>
	</c:otherwise>
</c:choose>
   
    <c:forEach  var="i" begin="1" end="${end}">
    <li class="page-item"><a class="page-link" href="ListChange?a=${i}&b=${prenext}">${prenext*5+i}</a></li>
    </c:forEach>
      <c:choose>
    <c:when test="${((prenext+1) *30)<=size}">
 	<li class="page-item">
      <a class="page-link" href="ListChange?a=1&b=${prenext}&c=1">Next</a>
    </li>
	</c:when>
	<c:otherwise>
	<li class="page-item disabled">
      <a class="page-link" href="#" tabindex="-1">Next</a>
    </li>
	</c:otherwise>
</c:choose>
   
  </ul>
</nav>
    </div>
    </c:otherwise>
    </c:choose>
    <a href="editperson?a=write" class="btn btn-lg btn btn-info">프로젝트 작성</a>
</div>
  <%
  
session.setAttribute("number",1);
 session.setAttribute("prenext",0);

%>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="./resource/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="./resource/js/popper.min.js"></script>
    <script src="./resource/js/bootstrap.min.js"></script>
    <script src="./resource/js/holder.min.js"></script>
    <script>
      Holder.addTheme('thumb', {
        bg: '#55595c',
        fg: '#eceeef',
        text: 'Thumbnail'
      });
    </script>
  </body>
</html>
