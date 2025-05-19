package collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bmi {
	private String name;
	private int age;
	private double height;
	private double weight;
	private double bmi;
	private String status;
	
	public Bmi() {
	}
	
	public Bmi(String name, int age, int height, int weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		
		bmi = weight / ((height * height) / 10000);
		
		calc();
	}
	
	public void calc() {
		if (bmi < 18.5) {
			status = "저체중";
		} else if (bmi <= 22.9) {
			status = "정상";
		} else if (bmi <= 24.9) {
			status = "과체중";
		} else {
			status = "비만";
		}
	}
	
	@Override
	public String toString() {
		String str = "이름:" + name + "\n나이:" + age + "\n신장:" + height 
					+ "\n체중:" + weight + "\nBMI:" + bmi + "\n결과:" + status;
		return str;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public static void main(String[] args) {
		Bmi[] members = {new Bmi("kim", 20, 180, 75),
						new Bmi("park", 21, 185, 70),
						new Bmi("hong", 22, 190, 85),
						new Bmi("choi", 23, 160, 60),
						new Bmi("lee", 24, 165, 65)};
		
		Map<String, Bmi> map = new HashMap<>();
		for(Bmi m : members) {
			map.put(m.getName(), m);
		}
		System.out.println(map);
		Scanner scan = new Scanner(System.in);
		System.out.println("이름을 입력하세요:");
		String name = scan.nextLine();
		Bmi result = map.get(name);
		System.out.println(result);
	}
}
