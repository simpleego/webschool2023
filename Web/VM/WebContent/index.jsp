<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커피 자판기</title>
<style type="text/css">
	* {
		margin: 0px;
		padding: 0px;
	}
	
	form {
		width: 800px;
		margin: 10px auto;
		border: 5px solid #ccc;
		border-radius: 10%;
		padding: 10px;
	}
	
	table {
		width: 100%;
		margin: 10px auto;
		border: 3px solid #ccc;
		border-radious: 5%;
		padding: 10px;	
		background-color: #eee;	
	}

	#coffee_menu {
	
	
	}
</style>
</head>
<body>
	<form action="vm" method="post">
		<table id="coffee_menu">
		<colgroup>
			<col width="150px">
			<col width="150px">
			<col width="150px">
			<col width="150px">
		</colgroup>
			<tr>
				<td colspan=3><h1> 믹스 커피 자판기</h1></td>
			</tr>
			<tr>
				<td>밀크커피</td>
				<td>프림커피</td>
				<td>설탕커피</td>
				<td>블랙커피</td>
			</tr>
			<tr>
				<td>(300원)</td>
				<td>(300원)</td>
				<td>(200원)</td>
				<td>(200원)</td>
			</tr>
			<tr>
				<td><input type="submit" ${empty btnMilk ? 'disabled': '' } name="coffee"  value="밀크커피"></td>
				<td><input type="submit" ${empty btnCream ? 'disabled': '' } name="coffee"  value="프림커피"></td>
				<td><input type="submit" ${empty btnSugar ? 'disabled': '' } name="coffee"  value="설탕커피"></td>
				<td><input type="submit" ${empty btnBlack ? 'disabled': '' } name="coffee"  value="블랙커피"></td>
			</tr>
			<tr>
				<td>
				   동전 입력 : <input type="submit" name="coin" value="500">
				   <input type="submit" name="coin" value="100">
				   <input type="submit" name="coin" value="50">
				</td>
				<td>
					잔액 : <input type="text" size=8 readonly value="${valance }"><br>
				</td>
				<td> 반환: <input type="submit" name="change" value="반환"></td>
				<td>상태 : <input type="text" size=8 readonly value="${change }"></td>
			</tr>
			<tr>
				<td colspan=3><input type="submit" name="logout" value="logout"></td>
			</tr>
			<tr>
				<td colspan=3>
					<textarea rows="10" cols="50">
						${coffee }
					</textarea>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>