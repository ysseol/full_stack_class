package function;

public class Bmi {
	static double bmi(double w, double h) {
		return w / (h * h);
	}
	static String grade(double b) {
		String result = "";
		if(b < 18.5) {
			result = "저체중";
		} else if(b <23) {
			result = "정상";
		} else if(b < 25) {
			result = "과체중";
		} else {
			result = "비만";
		}
		return result;
	}
	
	public static void main(String[] args) {
		double weight = 77;
		double height = 180;
		double a = bmi(weight, height / 100);
		String b = grade(a);
		System.out.println(String.format("%.2f", a));
		System.out.println(b);
	}
}
