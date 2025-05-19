package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Point {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	
	public Point(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("c:/work/data.txt")));
		List<Point> items = new ArrayList<>();
		while (true) {
			String str = br.readLine();
			if (str == null)
				break;
			String[] arr = str.split(",");
			String name = arr[0];
			int kor = Integer.parseInt(arr[1]);
			int eng = Integer.parseInt(arr[2]);
			int mat = Integer.parseInt(arr[3]);
			Point p = new Point(name, kor, eng, mat);
			p.setTot(p.getKor() + p.getEng() + p.getMat());
			p.setAvg(p.getTot() / 3.0);
			items.add(p);
		}
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		for (int i = 0; i < items.size(); i++) {
			Point p = items.get(i);
			System.out.println(p.getName() + "\t" + p.getKor() + "\t" + p.getEng() 
			+ "\t" + p.getMat() + "\t" + p.getTot() 
			+ "\t" + String.format("%.2f", p.getAvg()));
		}
	}
}
