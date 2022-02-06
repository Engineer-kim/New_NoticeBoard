<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<form id="signFrm" name="signFrm" action="signUp">
		<table>
			<tbody>
				<tr>
					<td>아이디</td>
					<td><input type="text" id="userid" name="userid" ></td>
					<td><input type="button" id="check" value="중복체크"></td>
				</tr>
				<tr>
					<td colspan=3 id="idCheck"></td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td colspan="2"><input id="passwd" name="passwd" type="password"></td>
				</tr>
				<tr>
					<td>패스워드 확인</td>
					<td colspan="2"><input id="passwdCheck" name="passwdCheck" type="password"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td colspan="2"><input id="name" name="name"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td colspan="2"><input id="address" name="address"></td>
				</tr>
				<tr>
					<td colspan="3"><input type="button" id="signUp" value="회원가입"></td>
				</tr>
				<tr>
					  <td colspan="3"><button type="button" onclick="resetForm();">reset</button></td>
				</tr>
				<tr>
					<td><input type="button"  id="cancel" onclick="location.href='/board/listSearch?num=1'" value="취소" /></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>

<script type="text/javascript">
	$(document).ready(function(e){
		
		var idx = false;
		$('#signUp').click(function(){
			//이름은 필수값으로 분류
			if($.trim($('#name').val()) == ''){
				alert("이름 입력 하셈");
				$('#name').focus();
				return;
			}
			
			if($.trim($('#userid').val()) == ''){
				alert("아이디 입력 하셈");
				$('#userid').focus();
				return;
			}else if($.trim($('#passwd').val()) == ''){
				alert("패스워드 입력.");
				$('#passwd').focus();
				return;
			}
			
			//패스워드 확인
			else if($('#passwd').val() != $('#passwdCheck').val()){
				alert('패스워드가 다릅니다 , 똑같이 똑바로 입력하셈.');
				$('#passwd').focus();
				return;
			}
			
			if(idx==false){
				alert("아이디 중복체크를 해야됨.");
				return;
			}else{
				$('#signFrm').submit();
			}
		});
		
		$('#check').click(function(){
			$.ajax({
				url: "idCheck",
				type: "GET",
				data:{
					"userid":$('#userid').val()
				},
				success: function(data){
					
					if(data == 0 && $.trim($('#userid').val()) != '' ){
						idx=true;
						$('#userid').attr("readonly",true);    //아이디 중복체크시 사용가능 아이디 중복되지않는 사용가능 아이디일경우 수정불가
						$("#check").attr("disabled" ,true);  // 중복 체크를 돌아 중복되지않는 아이디면비활됨
						var html="<tr><td colspan='3' style='color: green'>사용가능할지도!</td></tr>";
						$('#idCheck').empty();
						$('#idCheck').append(html);
						
						
					}else{
						$("#check").attr("disabled" ,false);
						var html="<tr><td colspan='3' style='color: red'>공백 또는 중복되어 사용불가능한 아이디 입니다.</td></tr>";
						$('#idCheck').empty();
						$('#idCheck').append(html);

					}
				},
				error: function(){
					alert("jquery오류나서  병신됨");
				}
			});
			

		});
		
		
	});
	/*reset button*/
	
	function resetForm() {
// 		$('#userid').attr("readonly",false); // reset 클릭시 다시 수정가능   참고 사이트 :https://www.tutorialrepublic.com/faq/how-to-reset-a-form-using-jquery.php
// 		$("#check").attr("disabled" ,false);  //rest 클릭시 다시 중복 체크 버튼 활성화, 
		alert('입력한 정보는 모두 초기화됩니다');
// 		document.getElementById("signFrm").reset();
		 window.location.reload();
	}
	/*reset button finish*/


	
	
</script>
</html>