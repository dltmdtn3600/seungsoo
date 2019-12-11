<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>점수 등록 현황</h2>
	<c:forEach var="vo" items="${scoreList }" varStatus="num">
		번호 : ${num.index } <!-- item의 인덱스번호 -->
		이름 : ${vo.name }
		국어 : ${vo.kor }
		영어 : ${vo.eng }
		수학 : ${vo.math }
		<button type="button" id="deleteBtn" onclick="location.href='scoreDelete?num=${vo.num }'">삭제</button>
		<br>
	</c:forEach>
	<a href="scoreRegist">점수 등록하러가기</a>
	
	<script>
// 		var deleteBtn = document.getElementById("deletBtn");
// 		dleleteBten.onclick = function test(){
// 			location.href='scoreDelete';
// 		}
	</script>
	
		
	
</body>
</html>