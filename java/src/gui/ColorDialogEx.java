package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ColorDialogEx extends JFrame {
	
	public ColorDialogEx() {
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("메뉴");
		menuBar.add(menu);
	
		JMenuItem miColor = new JMenuItem("색상 선택");
		miColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(ColorDialogEx.this, "색상을 선택하세요", Color.blue);
				getContentPane().setBackground(color);
			}
		});
		menu.add(miColor);
		
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ColorDialogEx();
	}
}
