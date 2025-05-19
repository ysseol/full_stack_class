package polym;

public class StaticVar {
	static int a = 10;
	int b = 20;
	public static void main(String[] args) {
		System.out.println(a);
		StaticVar s = new StaticVar();
		System.out.println(s.b);
	}
}
