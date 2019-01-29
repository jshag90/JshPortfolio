<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./resources/css/mystyle.css" />
<link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="./resources/script/bootstrap.min.css">
<link href="./resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="./resources/css/clean-blog.min.css" rel="stylesheet">
<link href="./resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

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

.paging-nav, #tableData {
	width: 600px;
	margin: 0 auto;
	font-family: Arial, sans-serif;
	zoom: 1.2;
}
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

<script type="text/javascript">
	$(document).ready(
			function() {
				$('#faqs h5').each(
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

</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-custom navbar-fixed-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header page-scroll">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
			</button>
			<a class="navbar-brand" href="./usercontent">Spring seminar</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
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
	<!-- /.container --> </nav>
	
	<!-- Page Header -->
    <!-- Set your background image for this header on the line below. -->
    <header class="intro-header" style="background-image: url('./resources/img/about-bg.jpg')">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <div class="page-heading">
                        <h1>NOTICE BOARD</h1>
                        <hr class="small">
                        <span class="subheading">It is a NOTICE BOARD by JI</span>
                    </div>
                </div>
            </div>
        </div>
    </header>


	<!-- Main Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">

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
								<c:forEach var="noticeList" items="${noticeList }"
									varStatus="status">
									<tr>
										<td align="center"><c:out value="${noticeList.noticeId}" />
										</td>
										<td>
											<div id="faqs">
												<h5>${noticeList.noticeTitle }</h5>
												<div style="display: none;">${noticeList.noticeContent }</div>
											</div>
										</td>

										<td align="center"><c:out
												value="${noticeList.noticeUserName }" /></td>
										<td align="center"><c:out
												value="${noticeList.noticeRegDate }" /></td>

										<c:if test="${userIsAdmin == 'y'}">
											<td><input type="button" value="삭제"
												onclick="location.href='./noticeboarddeleteproc?noticeId=${noticeList.noticeId}'" />
												<input type="button" value="수정"
												onclick="location.href='./noticeboardmodify?noticeId=${noticeList.noticeId}'" />
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
						<script type="text/javascript"
							src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
						<script
							src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
						<script type="text/javascript" src="./resources/script/paging.js"></script>
						<script type="text/javascript">
							$(document).ready(function() {
								$('#tableData').paging({
									limit : 5
								});
							});
						</script>
						<script type="text/javascript">
							var _gaq = _gaq || [];
							_gaq.push([ '_setAccount', 'UA-36251023-1' ]);
							_gaq.push([ '_setDomainName', 'jqueryscript.net' ]);
							_gaq.push([ '_trackPageview' ]);

							(function() {
								var ga = document.createElement('script');
								ga.type = 'text/javascript';
								ga.async = true;
								ga.src = ('https:' == document.location.protocol ? 'https://ssl'
										: 'http://www')
										+ '.google-analytics.com/ga.js';
								var s = document.getElementsByTagName('script')[0];
								s.parentNode.insertBefore(ga, s);
							})();
						</script>
					</center>

					<center>
						<p>
							<c:if test="${userIsAdmin == 'y'}">
								<center>
									<input type="button" value="공지 등록"
										onclick="location.href='./noticeboardwrite' ">
								</center>

							</c:if>

						</p>
					</center>
			</div>
		</div>
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
					<p class="copyright text-muted">Copyright &copy; Your Website
						2016</p>
				</div>
			</div>
		</div>
		</footer>
	</div>
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