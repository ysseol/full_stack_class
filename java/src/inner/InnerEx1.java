package inner;

public class InnerEx1 {
	static int x = 10;
	class Inner {
		int getX() {
			return x;
		}
	}
	public static void main(String[] args) {
		System.out.println(x);
		InnerEx1 e = new InnerEx1();
		InnerEx1.Inner in = e.new Inner();
		System.out.println(in.getX());
	}
}
