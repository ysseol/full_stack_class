package oop;

public class Rect {
	private int width, height;
	private int area, length;
	
	public int getArea() {
		area = width * height;
		return area;
	}
	
	public int getLength() {
		length = (width + height) * 2;
		return length;
	}
	
	public void setDimensions(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public String toString() {
		return "가로:" + width + ",세로:" + height + "\n" + "사각형의 둘레:" + getLength() + ",넓이:" + getArea();
	}
	
	public static void main(String[] args) {
		Rect rect = new Rect();
		rect.setDimensions(10, 20);
		System.out.println(rect);
	}
}
