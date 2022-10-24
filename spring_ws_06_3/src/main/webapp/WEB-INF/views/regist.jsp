<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 도서 관리</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<div class="container">
		<h1>도서 등록</h1>
	<!-- file upload를 위해 multipart/form-data를 추가한다. -->
	<form method="post" action="regist" enctype="multipart/form-data">
			<!-- front-controller pattern에서 요청을 구분하기 위한 parameter -->
			<div class="input-group mb-3">
				<span class="input-group-text">도서번호</span>
				<input type="text" id="isbn" name="isbn" class="form-control">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">도서명</span>
				<input type="text" id="title" name="title" class="form-control">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">저자</span>
				<input type="text" id="author" name="author" class="form-control">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">가격</span>
				<input type="number" id="price" name="price" class="form-control">
			</div>
			<div class="mb-3">
				<label for="file" class="form-label">이미지</label>
				<input type="file" id="file" name="file" class="form-control" accept="image/*" >
			</div>
			<div class="mb-3">
				<label for="content" class="form-label">설명</label>
				<textarea id="content" name="content" class="form-control" rows="3"></textarea>
			</div>
			<div>
				<input type="submit" value="등록">
				<input type="reset" value="취소">
			</div>
		</form>
		<br> <a href="${root }/list">도서 목록</a>
	</div>
</body>
</html>