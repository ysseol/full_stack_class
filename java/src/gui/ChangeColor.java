package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ChangeColor extends JFrame implements ItemListener {
	JRadioButton red, green, blue;
	ButtonGroup group;
	String color = "default";
	
	public ChangeColor() {
		setLayout(new BorderLayout());
		
		red = new JRadioButton("Red");
		green = new JRadioButton("Green");
		blue = new JRadioButton("Blue");
		
		red.addItemListener(this);
		green.addItemListener(this);
		blue.addItemListener(this);
		
		group = new ButtonGroup();
		
		group.add(red);
		group.add(green);
		group.add(blue);
		
		MyPanel panel = new MyPanel();
		JPanel panel2 = new JPanel();
		
		panel2.add(red);
		panel2.add(green);
		panel2.add(blue);
		
		add("North", panel2);
		add("Center", panel);
		
		setSize(300, 220);
		setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (red.isSelected()) {
			color = "RED";
			repaint();
		}
		if (blue.isSelected()) {
			color = "BLUE";
			repaint();
		}
		if (green.isSelected()) {
			color="GREEN";
			repaint();
		}
	}
	
	class MyPanel extends JPanel {
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			switch (color) {
			case "default":
				g.setColor(Color.black);
				break;
			case "RED":
				g.setColor(Color.red);
				break;
			case "BLUE":
				g.setColor(Color.blue);
				break;
			case "GREEN":
				g.setColor(Color.green);
				break;
			}
			g.fillOval(80, 30, 120, 80);
		}
	}
	
	public static void main(String[] args) {
		new ChangeColor();
	}
}
