package polym;

public class StaticMethod {
	static int a = 10;
	int b = 20;
	
	public static void printA() {
		System.out.println(a);
		StaticMethod s = new StaticMethod();
		System.out.println(s.b);
	}
	
	public void printB() {
		System.out.println(a);
		System.out.println(b);
	}
	
	public static void main(String[] args) {
		printA();
		StaticMethod a = new StaticMethod();
		a.printB();
	}
}
