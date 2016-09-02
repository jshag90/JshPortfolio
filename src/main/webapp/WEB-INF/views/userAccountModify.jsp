<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css"
	href="./resources/css/mystyle.css" />
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style type="text/css">
	table.table-style-two {
		font-family: verdana, arial, sans-serif;
		font-size: 11px;
		color: #333333;
		border-width: 1px;
		border-color: #3A3A3A;
		border-collapse: collapse;
	}
 
	table.table-style-two th {
		border-width: 1px;
		padding: 8px;
		border-style: solid;
		border-color: #517994;
		background-color: #B2CFD8;
	}
 
	table.table-style-two tr:hover td {
		background-color: #DFEBF1;
	}
 
	table.table-style-two td {
		border-width: 1px;
		padding: 8px;
		border-style: solid;
		border-color: #517994;
		background-color: #ffffff;
	}
</style>
</head>

<body>
	<div id="pagebody">
	<center>
	<br>
		<form action="./useraccountmodifyProc" method="post">
			<table class="table-style-two">
				<tr height="25">
					<%-- <td colspan="2" ><center><h3>My Account Modify</h3></center></td> --%>
					<th colspan="2" ><center><h3>My Account Modify</h3></center></th>
				</tr>
				<tr>
					<td height="30">사용자 ID</td>
					<td width="450">${userbyUserName.userName}</td>
				</tr>
				<tr>
					<td height="30">비밀번호</td>
					<td><input name="password" id="password" type="password" size="15" maxlength="12" value="${userbyUserName.password}" /></td>
				</tr>
				<tr>
					<td height="30">E-Mail</td>
					<td><input name="email" id="email" type="text" name="email" size="40" maxlength="30" value="${userInfobyInfoId.email}" /></td>
				</tr>
				<tr>
					<td height="30">Tel</td>
					<td><input name="tel" id="tel" type="text" name="tel" size="40" maxlength="30" value="${userInfobyInfoId.tel}" /></td>
				</tr>

			</table>
			<input type="submit" value="수정"> 
			<input type="button" name="cancel" value="변경 취소" onclick="javascript:window.location='./usercontent'">
		</form>
		</center>
		<div id="footer">
			<address>Copyright (c) by SoenHakJi</address>

		</div>
	</div>

</body>
</html>