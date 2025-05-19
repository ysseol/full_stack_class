package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyColorAction implements ActionListener {
	private JFrame f;
	private Color c;
	private Container con;
	
	public MyColorAction(JFrame f, Color c) {
		this.f = f;
		con = f.getContentPane();
		this.c = c;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		con.setBackground(c);
	}
}

public class EventEx3 extends JFrame {
	
	private JButton button1, button2, button3;
	
	public EventEx3() {
		setLayout(new FlowLayout());
		
		button1 = new JButton("Red");
		button2 = new JButton("Green");
		button3 = new JButton("Blue");
		
		add(button1);
		add(button2);
		add(button3);
		
		button1.addActionListener(new MyColorAction(this, Color.red));
		button2.addActionListener(new MyColorAction(this, Color.green));
		button3.addActionListener(new MyColorAction(this, Color.blue));
		
		setSize(450, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new EventEx3();
	}
}
