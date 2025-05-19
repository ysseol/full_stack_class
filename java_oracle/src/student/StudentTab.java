package student;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class StudentTab extends JFrame {
	
	private StudentDAO studentDao;
	private MajorDAO departmentDao;
	private ProfessorDAO professorDao;
	private JTextField tfName;
	private JTextField tfStudno;
	private JTextField tfTel;
	private JList list;
	private StudentDTO dto;
	private String img_path;
	private ArrayList<MajorDTO> departmentList;
	private ArrayList<ProfessorDTO> professorList;
	private JComboBox cboDeptno;
	private JComboBox cboProfessor;
	private JTable table;
	private Vector data, col;

	
	public StudentTab() {
		
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(136, 54, 322, 288);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("학생정보", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblImage = new JLabel("사진");
		lblImage.setBounds(14, 11, 80, 100);
		panel.add(lblImage);
		
		JLabel lblName = new JLabel("이름");
		lblName.setBounds(99, 14, 40, 16);
		panel.add(lblName);
		
		JLabel lblNo = new JLabel("학번");
		lblNo.setBounds(99, 56, 40, 16);
		panel.add(lblNo);
		
		JLabel lblMajor = new JLabel("학과");
		lblMajor.setBounds(99, 101, 40, 16);
		panel.add(lblMajor);
		
		JLabel lblTeacher = new JLabel("지도교수");
		lblTeacher.setBounds(96, 142, 62, 16);
		panel.add(lblTeacher);
		
		JLabel lblTel = new JLabel("전화번호");
		lblTel.setBounds(97, 183, 61, 16);
		panel.add(lblTel);
		
		JButton btnSave = new JButton("저장");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentDTO dto = new StudentDTO();
				dto.setStudno(Integer.parseInt(tfStudno.getText()));
				dto.setSname(tfName.getText());
				dto.setTel(tfTel.getText());
				int index = cboDeptno.getSelectedIndex();
				dto.setMajorno(departmentList.get(index).getMajorno());
				index = cboProfessor.getSelectedIndex() - 1;
				if (index != -1) {
					dto.setProfno(professorList.get(index).getProfno());
				}
				
				dto.setImg_path(img_path);
				int result = studentDao.updateStudent(dto);
				if (result == 1) {
					JOptionPane.showMessageDialog(StudentTab.this, "저장되었습니다.");
				}
			}
		});
		btnSave.setBounds(99, 210, 101, 25);
		panel.add(btnSave);
		
		tfName = new JTextField();
		tfName.setBounds(174, 11, 116, 22);
		panel.add(tfName);
		tfName.setColumns(10);
		
		tfStudno = new JTextField();
		tfStudno.setEditable(false);
		tfStudno.setColumns(10);
		tfStudno.setBounds(174, 53, 116, 22);
		panel.add(tfStudno);
		
		tfTel = new JTextField();
		tfTel.setColumns(10);
		tfTel.setBounds(174, 177, 116, 22);
		panel.add(tfTel);
		
		JButton btnImage = new JButton("사진등록");
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int result = fc.showOpenDialog(StudentTab.this);
				if (result == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					img_path = fc.getSelectedFile().getAbsolutePath();
					System.out.println(img_path);
					try {
						ImageIcon icon = new ImageIcon(ImageIO.read(file));
						Image imageSrc = icon.getImage();
						BufferedImage bi = ImageIO.read(file);
						File copyfile = new File("test.jpg");
						ImageIO.write(bi, "jpg", copyfile);
						
						Image imageNew = imageSrc.getScaledInstance(80, 100, Image.SCALE_AREA_AVERAGING);
						icon = new ImageIcon(imageNew);
						lblImage.setIcon(icon);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		btnImage.setBounds(0, 138, 91, 25);
		panel.add(btnImage);
		
		cboDeptno = new JComboBox();
		cboDeptno.setBounds(174, 98, 129, 25);
		panel.add(cboDeptno);
		
		cboProfessor = new JComboBox();
		cboProfessor.setBounds(172, 139, 131, 22);
		panel.add(cboProfessor);
		
		JPanel panel_subject = new JPanel();
		tabbedPane.addTab("수강정보", null, panel_subject, null);
		panel_subject.setLayout(null);
		
		JScrollPane scroll_subject = new JScrollPane();
		scroll_subject.setBounds(14, 11, 289, 236);
		panel_subject.add(scroll_subject);
		
		table = new JTable();
		scroll_subject.setViewportView(table);
		
		JScrollPane scroll_student = new JScrollPane();
		scroll_student.setBounds(14, 54, 121, 288);
		add(scroll_student);
		
		studentDao = new StudentDAO();
		departmentDao = new MajorDAO();
		professorDao = new ProfessorDAO();
		professorList = professorDao.listProfessor();
		ArrayList<String> studentList = studentDao.listStudent();
		departmentList = departmentDao.listDepartment();
		
		col = new Vector();
		col.add("학번");
		col.add("이름");
		col.add("과목명");
		col.add("담당교수");
		col.add("학점");
		col.add("등급");
		
		list = new JList(studentList.toArray());
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) {
					String str = list.getSelectedValue().toString();
					String[] arr = str.split(" ");
					int studno = Integer.valueOf(arr[0]);
					
					DefaultTableModel model = new DefaultTableModel(studentDao.listLecture(studno), col);
					table.setModel(model);
					
					dto = studentDao.detailStudent(studno);
					if (dto != null) {
						tfStudno.setText(dto.getStudno() + "");
						tfName.setText(dto.getSname());
						int count = 0;
						int cboIndex = 0;
						cboDeptno.removeAllItems();
						for (MajorDTO dto2 : departmentList) {
							cboDeptno.addItem(dto2.getMname());
							if (dto.getMajorno() == dto2.getMajorno()) {
								cboIndex = count;
							}
							count++;
						}
						cboDeptno.setSelectedIndex(cboIndex);
						
						cboIndex = 0;
						boolean assign = false;
						cboProfessor.removeAllItems();
						cboProfessor.addItem("미배정");
						for (int i = 0; i < professorList.size(); i++) {
							int profno = professorList.get(i).getProfno();
							String name = professorList.get(i).getPname();
							cboProfessor.addItem(name);
							System.out.println(profno + "," + dto.getProfno());
							if (profno == dto.getProfno()) {
								assign = true;
								cboIndex = i;
							}
						}
						
						if (assign) {
							cboProfessor.setSelectedIndex(cboIndex + 1);
						} else {
							cboProfessor.setSelectedIndex(0);
						}
						tfTel.setText(dto.getTel());
						img_path = dto.getImg_path();
						if (img_path == null) {
							lblImage.setText("사진미등록");
							lblImage.setIcon(null);
						} else {
							ImageIcon icon = new ImageIcon(img_path);
							Image imageSrc = icon.getImage();
							Image imageNew = imageSrc.getScaledInstance(80, 100, Image.SCALE_AREA_AVERAGING);
							icon = new ImageIcon(imageNew);
							lblImage.setIcon(icon);
						}
					} else {
						tfStudno.setText("");
						tfName.setText("");
						tfTel.setText("");
					}
					
				}
			}
		});
		scroll_student.setViewportView(list);
		
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new StudentTab();
	}
}
