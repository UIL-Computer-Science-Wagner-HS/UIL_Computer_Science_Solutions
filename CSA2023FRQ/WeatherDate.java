
public class WeatherDate {

	public void cleanData(double lower, double upper) {
		
		for(int i = temperatures.size()-1; i>=0; i--) {
			double temp = temperatures.get(i);
			if(temp<lower || temp >upper)
				temperatures.remove(i);
				
			
		}
	}
	
	public int longestHeatWave(double threshold) {
		int longest = 1;
		int count = 0;
		for(int i = 0; i<temperatures.size(); i++) {
			if(temperatures.get(i)>=threshhold) { 
				count++;
			if(count>longest)
				longest = count;
			}
			if(temperaturs.get(i)<threshhold)
				count =0;
			
			
		}
		
		
		
		return longest;
	}
	
	
}
