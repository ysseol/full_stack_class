package somepack;

public class Wrapper {
	public static void main(String[] args) {
		Integer i1 = 10;
		int num1 = i1.intValue();
		int num2 = 20;
		int sum = num1 + num2;
		System.out.println(sum);
		System.out.println(Integer.toBinaryString(sum));
		System.out.println(Integer.parseInt("100"));
		System.out.println(Integer.toString(100));
		System.out.println(100 + "");
	}
}
