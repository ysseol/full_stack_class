package thread;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;

class MyFrame extends JFrame implements Runnable {
	private int x, y = 50;
	private int moveX = 2, moveY = 3;
	private Graphics bg;
	private Image offScreen;
	private Dimension dim;
	public MyFrame() {
		setSize(500, 500);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		dim = getSize();
		offScreen = createImage(dim.width, dim.height);
		bg = offScreen.getGraphics();
		Thread t = new Thread(this);
		t.start();
	}
	@Override
	public void update(Graphics g) {
		bg.setColor(Color.yellow);
		bg.fillRect(0, 0, getWidth(), getHeight());
		bg.setColor(Color.green);
		bg.fillOval(x, y, 30, 30);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(offScreen, 0, 0, this);
		update(g);
	}
	@Override
	public void run() {
		while (true) {
			if (x > (dim.width - 30) || x < 0) {
				moveX = -moveX;
			}
			x = x + moveX;
			if (y > (dim.height - 30) || y < 30) {
				moveY = -moveY;
			}
			y = y + moveY;
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Ball {
	public static void main(String[] args) {
		new MyFrame();
	}
}
