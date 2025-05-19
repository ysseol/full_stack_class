package oop;

import java.util.Scanner;

public class Days {
	private int year;
	private int month;
	private int days;
	
	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.println("연도:");
		year = scan.nextInt();
		System.out.println("월:");
		month = scan.nextInt();
	}
	
	public void calc() {
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		case 2:
			if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				days = 29;
			} else {
				days = 28;
			}
		}
	}
	
	@Override
	public String toString() {
		return year + "년 " + month + "월은 " + days + "일입니다.";
	}
	
	public static void main(String[] args) {
		Days ex = new Days();
		ex.input();
		ex.calc();
		System.out.println(ex);
	}
}
