import java.io.*;
import java.util.*;
public class Revenge {
	// helper method to reverse elements of the array between left and right inclusive
	static void rev(char[] arr, int left, int right) {
		//char[] nArr = new char[right-left+1];
		for(int i = 0; i<=(right-left)/2; i++) {
			char swap = arr[i+left];
			arr[i+left]= arr[right-i];
			arr[right-i] = swap;
			
			
		}
		
		
	}
	static void sort(char[] arr, int left, int right) {
		if(left<right) {
			rev(arr,left,right);//reverse
		int mid = (left+right+1)/2;  // find midpoint
		sort(arr,left,mid-1);// sort left of the midpoint
		//System.out.println(right);
		sort(arr,mid,right);
		
		
		
		}
	}
	
	
public static void main(String... args) throws IOException {

	Scanner scan = new Scanner(new File("revenge.dat"));
	int noSets = scan.nextInt();
	scan.nextLine();
	while (noSets-- > 0) {
		String str = scan.nextLine();
		char[] arr = str.toCharArray();
		sort(arr, 0, arr.length-1);
		//rev(arr,0,2);
		System.out.println(arr);

	}

}
}
