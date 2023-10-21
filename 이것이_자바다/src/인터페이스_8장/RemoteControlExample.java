package 인터페이스_8장;

public class RemoteControlExample {

	public static void main(String[] args) {
		
		RemoteControl rc = new Television();
		
		rc.turnOn();
		rc.mute();
		
		rc = new Audio();
		
		rc.turnOn();
		rc.mute();
		
	}
	
}
