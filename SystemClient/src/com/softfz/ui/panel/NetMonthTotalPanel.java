package com.softfz.ui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.softfz.RMIFactory;
import com.softfz.model.NetSaleTotal;
import com.softfz.model.PageModel;
import com.softfz.resources.Resources;
import com.softfz.service.ISystemService;
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
public class NetMonthTotalPanel extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -723297373227423953L;
	private JPanel jPanel_UP;
	private JPanel jPanel_DOWN;
	private JLabel jLabel1;
	private JLabel jLabel3;
	private JButton jButton_Search;
	private JTextField jTextField_SaleMonth;
	private JTextField jTextField_NetID;
	private PageTable pageTable;
	private MyTableModel tableModel;
	private String[] header = new String[]{"销售网点编号","网点名称","月份","票数","票价汇总","退票数","退票额","销售额汇总"};
	private int errorNoticeInt;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new NetMonthTotalPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public NetMonthTotalPanel() {
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
			if(cmd.equals("查询")){
				
				
				
			}
		}
	}
	
	private class MyTableModel extends PageTableModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -8568169816510515606L;

		public MyTableModel(String[] header) {
			super(header);
		}
	
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// 该方法实现表格需要显示的内容
			//rowIndex需要显示的行记录
			NetSaleTotal netSaleTotal =(NetSaleTotal)this.getPageModel().getResult().get(rowIndex);
					
			//columnIndex需要显示的列记录数
			Object value = null;
			switch (columnIndex) {
			
			case 0:
				value = netSaleTotal.getNetcode();
				break;
			case 1:
				value = netSaleTotal.getNetname();
				break;
			case 2:
				value = netSaleTotal.getMonth();
				break;
			case 3:
				value = netSaleTotal.getTicketnum();
				break;
			case 4:
				value = netSaleTotal.getTicketmoney();
				break;
			case 5:
				value = netSaleTotal.getTurnnum();
				break;
			case 6:
				value = netSaleTotal.getTurnmoney();
				break;
			case 7:
				value = netSaleTotal.getTotalmoney();
				break;				
			default:
				break;
			}
			return value;
		}

		@Override
		public void doPageQuery(int currentPage, int pageSize) {
			// 该方法是表格内容更新方法，比如在分页按钮和查询时调用.
			// 其中分页按钮已经实现了内部调用无需关联，
			// 在界面的查询按钮中需要监听点击方法调用本方法

			// 该方法具体实现只需要调用远程服务器中的业务方法即可。
			ISystemService systemService = RMIFactory.getService();
			if(systemService != null){
				//获得界面上的“销售月份”和“网点编号”
				String saleMonth = jTextField_SaleMonth.getText().trim();
				String netCode = jTextField_NetID.getText().trim();
				//把获得的pageModel设置到界面上
				try {
					PageModel<NetSaleTotal> pageModel = systemService.queryNetSaleTotal(netCode, saleMonth, currentPage, pageSize);
					System.out.println(pageModel);
					super.setPageModel(pageModel);
				} catch (Exception e) {
					String eStr = e.getMessage().substring(e.getMessage().lastIndexOf(":")+1);
					JOptionPane.showMessageDialog(null, eStr);
				}
			}
		}

	}
	
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(630, 554));
			this.setSize(630, 554);
			this.setLayout(null);
			{
				jPanel_UP = new JPanel();
				this.add(jPanel_UP);
				jPanel_UP.setBounds(0, 0, 630, 101);
				jPanel_UP.setLayout(null);
				jPanel_UP.setBorder(BorderFactory.createTitledBorder("\u67e5\u8be2\u6761\u4ef6"));
				{
					jLabel1 = new JLabel();
					jPanel_UP.add(jLabel1);
					jLabel1.setText("\u7f51\u70b9\u7f16\u53f7\uff1a");
					jLabel1.setBounds(12, 40, 80, 20);
				}
				{
					jLabel3 = new JLabel();
					jPanel_UP.add(jLabel3);
					jLabel3.setText("\u9500\u552e\u6708\u4efd\uff1a");
					jLabel3.setBounds(216, 40, 80, 20);
				}
				{
					jTextField_NetID = new JTextField();
					jPanel_UP.add(jTextField_NetID);
					jTextField_NetID.setBounds(85, 39, 113, 24);
				}
				{
					jTextField_SaleMonth = new JTextField();
					jPanel_UP.add(jTextField_SaleMonth);
					jTextField_SaleMonth.setBounds(281, 39, 115, 24);
				}
				{
					jButton_Search = new JButton();
					jPanel_UP.add(jButton_Search);
					jButton_Search.setText("\u67e5\u8be2");
					jButton_Search.setBounds(458, 35, 90, 32);
					jButton_Search.setIcon(Resources.getFindIcon());
				}
			}
			{
				// 分页表格
//				pageTable = new PageTable(tableModel);
//				this.add(pageTable);
//				pageTable.setEnabled(true);
//				pageTable.setBounds(0, 101, 630, 453);
				pageTable = new PageTable(tableModel);
				pageTable.setEnabled(true);
				pageTable.setBounds(10, 20, 610, 430);
				jPanel_DOWN = new JPanel();
				jPanel_DOWN.add(pageTable);
				jPanel_DOWN.setBounds(0, 101, 630, 453);
				jPanel_DOWN.setLayout(null);
				jPanel_DOWN.setBorder(BorderFactory.createTitledBorder("\u67e5\u8be2\u7ed3\u679c"));
				this.add(jPanel_DOWN);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
