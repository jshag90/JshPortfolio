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

</head>
</head>
<body>
	<div id="pagebody">
		<center>
			<br /> <br />
			<table class="table-style-two" border="1" summary="게시판 목록">

				<colgroup>
					<col width="50" />
					<col width="300" />
					<col width="80" />
					<col width="100" />
					<col width="70" />
				</colgroup>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록 일시</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="userBoardList" items="${userBoardList }"
						varStatus="status">
						<tr>
							<td align="center"><c:out value="${userBoardList.bId }"/></td>
							<td><a href="./userobardview?bId=${userBoardList.bId }"><c:out value="${userBoardList.bTitle }"/></a></td>
							<td align="center"><c:out value="${userBoardList.bUserName }"/></td>
							<td align="center"><c:out value="${userBoardList.bRegDate }"/></td>
							<td align="center"><c:out value="${userBoardList.bHit }"/></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td align="center" colspan="5">1</td>
					</tr>
				</tfoot>
			</table>
		</center>
		<center>
			<p>

				<!-- <button type="button"  href="./userboardwrite" target="userContent">글쓰기</button> -->
				<input type="button" value="글쓰기"
					onclick="location.href='./userboardwrite' ">
			</p>
		</center>
		<div id="footer">
			<address>Copyright (c) by SoenHakJi</address>
		
		</div>
	</div>

</body>
</html>