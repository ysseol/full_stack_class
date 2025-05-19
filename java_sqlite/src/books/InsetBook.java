package books;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class InsetBook {
	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream("c:/work/sqlite.prop");
		Properties prop = new Properties();
		prop.load(fis);
//		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
//			Class.forName(driver);
			conn = DriverManager.getConnection(url);
			
			String title = "Python";
			String author = "홍성철";
			String year = "2021";
			int price = 45000;
			
			String sql = "insert into books (title,author,year,price) values (?,?,?,?)";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, title);
			stmt.setString(2, author);
			stmt.setString(3, year);
			stmt.setInt(4, price);
			stmt.executeUpdate();
			System.out.println("추가되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
			
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
}
