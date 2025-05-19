package address;

import java.util.List;

public class ManageAddress {
	AddressDAO dao = new AddressDAO();
	
	void list() {
		List<AddressDTO> items = dao.list();
		
		System.out.println("이름\t주소\t핸드폰\t\t이메일");
		System.out.println("===================================================");
		
		for (AddressDTO dto : items) {
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getAddress() + "\t");
			System.out.print(dto.getHp() + "\t");
			System.out.print(dto.getEmail() + "\n");
		}
		
	}
	
	public static void main(String[] args) {
		
		ManageAddress ex = new ManageAddress();
		
		ex.list();
	}
}
