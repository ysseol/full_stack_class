package gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Random;

import javax.swing.JFrame;

class BallCanvas extends Canvas implements Runnable, ComponentListener {
	private int x, y;
	private int moveX = 2, moveY = 3;
	private int red, green, blue;
	private Random random;
	private int width, height;
	private Image offImage;
	private Graphics bg;
	
	public BallCanvas() {
		addComponentListener(this);
		random = new Random();
		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void update(Graphics g) {
		Dimension d = getSize();
		if (offImage == null) {
			offImage = createImage(d.width, d.height);
			bg = offImage.getGraphics();
		}
		bg.setColor(getBackground());
		bg.fillRect(0, 0, d.width, d.height);
		bg.setColor(new Color(red, green, blue));
		bg.fillOval(x,  y, 20, 20);
		paint(g);
	}
	
	@Override
	public void paint(Graphics g) {
		if (offImage != null) {
			g.drawImage(offImage, 0, 0, null);
		}
		g.setColor(new Color(red, green, blue));
		g.fillOval(x, y, 20, 20);
	}
	
	public void setColor() {
		red = random.nextInt(256);
		green = random.nextInt(256);
		blue = random.nextInt(256);
	}
	
	@Override
	public void run() {
		while (true) {
			if (x > (width - 20) || x < 0) {
				setColor();
				moveX = -moveX;
			}
			if (y > (height - 30) || y < 0) {
				setColor();
				moveY = -moveY;
			}
			x = x + moveX;
			y = y + moveY;
			repaint();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void componentResized(ComponentEvent e) {
		width = getWidth();
		height = getHeight();
		offImage = createImage(width, height);
		bg = offImage.getGraphics();
	}
	
	@Override
	public void componentMoved(ComponentEvent e) {
	}
	
	@Override
	public void componentShown(ComponentEvent e) {
	}
	
	@Override
	public void componentHidden(ComponentEvent e) {
	}
}

public class CanvasEx  extends JFrame {
	
	public CanvasEx() {
		BallCanvas canvas = new BallCanvas();
		canvas.setBackground(Color.yellow);
		add(canvas);
		
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new CanvasEx();
	}
}
