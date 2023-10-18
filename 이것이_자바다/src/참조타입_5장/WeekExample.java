package 참조타입_5장;

import java.util.Calendar;

public class WeekExample {

	public static void main(String[] args) {
		
		Week today = null;
		
		Calendar now = Calendar.getInstance();
		
		int num = now.get(Calendar.DAY_OF_WEEK);
	
		if(num == 2) {
			today = Week.MONDAY;
		} else if(num == 3) {
			today = Week.TUSEDAY;
		} else if(num == 4) {
			today = Week.WEDNESDAY;
		} else if(num == 5) {
			today = Week.THURSDAY;
		} else if(num == 6) {
			today = Week.FRIDAY;
		} else if(num == 7) {
			today = Week.SATURDAY;
		} else if(num == 1) {
			today = Week.SUNDAY;
		}
		
		if(today == Week.WEDNESDAY) {
			System.out.println("스터디 2일차");
		}
		
		
	}
}