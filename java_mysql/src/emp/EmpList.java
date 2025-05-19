package emp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class EmpList extends JFrame {
	private EmpDAO dao;
	private Vector cols;
	private DefaultTableModel model;
	private EmpDTO dto;
	
	private JTextField tfEmpno;
	private JTextField tfEname;
	private JTextField tfHiredate;
	private JTextField tfSal;
	private JTextField tfSearch;
	private JTable table;
	
	public EmpList() {
		setLayout(null);
		
		JLabel lblEmpno = new JLabel("사번");
		lblEmpno.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpno.setBounds(12, 13, 57, 15);
		add(lblEmpno);
		
		tfEmpno = new JTextField();
		tfEmpno.setBounds(81, 7, 116, 21);
		add(tfEmpno);
		tfEmpno.setColumns(10);
		
		JLabel lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(12, 46, 57, 15);
		add(lblName);
		
		tfEname = new JTextField();
		tfEname.setBounds(81, 40, 116, 21);
		add(tfEname);
		tfEname.setColumns(10);
		
		JLabel lblDate = new JLabel("입사일자");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setBounds(12, 79, 57, 15);
		add(lblDate);
		
		tfHiredate = new JTextField();
		tfHiredate.setBounds(81, 76, 116, 21);
		add(tfHiredate);
		tfHiredate.setColumns(10);
		
		JLabel lblSal = new JLabel("연봉");
		lblSal.setHorizontalAlignment(SwingConstants.CENTER);
		lblSal.setBounds(12, 110, 57, 15);
		add(lblSal);
		
		tfSal = new JTextField();
		tfSal.setBounds(81, 107, 116, 21);
		add(tfSal);
		tfSal.setColumns(10);
		
		JButton btnSave = new JButton("저장");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				int result = dao.insertEmp(dto);
				if (result == 1) {
					JOptionPane.showMessageDialog(EmpList.this, "저장되었습니다.");
					list();
					table.setModel(model);
					clear();
				}
			}
		});
		btnSave.setBounds(216, 6, 97, 23);
		add(btnSave);
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				int result = dao.updateEmp(dto);
				if (result == 1) {
					JOptionPane.showMessageDialog(EmpList.this, "수정되었습니다.");
					list();
					table.setModel(model);
					clear();
				}
			}
		});
		btnUpdate.setBounds(216, 42, 97, 23);
		add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int empno = Integer.parseInt(tfEmpno.getText());
				int result = 0;
				int response = JOptionPane.showConfirmDialog(EmpList.this, "삭제하시겠습니까?");
				if (response == JOptionPane.YES_OPTION) {
					result = dao.deleteEmp(empno);
					if (result == 1) {
						JOptionPane.showMessageDialog(EmpList.this, "삭제되었습니다.");
						list();
						table.setModel(model);
						clear();
					}
				}
			}
		});
		btnDelete.setBounds(216, 75, 97, 23);
		add(btnDelete);
		
		JLabel lblSearch = new JLabel("이름을 입력하세요");
		lblSearch.setBounds(12, 150, 137, 15);
		add(lblSearch);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(151, 147, 110, 21);
		add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnSearch.setBounds(273, 146, 77, 23);
		add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 183, 338, 212);
		add(scrollPane);
		
		dao = new EmpDAO();
		cols = new Vector();
		cols.add("사원번호");
		cols.add("사 원 명");
		cols.add("입사일자");
		cols.add("연 봉");
		list();
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int idx = table.getSelectedRow();
				tfEmpno.setEditable(false);
				tfEmpno.setText(table.getValueAt(idx, 0) + "");
				tfEname.setText(table.getValueAt(idx, 1) + "");
				tfHiredate.setText(table.getValueAt(idx, 2) + "");
				tfSal.setText(table.getValueAt(idx, 3) + "");
			}
		});
		scrollPane.setViewportView(table);
		
		setSize(400, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void input() {
		int empno = Integer.parseInt(tfEmpno.getText());
		String ename = tfEname.getText();
		String hiredate = tfHiredate.getText();
		int sal = Integer.parseInt(tfSal.getText());
		dto = new EmpDTO(empno, ename, hiredate, sal);
	}
	
	public void clear() {
		tfEmpno.setText("");
		tfEname.setText("");
		tfHiredate.setText("");
		tfSal.setText("");
		tfEmpno.requestFocus();
		tfEmpno.setEditable(true);
	}
	
	public void search() {
		String name = tfSearch.getText();
		model = new DefaultTableModel(dao.searchEmp(name), cols) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(model);;
	}
	
	public void list() {
		model = new DefaultTableModel(dao.searchEmp(""), cols) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	}
	
	public static void main(String[] args) {
		new EmpList();
	}
}
