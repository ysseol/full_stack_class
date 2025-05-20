package io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteObject {
	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		MemberDTO m1 = new MemberDTO("kim", 28, "971231-1234567", "1111");
		MemberDTO m2 = new MemberDTO("park", 26, "991231-1234567", "2222");
		MemberDTO m3 = new MemberDTO("hong", 27, "981231-1234567", "3333");
		try {
			oos = new ObjectOutputStream(new FileOutputStream("c:/work/object.dat"));
			oos.writeObject(m1);
			oos.writeObject(m2);
			oos.writeObject(m3);
			System.out.println("객체를 저장했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null)
					oos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
