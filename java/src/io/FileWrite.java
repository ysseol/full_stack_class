package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileWrite {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("c:/work/test.txt");
			System.out.println("Input:");
			while (true) {
				int ch = System.in.read();
				System.out.println(ch + "==>" + (char) ch);
				if (ch == 13)
					break;
				os.write(ch);
			}
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (os != null)
					os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
