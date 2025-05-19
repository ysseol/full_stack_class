package address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO {
	public List<AddressDTO> list() {
		
		List<AddressDTO> items = new ArrayList<>();
		
		String sql = "select * from address";
		
		try (Connection conn = DB.dbConn();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			
			while (rs.next()) {
				String email = rs.getString("email");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String hp = rs.getString("hp");
				AddressDTO dto = new AddressDTO(email, name, address, hp);
				
				items.add(dto);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return items;
	}
}
