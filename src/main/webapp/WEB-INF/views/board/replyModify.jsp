<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 댓글 수정</title>
</head>
<style>
/*a 태그 밑줄 , 색깔 없애기*/
a { text-decoration: none; color: black; }

</style>
<body>

	<form method="post">
        <table  style="padding-top:50px" align = center width=700 border=0 cellpadding=2 >
                <tr>
                <td height=20 align= center bgcolor=#ccc><font color=white>댓글 상세화면</font></td>
                </tr>
                <tr>
                <td bgcolor=white>
                <table class = "table2">
                        <tr>
                        <td>댓글 작성자</td>
                        <td><input type = text name = writer size=20 value="${reply.writer}" disabled></td>
                        </tr>
                        <tr>
                        <td>댓글 번호</td>
                         <td><input type = text  disabled value="${reply.replyIdx}" ></td>
                        </tr>
                        <tr>
                        <td>댓글 내용</td>
                        <td><textarea name = content cols=85 rows=15 disabled>${reply.content}</textarea></td>
                        </tr>
                        </table>
                        <center>
                 				<button><a href="/board/view?idx=${view.idx}">이전 게시글로 돌아가기</a></button>
                 				<button><a href="/reply/modify?replyIdx=${reply.replyIdx}">댓글 수정</a></button>            				
                 				 
                        </center>
                </td>
                </tr>
        </table>  
        </form>


</body>
</html>