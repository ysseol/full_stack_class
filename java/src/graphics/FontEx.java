package graphics;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JFrame;

public class FontEx extends JFrame {
	private Font font;
	private FontMetrics fm;
	private int x, y;
	private String message;
	private Dimension dim;
	
	public FontEx() {
		message = "그래픽 테스트";
		font = new Font("굴림", Font.ITALIC, 30);
		fm = getFontMetrics(font);
		
		setSize(250, 250);
		dim = getSize();
		System.out.println("가로길이:" + dim.width + ",세로길이:" + dim.height);
		x = (dim.width / 2) - (fm.stringWidth(message) / 2);
		y = (dim.height / 2) - (fm.getDescent() / 2);
		System.out.println(fm.stringWidth(message));
		System.out.println(fm.getDescent());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(font);
		g.drawString(message, x, y);
	}
	
	public static void main(String[] args) {
		new FontEx();
	}
}
