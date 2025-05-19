package array;

public class Array2D {
	public static void main(String[] args) {
		int[][] nums = {{10, 20, 30}
					, {40, 50, 60}
					, {70, 80, 90}};
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.println(nums[i][j]);
			}
		}
	}
}
