package array;

public class MultiTable {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("단을 입력하세요.");
			System.exit(0);
		}
		int dan = Integer.parseInt(args[0]);
		for (int i = 1; i <= 9; i++) {
			System.out.println(dan + "x" + i + "=" + dan * i);
		}
	}
}
