 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
/*a 태그 밑줄 , 색깔 없애기*/
a { text-decoration: none; color: black; }
</style>
 
 <div>            
   <div class="jumbotron">
  <h2> 임시 비밀번호가 전송되었습니다. </h2><br/>
  		
  	<h1>${member}</h1><br/>
  	<h2>를 확인해주세요.</h2>
  <button type="button" onclick="location.href='/board/login'">로그인페이지</button>
  <button type="button" onclick="location.href='/board/listSearch?num=1'">메인페이지</button> 
</div>