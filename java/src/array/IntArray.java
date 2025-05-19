package array;

public class IntArray {
	public static void main(String[] args) {
		int[] nums = {10, 20, 30, 40, 50};
		
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		for(int n : nums) {
			System.out.println(n);
		}
	}
}
