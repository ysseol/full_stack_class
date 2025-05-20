package io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Directory extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfDirectory;
	private JTextArea ta;
	
	public Directory() {
		
		setLayout(null);
		
		tfDirectory = new JTextField();
		tfDirectory.setBounds(28, 22, 228, 21);
		add(tfDirectory);
		tfDirectory.setColumns(10);
		
		JButton button1 = new JButton("OK");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String directory = tfDirectory.getText();
				File file = new File(directory);
				String[] list = file.list();
				ta.setText("");
				for (int i = 0; i < list.length; i++) {
					File f = new File(directory, list[i]);
					String str = f.isDirectory() ? "Directory" : "File";
					ta.append(str + ":" + list[i] + "\n");
				}
			}
		});
		button1.setBounds(268, 21, 97, 23);
		add(button1);
		
		ta = new JTextArea();
		ta.setBounds(28, 53, 350, 350);
		add(ta);
		
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Directory();
	}
}
