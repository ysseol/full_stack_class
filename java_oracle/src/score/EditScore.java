package score;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EditScore extends JFrame {
	
	private JTextField tfStudentNo;
	private JTextField tfName;
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMat;
	
	public EditScore(ScoreMain parent, ScoreDTO dto) {
		setLayout(null);
		
		JLabel lblNo = new JLabel("학번");
		lblNo.setBounds(14, 31, 62, 18);
		add(lblNo);
		
		tfStudentNo = new JTextField();
		tfStudentNo.setEditable(false);
		tfStudentNo.setBounds(90, 28, 116, 24);
		add(tfStudentNo);
		
		tfStudentNo.setColumns(10);
		JLabel lblName = new JLabel("이름");
		lblName.setBounds(14, 64, 62, 18);
		add(lblName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(90, 61, 116, 24);
		add(tfName);
		
		JLabel lblKor = new JLabel("국어");
		lblKor.setBounds(14, 97, 62, 18);
		add(lblKor);
		
		tfKor = new JTextField();
		tfKor.setColumns(10);
		tfKor.setBounds(90, 94, 116, 24);
		add(tfKor);
		
		JLabel lblEng = new JLabel("영어");
		lblEng.setBounds(14, 130, 62, 18);
		add(lblEng);
		
		tfEng = new JTextField();
		tfEng.setColumns(10);
		tfEng.setBounds(90, 127, 116, 24);
		add(tfEng);
		
		JLabel lblMath = new JLabel("수학");
		lblMath.setBounds(14, 163, 62, 18);
		add(lblMath);
		
		tfMat = new JTextField();
		tfMat.setColumns(10);
		tfMat.setBounds(90, 160, 116, 24);
		add(tfMat);
		
		JButton btnSave = new JButton("수정");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScoreDAO dao = new ScoreDAO();
				String student_no = tfStudentNo.getText();
				String name = tfName.getText();
				int kor = Integer.valueOf(tfKor.getText());
				int eng = Integer.valueOf(tfEng.getText());
				int mat = Integer.valueOf(tfMat.getText());
				dao.updateScore(new ScoreDTO(student_no, name, kor, eng, mat));
				JOptionPane.showMessageDialog(EditScore.this, "수정되었습니다.");
				parent.refreshTable();
				dispose();
			}
		});
		btnSave.setBounds(46, 195, 73, 27);
		add(btnSave);
		
		tfStudentNo.setText(dto.getStudent_no());
		tfName.setText(dto.getName());
		tfKor.setText(dto.getKor() + "");
		tfEng.setText(dto.getEng() + "");
		tfMat.setText(dto.getMat() + "");
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(EditScore.this, "삭제하시겠습니까?");
				if (response == JOptionPane.YES_OPTION) {
					String student_no = tfStudentNo.getText();
					ScoreDAO dao = new ScoreDAO();
					dao.deleteScore(student_no);
					parent.refreshTable();
					JOptionPane.showMessageDialog(EditScore.this, "삭제되었습니다.");
					dispose();
				}
			}
		});
		btnDelete.setBounds(133, 195, 73, 27);
		add(btnDelete);
		
		setSize(250, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
