<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css"
	href="./resources/css/mystyle.css" />
<title>Insert title here</title>
<style type="text/css">
div#sessionId {
	margin-right: 50px;
}
</style>
</head>
<body>
	<div id="pagebody">
		<!--  header -->
		<div id="header">
			<h1>
				<a href="./userIndex">Web Manager Application(User Page)</a> 
			</h1>

		</div>
		<!--  MAIN NENU -->
		<ul id="menu">

			<li id="menu01"><a href="./usercontent" target="userContent">게시판</a></li>
			<!-- 회원수, 게시글, 방문자수, 새글 -->
			<li id="menu02"><a href="./noticeboardlist" target="userContent">공지사항</a></li>
			<!-- 회원 탈퇴, 등급 관리 -->
			<li id="menu03"><a href="./userqnaboard" target="userContent">Q&A</a></li>
			<!-- 관리자 전용 공지사항 페이지 -->
			<li id="menu04"><a href="./useraccountmodify" target="userContent">내 계정</a></li>
			<li id="menu05"><a href="./logout" target="_parent">로그아웃</a></li>

		</ul>
	</div>

</body>
</html>
