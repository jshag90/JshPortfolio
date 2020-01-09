package com.jsh.paging;

/**
 * ?˜?´ì§? ë¡œì§?„ ?œ„?•œ ?´?˜?Š¤ 
 * 
 * @author inst
 *
 */
public class PagingBean {
	/**
	 * ì´? ê²Œì‹œë¬? ?ˆ˜
	 */
	private int totalContent;

	public int getNowPage() {
		return nowPage;
	}

	/**
	 * ?˜„?¬ ?˜?´ì§? ?„˜ë²?
	 */
	private int nowPage = 1;
	/**
	 * ?•œ ?˜?´ì§??—?„œ ë³´ì—¬ì¤? ê²Œì‹œë¬? ?ˆ˜
	 */
	private int numberOfContentPerPage = CommonConstants.CONTENT_NUMBER_PER_PAGE;
	/**
	 * ?•œ ?˜?´ì§? ê·¸ë£¹?‚´ ?˜?´ì§? ?ˆ˜ 
	 */
	private int numberOfPageGroup = CommonConstants.PAGEGROUP_NUMBER_PER_PAGE;

	/**
	 * PagingBean?„ ?†µ?•´ ?˜?´ì§? ë¡œì§?„ ? •?˜?•˜ê¸? ?œ„?•´?„œ?Š”
	 * ? „ì²? ê²Œì‹œë¬? ?ˆ˜?? ?˜„?¬ ?˜?´ì§? ?„˜ë²„ë?? ?•„?š”ë¡? ?•œ?‹¤. 
	 * @param totalContent
	 * @param nowPage
	 */
	public PagingBean(int totalContent, int nowPage) {
		super();
		this.totalContent = totalContent;
		this.nowPage = nowPage;
	}

	/**
	 * ì´? ?˜?´ì§? ?ˆ˜ ë¦¬í„´  
	 * ex) ì´ê²Œ?‹œë¬? ?ˆ˜ - 15 ê°? , ?•œ?™”ë©´ì—?„œ ë³´ì—¬ì§? ê²Œì‹œë¬? ?ˆ˜ - 5ê°? 
	 *      ëª‡í˜?´ì§? ? ì´? 3 ?˜?´ì§? 
	 *      16ê°œë©´ ì´? 4?˜?´ì§? 
	 *  ì´ê²Œ?‹œë¬¼ìˆ˜ % ?•œ?˜?´ì§??— ë³´ì—¬ì§? ê²Œì‹œë¬¼ìˆ˜ 
	 *  0 ?´ë©? ?‚˜?ˆˆ ê°?
	 *  0 ?´ ?•„?‹ˆë©? ?‚˜?ˆˆ ê°? + 1   
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
	 * ? „ì²? ?˜?´ì§? ê·¸ë£¹?ˆ˜ ë¦¬í„´ 
	 * ex) ì´? ê²Œì‹œë¬? ?ˆ˜ 23ê°? - ì´í˜?´ì§??ˆ˜?5?˜?´ì§?   ì´í˜?´ì§?ê·¸ë£¹?ˆ˜?2ê·¸ë£¹
	 * ì´í˜?´ì§??ˆ˜ % Page Group ?‚´ ?˜?´ì§? ?ˆ˜ 
	 * --> 0?´ë©? ?‚˜?ˆˆê°? 
	 * --> 0?´ ?•„?‹ˆë©? ?‚˜?ˆˆê°?+1  
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
	 * ?˜„?¬ ?˜?´ì§?ê°? ?†?•œ ?˜?´ì§? ê·¸ë£¹ ë²ˆí˜¸ë¥? ë¦¬í„´ 
	 * ?˜„?¬ ?˜?´ì§? % Page ê·¸ë£¹?‚´ ?˜?´ì§? ?ˆ˜ 
	 * 0 -> ?‚˜?ˆˆ ê°’ì´ ?˜?´ì§? ê·¸ë£¹ ë²ˆí˜¸ 
	 * 0 ?´ ?•„?‹ˆë©? ?‚˜?ˆˆ ê°? + 1 
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
	 * ?˜„?¬ ?˜?´ì§?ê°? ?†?•œ ?˜?´ì§? ê·¸ë£¹?˜ ?‹œ?‘ ?˜?´ì§? ë²ˆí˜¸ë¥? ë¦¬í„´ 
	 * PageGroup?‚´ ?˜?´ì§? ?ˆ˜ * (?˜„?¬ ?˜?´ì§? ê·¸ë£¹-1) + 1 
	 * ? „ ?˜?´ì§? ê·¸ë£¹?˜ ë§ˆì?ë§? ë²ˆí˜¸ + 1 ?´ ê²°êµ­ ?‹œ?‘ ?˜?´ì§?ê°? ?œ?‹¤ 
	 * @return
	 */
	public int getStartPageOfPageGroup() {
		// ?´? „ ?˜?´ì§? ê·¸ë£¹?˜ ë§ˆì?ë§? ?˜?´ì§? ë²ˆí˜¸+1?•˜ë©? ?‹œ?‘ ?˜?´ì§?ê°? ?¨
		int start = this.numberOfPageGroup * (this.getNowPageGroup() - 1) + 1;
		return start;
	}

	/**
	 * ?˜„?¬ ?˜?´ì§?ê°? ?†?•œ ?˜?´ì§? ê·¸ë£¹?˜ ë§ˆì?ë§? ?˜?´ì§? ë²ˆí˜¸ë¥? ë¦¬í„´ 
	 * ?˜„?¬ ?˜?´ì§? ê·¸ë£¹ * ?˜?´ì§? ê·¸ë£¹?‚´ ?˜?´ì§? ?ˆ˜ 
	 * ë§Œì•½ ? „ì²? ?˜?´ì§? ?ˆ˜ë³´ë‹¤ ?œ„?˜ ê°’ë³´?‹¤ ?´ ê²½ìš° 
	 * ? „ì²? ?˜?´ì§? ?ˆ˜ê°? ë§ˆì?ë§? ?˜?´ì§? ë²ˆí˜¸ê°? ?œ?‹¤.
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
	 * ?´? „ ?˜?´ì§? ê·¸ë£¹?´ ?ˆ?Š”ì§? ?™•?¸?•˜?—¬ ?ˆ?œ¼ë©? true ?—†?œ¼ë©? false 
	 * ?˜„?¬ ?˜?´ì§? ê·¸ë£¹?´ 1ë³´ë‹¤ ?¬ë©? true 
	 * @return
	 */
	public boolean isPreviousPageGroup() {
		boolean flag = false;
		if (this.getNowPageGroup() > 1)
			flag = true;
		return flag;
	}

	/**
	 * ?‹¤?Œ ?˜?´ì§? ê·¸ë£¹?´ ?ˆ?Š” ì§? ?™•?¸ 
	 * ?˜„?¬ ?˜?´ì§? ê·¸ë£¹?´ ? „ì²? ?˜?´ì§? ê·¸ë£¹ ?ˆ˜ë³´ë‹¤ ?‘?œ¼ë©? true
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
		System.out.println(bean.getTotalPage() + "?˜?´ì§?");
		System.out.println(bean.getTotalPageGroup() + "?˜?´ì§? ê·¸ë£¹");
		System.out.println(bean.getNowPageGroup() + " ?˜„?¬ ?˜?´ì§? ê·¸ë£¹");
	}
}
