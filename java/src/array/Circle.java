package array;

public class Circle {
	public static void main(String[] args) {
		double[] r = {10.5, 11.5, 12.5, 13.5, 14.5};
		double[] a = new double[5];
		double[] b = new double[5];
		for(int i = 0; i < r.length; i++) {
			a[i] = Math.PI * r[i] * r[i];
			b[i] = 2 * Math.PI * r[i];
		}
		System.out.println("반지름\t넓이\t둘레");
		System.out.println("=======================");
		for(int i = 0; i < r.length; i++) {
			System.out.println(r[i] + "\t" 
		+ String.format("%.2f", a[i]) + "\t" 
		+ String.format("%.2f", b[i]));
		}
	}
}
