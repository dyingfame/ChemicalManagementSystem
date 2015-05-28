package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import Class.ModifyStockClass;
import model.Drugstock;

public class ModifyStock extends JFrame {

	private JPanel contentPane;
	private JTextField drugNametextField;
	private JTextField drugCounttextField;
	private JTextField drugLimittextField;
	private JTextField drugLighttextField;
	private JTextField drugVolattextField;
	private JTextField remarktextField;
	private JTextField unitPricetextField;
	static ModifyStock frame = new ModifyStock();
	JButton confirmbtn;

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
	public ModifyStock() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u836F\u54C1\u540D\u79F0\uFF1A");
		lblNewLabel.setBounds(10, 23, 79, 15);
		contentPane.add(lblNewLabel);
		
		drugNametextField = new JTextField();
		drugNametextField.setBounds(74, 20, 195, 21);
		contentPane.add(drugNametextField);
		drugNametextField.setColumns(10);
		
		JLabel label = new JLabel("\u836F\u54C1\u5E93\u5B58\uFF1A");
		label.setBounds(10, 56, 79, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u9650\u5236\u7528\u91CF\uFF1A");
		label_1.setBounds(10, 91, 79, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u89C1\u5149\u6027\uFF1A");
		label_2.setBounds(10, 125, 79, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u6325\u53D1\u6027\uFF1A");
		label_3.setBounds(10, 162, 79, 15);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u5B58\u50A8\u5907\u6CE8\uFF1A");
		label_4.setBounds(10, 198, 79, 15);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u836F\u54C1\u5355\u4EF7\uFF1A");
		label_5.setBounds(10, 235, 79, 15);
		contentPane.add(label_5);
		
		drugCounttextField = new JTextField();
		drugCounttextField.setColumns(10);
		drugCounttextField.setBounds(74, 53, 195, 21);
		contentPane.add(drugCounttextField);
		
		drugLimittextField = new JTextField();
		drugLimittextField.setColumns(10);
		drugLimittextField.setBounds(74, 88, 195, 21);
		contentPane.add(drugLimittextField);
		
		drugLighttextField = new JTextField();
		drugLighttextField.setColumns(10);
		drugLighttextField.setBounds(74, 122, 195, 21);
		contentPane.add(drugLighttextField);
		
		drugVolattextField = new JTextField();
		drugVolattextField.setColumns(10);
		drugVolattextField.setBounds(74, 159, 195, 21);
		contentPane.add(drugVolattextField);
		
		remarktextField = new JTextField();
		remarktextField.setColumns(10);
		remarktextField.setBounds(74, 195, 195, 21);
		contentPane.add(remarktextField);
		
		unitPricetextField = new JTextField();
		unitPricetextField.setColumns(10);
		unitPricetextField.setBounds(74, 232, 195, 21);
		contentPane.add(unitPricetextField);
		
		confirmbtn = new JButton("\u786E\u5B9A");
		confirmbtn.setBounds(24, 279, 93, 23);
		contentPane.add(confirmbtn);
		
		JButton cancelbtn = new JButton("\u53D6\u6D88");
		cancelbtn.setBounds(176, 279, 93, 23);
		contentPane.add(cancelbtn);
		confirmbtn.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				try{
					ModifyStockClass msc = new ModifyStockClass();
					if(msc.isDrugExist(drugNametextField.getText())){
						JOptionPane.showMessageDialog(null, "该药品已存在！！", "错误", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					Drugstock drugstock = new Drugstock();
					drugstock.setDrugName(drugNametextField.getText());
					drugstock.setDrugCount(Double.valueOf(drugCounttextField.getText()));
					drugstock.setDrugLimit(Double.valueOf(drugLimittextField.getText()));
					drugstock.setDrugLight(drugLighttextField.getText());
					drugstock.setDrugVolat(drugVolattextField.getText());
					drugstock.setRemark(remarktextField.getText());
					drugstock.setDrugUnitPrice(Double.valueOf(unitPricetextField.getText()));
					msc.addNewDrug(drugstock);
					JOptionPane.showMessageDialog(null, "添加成功！", "信息", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					Manager.frame.updateStock();
				}catch(NullPointerException ex){
					JOptionPane.showMessageDialog(null, "请将信息填写完整！", "错误", JOptionPane.ERROR_MESSAGE);
					return;
				}catch(NumberFormatException ex){
					return;
				}
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
	}
	
	public ModifyStock(Drugstock drugstock){
		this();
		MouseListener[] m = confirmbtn.getMouseListeners();
		for(int i = 0 ; i < m.length ; i++){
			confirmbtn.removeMouseListener(m[i]);
		}
		drugNametextField.setText(drugstock.getDrugName());
		drugCounttextField.setText(String.valueOf(drugstock.getDrugCount()));
		drugLimittextField.setText(String.valueOf(drugstock.getDrugLimit()));
		drugLighttextField.setText(drugstock.getDrugLight());
		drugVolattextField.setText(drugstock.getDrugVolat());
		remarktextField.setText(drugstock.getRemark());
		unitPricetextField.setText(String.valueOf(drugstock.getDrugUnitPrice()));
		
		confirmbtn.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				try{
					ModifyStockClass msc = new ModifyStockClass();
					Drugstock drugstock = new Drugstock();
					drugstock.setDrugName(drugNametextField.getText());
					drugstock.setDrugCount(Double.valueOf(drugCounttextField.getText()));
					drugstock.setDrugLimit(Double.valueOf(drugLimittextField.getText()));
					drugstock.setDrugLight(drugLighttextField.getText());
					drugstock.setDrugVolat(drugVolattextField.getText());
					drugstock.setRemark(remarktextField.getText());
					drugstock.setDrugUnitPrice(Double.valueOf(unitPricetextField.getText()));
					msc.mergeDrugStock(drugstock);
					JOptionPane.showMessageDialog(null, "修改成功！", "信息", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					Manager.frame.updateStock();
				}catch(NullPointerException ex){
					JOptionPane.showMessageDialog(null, "请将信息填写完整！", "错误", JOptionPane.ERROR_MESSAGE);
					return;
				}catch(NumberFormatException ex){
					return;
				}
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		
	}

}
