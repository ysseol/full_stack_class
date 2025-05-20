package network;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MultiTableClient extends JFrame {
	
	private JComboBox cboTable;
	private JTextArea taResult;
	
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;
	
	public MultiTableClient() {
		try {
			socket = new Socket("localhost", 9000);
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setLayout(null);
		
		cboTable = new JComboBox();
		cboTable.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					int table = cboTable.getSelectedIndex() + 2;
					try {
						dos.writeInt(table);
						taResult.setText(dis.readUTF());
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		cboTable.setModel(new DefaultComboBoxModel(new String[] { 
			"2단", "3단", "4단", "5단", "6단", "7단", "8단", "9단" }));
		cboTable.setBounds(22, 20, 79, 23);
		add(cboTable);
		
		taResult = new JTextArea();
		taResult.setBounds(22, 53, 195, 198);
		add(taResult);
		
		setSize(280, 320);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MultiTableClient();
	}
}
