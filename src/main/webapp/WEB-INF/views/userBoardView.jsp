<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="./resources/css/mystyle.css" />
<style type="text/css">
* {
	font-size: 9pt;
}

p {
	width: 600px;
	text-align: right;
}

table tbody tr th {
	background-color: gray;
}
</style>
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
</head>
<body>
	<div id="pagebody">
		<center>
			<br /> <br />
			<table class="table-style-two" border="1" summary="Board View">
				<caption>
					<h3>Board View</h3>
				</caption>
				<colgroup>
					<col width="100" />
					<col width="500" />
				</colgroup>
				<tbody>


					<tr>
						<th align="center">제목</th>
						<td>${boardbybId.bTitle }</td>
					</tr>
					<tr>
						<th align="center">작성자/조회수</th>
						<td>${boardbybId.bUserName }/ ${boardbybId.bHit}</td>
					</tr>
					<tr>
						<td colspan="5">${boardbybId.bContent }</td>
					</tr>


				</tbody>
			</table>
		</center>
		<p>

			<input type="button" value="목록"
				onclick="location.href='./usercontent' ">
			<c:if test="${user.userName == boardbybId.bUserName}">
				<input type="button" value="수정"
					onclick="location.href='./userobardmodify?bId=${boardbybId.bId }' ">
				<input type="button" value="삭제"
					onclick="location.href='./userboardDeleteProc?bId=${boardbybId.bId }' " />
			</c:if>
		</p>

		<div id="footer">
			<address>Copyright (c) by SoenHakJi</address>
		</div>
	</div>

</body>
</html>