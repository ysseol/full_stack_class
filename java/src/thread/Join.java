package thread;

public class Join extends Thread {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " 스레드가 시작되었습니다.");
		Join e = new Join();
		e.setName("background");
		e.start();
		
		try {
			e.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + " 스레드가 종료되었습니다.");
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " 스레드가 시작되었습니다.");
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " 스레드가 종료되었습니다.");
	}
}
