package condition;

import java.util.Scanner;

public class Year {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Year:");
		int year = sc.nextInt();
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			System.out.println(year + "==> 윤년입니다");
		} else {
			System.out.println(year + "==> 평년입니다");
		}
	}
}
