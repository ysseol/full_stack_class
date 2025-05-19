package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataStream {
	public static void main(String[] args) {
		try {
			DataOutputStream dataout = new DataOutputStream(new FileOutputStream("c:/work/test.dat"));
			dataout.writeInt(123);
			dataout.writeChar('A');
			dataout.writeDouble(3.5);
			dataout.close();
			System.out.println("저장되었습니다.");
			
			DataInputStream datain = new DataInputStream(new FileInputStream("c:/work/test.dat"));
			System.out.println(datain.readInt());
			System.out.println(datain.readChar());
			System.out.println(datain.readDouble());
			datain.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
