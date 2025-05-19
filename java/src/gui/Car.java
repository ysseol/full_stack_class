package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Car extends JFrame {
	
	private int[] moneys = {90000, 100000, 10000, 200000};
	private int sum;
	private JLabel lblResult;
	
	public Car() {
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JCheckBox ck1 = new JCheckBox("엔진오일 교환");
		ck1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					sum += moneys[0];
				} else {
					sum -= moneys[0];
				}
				putResult();
			}
		});
		panel.add(ck1);
		
		JCheckBox ck2 = new JCheckBox("자동변속기 오일 교환");
		ck2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					sum += moneys[1];
				} else {
					sum -= moneys[1];
				}
				putResult();
			}
		});
		panel.add(ck2);
		
		JCheckBox ck3 = new JCheckBox("에어컨 필터 교환");
		ck3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					sum += moneys[2];
				} else {
					sum -= moneys[2];
				}
				putResult();
			}
		});
		panel.add(ck3);
		
		JCheckBox ck4 = new JCheckBox("타이어 교환");
		ck4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					sum += moneys[3];
				} else {
					sum -= moneys[3];
				}
				putResult();
			}
		});
		panel.add(ck4);
		
		lblResult = new JLabel("");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("굴림", Font.PLAIN, 20));
		lblResult.setBackground(Color.yellow);
		
		add(lblResult, BorderLayout.CENTER);
		
		setSize(500, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void putResult() {
		lblResult.setText("<html><p style='background-color:yellow'>현재까지의 가격은 " + 
				String.format("%,d", sum) + "원입니다.</p></html>");
	}
	
	public static void main(String[] args) {
		new Car();
	}
}
