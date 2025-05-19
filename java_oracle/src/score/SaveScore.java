package score;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SaveScore extends JFrame {

	private JTextField tfName;
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMat;
	private JTextField tfStudentNo;
	
	public SaveScore(ScoreMain parent) {
		
		setLayout(null);
		
		JLabel lblName = new JLabel("이름");
		lblName.setBounds(12, 78, 57, 15);
		add(lblName);
		
		JLabel lblKor = new JLabel("국어");
		lblKor.setBounds(12, 120, 57, 15);
		add(lblKor);
		
		JLabel lblEng = new JLabel("영어");
		lblEng.setBounds(12, 160, 57, 15);
		add(lblEng);
		
		JLabel lblNo = new JLabel("학번");
		lblNo.setBounds(12, 36, 57, 15);
		add(lblNo);
		
		tfName = new JTextField();
		tfName.setBounds(79, 75, 116, 21);
		add(tfName);
		tfName.setColumns(10);
		
		tfKor = new JTextField();
		tfKor.setBounds(79, 117, 116, 21);
		add(tfKor);
		tfKor.setColumns(10);
		
		tfEng = new JTextField();
		tfEng.setBounds(79, 157, 116, 21);
		add(tfEng);
		tfEng.setColumns(10);
		
		tfMat = new JTextField();
		tfMat.setBounds(79, 198, 116, 21);
		add(tfMat);
		tfMat.setColumns(10);
		
		tfStudentNo = new JTextField();
		tfStudentNo.setBounds(79, 33, 116, 21);
		add(tfStudentNo);
		tfStudentNo.setColumns(10);
		
		JButton btnSave = new JButton("저장");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScoreDAO dao = new ScoreDAO();
				String student_no = tfStudentNo.getText();
				String name = tfName.getText();
				int kor = Integer.valueOf(tfKor.getText());
				int eng = Integer.valueOf(tfEng.getText());
				int mat = Integer.valueOf(tfMat.getText());
				dao.insertScore(new ScoreDTO(student_no, name, kor, eng, mat));
				JOptionPane.showMessageDialog(SaveScore.this, "추가되었습니다.");
				parent.refreshTable();
				dispose();
			}
		});
		btnSave.setBounds(76, 256, 97, 23);
		add(btnSave);
		
		setSize(250, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
