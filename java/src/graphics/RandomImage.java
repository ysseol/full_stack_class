package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RandomImage extends JFrame {
	
	private DrawCanvas canvas;
	private Random random = new Random();
	private Image imgCross;
	private Image imgNought;

	public RandomImage() {
		imgCross = Toolkit.getDefaultToolkit().getImage(getClass().getResource("cross.gif"));
		imgNought = Toolkit.getDefaultToolkit().getImage(getClass().getResource("nought.gif"));
		
		canvas = new DrawCanvas();
		canvas.setPreferredSize(new Dimension(270, 270));
		setContentPane(canvas);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	class DrawCanvas extends JPanel {
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			
			setBackground(Color.WHITE);
			for (int row = 0; row < 3; row++) {
				for (int col = 0; col < 3; col++) {
					boolean useCross = random.nextBoolean();
					if (useCross) {
						g.drawImage(imgCross, 90 * col + 20, 90 * row + 20, this);
					} else {
						g.drawImage(imgNought, 90 * col + 20, 90 * row + 20, this);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new RandomImage();
	}
}
