<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="./resources/css/mystyle.css" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<style>  
.mytable { border-collapse:collapse; }  
.mytable th, .mytable td { border:1px solid black; }
</style>
<body>
	<div id="pagebody">
		<div id="content">
			<div id="news">
			<table class="mytable">
				<tr>
					<th colspan="2">ID</th>
					<th colspan="3">Password</th>
					<br>
					<c:forEach var="userList" items="${userList}" varStatus="status">
						<td><c:out value="${userList.id}" /></td>
						<td><c:out value="${userList.password }" /></td>
						<br>
					</c:forEach>
				</tr>
				</table>
			</div>

		</div>
		<div id="footer">
			<address>Copyright (c) by SoenHakJi</address>
		</div>
	</div>
</body>
</html>