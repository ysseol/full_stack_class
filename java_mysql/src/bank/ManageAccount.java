package bank;

import java.util.List;
import java.util.Scanner;

public class ManageAccount {
	AccountDAO dao = new AccountDAO();
	
	void list() {
		
		List<AccountDTO> list = dao.listAccount();
		
		System.out.println("은행\t계좌번호\t\t예금주\t잔액");
		System.out.println("=====================================================");
		
		for (AccountDTO dto : list) {
			
			System.out.print(dto.getBank() + "\t");
			System.out.print(dto.getNum() + "\t");
			System.out.print(dto.getName() + "\t");
			System.out.print(String.format("%,d", dto.getMoney()) + "\n");
			
		}
	}
	
	void insert() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("은행 : ");
		String bank = scan.nextLine();
		System.out.print("계좌번호 : ");
		String num = scan.nextLine();
		System.out.print("예금주 : ");
		String name = scan.nextLine();
		System.out.print("잔액 : ");
		int money = scan.nextInt();
		
		AccountDTO dto = new AccountDTO(bank, num, name, money);
		dao.insertAccount(dto);
		System.out.print("추가되었습니다.");
	}
	
	public static void main(String[] args) {
		
		ManageAccount ex = new ManageAccount();
		
		while (true) {
			
			Scanner scan = new Scanner(System.in);
			
			System.out.print("메뉴를 선택하세요(1:계좌목록 2:계좌등록 0:종료):");
			
			int menu = scan.nextInt();
			
			switch (menu) {
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			case 1:
				ex.list();
				break;
			case 2:
				ex.insert();
				break;
			}
		}
	}
}
