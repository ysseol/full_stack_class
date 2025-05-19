package car;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CarDAO {
	public Connection dbConn() {
		Connection conn = null;
		try {
			FileInputStream fis = new FileInputStream("c:/work/mysql.prop");
			Properties prop = new Properties();
			prop.load(fis);
			
			String url = prop.getProperty("url");
			String id = prop.getProperty("id");
			String password = prop.getProperty("password");
			
			conn = DriverManager.getConnection(url, id, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public List<CarDTO> list_car() {
		List<CarDTO> items = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbConn();
			String sql = "select * from car";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String car_no = rs.getString("car_no");
				String company = rs.getString("company");
				String type = rs.getString("type");
				int year = rs.getInt("year");
				int efficiency = rs.getInt("efficiency");
				
				CarDTO dto = new CarDTO(car_no, company, type, year, efficiency);
				items.add(dto);
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
				if (pstmt != null)
					pstmt.close();
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
		return items;
	}
	
	public void insert_car(CarDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbConn();
			String sql = "insert into car (car_no, company, type, year, efficiency) values (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getCar_no());
			pstmt.setString(2, dto.getCompany());
			pstmt.setString(3, dto.getType());
			pstmt.setInt(4, dto.getYear());
			pstmt.setInt(5, dto.getEfficiency());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
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
	
	public int delete_car(String car_no) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbConn();
			String sql = "delete from car where car_no=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, car_no);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
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
		return result;
	}
}
