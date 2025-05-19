package calc;

import java.util.Scanner;

public class Age {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요:");
		String name = sc.next();
		System.out.print("출생년도를 입력하세요:");
		int age1 = sc.nextInt();
		int age2 = age1 - 1960;
		System.out.println(name + "님의 나이는 " + age2 + "세 입니다.");
		if((age1 % 2) == 0)
		{
			System.out.println("올해 건강검진 대상입니다.");
		}
		else
		{
			System.out.println("올해 건강검진 비대상입니다.");
		}
		
	}
}
