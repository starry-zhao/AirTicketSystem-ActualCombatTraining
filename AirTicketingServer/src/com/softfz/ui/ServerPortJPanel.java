package com.softfz.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.softfz.config.ServerConfig;
import com.softfz.resources.Resources;
import com.softfz.server.IServiceOperator;
import com.softfz.server.ServerOperatorImpl;
import com.softfz.utils.CheckUtil;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class ServerPortJPanel extends javax.swing.JPanel {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JButton jButton1;
	private JTextField jTextField2;
	private JTextField jTextField1;
	private int errorNum;

	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new ServerPortJPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public ServerPortJPanel() {
		super();
		initGUI(); //�����ʼ��
		listener();  //�¼�����
		initData(); //���ݳ�ʼ��
	}

	private void initData() {
		// ��ȡserver.properties�����ļ��е�������ʾ��������
		IServiceOperator operator = ServerOperatorImpl.getInstance();
		operator.initNetPort();

		jTextField1.setText(ServerConfig.RMI_PORT);
		jTextField2.setText(ServerConfig.SERVER_CLIENT_PORT);
	}

	private void listener() {
		ButtonListener bl = new ButtonListener();
		jButton1.addActionListener(bl);
	}

	/**
	 * �Ӻ˲�����ȡ�ú˲�Ĵ�����Ϣ
	 * 
	 * @param errorNum
	 * @throws Exception
	 */
	private void checkIsError(int errorNum) throws Exception {
		if (errorNum != CheckUtil.OK) {
			String errorInfo = CheckUtil.ERRMsgMap.get(errorNum);
			throw new Exception(errorInfo);
		}
	}

	/**
	 * ����˿����õ��ļ���
	 * 
	 * @param RMI_PORT
	 * @param SERVER_CLIENT_PORT
	 */
	private void savePort(String RMI_PORT, String SERVER_CLIENT_PORT) {

	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if (cmd.equals("��������")) { //����������ð�ť
				//TODO��
				//���ж��Ƿ������޸Ķ˿ڣ����������в�����
				//1)��ȡ�ı�������� : jTextField1.getText();  --У��
				//2��ServerOperatorImpl.updateNetPort(String rmiPort, String socketPort) 
				//---a)�޸�ServerConfig���ж�Ӧ�ı��������£�
				//---b)����ServerConfigFile.saveServerConfig()
				
			}

		}

	}

	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(580, 336));
			this.setSize(580, 336);
			this.setLayout(null);
			{
				jLabel1 = new JLabel();
				this.add(jLabel1);
				jLabel1.setText("RMI\u7aef\u53e3\uff1a");
				jLabel1.setBounds(168, 87, 82, 29); //
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2);
				jLabel2.setText("Socket\u7aef\u53e3\uff1a");
				jLabel2.setBounds(168, 133, 82, 29);
			}
			{
				jTextField1 = new JTextField();
				this.add(jTextField1);
				jTextField1.setText("1099");
				jTextField1.setBounds(250, 91, 168, 25);
			}
			{
				jTextField2 = new JTextField();
				this.add(jTextField2);
				jTextField2.setText("1024");
				jTextField2.setBounds(250, 133, 168, 25);
			}
			{
				jButton1 = new JButton();
				this.add(jButton1);
				jButton1.setText("\u4fdd\u5b58\u914d\u7f6e");
				jButton1.setBounds(237, 213, 120, 30);
				jButton1.setIcon(Resources.getSaveIcon());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
