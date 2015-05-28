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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField usertextField;
	static Login frame = new Login();
	private JPasswordField passwordField;

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
	public Login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 373, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setBounds(53, 64, 75, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u5BC6  \u7801\uFF1A");
		label.setBounds(53, 111, 75, 15);
		contentPane.add(label);
		
		usertextField = new JTextField();
		usertextField.setBounds(115, 61, 176, 21);
		contentPane.add(usertextField);
		usertextField.setColumns(10);
		
		//µÇÂ¼
		JButton loginbtn = new JButton("\u767B\u5F55");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!usertextField.getText().equals("admin")){
					JOptionPane.showMessageDialog(null, "ÓÃ»§Ãû´íÎó£¡£¡", "´íÎó", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else{
					if(!passwordField.getText().equals("admin")){
						JOptionPane.showMessageDialog(null, "ÃÜÂë´íÎó£¡£¡", "´íÎó", JOptionPane.ERROR_MESSAGE);
						return;
					}
					else{
						Manager.frame.show();
						frame.dispose();
					}
				}
			}
		});
		loginbtn.setBounds(74, 160, 92, 23);
		contentPane.add(loginbtn);
		
		//·µ»Ø
		JButton backbtn = new JButton("\u8FD4\u56DE");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				UseDrug.frame.show();
			}
		});
		backbtn.setBounds(200, 160, 92, 23);
		contentPane.add(backbtn);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("ËÎÌå", Font.PLAIN, 15));
		passwordField.setBounds(115, 108, 176, 21);
		contentPane.add(passwordField);
	}
}
