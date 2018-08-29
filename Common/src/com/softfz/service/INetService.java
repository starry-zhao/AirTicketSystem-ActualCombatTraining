package com.softfz.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

import com.softfz.model.BounceRecord;
import com.softfz.model.Flight;
import com.softfz.model.NetDealer;
import com.softfz.model.Oiltax;
import com.softfz.model.PageModel;
import com.softfz.model.SaleRecord;
import com.softfz.model.SaleTotal;
import com.softfz.model.SalesTicketInfoShow;

/**
 * �ýӿڶ�������������ͻ��˵�ҵ���߼�����
 * @author Administrator
 *
 */
public interface INetService extends Remote {
	/**
	 * ������Ϣ���������˵���Ϣ��ʾ��
	 * @param str
	 * @throws RemoteException 
	 */
	public void showMsgToServer(String str) throws RemoteException;
	/**
	 * ������¼������������������ʺŻ�����������׳�RemoteException�쳣
	 * @param netcode
	 * @param password
	 * @return
	 */
	public NetDealer login(String netcode, String password) throws RemoteException;
	
	/**
	 * ������������Ƿ񱻶��ᣨ��������׳���������쳣��
	 * @param netcode
	 * @return
	 * @throws RemoteException
	 */
	public void checkIsLock(String netcode) throws RemoteException;
	/**
	 * �޸���������ĵ�½����
	 * @param netid
	 * @param passwordOld
	 * @param passwordNew
	 * @return 
	 * @throws RemoteException
	 */
	public Boolean updateNetClientPwd(int netid, String passwordOld, String passwordNew) throws RemoteException;	
	
	/**
	 * �����ѯ���ͻ��ڶ�Ʊ֮ǰ��ͨ�������ѯ���Һ�����Ϣ
	 * @param fromCity
	 * @param toCity
	 * @param planDate
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageModel<Flight> queryFlights(String fromCity,String toCity,
			Date planDate, int currentPage, int pageSize) throws RemoteException;
	/**
	 * ͨ�������ѯ֮��ͻ�ѡ��ָ���ĺ�����ж�Ʊʱ����
	 * @param flightid
	 * @return
	 */
	public Flight queryFlights(int flightid) throws RemoteException;
	
	/**
	 * ����ͻ��Ķ�Ʊ��Ϣ
	 * @param record
	 * @return
	 */
	public String saleTicket(SaleRecord record) throws RemoteException;
	
	/**
	 * ����ͻ�����Ʊ��¼
	 * @param record
	 * @return
	 */
	public String cancelTicket(BounceRecord record) throws RemoteException;
	
	/**
	 * ����ͻ���תǩ��¼��ע�⣺���˲��ˣ�������Ҫ����
	 * @param recordid
	 * @param newPlanDate
	 * @return
	 */
	public String changeTicketDate(int recordid, Date newPlanDate) throws RemoteException;
	
	/**
	 * �������������ۼ�¼��ѯ
	 * @param month
	 * @param flightno
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageModel<SaleTotal> queryMonthSale(int netid, String month, String flightno,
			int currentPage, int pageSize) throws RemoteException;
	
	/**
	 * ��ѯȼ��˰��Ϣ
	 * @return
	 */
	public Oiltax getOilTax() throws RemoteException;
	
	/**
	 * ��ѯ�ÿ͵Ķ�Ʊ��¼Ϊ��Ʊ��תǩʹ��
	 * @param fromCity
	 * @param toCity
	 * @param idcard
	 * @param planDate
	 * @return
	 */
	public SaleRecord getSaleRecord(int netid, String fromCity, String toCity,
			String idcard, java.sql.Date planDate) throws RemoteException;
	
	/**
	 * ���ݡ����֤�š��͡�Ʊ��״̬���������ʱ�䡱���ҷ������������ۼ�¼
	 * @param idCard
	 * @return
	 */
	public SaleRecord queryRecordForTicket(String idCard) throws RemoteException;
	
}
