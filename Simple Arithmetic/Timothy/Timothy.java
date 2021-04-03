import java.io.*;
import java.util.*;
public class Timothy {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("timothy.dat"));
		int[] nums  = new int[50];
		while(scan.hasNextLine()) {
			while(scan.hasNextInt()) {
				int scanned = scan.nextInt();
				nums[scanned]++;
			}
			scan.nextLine();
		}
		//for(int i = 0; i < nums.length; i++) {
			//System.out.println("Number: " + i + ", Occurunces: " + nums[i]);
		//}
		for(int i = nums.length-1; i >= 0; i--) {
			if(nums[i] != 0) {
				if(nums[i] == 1) {
					System.out.println(i);
				}
				else {
					
					System.out.println(i + " " + (nums[i]-1));
				}
			}
			else {
				
			}
		}
	}

}
