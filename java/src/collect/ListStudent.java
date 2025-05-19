package collect;

import java.util.ArrayList;
import java.util.List;

public class ListStudent {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		
		list.add(new Student("Kim", "Design", 1));
		list.add(new Student("Park", "DB", 2));
		list.add(new Student("Song", "Math", 3));
		
		System.out.println(list);
		
		System.out.println("Name\tMajor\tYear");
		
		for(Student s : list) {
			System.out.println(s.getName() + "\t" + s.getMajor() + "\t" + s.getYear());
		}
		
		for(int i = 0; i < list.size(); i++) {
			Student s = list.get(i);
			System.out.println(s.getName() + "\t" + s.getMajor() + "\t" + s.getYear());
		}
		
	}
}
