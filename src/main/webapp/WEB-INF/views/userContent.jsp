<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Spring Seminar</title>

<!-- Bootstrap Core CSS -->
<link href="./resources/vendor/bootstrap/css/bootstrap.min.css"	rel="stylesheet">

<!-- Theme CSS -->
<link href="./resources/css/clean-blog.min.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="./resources/vendor/font-awesome/css/font-awesome.min.css" 	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' 	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>

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
					<li><a href="./usercontent?&pageNo=1">BULLETIN BOARD</a></li>
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
	<header class="intro-header" style="background-image: url('./resources/img/home-bg.jpg')">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<div class="site-heading">
						<h1>BULLETIN BOARD</h1>
						<hr class="small">
						<span class="subheading">It is a BULLETIN BOARD by JI</span>
					</div>
				</div>
			</div>
		</div>
	</header>
	
	<!-- Main Content -->	
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<div class="post-preview">
					<center>
							<table class="table table-hover" >
								<thead>
									<tr>
										<th><center>NO</center></th>
										<th><center>TITLE</center></th>
										<th><center>AUTHOR</center></th>
										<th><center>DATE</center></th>
										<th><center>HIT</center></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="userBoard" items="${userBoardList.list}" varStatus="status">
										<tr>
											<td align="center"><c:out value="${userBoard.bId }" /></td>
											<td>
												<a href="./userobardview?bId=${userBoard.bId }">
													<c:out value="${userBoard.bTitle }" />
												</a>
											</td>
											<td align="center"><c:out value="${userBoard.bUserName }" /></td>
											<td align="center"><c:out value="${userBoard.bRegDate }" /></td>
											<td align="center"><c:out value="${userBoard.bHit }" /></td>
										</tr>
									</c:forEach>
								</tbody>
								<tfoot><!-- 페이징 -->
								</tfoot> 
							</table>
							
							<ul class="pagination">
								<c:if test="${userBoardList.pagingBean.previousPageGroup}">
								<!-- 이전 페이지의 값 계산 -->
									<li><a href="./usercontent?pageNo=${pagingBean.startPageOfPageGroup-1}"></a><li>
								</c:if>
								
								<c:forEach var="i" begin="${userBoardList.pagingBean.startPageOfPageGroup}"
						  								  end="${userBoardList.pagingBean.endPageOfPageGroup}">
									<c:choose>
							 			<c:when test="${userBoardList.pagingBean.nowPage!=i}">
							 			<!-- 현재 페이지가 속한 그룹을 계산하여 나온 값을 리턴하고 페이지 값 i와 같지 않으면 -->
							 				<li><a href="./usercontent?&pageNo=${i}">${i}</a></li>
						 				</c:when>
					 		 			<c:otherwise>
											<li class="active"><a href="#" >${i}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>	
								<c:if test="${userBoardList.pagingBean.nextPageGroup}">
									<li><a href="./usercontent?pageNo=${pagingBean.endPageOfPageGroup+1}">>></a><li>
								</c:if>
							</ul>
							<br/>
							<input type="button" class="btn btn-default" value="글쓰기" onclick="location.href='./userboardwrite' ">
					</center>
				</div>
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
					<center>
					<p class="copyright text-muted">Copyright &copy; Your Website 2016</p>
					</center>
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