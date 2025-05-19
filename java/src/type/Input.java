package type;

import java.util.Scanner;

public class Input {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요:");
		String name = sc.next();
		System.out.println("Name: " + name);
		System.out.print("나이를 입력하세요:");
		int age = sc.nextInt();
		System.out.println("나이: " + age);
		
	}
}
