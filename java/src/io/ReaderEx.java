package io;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReaderEx {
	public static void main(String[] args) {
		int var = 0;
		Reader input = new InputStreamReader(System.in);
		
		System.out.println("input:");
		try {
			while (true) {
				var = input.read();
				if (var == 13)
					break;
				System.out.println(var + "==>" + (char) var);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
