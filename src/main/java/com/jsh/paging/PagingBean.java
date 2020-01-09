package com.jsh.paging;

/**
 * ?��?���? 로직?�� ?��?�� ?��?��?�� 
 * 
 * @author inst
 *
 */
public class PagingBean {
	/**
	 * �? 게시�? ?��
	 */
	private int totalContent;

	public int getNowPage() {
		return nowPage;
	}

	/**
	 * ?��?�� ?��?���? ?���?
	 */
	private int nowPage = 1;
	/**
	 * ?�� ?��?���??��?�� 보여�? 게시�? ?��
	 */
	private int numberOfContentPerPage = CommonConstants.CONTENT_NUMBER_PER_PAGE;
	/**
	 * ?�� ?��?���? 그룹?�� ?��?���? ?�� 
	 */
	private int numberOfPageGroup = CommonConstants.PAGEGROUP_NUMBER_PER_PAGE;

	/**
	 * PagingBean?�� ?��?�� ?��?���? 로직?�� ?��?��?���? ?��?��?��?��
	 * ?���? 게시�? ?��?? ?��?�� ?��?���? ?��버�?? ?��?���? ?��?��. 
	 * @param totalContent
	 * @param nowPage
	 */
	public PagingBean(int totalContent, int nowPage) {
		super();
		this.totalContent = totalContent;
		this.nowPage = nowPage;
	}

	/**
	 * �? ?��?���? ?�� 리턴  
	 * ex) 총게?���? ?�� - 15 �? , ?��?��면에?�� 보여�? 게시�? ?�� - 5�? 
	 *      몇페?���? ? �? 3 ?��?���? 
	 *      16개면 �? 4?��?���? 
	 *  총게?��물수 % ?��?��?���??�� 보여�? 게시물수 
	 *  0 ?���? ?��?�� �?
	 *  0 ?�� ?��?���? ?��?�� �? + 1   
	 * @return
	 */
	public int getTotalPage() {
		int num = totalContent % this.numberOfContentPerPage;
		int totalPage = 0;
		if (num == 0)
			totalPage = totalContent / this.numberOfContentPerPage;
		else
			totalPage = totalContent / this.numberOfContentPerPage + 1;
		return totalPage;
	}

	/**
	 * ?���? ?��?���? 그룹?�� 리턴 
	 * ex) �? 게시�? ?�� 23�? - 총페?���??��?5?��?���?   총페?���?그룹?��?2그룹
	 * 총페?���??�� % Page Group ?�� ?��?���? ?�� 
	 * --> 0?���? ?��?���? 
	 * --> 0?�� ?��?���? ?��?���?+1  
	 * 
	 * @return
	 */
	public int getTotalPageGroup() {
		int num = this.getTotalPage() % this.numberOfPageGroup;
		int totalGroup = 0;
		if (num == 0)
			totalGroup = this.getTotalPage() / this.numberOfPageGroup;
		else
			totalGroup = this.getTotalPage() / this.numberOfPageGroup + 1;
		return totalGroup;
	}

	/**
	 * ?��?�� ?��?���?�? ?��?�� ?��?���? 그룹 번호�? 리턴 
	 * ?��?�� ?��?���? % Page 그룹?�� ?��?���? ?�� 
	 * 0 -> ?��?�� 값이 ?��?���? 그룹 번호 
	 * 0 ?�� ?��?���? ?��?�� �? + 1 
	 * @return
	 */
	public int getNowPageGroup() {
		int num = this.nowPage % this.numberOfPageGroup;
		int nowGroup = 0;
		if (num == 0)
			nowGroup = this.nowPage / this.numberOfPageGroup;
		else
			nowGroup = this.nowPage / this.numberOfPageGroup + 1;
		return nowGroup;
	}

	/**
	 * ?��?�� ?��?���?�? ?��?�� ?��?���? 그룹?�� ?��?�� ?��?���? 번호�? 리턴 
	 * PageGroup?�� ?��?���? ?�� * (?��?�� ?��?���? 그룹-1) + 1 
	 * ?�� ?��?���? 그룹?�� 마�?�? 번호 + 1 ?�� 결국 ?��?�� ?��?���?�? ?��?�� 
	 * @return
	 */
	public int getStartPageOfPageGroup() {
		// ?��?�� ?��?���? 그룹?�� 마�?�? ?��?���? 번호+1?���? ?��?�� ?��?���?�? ?��
		int start = this.numberOfPageGroup * (this.getNowPageGroup() - 1) + 1;
		return start;
	}

	/**
	 * ?��?�� ?��?���?�? ?��?�� ?��?���? 그룹?�� 마�?�? ?��?���? 번호�? 리턴 
	 * ?��?�� ?��?���? 그룹 * ?��?���? 그룹?�� ?��?���? ?�� 
	 * 만약 ?���? ?��?���? ?��보다 ?��?�� 값보?�� ?�� 경우 
	 * ?���? ?��?���? ?���? 마�?�? ?��?���? 번호�? ?��?��.
	 * @return
	 */
	public int getEndPageOfPageGroup() {
		int end = this.numberOfPageGroup * this.getNowPageGroup();
		if (end > this.getTotalPage()) {
			end = this.getTotalPage();
		}
		return end;
	}

	/**
	 * ?��?�� ?��?���? 그룹?�� ?��?���? ?��?��?��?�� ?��?���? true ?��?���? false 
	 * ?��?�� ?��?���? 그룹?�� 1보다 ?���? true 
	 * @return
	 */
	public boolean isPreviousPageGroup() {
		boolean flag = false;
		if (this.getNowPageGroup() > 1)
			flag = true;
		return flag;
	}

	/**
	 * ?��?�� ?��?���? 그룹?�� ?��?�� �? ?��?�� 
	 * ?��?�� ?��?���? 그룹?�� ?���? ?��?���? 그룹 ?��보다 ?��?���? true
	 * 
	 * @return
	 */
	public boolean isNextPageGroup() {
		boolean flag = false;
		if (this.getNowPageGroup() < this.getTotalPageGroup())
			flag = true;
		return flag;
	}

	public static void main(String args[]) {
		PagingBean bean = new PagingBean(26, 6);
		System.out.println(bean.getTotalPage() + "?��?���?");
		System.out.println(bean.getTotalPageGroup() + "?��?���? 그룹");
		System.out.println(bean.getNowPageGroup() + " ?��?�� ?��?���? 그룹");
	}
}
