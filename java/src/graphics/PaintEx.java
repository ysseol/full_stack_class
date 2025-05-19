package graphics;

import java.awt.Graphics;

import javax.swing.JFrame;

public class PaintEx extends JFrame{
	public PaintEx() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawString("hello java", 10, 60);
		System.out.println("paint method 호출");
	}
	
	public static void main(String[] args) {
		new PaintEx();
	}
}
