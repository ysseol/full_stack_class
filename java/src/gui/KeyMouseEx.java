package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class KeyMouseEx extends JFrame implements KeyListener, MouseListener, MouseMotionListener{

	private int x, y;
	private int width, height;
	private Image img;
	
	public KeyMouseEx() {
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("cat.png"));
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		width = img.getWidth(this);
		height = img.getHeight(this);
		g.drawImage(img, x, y, this);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			y = Math.max(50, y - 5);
			break;
		case KeyEvent.VK_DOWN:
			y = Math.min(480 - height, y + 5);
			break;
		case KeyEvent.VK_LEFT:
			x = Math.max(20, x - 5);
			break;
		case KeyEvent.VK_RIGHT:
			x = Math.min(480 - width, x + 5);
			break;
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	public static void main(String[] args) {
		new KeyMouseEx();
	}
}
