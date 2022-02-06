<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<style>
/*a 태그 밑줄 , 색깔 없애기*/
a { text-decoration: none; color: black; }

.list_table { width: 100%; }
.boardcss_list_table { width: 100%; }
</style>
<body>

	<form method="post">
        <table  style="padding-top:50px" align = center width=700 border=0 cellpadding=2 >
                <tr>
                <td height=20 align= center bgcolor=#ccc><font color=white>상세화면</font></td>
                </tr>
                <tr>
                <td bgcolor=white>
                <table class = "table2">
                        <tr>
                        <td>작성자</td>
                        <td><input type = text name = writer size=20 value="${view.writer}" disabled></td>
                        </tr>
                        <tr>
                        <td>작성일</td>
                        <td><input type = text name = regDt size=30 value="${view.regDt}" disabled></td>
                        </tr>
                        <tr>
                        <td>게시글 번호</td>
                         <td><input type = text  disabled value="${view.idx}" ></td>
                        </tr>
                        <tr>
                        <td>제목</td>
                        <td><input type = text name = title size=60 value="${view.title}" disabled></td>
                        </tr>
 
                        <tr>
                        <td>내용</td>
                        <td><textarea name = content cols=85 rows=15 disabled>${view.content}</textarea></td>
                        </tr>
                        </table>
                        <center>
                 				<button><a href="/board/listSearch?num=1">메인으로 돌아가기</a></button>
                 				<button><a href="/board/modify?idx=${view.idx}">수정</a></button>            				
                 				 
                        </center>
                </td>
                </tr>
        </table>  
        </form>
        			<hr />		
								<!-- 댓글 부분 -->
<!-- 								<form method="GET"  action="/reply/delete"> -->
								<center>
										<label>댓글 목록</label>
										<table class="list_table">
										<colgroup>
												<col width="20%" />
												<col width="20%" />
												<col width="20%" />
												<col width="20%" />
										</colgroup>
										<thead>
											<tr>
												<th>댓글번호</th>
												<th>댓글작성자</th>
												<th>댓글내용</th>
												<th>댓글관리</th>
											</tr>							
										</thead>
									<tbody>
									<c:forEach items="${reply}" var="reply">
										<tr>
											<th style="font-weight:100;">${reply.replyIdx}</th>
											<th style="font-weight:100;">${reply.writer}</th>	
<%-- 											<c:choose> --%>
<%-- 											<c:when test="${empty sessionScope.userid}"> --%>
<%-- 											<th style="font-weight:100;">${reply.writer}</th>											 --%>
<%-- 											</c:when> --%>
<%-- 											<c:otherwise> --%>
<%-- 											<th style="font-weight:100;">${sessionScope.userid}</th> --%>
<%-- 											</c:otherwise>	 --%>
<%-- 											</c:choose> --%>
											<th style="font-weight:100;">${reply.content}</th>
<%-- 										<th><button id="deleteComment"><a href="/reply/delete?replyIdx=${reply.replyIdx}?idx=${reply.idx}">댓글 삭제</a></button></th> --%>
											<th><button id="CommentDel"><input type="hidden" name="idx" value="${view.idx}"><a href="/reply/delete?replyIdx=${reply.replyIdx}">댓글 삭제</a></button></th>
<%-- 											<th><button><a href="/reply/replyModify?replyIdx=${reply.replyIdx}">수정</a></button></th> --%>
										</tr>	
									</c:forEach>
									
									</tbody>
									</table>	
<!-- 									</form>		 -->
								<div>

								<form method="POST" action="/reply/write">
									<p>
									<label>댓글 작성자</label> <input type="text" name="writer">
<%-- 										<c:choose> --%>
<%-- 										<c:when test="${empty sessionScope.userid}">										 --%>
<!-- 										<label>댓글 작성자</label> <input id="writer" type="text" name="writer" disabled> -->
<%-- 										</c:when> --%>
<%-- 										<c:otherwise> --%>
<%-- 											<label>댓글 작성자</label><input type="text" ${sessionScope.userid}  disabled> --%>
<%-- 											</c:otherwise>	 --%>
<%-- 											</c:choose> --%>
									</p>
									<p>
										<textarea rows="5" cols="50" name="content"></textarea>
									</p>
									<p>
										<input type="hidden" name="idx" value="${view.idx}">
										<button type="submit">댓글 작성</button>
									</p>
								</form>
								</div>
								
								
								

	
</center>
<script type="text/javascript">
// 			$(document).ready(funtion(){
// 				$("#CommentDel").click(function(){
// 					$(location).attr('href','listSearch?num=1')
// 			});
// // 		});	
 	$(function(){
 		if($('#sessionScope.userid').val() == ''){
 		     $('#writer').removeAttr("readonly");
 		}
 		else{
 			$('#loginWriter').removeAttr("readonly");
 		}
});
 




</script>
</body>
</html>