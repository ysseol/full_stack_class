package graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class StringLine extends JFrame {
	public StringLine() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.setColor(Color.blue);
		g.drawLine(250, 50, 30, 160);
		
		g.setColor(Color.red);
		g.drawString("Red String", 10, 50);
		g.setColor(Color.green);
		g.drawString("Green String", 10, 80);
		g.setColor(Color.blue);
		g.drawString("Blue String", 10, 110);
	}
	
	public static void main(String[] args) {
		new StringLine();
	}
}
