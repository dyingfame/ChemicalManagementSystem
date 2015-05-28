package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import Class.UseDrugClass;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UseDrug extends JFrame {

	private JPanel contentPane;
	private JTextField userNametextField;
	private JTextField userNumtextField;
	private JTextField drugCounttextField;
	private DateChooser useDate;
	private String[] name = null;
	UseDrugClass udc = new UseDrugClass();
	static UseDrug frame = new UseDrug();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UseDrug() {
		JFrame.setDefaultLookAndFeelDecorated(true); 
	     try {
	    	 javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");

	     }catch (Exception e) {
	            e.printStackTrace();
	           }
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u4F7F\u7528\u8005\u59D3\u540D\uFF1A");
		label.setBounds(10, 74, 85, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u4F7F\u7528\u8005\u7F16\u53F7\uFF1A");
		label_1.setBounds(10, 111, 85, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u836F\u54C1\u540D\u79F0\uFF1A");
		label_2.setBounds(10, 150, 85, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u7533\u8BF7\u6570\u91CF\uFF1A");
		label_3.setBounds(10, 188, 85, 15);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u7533\u8BF7\u65E5\u671F\uFF1A");
		label_4.setBounds(10, 225, 85, 15);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u5316\u5B66\u5B9E\u9A8C\u5BA4\u4F7F\u7528\u767B\u8BB0\u8868");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		label_5.setBounds(10, 10, 294, 41);
		contentPane.add(label_5);
		
		userNametextField = new JTextField();
		userNametextField.setBounds(89, 71, 174, 21);
		contentPane.add(userNametextField);
		userNametextField.setColumns(10);
		
		userNumtextField = new JTextField();
		userNumtextField.setColumns(10);
		userNumtextField.setBounds(89, 108, 174, 21);
		contentPane.add(userNumtextField);
		
		drugCounttextField = new JTextField();
		drugCounttextField.setColumns(10);
		drugCounttextField.setBounds(89, 185, 174, 21);
		contentPane.add(drugCounttextField);
		
		final JComboBox drugNamecomboBox = new JComboBox();
		drugNamecomboBox.setBounds(89, 147, 174, 21);
		contentPane.add(drugNamecomboBox);
		name = udc.getDrugName();
		for(int i = 0;i < name.length;i++)
		{
			drugNamecomboBox.addItem(name[i]);
		}
		
		
		useDate = new DateChooser("yyyy-MM-dd");
		useDate.setBounds(89, 225, 174, 25);
		contentPane.add(useDate);
		
		//确认申请
		JButton confirmbtn = new JButton("\u786E\u8BA4\u7533\u8BF7");
		confirmbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(udc.judgeAbuse(drugNamecomboBox.getSelectedItem().toString(),drugCounttextField.getText()) == false){
					JOptionPane.showMessageDialog(null, "已超过药品使用限定量！", "警告", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(udc.judgeRemain(drugNamecomboBox.getSelectedItem().toString(),drugCounttextField.getText()) == false){
					JOptionPane.showMessageDialog(null, "库存不足！", "警告", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else
				udc.addToRegister(userNametextField.getText(),userNumtextField.getText(),
						drugNamecomboBox.getSelectedItem().toString(),Double.valueOf(drugCounttextField.getText()),useDate.getLabelText());
				udc.deleteCount(drugNamecomboBox.getSelectedItem().toString(),drugCounttextField.getText());
			}
		});
		confirmbtn.setBounds(24, 282, 116, 23);
		contentPane.add(confirmbtn);
		
		//管理员登录
		JButton loginbtn = new JButton("\u7BA1\u7406\u5458\u767B\u5F55");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.frame.show();
				frame.dispose();
			}
		});
		loginbtn.setBounds(24, 315, 116, 23);
		contentPane.add(loginbtn);
		
		//退出
		JButton button = new JButton("\u53D6\u6D88");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button.setBounds(168, 315, 116, 23);
		contentPane.add(button);
		
		JButton buybtn = new JButton("\u7533\u8BF7\u8D2D\u4E70");
		buybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Buy.frame.show();
			}
		});
		buybtn.setBounds(168, 282, 116, 23);
		contentPane.add(buybtn);
	}
}
