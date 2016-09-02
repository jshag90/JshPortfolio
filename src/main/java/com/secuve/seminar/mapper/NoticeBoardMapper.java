package com.secuve.seminar.mapper;

import java.util.ArrayList;

import com.secuve.seminar.dto.Notice;

public interface NoticeBoardMapper {

	public void noticeBoardWrite(Notice notice);

	public ArrayList<Notice> noticeBoardList();

	public Notice noticeBoardViewbyNoticeId(long noticeId);

	public void noticeBoardDelete(long noticeId);

	public void noticeBoardModifybyNoticeId(Notice notice);

}
