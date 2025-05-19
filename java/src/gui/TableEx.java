package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableEx extends JFrame {

	private JTable table;
	
	public TableEx() {
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		String[] title = {"번호", "이름", "날짜"};
		String[][] data = { { "1", "kim", "2010-03-10" },
							{ "2", "park", "2011-03-10" },
							{ "3", "song", "2012-03-10" } };
		table = new JTable(data, title);
		scrollPane.setViewportView(table);
		
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new TableEx();
	}
}
