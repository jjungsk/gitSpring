<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록 결과</title>
</head>
<body>
	<!-- 코드작성 -->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
  	<h1>도서 등록 결과</h1>
	<h2>등록 도서 정보</h2>
	<table>
		<thead>
			<tr>
				<th>항목</th>
				<th>내용</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>도서번호</td>
				<td>${bookinfo.isbn}</td>
			</tr>
			<tr>
				<td>도서명</td>
				<td>${bookinfo.title}</td>
			</tr>
			<tr>
				<td>저자</td>
				<td>${bookinfo.author}</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>${bookinfo.price}</td>
			</tr>
			<tr>
				<td>설명</td>
				<td>${bookinfo.content}</td>
			</tr>
			<tr>
				<td>이미지</td>
				<td>${bookinfo.fileInfos[0]}</td>
				<td>"${root}/upload/${bookinfo.fileInfos[0].saveFolder}/${bookinfo.fileInfos[0].saveFile}"</td>
				<td><img src="${root}/upload/${bookinfo.fileInfos[0].saveFolder}/${bookinfo.fileInfos[0].saveFile}" /></td>
			</tr>
		</tbody>
	</table>
	<a href="${root}/regist">추가등록</a>
	<a href="${root}/list">도서 목록</a>
	
</body>
</html>