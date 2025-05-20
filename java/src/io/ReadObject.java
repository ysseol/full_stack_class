package io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadObject {
	public static void main(String[] args) {
		
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("c:/work/object.dat"));
			MemberDTO dto1 = (MemberDTO) ois.readObject();
			MemberDTO dto2 = (MemberDTO) ois.readObject();
			MemberDTO dto3 = (MemberDTO) ois.readObject();
			System.out.println(dto1);
			System.out.println(dto2);
			System.out.println(dto3);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null)
					ois.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
