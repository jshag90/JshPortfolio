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

<!-- Bootstrap Core CSS -->
<link href="./resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Theme CSS -->
<link href="./resources/css/clean-blog.min.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="./resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>

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
	<!-- /.container --> </nav>
	<!-- Page Header -->
	<!-- Set your background image for this header on the line below. -->
	<header class="intro-header"
		style="background-image: url('./resources/img/contact-bg.jpg')">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<div class="site-heading">
					<h1>MY ACCOUNT</h1>
					<hr class="small">
					<span class="subheading">It is a MY ACCOUNT by JI</span>
				</div>
			</div>
		</div>
	</div>
	</header>


	<center>
		<br>
		<form action="./useraccountmodifyProc" method="post">
			<table class="table-style-two">
				<tr height="25">
					<%-- <td colspan="2" ><center><h3>My Account Modify</h3></center></td> --%>
					<th colspan="2"><center>
							<h3>My Account Modify</h3>
						</center></th>
				</tr>
				<tr>
					<td height="30">사용자 ID</td>
					<td width="450">${userbyUserName.userName}</td>
				</tr>
				<tr>
					<td height="30">비밀번호</td>
					<td><input name="password" id="password" type="password"
						size="15" maxlength="12" value="${userbyUserName.password}" /></td>
				</tr>
				<tr>
					<td height="30">E-Mail</td>
					<td><input name="email" id="email" type="text" name="email"
						size="40" maxlength="30" value="${userInfobyInfoId.email}" /></td>
				</tr>
				<tr>
					<td height="30">Tel</td>
					<td><input name="tel" id="tel" type="text" name="tel"
						size="40" maxlength="30" value="${userInfobyInfoId.tel}" /></td>
				</tr>

			</table>
			<input type="submit" value="수정"> <input type="button"
				name="cancel" value="변경 취소"
				onclick="javascript:window.location='./usercontent'">
		</form>
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
					<p class="copyright text-muted">Copyright &copy; Your Website
						2016</p>
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