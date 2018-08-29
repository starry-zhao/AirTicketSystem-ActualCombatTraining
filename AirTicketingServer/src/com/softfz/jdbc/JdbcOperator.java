package com.softfz.jdbc;

import java.util.List;

import com.softfz.model.PageModel;
import com.softfz.model.SystemUser;

public interface JdbcOperator {
	
	/**
	 * ��ѯSQL��䷵��һ�����͵Ľ��
	 * @param sql ��ѯ���
	 * @param params ����ж�Ӧ�Ĳ���
	 * @return ��ѯ���
	 */
	public int queryForInt(String sql, Object...params);
	
	/**
	 * ��ѯSQL��䷵��һ�������͵Ľ��
	 * @param sql ��ѯ���
	 * @param params ����ж�Ӧ�Ĳ���
	 * @return
	 */
	public long queryForLong(String sql, Object...params);
	
	public Object queryForJavaBean(String sql, Class javaBeanClass, Object...params);
	
	/**
	 * insert��delete��update����
	 * @param sql
	 * @param params
	 * @return
	 */
	public int update(String sql, Object...params);
	
	/**
	 * insert��delete��update����
	 * @param sql
	 * @param list
	 * @return
	 */
	public int update(String sql, List list);
	
	public List queryForJavaBeanList(String sql, Class javaBeanClass, Object...params);
	
	public PageModel queryPageModel(int currentPage, int pageSize, StringBuilder querySql,
			StringBuilder countSql, StringBuilder whereSql, List paramList,
			Class javaBeanType);
	
	//����Ψһֵ
	public Object queryOneValue(String sql,Object... params);	
}
