package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import dao.DrugstockDAO;
import model.Adddrug;
import model.Drugstock;
import model.Useregister;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import Class.ManagerClass;
import javax.swing.SwingConstants;

public class Manager extends JFrame {

	private JPanel contentPane;
	static Manager frame = new Manager();
	private JTable table;

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
	public Manager() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 723, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 687, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		final JRadioButton useRadioButton = new JRadioButton("\u4F7F\u7528\u767B\u8BB0\u8868");
		useRadioButton.setBounds(24, 17, 121, 23);
		panel.add(useRadioButton);
		
		final JRadioButton drugRadioButton = new JRadioButton("\u836F\u54C1\u5E93\u5B58");
		drugRadioButton.setBounds(264, 17, 121, 23);
		panel.add(drugRadioButton);
		
		final JRadioButton addRadioButton = new JRadioButton("\u836F\u54C1\u8865\u8D27\u5355");
		addRadioButton.setBounds(503, 17, 121, 23);
		panel.add(addRadioButton);
		
		ButtonGroup buttongroup = new ButtonGroup();
		buttongroup.add(useRadioButton);
		buttongroup.add(drugRadioButton);
		buttongroup.add(addRadioButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 687, 274);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 350, 687, 66);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton backbtn = new JButton("\u8FD4\u56DE");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				UseDrug.frame.show();
			}
		});
		backbtn.setBounds(568, 33, 93, 23);
		panel_1.add(backbtn);
		
		JButton changebtn = new JButton("\u4FEE\u6539");
		changebtn.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				if(-1 == table.getSelectedRow()){
					JOptionPane.showMessageDialog(null, "请选择一个信息！", "错误", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int i = table.getSelectedRow();
				if(useRadioButton.isSelected()){
					return;
				}
				if(drugRadioButton.isSelected()){
					DrugstockDAO drugstockdao = new DrugstockDAO();
					Drugstock drugstock = drugstockdao.findById(table.getValueAt(i, 0).toString());
					ModifyStock.frame = new ModifyStock(drugstock);
					ModifyStock.frame.show();
					
				}
				if(addRadioButton.isSelected()){
					return;
				}
			}

			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		changebtn.setBounds(446, 33, 93, 23);
		panel_1.add(changebtn);
		
		JButton addbtn = new JButton("\u589E\u52A0");
		addbtn.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				if(useRadioButton.isSelected()){
					return;
				}
				if(drugRadioButton.isSelected()){
					ModifyStock.frame = new ModifyStock();
					ModifyStock.frame.show();
				}
				if(addRadioButton.isSelected()){
					return;
				}
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		addbtn.setBounds(323, 33, 93, 23);
		panel_1.add(addbtn);
		
		JButton deletebtn = new JButton("\u6E05\u7A7A\u8865\u8D27\u5355");
		deletebtn.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				if(useRadioButton.isSelected()){
					return;
				}
				if(drugRadioButton.isSelected()){
					return;
				}
				if(addRadioButton.isSelected()){
					final DefaultTableModel dtm = (DefaultTableModel)table.getModel();
					String[] colName = {"药品名称","药品数量"};
					dtm.setRowCount(0);
					dtm.setColumnIdentifiers(colName);
					ManagerClass mc = new ManagerClass();
					mc.deleteAdd();
				}
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		deletebtn.setBounds(190, 33, 100, 23);
		panel_1.add(deletebtn);
		
		JButton stockbtn = new JButton("\u8865\u5145\u5E93\u5B58");
		stockbtn.setBounds(67, 33, 93, 23);
		panel_1.add(stockbtn);
		stockbtn.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				if(useRadioButton.isSelected()){
					return;
				}
				if(drugRadioButton.isSelected()){
					ManagerClass mc = new ManagerClass();
					mc.addStock();
				}
				if(addRadioButton.isSelected()){
					return;
				}
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		
		useRadioButton.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				updateUse();
			}

			@Override
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		drugRadioButton.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				updateStock();
			}
			public void mousePressed(MouseEvent e) {
				updateStock();
			}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		addRadioButton.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				updateAdd();
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
	}
	
	//显示使用登记表
	public void updateUse(){
		final DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		String[] colName = {"姓名","编号","药品名称","使用数量","日期"};
		dtm.setRowCount(0);
		dtm.setColumnIdentifiers(colName);
		ManagerClass mc = new ManagerClass();
		List list = mc.findALLRegister();
		Vector vector;
		for(int i = 0;i < list.size();i++){
			vector = new Vector();
			vector.add(((Useregister)list.get(i)).getUserName());
			vector.add(((Useregister)list.get(i)).getUserNum());
			vector.add(((Useregister)list.get(i)).getDrugName());
			vector.add(((Useregister)list.get(i)).getDrugCount());
			vector.add(((Useregister)list.get(i)).getDate());
			
			dtm.addRow(vector);
		}
	}
	//显示库存
	public void updateStock(){
		final DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		String[] colName = {"药品名称","药品库存","用量限制","见光性","挥发性","备注","药品单价"};
		dtm.setRowCount(0);
		dtm.setColumnIdentifiers(colName);
		ManagerClass mc = new ManagerClass();
		List list = mc.findAllDrug();
		Vector vector;
		for(int i = 0;i < list.size();i++){
			vector = new Vector();
			vector.add(((Drugstock)list.get(i)).getDrugName());
			vector.add(((Drugstock)list.get(i)).getDrugCount());
			vector.add(((Drugstock)list.get(i)).getDrugLimit());
			vector.add(((Drugstock)list.get(i)).getDrugLight());
			vector.add(((Drugstock)list.get(i)).getDrugVolat());
			vector.add(((Drugstock)list.get(i)).getRemark());
			vector.add(((Drugstock)list.get(i)).getDrugUnitPrice());
			dtm.addRow(vector);
		}
	}
	
	//显示补货单
	public void updateAdd(){
		final DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		String[] colName = {"药品名称","药品数量"};
		dtm.setRowCount(0);
		dtm.setColumnIdentifiers(colName);
		ManagerClass mc = new ManagerClass();
		List list = mc.findAllAdd();
		Vector vector;
		for(int i = 0;i < list.size();i++){
			vector = new Vector();
			vector.add(((Adddrug)list.get(i)).getDrugName());
			vector.add(((Adddrug)list.get(i)).getDrugCount());
			
			dtm.addRow(vector);
		}
	}
}
