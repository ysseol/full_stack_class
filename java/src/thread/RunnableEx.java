package thread;

public class RunnableEx implements Runnable{
	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName() + "==>" + i);
		}
	}
	
	public static void main(String[] args) {
		RunnableEx e1 = new RunnableEx();
		Thread t1 = new Thread(e1, "thread 1");
		Thread t2 = new Thread(e1, "thread 2");
		t1.start();
		t2.start();
	}
}
