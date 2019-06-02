<%@page import="com.project.ISAM.Default"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.project.ISAM.data"%>
<%@page import="java.util.List"%>
<%@page import="com.project.ISAM.List_data"%>
<%@page import="com.project.ISAM.Member"%>
<%@page import="com.project.ISAM.Connect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.project.ISAM.ListChange" %>

<!DOCTYPE html>
<html>
<head>
<%@include file="./common.jsp"%>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.2/moment-with-locales.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/js/bootstrap-datetimepicker.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote-lite.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote-lite.js"></script>
  	<script src="lang/summernote-ko-KR.js"></script>
  </head>

  <body>
  
<%
if(session.getAttribute("id")==null){
	 out.println("<script>alert('로그인부터 해주세요');location.href='index.jsp';</script>");
}
else{
	String role;
	Member mem =new Member();
	mem=(Member)session.getAttribute("member");
	System.out.println(mem);
	role=mem.getRole();
	
	if(role.equals("member")){
		out.println("<script>alert('팀장만 접근 가능합니다');location.href='index.jsp';</script>");
	}
	String name,major;
	name=mem.getName();
	major=mem.getMajor();
	session.setAttribute("Name", name);
	session.setAttribute("major",major);
	System.out.println(session.getAttribute("Name"));
	Default bb= new Default();
	bb.basic();
	List_data a =new List_data();
	a=bb.getData();
	List<data> c =new ArrayList<data>();
	c=a.getBasic_data();
	int size=c.size();
	session.setAttribute("defalut",size);
}
%>
   <%@include file="./header.jsp"%>

<form action="write" method="post">
		<table class="table table-striped" style="text-align:center; border:1px solid #dddddd">
			<thread>
				<tr>
					<th colspan="2" style="background-color :#eeeeee; text-align:center;">게시판 글쓰기 양식</th>
				</tr>
			</thread>
			<tbody>
				<tr>
			<td><div class="custom-control custom-radio custom-control-inline">
  <input type="radio" id="optradio1" name="optradio" value="1" checked class="custom-control-input">
  <label class="custom-control-label" for="optradio1">학술제</label>
</div>



<div class="custom-control custom-radio custom-control-inline">
  <input type="radio" id="optradio2" name="optradio" value="2"  class="custom-control-input">
  <label class="custom-control-label" for="optradio2">프로젝트</label>
</div>


<div class="custom-control custom-radio custom-control-inline">
  <input type="radio" id="optradio3" name="optradio" value="3" class="custom-control-input">
  <label class="custom-control-label" for="optradio3">졸업작품</label>
</div></td>
			</tr>
			<tr>
			<td><label class="radio-inline"><input type="radio" id="state" name="state" value="1"checked>진행중</label>
<label class="radio-inline"><input type="radio" id="state" name="state" value="2">완료</label></td>
			</tr>
			<tr>
			<td>마감일자:<input id="someDate" type="date" id="deadline" name ="deadline" ></td>
			</tr>
				<tr>
					<td>  
					<div class="form-group row">
						    <label for="inputPassword" class="col-sm-2 col-form-label">제목</label>
						    <div class="col-sm-10">
						    <input class="form-control" type="text" placeholder="프로젝트명" id="title" name="title"  maxlength = "50">
						
					</div></td>
				</tr>
				
				<tr>
				<td> 
   				 <textarea class="custom-toolbar" id="summernote" name="contents"></textarea>
    				<script>
    				  $(function() {
    					    $('.custom-toolbar').summernote({
    						 height: 300,                 // set editor height
    					  minHeight: null,             // set minimum height of editor
    					  maxHeight: null,             // set maximum height of editor
    					  focus: true ,
    					      toolbar: [
    					        ['style', ['bold', 'italic', 'underline', 'clear']],
    					        ['font', ['strikethrough', 'superscript', 'subscript']],
    					        ['fontsize', ['fontsize']],
    					        ['color', ['color']],
    					        ['para', ['ul', 'ol', 'paragraph']],
    					        ['height', ['height']],
    							['insert', ['table','hr']],
    							['misc',['codeview','undo','redo']]
    					      ],
    					      placeholder: '동영상은 </>클릭해서 <iframe>태그 넣어주시면됩니다.',
    						  popover: {
    					  image: [
    					    ['imagesize', ['imageSize100', 'imageSize50', 'imageSize25']],
    					    ['float', ['floatLeft', 'floatRight', 'floatNone']],
    					    ['remove', ['removeMedia']]
    					  ],
    					  link: [
    					    ['link', ['linkDialogShow', 'unlink']]
    					  ],
    					  air: [
    					    ['color', ['color']],
    					    ['font', ['bold', 'underline', 'clear']],
    					    ['para', ['ul', 'paragraph']],
    					    ['table', ['table']],
    					    ['insert', ['link', 'picture']]
    					  ]
    					}
    					    });
    					  });
				    </script></td>
				</tr>	
				<tr>
				<td>
				<div class="custom-file">
					  <input type="file" class="custom-file-input" id="customFile">
					  <label class="custom-file-label" for="customFile">Choose file</label>
				</div></td>
				</tr>
				<tr>
					<td><input type="submit" class="btn  btn-info" value="작성"></td>
				</tr>
			</tbody>
			</table>
						
		</form>

</body>
</html>