package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import common.DB;

public class StudentDAO {

	public Vector listLecture(int studno) {
		Vector items = new Vector();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.oraConn();
			String sql = "select l.studno, sname, subject_name, pname, point, l.grade "
					+ "from lecture l, stud st, subject sb, prof p "
					+ "where l.studno=st.studno and "
					+ "l.subject_code=sb.subject_code and "
					+ "sb.profno=p.profno and l.studno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, studno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Vector row = new Vector();
				row.add(rs.getInt("studno"));
				row.add(rs.getString("sname"));
				row.add(rs.getString("subject_name"));
				row.add(rs.getString("pname"));
				row.add(rs.getDouble("point"));
				row.add(rs.getString("grade"));
				items.add(row);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}
	
	public int updateStudent(StudentDTO dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.oraConn();
			String sql = "update stud set sname=?, majorno=?, profno=?, tel=?, img_path=? where studno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSname());
			pstmt.setInt(2, dto.getMajorno());
			pstmt.setInt(3, dto.getProfno());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getImg_path());
			pstmt.setInt(6, dto.getStudno());
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
	
	public StudentDTO detailStudent(int studno) {
		StudentDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.oraConn();
			String sql = "select studno, sname, s.majorno, mname, pname, tel, img_path, "
					+ "p.profno from stud s, prof p, major m where s.profno=p.profno(+) and "
					+ "s.majorno=m.majorno and studno=?";
			System.out.println("studno:"+studno);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, studno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new StudentDTO();
				dto.setProfno(rs.getInt("profno"));
				dto.setStudno(studno);
				dto.setMajorno(rs.getInt("majorno"));
				dto.setSname(rs.getString("sname"));
				dto.setMname(rs.getString("mname"));
				dto.setPname(rs.getString("pname"));
				dto.setTel(rs.getString("tel"));
				dto.setImg_path(rs.getString("img_path"));
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
	
	public ArrayList<String> listStudent() {
		ArrayList<String> items = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.oraConn();
			String sql = "select (studno ||' '|| sname) sname from stud";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				items.add(rs.getString("sname"));
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
