package oop;

import java.util.Scanner;

public class Money {
	private int inputMoney = 0;
	private int tenThousand = 0;
	private int fiveThousand = 0;
	private int thousand = 0;
	private int fiveHundred = 0;
	private int hundred = 0;
	private int fifty = 0;
	private int ten = 0;
	private int remain = 0;
	
	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("금액을 입력하세요: ");
		inputMoney = scan.nextInt();
		calc();
	}
	
	public void calc() {
		System.out.println("금액 : " + inputMoney + "원");
		tenThousand = inputMoney / 10000;
		fiveThousand = inputMoney % 10000 / 5000;
		thousand = inputMoney % 5000 / 1000;
		fiveHundred = inputMoney % 5000 % 1000 / 500;
		hundred = inputMoney % 5000 % 1000 % 500 / 100;
		fifty = inputMoney % 5000 % 1000 % 500 % 100 / 50;
		ten = inputMoney % 5000 % 1000 % 500 % 100 % 50 / 10;
		remain = inputMoney % 5000 % 1000 % 500 % 100 % 50 % 10;
		System.out.println("10000원 : " + tenThousand);
		System.out.println("5000원 : " + fiveThousand);
		System.out.println("1000원 : " + thousand);
		System.out.println("500원 : " + fiveHundred);
		System.out.println("100원 : " + hundred);
		System.out.println("50원 : " + fifty);
		System.out.println("10원 : " + ten);
		System.out.println("남은 돈 : " + remain);
	}
	
	public static void main(String[] args) {
		Money m = new Money();
		m.input();
	}
}
