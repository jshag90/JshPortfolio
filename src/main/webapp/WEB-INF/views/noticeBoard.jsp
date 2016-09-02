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
<link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="./resources/script/bootstrap.min.css">
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
	background-color: #999999;
}
</style>
<style type="text/css">

.paging-nav {
  text-align: right;
  padding-top: 2px;
}

.paging-nav a {
  margin: auto 1px;
  text-decoration: none;
  display: inline-block;
  padding: 1px 7px;
  background: #91b9e6;
  color: white;
  border-radius: 3px;
}

.paging-nav .selected-page {
  background: #999999;
  font-weight: bold;
}

.paging-nav,
#tableData {
  width: 600px;
  margin: 0 auto;
  font-family: Arial, sans-serif;
  zoom:1.2;
  
}
</style>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#faqs h5')
								.each(
										function() {
											var tis = $(this), state = false, answer = tis
													.next('div').slideUp();
											tis.click(function() {
												state = !state;
												answer.slideToggle(state);
												tis	.toggleClass('active',state);
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
	
<div class="jquery-script-clear"></div>
		<center>
			<br /> <br />
			<!-- <table class="table-style-two" border="1" summary="게시판 목록"> -->
			<table id="tableData" class="table table-bordered table-striped">

				<colgroup>
					<col width="100" />
					<col width="500" />
					<col width="40" />
					<col width="150" />
					<col width="150" />
					
					
				</colgroup>
				<thead>
					<tr>
						<th><center>번호</center></th>
						<th><center>공지사항</center></th>
						<th><center>글쓴이</center></th>
						<th><center>등록일</center></th>
						<c:if test="${userIsAdmin == 'y'}">
							<th><center>관리</center></th>
						</c:if>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="noticeList" items="${noticeList }" varStatus="status">
						<tr>
							<td align="center">
							<c:out value="${noticeList.noticeId}" />
							</td>
							<td>
								<div id="faqs">
									<h5>${noticeList.noticeTitle }</h5>
									<div style="display: none;">${noticeList.noticeContent }</div>
								</div>
							</td>

							<td align="center">
								<c:out value="${noticeList.noticeUserName }" />
							</td>
							<td align="center">
								<c:out value="${noticeList.noticeRegDate }" />
							</td>
							
							<c:if test="${userIsAdmin == 'y'}">
								<td>
<input type="button" value="삭제" onclick="location.href='./noticeboarddeleteproc?noticeId=${noticeList.noticeId}'"/> <input type="button" value="수정" 	onclick="location.href='./noticeboardmodify?noticeId=${noticeList.noticeId}'"/>
								</td>
							</c:if>
														
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<c:choose>
						<c:when test="${userIsAdmin == 'y'}">
							<tr>
								<td align="center" colspan="7">1</td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr>
								<td align="center" colspan="4">1</td>

							</tr>
						</c:otherwise>
					</c:choose>
				</tfoot>
			</table>
			<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> 
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
<script type="text/javascript" src="./resources/script/paging.js"></script> 
<script type="text/javascript">
            $(document).ready(function() {
                $('#tableData').paging({limit:5});
            });
        </script>
        <script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-36251023-1']);
  _gaq.push(['_setDomainName', 'jqueryscript.net']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
		</center>
		
		<center>
			<p>
				<c:if test="${userIsAdmin == 'y'}">
					<center><input type="button" value="공지 등록" onclick="location.href='./noticeboardwrite' "></center>

				</c:if>

			</p>
		</center>
		<div id="footer">
			<address>Copyright (c) by SoenHakJi</address>

		</div>
	</div>

</body>
</html>