
public class AppointmentBook {

	public int findFreeBlock(int period, int duration) {
		for(int i = 0; i<=60-duration; i++) {
			if(isMinuteFree(period, i))
				return i;
		}
		return -1;
		
	}
	
	public boolean makeAppointment(int startPeriod, int endPeriod, int duration) {
		for(int per = startPeriod, per<=endPeriod, per++) {
			if(findFreeBlock(per,duration)!=-1) {
				reserve(per, findFreeBlock(per, duration),duration);
				return true;
			}
					
		}
		
		return false;
	}
	
	
}
