package except;

public class TryEx {
	public static void main(String[] args) {
		int[] nums = {10, 20, 30, 40, 50};
		try {
			for (int i = 0; i <= nums.length; i++) {
				System.out.println(nums[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		System.out.println("종료");
	}
}
