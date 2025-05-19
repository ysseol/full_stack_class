package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Point extends JFrame {

	private JTextField tfName;
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMath;
	private JTextArea ta;
	private String name;
	private int kor, eng, math, tot;
	private double avg;
	
	public Point() {
		
		setLayout(null);
		
		JLabel lblName = new JLabel("이름");
		lblName.setBounds(34, 26, 57, 15);
		add(lblName);
		
		tfName = new JTextField();
		tfName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = tfName.getText();
				if (name.equals("")) {
					check("이름을 입력하세요", tfName);
					return;
				}
				tfKor.requestFocus();
			}
		});
		tfName.setBounds(114, 23, 116, 21);
		add(tfName);
		tfName.setColumns(10);
		
		JLabel lblKor = new JLabel("국어");
		lblKor.setBounds(34, 57, 57, 15);
		add(lblKor);
		
		tfKor = new JTextField();
		tfKor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strKor = tfKor.getText();
				if (strKor.equals("")) {
					check("국어점수를 입력하세요.", tfKor);
					return;
				}
				tfEng.requestFocus();
			}
		});
		tfKor.setColumns(10);
		tfKor.setBounds(114, 54, 116, 21);
		add(tfKor);
		
		JLabel lblEng = new JLabel("영어");
		lblEng.setBounds(34, 90, 57, 15);
		add(lblEng);
		
		tfEng = new JTextField();
		tfEng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strEng = tfEng.getText();
				if (strEng.equals("")) {
					check("영어점수를 입력하세요.", tfEng);
					return;
				}
				tfMath.requestFocus();
			}
		});
		tfEng.setColumns(10);
		tfEng.setBounds(114, 87, 116, 21);
		add(tfEng);
		
		JLabel lblMath = new JLabel("수학");
		lblMath.setBounds(34, 120, 57, 15);
		add(lblMath);
		
		tfMath = new JTextField();
		tfMath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strMath = tfMath.getText();
				if (strMath.equals("")) {
					check("수학점수를 입력하세요.", tfMath);
					return;
				}
				calc();
			}
		});
		tfMath.setColumns(10);
		tfMath.setBounds(114, 117, 116, 21);
		add(tfMath);
		
		JButton btnEval = new JButton("계산");
		btnEval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calc();
			}
		});
		btnEval.setBounds(30, 163, 97, 23);
		add(btnEval);
		
		getRootPane().setDefaultButton(btnEval);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfName.setText("");
				tfKor.setText("");
				tfEng.setText("");
				tfMath.setText("");
				ta.setText("");
				tfName.requestFocus();
			}
		});
		btnCancel.setBounds(133, 163, 97, 23);
		add(btnCancel);
		
		ta = new JTextArea();
		ta.setBounds(34, 201, 196, 144);
		add(ta);
		
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void check(String message, JTextField tf) {
		JOptionPane.showConfirmDialog(Point.this, message);
		tf.requestFocus();
	}
	
	void calc() {
		name = tfName.getText();
		if (name.equals("")) {
			check("이름을 입력하세요", tfName);
			return;
		}
		String strKor = tfKor.getText();
		if (strKor.equals("")) {
			check("국어점수를 입력하세요.", tfKor);
			return;
		}
		String strEng = tfEng.getText();
		if(strEng.equals("")) {
			check("영어점수를 입력하세요.", tfEng);
			return;
		}
		String strMath = tfMath.getText();
		if(strMath.equals("")) {
			check("수학점수를 입력하세요.", tfMath);
			return;
		}
		kor = Integer.parseInt(strKor);
		eng = Integer.parseInt(strEng);
		math = Integer.parseInt(strMath);
		tot = kor + eng + math;
		avg = tot / 3.0;
		String result = "이름:" + name + "\n" + "총점:" + tot + "\n" + "평균:" + String.format("%.2f", avg);
		ta.setText(result);
	}
	
	public static void main(String[] args) {
		new Point();
	}
}
