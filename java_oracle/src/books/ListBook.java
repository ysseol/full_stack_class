package books;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ListBook {
	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String id = "java";
		String pwd = "1234";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pwd);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("도서명을 입력하세요:");
			String book_title = sc.nextLine();
			
			String sql = "select * from books where title like ? order by title";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%" + book_title + "%");
			rs = pstmt.executeQuery();
			
			System.out.println("코드\t도서명\t저자\t단가");
			
			while (rs.next()) {
				int book_code = rs.getInt("book_code");
				String title = rs.getString("title");
				String author = rs.getString("author");
				int price = rs.getInt("price");
				
				System.out.println(book_code + "\t" + title + "\t" + author + "\t" + price);
			}
		} catch (Exception e) {
			e.printStackTrace();
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
