package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ImageEx extends JFrame implements ActionListener {
	Image curImg;
	Panel p;
	JButton btnNormal, btnPart, btnScale, btnHori, btnVert, btnAll;
	Dimension d;
	
	int command;
	static final int SHOW_NORM = 0;
	static final int SHOW_PART = 1;
	static final int SHOW_SCALE = 2;
	static final int SHOW_HORI = 3;
	static final int SHOW_VERT = 4;
	static final int SHOW_ALL = 5;
	
	public ImageEx() {
		curImg = Toolkit.getDefaultToolkit().getImage(getClass().getResource("flower.jpg"));
		p = new Panel();
		btnNormal = new JButton("정상 그림");
		p.add(btnNormal);
		p.add(btnPart = new JButton("그림 일부"));
		p.add(btnScale = new JButton("축소"));
		p.add(btnHori = new JButton("좌우뒤집기"));
		p.add(btnVert = new JButton("상하뒤집기"));
		p.add(btnAll = new JButton("전부뒤집기"));
		add(p, BorderLayout.NORTH);
		btnNormal.addActionListener(this);
		btnPart.addActionListener(this);
		btnScale.addActionListener(this);
		btnHori.addActionListener(this);
		btnVert.addActionListener(this);
		btnAll.addActionListener(this);
		setSize(600, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ImageEx();
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn == btnNormal) {
			command = SHOW_NORM;
		} else if (btn == btnPart) {
			command = SHOW_PART;
		} else if (btn == btnScale) {
			command = SHOW_SCALE;
		} else if (btn == btnHori) {
			command = SHOW_HORI;
		} else if (btn == btnVert) {
			command = SHOW_VERT;
		} else if (btn == btnAll) {
			command = SHOW_ALL;
		}
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		d = p.getSize();
		switch (command) {
		case SHOW_NORM:
			g.drawImage(curImg, 0, 0, this);
			break;
		case SHOW_PART:
			g.drawImage(curImg, 0, d.height, 100, d.height + 100, 20, 20, 120, 120, this);
			break;
		case SHOW_SCALE:
			g.drawImage(curImg, 0, d.height, curImg.getWidth(this) / 2,
					d.height + curImg.getHeight(this) / 2, 0, 0,
					curImg.getWidth(this), curImg.getHeight(this), this);
			break;
		case SHOW_HORI:
			g.drawImage(curImg, curImg.getWidth(this), d.height, 0,
					curImg.getHeight(this) + d.height, 0, 0, 
					curImg.getWidth(this), curImg.getHeight(this), this);
			break;
		case SHOW_VERT:
			g.drawImage(curImg, 0, d.height + curImg.getHeight(this),
					curImg.getWidth(this), d.height, 0, 0,
					curImg.getWidth(this), curImg.getHeight(this), this);
			break;
		case SHOW_ALL:
			g.drawImage(curImg, curImg.getWidth(this), 
					curImg.getHeight(this) + d.height, 0, d.height, 0, 0, 
					curImg.getWidth(this), curImg.getHeight(this), this);
			break;
		}
	}
}
