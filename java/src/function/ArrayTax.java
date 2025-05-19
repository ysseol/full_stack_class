package function;

public class ArrayTax {
	static String[] product = {"TV", "냉장고", "세탁기", "탈수기", "정수기"};
	static int[] price = {50, 60, 30, 20, 80};
	static int[] amount = {3, 2, 1, 4, 5};
	static int[] money = new int[5];
	static int[] notax = new int[5];
	static int[] tax = new int[5];
	static String[] a = {"", "", "", "", ""};
	
	public static void main(String[] args) {
		calc();
		print();
	}
	
	static void calc() {
		for (int i = 0; i < product.length; i++) {
			money[i] = price[i] * amount[i];
			notax[i] = (int) (money[i] / 1.1);
			tax[i] = money[i] - notax[i];
		}
	}
	
	static void print() {
		System.out.println("품명\t단가\t수량\t금액\t물품가액\t부가세");
		System.out.println("=============================================");
		for (int i = 0; i < product.length; i++) {
			System.out.println(product[i] + "\t" 
					+ price[i] + "\t"
					+ amount[i] + "\t"
					+ money[i] + "\t"
					+ notax[i] + "\t"
					+ tax[i]);
		}
	}
}
