package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridEx extends JFrame {
	public GridEx() {
		
		setLayout(new GridLayout(2, 3));
		
		for (int i = 1; i <= 6; i++) {
			JButton button = new JButton("버튼" + i);
			add(button);
		}
		
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new GridEx();
	}
}
