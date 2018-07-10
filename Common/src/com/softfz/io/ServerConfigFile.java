package com.softfz.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.softfz.config.ServerConfig;



/**
 * ���ฺ�𱣴������ͨѶ�˿��Լ�IP��ַ�������ļ���
 * @author Administrator
 *
 */
public class ServerConfigFile {
	private static final String SERVER_PORT_CONFIG = "config/server.properties";
	
	private ServerConfigFile(){
		
	}
	
	/**
	 * ��ȡ�����ļ���ServerConfig��
	 */
	public static void readServerConfig(){
		//TODO��2018-6-13
		try {
			FileInputStream fileInputStream=new FileInputStream(SERVER_PORT_CONFIG);
			Properties properties=new Properties();
			properties.load(fileInputStream);
			ServerConfig.RMI_PORT=properties.getProperty("RMI_PORT");
			ServerConfig.SERVER_CLIENT_PORT=properties.getProperty("SERVER_CLIENT_PORT");
			ServerConfig.RMI_IP=properties.getProperty("RMI_IP");
			
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
	 * ��ServerConfig�ж�ȡ������Ϣ,���������ͨѶ��Ϣ�������ļ���
	 */
	public static void saveServerConfig(){
		//TODO��2018-6-13����ServerConfig.***�������浽�����ļ�
		try {
			FileOutputStream fileOutputStream=new FileOutputStream(SERVER_PORT_CONFIG);
			Properties properties=new Properties();
			properties.setProperty("RMI_IP", ServerConfig.RMI_IP);
			properties.setProperty("SERVER_CLIENT_PORT", ServerConfig.SERVER_CLIENT_PORT);
			properties.setProperty("RMI_PORT", ServerConfig.RMI_PORT);
			properties.store(fileOutputStream, SERVER_PORT_CONFIG);
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
