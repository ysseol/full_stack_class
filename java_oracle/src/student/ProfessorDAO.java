package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DB;

public class ProfessorDAO {
	public ArrayList<ProfessorDTO> listProfessor() {
		ArrayList<ProfessorDTO> items = new ArrayList<ProfessorDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.oraConn();
			String sql = "select * from prof order by pname";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProfessorDTO dto = new ProfessorDTO();
				dto.setProfno(rs.getInt("profno"));
				dto.setPname(rs.getString("pname"));
				items.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}
}
