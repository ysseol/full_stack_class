package oop;

import java.util.Scanner;

public class MultiTable {
	private int start, end;
	
	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.println("시작 단과 끝 단 2개의 정수를 입력하세요:");
		String str = scan.nextLine();
		String[] arr = str.split(" ");
		start = Integer.parseInt(arr[0]);
		end = Integer.parseInt(arr[1]);
	}
	
	public void calc() {
		for (int i = start; i <= end; i++) {
			System.out.println("===" + i + "단===");
			for (int j = 1; j <= 9; j++) {
				System.out.println(i +"x" + j + "=" +i * j);
			}
		}
	}
	
	public static void main(String[] args) {
		MultiTable ex = new MultiTable();
		ex.input();
		ex.calc();
	}
}
