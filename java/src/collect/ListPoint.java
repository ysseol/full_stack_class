package collect;

import java.util.ArrayList;
import java.util.List;

public class ListPoint {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	private String grade;
	
	public ListPoint(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	public void calc() {
		tot = kor + eng + mat;
		avg = tot / 3.0;
		if (avg >= 90) {
			grade = "A";
		} else if (avg >= 80) {
			grade = "B";
		} else if (avg >= 70) {
			grade = "C";
		} else if (avg >= 60) {
			grade = "D";
		} else {
			grade = "F";
		}
	}
	
	public void print() {
		System.out.println(name + "\t" + kor + "\t" + eng + "\t" + mat + "\t"
							+ tot +"\t" + String.format("%.2f", avg) + "\t"
							+ grade);
	}
	
	public static void main(String[] args) {
		List<ListPoint> list = new ArrayList<ListPoint>();
		ListPoint p1 = new ListPoint("김철수", 90, 80, 70);
		ListPoint p2 = new ListPoint("김희수", 90, 88, 77);
		ListPoint p3 = new ListPoint("박철수", 99, 83, 72);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t등급");
		System.out.println("======================================================");
		for(int i = 0; i < list.size(); i++) {
			ListPoint p = list.get(i);
			p.calc();
			p.print();
		}
	}
}
