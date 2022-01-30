<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<a href="/board/list?num=1">게시판</a>
	<c:choose>
			<c:when test="${sessionScope.userId == null}">
				<a href="/board/login">로그인</a>
				
			</c:when>
			<c:otherwise>
					${sessionScope.userName}님 로그인중
					<a href="/board/logout">로그아웃</a>
			</c:otherwise>
	</c:choose>
</html>
<hr>