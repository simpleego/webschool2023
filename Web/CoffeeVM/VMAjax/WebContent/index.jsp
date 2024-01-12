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
	
	#wrapper {
		width: 830px;
		margin: 10px auto;		
	}
	
	#title {
		margin-top: 30px;
		margin-bottom: 30px;
		text-align: center;
	}
	
	form {
		border: 5px solid #ccc;
		border-radius: 10%;
		padding: 10px;
	}
	
	table {
		width: 95%;
		margin: 10px auto;
		padding: 10px;	
		background-color: #fff;	
	}

	.coffee {
		width:110px;
		height: 150px;
	}
	
	#coins {
		width: 400px;
	}
	
	#coin500 {
		width: 80px;
		height: 75px;
		background-image: url('images/coin500.png');
		background-repeat: no-repeat;
		color: rgb(255,0,0,0.0);
	}
	#coin100 {
		width: 80px;
		height: 75px;
		background-image: url('images/coin100.png');
		background-repeat: no-repeat;
		color: rgb(255,0,0,0.0);
	}
	#coin50 {
		width: 80px;
		height: 75px;
		background-image: url('images/coin50.png');
		background-repeat: no-repeat;
		color: rgb(255,0,0,0.0);
	}
	
	#return{
	    width: 69px;
		height: 67px;
		background-image: url('images/return.png');
		background-repeat: no-repeat;
		color: rgb(255,0,0,0.0);
	}
	
	#coffeeOut{
		width: 200px;
		height: 300px;
		background-image: url('images/coffeeOut.png');
		background-repeat: no-repeat;
	}
	
	#coffeeOut img {
		position: relative;
		top: 40px;
		left: 55px;
	}
</style>
</head>
<body>
<div id="wrapper">
	<h1 id="title"> 커피 자판기 </h1>
	<form action="vm" method="post">
		<table id="coffee_menu">
		<colgroup>
			<col width="150px">
			<col width="150px">
			<col width="150px">
			<col width="150px">
		</colgroup>
			<tr>
				<td colspan=3></td>
			</tr>
			<tr>
				<td><img class="coffee" src="images/milkOut.png"></td>
				<td><img class="coffee" src="images/creamOut.png"></td>
				<td><img class="coffee" src="images/sugarOut.png"></td>
				<td><img class="coffee" src="images/blackOut.png"></td>
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
				<td id="coins">
				   <input id="coin500" type="submit" name="coin" value="500">
				   <input id="coin100" type="submit" name="coin" value="100">
				   <input id="coin50" type="submit" name="coin" value="50">
				</td>
				<td>
					잔액 : <input type="text" size=8 readonly value="${valance }"><br>
				</td>
				<td> <input id="return" type="submit" name="change" value="반환"></td>
				<td>상태 : <input type="text" size=8 readonly value="${change }"></td>
			</tr>
			<tr>
				<td colspan=3><input type="submit" name="logout" value="logout"></td>
			</tr>
			<tr><td></td>
				<td id="coffeeOut" colspan=3>					
						<img src="images/${coffee }" >
				</td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>