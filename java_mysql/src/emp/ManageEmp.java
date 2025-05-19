package emp;

import java.util.List;
import java.util.Scanner;

public class ManageEmp {
	EmpDAO dao = new EmpDAO();
	
	void list() {
		List<EmpDTO> items = dao.listEmp();
		
		System.out.println("사번\t이름\t입사일자\t급여");
		
		for (EmpDTO dto : items) {
			System.out.print(dto.getEmpno() + "\t");
			System.out.print(dto.getEname() + "\t");
			System.out.print(dto.getHiredate() + "\t");
			System.out.print(dto.getSal() + "\n");
		}
	}
	
	void insert() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("사번:");
		int empno = sc.nextInt();
		System.out.print("이름:");
		String ename = sc.next();
		System.out.print("입사일자:");
		String hiredate = sc.next();
		System.out.print("급여:");
		int sal = sc.nextInt();
		
		EmpDTO dto = new EmpDTO(empno, ename, hiredate, sal);
		
		dao.insertEmp(dto);
		
		System.out.println("저장되었습니다.");
	}
	
	void delete() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 사번을 입력하세요:");
		int empno = sc.nextInt();
		
		int result = dao.deleteEmp(empno);
		
		if (result == 1) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("사번을 확인하세요.");
		}
	}
	
	public static void main(String[] args) {
		ManageEmp emp = new ManageEmp();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("메뉴를 선택하세요(1:목록 2:추가 3:삭제 0:종료)");
			int code = sc.nextInt();
			switch (code) {
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			case 1:
				emp.list();
				break;
			case 2:
				emp.insert();
				break;
			case 3:
				emp.delete();
				break;
			}
		}
	}
}
