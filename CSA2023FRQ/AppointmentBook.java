
public class AppointmentBook {

	public int findFreeBlock(int period, int duration) {
		for(int i = 0; i<=60-duration; i++) {
			boolean flag = true;
			for(int j = i; j<i+duration; j++) {
				if(!isMinuteFree(period,j))
					flag = false;
			}
			if(flag)
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
