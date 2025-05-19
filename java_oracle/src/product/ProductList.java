package product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductList {
	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost/xe";
		String id = "java";
		String password = "1234";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, id, password);
			String sql = "select product_code,name,maker,price,amount,price*amount money from product";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("상품코드\t품명\t제조사\t단가\t수량\t금액");
			
			while (rs.next()) {
				String product_code = rs.getString("product_code");
				String name = rs.getString("name");
				String maker = rs.getString("maker");
				int price = rs.getInt("price");
				int amount = rs.getInt("amount");
				int money = rs.getInt("money");
				
				System.out.println(product_code + "\t" + name + "\t" + maker + "\t" + price + "\t" + amount + "\t" + money);
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
