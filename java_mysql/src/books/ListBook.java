package books;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListBook {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/web?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String id = "user";
		String password = "1234";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, password);
			String sql = "select * from books";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int book_code = rs.getInt("book_code");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String year = rs.getString("year");
				int price = rs.getInt("price");
				System.out.println(book_code + "\t" + title + "\t" + author + "\t" + year + "\t" + price);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
