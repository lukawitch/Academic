<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./common.jsp"%>

    <title>Login</title>

    <!-- Bootstrap core CSS -->
    <link href="./resource/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./resource/css/signin.css" rel="stylesheet">
  </head>

  <body class="text-center">
    <form class="form-signin" action="Loginout" method="post">
      <img class="mb-4" src="./resource/img/LOGO.png" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">로그인해주세요</h1>
      <label for="inputEmail" class="sr-only">ID</label>
      <input type="text"placeholder="학번" class="form-control" required autofocus name="id">
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="inputPassword" class="form-control" placeholder="비밀번호" required name="pw">
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>
      <button class="btn btn-lg btn-outline-info btn-block" type="submit">login</button>
	  <br>
      <div class="mb-3 text-muted">아직 회원이 아니신분들은</div>
	  <button class="btn btn-lg btn-outline-info btn-block" type="button" onclick="location.href='./join.jsp' ">회원가입</button>
    </form>
  </body>
</html>
