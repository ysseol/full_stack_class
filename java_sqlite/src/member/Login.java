package member;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Login {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디:");
		String userid = sc.next();
		System.out.println("비번:");
		String pwd = sc.next();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			FileInputStream fis = new FileInputStream("c:/work/sqlite.prop");
			Properties prop = new Properties();
			prop.load(fis);
			String url = prop.getProperty("url");
			conn = DriverManager.getConnection(url);
			
			String sql = "select * from member where userid=? and pwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println(rs.getString("name") + "님 환영합니다.");
			} else {
				System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
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
}
