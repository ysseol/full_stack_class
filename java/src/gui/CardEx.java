package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CardEx extends JFrame {
	CardLayout card;
	Container con;
	
	public CardEx() {
		con = getContentPane();
		card = new CardLayout();
		
		setLayout(card);
		
		JPanel[] pan = new JPanel[5];
		Color[] color = {Color.red, Color.yellow, Color.green, Color.blue, Color.cyan};
		
		for (int i = 0; i < pan.length; i++) {
			pan[i] = new JPanel();
			pan[i].setBackground(color[i]);
			add("card" + i, pan[i]);
			
			pan[i].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					card.next(con);
//					card.previous(con);
				}
			});
		}
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new CardEx();
	}
}
