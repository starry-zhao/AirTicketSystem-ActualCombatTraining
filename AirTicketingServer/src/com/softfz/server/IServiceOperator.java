package com.softfz.server;

import java.io.IOException;

/**
 * �ýӿڶ����˷�����������ϵͳ���ҵ���߼�
 * @author Administrator
 *
 */
public interface IServiceOperator {
	
	
	/**
	 * ����������
	 * @return 
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public boolean start();
	
	
	/**
	 * ֹͣ����
	 */
	public boolean stop();
	
	
	/**
	 * �޸ķ�����ͨ�Ŷ˿�
	 */
	public void updateNetPort(String rmiPort, String socketPort);
	
	
	/**
	 * ��ȡ�����ļ���ʼ��ͨѶ�˿�		//RMI�˿�
	 */
	public void initNetPort();
		
	
	/**
	 * �޸����ݿ�������Ϣ�����浽�����ļ���
	 */
	public void updateDbConfig(String ip, String port, String sid, String user,String password);
	
	
	/**
	 * ��ȡ�����ļ���ʼ�����ݿ����������Ϣ
	 */
	public void initDbConfig();
}
