package inner;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InnerEx2 extends Frame {
	public InnerEx2() {
		setSize(300, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		InnerEx2 e = new InnerEx2();
		
		e.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
