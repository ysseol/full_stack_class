package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class StatementEx {
	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String id = "java";
		String pwd = "1234";
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pwd);
			stmt = conn.createStatement();
			
			long start = System.currentTimeMillis();
			
			for (int i = 1; i <= 10000; i++) {
				String str = "data" + i;
				String sql = "insert into test values (" + i + ", '" + str + "')";
				stmt.executeUpdate(sql);
			}
			
			long end = System.currentTimeMillis();
			
			System.out.println("작업수행시간:" + (end - start));
			
			start = System.currentTimeMillis();
			
			String sql = "insert into test values (?,?)";
			pstmt = conn.prepareStatement(sql);
			
			for (int i = 10001; i <= 20000; i++) {
				String str = "data" + i;
				pstmt.setInt(1, i);
				pstmt.setString(2, str);
				pstmt.executeUpdate();
			}
			
			end = System.currentTimeMillis();
			
			System.out.println("작업수행시간:" + (end - start));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
