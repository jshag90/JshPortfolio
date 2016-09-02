package com.secuve.seminar.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secuve.seminar.dto.Notice;
import com.secuve.seminar.mapper.NoticeBoardMapper;

@Service("noticeBoardService")
public class NoticeBoardServiceImpl implements NoticeBoardService {
	@Autowired
	NoticeBoardMapper noticeBoardMapper;

	@Override
	public void noticeBoardWrite(Notice notice) {
		noticeBoardMapper.noticeBoardWrite(notice);

	}

	@Override
	public ArrayList<Notice> noticeBoardList() {

		ArrayList<Notice> noticeResult = noticeBoardMapper.noticeBoardList();

		return noticeResult;
	}

	@Override
	public Notice noticeBoardViewbyNoticeId(long noticeId) {
		// TODO Auto-generated method stub
		Notice notice = noticeBoardMapper.noticeBoardViewbyNoticeId(noticeId);
		return notice;
	}

	@Override
	public void noticeBoardDelete(long noticeId) {

		noticeBoardMapper.noticeBoardDelete(noticeId);

	}

	@Override
	public void noticeBoardModifybyNoticeId(Notice notice) {
		noticeBoardMapper.noticeBoardModifybyNoticeId(notice);

	}

	

}
