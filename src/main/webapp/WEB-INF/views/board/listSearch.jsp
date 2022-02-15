<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 등록일 날짜 포멕 변경 -->
<%--  <%@ taglib prefix="fmt" uri=" http://java.sun.com/jsp/jstl/fmt "> --%>
<html>
<head>

<title>메인 리스트</title>
</head>
<!--   <!--jquery Cdn--> 
<!-- 	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
<!--      pagination 관련 js cdn -->
<!--      <script src="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.min.js"></script> -->
<!--      페이지네이션 관련 css -->
<!--     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.css"/> -->

<style type="text/css">
/* boardcss_list 에서 사용되는 글 등록 버튼 테이블 크기 */
#boardcss_list_add_button_table { width: 100%; margin: 0 auto 15px; /*position: relative; background: #bddcff; font-weight: bold;*/ }

/* 화면에 보여지는 글 등록 버튼 */
#boardcss_list_add_button_table .add_button { cursor: pointer; border: 1px solid #bebebe; position: absolute; right: 10px; top: 250px; width: 85px; padding: 6px 0 6px; text-align: center; font-weight: bold; }
#boardcss_list_add_button_table .add_button a { color: #ffffff; }

/* 글 등록 버튼과 글 목록이 겹치지 않게 */
#boardcss_list_add_button_table .boardcss_list_add_button ul { width: 100%; overflow: hidden; height: 10px;}

/* boardcss_list 에서 사용하는 글 목록 테이블 크기*/
.boardcss_list_table { width: 100%; }

/* 화면에 보여지는 글 목록 테이블 */
.list_table { width: 100%; }

/* 화면에 보여지는 caption */
.list_table caption { display: none; }

/* list_table 에서 사용되는 thead */
.list_table thead th { text-align: center; border-top: 1px solid #e5e5e5; border-bottom: 1px solid #e5e5e5; padding: 8px 0; background: #faf9fa; }

/* list_table 에서 사용되는 tbody */
.list_table tbody td { text-align: center;  border-bottom: 1px solid #e5e5e5; padding: 5px 0; }

/*a 태그 밑줄 , 색깔 없애기*/
a { text-decoration: none; color: black; }

a:hover {
	background-color: blue; 
	transition: background-color 2.5s;
}
id{
	
}

</style>

<body>

<!-- 등록버튼 시작 -->
<!-- <div id="boardcss_list_add_button_table"> -->
<!-- 	<div class="boardcss_list_add_button"> -->
<!-- 		<a href="/board/write"><p class="add_button">등록</p></a> -->
<!-- 		<ul></ul> -->
<!-- 	</div> -->
<!-- </div> -->
<!-- 등록버튼 종료 -->
	<div>
		<section>
			
<!-- <div> -->
<!--     <section> -->
<!--         <div id="data-container"></div> -->
<!--         <div id="pagination"></div> -->
<!--     </section> -->
<!-- </div> -->
		</section>
	</div>

<c:choose>
<c:when test="${empty sessionScope.userid}">
<button id="login"><a href="/board/login">Login</a></button>
<button id="signUp"><a href="/board/signUpPage">SignUp</a></button>
<button id="home"><a href="/">Home</a></button>
</c:when>
<c:otherwise>
<button id="logOut"><a href="logout">로그아웃</a></button>
<button id="home"><a href="/">Home</a></button>
<a href= "detail">${sessionScope.userid}님 환영합니다<a>
</c:otherwise>	
</c:choose>

<br>
<!-- 리스트  테이블 시작 -->
<div class="boardcss_list_table">
	<table class="list_table">
		<caption>메인 리스트</caption>
		<colgroup>
			
			<col width="15%" />
			<col width="15%" />
			<col width="20%" />
			<col width="30%" />
			<col width="20%" />
		</colgroup>
		<thead>
			<tr>
				
				<th><input id="allCheck" type="checkbox" name="allCheck" >번호</th>
				<th>제목</th>
				<th>작성자 이름</th>
				<th>등록일자</th>
				<th>관리</th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach items="${list}" var="list">
 				<tr>
  					<td><input name="RowCheck" type="checkbox" value="${list.idx}">${list.idx}</td>
  					 <td style="max-width: 60px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><a href="/board/view?idx=${list.idx}">${list.title}</a></td>
  					<td><a href="/board/view?idx=${list.idx}">${list.writer}</a></td>
  					<td><a href="/board/view?idx=${list.idx}">${list.regDt}</td>
  					<td><button><a href="/board/modify?idx=${list.idx}">수정</a></button>
  						<button><a href="/board/delete?idx=${list.idx}">삭제</a></button>
  					</td>
 			   </tr>
			</c:forEach>
		</tbody>
	</table>
<!-- 		<div> -->
<%--  <c:forEach begin="1" end="${pageNum}" var="num"> --%>
<!--     <span> -->
<%--      <a href="/board/list?num=${num}">${num}</a> --%>
<!--   </span> -->
<%--  </c:forEach> --%>
<!-- </div> -->
	<center>
		<c:if test="${page.prev}">
 		<span>[ <a href="/board/listSearch?num=${page.startPageNum - 1}${page.searchTypeKeyword}">이전</a> ]</span>
		</c:if>

		<c:forEach begin="${page.startPageNum}" end="${page.endPageNum}" var="num">
 		<span>
 
  		<c:if test="${select != num}"> 
   		<a href="/board/listSearch?num=${num}${page.searchTypeKeyword}">${num}</a>
  		</c:if>    
  
  		<c:if test="${select == num}">
   		<b>${num}</b>
  		</c:if>
    
 		</span>
		</c:forEach>

		<c:if test="${page.next}">
 		<span>[ <a href="/board/listSearch?num=${num}${page.searchTypeKeyword}">${num}</a>
		</c:if>
</center>




	<br>
	<br>
		<center>
			<form name= "search" method="GET" action="/board/listSearch?num=${num}">
			  <div>
 					 <select name="searchType">
     					<option value="title" <c:if test="${page.searchType eq 'title'}">selected</c:if>>제목</option>
        				<option value="content" <c:if test="${page.searchType eq 'content'}">selected</c:if>>내용</option>
     					<option value="title_content" <c:if test="${page.searchType eq 'title_content'}">selected</c:if>>제목+내용</option>
     					<option value="writer" <c:if test="${page.searchType eq 'writer'}">selected</c:if>>작성자</option>
 					</select>
 						<input type="text" name="keyword" value="${page.keyword}"/>
 						<button type="button" id="searchBtn">검색</button>
<%--  						<a href="listSearchPage?num=${num}"><button>해제</button></a> --%>
				</div>
 			</form>
					<div class="boardcss_list_add_button">
						<button><a href="/board/write?num=${page.num}"><p class="add_button">게시글 등록</p></a></button>
							<ul></ul>
					</div>
					<input type="button" value="선택 삭제" class="btn btn-outline-info" onclick="deleteValue();">
					
		</center>
</div>
</body>
<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
	<script type="text/javascript">
		$(function(){
			var chkObj = document.getElementsByName("RowCheck");
			var rowCnt = chkObj.length;
			
			$("input[name='allCheck']").click(function(){
				var chk_listArr = $("input[name='RowCheck']");
				for (var i=0; i<chk_listArr.length; i++){
					chk_listArr[i].checked = this.checked;
				}
			});
			$("input[name='RowCheck']").click(function(){
				if($("input[name='RowCheck']:checked").length == rowCnt){
					$("input[name='allCheck']")[0].checked = true;
				}
				else{
					$("input[name='allCheck']")[0].checked = false;
				}
			});
		});
		function deleteValue(){
			var url = "delete";    // Controller로 보내고자 하는 URL (.dh부분은 자신이 설정한 값으로 변경해야됨)
			var valueArr = new Array();
		    var list = $("input[name='RowCheck']");
		    for(var i = 0; i < list.length; i++){
		        if(list[i].checked){ //선택되어 있으면 배열에 값을 저장함
		            valueArr.push(list[i].value);
		        }
		    }
		    if (valueArr.length == 0){
		    	alert("선택된 글이 없습니다.");
		    }
		    else{
				var chk = confirm("정말 삭제하시겠습니까?");				 
				$.ajax({
				    url : url,                    // 전송 URL
				    type : 'POST',                // GET or POST 방식
				    traditional : true,
				    data : {
				    	valueArr : valueArr        // 보내고자 하는 data 변수 설정
				    },
	                success: function(jdata){
	                    if(jdata = 1) {
	                        alert("삭제 성공");
	                       window.location.replace("/board/listSearch?num=1")// 선택삭제 시 1페이지로 이동  원래의도는 해당페이지정보 유지인데 보완 중
	                       //location.href를 썻으나 안되서  대체제인  window.location.href =link;  , window.location.replace(link); , window.location.assign(link); 3개중에 사용
	                   //https://zuyo.tistory.com/360  사이트 참고 
	                   }
	                    else{
	                        alert("삭제 실패");
	                    }
	                }
				});
			}
		}
		 /*검색 jquery*/

		 document.getElementById("searchBtn").onclick = function () {
		    
		  let searchType = document.getElementsByName("searchType")[0].value;
		  let keyword =  document.getElementsByName("keyword")[0].value;
		  
		  console.log(searchType)
		  console.log(keyword)
		  location.href = "/board/listSearch?num=1" + "&searchType=" + searchType + "&keyword=" + keyword;
		 };

		 
		 /*로그인 페이지로 이동 jquery*/
			$(document).ready(function(e){
				
				$('#login').click(function() {
					location.href="/board/login";
				});
			});
		 
			 
			 /*회원가입 페이지로 이동 jquery*/
				$(document).ready(function(e){
					
					$('#signUp').click(function() {
						location.href="signUpPage";
					});
				});
			 
			 

			 
			 /*회원 상세페이지 진입 jquery 버튼 보다는 링크 타입이 더 적합하여  해당 jquery 주석 처리 함*/
// 			 	$(document).ready(function(e){
// 			 		$('#detail').click(function(){
// 			 			location.href="detail";
// 			 		});
// 			 	});
			 
	</script>
</html>