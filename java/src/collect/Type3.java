package collect;

public class Type3<T> {
	
	T t;
	
	public void setT(T t) {
		this.t = t;
	}
	
	public T getT() {
		return t;
	}
	
	public static void main(String[] args) {
		Type3<String> t = new Type3<String>();
		t.setT("100");
		System.out.println(t.getT());
		Type3<Integer> t2 = new Type3<Integer>();
		t2.setT(100);
		System.out.println(t2.getT());
		Type3<Double> t3 = new Type3<Double>();
		t3.setT(100.5);
		System.out.println(t3.getT());
	}
}
