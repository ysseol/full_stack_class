package graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Animation extends JFrame implements Runnable {
	private Image[] img;
	private int idx;
	
	private Image offImage;
	private Graphics bg;
	
	public Animation() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
		
		Dimension d = getSize();
		if (offImage == null) {
			offImage = createImage(d.width, d.height);
			bg = offImage.getGraphics();
		}
		
		img = new Image[10];
		for (int i = 0; i < img.length; i++) {
			img[i] = Toolkit.getDefaultToolkit().getImage(getClass().getResource("duke"+(i+1)+".gif"));
		}
		Thread t = new Thread(this);
		t.start();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		bg.setColor(getBackground());
		bg.fillRect(0, 0, 300, 300);
		bg.drawImage(img[idx], 0, 0, null);
		if (offImage != null) {
			g.drawImage(offImage, 90, 73, this);
		}
	}
	
	@Override
	public void run() {
		while (true) {
			idx++;
			if (idx >= 10) {
				idx = 0;
			}
			repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new Animation();
	}
}
