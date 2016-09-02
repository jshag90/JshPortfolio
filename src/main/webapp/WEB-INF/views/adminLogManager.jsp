<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="./resources/script/jquery-1.12.3.js" charset="utf-8"></script>
<link href="./resources/script/jquery.dataTables.css" rel="stylesheet"
	type="text/css" />
<script src="./resources/script/jquery.dataTables.js"></script>

<link rel="stylesheet" type="text/css"
	href="./resources/css/mystyle.css" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
body {
	font: 90%/1.45em "Helvetica Neue", HelveticaNeue, Verdana, Arial,
		Helvetica, sans-serif;
	margin: 0;
	padding: 0;
	color: #333;
	background-color: #999999;
}
</style>
<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		var table = $('#example').DataTable();
	});
</script>
<style>
.mytable {
	border-collapse: collapse;
}

.mytable th, .mytable td {
	border: 1px solid black;
	padding: 1px;
}
</style>

<style type="text/css">
#tfheader {
	background-color: #c3dfef;
}

#tfnewsearch {
	float: right;
	padding: 20px;
}

.tftextinput {
	margin: 0;
	padding: 5px 15px;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	border: 1px solid #0076a3;
	border-right: 0px;
	border-top-left-radius: 5px 5px;
	border-bottom-left-radius: 5px 5px;
}

.tfbutton {
	margin: 0;
	padding: 5px 15px;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	outline: none;
	cursor: pointer;
	text-align: center;
	text-decoration: none;
	color: #ffffff;
	border: solid 1px #0076a3;
	border-right: 0px;
	background: #0095cd;
	background: -webkit-gradient(linear, left top, left bottom, from(#00adee),
		to(#0078a5));
	background: -moz-linear-gradient(top, #00adee, #0078a5);
	border-top-right-radius: 5px 5px;
	border-bottom-right-radius: 5px 5px;
}

.tfbutton:hover {
	text-decoration: none;
	background: #007ead;
	background: -webkit-gradient(linear, left top, left bottom, from(#0095cc),
		to(#00678e));
	background: -moz-linear-gradient(top, #0095cc, #00678e);
}
/* Fixes submit button height problem in Firefox */
.tfbutton::-moz-focus-inner {
	border: 0;
}

.tfclear {
	clear: both;
}

#logTable {
	width: 600px;
	float: right;
	padding-right: 10px;
	zoom:0.9;
}
</style>
</head>
<body>

	<div id="pagebody">
		<div id="content03">
			<div id="logTable">
				<div class="container">
					<form id="tfnewsearch" method="post" action="./adminloglistbylogusername">
						<select name="columName" form="tfnewsearch">
							<option value="userName">USERNAME</option>
							<option value="accessIp">ACCESSIP</option>
							<option value="date">DATE</option>
							<option value="content">CONTENT</option>
						</select> <input type="text" class="tftextinput" name="searchWord"
							size="21" maxlength="120"><input type="submit"
							value="search" class="tfbutton">
					</form>
				</div>

				<table id="example" class="display nowrap" >
					<thead>
						<tr>
							<th align="center" >INDEX</th>
							<th align="center">USERNAME</th>
							<th align="center" >ACCESSIP</th>
							<th align="center" >DATE</th>
							<th align="center" >CONTENT</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="logList" items="${logList}" varStatus="status">
							<tr>
								<td align="center" ><c:out value=" ${logList.logId}" /></td>
								<td align="center" ><a href="./contentstatic?logUserName=${logList.logUserName}"><c:out value=" ${logList.logUserName}" /></a></td>
								<td width="110"><c:out value=" ${logList.ipAddress}" /></td>
								<td width="110"><c:out value=" ${logList.logRegDate}" /></td>
								<td width="100"><c:out value=" ${logList.logContent}" /></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
				</div>
		</div>
		<div id="footer">
			<address>Copyright (c) by SoenHakJi</address>
		</div>
	</div>
</body>
</html>