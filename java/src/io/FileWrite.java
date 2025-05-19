package io;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileWrite {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("c:/work/test.txt");
			System.out.println("Input:");
			while (true) {
				int ch = System.in.read();
				System.out.println();
			}
		}
	}
}
