package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class FileReplace {
	public static void main(String[] args) {
		String source = "c:/work/input1.txt";
		String target = "c:/work/output1.txt";
		try (
			Scanner scan = new Scanner(System.in);
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(source), "utf-8"));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(target), "utf-8"));
			) {
			System.out.println("찾는 단어를 입력하세요");
			String find = scan.nextLine();
			System.out.println("바꿀 단어를 입력하세요");
			String change = scan.nextLine();
			String str = "";
			while ((str = reader.readLine()) != null) {
				str = str.replace(find, change);
				writer.write(str + "\r\n");
			}
			System.out.println("변경되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
