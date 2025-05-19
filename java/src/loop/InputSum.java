package loop;

import java.util.Scanner;

public class InputSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n을 입력하세요: ");
		int n = sc.nextInt();
		int result1 = 0;
		int result2 = 0;
		long start = System.currentTimeMillis();
		
		for(int i = 1; i < n + 1; i++)
		{
			if(i % 2 == 1)
			{
				result1 = result1 + i;
			}
			else if(i % 2 == 0)
			{
				result2 = result2 + i;
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.println("홀수 합계 : " + result1);
		System.out.println("짝수 합계 : " + result2);
		System.out.println("실행시간 : " + (end - start));
	}
}
