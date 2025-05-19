package address;

import java.util.List;
import java.util.Scanner;

public class ManageAddress {
	private AddressDAO dao = null;
	
	public ManageAddress() {
		dao = new AddressDAO();
	}
	
	void delete() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("삭제할 이메일:");
		
		String userid = scan.next();
		
		int result = dao.delete(userid);
		
		if (result == 1) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("이메일을 확인하세요.");
		}
	}
	
	void list() {
		List<AddressDTO> items = dao.list();
		
		System.out.println("이름\t주소\t전화\t이메일");
		
		for (AddressDTO dto : items) {
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getAddress() + "\t");
			System.out.print(dto.getHp() + "\t");
			System.out.println(dto.getEmail() + "\t");
		}
	}
	
	void insert() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이메일:");
		String email = scan.next();
		System.out.println("이름:");
		String name = scan.next();
		System.out.println("주소:");
		String address = scan.next();
		System.out.println("전화:");
		String tel = scan.next();
		
		AddressDTO dto = new AddressDTO(email, name, address, tel);
		
		dao.insert(dto);
		
		System.out.println("저장되었습니다.");
	}
	
	void update() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("수정할 이메일:");
		String email = scan.next();
		System.out.println("이름:");
		String name = scan.next();
		System.out.println("주소:");
		String address = scan.next();
		System.out.println("전화:");
		String tel = scan.next();
		
		AddressDTO dto = new AddressDTO(email, name, address, tel);
		
		dao.update(dto);
		
		System.out.println("수정되었습니다.");
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ManageAddress obj = new ManageAddress();
		
		while (true) {
			
			System.out.println("메뉴(1.목록, 2.추가, 3.수정, 4.삭제, 0.종료)");
			
			int code = scan.nextInt();
			
			switch (code) {
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			case 1:
				obj.list();
				break;
			case 2:
				obj.insert();
				break;
			case 3:
				obj.update();
				break;
			case 4:
				obj.delete();
				break;
			}
		}
	}
}
