package com.softfz.ui.panel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.eltima.components.ui.DatePicker;
import com.softfz.RMIFactory;
import com.softfz.model.Discount;
import com.softfz.model.Flight;
import com.softfz.model.PageModel;
import com.softfz.model.SalesTicketInfoShow;
import com.softfz.model.TicketStore;
import com.softfz.resources.Resources;
import com.softfz.service.INetService;
import com.softfz.ui.Center;
import com.softfz.ui.table.PageRadioTable;
import com.softfz.ui.table.PageRadioTableModel;


/**
* �����ѯ���棬��ʾ���������ĺ�����Ϣ
*/
public class FlightInfo extends javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2307425322358541964L;
	private JPanel jPanel1;
	private JPanel bottom;
	private PageRadioTable radioTable;
	private JLabel jLabel3;
	private JButton searchBtn;
	private DatePicker datePicker;
	private JTextField toCityField;
	private JTextField fromCityField;
	private JButton orderBtn;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private Center center;
	
	
	
	private String[] header = new String[]{"","���ʱ��","����ʱ��","��ɻ���","�������","���չ�˾","����","�۸�","�ۿ�","ʣ��Ʊ��"};
	private SearchTableModel tableModel;
	private INetService facade;
	
	
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		frame.getContentPane().add(new FlightInfo());
//		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//		frame.pack();
//		frame.setVisible(true);
//	}
	
	public FlightInfo(Center center) {
		this.center = center;
		tableModel = new SearchTableModel();
		initGUI();
		listener();
	}
	
	private void listener(){
		ButtonListener bl = new ButtonListener();
		searchBtn.addActionListener(bl);
		orderBtn.addActionListener(bl);
	}
		
	private void initGUI() {
		try {
			{
				this.setPreferredSize(new java.awt.Dimension(794, 498));
				this.setLayout(new BorderLayout());
				{
					jPanel1 = new JPanel();
					this.add(jPanel1, BorderLayout.NORTH);
					
					jPanel1.setSize(794,80);
					jPanel1.setLayout(null);
					jPanel1.setPreferredSize(new java.awt.Dimension(794, 80));
				}
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("�������У�");
					jLabel1.setBounds(10,16,80,35);
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("������У�");
					jLabel2.setBounds(210,16,80,35);
				}
				{
					jLabel3 = new JLabel();
					jPanel1.add(jLabel3);
					jLabel3.setText("�������ڣ�");
					jLabel3.setBounds(420,16,80,35);
				}
				{
					fromCityField = new JTextField();
					jPanel1.add(fromCityField);
					fromCityField.setBounds(80,16,120,30);
				}
				{
					toCityField = new JTextField();
					jPanel1.add(toCityField);
					toCityField.setBounds(290,16,120,30);
				}
				{
					datePicker = new DatePicker(this, new Date());
					datePicker.setPattern("yyyy-MM-dd");
					jPanel1.add(datePicker);
					datePicker.setBounds(500,16,123,29);
				}
				{
					searchBtn = new JButton();
					jPanel1.add(searchBtn);
					searchBtn.setText("��ѯ");
					searchBtn.setIcon(Resources.getFindIcon());
					searchBtn.setBounds(680,16,100,30);
				}
			}
			{
				// ����ѡ��ķ�ҳ���
				radioTable = new PageRadioTable(tableModel);
				this.add(radioTable,BorderLayout.CENTER);
				radioTable.setEnabled(true);
				radioTable.setPreferredSize(new java.awt.Dimension(794, 369));
			}	
			{
				bottom = new JPanel();
				orderBtn = new JButton("��Ʊ");
				orderBtn.setIcon(Resources.getNewIcon());
				bottom.add(orderBtn);
				this.add(bottom,BorderLayout.SOUTH);
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(cmd.equals("��ѯ")){
				tableModel.doPageQuery(1, PageModel.DEFAULT_PAGESIZE);
				radioTable.reflashTable();
			}else if(cmd.equals("��Ʊ")){
				Flight flight=tableModel.getCheckFlight();
				if (flight.getStorenum()>0) {
					Date date=(Date) datePicker.getValue();
					java.sql.Date sqlDate = new java.sql.Date(date.getTime());
					
					JFrame frame = new JFrame();
					Ticketing ticketing=new Ticketing(center);
					ticketing.buildTicket(flight, sqlDate );
					frame.getContentPane().add(ticketing);
					frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					frame.pack();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "��λ���㣬�޷���Ʊ");
				}
				
			}
			
		}
		
	}
	
	
	private class SearchTableModel extends PageRadioTableModel {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 4152552028516706843L;

		public SearchTableModel(){
			super(header);
		}
		/**
		 * ��ȡѡ�еĺ�����Ϣ
		 * @return
		 */
		public Flight getCheckFlight(){
			int index = super.getSelectedIndex();//����ѡ�е��ǵڼ��У��±��0��ʼ��
			if(index == -1){
				JOptionPane.showMessageDialog(null, "û��ѡ�к��࣬�޷���Ʊ");
				return null;
			}
			Flight flight = (Flight) super.getPageModel().getResult().get(index);
			return flight;
		}
		
		/**
		 * ��ѯ�ķ���
		 * @param rowIndex
		 * @param columnIndex
		 * @return
		 */
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Flight flight=(Flight) this.getPageModel().getResult().get(rowIndex);
			switch (columnIndex) {
			case 0:
				return this.getRadionBtn(rowIndex);
			case 1:
				return flight.getPlanstarttime();
			case 2:
				return flight.getPlanendtime();
			case 3:
				return flight.getStartairport();
			case 4:
				return flight.getEndairport();
			case 5:
				return flight.getAirname();
			case 6:
				return flight.getFlighttype();
			case 7:
				return flight.getPrice();
			case 8:
				return flight.getDiscount();
			case 9:
				return flight.getStorenum();
			default:
				break;
			}
			return null;
		}
		
		/**
		 * �ҳ�Ҫ��ʾ�����ݲ���ʾ��������
		 * @param currentPage
		 * @param pageSize
		 */
		@Override
		public void doPageQuery(int currentPage, int pageSize) {
			INetService netService=RMIFactory.getService();
			if (netService!=null) {
				String fromcity=fromCityField.getText().trim();
				String tocity=toCityField.getText().trim();
				Date planDate = (Date) datePicker.getValue();
				
				if (fromcity==null||fromcity==""||fromcity.length()==0||tocity==null||tocity==""||tocity.length()==0) {
					JOptionPane.showMessageDialog(null, "����д�����Ĳ�ѯ������");
				}else {
					PageModel<Flight> pageModel;
					try {
						pageModel = netService.queryFlights(fromcity, tocity, planDate, currentPage, pageSize);
						super.setPageModel(pageModel);
					} catch (RemoteException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
						String eStr = e.getMessage().substring(e.getMessage().lastIndexOf(":")+1);
						JOptionPane.showMessageDialog(null, eStr);
					}
					
				}
			}
		}
	}
		

}
