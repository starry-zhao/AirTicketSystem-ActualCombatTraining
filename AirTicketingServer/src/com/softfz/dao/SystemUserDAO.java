package com.softfz.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.softfz.config.DataSourceConfig;
import com.softfz.jdbc.JdbcOperator;
import com.softfz.jdbc.JdbcOperatorImpl;
import com.softfz.model.PageModel;
import com.softfz.model.SystemUser;

public class SystemUserDAO {
	private JdbcOperator jdbcOperator;

	public SystemUserDAO() {
		DataSource dataSource = DataSourceConfig.getDataSource();
		jdbcOperator = new JdbcOperatorImpl(dataSource);
	}
	
	/**
	 * ��ѯ����Ա��״̬
	 * @param netcode
	 * @return
	 */
	public String queryState(String username){
		return null;
	}
	
	/**
	 * ͨ���û������û���������Ϣ����װ��SystemUser������
	 * @param username
	 * @return
	 */
	public SystemUser getSystemUserByUsername(String username){
		if (username==null||username==""||username.length()==0) {
			return null;
		}
		String sql="SELECT * FROM airticket.systemuser where username=?";
		return (SystemUser) jdbcOperator.queryForJavaBean(sql,SystemUser.class,username);
	}
	/**
	 * ͨ���û��������뷵�ظ��û���������Ϣ����װ��SystemUser������
	 * @param username
	 * @return
	 */
	public SystemUser getSystemUserByUsername(String username,String password){
		SystemUser systemUser=null;
		String sql="SELECT * FROM airticket.systemuser where username=? and password=?";
		systemUser=(SystemUser) jdbcOperator.queryForJavaBean(sql,SystemUser.class,username,password);
		return systemUser;
	}
	
	/**
	 * �޸�ϵͳ������û�����
	 * @param netid
	 * @param passwordOld
	 * @param passwordNew
	 */
	public boolean updateSystemUser(String username, String passwordOld, String passwordNew){
		String sql="SELECT * FROM airticket.systemuser where username=? and password=?";
		SystemUser systemUser=(SystemUser) jdbcOperator.queryForJavaBean(sql,SystemUser.class,username,passwordOld);
		if (systemUser==null) {
			return false;
		}
		sql="UPDATE airticket.systemuser SET password=? WHERE userid=?;";
		int result=jdbcOperator.queryForInt(sql, passwordNew,systemUser.getUserid());
		if (result>0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * ����������û�
	 * @param netid
	 * @param passwordOld
	 * @param passwordNew
	 */
	public int addSystemUser(String username, String password, String email, String realname, String telephone){
		//ȡ����
		//����������
		//��װ������List��
		//����JDBC����֮
		//jdbcOperator.update(sql,parameterList);
		//û���������
		String sql="INSERT INTO airticket.systemuser(username,password,email,state,realname,telephone) VALUES (?,?,?,?,?,?);";
		int result=jdbcOperator.queryForInt(sql, username,password,email,"0",realname,telephone);
		return result;
	}
	
	/**
	 * �޸Ĺ���Ա
	 * @param systemUser
	 */
	public boolean modifySystemUserByJavaBean(SystemUser systemUser){
		//����������
		//��װ������List��
		//����JDBC����֮
		//jdbcOperator.update(sql,parameterList);
		String sql="UPDATE airticket.systemuser SET username=?,password=?,email=?,state=?,realname=?,telephone=? where userid=?;";
		int result=jdbcOperator.queryForInt(sql, systemUser.getUsername(),systemUser.getPassword(),
				systemUser.getEmail(),systemUser.getState(),systemUser.getRealname(),
				systemUser.getTelephone(),systemUser.getUserid());
		if (result>0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * ��������ϵͳ����Ա
	 * @param systemUser
	 */
	public void lockAndUnlockSystemUserByJavaBean(SystemUser systemUser){
		
	}
	
	/**
	 * ���ҷ�ҳ������Ա����
	 * @param username
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageModel<SystemUser> querySystemUser(String username,
			int currentPage, int pageSize){		
		String sql;
		List<SystemUser> list;
		if (username==null||username.length()==0||username=="") {
			sql="SELECT * FROM airticket.systemuser;";
			list=jdbcOperator.queryForJavaBeanList(sql, SystemUser.class);
		}else {
			sql="SELECT * FROM airticket.systemuser where username=?;";
			list=jdbcOperator.queryForJavaBeanList(sql, SystemUser.class,username);
		}
		
		PageModel<SystemUser> pageModel=new PageModel<SystemUser>();
		pageModel.setAllCount(list.size());
		pageModel.setCurrentPage(currentPage);
		pageModel.setPageSize(pageSize);
		List<SystemUser> systemUsers=new ArrayList<SystemUser>();
		for(int i=1+(currentPage-1)*pageSize;i<=pageSize+(currentPage-1)*pageSize;i++){
			if (list.size()<i) {
				break;
			}
			SystemUser systemUser=list.get(i-1);
			systemUsers.add(systemUser);
		}
		pageModel.setResult(systemUsers);
		return pageModel;
	}
	
	public static void main(String[] args) {
		SystemUserDAO systemUserDAO=new SystemUserDAO();
		systemUserDAO.updateSystemUser("zhaoda", "888888", "999999");
		System.out.println(systemUserDAO.getSystemUserByUsername("zhaoda").toString());
	}
	
}
