package student;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableEx extends JFrame {
	
	private JTable table;
	private Vector data, cols;
	
	public JTableEx() {
		cols = new Vector();
		
		cols.add("학번");
		cols.add("이름");
		cols.add("국어");
		cols.add("영어");
		cols.add("수학");
		cols.add("총점");
		cols.add("평균");

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		ScoreDAO dao = new ScoreDAO();
		DefaultTableModel model = new DefaultTableModel(dao.list_score(), cols) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		setSize(500, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JTableEx();
	}
}
