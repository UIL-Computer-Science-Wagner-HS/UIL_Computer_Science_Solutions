import java.io.*;
import java.util.*;

public class Elevator {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("elevator.dat"));
		int elevator_count = scan.nextInt();
		scan.nextLine();
		int max_limit = 2000;
		
		
		while (elevator_count-- > 0) {
			int current_weight = 0;
			int person = 0;
			String arr [] = scan.nextLine().split(" ");
			for (int i = 0; i < arr.length; i++) {
				if (((Integer.parseInt(arr[i])+ current_weight) < max_limit)) {
					current_weight += Integer.parseInt(arr[i]);
					person++;
				}
				else {
					break;
				}
			}
			System.out.println(person);
		}
	}
}
