package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Circle extends JFrame {
	private JPanel contentPane;
	private JTextField tfR;
	private JLabel lblResult;
	
	public Circle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblR = new JLabel("반지름");
		lblR.setBounds(36, 41, 57, 15);
		contentPane.add(lblR);
		
		lblResult = new JLabel("");
		lblResult.setForeground(Color.BLUE);
		lblResult.setFont(new Font("굴림", Font.BOLD, 16));
		lblResult.setBounds(37, 130, 204, 111);
		contentPane.add(lblResult);
		
		JButton button1 = new JButton("계산");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!tfR.getText().equals("")) {
					try {
						double r = Double.parseDouble(tfR.getText());
						double a = 2 * Math.PI * r;
						double b = Math.PI * r * r;
						String txt = "<html>반지름:" + r + "<br>둘레" + String.format("%.2f", a)
								+ "<br>넓이:" + String.format("%.2f", b) + "</html>";
						lblResult.setText(txt);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(Circle.this, "숫자만 입력하세요.");
					}
				}
			}
		});
		button1.setBounds(36, 85, 97, 23);
		contentPane.add(button1);
		
		tfR = new JTextField();
		tfR.setBounds(129, 38, 116, 21);
		contentPane.add(tfR);
		tfR.setColumns(10);
	}
	
	public static void main(String[] args) {
		Circle frame = new Circle();
		frame.setVisible(true);
	}
}
