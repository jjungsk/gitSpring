<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="/WEB-INF/views/common/headerNoLogin.jsp"%>
<c:if test="${empty userinfo}">
  <script type="text/javascript">
    alert("로그인 후 이용 가능한 페이지입니다.");
    location.href = "${root}/index";
  </script>
</c:if>
