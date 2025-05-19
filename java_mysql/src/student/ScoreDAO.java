package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import address.DB;

public class ScoreDAO {
	public int insert_score(ScoreDTO dto) {
		
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DB.dbConn();
			String sql = "insert into scores values (?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getStudent_no());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			pstmt.setInt(6, dto.getTot());
			pstmt.setDouble(7, dto.getAvg());
			
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
	
	public int delete_score(String student_no) {
		
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DB.dbConn();
			
			String sql = "delete from scores where student_no=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, student_no);
			
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
	
	public int update_score(ScoreDTO dto) {
		
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DB.dbConn();
			
			String sql = "update scores set name=?,kor=?,eng=?,mat=?,tot=?,avg=? where student_no=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getKor());
			pstmt.setInt(3, dto.getEng());
			pstmt.setInt(4, dto.getMat());
			pstmt.setInt(5, dto.getTot());
			pstmt.setDouble(6, dto.getAvg());
			pstmt.setString(7, dto.getStudent_no());
			
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
	
	public Vector search_score(String name) {
		
		Vector items = new Vector();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DB.dbConn();
			
			String sql = "select student_no, name, kor, eng, mat, (kor+eng+mat) tot, round(((kor+eng+mat)/3.0),1) avg from scores where name like ? order by name";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%" + name + "%");
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				Vector row = new Vector();
				row.add(rs.getString("student_no"));
				row.add(rs.getString("name"));
				row.add(rs.getInt("kor"));
				row.add(rs.getInt("eng"));
				row.add(rs.getInt("mat"));
				row.add(rs.getInt("tot"));
				row.add(rs.getDouble("avg"));
				items.add(row);
				
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
	
	public Vector list_score() {
		
		Vector items = new Vector();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DB.dbConn();
			
			String sql = "select student_no, name, kor, eng, mat, (kor+eng+mat) tot, round(((kor+eng+mat)/3.0),1) avg from scores order by name";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				Vector row = new Vector();
				
				row.add(rs.getString("student_no"));
				row.add(rs.getString("name"));
				row.add(rs.getInt("kor"));
				row.add(rs.getInt("eng"));
				row.add(rs.getInt("mat"));
				row.add(rs.getInt("tot"));
				row.add(rs.getDouble("avg"));
				items.add(row);
				
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
}
