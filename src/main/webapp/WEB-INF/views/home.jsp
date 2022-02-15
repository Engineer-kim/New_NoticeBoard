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


<h1>
	Home
</h1>
<button><a href="/board/listSearch?num=1">게시판</a></button>

<c:choose>
<c:when test="${empty sessionScope.userid}">
<button id="login"><a href="/board/login">Login</a></button>
<button id="signUp"><a href="/board/signUpPage">SignUp</a></button>
</c:when>
<c:otherwise>
</c:otherwise>	
</c:choose>
</body>
<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(e){
	$('#login').click(function(){

		// 입력 값 체크
		if($('#userid').val() == ''){
			alert("아이디를 입력해 주세요.");
			$('#userid').focus();
			return;
		}else if($('#passwd').val() == ''){    //원래 코드 공백 제거 용 }else if($.trim($('#passwd').val()) == ''){
			alert("패스워드를 입력해 주세요.");
			$('#passwd').focus();
			return;
		}
		
		//전송
		$('#loginFrm').submit();
	});
			
	
	 /*로그인 페이지로 이동 jquery*/
	$(document).ready(function(e){
		
		$('#login').click(function() {
			location.href="/board/login";
		});
	});
 
	
	
	
	
	//회원가입 버튼
	$('#signUp').click(function() {
		
		location.href="signUpPage";
	});
});
</script>
</html>
