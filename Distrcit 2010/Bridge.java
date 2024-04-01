/*data
	2 
8 
10 10 
5 25 
40 5 
35 15 
12 23 
30 20 
42 25 
8 30 
10 
42 10 
23 30 
40 5 
2 10 
1 20 
4 30 
6 28 
28 3 
17 8 
35 10 
	*/
import java.io.*;
import java.util.*;

public class Bridge {
	int min;
	int pounds;
	// idea is to store a list of trucks, sort it by time, higher to lower and then pick 
	// the slowest truck left in the list and after that all the slowest trucks within the weight limit for the 
	
	//group of trucks
	public Bridge(int min, int pounds) {
		super();
		this.min = min;
		this.pounds = pounds;
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("bridge.dat"));
		int noSets = scan.nextInt();
		while(noSets-->0) {
			int noTrucks = scan.nextInt();
			List<Bridge> list = new ArrayList<>();
			while(noTrucks-->0) {
				
				int weight= scan.nextInt();
				int speed = scan.nextInt();
				list.add(new Bridge(speed,weight));
			}
			list.sort((a,b)->b.min-a.min);
			//OK we are ready to go.  List sorted by time higher to lower.
			int ans = 0;//total time
			while(list.size()>0) {
				//add the time of the first element of the list
				int index = 0;
				ans+=list.get(index).min;
				// we now have used serialW pounds
				int serialW = list.get(index).pounds;
				list.remove(0);
				// this is a greedy loop to add the slowest trucks within our weight limit				
				while(serialW<=42&&index<list.size()) {
					//can we add truck at index?
					if(serialW+list.get(index).pounds<=42) {
						serialW+=list.get(index).pounds;
						list.remove(index);
						
						
					}
					// if not check the remaining trucks
					else index++;
					//quit this loop when we are at weight or at the end of the list
				}
				
				
			}
			System.out.println(ans);
			
			
			
		}

	}
}
