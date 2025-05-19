package except;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiException {
	public static void main(String[] args) {
		int num = 50;
		Scanner sc = null;
		try {
			System.out.println("숫자를 입력하세요:");
			sc = new Scanner(System.in);
			int value = sc.nextInt();
			System.out.println((num / value));
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException");
		} catch (InputMismatchException e) {
			System.out.println("InputMismatchException");
		} catch (Exception e) {
			System.out.println("Other Exception");
		} finally {
			if (sc != null)
				sc.close();
		}
		System.out.println("end");
	}
}
