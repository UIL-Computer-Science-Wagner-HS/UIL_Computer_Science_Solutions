import java.util.*;
public class Fibonacci {
	static int fibRecursive(int n) {
		if(n==1 || n == 2)
			return 1;
		return fibRecursive(n-1)+fibRecursive(n-2);
		
	}
	static int fibMemoization(int n){
		int[] arr = new int[n];
		arr[0]= 1;
		arr[1]= 1;
		for(int i = 2; i<n; i++)
			arr[i]= arr[i-1]+arr[i-2];
		return arr[n-1];
		
		
	}
public static void main(String[] args) {
	System.out.println(fibRecursive(7));
	System.out.println((fibMemoization(7)));
}
}
