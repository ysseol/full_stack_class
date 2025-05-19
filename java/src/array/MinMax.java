package array;

public class MinMax {
	public static void main(String[] args) {
		int[] nums = {77, 88, 99, -15, 50, 85, 3, 250};
		int sum = 0;
		int max = nums[0];
		int min = nums[0];
		
		for(int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			if(max < nums[i]) {
				max = nums[i];
			}
			if(min > nums[i]) {
				min = nums[i];
			}
		}
		System.out.println("합계:" + sum);
		System.out.println("최소값:" + min);
		System.out.println("최대값:" + max);
	}
}
