  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  
  
 
            
  <h2> 아이디는 : </h2><br/>
  		<ul>
  		<c:forEach items="${member}" var="member">
  		  	
  		  	<li>${member.userid} </li><br/>
  		
  		</c:forEach>
  		</ul>
  	<h2>입니다</h2>
  <button type="button"  onclick="location.href='/board/login'">로그인페이지</button>
  <button type="button"  onclick="location.href='/board/listSearch?num=1'">메인페이지</button>
  
  
</div>