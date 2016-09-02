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
	<center><br/><br/>
		<form action="./adminqnaboardanswerwriteproc" method="post">

				<table class="table-style-two" border="1" summary="게시판 등록">

					<colgroup>
						<col width="100" />
						<col width="500" />
						<col width="500" />
					</colgroup>

					<tr>
						<th align="center">작성자</th>
						<td><input name="qnaUserName" id="qnaUserName" type="text" value="${qnaUser}"/></td>
						
					</tr>
					<tr>
						<th align="center">질문</th>
						<td><input name="qnaQuestion" id="qnaQuestion" type="text" size="70" value="${qnaQuestion}"/></td>
					</tr>
					<tr>
						<th align="center">답변</th>
						<td><textarea rows="10" cols="80" name="qnaAnswer" id="qnaAnswer" >${qnaAnswer }</textarea></td>
					</tr>
					

				</table>
				<p>
					<input type="button" value="목록" onclick="location.href='./userqnaboard' "> 
						<input type="submit" value="답변달기" />
				</p>
			</form>
		<div id="footer">
			<address>Copyright (c) by SoenHakJi</address>

		</div>
		</center>
	</div>

</body>
</html>