import java.io.*;
import java.util.*;
public class KnapSack {
	static int solve(int[] weights,int[] vals, int  max, int index) {
		if(max<0)
			return -10000;
		if(index>=weights.length)
			return 0;
		int use = solve(weights, vals, max-weights[index], index+1)+vals[index];
		int noUse = solve(weights, vals, max, index+1);
		return Math.max(use, noUse);
	}
public static void main(String[] args) throws IOException{

	int [] weights ={2,45,3,9};
	int [] vals = {2,5,10,7};
	int max = 13;
	int ans = solve(weights, vals, max, 0);
	System.out.println(ans);
	
}

}