package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Age extends JFrame {
	private JTextField tfName;
	private JTextField tfYear;
	private JLabel lblResult;
	
	public Age() {
		setLayout(null);
		
		JLabel lblName = new JLabel("이름");
		lblName.setBounds(36, 41, 57, 15);
		add(lblName);
		
		JLabel lblYear = new JLabel("출생연도");
		lblYear.setBounds(36, 98, 57, 15);
		add(lblYear);
		
		lblResult = new JLabel("");
		lblResult.setForeground(Color.BLUE);
		lblResult.setFont(new Font("굴림", Font.BOLD, 16));
		lblResult.setBounds(36, 197, 204, 111);
		add(lblResult);
		
		JButton button1 = new JButton("계산");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				int year = Integer.parseInt(tfYear.getText());
				int age = 2024 - year;
				String txt = "<html>이름:" + name + "<br>출생연도:" + year + "<br>나이:" + age + "세</html>";
				lblResult.setText(txt);
			}
		});
		button1.setBounds(35, 152, 97, 23);
		add(button1);
		
		tfName = new JTextField();
		tfName.setBounds(129, 38, 116, 21);
		add(tfName);
		tfName.setColumns(10);
		
		tfYear = new JTextField();
		tfYear.setBounds(129, 95, 116, 21);
		add(tfYear);
		tfYear.setColumns(10);
		
		setSize(300, 350);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Age();
	}
}
