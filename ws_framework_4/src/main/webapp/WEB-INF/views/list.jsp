<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 코드작성 -->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
    <table class="table table-hover">
      <thead>
        <tr class="text-center">
          <th scope="col">번호</th>
          <th scope="col">ISBN</th>
          <th scope="col">제목</th>
          <th scope="col">저자</th>
          <th scope="col">가격</th>
        </tr>
      </thead>
      <tbody>
		<c:forEach var="article" items="${articles}" >
        <tr class="text-center">
          <th scope="row"> 0 </th>
          <td class="text-start">
            <a
              href="#"
              class="article-title link-dark"
              data-no=""
              style="text-decoration: none"
            >
              	${article.isbn}
            </a>
          </td>
          <td>${article.title}</td>
          <td>${article.author}</td>
          <td>${article.price}</td>
        </tr>
		</c:forEach>
      </tbody>
    </table>
 	<ul>
	  <li><a href="${root }/regist">도서 등록</a></li>
  	</ul>
</body>
</html>