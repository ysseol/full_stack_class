package io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MultiTable {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("단을 입력하세요:");
		int dan = scan.nextInt();
		BufferedWriter writer = null;
		String file = "c:/work/gugu.txt";
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
			for (int i = 1; i <= 9; i++) {
				writer.write(dan + "x" + i + "=" + dan * i + "\n");
			}
			System.out.println("완료되었습니다.");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
