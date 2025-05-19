package gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JSliderEx extends JFrame {

	int red, green, blue;
	private JPanel panel;
	private JSlider sliderR;
	private JSlider sliderG;
	private JSlider sliderB;
	
	
	public JSliderEx() {
		setLayout(null);
		
		sliderR = new JSlider();
		sliderR.setValue(0);
		sliderR.setMaximum(255);
		
		sliderR.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				red = sliderR.getValue();
				panel.setBackground(new Color(red, green, blue));
			}
		});
		sliderR.setBounds(38, 40, 350, 23);
		add(sliderR);
		
		sliderG = new JSlider();
		sliderG.setValue(0);
		sliderG.setMaximum(255);
		sliderG.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				green = sliderG.getValue();
				panel.setBackground(new Color(red, green, blue));
			}
		});
		sliderG.setBounds(38, 97, 350, 23);
		add(sliderG);
		
		sliderB = new JSlider();
		sliderB.setValue(0);
		sliderB.setMaximum(255);
		sliderB.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				blue = sliderB.getValue();
				panel.setBackground(new Color(red, green, blue));
			}
		});
		sliderB.setBounds(37, 142, 350, 23);
		add(sliderB);
		
		panel = new JPanel();
		panel.setBounds(37, 175, 350, 139);
		add(panel);
		
		JLabel lblRed = new JLabel("Red");
		lblRed.setBounds(37, 25, 57, 15);
		add(lblRed);
		
		JLabel lblGreen = new JLabel("Green");
		lblGreen.setBounds(37, 85, 57, 15);
		add(lblGreen);
		
		JLabel lblBlue = new JLabel("Blue");
		lblBlue.setBounds(37, 130, 57, 15);
		add(lblBlue);
		
		setSize(450, 450);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JSliderEx();
	}
}
