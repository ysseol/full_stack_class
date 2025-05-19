package emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.DB;

public class EmpDAO {

	public void insert() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DB.dbConn();
			conn.setAutoCommit(false);
			
			long before = System.currentTimeMillis();
			
			String sql = "insert into emp2 (empno, ename, deptno) values (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			for (int i = 1; i <= 100000; i++) {
				pstmt.setInt(1, i);
				pstmt.setString(2, "name" + i);
				pstmt.setInt(3, i);
				pstmt.executeUpdate();
			}
			
			long after = System.currentTimeMillis();
			
			conn.commit();
			conn.setAutoCommit(true);
			
			System.out.println("실행시간:" + (after - before));
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (conn != null)
					conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
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
	
	public void insert_batch() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DB.dbConn();
			conn.setAutoCommit(false);
			
			String sql = "insert into emp2 (empno, ename, deptno) values (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			long before = System.currentTimeMillis();
			
			for (int i = 100001; i <= 200000; i++) {
				pstmt.setInt(1, i);
				pstmt.setString(2, "name" + i);
				pstmt.setInt(3, i);
				pstmt.addBatch();
			}
			
			pstmt.executeBatch();
			
			long after = System.currentTimeMillis();
			
			conn.commit();
			conn.setAutoCommit(true);
			
			System.out.println("실행시간:" + (after - before));
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (conn != null)
					conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
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
}
