package com.softfz.ui.panel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.softfz.NetContext;
import com.softfz.RMIFactory;
import com.softfz.model.Flight;
import com.softfz.model.PageModel;
import com.softfz.model.SaleTotal;
import com.softfz.resources.Resources;
import com.softfz.service.INetService;
import com.softfz.ui.table.PageTable;
import com.softfz.ui.table.PageTableModel;
import com.softfz.utils.CheckUtil;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class SalesCount extends javax.swing.JPanel {
	private JPanel jPanel_UP;
	private JPanel jPanel_DOWN;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JTextField jTextField_SaleMonth;
	private JButton jButton_Search;
	private JTextField jTextField_FlightID;
	private PageTable pageTable;
	private MyTableModel tableModel;
	private String[] header = new String[]{"�����·�","������","�������չ�˾","��Ʊ��","��Ʊ��","��Ʊ��","��Ʊ��","�����ܶ�"};
	private int errorNoticeInt;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new SalesCount());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public SalesCount() {
		tableModel = new MyTableModel(header);
		initGUI();
		listener();
	}
	
	private void listener(){
		ButtonListener bl = new ButtonListener();
		jButton_Search.addActionListener(bl);
	}
	
	private void checkIsError(int inputTextInt) throws Exception{
		String errorNoticeString = CheckUtil.getMapNoticeInfo(inputTextInt);
		if(!errorNoticeString.equals("OK")){
			throw new Exception(errorNoticeString);
		}
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(cmd.equals("��ѯ")){
				
			}
		}
	}
	
	private class MyTableModel extends PageTableModel {
		public MyTableModel(String[] header) {
			super(header);
		}
	
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// �÷���ʵ�ֱ����Ҫ��ʾ������
			//rowIndex��Ҫ��ʾ���м�¼
			SaleTotal saleTotal =(SaleTotal)this.getPageModel().getResult().get(rowIndex);
			//columnIndex��Ҫ��ʾ���м�¼��
			Object value = null;
			switch (columnIndex) {
			
			case 0:
				value = saleTotal.getMonth();//�����·�
				break;
			case 1:
				value = saleTotal.getFlightno();//������
				break;
			case 2:
				value = saleTotal.getAirline();//�������չ�˾
				break;
			case 3:
				value = saleTotal.getTicketnum();//��Ʊ��
				break;
			case 4:
				value = saleTotal.getTicketmoney();//��Ʊ��
				break;
			case 5:
				value = saleTotal.getTurnnum();//��Ʊ��
				break;
			case 6:
				value = saleTotal.getTurnmoney();//��Ʊ��
				break;
			case 7:
				value = saleTotal.getTotalmoney();//�����ܶ�
				break;
			default:
				break;
			}
			return value;
		}

		@Override
		public void doPageQuery(int currentPage, int pageSize) {
			/* �÷����Ǳ�����ݸ��·����������ڷ�ҳ��ť�Ͳ�ѯʱ����.
			 ���з�ҳ��ť�Ѿ�ʵ�����ڲ��������������
			 �ڽ���Ĳ�ѯ��ť����Ҫ��������������ñ�����*/
			// �÷�������ʵ��ֻ��Ҫ����Զ�̷������е�ҵ�񷽷����ɡ�
			
			
			
		}

	}
	
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(794, 498));
			this.setSize(794, 498);
			this.setLayout(null);
			{
				jPanel_UP = new JPanel();
				this.add(jPanel_UP);
				jPanel_UP.setBounds(0, 0, 794, 92);
				jPanel_UP.setBorder(BorderFactory.createTitledBorder("\u67e5\u8be2\u6761\u4ef6"));
				jPanel_UP.setLayout(null);
				{
					jLabel1 = new JLabel();
					jPanel_UP.add(jLabel1);
					jLabel1.setText("\u9500\u552e\u6708\u4efd\uff1a");
					jLabel1.setBounds(30, 38, 60, 17);
					jLabel1.setSize(80, 20);
				}
				{
					jLabel2 = new JLabel();
					jPanel_UP.add(jLabel2);
					jLabel2.setText("\u822a\u73ed\u7f16\u53f7\uff1a");
					jLabel2.setBounds(334, 39, 80, 20);
				}
				{
					jTextField_SaleMonth = new JTextField();
					jPanel_UP.add(jTextField_SaleMonth);
					jTextField_SaleMonth.setBounds(101, 37, 187, 24);
				}
				{
					jTextField_FlightID = new JTextField();
					jPanel_UP.add(jTextField_FlightID);
					jTextField_FlightID.setBounds(396, 37, 192, 24);
				}
				{
					jButton_Search = new JButton();
					jPanel_UP.add(jButton_Search);
					jButton_Search.setText("\u67e5\u8be2");
					jButton_Search.setBounds(642, 31, 100, 36);
					jButton_Search.setIcon(Resources.getFindIcon());
				}
			}
			{
				// ��ҳ���
				pageTable = new PageTable(tableModel);
				pageTable.setEnabled(true);
				pageTable.setBounds(13, 20, 770, 370);
				jPanel_DOWN = new JPanel();
				jPanel_DOWN.add(pageTable);
				jPanel_DOWN.setBounds(0, 92, 794, 406);
				jPanel_DOWN.setLayout(null);
				jPanel_DOWN.setBorder(BorderFactory.createTitledBorder("\u67e5\u8be2\u7ed3\u679c"));
				this.add(jPanel_DOWN);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
