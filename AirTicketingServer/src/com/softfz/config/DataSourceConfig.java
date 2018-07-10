package com.softfz.config;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * ���ݿ�������Ϣ�����࣬����������ȫ�ֵľ�̬�������ڴ�����ݿ�������Ϣ
 * @author Administrator
 *
 */
public class DataSourceConfig {
	/**
	 * ���ݿ�IP��ַ
	 */
	public static String ip = "127.0.0.1";
//	public static String ip;
	/**
	 * ���ݿ�˿�
	 */
	public static String port = "3306";
//	public static String port;
	/**
	 * ���ݿ�SID
	 */
	public static String sid = "mysql";
//	public static String sid;
	/**
	 * ���ݿ��ʺ�
	 */
	public static String user = "jn131201";
//	public static String user;
	/**
	 * ���ݿ�����
	 */
	public static String password = "jn131201";
//	public static String password;
	
	
	/**
	 * ����Դ
	 */
	private static DataSource dataSource; 
	
	
	
	/**
	 * ��ȡ����Դ�������ӳض���
	 * @return Java.sql.DataSource
	 */
	public static synchronized DataSource getDataSource(){
		if(dataSource == null){
			initialization();
		}
		return dataSource;
	}
	/**
	 * ��ʼ�����ݿ����ӳ�
	 */
	public static void initialization(){
		//1�����ж�dataSource�Ƿ�==null���ǣ��ȹر�
		//2��c3p0���ӳش���������DataSource
		if (dataSource != null) {
			//�ر�dataSource
			((ComboPooledDataSource) dataSource).close();
		}
		dataSource=new ComboPooledDataSource();
		try {
			((ComboPooledDataSource) dataSource).setDriverClass("com.mysql.cj.jdbc.Driver");
			((ComboPooledDataSource) dataSource).setJdbcUrl("jdbc:"+sid+"://"+ip+":"+port+"/airticket?characterEncoding=utf-8&serverTimezone=GMT&useSSL=false");
			((ComboPooledDataSource) dataSource).setUser(user);
			((ComboPooledDataSource) dataSource).setPassword(password);
			((ComboPooledDataSource) dataSource).setLoginTimeout(3000);
			((ComboPooledDataSource) dataSource).setMaxPoolSize(25);
		} catch (PropertyVetoException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	public static void closeDataSource() {
		if (dataSource != null) {
			//�ر�dataSource
			((ComboPooledDataSource) dataSource).close();
			dataSource=null;
		}
	}
	public static void main(String[] args) {
		DataSource dataSource = DataSourceConfig.getDataSource();
		Connection conn;
		try {
			conn = dataSource.getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
