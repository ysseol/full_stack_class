package constructor;

import java.util.Scanner;

public class Circle {
	private double r;
	private double length;
	private double area;
	
	public Circle(double r) {
		this.r = r;
	}
	
	public void calc() {
		length = 2 * Math.PI * r;
		area = Math.PI * r * r;
	}
	
	public void print() {
		System.out.println("반지름\t둘레\t넓이");
		System.out.println(r + "\t"
				+ String.format("%.1f", length) + "\t"
				+ String.format("%.1f", area));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("반지름을 입력하세요:");
		double r = sc.nextDouble();
		Circle c = new Circle(r);
		c.calc();
		c.print();
	}
}
