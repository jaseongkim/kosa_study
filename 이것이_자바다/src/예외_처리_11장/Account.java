package 예외_처리_11장;

public class Account {
	
	private int balance;
	
	public Account() {
	}
	
	public void deposit(int money) {
		this.balance = money;
	}
	
	public int getBalance() {
		return balance;
	}


	public void withDraw(int money) throws TestExeption {
		if(balance < money) {
			throw new TestExeption("잔고 부족: " + (money-balance) + " 모자람");
		}
		
	}
	
}
