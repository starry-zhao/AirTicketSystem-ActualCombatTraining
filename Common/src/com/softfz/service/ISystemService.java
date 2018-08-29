package com.softfz.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.softfz.model.Dirctory;
import com.softfz.model.Discount;
import com.softfz.model.Flight;
import com.softfz.model.FlightSaleTotal;
import com.softfz.model.FlightStop;
import com.softfz.model.NetDealer;
import com.softfz.model.NetSaleTotal;
import com.softfz.model.Oiltax;
import com.softfz.model.PageModel;
import com.softfz.model.SystemUser;
/**
 * �ýӿڶ�������������ͻ��˵�ҵ���߼�����,�ýӿ�����Ƶ�SystemUser������ɴ�E-Rͼ��������ص�ʵ�����NetSaleTotal��FlightSaleTotalΪ����������ͳ���Լ�����������ͳ�ƣ����������Ϊ��������ͳ�Ʋ�ѯ��Ҫ��ʾ��������ƶ��ɣ��ɲο�����������ͳ���е�SaleTotal��
 * @author Administrator
 *
 */
public interface ISystemService extends Remote {
	/**
	 * ������Ϣ���������˵���Ϣ��ʾ��
	 * @param str
	 * @throws RemoteException 
	 */
	public void showMsgToServer(String str) throws RemoteException;	
	/**
	 * ������¼�����ع���Աʵ������ʺŻ�����������׳�RemoteException�쳣
	 * @param username
	 * @param password
	 * @return
	 */
	public SystemUser login(String username, String password)throws RemoteException;
	
	
	/**
	 * �������������׳��������RemoteException
	 * @param username
	 * @param oldpassword
	 * @param password
	 * @return 
	 */
	public Boolean updatePassword(String username, String oldpassword,
			String password) throws RemoteException;
	
	
	/**
	 * ����ʺ������׳�����RemoteException
	 * @param user
	 * @return 
	 */
	public boolean addSystemUser(String username, String password, String email, String realname, String telephone) throws RemoteException;
	
	/**
	 * ���ݴ����SystemUser����ȥ���±��е���Ϣ
	 * @param systemUser
	 * @return 
	 * @throws RemoteException
	 */
	public boolean modifySystemUser(SystemUser systemUser) throws RemoteException;
	
	
	/**
	 * ����Ա�б��ҳ��ѯ
	 * @param username
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageModel<SystemUser> queryAllSystemUser(String username,
			int currentPage, int pageSize) throws RemoteException;
	
	
	/**
	 * ���ù���Ա������Ϊ��ʼ����888888
	 * @param userids
	 */
	public void resetPassword(List<Integer> userids) throws RemoteException;
	
	
	/**
	 * �������Ա�ʺ�
	 * @param userids
	 */
	public void lockSystemUser(List<Integer> userids) throws RemoteException;
	
	/**
	 * ������Ա�˺��Ƿ񱻶��ᣨ��������׳���������쳣��
	 * @param netcode
	 * @return
	 * @throws RemoteException
	 */
	public void checkIsLock(String netcode) throws RemoteException;
	
	
	/**
	 * ͨ������JavaBean���������Ա�˺�
	 * @param systemUser
	 * @throws RemoteException
	 */
	public void lockSystemUser(SystemUser systemUser) throws RemoteException;
	
	
	/**
	 * �������Ĺ���Ա�ʺ�
	 * @param userids
	 */
	public void unlockSystemuser(List<Integer> userids) throws RemoteException;
	
	/**
	 * ͨ������JavaBean���ⶳ����Ա�˺�
	 * @param systemUser
	 * @throws RemoteException
	 */
	public void unlockSystemUser(SystemUser systemUser) throws RemoteException;
	
	/**
	 * �����û�������ϵͳ����Ա��Ϣ
	 * @param username
	 * @return
	 * @throws RemoteException
	 */
	public SystemUser querySystemUser(String username) throws RemoteException;
	
	/**
	 * ���������ѯ
	 * @param netcode
	 * @param netname
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageModel<NetDealer> queryAllDealer(String netcode,
			String netname, int currentPage, int pageSize) throws RemoteException;
	
	
	/**
	 * �������������Ϣ
	 * @param dealer
	 * @return 
	 */
	public boolean addNetDealer(int userid, String netcode, String netname, String password,
			String director, String telephone, String state, String address) throws RemoteException;
	
	
	/**
	 * �����������������Ϊ123456
	 * @param netids
	 * @throws RemoteException,Exception 
	 */
	public void resetNetPassword(int netid, String passwordOld) throws RemoteException, RemoteException,Exception;
//	public void resetNetPassword(List<Integer> netids) throws RemoteException;
	
	
	
	/**
	 * ������������
	 * @param netids
	 */
	public void lockNet(int netid) throws RemoteException;
//	public void lockNet(List<Integer> netids) throws RemoteException;
	
	
	/**
	 * ����������������
	 * @param netids
	 */
	public void unlockNet(int netid) throws RemoteException;
//	public void unlockNet(List<Integer> netids) throws RemoteException;
	
	
	/**
	 * ��Ӻ�����Ϣ
	 * @param flight
	 */
	public int addFlight(Flight flight) throws RemoteException;
	
	
	/**
	 * ��ѯ������Ϣ
	 * @param flightno
	 * @param fromCity
	 * @param toCity
	 * @param type
	 * @param isstop
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageModel<Flight> queryFlights(String flightno, String fromCity,
			String toCity, int type, int isstop, int currentPage, int pageSize)
			 throws RemoteException;
	
	
	/**
	 * ����ۿ���Ϣ
	 * @param discount
	 * @throws Exception 
	 */
	public void addDiscount(Discount discount) throws RemoteException, Exception;
	
	
	/**
	 * ����ȼ��˰
	 * @param oiltax
	 */
	public void setOilTax(Oiltax oiltax) throws RemoteException;
	
	/**
	 * ��ȡȼ��˰
	 * @return
	 * @throws RemoteException
	 */
	public Oiltax getOilTax() throws RemoteException;
	
	/**
	 * ��ѯ������Ϣ
	 * @return
	 */
	public List<Dirctory> getAllAirPorts() throws RemoteException;
	
	
	/**
	 * ��ѯ���չ�˾��Ϣ
	 * @return
	 */
	public List<Dirctory> getAllAirLines() throws RemoteException;
	
	
	/**
	 * ��������������࣬����Ȼ�»���ͳ�Ƹ�������������������
	 * @param netcode
	 * @param month
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageModel<NetSaleTotal> queryNetSaleTotal(String netcode, String month,
			int currentPage, int pageSize) throws RemoteException;
	
	
	/**
	 * ��������ͳ�ƣ���������࣬����Ȼ�»���ͳ����������������������
	 * @param flightno
	 * @param month
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageModel<FlightSaleTotal> queryFlightSaleTotal(String flightno,
			String month, int currentPage, int pageSize) throws RemoteException;
	
	public void lockFlight(int flightId) throws RemoteException;

	public int getDicID(String dicName) throws RemoteException;

	/**
	 * �������ྭͣ��Ϣ
	 * @param flightStop
	 * @return 
	 * @throws RemoteException
	 */
	public boolean addFlightStop(FlightStop flightStop) throws RemoteException;
	
	/**
	 * ���ݺ����Ų�ѯ������Ϣ
	 * @param flightno
	 * @return
	 * @throws RemoteException
	 */
	public Flight queryFlight(String flightno) throws RemoteException;
	
	/**
	 * ���ݺ���ID��ѯ������Ϣ
	 * @param flightno
	 * @return
	 * @throws RemoteException
	 */
	public Flight queryFlight(int flightid) throws RemoteException;
	
	/**
	 * ��ѯ�����ۿ�
	 * @param flightid
	 * @return
	 * @throws RemoteException
	 */
	public Discount queryDiscount(int flightid, String DiscountDate) throws RemoteException;
	
	
}
