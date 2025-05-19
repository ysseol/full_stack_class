package condition;

import java.util.Scanner;

public class Temperature {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("섭씨 온도를 입력하세요 : ");
		double input = sc.nextDouble();
		double result = (input * 1.8) + 32;
		System.out.println("화씨 온도 : " + result);
		
		System.out.print("화씨 온도를 입력하세요 : ");
		input = sc.nextDouble();
		result =(input - 32) / 1.8;
		System.out.println("섭씨 온도 : " + result);
	}
}
