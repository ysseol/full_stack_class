package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Game extends JFrame implements KeyListener, Runnable{
	private Image imgBackground;
	private Image imgGunship;
	private Image imgMissile;
	private Image imgEnemy;
	private Image imgHit;
	
	private File audioFire;
	private File audioHit;
	
	private int x, y = 450;
	private int mx = x + 10;
	private int my = y - 10;
	private int ex, ey = 50;
	private int moveEx = 2;
	private int hitX, hitY;
	private int point = 1000;
	
	private boolean hit;
	
	ArrayList<Missile> mlist = new ArrayList<Missile>();
	
	private Image offImage;
	private Graphics bg;
	
	public Game() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 500);
		setVisible(true);
		
		x = getWidth() / 2 - 15;
		mx = getWidth() / 2 - 2;
		ex = getWidth() - 25;
		
		offImage = createImage(getWidth(), getHeight());
		bg = offImage.getGraphics();
		
		imgBackground = Toolkit.getDefaultToolkit().getImage(getClass().getResource("space.png"));
		imgGunship = Toolkit.getDefaultToolkit().getImage(getClass().getResource("gunship.png"));
		imgMissile = Toolkit.getDefaultToolkit().getImage(getClass().getResource("missile.png"));
		imgEnemy = Toolkit.getDefaultToolkit().getImage(getClass().getResource("enemy.png"));
		imgHit = Toolkit.getDefaultToolkit().getImage(getClass().getResource("hit.png"));
		
		audioFire = new File("C:/work/java/src/graphics/fire.wav");
		audioHit = new File("C:/work/java/src/graphics/hit.wav");
		
		
		addKeyListener(this);
		setFocusable(true);
		requestFocus();
		Thread t = new Thread(this);
		t.start();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		bg.clearRect(0, 0, getWidth(), getHeight());
		bg.drawImage(imgBackground, 0, 0, this);
		bg.drawImage(imgGunship, x, y, this);
		
		for (int i = 0; i < mlist.size(); i++) {
			Missile m = mlist.get(i);
			bg.drawImage(imgMissile, m.getMx(), m.getMy(), this);
		}
		
		if (hit) {
			try {
				Clip clipHit = AudioSystem.getClip();
				clipHit.open(AudioSystem.getAudioInputStream(audioHit));
				clipHit.start();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			bg.drawImage(imgHit, hitX, hitY, this);
			hit = false;
		} else {
			bg.drawImage(imgEnemy, ex, ey, this);
		}
		bg.setColor(Color.white);
		bg.drawString("점수:" + point, 20, 70);
		
		g.drawImage(offImage, 0, 0, this);
	}
	
	@Override
	public void run() {
		while(true) {
			for (int i = 0; i < mlist.size(); i++) {
				Missile m = mlist.get(i);
				m.setMy(m.getMy() - 5);
				if(m.getMy() == 0) {
					mlist.remove(i);
				}
				
				Rectangle rect1 = new Rectangle(ex, ey, imgEnemy.getWidth(null), imgEnemy.getHeight(null));
				Rectangle rect2 = new Rectangle(m.getMx(), m.getMy(), imgMissile.getWidth(null), imgMissile.getHeight(null));
				
				if (rect1.intersects(rect2)) {
					hit = true;
					hitX = m.getMx() - 30;
					hitY = m.getMy() - 30;
					point = point + 100;
					setMissilePos();
					ex = getWidth() - 25;
					ey = 50;
					mlist.remove(i);
				}
			}
			ex = ex - moveEx;
			
			if (ex < 0 || ex > getWidth() - 25) {
				moveEx = -moveEx;
				ey = ey + 30;
			}
			
			if (ey == (getHeight() - imgGunship.getHeight(this) - 30)) {
				int result = JOptionPane.showConfirmDialog(this, "game over, restart?");
				if (result == JOptionPane.NO_OPTION) {
					System.exit(0);
				} else if (result == JOptionPane.YES_OPTION) {
					ex = getWidth() - 25;
					ey = 0;
					point = 1000;
				}
			}
			
			repaint();
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void setMissilePos() {
		mx = x + 13;
	}
	
	public void keyPressed(KeyEvent e) {
		
		switch (e.getKeyCode()) {
		
		case KeyEvent.VK_LEFT:
			x = Math.max(10, x - 10);
			setMissilePos();
			break;
		case KeyEvent.VK_RIGHT:
			x = Math.min(290 - imgGunship.getWidth(null), x + 10);
			setMissilePos();
			break;
		case KeyEvent.VK_F:
			Missile m = new Missile();
			m.setMx(x + imgGunship.getWidth(null) / 2);
			m.setMy(y);
			mlist.add(m);
			
			try {
				Clip clipFire = AudioSystem.getClip();
				clipFire.open(AudioSystem.getAudioInputStream(audioFire));
				clipFire.start();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			break;
		}
		
		repaint();
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	public static void main(String[] args) {
		new Game();
	}
}
