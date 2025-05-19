package function;

public class Temperature {
	static double degree1(double a) {
		return (a - 32) / 1.8;
	}
	static double degree2(double a) {
		return (a * 1.8) + 32;
	}
	
	public static void main(String[] args) {
		double a = 100;
		System.out.println(String.format("%.1f", degree1(a)));
		
		double b = 37.7;
		System.out.println(String.format("%.1f", degree2(b)));
	}
}
