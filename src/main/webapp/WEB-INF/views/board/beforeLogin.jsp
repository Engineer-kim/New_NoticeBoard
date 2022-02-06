<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
	<title>Home</title>
</head>
<style>
a { text-decoration: none; color: black; }
</style>
<body>
 <div class="alert alert-success">
        회원가입 됬음!
</div>
<p><a href="/board/listSearch?num=1">게시판</a></p>


<button id="login"><a href="/board/login">Login</a></button>
<button id="signUp"><a href="/board/signUpPage">SignUp</a></button>

</body>

</html>
