<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
{
"members" : [
			<c:forEach varStatus="i" var="member" items="${memberlist}">
				{
				"userid" : "${member.userId}",
				"username" : "${member.userName}",
				"email" : "${member.emailId}@${member.emailDomain}",
				"joindate" : "${member.joinDate}"
				}
				<c:if test="${i.index != memberlist.size() - 1}">,</c:if>
			</c:forEach>
			]
}