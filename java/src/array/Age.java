package array;

public class Age {
	public static void main(String[] args) {
		String[] names = {"김철수", "박희영", "홍찬수"};
		int[] years = {1990, 1995, 2000};
		int[] ages = new int[3];
		for (int i = 0; i < names.length; i++) {
			ages[i] = 2025 - years[i];
		}
		
		System.out.println("이름\t연도\t나이");
		System.out.println("=========================");
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i] 
					+ "\t" + years[i]
					+ "\t" + ages[i]);
		}
	}
}
