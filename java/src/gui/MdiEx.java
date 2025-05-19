package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class MdiEx extends JFrame implements Runnable {

	private JProgressBar pb;
	private JLabel lblResult;
	private int sum;
	
	public MdiEx() {
		
		setLayout(null);
		
		JInternalFrame iframe = new JInternalFrame("내부 프레임");
		iframe.setIconifiable(true);
		iframe.setMaximizable(true);
		iframe.setClosable(true);
		iframe.setBounds(43, 23, 356, 305);
		add(iframe);
		iframe.getContentPane().setLayout(null);
		
		pb = new JProgressBar();
		pb.setStringPainted(true);
		pb.setBounds(14, 27, 294, 37);
		iframe.getContentPane().add(pb);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread th = new Thread(MdiEx.this);
				th.start();
			}
		});
		btnStart.setBounds(106, 100, 101, 25);
		iframe.getContentPane().add(btnStart);
		
		lblResult = new JLabel("");
		lblResult.setBounds(14, 162, 294, 31);
		iframe.getContentPane().add(lblResult);
		iframe.setVisible(true);
		
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void run() {
		sum = 0;
		for (int i = 1; i <= 100; i++) {
			pb.setValue(i);
			sum += i;
			lblResult.setText("1부터 " + i + "까지의 합계:" + sum);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new MdiEx();
	}
}
