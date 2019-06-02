<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%@include file="./common.jsp"%>

    <!-- Custom styles for this template -->
    <link href="./resource/css/form-validation.css" rel="stylesheet">
	<script src="./resource/js/script.js"></script>
  </head>

  <body class="bg-light">

    <div class="container">
      <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="./resource/img/LOGO.png" alt="" width="72" height="72">
        <h2>회원가입</h2>
        <p class="lead">회원가입을하면 프로젝트 등록및 신청을 할 수 있습니다.</p>
      </div>

      <div class="row">
        
        <div class="col-md-12 order-md-1">
          <h4 class="mb-3">기본정보</h4>
          <form  action="Join" method="post" class="needs-validation" novalidate >
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="Name">이름</label>
                <input type="text" class="form-control" id="name" placeholder="" name="name"required>
                <div class="invalid-feedback">
                  이름을 입력해주세요
                </div>
              </div>
			      
              <div class="col-md-6 mb-3">
                <label for="number">학번/교번</label>
                <input type="text" class="form-control" id="number" placeholder="" name="number" onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)'required>
                <div class="invalid-feedback">
                  학번을 입력해주세요
                </div>
              </div>
            </div>
			<div class="row">
            <div class="col-md-6 mb-3">
              <label for="username">비밀번호</label>


                <input type="password" class="form-control" id="password" name="password" required>
                <div class="invalid-feedback" style="width: 100%;">
                  비밀번호를 입력해주세요
                </div>
            </div>
             <div class="col-md-6 mb-3">
              <label for="username_check">비밀번호확인</label>
                <input type="password" class="form-control" id="password" name="password_check" required>
                <div class="invalid-feedback" style="width: 100%;">
                  비밀번호를 입력해주세요
                </div>
            </div>
          


                
			</div>

            <div class="row">
             <div class="col-md-6 mb-3">
              <label for="username">학과</label>
             <select  class="custom-select d-block w-100" id="major" name="major"required >
                  <option value="">Choose...</option>
	
                  <option value="computer" selected="selected">컴퓨터과학과</option>
				  <option value="Biology">생명과학과</option>
				  <option value="Environment">환경학과</option>
				  <option value="Logistics">물류통계정보학과</option>
				  <option value="Industrial">산업환경보건학과</option>
				  <option value="media">미디어디자인과</option>
				  <option value="Culture_Contents">문화콘텐츠학과</option>
				<option value="dance">무용학과</option>
				<option value="Cultural_Heritage">문화재학과</option>
				<option value="picture">회화학과</option>
				<option value="Korean_music">연극학과</option>
				<option value="applied_music">실용음악과</option>
				<option value="Movie">영화영상학과</option>
				<option value="Management">경영학과</option>
				<option value="police">경찰행정학과</option>
				<option value="China">중국학과</option>
				<option value="Management_info">경영정보학과</option>
				<option value="English">영어과</option>		
				  <option value="Culture_tour">문화관광학과</option>
				  <option value="Food_nutrition">식품영양학과</option>
				  <option value="Physical_therapy">물리치료학과</option>
				  <option value="Social_welfare">사회복지학과</option>
				  <option value="Sports_leisure">스포츠레저학과</option>
				  <option value="Golf">골프학과</option>
				  <option value="Physical">체육학과</option>
				  <option value="Special_sports">특수체육교육학과</option>
				  <option value="judo">유도학과</option>
				   <option value="judo_game">유도경기지도학과</option>
				  <option value="Taekwondo">태권도학과</option>
				  <option value="Taekwondo_game">태권도경기지도학과</option>
				  <option value="combative">격기지도학과</option>
				  <option value="Guard">경호학과</option>
				  <option value="Oriental">동양무예학과</option>
				  <option value="military_affairs">군사학과</option>
				 
			
                </select>
                <div class="invalid-feedback" style="width: 100%;">
                  학과선택해주세요
                </div>
            </div>
              <div class="col-md-6 mb-3">
                <label for="country">직위</label>
                <select class="custom-select d-block w-100" id="role" name="role" >
                  <option value="">Choose...</option>
                  <option value="boss">팀장</option>
				  <option value="member" selected="selected">팀원</option>
                </select>
                <div class="invalid-feedback">
                  Please select a valid country.
                </div>
              </div>
             
              </div>
                <div class="row">
					<div class="col-md-6 mb-3">
              <label for="address">전화번호</label>
              <input type="text" class="form-control" id="phone" placeholder="010********" onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' name="phone" required>
              <div class="invalid-feedback">
                	전화번호를 입력해주세요
              </div>
            </div>
			
			            <div class="col-md-6 mb-3">
              <label for="email">Email</label>
              <input type="email" class="form-control" id="email" placeholder="you@example.com" name="email"required>
                   <div class="invalid-feedback" style="width: 100%;">
                  이메일을 입력해주세요
                </div>
            </div>

				
            </div>  
         
            <hr class="mb-4">
            <input class="btn btn-outline-info btn-lg btn-block" type="submit" value="회원가입"/>
			<br>
			<br>
			<br>
          </form>
        </div>
      </div>

    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="./resource/js/jquery-slim.min.js"><\/script>')</script>
    <script src="./resource/js/vendor/popper.min.js"></script>
    <script src="./resource/js/bootstrap.min.js"></script>
    <script src="./resource/js/vendor/holder.min.js"></script>
    <script>
      // Example starter JavaScript for disabling form submissions if there are invalid fields
      (function() {
        'use strict';

        window.addEventListener('load', function() {
          // Fetch all the forms we want to apply custom Bootstrap validation styles to
          var forms = document.getElementsByClassName('needs-validation');

          // Loop over them and prevent submission
          var validation = Array.prototype.filter.call(forms, function(form) {
            form.addEventListener('submit', function(event) {
              if (form.checkValidity() === false) {
                event.preventDefault();
                event.stopPropagation();
              }
              form.classList.add('was-validated');
            }, false);
          });
        }, false);
      })();
    </script>
  </body>
</html>
