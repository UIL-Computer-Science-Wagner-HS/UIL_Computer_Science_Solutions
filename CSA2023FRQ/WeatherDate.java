
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
		int count = 1;
		for(int i = 1; i<temperatures.size(); i++) {
			if(temperatures.get(i-1)==temperatures.get(i)) { 
				count++;
			if(count>longest)
				longest = count;
			}
		
			else  count =1;
			
			return longest;
		}
		
		
		
		return longest;
	}
	
	
}
