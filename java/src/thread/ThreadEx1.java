package thread;

public class ThreadEx1 extends Thread {
	public ThreadEx1(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 9; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadEx1 e1 = new ThreadEx1("T1");
		ThreadEx1 e2 = new ThreadEx1("T2");
		ThreadEx1 e3 = new ThreadEx1("T3");
		e1.start();
		e2.start();
		e3.start();
	}
}
