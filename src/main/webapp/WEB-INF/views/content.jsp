<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script type="text/javascript">
var logHour=${logStatisListHour};
var logAccessCount=${logStatisListAccessCount};

	$(function() {
		$('#container').highcharts(
				{
					title : {
						text : '�ð��� �� ������ �� ���',
						x : -20
					//center
					},
					/* subtitle : {
						text : 'Source: WorldClimate.com',
						x : -20
					}, */
					xAxis : {
						 categories : JSON.parse("[" + logHour + "]")

					},
					yAxis : {
						title : {
							text : '�����ڼ� (��)'
						},
						plotLines : [ {
							value : 0,
							width : 1,
							color : '#808080'
						} ]
					},
					tooltip : {
						valueSuffix : '��'
					},
					legend : {
						layout : 'vertical',
						align : 'right',
						verticalAlign : 'middle',
						borderWidth : 0
					},
					series : [
							{
								name : '��ü ������',
								data : JSON.parse("[" + logAccessCount + "]")

							} ]
				});
	});
</script>


<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css"
	href="./resources/css/mystyle.css" />
<title>Insert title here</title>
</head>
<body>

	<div id="pagebody">
		<!-- LEFT   Menu Area-->
		<!-- <div style="margin-left: 10px; margin-top: 10px; float: left;">
		<img src="./resources/images/secuveLog.jpg" width="90" height="70" />
			</div> -->

		<div id="submenu">

			<div id="submenu_header">�ֽ� �Խñ�</div>
			<c:forEach var="latestBoardList" items="${latestBoardList}" varStatus="status">
				&nbsp;&nbsp;<a href="./userobardview?bId=${latestBoardList.bId }" target="content">${latestBoardList.bTitle}<br/></a>
			</c:forEach>
			<!-- <li></li> -->
			<!-- <ul id="submenu_body">
			</ul> -->
			<!-- <br /> -->
			
			<div id="submenu_header">�ֽ� Q&A</div>
			<c:forEach var="latestQnaBoardList" items="${latestQnaBoardList}" varStatus="status">
				&nbsp;&nbsp;<a href="./adminqnaboardanswerwrite?qnaId=${latestQnaBoardList.qnaId}" target="content">${latestQnaBoardList.qnaQuestion}<br/></a>
				</c:forEach>
			<!-- </ul> -->
			<br />
			<div id="dictionary">
			<br/>
			
				<h2>�ֱ� ���� ID</h2>
				<c:forEach var="accessIdList" items="${accessIdList}" varStatus="status">
					<ul>
						<li><a href="./contentstatic?logUserName=${accessIdList.logUserName}">${accessIdList.logUserName}</a></li>
					</ul>
				</c:forEach>
			</div>


		</div>


		<div id="content">

			<h2>���� ��� ��Ȳ</h2>
			<h3>ȸ���� : ${usersCount} �� ���� �湮�ڼ� : ${todayAccessUserCount}��</h3>
			
			<p></p>
			<hr />
			<div id="container"
				style="min-width: 310px, height: 400px, width:400px; margin: 0 auto"></div>
		</div>

		<div id="footer">
			<address>Copyright (c) by SoenHakJi</address>

		</div>
	</div>

</body>
</html>