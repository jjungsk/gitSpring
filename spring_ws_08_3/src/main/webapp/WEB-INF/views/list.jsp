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

		<form class="d-flex" method="get" action="" id="searchForm" class="row">
	        <input type="hidden" name="pgno" value="1"/>
	          <select
			  	id="search-condition"
	            class="form-select form-select-sm ms-5 me-1 w-50"
	            name="key"
	            aria-label="검색조건" >
	            	<option value="" selected>검색조건</option>
	            	<option value="isbn">isbn</option>
	            	<option value="title">title</option>
	            	<option value="author">author</option>
	          </select>
			  <div class="input-group input-group-sm">
				<input id="search-word" type="text" class="form-control" name="word" placeholder="검색어" />
				<button id="btn-search" class="btn btn-dark" type="button" form="searchForm">검색</button>
			  </div>
     	      <select class="form-select form-select-sm ms-5 me-1 w-50"
			  	id="order-by"
			  	onchange="orderFn()"
	            name="orderBy"
	            aria-label="정렬조건" >
	            	<option value="" selected>정렬조건</option>
	            	<option value="asc">오름차순</option>
	            	<option value="desc">내림차순</option>
	          </select>
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
	
	
	<script>
		// search condtion
		document.querySelector("#btn-search").addEventListener("click", function(){
			let form = document.querySelector("#searchForm");
			
			var search = form.querySelector("#search-condition");
			var searchCon = search.options[search.selectedIndex].value;

			var searchWord = form.querySelector("#search-word").value;
			
			fetch("${root}/bookapi/book/${searchWord}", options)
			  .then((response) => response.json())
			  .then((data) => console.log(data))

			var options = {
				method: "GET",
				headers: {"Content-Type": "application/json"},
				body: JSON.stringify(data)
			}
		});

		// 정렬 Ajax
		function orderFn() {
			var search = document.querySelector("#search-condition");
			var searchCon = search.options[search.selectedIndex].value;
			

			var searchWord = document.querySelector("#search-word").value;
			
			var searchWord = document.querySelector("#search-word").innerHtml;
			

			var order = document.querySelector("#order-by");
			var orderDir = order.options[order.selectedIndex].value;
			console.log(orderDir);



		}
	</script>
</body>
</html>