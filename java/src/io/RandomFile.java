package io;

import java.io.RandomAccessFile;

public class RandomFile {
	public static void main(String[] args) {
		StringBuilder output = new StringBuilder();
		String str = null;
		try {
			RandomAccessFile file = new RandomAccessFile("c:/work/test.txt", "rw");
			file.seek(29);
			file.write("추가한 문자열".getBytes());
			file.seek(0);
			while (file.getFilePointer() < file.length()) {
				output.append(file.getFilePointer() + ":");
				str = file.readLine();
				str = new String(str.getBytes("8859_1"), "utf-8");
				output.append(str + "\r\n");
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(output);
	}
}
