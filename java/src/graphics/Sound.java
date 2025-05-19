package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sound extends JFrame {
	public Sound() {
		JPanel p = new JPanel();
		JButton btn = new JButton("click");
		setSize(300, 300);
		setVisible(true);
		p.add(btn);
		getContentPane().add(p);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				audio();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void audio() {
		try {
			File file = new File("C:/work/java/src/graphics/dingdong1.wav");
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(file));
			clip.loop(3);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Sound();
	}
}
