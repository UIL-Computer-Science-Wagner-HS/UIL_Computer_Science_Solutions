
import java.io.*;
import java.util.*;
public class Terry {
	
	static double solve(int[] probs, int[] vals, int goal, int index ) {
		if(index>=vals.length&&goal>0)
			return -1000;
		if(goal<=0)
			return 1;
		
		
		double use = (1-1.0*probs[index]/100)*solve(probs, vals, goal-vals[index], index+1);
		double noUse = solve(probs, vals, goal, index+1);
		return Math.max(use, noUse);
		
		
	}
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("terry.dat"));
		int noSets = scan.nextInt();
		while(noSets-->0) {
			int items = scan.nextInt();
			int goal = scan.nextInt();
			int[] probs = new int[items];
			int[] vals = new int[items];
			for(int i = 0; i<items; i++) {
				vals[i]= scan.nextInt();
				probs[i]= scan.nextInt();
				
				
			}
			double ans = solve(probs, vals, goal, 0);
			System.out.printf("%.6f\n",(1.0-ans)*100);
			
			
			
			
			
			
		}
				
	}

}
