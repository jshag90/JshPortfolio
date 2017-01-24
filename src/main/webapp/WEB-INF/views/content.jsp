<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"	src="./resources/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="./resources/js/modules/exporting.js"></script>
<script type="text/javascript" src="./resources/js/highcharts.js"></script>
<script type="text/javascript">
var logHour=${logStatisListHour};
var logAccessCount=${logStatisListAccessCount};

	$(function() {
		$('#container').highcharts(
				{
					title : {
						text : '시간대 별 접속자 수 통계',
						x : -20
					
					},
					xAxis : {
						 categories : JSON.parse("[" + logHour + "]")

					},
					yAxis : {
						title : {
							text : '접속자수 (명)'
						},
						plotLines : [ {
							value : 0,
							width : 1,
							color : '#808080'
						} ]
					},
					tooltip : {
						valueSuffix : '명'
					},
					legend : {
						layout : 'vertical',
						align : 'right',
						verticalAlign : 'middle',
						borderWidth : 0
					},
					
					 plotOptions: {
			                series: {
			                    cursor: 'pointer',
			                    point: {
			                        events: {
			                            click: function (e) {
			                            	
			                            	 location.href =  './adminlogmanager';
			                               
			                            }
			                        }
			                    },
			                    marker: {
			                        lineWidth: 1
			                    }
			                }
			            },
					series : [
							{
								name : '전체 접속자',
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
		
			<div id="submenu">

			<div id="submenu_header">최신 게시글</div>
			<c:forEach var="latestBoardList" items="${latestBoardList}" varStatus="status">
				&nbsp;&nbsp;<a href="./userobardview?bId=${latestBoardList.bId }" target="content">${latestBoardList.bTitle}<br/></a>
			</c:forEach>
			<!-- <li></li> -->
			<!-- <ul id="submenu_body">
			</ul> -->
			<!-- <br /> -->
			
			<div id="submenu_header">최신 Q&A</div>
			<c:forEach var="latestQnaBoardList" items="${latestQnaBoardList}" varStatus="status">
				&nbsp;&nbsp;<a href="./adminqnaboardanswerwrite?qnaId=${latestQnaBoardList.qnaId}" target="content">${latestQnaBoardList.qnaQuestion}<br/></a>
				</c:forEach>
			<!-- </ul> -->
			<br />
			<div id="dictionary">
			<br/>
			
				<h2>최근 접속 ID</h2>
				<c:forEach var="accessIdList" items="${accessIdList}" varStatus="status">
					<ul>
						<li><a href="./contentstatic?logUserName=${accessIdList.logUserName}">${accessIdList.logUserName}</a></li>
					</ul>
				</c:forEach>
			</div>


		</div>


		<div id="content">

			<h2>접속 통계 현황</h2>
			<h3>회원수 : ${usersCount} 명 오늘 방문자수 : ${todayAccessUserCount}명</h3>
			
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