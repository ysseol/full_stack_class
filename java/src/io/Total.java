package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Total {
	public static void main(String[] args) {
		BufferedReader reader = null;
		String file = "c:/work/input.txt";
		int sum = 0;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			while (true) {
				String str = reader.readLine();
				if (str == null)
					break;
				int num = Integer.parseInt(str);
				sum = sum + num;
			}
			System.out.println("합계:" + sum);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
