import java.io.*;
import java.util.*;
public class Shopping {
	static double solve(double[] arr2,double  max, int index) {
		if(max<0)
			return -10000;
		if(index>=arr2.length)
			return 0;
		double use = solve(arr2, max-arr2[index], index+1)+arr2[index];
		double noUse = solve(arr2, max, index+1);
		return Math.max(use, noUse);
		
		
	}
public static void main(String[] args) throws IOException{
	Scanner scan = new Scanner(new File("shopping.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		while(noSets-->0) {
		String[] arr1 = scan.nextLine().split(" ");
		double [] arr2 = new double[arr1.length];
		for(int i = 0; i<arr1.length; i++) {
			arr2[i]= Double.parseDouble(arr1[i]);
		}
		double ans = solve(arr2, 200, 0);
		System.out.printf("%.2f\n",200-ans);
			
			
		}
		
		
		
}
}
