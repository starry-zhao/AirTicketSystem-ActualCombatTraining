package com.softfz.model;

import java.io.Serializable;

public class SaleTotal implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -220591707172968957L;
	private String month;//�����·ݣ���201301
	private String flightno;//������
	private String airline;//���չ�˾
	private long ticketmoney;//����Ʊ��
	private int ticketnum;//���۵�����
	private long turnmoney;//��Ʊ����
	private int turnnum;//��Ʊ���
	private long totalmoney;//���ۻ���=���˶���Ǯ-���˶���Ǯ
	
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getFlightno() {
		return flightno;
	}
	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public long getTicketmoney() {
		return ticketmoney;
	}
	public void setTicketmoney(long ticketmoney) {
		this.ticketmoney = ticketmoney;
	}
	public int getTicketnum() {
		return ticketnum;
	}
	public void setTicketnum(int ticketnum) {
		this.ticketnum = ticketnum;
	}
	public long getTurnmoney() {
		return turnmoney;
	}
	public void setTurnmoney(long turnmoney) {
		this.turnmoney = turnmoney;
	}
	public int getTurnnum() {
		return turnnum;
	}
	public void setTurnnum(int turnnum) {
		this.turnnum = turnnum;
	}
	public long getTotalmoney() {
		return totalmoney;
	}
	public void setTotalmoney(long totalmoney) {
		this.totalmoney = totalmoney;
	}
	@Override
	public String toString() {
		return "SaleTotal [month=" + month + ", flightno=" + flightno
				+ ", airline=" + airline + ", ticketmoney=" + ticketmoney
				+ ", ticketnum=" + ticketnum + ", turnmoney=" + turnmoney
				+ ", turnnum=" + turnnum + ", totalmoney=" + totalmoney + "]";
	}
	
	
}
