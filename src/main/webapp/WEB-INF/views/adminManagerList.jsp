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

<style type="text/css">
* {
	font-size: 9pt;
}

p {
	width: 600px;
	text-align: right;
}

table thead tr th {
	background-color: gray;
}

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
<body>
	<div id="pagebody">
		<center>
			<br />
			<br />
			<table class="table-style-two" border="1">
				<colgroup>
					<col width="50" />
					<col width="50" />
					<col width="90" />
					<col width="80" />
					<col width="40" />
					<col width="40" />
					<col width="90" />
					<col width="90" />

				</colgroup>
				<thead>
					<tr>
						<th align="center">ID</th>
						<th align="center">PASSWORD</th>
						<th align="center">E-MAIL</th>
						<th align="center">tel</th>
						<th align="center">권한</th>
						<th align="center">관리</th>
						<th align="center">관리자 권한</th>
						<th align="center">사용자 권한</th>
					</tr>
				</thead>
				<tbody>
						
					<c:forEach var="userList" items="${userList}" varStatus="status">
					
							<tr>
								<td><c:out value=" ${userList.userName}" /></td>
								<td><c:out value=" ${userList.password }" /></td>
								<td><c:out value="${userInfoList[status.index].email }" /></td>
								<td><c:out value="${userInfoList[status.index].tel }" /></td>
								<td><c:choose>
										<c:when test="${userList.isAdmin == 'y'}">
											<c:out value="Admin" />
										</c:when>
										<c:when test="${userList.isAdmin == 'n'}">
											<c:out value="User" />
										</c:when>
									</c:choose></td>
								<td><center>
										<input type="button" value="삭제"
											onclick="location.href='./adminmanagerdelete?id=${userList.id}'">
									</center></td>
								<td><center>

										<c:if test="${userList.isAdmin == 'y'}">
											<input type="checkbox" checked="checked"
												onclick="location.href='./adminmanagerisadmin?id=${userList.id}&isAdmin=y' " />
										</c:if>
										<c:if test="${userList.isAdmin == 'n'}">
											<input type="checkbox"
												onclick="location.href='./adminmanagerisadmin?id=${userList.id}&isAdmin=y' " />
										</c:if>
									</center></td>
								<td><center>

										<c:if test="${userList.isAdmin == 'y'}">
											<input type="checkbox" value="등록"
												onclick="location.href='./adminmanagerisadmin?id=${userList.id}&isAdmin=n' " />
										</c:if>
										<c:if test="${userList.isAdmin == 'n'}">
											<input type="checkbox" value="등록" checked="checked"
												onclick="location.href='./adminmanagerisadmin?id=${userList.id}&isAdmin=n' " />
										</c:if>

									</center></td>
							</tr>
						
						</c:forEach>
					
				</tbody>
				<tfoot></tfoot>
			</table>
			<br />
			<br />
		</center>

		<div id="footer">
			<address>Copyright (c) by SoenHakJi</address>
		</div>
	</div>

</body>
</html>