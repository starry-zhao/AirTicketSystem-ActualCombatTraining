package com.softfz.model;

import java.io.Serializable;
import java.util.List;

public class PageModel<T> implements Serializable{
	/**
	 * ��ҳ����ģ��
	 */
	private static final long serialVersionUID = -59432160528478346L;
	public int DEFAULT_PAGESIZE = 5;//Ĭ��ÿҳ��ʾ��Ŀ
	private int currentPage = 1; //��ǰҳ
	private int pageSize = DEFAULT_PAGESIZE;//ÿҳ��ʾ����
	private int allCount;//�ܼ�¼��
	private List<T> result;//��ŷ�ҳ�����Ҫ��ʾ�ļ�¼����
	/**
	 * ͨ���ܼ�¼����ÿҳ��ʾ��Ŀ������ҳ��
	 * @return
	 */
	public int getAllPage(){
		return (this.allCount - 1) / this.pageSize + 1;
	}	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getAllCount() {
		return allCount;
	}
	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}
	public List<T> getResult() {
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}
	
	
}
