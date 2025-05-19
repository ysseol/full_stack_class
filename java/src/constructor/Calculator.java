package constructor;

public class Calculator {
	private int left;
	private int right;
	public Calculator() {
		
	}
	public Calculator(int left, int right) {
		this.left = left;
		this.right = right;
	}
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}
	public int getRight() {
		return right;
	}
	public void setRight(int right) {
		this.right = right;
	}
	public void sum() {
		System.out.println(left + right);
	}
	public void avg() {
		System.out.println((left + right) / 2);
	}
}
