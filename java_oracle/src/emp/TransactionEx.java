package emp;

import java.sql.Connection;
import java.sql.PreparedStatement;

import common.DB;

public class TransactionEx {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean success = false;
		try {
			conn = DB.oraConn();
			conn.setAutoCommit(false);
			String sql = "insert into emp_copy values (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			long start = System.currentTimeMillis();
			System.out.println(start);
			for (int i = 1; i <= 500; i++) {
				pstmt.setInt(1, i * 100);
				pstmt.setString(2, "kim" + i);
				pstmt.setInt(3, 4500);
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			success = true;
			long end = System.currentTimeMillis();
			System.out.println("작업수행시간:" + (end - start));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (success) {
					System.out.println("커밋되었습니다.");
					conn.commit();
				} else {
					System.out.println("롤백되었습니다.");
					conn.rollback();
				}
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
