package graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel {
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setStroke(new BasicStroke(10));
		g.drawLine(10, 20, 200, 20);
		
		g2.setStroke(new BasicStroke(1));
		g.setColor(Color.red);
		g.drawRect(120, 40, 90, 55);
		g.fillRect(120, 140, 90, 55);
		g.setColor(Color.blue);
		g.fillRoundRect(120, 240, 90, 55, 40, 40);
		g.drawOval(0, 40, 90, 55);
		g.fillOval(0, 140, 90, 55);
		
		int[] x = { 10, 30, 50, 40, 20 };
		int[] y = { 257, 240, 257, 280, 280 };
		g.setColor(Color.yellow);
		g.fillPolygon(x, y, x.length);
	}
}

public class Shapes extends JFrame {
	public Shapes() {
		MyPanel panel = new MyPanel();
		add(panel);
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Shapes();
	}
}
