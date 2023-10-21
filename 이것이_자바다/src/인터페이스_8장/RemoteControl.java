package 인터페이스_8장;

public interface RemoteControl {
	
	void turnOn();
	
	default void mute() {
		System.out.println("음소거");
	}

}
