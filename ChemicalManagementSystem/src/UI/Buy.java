package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import Class.BuyClass;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Buy extends JFrame {

	private JPanel contentPane;
	private JTextField drugNametextField;
	private JTextField drugCounttextField;
	static Buy frame = new Buy();

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
	public Buy() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 310, 206);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u836F\u54C1\u540D\u79F0\uFF1A");
		lblNewLabel.setBounds(21, 40, 63, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u836F\u54C1\u6570\u91CF\uFF1A");
		label.setBounds(21, 75, 63, 15);
		contentPane.add(label);
		
		drugNametextField = new JTextField();
		drugNametextField.setBounds(94, 37, 161, 21);
		contentPane.add(drugNametextField);
		drugNametextField.setColumns(10);
		
		drugCounttextField = new JTextField();
		drugCounttextField.setColumns(10);
		drugCounttextField.setBounds(94, 72, 161, 21);
		contentPane.add(drugCounttextField);
		
		JButton confirmbtn = new JButton("\u786E\u5B9A");
		confirmbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyClass bc = new BuyClass();
				if(bc.isDrugExist(drugNametextField.getText()) == true){
					JOptionPane.showMessageDialog(null, "药品已存在！", "警告", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else{
					bc.submit(drugNametextField.getText(), Double.valueOf(drugCounttextField.getText()));
					JOptionPane.showMessageDialog(null, "申请成功！", "成功", JOptionPane.YES_OPTION);
					frame.dispose();
					UseDrug.frame.show();
				}
			}
		});
		confirmbtn.setBounds(30, 117, 93, 23);
		contentPane.add(confirmbtn);
		
		JButton cancelbtn = new JButton("\u53D6\u6D88");
		cancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				UseDrug.frame.show();
			}
		});
		cancelbtn.setBounds(162, 117, 93, 23);
		contentPane.add(cancelbtn);
		
		
		
	}
}
