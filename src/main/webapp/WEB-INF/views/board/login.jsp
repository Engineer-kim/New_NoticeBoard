<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
	<h1>로그인 페이지</h1>
	<hr />
		<c:choose>
			<c:when test="${empty sessionScope.userid}">
			<!-- 로그인이 안되어 있으면 -->
				<form id="loginFrm" name="loginFrm" action="loginCheck" method="post">
					<table>
						<tr>
							<td>아이디</td>
							<td><input type="text" name="userid" id="userid" placeholder="10글자" maxlength="10"></td>
						</tr>
						<tr>
							<td>패스워드</td>
							<td><input type="password" name="passwd" id="passwd" maxlength="20"></td>
						</tr>
						<c:if test="${msg == '실패'}">
							<tr>
								<td colspan=2>
									아이디 또는 패스워드가 틀렸습니다.
								</td>
							</tr>
						</c:if>
						<tr>
							<td colspan=2>
								<input type="button" id="login" value="로그인" />
								<input type="button"  id="cancel" onclick="location.href='/board/listSearch?num=1'" value="취소" />
								<input type="button" id="signUp"   value="회원가입" />
							</td>
						</tr>
					</table>
				</form>
			</c:when>
			<c:otherwise>
				<h3>${sessionScope.userid}님 환영합니다.</h3>
<!-- 				<a href="logout">로그아웃</a> -->
<%-- 				<c:if test="${msg == 'success'}"> --%>
				<a href="/board/listSearch?num=1">게시판 이동</a>
<%-- 				</c:if> --%>
				<a href="seession">회원탈퇴</a>

			</c:otherwise>
		</c:choose>
		<hr />
	
		
</body>
<script type="text/javascript">
	$(document).ready(function(e){
		$('#login').click(function(){

			// 입력 값 체크
			if($.trim($('#userid').val()) == ''){
				alert("아이디를 입력해 주세요.");
				$('#userid').focus();
				return;
			}else if($.trim($('#passwd').val()) == ''){
				alert("패스워드를 입력해 주세요.");
				$('#passwd').focus();
				return;
			}
			
			//전송
			$('#loginFrm').submit();
		});
				
		
		
		//회원가입 버튼
		$('#signUp').click(function() {
// 			console.log('dsadsad');
			location.href="signUpPage";
		});
	});
</script>
</html>




