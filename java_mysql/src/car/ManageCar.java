package car;

import java.util.List;
import java.util.Scanner;

public class ManageCar {
	CarDAO dao = new CarDAO();
	
	void delete() {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 차량번호를 입력하세요:");
		
		String car_no = sc.nextLine();
		int result = dao.delete_car(car_no);
		
		if (result == 1) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("차량번호를 확인하세요.");
		}
	}
	
	void insert() {
		Scanner sc = new Scanner(System.in);
		System.out.print("차량번호:");
		String car_no = sc.nextLine();
		System.out.print("제조사:");
		String company = sc.nextLine();
		System.out.print("타입:");
		String type = sc.nextLine();
		System.out.print("제조연도:");
		int year = sc.nextInt();
		System.out.print("연비:");
		
		int efficiency = sc.nextInt();
		CarDTO dto = new CarDTO(car_no, company, type, year, efficiency);
		
		dao.insert_car(dto);
		System.out.println("추가되었습니다.");
	}
	
	void list() {
		List<CarDTO> items = dao.list_car();
		
		System.out.println("차량번호\t\t연도\t제조사\t타입\t연비");
		System.out.println("==========================================================");
		
		for (CarDTO dto : items) {
			System.out.print(dto.getCar_no() + "\t\t");
			System.out.print(dto.getYear() + "\t");
			System.out.print(dto.getCompany() + "\t");
			System.out.print(dto.getType() + "\t");
			System.out.print(dto.getEfficiency() + "\n");
		}
	}
	
	public static void main(String[] args) {
		ManageCar car = new ManageCar();
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("작업을 선택하세요(1:목록 2:추가 3:삭제 0:종료):");
			
			int code = sc.nextInt();
			switch (code) {
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			case 1:
				car.list();
				break;
			case 2:
				car.insert();
				break;
			case 3:
				car.delete();
				break;
			}
		}
	}
}
