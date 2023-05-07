
public class AppointmentBook {

	public int findFreeBlock(int period, int duration) {
		for(int i = 0; i<=60-duration; i++) {
			boolean free = true;
			for(int j = i; j<duration+i; j++) {
				if(!isMinuteFree(period,j))
					free = false;
				if(free)
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
