<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
</head>
<style>
/*a 태그 밑줄 , 색깔 없애기*/
a { text-decoration: none; color: black; }

</style>
<body>

	<form method="post">
        <table  style="padding-top:50px" align = center width=700 border=0 cellpadding=2 >
                <tr>
                <td height=20 align= center bgcolor=#ccc><font color=white>수정창</font></td>
                </tr>
                <tr>
                <td bgcolor=white>
                <table class = "table2">
                        <tr>
                       <td>작성자</td>
                        <td><input type = text name = writer size=20 value="${view.writer}"></td>
                        </tr>
                        <tr>
                        <td>게시글 번호</td>
                         <td><input type = text  disabled value="${view.idx}"></td>
                        </tr>
                        <tr>
                        <td>제목</td>
                        <td><input type = text name = title size=60 value="${view.title}"></td>
                        </tr>
 
                        <tr>
                        <td>내용</td>
                        <td><textarea name = content cols=85 rows=15 >${view.content}</textarea></td>
                        </tr>
 
<!--                         <tr> -->
<!--                         <td>비밀번호</td> -->
<!--                         <td><input type = password name = pw size=10 maxlength=10></td> -->
<!--                         </tr> -->
                        </table>
                        <center>
                 			<div id="modify"><button type="submit">수정완료하기</button></div>
                        </center>
                </td>
                </tr>
        </table>
        </form>



</body>
</html>