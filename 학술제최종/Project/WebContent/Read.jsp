<%@page import="com.project.ISAM.Contents"%>
<%@page import="java.io.PrintWriter"%>
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
  </head>

  <body>

   <%@include file="./header.jsp"%>


		<table class="table table-striped" style="text-align:center; border:1px solid #dddddd">
			<thread>
				<tr>
					<th colspan="2" style="background-color :#eeeeee; text-align:center;">게시판 글쓰기 양식</th>
				</tr>
			</thread>
			<tbody>
			<tr>
			<td>${contents.getProtype()}</td>
			</tr>
			<tr>
			<td>마감일자:${contents.getDeadline()}</td>
			</tr>
				<tr>
					<td>프로젝트명:${contents.getProjectname()}</td>
				</tr>
				<tr>
					<td>팀장:${contents.getName()}</td>
				</tr>
				<tr>
					<td>프로젝트내용:${contents.getContent()}</td>
				</tr>
				<tr>
				<td><a href="modifiedpre?a=${contents.getName()}&b=${contents.getProjectname()}" class="btn btn-info">수정</a></td>
				</tr>
				
			</tbody>
			</table>
			          
</body>
</html>