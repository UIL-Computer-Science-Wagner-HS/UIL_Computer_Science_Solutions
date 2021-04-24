import java.util.*;
import java.io.*;
public class Knap1 {
	
	static int solve(int[] weights, int[] values, int max, int index){
		if(max<0)
			return -1000;
		if(max==0||index>=weights.length)
			return 0;
		
		int used = solve(weights, values, max-weights[index], index+1)+values[index];
		int notUsed = solve(weights, values, max, index+1); 
		return Math.max(used, notUsed);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("knap.dat"));
		int max = scan.nextInt();
		scan.nextLine();
		String[] arr1 = scan.nextLine().split(" ");
		String[] arr2 = scan.nextLine().split(" ");
		int[] weights = new int[arr1.length];
		int[] values = new int[arr1.length];
		for(int i = 0; i<arr1.length; i++){
			weights[i]= Integer.parseInt(arr1[i]);
			values[i]= Integer.parseInt(arr2[i]);
			
		}
		
		int ans = solve(weights,values,max,0);
		System.out.println(ans);
		
	}

}
