<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
	
</head>
<style>
/*a 태그 밑줄 , 색깔 없애기*/
a { text-decoration: none; color: black; }
</style>
<body>

	<form method="post" id="writeForm" enctype="multipart/form-data">
        <table  style="padding-top:50px" align = center width=700 border=0 cellpadding=2 >
                <tr>
                <td height=20 align= center bgcolor=#ccc><font color=white> 글쓰기</font></td>
                </tr>
                <tr>
                <td bgcolor=white>
                <table class = "table2">
                        <tr>
                        <td>작성자</td>
                        <td><input type = text name = writer size=20  minlength="3" required></td>
                        </tr>
                        <tr>
                        <td>제목</td>
                        <td><input type = text name = title size=60  required></td>
                        </tr>
                        <tr>
                        <td>내용</td>
                        <td><textarea name = content cols=85 rows=15  required style="height: 361px; width: 432px;"></textarea></td>
                        </tr>
                        <!--  파일 업로드 관련 부분 시작 -->
<!--                         <tr> -->
<!-- 						<td  width="70">업로드</td><td align="left"> -->
<!-- 						<input type="file" name="uploadFile"/></td> -->
<!-- 					   </tr> -->
					    <!--  파일 업로드 관련 부분 끝 -->
                        </table>
                        <center>
                 		<button type="submit">작성</button>
                 			<button><a href="/board/listSearch?num=1">취소</a></button>
                        </center>
                </td>
                </tr>
        </table>
        </form>



</body>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
 <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script type="text/javascript">
		$(function() { 
			$("#writeForm").validate(); 
			
			});
</script>
</html>