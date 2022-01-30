<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reply</title>
</head>
<body>
	<!-- 댓글 부분 -->
								<center>
									
									<c:forEach items="${reply}" var="reply">
										<li>
											<div>
												<p>${reply.writer}</p>
												<p>${reply.content}</p>
											</div>
										</li>	
									</c:forEach>
									
								<div>

								<form method="POST" action="/reply/write">
									<p>
										<label>댓글 작성자</label> <input type="text" name="writer">
									</p>
									<p>
										<textarea rows="5" cols="50" name="content"></textarea>
									</p>
									<p>
										<button type="submit">댓글 작성</button>
									</p>
								</form>
	
								</div>
	
</center>
</body>
</html>