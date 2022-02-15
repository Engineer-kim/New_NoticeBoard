<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
/*a 태그 밑줄 , 색깔 없애기*/
a { text-decoration: none; color: black; }
</style>

<script type="text/javascript">
	var msg = "${msg}";
		 
		if (msg != "") {
			alert(msg);
		}
</script>


   <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-2">아이디 찾기</h1>
                                        <p class="mb-4">이메일을 입력해주세요</p>
                                    </div>
                                    <form class="user" action="/board/findId" method="POST">
                                        <div class="form-group">
                                            <input type="email" class="form-control form-control-user"
                                                id="email" aria-describedby="emailHelp" name="email"
                                                placeholder="가입한 이메일 써라">
                                        </div>
                                        <button type="submit" class="btn btn-primary btn-user btn-block">
                                            Find ID
                                        </button>
                                    </form>
                                    <hr>
                                  
                                    <a href="/board/login" class="btn btn-facebook btn-user btn-block">
                                           Login
                                        </a>
                                        <tr> | </tr>
                                        <a href="/board/listSearch?num=1">mainPage</a> 
                                        <hr>
                                       <div class="text-center">
                                    </div>