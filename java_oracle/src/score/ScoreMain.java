package score;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ScoreMain extends JFrame {

	private JTable table;
	private ScoreDAO dao;
	private Vector data, cols;
	
	public ScoreMain() {
		setLayout(null);
		
		JButton btnAdd = new JButton("추가");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveScore form = new SaveScore(ScoreMain.this);
				form.setVisible(true);
				form.setLocation(200, 200);
			}
		});
		btnAdd.setBounds(12, 24, 97, 23);
		add(btnAdd);
		
		JButton btnEdit = new JButton("수정/삭제");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idx = table.getSelectedRow();
				if (idx == -1) {
					JOptionPane.showMessageDialog(ScoreMain.this, "편집할 레코드를 선택하세요.");
					return;
				}
				String student_no = String.valueOf(table.getValueAt(idx, 0));
				String name = String.valueOf(table.getValueAt(idx, 1));
				int kor = Integer.valueOf(table.getValueAt(idx, 2) + "");
				int eng = Integer.valueOf(table.getValueAt(idx, 3) + "");
				int mat = Integer.valueOf(table.getValueAt(idx, 4) + "");
				
				ScoreDTO dto = new ScoreDTO(student_no, name, kor, eng, mat);
				EditScore form = new EditScore(ScoreMain.this, dto);
				form.setVisible(true);
			}
		});
		btnEdit.setBounds(133, 24, 97, 23);
		add(btnEdit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 72, 382, 291);
		add(scrollPane);
		
		dao = new ScoreDAO();
		cols = new Vector();
		cols.add("학번");
		cols.add("이름");
		cols.add("국어");
		cols.add("영어");
		cols.add("수학");
		cols.add("총점");
		cols.add("평균");
		
		table = new JTable();
		refreshTable();
		scrollPane.setViewportView(table);
		
		setSize(450, 450);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void refreshTable() {
		DefaultTableModel model = new DefaultTableModel(dao.listScore(), cols);
		table.setModel(model);
	}
	
	public static void main(String[] args) {
		new ScoreMain();
	}
}
