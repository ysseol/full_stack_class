package array;

public class Bmi {
	public static void main(String[] args) {
		double[] weight = {70.1, 75.2, 60.3, 65.4, 55.5};
		double[] height = {170.1, 175.2, 160.3, 165.4, 155.5};
		double[] bmi = new double[5];
		String[] result = new String[5];
		for(int i = 0; i < weight.length; i++) {
			height[i] = height[i] / 100;
			bmi[i] = weight[i] / (height[i] * height[i]);
			if(bmi[i] < 18.5) {
				result[i] = "저체중";
			} else if(bmi[i] >= 18.5 && bmi[i] < 23) {
				result[i] = "정상";
			} else if(bmi[i] >= 23 && bmi[i] < 25) {
				result[i] = "과체중";
			} else if(bmi[i] >= 25) {
				result[i] = "비만";
			}
		}
		System.out.println("신장\t체중\tbmi\t결과");
		for (int i = 0; i <weight.length; i++) {
			System.out.println(
					height[i] * 100 
					+ "\t" + weight[i]
					+ "\t" + String.format("%.2f", bmi[i])
					+ "\t" + result[i]);
		}
		
	}
}
