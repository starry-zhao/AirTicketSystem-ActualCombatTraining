package com.softfz.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ���ฺ�𱣴����ݿ���ص�������Ϣ�������ļ���
 * @author Administrator
 *
 */
public class DataSourceConfigFile {
	private static final String DATASOURCE_CONFIG_FILE = "config/datasource.properties";
	/**
	 * ��ȡ���ݿ�������Ϣ�����ļ�������Ϣ�����DataSourceConfig��
	 */
	public static void readDataSourceConfig(){
		//TODO:
		try {
			FileInputStream fileInputStream=new FileInputStream(DATASOURCE_CONFIG_FILE);
			Properties properties=new Properties();
			properties.load(fileInputStream);
			DataSourceConfig.ip=properties.getProperty("ip");
			DataSourceConfig.password=properties.getProperty("password");
			DataSourceConfig.sid=properties.getProperty("sid");
			DataSourceConfig.user=properties.getProperty("user");
			DataSourceConfig.port=properties.getProperty("port");
			
		} 
		catch (FileNotFoundException fileNotFoundException) {
			// TODO Auto-generated catch block
			fileNotFoundException.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ��DataSourceConfig�ж�ȡ������Ϣ���浽�����ļ���
	 */
	public static void saveDataSourceConfig(){
		//TODO:
		try {
			FileOutputStream fileOutputStream=new FileOutputStream(DATASOURCE_CONFIG_FILE);
			Properties properties=new Properties();
			properties.setProperty("sid", DataSourceConfig.sid);
			properties.setProperty("user", DataSourceConfig.user);
			properties.setProperty("port", DataSourceConfig.port);
			properties.setProperty("password", DataSourceConfig.password);
			properties.setProperty("ip", DataSourceConfig.ip);
			properties.store(fileOutputStream, DATASOURCE_CONFIG_FILE);
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	
	public static void main(String[] args) {
		saveDataSourceConfig();
	}
}
