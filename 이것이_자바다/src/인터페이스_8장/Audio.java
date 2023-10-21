package 인터페이스_8장;

public class Audio implements RemoteControl{

	@Override
	public void turnOn() {
		System.out.println("오디오를 켭니다");
	}

}
