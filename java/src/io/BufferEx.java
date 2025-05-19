package io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferEx {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("input:");
		try {
			String str = br.readLine();
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
