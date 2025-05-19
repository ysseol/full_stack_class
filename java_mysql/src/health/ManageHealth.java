package health;

import java.util.Scanner;

public class ManageHealth {
	
	String getGrade(double bmi) {
		String grade = "";
		if (bmi < 18.5) {
			grade = "저체중";
		} else if (bmi < 23) {
			grade = "정상";
		} else if (bmi < 25) {
			grade = "과체중";
		} else if (bmi >= 25) {
			grade = "비만";
		}
		return grade;
	}
	
	void print(HealthDTO dto) {
		System.out.println("이름 : " + dto.getName());
		System.out.println("나이 : " + dto.getAge());
		System.out.println("신장 : " + dto.getHeight());
		System.out.println("몸무게 : " + dto.getWeight());
		System.out.println("BMI : " + dto.getBmi());
		System.out.println("등급 : " + getGrade(dto.getBmi()));
	}
	
	public static void main(String[] args) {
		ManageHealth ex = new ManageHealth();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("번호를 입력하세요 :");
		String id = scan.nextLine();
		
		HealthDAO dao = new HealthDAO();
		HealthDTO dto = dao.search(id);
		
		ex.print(dto);
		scan.close();
	}
}
