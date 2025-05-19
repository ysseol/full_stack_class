package loop;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
	public static void main(String[] args) {
		String[] arr = { "가위", "바위", "보" };
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		while (true) {
			int com = rand.nextInt(3) + 1;
			System.out.println("가위(1), 바위(2), 보(3)를 입력하세요. \n(종료하려면 0을 입력하세요)");
			int user = scan.nextInt();
			String result = "";
			if (user == 0) {
				break;
			} else if (user == 1) {
				switch (com) {
				case 1:
					result = "비겼습니다.";
					break;
				case 2:
					result = "당신이 졌습니다.";
					break;
				case 3:
					result = "당신이 이겼습니다.";
					break;
				}
			} else if (user == 2) {
				switch (com) {
				case 1:
					result = "당신이 이겼습니다.";
					break;
				case 2:
					result = "비겼습니다.";
					break;
				case 3:
					result = "당신이 졌습니다.";
					break;
				}
			} else if (user == 3) {
				switch (com) {
				case 1:
					result = "당신이 졌습니다.";
					break;
				case 2:
					result = "당신이 이겼습니다.";
					break;
				case 3:
					result = "비겼습니다.";
					break;
				}
			}
			System.out.println(arr[user - 1] + "를 내셨습니다.");
			System.out.println("컴퓨터는 " + arr[com - 1] + "를 냈습니다.");
			System.out.println(result);
		}
		System.out.println("프로그램이 종료되었습니다.");
	}
}
