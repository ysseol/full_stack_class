package gui;

import java.awt.BorderLayout;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class TabEx extends JFrame {

	public TabEx() {
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
		add(tab, BorderLayout.NORTH);
		
		Panel panel1 = new Panel();
		tab.addTab("탭1", null, panel1, null);
		
		JButton btnNewButton = new JButton("버튼1");
		btnNewButton.setIcon(new ImageIcon(TabEx.class.getResource("/gui/duke1.gif")));
		panel1.add(btnNewButton);
		
		Panel panel2 = new Panel();
		tab.addTab("탭2", null, panel2, null);
		
		JButton btnNewButton_1 = new JButton("버튼2");
		btnNewButton_1.setIcon(new ImageIcon(TabEx.class.getResource("/gui/duke2.gif")));
		panel2.add(btnNewButton_1);
		
		Panel panel3 = new Panel();
		tab.addTab("탭3", new ImageIcon(TabEx.class.getResource("/gui/duke3.gif")), panel3, null);
		
		setSize(500, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new TabEx();
	}
}
