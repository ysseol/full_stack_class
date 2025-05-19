package emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import address.DB;

public class EmpDAO {
	
	public List<EmpDTO> listEmp() {
		
		List<EmpDTO> items = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DB.dbConn();
			String sql = "select * from emp";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String hiredate = rs.getString("hiredate");
				int sal = rs.getInt("sal");
				
				items.add(new EmpDTO(empno, ename, hiredate, sal));
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
	
	public int insertEmp(EmpDTO dto) {
		
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DB.dbConn();
			String sql = "insert into emp (empno, ename, hiredate, sal) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getEmpno());
			pstmt.setString(2, dto.getEname());
			pstmt.setString(3, dto.getHiredate());
			pstmt.setInt(4, dto.getSal());
			
			System.out.println(dto);
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
	
	public int deleteEmp(int empno) {
		
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DB.dbConn();
			String sql = "delete from emp where empno=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, empno);
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
	
	public int updateEmp(EmpDTO dto) {
		
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DB.dbConn();
			String sql = "update emp set ename=?,hiredate=?,sal=? where empno=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getEname());
			pstmt.setString(2, dto.getHiredate());
			pstmt.setInt(3, dto.getSal());
			pstmt.setInt(4, dto.getEmpno());
			
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
	
	public Vector searchEmp(String name) {
		
		Vector items = new Vector();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DB.dbConn();
			
			String sql = "select empno, ename, hiredate, sal from emp where ename like ? order by ename";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Vector row = new Vector();
				row.add(rs.getInt("empno"));
				row.add(rs.getString("ename"));
				row.add(rs.getDate("hiredate"));
				row.add(rs.getInt("sal"));
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
