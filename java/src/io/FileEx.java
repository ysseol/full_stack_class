package io;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class FileEx extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfFileName;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileEx frame = new FileEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FileEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("File:");
		lblNewLabel.setBounds(12, 22, 57, 15);
		contentPane.add(lblNewLabel);
		tfFileName = new JTextField();
		tfFileName.setBounds(81, 19, 266, 21);
		contentPane.add(tfFileName);
		tfFileName.setColumns(10);
		JButton button1 = new JButton("OK");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File(tfFileName.getText());
				if (!file.exists()) {
					try {
						file.createNewFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				String str = "Name:" + file.getName() + "\n" + "Length:" + file.length() 
				+ "\n" + "Parent:" + file.getParent();
				ta.setText(str);
			}
		});
		button1.setBounds(359, 18, 64, 23);
		contentPane.add(button1);
		ta = new JTextArea();
		ta.setBounds(12, 57, 411, 174);
		contentPane.add(ta);
	}
}
