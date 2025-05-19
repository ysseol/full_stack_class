package constructor;

import java.util.Scanner;

public class Bmi {
	private double height;
	private double weight;
	private double bmi;
	private String grade;
	
	public Bmi(double height, double weight) {
		this.height = height;
		this.weight = weight;
	}
	
	public void calc() {
		bmi = weight / (height * height);
		if (bmi < 18.5) {
			grade = "저체중";
		} else if (bmi < 23) {
			grade= "정상";
		} else if (bmi < 25) {
			grade = "과체중";
		} else {
			grade = "비만";
		}
	}
	
	public void print() {
		System.out.println("신장\t체중\tbmi\t등급");
		System.out.println(height * 100 
				+ "\t" + weight 
				+ "\t" + String.format("%.1f", bmi)
				+ "\t" + grade);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("신장:");
		double height = sc.nextDouble();
		System.out.println("체중:");
		double weight = sc.nextDouble();
		
		Bmi b = new Bmi(height / 100, weight);
		b.calc();
		b.print();		
	}
}
