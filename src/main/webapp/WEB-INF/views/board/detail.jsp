<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	a { text-decoration: none; color: black; }
</style>
<body>
<%-- 	<h3>${sessionScope.userid}님 상세정보</h3> --%>


<c:choose>
<c:when test="${not empty sessionScope.userid}">
<form name=detail method="GET">
<table  style="padding-top:50px" align = center width=700 border=0 cellpadding=2 >
  <tr>
 <td height=20 align= center bgcolor=#ccc><font color=white> ${sessionScope.userid}회원님 상세정보 화면</font></td>
                </tr>
                <tr>
                <td bgcolor=white>
                <table class = "table2">
<%--                  <c:forEach var="member" items="${member}"> --%>
                        <tr>
                        <td>아이디 :</td>
                        <td><input type = text name =userid size=10 value="${sessionScope.userid}" disabled></td>
						 </tr>
                        <tr>
                        <td> 비밀번호</td>
                        <td><input type = password name = "passwd" size=30 value="${member.passwd}" disabled></td>
                        </tr>
<!--                          <tr> -->
<!--                         <td>비밀번호 중복검사</td> -->
<%--                         <td><input type = password name = "passwdCheck" size=30 value="${member.passwd}" disabled></td> --%>
<!--                         </tr> -->
                        <tr>
                        <td>회원 이름 :</td>
                         <td><input type = text name= name size=30 value="${member.name}" disabled></td>
                        </tr>
                        <tr>
                        <td>이메일 :</td>
                        <td><input type = text name =email size=30 value="${member.email}" disabled></td>
                        </tr><tr>
                        <td>휴대폰 :</td>
                        <td><input type = text name =number size=30 value="${member.number}"  disabled ></td>
                        </tr>
                         <td>가입(최근수정)일시</td>
                        <td>${member.updateDt}</td>
                        </tr>
                        </table>
                        <center>
<!--                         	<button id="회원정보 수정"><a href="modify"></a></button> -->
							<button id="home"><a href="/board/listSearch?num=1">게시판으로</a></button>
                        	<button id ="탈퇴"><a href="seession">회원탈퇴</a></button>
                        	<button id ="update"><a href="update">회원정보수정</a></button>
                        </center>
                </td>
                </tr>
<%--                 </c:forEach> --%>
        </table> 
</form>  

</c:when>
</c:choose>
<!-- 로그 찍어보았지만 왜 sessionScope.,userid는 맞는데 다름 파라미터들은 못읽어올까?? ==> 이슈   ==> 해결 바보같이 session 관련해서 안넘겨줌 (2022-02-10) -->




</body>
</html>

