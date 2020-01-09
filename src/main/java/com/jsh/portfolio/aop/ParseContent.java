package com.jsh.portfolio.aop;

public class ParseContent {

	private String parseContent;

	public String parseContentReturn(String methodContent) {

		if (methodContent.contains("UserLoginServiceController.loginProcess(..)")) {
			parseContent = "로그인 처리";
		} else if (methodContent.contains("UserLoginServiceController.logOut(..)")) {
			parseContent = "로그아웃 ";
		} else if (methodContent.contains("UserLoginServiceController.userMenu(..)")) {
			parseContent = "사용자 메뉴 접근";
		} else if (methodContent.contains("UserBoardController.userContent(..)")) {
			parseContent = "사용자 게시판 접근";
		} else if (methodContent.contains("UserLoginServiceController.join(..)")) {
			parseContent = "회원가입";
		} else if (methodContent.contains("UserLoginServiceController.userAccountModify(..)")) {
			parseContent = "내 계정 수정 페이지 접근";
		} else if (methodContent.contains("NoticeBoardController.noticeBoardList(..)")) {
			parseContent = "공지사항 접근";
		} else if (methodContent.contains("QnaController.userQnaBoard(..)")) {
			parseContent = "Q&A 게시판 접근";
		} else if (methodContent.contains("UserBoardController.userBoardWrite(..)")) {
			parseContent = "게시판 글 쓰기 페이지";
		} else if (methodContent.contains("UserBoardController.userBoardWriteProcess(..)")) {
			parseContent = "게시판 글 등록 처리";
		} else if (methodContent.contains("NoticeBoardController.noticeBoardList(..)")) {
			parseContent = "공지사항 확인";
		} else if (methodContent.contains("QnaController.userQnaBoard(..)")) {
			parseContent = "Q&A 게시판 접근";
		} else if (methodContent.contains("QnaController.qnaBoardWriteProc(..)")) {
			parseContent = "Q&A 게시판 등록";
		} else if (methodContent.contains("QnaController.qnaBoardWrite()")) {
			parseContent = "Q&A 게시판 등록 페이지";
		} else if (methodContent.contains("UserBoardController.userBoardView(..)")) {
			parseContent = "사용자 게시판 게시글 조회";
		} else if (methodContent.contains("QnaController.qnaBoardDeleteProc(..)")) {
			parseContent = "Q&A 게시글 삭제";
		} else if (methodContent.contains("UserLoginServiceController.userAccountModityProc(..)")) {
			parseContent = "사용자 계정 수정 등록";
		} else {
			parseContent = methodContent;
		}

		return parseContent;
	}

}
