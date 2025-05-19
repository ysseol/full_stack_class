package student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.table.DefaultTableModel;

public class ScoreList extends JFrame {
	private ScoreDAO dao;
	private Vector<String> cols;
	private DefaultTableModel model;
	private ScoreDTO dto;
	private JTable table;
	private JTextField tfStudentNo;
	private JTextField tfName;
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMat;
	private JScrollPane scrollPane;
	private JButton btnSave;
	private JButton btnUpdate;
	private JTextField tfSearch;
	
	public ScoreList() {
		
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 175, 399, 217);
		add(scrollPane);
		
		dao = new ScoreDAO();
		cols = new Vector<String>();
		cols.add("학번");
		cols.add("이름");
		cols.add("국어");
		cols.add("영어");
		cols.add("수학");
		cols.add("총점");
		cols.add("평균");
		
		list();
		
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int idx = table.getSelectedRow();
				tfStudentNo.setEditable(false);
				tfStudentNo.setText(table.getValueAt(idx, 0) + "");
				tfName.setText(table.getValueAt(idx, 1) + "");
				tfKor.setText(table.getValueAt(idx, 2) + "");
				tfEng.setText(table.getValueAt(idx, 3) + "");
				tfMat.setText(table.getValueAt(idx, 4) + "");
			}
		});
		
		scrollPane.setViewportView(table);
		
		JLabel lblNo = new JLabel("학번");
		lblNo.setBounds(12, 10, 49, 15);
		add(lblNo);
		
		tfStudentNo = new JTextField();
		tfStudentNo.setBounds(61, 7, 116, 21);
		add(tfStudentNo);
		tfStudentNo.setColumns(10);
		
		JLabel lblName = new JLabel("이름");
		lblName.setBounds(12, 38, 49, 15);
		add(lblName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(61, 35, 116, 21);
		add(tfName);
		
		JLabel lblKor = new JLabel("국어");
		lblKor.setBounds(12, 66, 49, 15);
		add(lblKor);
		
		tfKor = new JTextField();
		tfKor.setColumns(10);
		tfKor.setBounds(61, 63, 116, 21);
		add(tfKor);
		
		JLabel lblEng = new JLabel("영어");
		lblEng.setBounds(12, 94, 49, 15);
		add(lblEng);
		
		tfEng = new JTextField();
		tfEng.setColumns(10);
		tfEng.setBounds(61, 91, 116, 21);
		add(tfEng);
		
		JLabel lblMath = new JLabel("수학");
		lblMath.setBounds(12, 122, 49, 15);
		add(lblMath);
		
		tfMat = new JTextField();
		tfMat.setColumns(10);
		tfMat.setBounds(61, 119, 116, 21);
		add(tfMat);
		
		btnSave = new JButton("저장");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				int result = dao.insert_score(dto);
				if (result == 1) {
					JOptionPane.showMessageDialog(ScoreList.this, "저장되었습니다.");
					list();
					table.setModel(model);
					clear();
				}
			}
		});
		
		btnSave.setBounds(189, 6, 97, 23);
		add(btnSave);
		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				int result = dao.update_score(dto);
				if (result == 1) {
					JOptionPane.showMessageDialog(ScoreList.this, "수정되었습니다.");
					list();
					table.setModel(model);
					clear();
				}
			}
		});
		
		btnUpdate.setBounds(189, 34, 97, 23);
		add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String student_no = tfStudentNo.getText();
				int result = 0;
				int response = JOptionPane.showConfirmDialog(ScoreList.this, "삭제하시겠습니까?");
				if (response == JOptionPane.YES_OPTION) {
					result = dao.delete_score(student_no);
				}
				if (result == 1) {
					JOptionPane.showMessageDialog(ScoreList.this, "삭제되었습니다.");
					list();
					table.setModel(model);
					clear();
				}
			}
		});
		
		btnDelete.setBounds(189, 62, 97, 23);
		add(btnDelete);
		
		JLabel lblSearch = new JLabel("이름을 입력하세요");
		lblSearch.setBounds(12, 147, 127, 15);
		add(lblSearch);
		
		tfSearch = new JTextField();
		tfSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				search();
			}
		});
		tfSearch.setBounds(125, 144, 116, 21);
		add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btnSearch = new JButton("찾기");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		
		btnSearch.setBounds(253, 143, 97, 23);
		add(btnSearch);
		
		setSize(450, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void search() {
		String name = tfSearch.getText();
		model = new DefaultTableModel(dao.search_score(name), cols) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(model);
	}
	
	public void input() {
		String student_no = tfStudentNo.getText();
		String name = tfName.getText();
		int kor = Integer.parseInt(tfKor.getText());
		int eng = Integer.parseInt(tfEng.getText());
		int mat = Integer.parseInt(tfMat.getText());
		dto = new ScoreDTO(student_no, name, kor, eng, mat);
	}
	
	public void clear() {
		tfStudentNo.setText("");
		tfName.setText("");
		tfKor.setText("");
		tfEng.setText("");
		tfMat.setText("");
		tfStudentNo.requestFocus();
		tfStudentNo.setEditable(true);
	}
	
	public void list() {
		model = new DefaultTableModel(dao.list_score(), cols) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	}
	
	public static void main(String[] args) {
		new ScoreList();
	}
}
