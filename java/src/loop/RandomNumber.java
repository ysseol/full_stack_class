package loop;

import java.util.Random;
import java.util.Scanner;

public class RandomNumber {
	public static void main(String[] args) {
		Random r = new Random();
		int com =  r.nextInt(100) + 1;
		Scanner sc = new Scanner(System.in);
		int user = 0;
		int count = 0;
		while(com != user) {
			System.out.print("숫자를 입력하세요:");
			user = sc.nextInt();
			count++;
			if (com > user) {
				System.out.println("더 큰 수를 입력하세요.");
			} else if (com < user) {
				System.out.println("더 작은 수를 입력하세요.");
			}
		}
		System.out.println("맞았습니다.");
		System.out.println(count + "회만에 맞히셨네요^^");
	}
}
