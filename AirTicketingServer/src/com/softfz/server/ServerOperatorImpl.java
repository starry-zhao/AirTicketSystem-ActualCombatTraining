package com.softfz.server;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMISocketFactory;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.softfz.config.DataSourceConfig;
import com.softfz.config.DataSourceConfigFile;
import com.softfz.config.ServerConfig;
import com.softfz.io.ServerConfigFile;
import com.softfz.service.INetService;
import com.softfz.service.ISystemService;
import com.softfz.service.NetServiceImpl;
import com.softfz.service.SystemServiceImpl;
import com.softfz.utils.CheckUtil;

public class ServerOperatorImpl implements IServiceOperator{

	private static IServiceOperator instance = new ServerOperatorImpl();
	private static INetService netService;
	private static ISystemService systemService;
	private static Registry registry;  //ͬһ��������������ͣ
	
	
	private ServerOperatorImpl(){
		// 1��ע���Զ����RMI SOCKET FACTORY��ָ��ͨѶ�˿ڣ�����ǽҪ���Ÿö˿ڣ�����ֹ������ǽ����
		try {
			RMISocketFactory.setSocketFactory(new CustomerSocketFactory());
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	/**
	 * ����
	 * @return
	 */
	public static IServiceOperator getInstance(){
		return instance;
	}
	
	@Override
	public boolean start(){
		try {
			
			// 2.����RMI����ע��ͨѶ�˿�
			registry = LocateRegistry.createRegistry(6600);
			// 3.ʵ����ҵ�����
			netService = new NetServiceImpl();
			systemService=new SystemServiceImpl();
			// 4.��ҵ�����ע�ᵽRMI��������(��ע����ҵ�������
			Naming.rebind("rmi://"+ServerConfig.RMI_IP+":"+ServerConfig.RMI_PORT+"/netService", netService);
			Naming.rebind("rmi://"+ServerConfig.RMI_IP+":"+ServerConfig.RMI_PORT+"/systemService", systemService);
//			Naming.rebind(rmiHead+"netService", systemService);
			
			System.out.println("RMI������������");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean stop(){
		try {
			if (registry != null) {
				Naming.unbind("rmi://"+ServerConfig.RMI_IP+":"+ServerConfig.RMI_PORT+"/netService");
				Naming.unbind("rmi://"+ServerConfig.RMI_IP+":"+ServerConfig.RMI_PORT+"/systemService");
				UnicastRemoteObject.unexportObject(registry, true);
				registry = null;
				System.out.println("RMI������ֹͣ��");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public void updateNetPort(String rmiPort, String socketPort) {
		ServerConfig.RMI_PORT=rmiPort;
		ServerConfig.SERVER_CLIENT_PORT=socketPort;
	}

	@Override
	public void initNetPort() {
		ServerConfigFile.readServerConfig();
	}

	@Override
	public void updateDbConfig(String ip, String port, String sid, String user,
			String password) {
		DataSourceConfig.ip=ip;
		DataSourceConfig.port=port;
		DataSourceConfig.sid=sid;
		DataSourceConfig.user=user;
		DataSourceConfig.password=password;
		DataSourceConfigFile.saveDataSourceConfig();
		
	}

	@Override
	public void initDbConfig() {
		DataSourceConfigFile.readDataSourceConfig();
	}

	public static Registry getRegistry() {
		return registry;
	}

	public  void setRegistry(Registry registry) {
		ServerOperatorImpl.registry = registry;
	}

	
}
