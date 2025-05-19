package books;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
	public static void main(String[] args) {
		String url = "jdbc:sqlite:c:/sqlite3/java.db";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
//			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(url);
			String sql = "select * from books";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int book_code = rs.getInt("book_code");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String year = rs.getString("year");
				int price = rs.getInt("price");
				System.out.println(book_code + "\t" + title + "\t"
						+ author + "\t" + year + "\t" + price);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch(SQLException e) {
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
