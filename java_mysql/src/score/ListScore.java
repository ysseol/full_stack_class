package score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import address.AddressDTO;
import address.DB;

public class ListScore {
	
	public static void main(String[] args) {
		String sql = "select name, kor, eng, mat, kor+eng+mat 총점,"
				+ "round((kor+eng+mat)/3,2) 평균,"
				+ "case "
				+ "when (kor+eng+mat)/3 >= 90 then 'A' "
				+ "when (kor+eng+mat)/3 >= 80 then 'B' "
				+ "when (kor+eng+mat)/3 >= 70 then 'C' "
				+ "when (kor+eng+mat)/3 >= 60 then 'D' "
				+ "else 'F' "
				+ "end 등급 "
				+ "from score";
		
		try (Connection conn = DB.dbConn();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			
			System.out.println("이름" + "\t" + "국어" + "\t" + "영어" + "\t" + "수학" + "\t" + "총점"
					+ "\t" + "평균" + "\t" + "등급");
			
			while(rs.next()) {
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int total = rs.getInt("총점");
				double avg = rs.getDouble("평균");
				String grade = rs.getString("등급");
				
				System.out.println(name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + total
						+ "\t" + avg + "\t" + grade);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
