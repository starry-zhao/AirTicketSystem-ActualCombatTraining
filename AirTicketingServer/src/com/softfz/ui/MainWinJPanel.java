package com.softfz.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import com.softfz.log.ServerContext;
import com.softfz.resources.Resources;
import com.softfz.server.ServerOperatorImpl;

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
public class MainWinJPanel extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9020445890224599324L;
	private JScrollPane jScrollPane1;
	private JButton jButton_Exit;
	private JButton jButton_Stop;
	private JButton jButton_Start;
	private JTextArea jTextArea1;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new MainWinJPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public MainWinJPanel() {
		super();
		initGUI();
		ServerContext.MAINPANEL = MainWinJPanel.this;//�ѽ�����󴫸�����ʵ���࣬����ͻ��˶Ա����ڽ��в���
		listener();  //���岢ע��������ť�ļ�����
	}
	
	private void listener(){
		ButtonListener m = new ButtonListener(); //ʵ��������������
		//��������ť�ϣ��¼�Դ��ע��԰�ť�ĵ���¼��ļ�������
		jButton_Start.addActionListener(m); 
		jButton_Stop.addActionListener(m);
		jButton_Exit.addActionListener(m);
	}
	
	/**
	 * �Զ�������ࣨ�ڲ��ࣩ
	 * @author Administrator
	 *
	 */
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand(); //e.getSource() --��ť����
			if(cmd.equals("����")){
				//��������,���ɹ��ı䰴ť����
				if(ServerOperatorImpl.getInstance().start()) { 
					jTextArea1.append("RMI������������\n");
					jButton_Start.setEnabled(false);
					jButton_Stop.setEnabled(true);
					jButton_Exit.setEnabled(false);
				}else {
					jTextArea1.append("RMI��������ʧ�ܣ�\n");
				}
				
			}else if(cmd.equals("ֹͣ")){
				//ֹͣ�������ɹ��ı䰴ť����
				if(ServerOperatorImpl.getInstance().stop()) {
					jTextArea1.append("RMI������ֹͣ��\n");
					jButton_Start.setEnabled(true);
					jButton_Stop.setEnabled(false);
					jButton_Exit.setEnabled(true);
				}else {
					jTextArea1.append("RMI����ֹͣʧ�ܣ�\n");
				}
				
			}else if(cmd.equals("�˳�")){
				int exitFlag = JOptionPane.showConfirmDialog(MainWinJPanel.this, "ȷ���˳������� ��", "�˳�ȷ��", JOptionPane.YES_NO_OPTION);
				if(exitFlag == 0){
					System.exit(0);
				}
			}	
		}
	}
	
	/**
	 * �ѽ���������Ϣ�͵�ǰʱ����װ�������˵���Ϣ��������ʾ
	 * @param message
	 */
	public void createMessage(String message){

	}
	
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(580, 336));
			this.setSize(580, 336);
			this.setLayout(null);
			{
				jScrollPane1 = new JScrollPane();
				this.add(jScrollPane1);
				jScrollPane1.setBounds(0, 0, 325, 250);
				jScrollPane1.setSize(400, 333);
				{
					jTextArea1 = new JTextArea();
					jScrollPane1.setViewportView(jTextArea1);
					jTextArea1.setText("��ӭʹ�ú���Ʊ��ϵͳ�����\n");
				}
			}
			{
				jButton_Start = new JButton();
				this.add(jButton_Start);
				jButton_Start.setText("\u542f\u52a8");
				jButton_Start.setBounds(445, 45, 86, 39);
				jButton_Start.setSize(86, 40);
				jButton_Start.setIcon(Resources.getStartIcon());
			}
			{
				jButton_Stop = new JButton();
				this.add(jButton_Stop);
				jButton_Stop.setText("\u505c\u6b62");
				jButton_Stop.setBounds(445, 125, 86, 40);
				jButton_Stop.setIcon(Resources.getStopIcon());
				jButton_Stop.setEnabled(false);
			}
			{
				jButton_Exit = new JButton();
				this.add(jButton_Exit);
				jButton_Exit.setText("\u9000\u51fa");
				jButton_Exit.setBounds(445, 204, 86, 40);
				jButton_Exit.setIcon(Resources.getExitIcon());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
