<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 도서 관리</title>
</head>
<body>
	<!-- 코드작성 -->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<form method="POST" action="" id="form-book-regist">
		<fieldset>
			<legend>도서 등록</legend>
			<div class="form-group" align="left">
				<label for="book-no">도서번호</label>
				<input type="text" id="book-no" name="isbn"><br>
			</div>
			<label for="book-title">도서명</label>
			<input type="text" id="book-title" name="title"><br>
			<label for="author">저자</label>
			<input type="text" id="author" name="author"><br>
			<label for="price">가격</label>
			<input type="number" id="price" name="price"><br>
			<label for="description">설명</label>
			<input type="text" id="description" name="content"><br>
            <div class="form-group" align="left">
				<label for="upfile">파일</label>
				<input type="file" class="form-control border" name="upfile" multiple="multiple">
			</div>
			<!-- <label for="img">이미지</label> <input type="text" id="img" name="img"><br> -->
			<button type="button" value="등록" id="btn-book-regist">등록</button>
			<button type="reset" value="초기화">초기화</button>
		</fieldset>
	</form>

	<script type="text/javascript">
		document.querySelector("#btn-book-regist").addEventListener("click", function() {
			console.log("book regist btn act");

			let form = document.querySelector("#form-book-regist");
			form.setAttribute("action", "${root}/regist");
			form.submit();

		});
	</script>

</body>
</html>