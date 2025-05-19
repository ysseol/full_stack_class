package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Taxi extends JFrame {
	
	private JTextField tfkm;
	private int fee;
	private int bonus1, bonus2;
	private int total;
	private JLabel lblResult;
	private JCheckBox ck1;
	private JCheckBox ck2;
	
	public Taxi() {
		setLayout(null);
		
		JLabel lblDistance = new JLabel("운행거리(km)");
		lblDistance.setBounds(22, 42, 80, 15);
		add(lblDistance);
		
		tfkm = new JTextField();
		tfkm.setBounds(106, 39, 116, 21);
		add(tfkm);
		tfkm.setColumns(10);
		
		JButton btnEval = new JButton("계산");
		btnEval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eval();
			}
		});
		btnEval.setBounds(107, 105, 97, 23);
		add(btnEval);
		
		JLabel label = new JLabel("요금 : ");
		label.setBounds(46, 138, 57, 15);
		add(label);
		
		lblResult = new JLabel("");
		lblResult.setBounds(105, 138, 57, 15);
		add(lblResult);
		
		ck1 = new JCheckBox("심야할증");
		ck1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				eval();
			}
		});
		ck1.setBounds(106, 66, 115, 23);
		add(ck1);
		
		ck2 = new JCheckBox("시외요금");
		ck2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				eval();
			}
		});
		ck2.setBounds(237, 66, 115, 23);
		add(ck2);
		
		setSize(350, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void eval() {
		int m = Integer.parseInt(tfkm.getText()) * 1000;
		if (m <= 2000) {
			fee = 4800;
		} else {
			int temp = m - 2000;
			fee = 4800 + (((int) Math.ceil(temp / 140.0)) * 150);
		}
		bonus1 = ck1.isSelected() ? (int) (fee * 0.2) : 0;
		bonus2 = ck2.isSelected() ? (int) (fee * 0.2) : 0;
		total = fee + bonus1 + bonus2;
		lblResult.setText(total + "");
	}
	
	public static void main(String[] args) {
		new Taxi();
	}

}
