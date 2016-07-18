<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css"
	href="./resources/css/mystyle.css" />
<title>Insert title here</title>
</head>
<body>
	<div id="pagebody">
		<!--  header -->
		<div id="header">
			<h1>
				<a href="./index"> AOP 기반 관리자 페이지 </a>
			</h1>
		</div>
		<!--  MAIN NENU -->
		<ul id="menu">

			<li id="menu01"><a href="./index"" >관리자 메인 페이지</a></li>
			<!-- 회원수, 게시글, 방문자수, 새글 -->
			<li id="menu02"><a href="./list" target="content">회원 관리</a></li>
			<!-- 회원 탈퇴, 등급 관리 -->
			<li id="menu03"><a href="#">공지사항</a></li>
			<!-- 관리자 전용 공지사항 페이지 -->
			<li id="menu04"><a href="#">관리자 FAQ 답변</a></li>

			<li id="menu05"><a href="#">시스템 로그(AOP)</a></li>

		</ul>
	</div>

</body>
</html>