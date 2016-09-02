<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
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

<script type="text/javascript">
	$(document).ready(
			function() {
				$('#faqs h3').each(
						function() {
							var tis = $(this), state = false, answer = tis
									.next('div').slideUp();
							tis.click(function() {
								state = !state;
								answer.slideToggle(state);
								tis.toggleClass('active', state);
							});
						});
			});
</script>

<style type="text/css">
#faqs {
	position: relative;
}

#faqs h3 {
	cursor: pointer;
}

#faqs h3.active {
	color: #d74646;
}

#faqs div {
	position: relative;
}
</style>

</head>
<body>

	<div id="pagebody">
		<center>
			<br /> <br />
			<table class="table-style-two" border="1" summary="게시판 목록">

				<colgroup>
					<col width="50" />
					<col width="300" />
					<col width="100" />
					<col width="80" />
					<col width="60" />
				</colgroup>
				<thead>
					<tr>
						<th>번호</th>
						<th>질문</th>
						<th>등록일</th>
						<th>사용자</th>
						<c:if test="${userIsAdmin != 'y'}">
						<th>관리</th>
						</c:if>
						
						
						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="qnaList" items="${qnaList }" varStatus="status">
						<tr>
							<td align="center"><c:out value="${qnaList.qnaId}" /></td>
							<td><c:choose>

									<c:when test="${userIsAdmin == 'y'}">
										<a href="./adminqnaboardanswerwrite?qnaId=${qnaList.qnaId}">${qnaList.qnaQuestion }</a>
										<br />
										<a>${qnaList.qnaAnswer }</a>
									</c:when>
									<c:otherwise>
										<div id="faqs">
											<h3>${qnaList.qnaQuestion }</h3>
											<div style="display: none;">${qnaList.qnaAnswer }</div>
										</div>
									</c:otherwise>
								</c:choose></td>
							<td align="center"><c:out value="${qnaList.qnaRegDate }" /></td>
							<td align="center"><c:out value="${qnaList.qnaUserName }" /></td>
							<c:if test="${qnaList.qnaUserName == user.userName }">
							<td><center><a href="./qnaboraddeleteproc?qnaId=${qnaList.qnaId}">삭제</a></center></td>
							</c:if>
							
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
					<c:if test="${userIsAdmin != 'y'}">
						<td align="center" colspan="5">1</td>
						</c:if>
						<td align="center" colspan="4">1</td>
					</tr>
				</tfoot>
			</table>
		</center>
		<center>
			<p>

				<c:if test="${userIsAdmin != 'y'}">
					<input type="button" value="질문 등록"
						onclick="location.href='./qnaboardwrite' ">
				</c:if>

			</p>
		</center>
		<div id="footer">
			<address>Copyright (c) by SoenHakJi</address>

		</div>
	</div>

</body>
</html>