package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MessageEx extends JFrame {

	public MessageEx() {
		
		setLayout(new FlowLayout());		
		
		JButton button1 = new JButton("Message");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MessageEx.this, "Message");
			}
		});
		add(button1);
		
		JButton button2 = new JButton("Confirm");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(MessageEx.this, 
						"Do you want to exit?", "EXIT", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		add(button2);
		
		JButton button3 = new JButton("Input");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(MessageEx.this, "Input name");
				JOptionPane.showMessageDialog(MessageEx.this, "Welcome " + name);
			}
		});
		add(button3);
		
		JButton button4 = new JButton("Option");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] str = {"ADD", "UPDATE", "DELETE"};
				JOptionPane.showOptionDialog(MessageEx.this, "SELECT MENU", "OPTION", 
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, 
						null, str, str[0]);
				
			}
		});
		add(button4);
		
		setSize(350, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MessageEx();
	}
}
