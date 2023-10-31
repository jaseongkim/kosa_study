package 멀티_스레드_14장;

public class SumThread extends Thread {

	private long sum;

	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}

	@Override
	public void run() {

		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
	}

	public static void main(String[] args) {

		SumThread sumThread = new SumThread();

		sumThread.start();
		try {
			sumThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(sumThread.getSum());

	}
}