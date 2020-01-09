package com.jsh.paging;

import java.util.List;

import com.jsh.portfolio.dto.Board;

/**
 * ê²Œì‹œë¬? ë¦¬ìŠ¤?Š¸ ? •ë³´ì? ?˜?´ì§? ? •ë³´ë?? ê°?ì§?ê³? ?ˆ?Š” ?´?˜?Š¤
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
