<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
form>label, form>select, form>input {
	margin-right: 10px !important;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<div class="container">
		<h1>도서 목록</h1>

		<form class="d-flex" method="get" action="${root }/list" id="searchForm" class="row">
	        <input type="hidden" name="pgno" value="1"/>
	          <select
	            class="form-select form-select-sm ms-5 me-1 w-50"
	            name="key"
	            aria-label="검색조건" >
	            	<option value="" selected>검색조건</option>
	            	<option value="isbn">isbn</option>
	            	<option value="title">title</option>
	            	<option value="author">author</option>
	          </select>
     	      <select
	            class="form-select form-select-sm ms-5 me-1 w-50"
	            name="orderBy"
	            aria-label="정렬조건" >
	            	<option value="" selected>정렬조건</option>
	            	<option value="asc">오름차순</option>
	            	<option value="desc">내림차순</option>
	          </select>
	          <div class="input-group input-group-sm">
	            <input type="text" class="form-control" name="word" placeholder="검색어" />
	            <button id="btn-search" class="btn btn-dark" type="submit" form="searchForm">검색</button>
	          </div>
		</form>
		<br>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>번호</th>
					<th>ISBN</th>
					<th>제목</th>
					<th>저자</th>
					<th>가격</th>
				</tr>
			</thead>
			<tbody>
				<%-- request 영역에 books로 등록된 자료를 반복문을 이용해 출력한다. --%>
				<c:forEach items="${books }" var="book" varStatus="vs">
					<tr>
						<td>${vs.count }</td>
						<td>${book.isbn }</td>
						<td>${book.title }</td>
						<td>${book.author }</td>
						<td>${book.price }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<a href="${root }/regist">도서 등록</a>
	</div>
</body>
</html>