package function;

public class ReturnSum {
	static int sum(int a) {
		int result = 0;
		for (int i = 1; i <= a; i++) {
			result = result + i;
		}
		return result;
	}
	public static void main(String[] args) {
		int n = sum(50);
		System.out.println(n);
		n = sum(100);
		System.out.println(n);
	}
}
