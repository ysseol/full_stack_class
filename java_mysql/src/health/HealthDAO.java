package health;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import address.DB;

public class HealthDAO {
	
	public HealthDTO search(String id) {
		
		HealthDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DB.dbConn();
			String sql = "select id, name, age, height, weight, (weight / ((height/100) * (height/100))) bmi from health where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				String name = rs.getString("name");
				int age = rs.getInt("age");
				double height = rs.getDouble("height");
				double weight = rs.getDouble("weight");
				double bmi = rs.getDouble("bmi");
				
				dto = new HealthDTO(id, name, age, height, weight, bmi);
				
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
		return dto;
	}
}
