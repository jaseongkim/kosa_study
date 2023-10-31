package 멀티_스레드_14장;

public class Interrupted {

	static class PrintThread extends Thread {

		@Override
		public void run() {

			while (true) {
				System.out.println("실행중");
				if (Thread.interrupted()) {
					break;
				}
			}

			System.out.println("리소스 정리");
			System.out.println("실행 종료");

		}

	}

	public static void main(String[] args) {

		PrintThread printThread = new PrintThread();

		printThread.start();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		printThread.interrupt();

	}
}