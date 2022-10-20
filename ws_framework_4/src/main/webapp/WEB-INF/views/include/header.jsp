<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--절대경로를 쉽게 사용하기 위해 session에 root를 key로 컨텍스트 루트 경로를 저장해둔다. --%>
<c:set value="${pageContext.request.contextPath }" scope="session" var="root"></c:set>

<%-- bootstrap 관련 코드를 등록한다. --%>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
<%-- 프로젝트에서 정의한 CSS를 참조할 때 resources 경로를 참조한다. --%>
<link rel="stylesheet" href="${root }/resources/css/common.css">
<div class="container">
	<img src="${root }/resources/img/ssafy_logo.png" id="ssafy_logo">
	<h1 class="display-4 text-center">도서 관리</h1>
	<br>
</div>

<!-- 로그인 폼 등 필요 코드 작성 -->

<c:if test="${userinfo eq null}">
	<div class="d-flex justify-content-end">
	  <div class="">
	    <form id="form-login" method="POST" action="">
	      <div class="p-2 bd-highlight">
	        <input
	          type="text"
	          class="form-control"
	          id="userId"
	          name="userId"
	          placeholder="아이디"
	        />
	      </div>
	      <div class="p-2 bd-highlight">
	        <input
	          type="password"
	          class="form-control"
	          id="userPwd"
	          name="userPwd"
	          placeholder="비밀번호"
	        />
	      </div>
	      <div class="text-danger mb-2">${msg}</div>
	      <div class="col-auto text-center">
	        <button type="button" id="btn-login" class="btn btn-outline-primary mb-3">
	         	 로그인
	        </button>
	      </div>
	    </form>
	  </div>
	</div>

	<!-- javaScript Login -->
	<script type="text/javascript">
		document.querySelector("#btn-login").addEventListener("click", function() {
			if (!document.querySelector("#userId").value) {
				alert("아이디 입력");
				return;
			} else if (!document.querySelector("#userPwd").value) {
				alert("비밀번호 입력");
				return;
			} else {
				let form = document.querySelector("#form-login");
				form.setAttribute("action", "${root}/login");
				console.log("login btn 동작");
				form.submit();
			}
		});
		
	    let message = "${msg}";
	    if (message) {
	        alert(message);
	    }
	</script>
</c:if>
<c:if test="${!empty userinfo}">
    <div class="row justify-content-center">
	  <div class="col-lg-8 col-md-10 col-sm-12 m-3 text-end">
		<strong>${userinfo.name}</strong> (${userinfo.id})님 안녕하세요.
		<a href="${root}/logout">로그아웃</a><br />
	  </div>
	</div>
</c:if>