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
<style>
/*a 태그 밑줄 , 색깔 없애기*/
a { text-decoration: none; color: black; }
</style>
<body>
	<h1>로그인 페이지</h1>
	<hr />
		<c:choose>
			<c:when test="${empty sessionScope.userid}">
			
			<!-- 로그인이 안되어 있으면 -->
			<center>
				<form id="loginFrm" name="loginFrm" action="loginCheck" method="post">
					<table>
						<tr>
							<td>아이디</td>
							<td><input type="text" name="userid" id="userid" placeholder="아이디" maxlength="19"></td>
						</tr>
						<tr>
							<td>패스워드</td>
							<td><input type="password" name="passwd" id="passwd" maxlength="19"  placeholder="비밀번호"></td>
						</tr>
						<c:if test="${msg == '실패'}">
							<tr>
								<td colspan=2>
									아이디 또는 패스워드가 틀렸습니다.
								</td>
							</tr>
						</c:if>
						<tr>
							<td colspan=4>
							<center>
								<input type="button" id="login" value="로그인" />
								<input type="button"  id="cancel" onclick="location.href='/board/listSearch?num=1'" value="취소" />
								<input type="button" id="signUp"   value="회원가입" />
								</center>
								
							</td>
						</tr>
						
					</table>
					
						<center>
							<br>
							<a href="findIdView">아이디 찿기</a>
							<tr>  |  </tr>
							<a href="findPwView">비밀번호 찿기</a>

							
						</center>
				</form>
											<br>
<br>
<!-- 네이버 로그인 창으로 이동 -->
<div id="naver_id_login" style="text-align:center"><a href="${url}">
<img width="223" src="https://developers.naver.com/doc/review_201802/CK_bEFnWMeEBjXpQ5o8N_20180202_7aot50.png"/></a></div>
<br>
<!-- <ul> -->
<!--       <li onclick="kakaoLogin();"> -->
<!--         <a href="javascript:void(0)"> -->
<!--             <span>카카오 로그인</span> -->
<!--         </a> -->
<!--       </li> -->
<!--   </ul> -->
				</center>
			</c:when>
			<c:otherwise>
				<h3>${sessionScope.userid}님 환영합니다.</h3>
				
<!-- 				<a href="logout">로그아웃</a> -->
<%-- 				<c:if test="${msg == 'success'}"> --%>
				<a href="/board/listSearch?num=1">게시판</a>
<%-- 				</c:if> --%>
<!-- 				<a href="seession">회원탈퇴</a> -->

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
 <script src="https://developers.kakao.com/sdk/js/kakao.js">
//카카오로그인
//  function kakaoLogin() {

//    $.ajax({
//        url: '/login/getKakaoAuthUrl',
//        type: 'get',
//        async: false,
//        dataType: 'text',
//        success: function (res) {
//            location.href = res;
//        }
//    });

//  }

//  $(document).ready(function() {

//      var kakaoInfo = '${kakaoInfo}';

//      if(kakaoInfo != ""){
//          var data = JSON.parse(kakaoInfo);

//          alert("카카오로그인 성공 \n accessToken : " + data['accessToken']);
//          alert(
//          "user : \n" + "email : "
//          + data['email']  
//          + "\n nickname : " 
//          + data['nickname']);
//      }
//  });  

 </script>
</html>




