package member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {

	private JTextField userid;
	private JPasswordField pwd;
	private JLabel lblResult;
	
	public Login() {
		setLayout(null);
		
		JLabel lblUserid = new JLabel("아이디");
		lblUserid.setBounds(12, 34, 57, 15);
		add(lblUserid);
		
		JLabel lblPwd = new JLabel("비밀번호");
		lblPwd.setBounds(12, 82, 57, 15);
		add(lblPwd);
		
		userid = new JTextField();
		userid.setBounds(87, 31, 116, 21);
		add(userid);
		userid.setColumns(10);
		
		pwd = new JPasswordField();
		pwd.setBounds(88, 79, 115, 21);
		add(pwd);
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String strUserid = userid.getText();
				String strPwd = String.valueOf(pwd.getPassword());
				
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try {
					
					FileInputStream fis = new FileInputStream("c:/work/mysql.prop");
					Properties prop = new Properties();
					prop.load(fis);
					
					String url = prop.getProperty("url");
					String id = prop.getProperty("id");
					String password = prop.getProperty("password");
					
					conn = DriverManager.getConnection(url, id, password);
					String sql = "select * from member where userid=? and pwd=?";
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, strUserid);
					pstmt.setString(2, strPwd);
					rs = pstmt.executeQuery();
					
					if (rs.next()) {
						lblResult.setText(rs.getString("name") + "님 환영합니다.");
					} else {
						lblResult.setText("아이디 또는 비밀번호가 일치하지 않습니다.");
					}
					
				} catch (Exception e2) {
					
					e2.printStackTrace();
					
				} finally {
					
					try {
						if (rs != null)
							rs.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					try {
						if (pstmt != null)
							pstmt.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					try {
						if (conn != null)
							conn.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}
			}
		});	
		btnLogin.setBounds(215, 78, 97, 23);
		add(btnLogin);
		
		lblResult = new JLabel("");
		lblResult.setBounds(12, 116, 300, 63);
		add(lblResult);
		
		setSize(350, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Login();
	}
}
