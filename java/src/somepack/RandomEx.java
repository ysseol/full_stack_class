package somepack;

import java.util.Random;

public class RandomEx {
	public static void main(String[] args) {
		Random r = new Random(10);
		System.out.println(r.nextDouble());
		System.out.println(r.nextInt());
		System.out.println(r.nextInt(100));
		System.out.println(r.nextInt(101) + 100);
		System.out.println(Math.random());
		int num = (int) (Math.random() * 100);
		System.out.println(num);
	}
}
