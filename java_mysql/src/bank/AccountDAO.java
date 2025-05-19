package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import address.DB;

public class AccountDAO {
	
public List<AccountDTO> listAccount() {
		
		List<AccountDTO> items = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DB.dbConn();
			String sql = "select * from bank_account";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String bank = rs.getString("bank");
				String num = rs.getString("num");
				String name = rs.getString("name");
				int money = rs.getInt("money");
				
				items.add(new AccountDTO(bank, num, name, money));
				
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
	
	public void insertAccount(AccountDTO dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DB.dbConn();
			String sql = "insert into bank_account (bank, num, name, money) values (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getBank());
			pstmt.setString(2, dto.getNum());
			pstmt.setString(3, dto.getName());
			pstmt.setInt(4, dto.getMoney());
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
}
