package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GuessNumber extends JFrame {
	
	private JTextField tfNum;
	private JLabel lblResult;
	private int com;
	private int user;
	private Random random;
	private int count;
	
	public GuessNumber() {
		setTitle("숫자 맞추기");
		
		setLayout(null);
		
		JLabel lblMessage = new JLabel("숫자를 입력하세요");
		lblMessage.setBounds(12, 30, 117, 15);
		add(lblMessage);
		
		tfNum = new JTextField();
		tfNum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				tfNum.setText("");
			}
		});
		tfNum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				user = Integer.parseInt(tfNum.getText());
				lblResult.setOpaque(true);
				if (user > com) {
					lblResult.setBackground(Color.green);
					lblResult.setText(count + "회 입력-더 작은 숫자를 입력하세요.");
				} else if (user < com) {
					lblResult.setBackground(Color.green);
					lblResult.setText(count + "회 입력-더 큰 숫자를 입력하세요.");
				} else if (user == com) {
					lblResult.setBackground(Color.yellow);
					lblResult.setText(count + "회만에 맞추셨습니다!!!");
				}
			}
		});
		tfNum.setBounds(124, 27, 206, 21);
		add(tfNum);
		tfNum.setColumns(10);
		
		lblResult = new JLabel("");
		lblResult.setBounds(124, 75, 230, 21);
		lblResult.setOpaque(true);
		add(lblResult);
		
		JButton btnRetry = new JButton("다시 한번");
		btnRetry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initialize();
			}
		});
		btnRetry.setBounds(73, 129, 97, 23);
		add(btnRetry);
		
		JButton btnExit = new JButton("종료");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "프로그램을 종료합니다.");
					System.exit(0);
			}
		});
		btnExit.setBounds(205, 129, 97, 23);
		add(btnExit);
		
		random = new Random();
		initialize();
		
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void initialize() {
		com = random.nextInt(100) + 1;
		lblResult.setText("");
		lblResult.setOpaque(false);
		count = 0;
		tfNum.requestFocus();
	}
	
	public static void main(String[] args) {
		new GuessNumber();
	}
}
