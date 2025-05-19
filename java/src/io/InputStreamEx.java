package io;

import java.io.IOException;

public class InputStreamEx {
	public static void main(String[] args) {
		int a = 0;
		try {
			System.out.println("Input:");

			a = System.in.read();
			while (a != 13) {
				System.out.println(a + "=" + (char) a);
				a = System.in.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}