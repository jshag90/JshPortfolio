package com.jsh.portfolio.aop;

public class ParseContent {

	private String parseContent;

	public String parseContentReturn(String methodContent) {

		if (methodContent.contains("UserLoginServiceController.loginProcess(..)")) {
			parseContent = "�α��� ó��";
		} else if (methodContent.contains("UserLoginServiceController.logOut(..)")) {
			parseContent = "�α׾ƿ� ";
		} else if (methodContent.contains("UserLoginServiceController.userMenu(..)")) {
			parseContent = "����� �޴� ����";
		} else if (methodContent.contains("UserBoardController.userContent(..)")) {
			parseContent = "����� �Խ��� ����";
		} else if (methodContent.contains("UserLoginServiceController.join(..)")) {
			parseContent = "ȸ������";
		} else if (methodContent.contains("UserLoginServiceController.userAccountModify(..)")) {
			parseContent = "�� ���� ���� ������ ����";
		} else if (methodContent.contains("NoticeBoardController.noticeBoardList(..)")) {
			parseContent = "�������� ����";
		} else if (methodContent.contains("QnaController.userQnaBoard(..)")) {
			parseContent = "Q&A �Խ��� ����";
		} else if (methodContent.contains("UserBoardController.userBoardWrite(..)")) {
			parseContent = "�Խ��� �� ���� ������";
		} else if (methodContent.contains("UserBoardController.userBoardWriteProcess(..)")) {
			parseContent = "�Խ��� �� ��� ó��";
		} else if (methodContent.contains("NoticeBoardController.noticeBoardList(..)")) {
			parseContent = "�������� Ȯ��";
		} else if (methodContent.contains("QnaController.userQnaBoard(..)")) {
			parseContent = "Q&A �Խ��� ����";
		} else if (methodContent.contains("QnaController.qnaBoardWriteProc(..)")) {
			parseContent = "Q&A �Խ��� ���";
		} else if (methodContent.contains("QnaController.qnaBoardWrite()")) {
			parseContent = "Q&A �Խ��� ��� ������";
		} else if (methodContent.contains("UserBoardController.userBoardView(..)")) {
			parseContent = "����� �Խ��� �Խñ� ��ȸ";
		} else if (methodContent.contains("QnaController.qnaBoardDeleteProc(..)")) {
			parseContent = "Q&A �Խñ� ����";
		} else if (methodContent.contains("UserLoginServiceController.userAccountModityProc(..)")) {
			parseContent = "����� ���� ���� ���";
		} else {
			parseContent = methodContent;
		}

		return parseContent;
	}

}
