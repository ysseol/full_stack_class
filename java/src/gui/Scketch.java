package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Scketch extends JFrame {
	private List<List<Point>> curves = new ArrayList<>();
	
	class MyPanel extends JPanel implements MouseListener, MouseMotionListener {
		MyPanel() {
			addMouseListener(this);
			addMouseMotionListener(this);
		}
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D g2 = (Graphics2D) g;
			
			for (List<Point> curve : curves) {
				Point previousPoint = curve.get(0);
				for (Point point : curve) {
					g2.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, 0));
					g.setColor(Color.blue);
					g.drawLine(previousPoint.x, previousPoint.y, point.x, point.y);
					previousPoint = point;
				}
			}
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			curves.get(curves.size() - 1).add(new Point(e.getX(), e.getY()));
			repaint(0, 0, getWidth(), getHeight());
		}
		
		@Override
		public void mouseMoved(MouseEvent e) {
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			List<Point> items = new ArrayList<Point>();
			items.add(new Point(e.getX(), e.getY()));
			curves.add(items);
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
	}
	
	public Scketch() {
		MyPanel panel = new MyPanel();
		add(panel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Scketch();
	}
}
