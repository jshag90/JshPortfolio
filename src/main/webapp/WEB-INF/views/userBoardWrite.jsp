<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<body>
	<div id="pagebody">
		<center>
			<br />
			<br />

			<form action="./boardwritepro" method="post">

				<table class="table-style-two" border="1" summary="게시판 등록">

					<colgroup>
						<col width="100" />
						<col width="500" />
					</colgroup>

					<tr>
						<th align="center">제목</th>
						<td><input name="bTitle" id="bTitle" type="text" /></td>
					</tr>
					<tr>
						<th align="center">작성자</th>
						<td><input name="bUserName" id="bUserName" type="text" value="${user.userName}"/></td>
						
					</tr>
					<tr>
						<td colspan="2"><textarea name="bContent" id="bContent" rows="20" cols="100"></textarea></td>
					</tr>

				</table>
				<p>
					<input type="button" value="목록" onclick="location.href='./usercontent' "> 
						<input type="submit" value="글쓰기" />
				</p>
			</form>
			<div id="footer">
				<address>Copyright (c) by SoenHakJi</address>
			</div>
		</center>
	</div>
</body>
</html>