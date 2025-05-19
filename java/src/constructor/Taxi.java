package constructor;

public class Taxi {
	private int cost;
	private int km;
	
	public Taxi(int km) {
		this.km = km;
	}
	
	public void calc() {
		int m = km * 1000;
		if (m <= 2000) {
			cost = 4800;
		} else {
			int temp = m - 2000;
			cost = 4800 + (int)((temp / 140.0) * 150);
		}
	}
	
	public void print() {
		System.out.println("운행거리:" + km 
				+ ",요금:" + String.format("%,d", cost));
	}
	
	public static void main(String[] args) {
		Taxi t = new Taxi(25);
		t.calc();
		t.print();
	}
}
