<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

</head>
<!-- textArea 모서리 크기조절 없애기 css -->
<style>
 textarea {
    width: 100%;
    height: 6.25em;
    border: none;
    resize: none;
  }
</style>
<body>
	<h1>회원가입</h1>
	<hr>
	<form id="signFrm" name="signFrm" action="signUp">
		<table>
			<tbody>
				<tr>
					<td>아이디</td>
					<td><input type="text" id="userid" name="userid" placeholder="영문으로입력특수문자 안됨 maxlength="19"></td>
					<td><input type="button" id="check" value="중복체크"></td>
<!-- 					<td><input type="button" id="resetId" value="resetId" onclick="ResetId();"></td> -->
				</tr>
				<tr>
					<td colspan=3 id="idCheck"></td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td colspan="2"><input type="password" class="form-control" id="passwd" name="passwd" placeholder="패스워드 입력"></td>
				</tr>
				<tr>
					<td>패스워드 확인</td>
					<td colspan="2"><input type="password" class="form-control" id="passwdCheck" name="passwdCheck" placeholder="Confirm Password"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td colspan="2"><input type="text" class="form-control" id="name" name="name" placeholder="이름 입력">
					<div class="eheck_font" id="name_check"></div></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td colspan="2"><input type="email" class="form-control" id="email" name="email" placeholder="example@example.com"></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td colspan="2"><input  class="form-control" id="number" name="number" placeholder="하이픈(-)제외 입력" maxlength="13"></td>
				</tr>
				<tr>
					<td>
					<fieldset>
						<legend><span>이용</span>약관</legend>
						<p class="agreeText">
							<label for="agreement1">아래 사항에 동의 합니다.</label>
							<input id="agreement1" type="checkbox" name="agreement1"/>
							<textarea id="text1" readonly>
								이용약관
								어쩌구 
								저쩌구
							</textarea>
						</p>
					</fieldset>
					<fieldset>
						<legend><span>개인정보</span>취급방침</legend>
						<p class="agreeText">
							<label for="agreement2">아래 사항에 동의 합니다.</label>
							<input id="agreement2" type="checkbox" name="agreement2"/>
							<textarea id="text2" readonly>
								개인정보 방침 및 안내
								어쩌구 저쩌구
							</textarea>
						</p>
					</fieldset>
					</td>
				</tr>
				<tr>
					<td colspan="3"><input type="button" id="signUp" value="회원가입"></td>
				</tr>
				<tr>
					  <td colspan="3"><button type="button" onclick="resetForm();">AllReset</button></td>
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
		
		/*전화 번화관련 validation 에  필요한변수 선언부*/
		var phone = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;

		//아이디 정규식 (영문으로 만 입력 되게끔)
		var idV = /^[a-z0-9][a-z0-9_\-]{3,19}$/;  //3~19 조절하면 아이디 타이핑갯수조절 가능
		
		// 이메일 검사 정규식 
		var mail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

		// 비밀번호 정규식
		 var pw = /^[A-Za-z0-9]{4,12}$/;  // 자릿수 validation 은 안돈다 공백 체크와 아무값도 안들어오면 은 체크 가능
		// 이름 정규식 
		var nameV = /^[가-힣]{2,4}|[a-zA-Z]{2,10}\s[a-zA-Z]{2,10}$/;
		
		 var code = "";
		
		var idx = false;
		$('#signUp').click(function(){
			
			var invaild = new Array(8).fill(false);

		
			if($.trim($('#userid').val()) == ''){
				alert("아이디 입력 하셈");
				$('#userid').focus();
				return;
			}else if(pw.test($('#passwd').val()) == false && $.trim($('#passwd').val()) == ''){
				alert("비밀 번호 공백없이 입력 해주세요");
				$('#passwd').focus();
				return;
			}
			
			//패스워드 확인
			else if($('#passwd').val() != $('#passwdCheck').val()){
				alert('패스워드가 다릅니다 , 똑같이 똑바로 입력하셈.');
				$('#passwd').focus();
				return clear();
			}
			//이름은 필수값으로 분류
			if (nameV.test($('#name').val())) {
				invaild[2] = true;
				}
			else { 
				invaild[2] = false; 
				alert('니 이름 재대로 입력하세요'); 
				return clear(); 
			}

			//이메일은 추후 회원정보 찿기 관련해서 필요하므로 필수 값으로 처리
			if (mail.test($('#email').val())){
// 				console.log(phoneJ.test($('#mem_email').val())); 
				invaild[4] = true; 
				}
			else { invaild[4] = false; 
			alert('이메일을 알맞은 형식으로 입력하세요.'); 
			return clear(); 
			}	
			
			
			/*동의여부도 필수값으로 validation check*/
			if(signFrm.agreement1.checked != true){
				alert("이용약관 동의해."); 
				frm.confirm.focus(); 
				return false;
			}
			if(signFrm.agreement2.checked != true){
				alert("개인정보취급방침 동의해."); 
				frm.confirm.focus(); 
				return false;
			}
			/*동의여부도 필수값으로 valiation check end*/
			
			
			
	/*얀락처도 필수값 나중에 추가될기능에 필요할수도 있음 필요없으시 이부분 주석처리*/
			if (phone.test($('#number').val())) {
			//	console.log(phone.test($('#number').val())); 
				invaild[5] = true; 
				} 
			else { invaild[5] = false; 
			alert('휴대폰 번호 입력 똑바로 해라.'); 
			return clear(); 
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
					
					if( idV.test($('#userid').val())==true && data == 0 && $.trim($('#userid').val()) != '' ){
						idx=true;
						$('#userid').attr("readonly",true);    //아이디 중복체크시 사용가능 아이디 중복되지않는 사용가능 아이디일경우 수정불가
						$("#check").attr("disabled" ,true);  // 중복 체크를 돌아 중복되지않는 아이디면비활됨
						var html="<tr><td colspan='3' style='color: green'>사용가능할지도!</td></tr>";
						$('#idCheck').empty();
						$('#idCheck').append(html);
						
						
					}else{
						$("#check").attr("disabled" ,false);
						var html="<tr><td colspan='3' style='color: red'>공백 , 한글 또는 중복되어 사용불가능한 아이디 입니다.</td></tr>";
						$('#idCheck').empty();
						$('#idCheck').append(html);

					}
				},
				error: function(){
					alert("jquery오류나서  병신됨, jquery 쫌 재대로 짜라!");
				}
			});
			

		});
		
		
	});
	/*signFrm validation 및 , 기본적인 폼 형태 finish 지점*/	
	
	
	
	/*이름 입력 받는곳에 특수문자 불가 처리*/
	$("#name").blur(function() { 
		var nameV = /^[가-힣]{2,4}|[a-zA-Z]{2,10}\s[a-zA-Z]{2,10}$/;
		if (nameV.test($(this).val())){ 
			//console.log(nameV.test($(this).val()));
		 $("#name_check").text('');
		 } 
		else { $('#name_check').text('한글 2~4자 이내로 입력하세요. (특수기호, 공백 사용 되겠냐? 안되지)');
		$('#name_check').css('color', 'red');
		 } 
		});

	/*이름 입력 받는곳에 특수문자 불가 처리 end*/
	
	
	/*동의 여부 확인 */
	$("input:checkbox").click(checkedChange);
   function checkedChange() {
       if($(this).prop("checked")){
           $("label[for="+this.id+"]").text("동의되었습니다.");
           $("label[for="+this.id+"]").css("color","green");
       }else{
           $("label[for="+this.id+"]").text("동의 해주시기 바랍니다.");
           $("label[for="+this.id+"]").css("color","red");
       }
   }
	/*동의 여부 확인 end*/
	
	
	
	/*reset button start*/
	
	function resetForm() {
// 		$('#userid').attr("readonly",false); // reset 클릭시 다시 수정가능   참고한 사이트 :https://www.tutorialrepublic.com/faq/how-to-reset-a-form-using-jquery.php
// 		$("#check").attr("disabled" ,false);  //rest 클릭시 다시 중복 체크 버튼 활성화, 
		alert('입력한 정보는 모두 초기화됩니다');
// 		document.getElementById("signFrm").reset();
		 window.location.reload();
	}
	/*reset button finish*/
	
	
	/*alert 창 이후 조건에 부합하지않는다면 input 값 초기화 */
	function clear(){
		
		/*전화 번화관련 validation 에  필요한변수 선언부*/
		var phone = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;

		//아이디 정규식 (영문으로 만 입력 되게끔)
		var idV = /^[a-z0-9][a-z0-9_\-]{4,19}$/; 
		
		// 이메일 검사 정규식 
		var mail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

		// 비밀번호 정규식
		 var pw = /^[A-Za-z0-9]{4,12}$/; 
		// 이름 정규식 
		var nameV = /^[가-힣]{2,4}|[a-zA-Z]{2,10}\s[a-zA-Z]{2,10}$/;
		
		if(nameV.test($('#name').val()) == false){
		$("#name").val("");
		
		}
		else if(mail.test($('#email').val()) ==false){
		$("#email").val("");
		}
		else if(phone.test($('#number').val()) ==false){
		$("#number").val("");
		}
		else{
			$("#passwd").val("");
			$("#passwdCheck").val("");
		}
	}	
	/*alert 창 이후 조건에 부합하지않는다면 input 값 초기화 finish */
  /*validation 허점(이슈) 현제 nema부분 valdation , 2번쨰 한글 기입후 특수문자나 공백가능 --> 수정사항*/
  
  /*-------------------------------------------------------------------------------------------*/

	/*이메일 인증 부분 이에일 옆 버튼클릭시 인증번호 날라옴 ddang0103@naver.com 내 이메일로*/
	/*이메일 인증 끝나는 지점*/
  
  
  
</script>
</html>