<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
<title>Spring Seminar</title>
<link rel="stylesheet" type="text/css"
	href="./resources/css/mystyle.css" />
	
	<!-- Bootstrap Core CSS -->
<link href="./resources/vendor/bootstrap/css/bootstrap.min.css"	rel="stylesheet">

<!-- Theme CSS -->
<link href="./resources/css/clean-blog.min.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="./resources/vendor/font-awesome/css/font-awesome.min.css" 	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' 	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
	
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

<!-- Navigation -->
	<nav class="navbar navbar-default navbar-custom navbar-fixed-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> Menu <i
						class="fa fa-bars"></i>
				</button>
				<a class="navbar-brand" href="./usercontent">Spring seminar</a>
			</div>
	
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="./usercontent?pageNo=1">BULLETIN BOARD</a></li>
					<li><a href="./noticeboardlist">NOTICE</a></li>
					<li><a href="./userqnaboard">Q&A</a></li>
					<li><a href="./useraccountmodify">MY ACCOUNT</a></li>
					<li><a href="./logout">LOGOUT</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
	<!-- /.container --> 
	</nav>

	<!-- Page Header -->
	<!-- Set your background image for this header on the line below. -->
	<header class="intro-header" style="background-image: url('./resources/img/post-bg.jpg')">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<div class="site-heading">
						<h1>Q&A BOARD</h1>
						<hr class="small">
						<span class="subheading">It is a Q&A BOARD by JI</span>
					</div>
				</div>
			</div>
		</div>
	</header>

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
		<!-- Footer -->
		<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<ul class="list-inline text-center">
						<li><a href="#"> <span class="fa-stack fa-lg"> <i
									class="fa fa-circle fa-stack-2x"></i> <i
									class="fa fa-twitter fa-stack-1x fa-inverse"></i>
							</span>
						</a></li>
						<li><a href="#"> <span class="fa-stack fa-lg"> <i
									class="fa fa-circle fa-stack-2x"></i> <i
									class="fa fa-facebook fa-stack-1x fa-inverse"></i>
							</span>
						</a></li>
						<li><a href="#"> <span class="fa-stack fa-lg"> <i
									class="fa fa-circle fa-stack-2x"></i> <i
									class="fa fa-github fa-stack-1x fa-inverse"></i>
							</span>
						</a></li>
					</ul>
					<center>
					<p class="copyright text-muted">Copyright &copy; Your Website 2016</p>
					</center>
				</div>
			</div>
		</div>
		</footer>
	
	<!-- jQuery -->
	<script src="./resources/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="./resources/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Contact Form JavaScript -->
	<script src="./resources/js/jqBootstrapValidation.js"></script>
	<script src="./resources/js/contact_me.js"></script>

	<!-- Theme JavaScript -->
	<script src="./resources/js/clean-blog.min.js"></script>

</body>
</html>