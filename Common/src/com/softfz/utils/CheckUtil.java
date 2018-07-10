package com.softfz.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * ��Ϣ���
 * 
 * @author Administrator
 * 
 */
public class CheckUtil {
	/**
	 * У����ȷ
	 */
	public static final int OK = 999;
	
	
	/**
	 * ���²��ܳ��� 6λ �� 201308
	 */
	private static final int YEAR_LONG =-501;
	/**
	 * ���²��ܺ�����ĸ�������ַ�
	 */
	private static final int YEAR_ERROR =-502;
	/**
	 * �·�Ҫ��1~12֮��
	 */
	private static final int YEAR_FARMOT =-503;
	/**
	 * ��¼ID����Ϊ��
	 */
	public static final int ID_NOT_NULL = -200;
	/**
	 * �ʺ�Ҫ�����ֺ���ĸ��ϳ���Ϊ8λ
	 */
	public static final int ID_ERROR = -201;

	/**
	 * ���벻��Ϊ��
	 */
	public static final int PWD_NOT_NULL = -110;
	/**
	 * �����ʽ�����賤��3~16λ����ĸ�����ֺ�_���������
	 */
	public static final int PWD_ERROR = -111;
	/**
	 * �����벻���
	 */
	public static final int TWOPWD_ERROR = -120;

	/**
	 * IP��ַ����Ϊ��
	 */
	public static final int IP_NOT_NULL = -180;
	/**
	 * IP��ַ��ʽ����
	 */
	public static final int IP_ERROR = -181;
	/**
	 * IP��ַ��ֵ̫�󣬱�����0~255֮��
	 */
	public static final int IP_NUM_TOO_LARGE = -182;
	/**
	 * IP��ַ��ֵ̫С��������0~255֮��
	 */
	public static final int IP_NUM_TOO_SMALL = -183;

	/**
	 * �˿ںŲ���Ϊ��
	 */
	public static final int PORT_NOT_NULL = -190;
	/**
	 * �˿ںŸ�ʽ����
	 */
	public static final int PORT_ERROR = -191;
	/**
	 * �˿ںŵ�ֵ̫С��������1024~65535֮��
	 */
	public static final int PORT_NULL_TOO_SMALL = -192;
	/**
	 * �˿ںŵ�ֵ̫�󣬱�����1024~65535֮��
	 */
	public static final int PORT_NULL_TOO_LARGE = -193;

	/**
	 * �û�����ʵ��������Ϊ��
	 */
	public static final int CUSTNAME_NOT_NULL = -100;
	/**
	 * ��ʵ����������2~10֮�������
	 */
	public static final int CUSTNAME_ERROR = -101;
    /**
     * �绰����Ϊ��
     */
	private static final int PHONE_NOT_NULL = -230;
	/**
	 * �绰���벻��
	 */
	private static final int PHONE_NOT_ENOUGH = -231;
	/**
	 * �绰�������
	 */
	private static final int PHONE_ERROR = -232;
	/**
	 * ���֤����Ϊ��
	 */
	private static final int IDCARD_NOT_NULL = -241;
	/**
	 * ���֤����
	 */
	private static final int IDCARD_NOT_ENOUGH = -242;
	/**
	 * ���֤�������
	 */
	private static final int IDCARD_ERROR = -243;

	/**
	 * ��ַ����Ϊ��
	 */
	public static final int ADDRESS_NOT_NULL = -140;
	/**
	 * ��ַ������50λ
	 */
	public static final int ADDRESS_TOO_LONG = -141;

	/**
	 * ���䲻�ܲ���
	 */
	public static final int EMAIL_NOT_NULL = -300;
	/**
	 * �������
	 */
	public static final int EMAIL_ERROR = -301;
	/**
	 * ʱ�䲻��Ϊ��
	 */
	private static final int  TIME_NO_NULL =-401;
	/**
	 * ʱ�䳬����5λ
	 */
	private static final int TIME_LONG_ERRER=-402;
	/**
	 * ʱ��Сʱ��Ҫ��0~59֮��
	 */
	private static final int TIME_MI_OUT=-403;
	/**
	 *  ʱ�������Ҫ��0~59֮��
	 */
	private static final int TIME_SS_OUT=-404;
	/**
	 *  Сʱ�����֮�����ˡ� ����
	 */
	private static final int FATMOT_ERROR=-405;
	/**
	 * ʱ�䲻�ܰ�����ĸ�������ַ����� �� �������ҡ�������Ӣ���ַ�
	 */
	private static final int  TIME_TYPE_ERROR =-406;
	
	private static final int DATEDAY_NOT_NULL = -1;
	private static final int DATEDAY_ERROR = -2;
	
	//���Ӻ���ʱ�õ��Ĵ�����Ϣ
	private static final int FLIGHTNO_NOT_NULL = 139;
	private static final int FLIGHTNO_ERROR = 591;
	private static final int FROMCITY_NOT_NULL = 912;
	private static final int TOCITY_NOT_NULL = 84;
	private static final int FLIGHTTYPE_NOT_NULL = 135;
	private static final int STOPCITY_NOT_NULL = 891;
	private static final int NUMBER_NOT_NULL1 = 23;
	private static final int NUMBER_ERROR1 = 404;
	private static final int NUMBER_NOT_NULL2 = 230;
	private static final int NUMBER_ERROR2 = 4040;
	
	//ϵͳ�����̨�õ��Ĵ�����Ϣ
	//�����û�������Ϣ
	private static final int SYSUSERNAME_NOT_NULL = 330;
	private static final int SYSUSERNAME_ERROR = 331;
	
	//�����������������Ϣ
	private static final int NETCODE_NOT_NULL = 260;
	private static final int NETCODE_ERROR = 261;
	private static final int NETNAME_NOT_NULL = 262;
	private static final int NETDIRECTOR_NOT_NULL = 263;
	
	//�����������ݿ����ӡ���������Ϣ
	private static final int SID_NOT_NULL = 460;
	private static final int DBNAME_NOT_NULL = 461;
	private static final int DBPASSWORD_NOT_NULL = 462;
	
	
	/**
	 * ����������Ӧ�Ĵ�����Ϣ
	 */
	
	public static Map<Integer, String> ERRMsgMap;
	static {
		
		ERRMsgMap = new HashMap<Integer, String>();
		ERRMsgMap.put(OK, "OK");
		
		
		ERRMsgMap.put(YEAR_LONG,"����Ҫ 6λ �� 201308");
		ERRMsgMap.put(YEAR_ERROR," ���²��ܺ�����ĸ�������ַ����ҵ�һλ������0");
		ERRMsgMap.put(YEAR_FARMOT,"�·�Ҫ��1~12֮��");
		
		ERRMsgMap.put(TIME_LONG_ERRER, "ʱ��Ҫ5λ����ʽΪ 00:00");
		ERRMsgMap.put(TIME_NO_NULL, "����Ϊ��");
		ERRMsgMap.put(TIME_MI_OUT, "Сʱ��Ҫ��0~24֮��");
		ERRMsgMap.put(TIME_SS_OUT, "������Ҫ��0~59֮��");
		ERRMsgMap.put(FATMOT_ERROR, " Сʱ�����֮�����ˡ� ����");
		ERRMsgMap.put(TIME_TYPE_ERROR, "���ܰ�����ĸ�������ַ����� �� �������ҡ�������Ӣ���ַ�");

		ERRMsgMap.put(ID_NOT_NULL, "��¼ID����Ϊ��");
		ERRMsgMap.put(ID_ERROR, "�ʺ�Ҫ�����ֺ���ĸ��ϳ���Ϊ8λ");

		ERRMsgMap.put(PWD_NOT_NULL, "���벻��Ϊ��");
		ERRMsgMap.put(PWD_ERROR, "�����ʽ���������ֺ���ĸ��ϳ�����6-12λ֮��");
		ERRMsgMap.put(TWOPWD_ERROR, "������������벻��ͬ��������ȷ��������");

		ERRMsgMap.put(IP_NOT_NULL, "IP��ַ����Ϊ��");
		ERRMsgMap.put(IP_ERROR, "IP��ַ��ʽ����");
		ERRMsgMap.put(IP_NUM_TOO_LARGE, "IP��ַ��ֵ̫�󣬱�����0~255֮��");
		ERRMsgMap.put(IP_NUM_TOO_SMALL, "IP��ַ��ֵ̫С��������0~255֮��");

		ERRMsgMap.put(PORT_NOT_NULL, "�˿ںŲ���Ϊ��");
		ERRMsgMap.put(PORT_ERROR, "�˿ںŸ�ʽ����");
		ERRMsgMap.put(PORT_NULL_TOO_SMALL, "�˿ںŵ�ֵ̫С��������1024~65535֮��");
		ERRMsgMap.put(PORT_NULL_TOO_LARGE, "�˿ںŵ�ֵ̫�󣬱�����1024~65535֮��");

		ERRMsgMap.put(CUSTNAME_NOT_NULL, "��������Ϊ��");
		ERRMsgMap.put(CUSTNAME_ERROR, "����������2~10֮�������");

		ERRMsgMap.put(PHONE_NOT_NULL, "�绰����Ϊ��");
		ERRMsgMap.put(PHONE_NOT_ENOUGH, "�绰����ӦΪ11λ");
		ERRMsgMap.put(PHONE_ERROR, "�绰�����ʽ���󣬺���ӦΪ����");

		ERRMsgMap.put(IDCARD_NOT_NULL, "���֤���벻��Ϊ��");
		ERRMsgMap.put(IDCARD_NOT_ENOUGH, "���֤����ӦΪ18λ");
		ERRMsgMap.put(IDCARD_ERROR, "���֤����ӦȫΪ���ֻ����һλΪX");

		ERRMsgMap.put(ADDRESS_NOT_NULL, "��ַ����Ϊ��");
		ERRMsgMap.put(ADDRESS_TOO_LONG, "��ַӦΪ50λ");
		ERRMsgMap.put(EMAIL_NOT_NULL, "���䲻��Ϊ��");
		ERRMsgMap.put(EMAIL_ERROR, "�����ʽ����,ӦΪ :���ֻ���ĸ@��ĸ.com");
		
		ERRMsgMap.put(DATEDAY_NOT_NULL, "���ڲ���Ϊ��");
		ERRMsgMap.put(DATEDAY_ERROR, "���ڸ�ʽ����Ӧ��Ϊyyyy-MM-dd");
		
		
		ERRMsgMap.put(FLIGHTNO_NOT_NULL, "�����Ų���Ϊ��");
		ERRMsgMap.put(FLIGHTNO_ERROR, "�����ű�������ĸ�����ֵ����");
		ERRMsgMap.put(FROMCITY_NOT_NULL, "�������в���Ϊ��");
		ERRMsgMap.put(TOCITY_NOT_NULL, "������в���Ϊ��");
		
		ERRMsgMap.put(FLIGHTTYPE_NOT_NULL, "�������Ͳ���Ϊ��");
		ERRMsgMap.put(STOPCITY_NOT_NULL, "��ͣ���в���Ϊ��");
		ERRMsgMap.put(NUMBER_NOT_NULL1, "��Ʊ��۸񡢺�����̡���λ��������Ϊ������");
		ERRMsgMap.put(NUMBER_ERROR1, "��Ʊ��۸񡢺�����̡���λ����������0~9������ɣ�����С����");
		ERRMsgMap.put(NUMBER_NOT_NULL2, "����ͣƱ��۸񡢾�ͣ���Ʊ�ۡ���ͣ���������Ϊ������");
		ERRMsgMap.put(NUMBER_ERROR2, "����ͣƱ��۸񡢾�ͣ���Ʊ�ۡ���ͣ�����������0~9������ɣ�����С����");
		
		ERRMsgMap.put(SYSUSERNAME_NOT_NULL, "����Ա�˺Ų���Ϊ��");
		ERRMsgMap.put(SYSUSERNAME_ERROR, "����Ա�˺������ֺ���ĸ��ϣ�����3-12λ֮��");
		
		ERRMsgMap.put(NETCODE_NOT_NULL, "���������Ų���Ϊ��");
		ERRMsgMap.put(NETCODE_ERROR, "���������������ֺ���ĸ��ϣ�����8λ");
		ERRMsgMap.put(NETNAME_NOT_NULL, "�����������Ʋ���Ϊ��");
		ERRMsgMap.put(NETDIRECTOR_NOT_NULL, "�������㸺���˲���Ϊ��");
		
		ERRMsgMap.put(SID_NOT_NULL, "SID����Ϊ��");
		ERRMsgMap.put(DBNAME_NOT_NULL, "�˺Ų���Ϊ��");
		ERRMsgMap.put(DBPASSWORD_NOT_NULL, " ���벻��Ϊ��");
		

	}

	/**
	 * ����û�id ���е�¼�ʺ��Ƿ�Ϊnull���߳���Ϊ0������Ƿ���ID_NOT_NULL��
	 * ���ж��ʺŵĳ����Ƿ�Ϊ8λ����������Ϸ���ID_ERROR�� ��������Ϸ���OK��
	 * 
	 * @param id
	 *    �û�id
	 * @return ����У����Ϣ
	 */
	public static int checkId(String id) {
		if (id == null || id.length() == 0) {
			return ID_NOT_NULL;
		} else if (!(id.matches("[a-zA-Z0-9]{8}"))) {
			return ID_ERROR;
		} else {
			return OK;
		}
	}

	/**
	 * ������� ���ж������Ƿ�Ϊnull���߳���Ϊ0������Ƿ���PWD_NOT_NULL��
	 * ���ж������ʽ�Ƿ����Ҫ�����ֺ���ĸ��ϳ�����6-12λ֮�䣬��������Ϸ���PWD_ERROR�� ��������Ϸ���OK��
	 * 
	 * @param pwd
	 *            �û�����
	 * @return ����У����Ϣ
	 */
	public static int checkPwd(String pwd) {
		if (pwd == null || pwd.length() == 0) {
			return PWD_NOT_NULL;
		} else if (!(pwd.matches("[a-zA-Z0-9]{6,12}"))) {
			return PWD_ERROR;
		} else {
			return OK;
		}
	}

	/**
	 * �ж��������Ƿ���ȣ�������ȽϷ���0 ʱ˵�����
	 * 
	 * @param pwd1
	 *            ����һ
	 * @param pwd2
	 *            �����
	 * @return ����У����Ϣ
	 */
	public static int checkTwoPwd(String pwd1, String pwd2) {
		if (pwd1.compareTo(pwd2) != 0) {
			return TWOPWD_ERROR;
		} else {
			return OK;
		}
	}

	/**
	 * ���ip��ַ ���ж�IP��ַ�Ƿ�Ϊnull���߳���Ϊ0������Ƿ���IP_NOT_NULL��
	 * �ж�IP��ַ�е���ֵ�Ƿ���0��255֮�䣬��������Ϸ���IP_NUM_TOO_SMALL��IP_NUM_TOO_LARGE��
	 * �ж��Ƿ����IP��ʽ������IP_ERROR�� ��������Ϸ���OK��
	 * 
	 * @param ip
	 *            ip��ַ
	 * @return ����У����Ϣ
	 */
	public static int checkIp(String ip) {
		if (ip == null || ip.length() == 0) {
			return IP_NOT_NULL;
		}
		if (!(ip.matches("([0-9]{1,3}\\.){3}[0-9]{1,3}"))) {
			return IP_ERROR;
		}
		String[] strs = ip.split("\\.");
		for (String string : strs) {
			if (Integer.parseInt(string) < 0) {
				return IP_NUM_TOO_SMALL;
			}
			if (Integer.parseInt(string) > 255) {
				return IP_NUM_TOO_LARGE;
			}
		}
		return OK;
	}

	/**
	 * ���˿ں� ���ж϶˿ں��Ƿ�Ϊnull���߳���Ϊ0������Ƿ���PORT_NOT_NULL��
	 * ���ж϶˿ںŵ�ֵ�Ƿ���1024��65535֮�䣬��������Ϸ���PORT_NUM_TOO_SMALL��PORT_NUM_TOO_LARGE��
	 * �������������Ҫ�󣬷���PORT_ERROR�� ��������Ϸ���OK��
	 * 
	 * @param portStr
	 *            �˿ں�
	 * @return ����У����Ϣ
	 */
	public static int checkPort(String portStr) {
		if (portStr == null || portStr.length() == 0) {
			return PORT_NOT_NULL;
		} else if (!(portStr.matches("[0-9]{1,}"))) {
			return PORT_ERROR;
		} else if (Integer.parseInt(portStr) < 1024) {
			return PORT_NULL_TOO_SMALL;
		} else if (Integer.parseInt(portStr) > 65535) {
			return PORT_NULL_TOO_LARGE;
		} else {
			return OK;
		}

	}

	/**
	 * ����û��� ���ж��ÿ������Ƿ�Ϊnull���߳���Ϊ0������Ƿ���NO_NULL�� ���ж�custName�ĸ�ʽ�Ƿ����Ҫ�󣬳����� 2~10 ֮��
	 * (����������)������񷵻�CUSTNAME_ERROR�� ��������Ϸ���OK��
	 * 
	 * @param userName
	 *            �û���
	 * @return ����У����Ϣ
	 */
	public static int checkName(String name) {
		if (name == null || name.length() == 0) {
			return CUSTNAME_NOT_NULL;
		} else if (!(name.matches("[\\u4e00-\\u9fa5]{2,10}"))) {
			return CUSTNAME_ERROR;
		} else {
			return OK;
		}
	}

	/**
	 * ����ÿ͵绰
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public static int checkPhoneNumber(String phoneNumber) {
		if (phoneNumber == null || phoneNumber.length() == 0) {
			return PHONE_NOT_NULL;
		}
		if (phoneNumber.length() != 11) {
			return PHONE_NOT_ENOUGH;
		}
		for (int i = 0; i < phoneNumber.length(); i++) {
			if (Character.isDigit(phoneNumber.charAt(i)) != true) {
				return PHONE_ERROR;
			}
		}
		return OK;
	}

	/**
	 * ������֤
	 * 
	 * @param idcard
	 * @return
	 */
	public static int checkIdCard(String idcard) {
		if (idcard == null || idcard.length() == 0) {
			return IDCARD_NOT_NULL;
		}
		if (idcard.length() != 18) {
			return IDCARD_NOT_ENOUGH;
		}
		if (!idcard.matches("[0-9]{17}[X0-9]{1}")) {
			return IDCARD_ERROR;
		}
		return OK;
	}

	/**
	 * ����ַ ���ж������ַ�Ƿ�Ϊnull���߳���Ϊ0������Ƿ���ADDRESS_NOT_NULL��
	 * ���ж������ַ�Ƿ����Ҫ�󣬲�����50���ַ�����������Ϸ���ADDRESS_TOO_LONG�� ��������Ϸ���OK��
	 * 
	 * @param addressStr
	 *            ��ַ
	 * @return ����У����Ϣ
	 */
	public static int checkAddress(String addressStr) {
		if (addressStr == null || addressStr.length() == 0) {
			return ADDRESS_NOT_NULL;
		} else if (addressStr.length() > 50) {
			return ADDRESS_TOO_LONG;
		} else {
			return OK;
		}

	}
	
	/**
	 * ��������ַ��ʽ
	 * @param email
	 * @return
	 */
	public static int checkEmail(String email){
		if (email == null || email.length() == 0) {
			return EMAIL_NOT_NULL;
		}
		if (!email.matches("[a-zA-Z0-9]{1,}@[a-zA-Z_]{1,}\\.com")) {
			return EMAIL_ERROR;
		}
		return OK;
	}
	
    /**
     * �ж�ʱ���Ƿ����ʱ��ĸ�ʽ��Ҫ��
     * @param time
     * @return
     */
	public static int checkDate(String time){
	
		if(time.trim() ==null ||time.length() == 0){
		      return TIME_NO_NULL;
		}
		if(time.trim().length() !=5){
			return TIME_LONG_ERRER;
		}
		if(!time.trim().matches("[0-9]{2}[:][0-9]{2}")){
			return TIME_TYPE_ERROR;
		}
		int mi =Integer.valueOf(time.trim().substring(0, 2));
	
		int ss =Integer.valueOf(time.trim().substring(3, 5));
		
		if(mi < 0  || mi > 24){
			return TIME_MI_OUT;
		}
		if(ss < 0  ||ss > 59){
			return TIME_SS_OUT;
		}
		if(!time.substring(2, 3).contains(":")){
			return FATMOT_ERROR;
		}
		return OK;	
	}
    public static void main(String[] args) {
    	System.out.println(ERRMsgMap.get(checkDate("09:24")));
	}
    
    
    
	public static int checkYearM(String date){
		if(date.trim().length()!=6){
			return YEAR_LONG;
		}
		if(!date.trim().trim().matches("[1-9]{1}[0-9]{5}")){
			return YEAR_ERROR;
		}
		if(Integer.valueOf(date.trim().substring(4,6)) < 1  || Integer.valueOf(date.trim().substring(4,6))>12){
			return YEAR_FARMOT;
		}
		return OK;	
	}
	
	
	public static int  CompareString(String str1,String str2)
	{
		String[] str3=str1.split(":");
		int hour1=Integer.parseInt(str3[0]);
		int minute1=Integer.parseInt(str3[1]);
		String[] str4=str2.split(":");
		int hour2=Integer.parseInt(str4[0]);
		int minute2=Integer.parseInt(str4[1]);
		if(hour1>hour2)
			return 1;
		if(hour1==hour2 && minute1>minute2)
			return 1;
		return -1;
				
	}	
	
	/**
	 * �˲����������(��ȷ��"��")�Ƿ����Ҫ��
	 * @param name
	 * @return
	 */
	public static int checkDateDay(String date){
		if(date==null || date.length()==0){
			return DATEDAY_NOT_NULL;
		}
		if(date.length() != 10){
			return DATEDAY_ERROR;
		}
		int year = Integer.parseInt(date.trim().substring(0, 4));
		int month = Integer.parseInt(date.trim().substring(5, 7));
		int day = Integer.parseInt(date.trim().substring(8, 10));
		if(year<1900 || year>3000 || month<1 || month>12 || day<1 || day>31){
			return DATEDAY_ERROR;
		}
		return OK;	
	}
	
	
	/**
	 * �˲���Ʊ�����ϵ���Ϣ�Ƿ�����д
	 * @param map
	 * @return
	 */
	public static String checkAllInputIsNull(HashMap<String, String> map){
		Set entrySet = map.entrySet();
		Iterator entryIterator = entrySet.iterator();
		while(entryIterator.hasNext()){
			Map.Entry entry = (Map.Entry)entryIterator.next();
			Object key = entry.getKey();
			Object values = entry.getValue();
			if(key.equals("")){
				StringBuffer errorInfo = new StringBuffer();
				return String.valueOf(errorInfo.append(values + "������д"));
			}
		}
		return "";
	}
	
	/**
	 * �Ӹ���Ĵ��󼯺�MAP��ȡ����������Ӧ�Ĵ�����Ϣ
	 * @param errorCode
	 * @return
	 */
	public static String getMapNoticeInfo(int errorCode){
		Set entrySet = ERRMsgMap.entrySet();
		Iterator entryIterator = entrySet.iterator();
		while(entryIterator.hasNext()){
			Map.Entry entry = (Map.Entry)entryIterator.next();
			Object key = entry.getKey();
			Object values = entry.getValue();
			if((Integer)key == errorCode){
				return (String)values;
			}
		}
		return null;
	}
	
	/**
	 * �˲麽����
	 * @param flightno
	 * @return
	 */
	public static int checkFlightNo(String flightno){
		if(flightno.trim().equals("")){
			return FLIGHTNO_NOT_NULL;
		}
		if(!flightno.trim().matches("^[A-Za-z0-9]+$")){
			return FLIGHTNO_ERROR;
		}
		return OK;
	}
	/**
	 * �˲麽���Ÿ�ʽ�������
	 * @param flightno
	 * @return
	 */
	public static int checkFlightNoExceptNull(String flightno){
		if(!flightno.trim().matches("^[A-Za-z0-9]+$")){
			return FLIGHTNO_ERROR;
		}
		return OK;
	}
	
	/**
	 * �˲����������Ÿ�ʽ�������
	 * @param netcode
	 * @return
	 */
	public static int checkNetcodeExceptNull(String netcode){
		if (!(netcode.matches("^[A-Za-z0-9]{8}"))) {
			return NETCODE_ERROR;
		}
		return OK;
	}
	
	/**
	 * ����Ӻ�����Ϣʱ���˲�������С�������С��������
	 */
	public static int checkCityAndFlighttype(String fromcity, String tocity,
			String flighttype){
		if(fromcity.trim().equals("")){
			return FROMCITY_NOT_NULL;
		}else if(tocity.trim().equals("")){
			return TOCITY_NOT_NULL;
		}else if(flighttype.trim().equals("")){
			return FLIGHTTYPE_NOT_NULL;
		}
		return OK;
	}
	
	/**
	 * ����Ӻ�����Ϣʱ���˲龭ͣ����
	 * @param stopcity
	 * @return
	 */
	public static int checkStopCity(String stopcity){
		if(stopcity.trim().equals("")){
			return STOPCITY_NOT_NULL;
		}
		return OK;
	}
	
	/**
	 * ����Ӻ���ʱ���˲����ֵ�����
	 */
	public static int checkIsNum(String num, int flag){
		if(num.trim().equals("")){
			switch(flag){
			case 1:
				return NUMBER_NOT_NULL1;
			case 2:
				return NUMBER_NOT_NULL2;
			}
		}
		if(!num.trim().matches("^[0-9]*$")){
			switch(flag){
			case 1:
				return NUMBER_ERROR1;
			case 2:
				return NUMBER_ERROR2;
			}
		}
		return OK;
	}
	/**
	 * ����Ӻ���ʱ���˲����ֵ�����
	 * �˲顰Ʊ��۸񡢺�����̡���λ������������ͣƱ��۸񡢾�ͣ���Ʊ�ۡ���ͣ�������
	 */
	public static int checkIsNum(String val1, String val2, String val3, int flag){
		if(!(checkIsNum(val1,flag) == OK)){
			return checkIsNum(val1,flag); 
		}else if(!(checkIsNum(val2,flag) == OK)){
			return checkIsNum(val2,flag);
		}else if(!(checkIsNum(val3,flag) == OK)){
			return checkIsNum(val3,flag);
		}
		return OK;
	}
	
	/**
	 * �˲�ϵͳ����Ա�˺�
	 * @param name
	 * @return
	 */
	public static int checkSysUsername(String name) {
		if (name == null || name.length() == 0) {
			return SYSUSERNAME_NOT_NULL;
		} else if (!(name.matches("^[A-Za-z0-9]{3,12}"))) {
			return SYSUSERNAME_ERROR;
		} else {
			return OK;
		}
	}
	
	
	/**
	 * �˲������˺�
	 * @param name
	 * @return
	 */
	public static int checkNetCode(String name) {
		if (name == null || name.length() == 0) {
			return NETCODE_NOT_NULL;
		} else if (!(name.matches("^[A-Za-z0-9]{8}"))) {
			return NETCODE_ERROR;
		} else {
			return OK;
		}
	}
	
	/**
	 * ������������
	 * @param name
	 * @return
	 */
	public static int checkNetName(String name) {
		if (name == null || name.length() == 0) {
			return NETNAME_NOT_NULL;
		} else {
			return OK;
		}
	}
	
	/**
	 * �������㸺����
	 * @param name
	 * @return
	 */
	public static int checkDirector(String name) {
		if (name == null || name.length() == 0) {
			return NETDIRECTOR_NOT_NULL;
		} else {
			return OK;
		}
	}
	
	
	public static int checkSidUserPwd(String sid, String username, String password){
		if(sid==null || sid.length()==0){
			return SID_NOT_NULL;
		}else if(username==null || username.length()==0){
			return DBNAME_NOT_NULL;
		}else if(password==null || password.length()==0){
			return DBPASSWORD_NOT_NULL;
		}
		return OK;
	}
	
	
	
}
