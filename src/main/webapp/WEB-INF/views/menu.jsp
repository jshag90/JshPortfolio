<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css"
	href="./resources/css/mystyle.css" />
<link rel="stylesheet" href="./resources/script/animate.css">
<title>Insert title here</title>

<style type="text/css">
div#sessionId {
	margin-right: 50px;
}
div#logo{
	margin-left: 30px;
}
</style>
</head>

<body>

	<div id="pagebody">
		<!--  header -->
		<div id="header">

			
				<!-- <a class="animated bounce" href="./logout">Web Manager Application </a> -->
			
			<div id="logo" >
				<img class="animated pulse"  width="500" src="./resources/images/Logo.png" />
				</div>
			<div id="sessionId" class="sessionId" style="text-align: right">
				<a href="./logout" target="_parent">������</a>
			</div>

		</div>
		<!--  MAIN NENU -->
		<ul id="menu">

			<li id="menu01"><a href="./content" target="content">������ ����
					������</a></li>
			<!-- ȸ����, �Խñ�, �湮�ڼ�, ���� -->
			<li id="menu02"><a href="./adminmanagerlist" target="content">ȸ�� ����</a></li>
			<!-- ȸ�� Ż��, ��� ���� -->
			<li id="menu03"><a href="./noticeboardlist" target="content">��������</a></li>
			<!-- ������ ���� �������� ������ -->
			<li id="menu04"><a href="./userqnaboard" target="content">������ Q&A �亯</a></li>
			<li id="menu05"><a href="./adminlogmanager" target="content">�� ���� ����</a></li>

		</ul>
	</div>

</body>
</html>