<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>화면처리 ( /컨패스/service/scoreRegist )</h2>
	<h2>점수 입력화면</h2>
	<form action="scoreForm" method="post">
		이름:<input type="text" name="name"><br>
		국어:<input type="text" name="kor"><br>
		영어:<input type="text" name="eng"><br>
		수학:<input type="text" name="math"><br>
		<input type="submit" value="전송">
		<input type="button" value="목록">
	</form>
	
	
</body>
</html>