import java.util.*;
import java.io.*;

public class elevator {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("elevate"));
		int x = sc.nextInt();
		int max = 2000;
		sc.nextLine();
		while (x-- > 0) {
			String[] arr = sc.nextLine().split(" ");
			int[] arr1 = new int[arr.length];
			int weight = 0;
			int numstu = 0;
			for (int i = 0; i < arr.length; i ++) {
				arr1[i] = Integer.parseInt(arr[i]); 
				weight += arr1[i];
				if (weight <= max) {
					numstu ++;
				}
			}
			System.out.println(numstu);
		} 
	}
}