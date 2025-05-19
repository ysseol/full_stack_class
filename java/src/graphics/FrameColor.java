package graphics;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class FrameColor extends JFrame {
	public FrameColor() throws Exception {
		
		setVisible(true);
		Container c = getContentPane();
		
		for (int i = 0; i <= 255; i++) {
			setSize(i * 2, i);
			setLocation(i * 2, i);
			c.setBackground(new Color(i, 0, 0));
			Thread.sleep(10);
		}
		
		for (int i = 0; i <= 255; i++) {
			setSize(i * 2, i);
			setLocation(i * 2, i);
			c.setBackground(new Color(255, i, 0));
			Thread.sleep(10);
		}
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) throws Exception {
		new FrameColor();
	}
}
