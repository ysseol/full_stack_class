package member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MemberJoin extends JFrame {
	
	private JTextField tfUserid;
	private JPasswordField pass;
	private JTextField tfName;
	private JButton btnCheck;
	
	public MemberJoin() {
		
		setLayout(null);
		
		tfUserid = new JTextField();
		tfUserid.setBounds(97, 36, 116, 21);
		add(tfUserid);
		tfUserid.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(96, 67, 117, 21);
		add(pass);
		
		tfName = new JTextField();
		tfName.setBounds(97, 98, 116, 21);
		add(tfName);
		tfName.setColumns(10);
		
		JButton btnSave = new JButton("확인");
		btnSave.setEnabled(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conn = null;
				PreparedStatement stmt = null;
				
				try {
					FileInputStream fis = null;
					fis = new FileInputStream("c:/work/mysql.prop");
					Properties prop = new Properties();
					prop.load(fis);
					
					String driver = prop.getProperty("driver");
					String url = prop.getProperty("url");
					String id = prop.getProperty("id");
					String password = prop.getProperty("password");
					
					conn = DriverManager.getConnection(url, id, password);
					Class.forName(driver);
					
					String userid = tfUserid.getText();
					if (userid.equals("")) {
						JOptionPane.showMessageDialog(MemberJoin.this, "아이디를 입력하세요.");
						tfUserid.requestFocus();
						return;
					}
					
					String pwd = String.valueOf(pass.getPassword());
					if (pwd.equals("")) {
						JOptionPane.showMessageDialog(MemberJoin.this, "비밀번호를 입력하세요.");
						pass.requestFocus();
						return;
					}
					
					String name = tfName.getText();
					if (name.equals("")) {
						JOptionPane.showMessageDialog(MemberJoin.this, "이름을 입력하세요.");
						tfName.requestFocus();
						return;
					}
					
					String sql = "insert into member values (?,?,?)";
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, userid);
					stmt.setString(2, pwd);
					stmt.setString(3, name);
					stmt.executeUpdate();
						
					JOptionPane.showMessageDialog(MemberJoin.this, "등록되었습니다.");
					
				} catch (Exception ex) {
					
					ex.printStackTrace();
					
				} finally {
					
					try {
						if (stmt != null)
							stmt.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
					try {
						if (conn != null)
							conn.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
				}
			}
		});
		btnSave.setBounds(96, 152, 97, 23);
		add(btnSave);
		
		JLabel lblUserid = new JLabel("아이디");
		lblUserid.setBounds(28, 39, 57, 15);
		add(lblUserid);
		
		JLabel lblPwd = new JLabel("비밀번호");
		lblPwd.setBounds(27, 70, 57, 15);
		add(lblPwd);
		
		JLabel lblName = new JLabel("이름");
		lblName.setBounds(28, 101, 57, 15);
		add(lblName);
		
		btnCheck = new JButton("중복확인");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conn = null;
				PreparedStatement stmt = null;
				ResultSet rs = null;
				
				try {
					FileInputStream fis = null;
					fis = new FileInputStream("c:/work/mysql.prop");
					Properties prop = new Properties();
					prop.load(fis);
					
					String driver = prop.getProperty("driver");
					String url = prop.getProperty("url");
					String id = prop.getProperty("id");
					String password = prop.getProperty("password");
					
					conn = DriverManager.getConnection(url, id, password);
					Class.forName(driver);
					
					String userid = tfUserid.getText();
					
					String sql = "select count(*) from member where userid=?";
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, userid);
					rs = stmt.executeQuery();
					
					if (rs.next()) {
						int count = rs.getInt(1);
						if (count == 0) {
							JOptionPane.showMessageDialog(MemberJoin.this, "사용가능한 아이디입니다.");
							btnSave.setEnabled(true);
						} else {
							JOptionPane.showMessageDialog(MemberJoin.this, "이미 사용중인 아이디입니다.");
							btnSave.setEnabled(false);
						}
					}
				} catch  (Exception ex) {
					
					ex.printStackTrace();
					
				} finally {
					
					try {
						if (stmt != null)
							stmt.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
					try {
						if (conn != null)
							conn.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
				}
			}
		});
		btnCheck.setBounds(227, 35, 97, 23);
		add(btnCheck);
		
		setSize(350, 280);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		
		new MemberJoin();
		
	}
}
