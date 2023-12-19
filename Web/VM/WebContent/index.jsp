<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커피 자판기</title>
</head>
<body>
	<form action="vm" method="post">
		동전 입력 : <input type="text" name="coin"><br>		
		잔액 : <input type="text" readonly value="${valance }"><br>
		<input type="submit" value="동전넣기">
	</form>
</body>
</html>