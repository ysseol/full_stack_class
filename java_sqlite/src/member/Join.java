package member;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class Join {
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			FileInputStream fis = null;
			fis = new FileInputStream("c:/work/sqlite.prop");
			Properties prop = new Properties();
			prop.load(fis);
			
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			conn = DriverManager.getConnection(url);
			Class.forName(driver);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("아이디:");
			String userid = sc.next();
			
			String sql = "select count(*) from member where userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				int count = rs.getInt(1);
				if(count > 0) {
					System.out.println("이미 사용중인 아이디입니다.");
				} else {
					System.out.println("비번:");
					String pwd = sc.next();
					System.out.println("이름:");
					String name = sc.next();
					
					sql = "insert into member values (?,?,?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, userid);
					pstmt.setString(2, pwd);
					pstmt.setString(3, name);
					pstmt.executeUpdate();
					System.out.println("등록되었습니다.");
				}
			}
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
			
		} finally {
			
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
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
}
