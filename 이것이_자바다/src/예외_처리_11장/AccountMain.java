package 예외_처리_11장;

public class AccountMain {

	public static void main(String[] args) {
		
		Account account = new Account();
		
		account.deposit(10000);
		System.out.println("현재 금액 : "+account.getBalance());
		
		try {
			account.withDraw(30000);
		} catch (TestExeption e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("예외처리 테스트 완료");
		
	}
}