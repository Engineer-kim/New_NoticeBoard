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
                                        <h1>비밀번호 찾기</h1>
                                        <p >아이디와 이메일을 입력해주세요!</p>
                                    </div>
                                    <form class="user" action="/board/findPw" method="post">
                                       <div>
                                            <input type="text" class="form-control form-control-user"
                                                id="userid" aria-describedby="IdHelp" name="userid"
                                                placeholder="가입한 아이디 써라">
                                        </div>
                                        <div>
                                            <input type="email" class="form-control form-control-user"
                                                id="email" aria-describedby="emailHelp" name="email"
                                                placeholder="가입한 이메일 써라">
                                        </div>
                                         
                                        <button type="submit" id="email">
                                            Find PW
                                        </button>
                                    </form>
                                    <hr>
                                     <a href="/board/login">
                                           Login
                                        </a>
                                        <tr> | </tr>
                                        <a  href="/board/listSearch?num=1">MAIN</a>
                                        <hr>
                                       <div class="text-center">
                                        
                                    </div>