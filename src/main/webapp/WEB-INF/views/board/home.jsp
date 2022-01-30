<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${msg == 'success'}">
	<h2>${sessionScope.name}(${sessionScope.userid})님 환영합니다</h2>
	</c:if>
	
</body>
</html>