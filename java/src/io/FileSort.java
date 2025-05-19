package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileSort {
	public static void main(String[] args) {
		int[] nums = new int[100];
		
		String f1 = "c:/work/input.txt";
		String f2 = "c:/work/output.txt";
		
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(f1)));
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f2)));
			
			int count = 0;
			String str = "";
			
			while ((str = reader.readLine()) != null) {
				nums[count++] = Integer.parseInt(str);
			}
			
			int temp = 0;
			
			for (int i = 0; i < count; i++) {
				for (int j = i + 1; j < count; j++) {
					if (nums[i] > nums[j]) {
						temp = nums[i];
						nums[i] = nums[j];
						nums[j] = temp;
					}
				}
			}
			
			for (int i = 0; i < count; i++) {
				writer.write(nums[i] + "\r\n");
			}
			
			System.out.println("완료되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
