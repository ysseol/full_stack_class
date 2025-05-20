package io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FileRead extends JFrame {
	private JTextField tf;
	private JTextArea ta;
	
	public FileRead() {
		
		setLayout(null);
		
		tf = new JTextField();
		tf.setBounds(22, 20, 230, 21);
		add(tf);
		tf.setColumns(10);
		
		JButton button1 = new JButton("OK");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String file = tf.getText();
				String str = "";
				BufferedReader reader = null;
				try {
					reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
					ta.setText("");
					while ((str = reader.readLine()) != null) {
						ta.append(str + "\n");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				} finally {
					try {
						if (reader != null)
							reader.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		button1.setBounds(264, 19, 97, 23);
		add(button1);
		
		ta = new JTextArea();
		ta.setBounds(22, 51, 340, 200);
		add(ta);
		
		setSize(400, 350);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new FileRead();
	}
}
