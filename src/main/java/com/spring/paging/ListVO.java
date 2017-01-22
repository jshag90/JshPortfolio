package com.spring.paging;

import java.util.List;

import com.spring.seminar.dto.Board;

/**
 * 게시물 리스트 정보와 페이징 정보를 가지고 있는 클래스
 * 
 * @author inst
 *
 */
public class ListVO {
	private List<Board> list;
	private PagingBean pagingBean;

	public ListVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListVO(List<Board> list, PagingBean pagingBean) {
		super();
		this.list = list;
		this.pagingBean = pagingBean;
	}

	public List<Board> getList() {
		return list;
	}

	public void setList(List<Board> list) {
		this.list = list;
	}

	public PagingBean getPagingBean() {
		return pagingBean;
	}

	public void setPagingBean(PagingBean pagingBean) {
		this.pagingBean = pagingBean;
	}

	@Override
	public String toString() {
		return "ListVO [list=" + list + ", pagingBean=" + pagingBean + "]";
	}

}
