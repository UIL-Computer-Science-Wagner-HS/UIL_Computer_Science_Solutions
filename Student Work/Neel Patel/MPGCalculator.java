import java.io.*;
import java.util.*;



public class MPGCalculator {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("mpgcalc.dat"));
		
		int initial_odometer = scan.nextInt();
		scan.nextLine();
		
		//Data Sets
		ArrayList <String> type = new ArrayList <String>();
		ArrayList <Double> mpg = new ArrayList <Double>();
		ArrayList <Integer> len = new ArrayList <Integer>();
		
		while (scan.hasNext()) {
			String arr[] = scan.nextLine().split(" ");
			//Check if the arbitrary word in in the ArrayList
			if (!type.contains(arr[2])) {
				type.add(arr[2]);
				mpg.add(0.0);
				len.add(0);
			}
			
			//Calculating the MPG
			int current_odometer = Integer.parseInt(arr[0]);
			double gas = Double.parseDouble(arr[1]);
			double avg = (current_odometer - initial_odometer)/gas;
			for (int i = 0; i < type.size(); i++) {
				if (type.get(i).equals(arr[2])) {
					mpg.set(i,mpg.get(i) + avg);
					len.set(i, len.get(i)+1);
				}
			}
			
			
			initial_odometer = current_odometer;
			

		}
		

		//Sorting
		ArrayList<solve> list = new ArrayList<solve>();
		for (int i = 0; i < type.size(); i++) {
			solve solve1= new solve(type.get(i),mpg.get(i),len.get(i));
			list.add(solve1);
			Collections.sort(list, (a,b)-> a.type.compareTo(b.type));
		}
		
		//Printing output
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%-15s %.1f", (list.get(i).getType()), (list.get(i).getMPG()/list.get(i).getLen()));
			System.out.println();
		}
		
		
		
	}

}

class solve{
	String type;
	double mpg;
	int len;
	public solve(String type, Double mpg, Integer len) {
		super();
		this.type = type;
		this.mpg = mpg;
		this.len = len;
	}
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}
	public double getMPG() {
		// TODO Auto-generated method stub
		return mpg;
	}
	public int getLen() {
		// TODO Auto-generated method stub
		return len;
	}
	
}
