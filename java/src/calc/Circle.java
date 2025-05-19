package calc;

import java.util.Scanner;

public class Circle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("반지름을 입력하세요:");
		double r = sc.nextDouble();
		double length = 2 * Math.PI * r;
		double area = Math.PI * r * r;
		System.out.println("R:" + r);
		System.out.println("둘레:" + String.format("%5.2f", length));
		System.out.println("넓이:"+String.format("%5.2f", area));
	}
}
